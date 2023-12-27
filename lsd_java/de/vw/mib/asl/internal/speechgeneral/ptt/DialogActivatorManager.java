/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogManager;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.DoublePressKeyAdapter;
import de.vw.mib.asl.api.system.KeyListener;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogSession;
import de.vw.mib.asl.internal.speechgeneral.ptt.SpeechApplicant;
import de.vw.mib.asl.internal.speechgeneral.ptt.StateTracker;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.AbstractDialogActivator;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.MultipleSpeechApplicants;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.StandAloneApplicant;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.UnavailableByFeatureConfig;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.UnavailableByLanguage;
import de.vw.mib.asl.internal.speechgeneral.ptt.activator.UnavailableInitializing;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralLogger;
import de.vw.mib.asl.internal.speechgeneral.utils.SpeechGeneralServiceManager;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.ASLDatapool;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.ServiceReference;

public class DialogActivatorManager
extends DoublePressKeyAdapter
implements ASLDatapoolObserver {
    private final SpeechGeneralLogger logger = new SpeechGeneralLogger("[KeyHandlerManager]: ", 4096);
    private static final String TRACE_PREFIX;
    private static final int TRACE_CLASSIFIER;
    private StateTracker stateTracker;
    private final ConfigurationManager configManager;
    private final ApplicationStateRouter appStateRouter;
    private final SystemEventDispatcher eventDispatcher;
    private SpeechApplicant speechApplicant;
    private final DialogSession dialogSession;
    private final ASLSystemAPI aslSystemAPI;
    private final GenericEvents genericEvents;
    private final AsyncServiceFactory asyncAslServiceFactory;
    private AbstractDialogActivator currentActivator;
    private AbstractDialogActivator bufferedActivator;
    private boolean isKeySessionActive;
    private StandAloneApplicant activatorStandAlone;
    private MultipleSpeechApplicants activatorMultipleApplicants;
    private UnavailableByFeatureConfig activatorUnavailableByFeatureConfig;
    private UnavailableByLanguage activatorUnavailableByLanguageChange;
    private UnavailableByLanguage activatorUnavailableByLanguageSupport;
    private UnavailableInitializing activatorUnavailableInit;
    private Services services;
    private ASLDatapool datapool = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$KeyListener;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;

    public DialogActivatorManager(DialogManager dialogManager, ConfigurationManager configurationManager, ApplicationStateRouter applicationStateRouter, SystemEventDispatcher systemEventDispatcher, DialogStateRouter dialogStateRouter, ASLSystemAPI aSLSystemAPI, GenericEvents genericEvents, AsyncServiceFactory asyncServiceFactory, Services services) {
        super(services);
        this.configManager = configurationManager;
        this.appStateRouter = applicationStateRouter;
        this.eventDispatcher = systemEventDispatcher;
        this.aslSystemAPI = aSLSystemAPI;
        this.services = services;
        this.genericEvents = genericEvents;
        this.asyncAslServiceFactory = asyncServiceFactory;
        this.dialogSession = new DialogSession(dialogManager);
        this.bufferedActivator = null;
        this.isKeySessionActive = false;
    }

    public void start() {
        this.stateTracker = new StateTracker(false, this.appStateRouter.getApplicationState(), this);
        this.speechApplicant = new SpeechApplicant(SpeechGeneralServiceManager.getBundleContext(), this.stateTracker, this.dialogSession);
        this.dialogSession.setApplicant(this.speechApplicant);
        this.speechApplicant.registerService();
        this.initSessionActivators();
        this.updateActivator();
        this.appStateRouter.register(this.stateTracker);
        this.eventDispatcher.createAndSubmitHMIEvent(335228928);
        Object object = this.asyncAslServiceFactory.create(this, new Class[]{class$de$vw$mib$asl$api$system$KeyListener == null ? (class$de$vw$mib$asl$api$system$KeyListener = DialogActivatorManager.class$("de.vw.mib.asl.api.system.KeyListener")) : class$de$vw$mib$asl$api$system$KeyListener});
        this.aslSystemAPI.addKeyListener(15, (KeyListener)object);
        this.addOCUEmergencyCallListener();
    }

    private void addOCUEmergencyCallListener() {
        if (this.getDatapool() != null) {
            this.getDatapool().registerObserver(-763161344, this);
            this.getDatapool().registerObserver(1652, this);
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        if (n == -763161344 && this.getDatapool() != null && this.getDatapool().getInteger(-763161344) == 1) {
            this.dialogSession.cancel();
        }
    }

    private ASLDatapool getDatapool() {
        if (this.datapool == null) {
            ServiceReference serviceReference = this.services.getBundleContext().getServiceReference((class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = DialogActivatorManager.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool).getName());
            Object object = serviceReference != null ? this.services.getBundleContext().getService(serviceReference) : null;
            this.datapool = (ASLDatapool)object;
        }
        return this.datapool;
    }

    private void initSessionActivators() {
        this.activatorStandAlone = new StandAloneApplicant(this.dialogSession, this.services);
        this.activatorMultipleApplicants = new MultipleSpeechApplicants(this.dialogSession, this.services);
        this.activatorUnavailableByFeatureConfig = new UnavailableByFeatureConfig(this.dialogSession, this.configManager, this.eventDispatcher, this.genericEvents, this.services);
        this.activatorUnavailableByLanguageChange = new UnavailableByLanguage(this.dialogSession, this.eventDispatcher, true, this.genericEvents, this.services);
        this.activatorUnavailableByLanguageSupport = new UnavailableByLanguage(this.dialogSession, this.eventDispatcher, false, this.genericEvents, this.services);
        this.activatorUnavailableInit = new UnavailableInitializing(this.dialogSession, this.eventDispatcher, this.genericEvents, this.services);
    }

    public void updateActivator() {
        AbstractDialogActivator abstractDialogActivator = this.stateTracker.getEngineState() == 2 ? this.getDialogActivator() : this.getPopupActivator();
        if (this.logger.isTraceEnabled()) {
            LogMessage logMessage = this.logger.trace();
            logMessage.append("Update activator to ");
            logMessage.append(abstractDialogActivator);
            logMessage.log();
        }
        if (this.isKeySessionActive) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("Key-Session is running ==> delay updating to handler ").log();
            }
            this.bufferedActivator = abstractDialogActivator;
        } else {
            this.currentActivator = abstractDialogActivator;
        }
    }

    private AbstractDialogActivator getDialogActivator() {
        if (this.stateTracker.isMultipleApplicants()) {
            return this.activatorMultipleApplicants;
        }
        return this.activatorStandAlone;
    }

    private AbstractDialogActivator getPopupActivator() {
        switch (this.stateTracker.getEngineState()) {
            case 4: {
                return this.activatorUnavailableByLanguageChange;
            }
            case 3: {
                return this.activatorUnavailableByLanguageSupport;
            }
            case 5: {
                return this.activatorUnavailableByFeatureConfig;
            }
            case 1: {
                return this.activatorUnavailableInit;
            }
        }
        LogMessage logMessage = this.logger.error();
        logMessage.append("Unknown 'unavailable' state. Keep current activator ");
        logMessage.append(this.currentActivator);
        logMessage.log();
        return this.currentActivator;
    }

    private void onKeySessionStarts() {
        this.isKeySessionActive = true;
    }

    private void onKeySessionEnds() {
        if (this.bufferedActivator != null) {
            this.currentActivator = this.bufferedActivator;
            this.bufferedActivator = null;
            if (this.logger.isTraceEnabled()) {
                LogMessage logMessage = this.logger.trace();
                logMessage.append("Updating to delayed activator ");
                logMessage.append(this.currentActivator);
                logMessage.log();
            }
        }
        this.isKeySessionActive = false;
    }

    @Override
    public void onSinglePressed(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onSinglePressed( )").log();
        }
        this.onKeySessionStarts();
        this.currentActivator.onSinglePressed(n);
    }

    @Override
    public void onSingleReleased(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onSingleReleased( )").log();
        }
        this.currentActivator.onSingleReleased(n);
        this.onKeySessionEnds();
    }

    @Override
    public void onLongPressed(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onLongPressed( )").log();
        }
        this.currentActivator.onLongPressed(n);
    }

    @Override
    public void onLongReleased(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onLongReleased( )").log();
        }
        this.currentActivator.onLongReleased(n);
        this.onKeySessionEnds();
    }

    @Override
    public void onDoublePressed(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onDoublePressed( )").log();
        }
        this.currentActivator.onDoublePressed(n);
        this.onKeySessionEnds();
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace().append("onUltraLongPressed( )").log();
        }
        this.currentActivator.onUltraLongPressed(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

