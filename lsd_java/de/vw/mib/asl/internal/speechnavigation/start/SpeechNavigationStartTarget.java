/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultControllerRouter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.start.SpeechNavigationStartTarget$1;
import de.vw.mib.asl.internal.speechnavigation.start.SpeechNavigationStartTarget$2;
import de.vw.mib.asl.internal.speechnavigation.start.SpeechNavigationStartTarget$3;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.ContactsBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.DestinationInputBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.DestinationInputJpnBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.GuidanceBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.LastDestinationBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.OnboardPOIsBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.OnlinePOIsBootstrap;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.SUIBootstrap;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechNavigationStartTarget
extends AbstractTarget {
    private ResultControllerRouter routingTable;
    protected SpeechEngineMaster speechEngine;
    protected CioDictionary cioDictionary;
    protected CioDispatcher cioDispatcher;
    private ServiceTrackerCustomizer cioDictionaryTracker = new SpeechNavigationStartTarget$1(this);
    private ServiceTrackerCustomizer cioDispatcherTracker = new SpeechNavigationStartTarget$2(this);
    private ServiceTrackerCustomizer speechEngineTracker = new SpeechNavigationStartTarget$3(this);
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;

    public SpeechNavigationStartTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return 1107695872;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                this.onPowerOn();
                break;
            }
            default: {
                if (this.routingTable == null) break;
                this.routingTable.onEvent(eventGeneric);
            }
        }
    }

    private void onPowerOn() {
        AppLogger.info(this, ".onPowerOn()");
        ServiceTracker serviceTracker = new ServiceTracker(SpeechNavigationStartTarget.getASLServices().getBundleContext(), (class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = SpeechNavigationStartTarget.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName(), this.cioDictionaryTracker);
        serviceTracker.open();
        ServiceTracker serviceTracker2 = new ServiceTracker(SpeechNavigationStartTarget.getASLServices().getBundleContext(), (class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = SpeechNavigationStartTarget.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName(), this.cioDispatcherTracker);
        serviceTracker2.open();
        ServiceTracker serviceTracker3 = new ServiceTracker(SpeechNavigationStartTarget.getASLServices().getBundleContext(), (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechNavigationStartTarget.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), this.speechEngineTracker);
        serviceTracker3.open();
    }

    void bootstrap(SpeechEngineMaster speechEngineMaster) {
        ResultHandler resultHandler = speechEngineMaster.getResultHandler(2);
        this.routingTable = resultHandler.getResultControllerRegistry();
        new ApplicationBootstrap(this, resultHandler, this.cioDictionary, this.cioDispatcher, speechEngineMaster.getTeleprompterManager(), speechEngineMaster.getDialogManager(2)).initialize();
        new GuidanceBootstrap(this, resultHandler).initialize();
        new LastDestinationBootstrap(this, resultHandler).initialize();
        new HomeAddressBootstrap(resultHandler).initialize();
        new ContactsBootstrap(this, resultHandler).initialize();
        new OnboardPOIsBootstrap(this, resultHandler).initialize();
        if (SpeechNavigationStartTarget.getASLServices().getConfigurationManagerDiag().isFeatureFlagSet(125)) {
            new DestinationInputJpnBootstrap(this, resultHandler).initialize();
        } else {
            new DestinationInputBootstrap(this, resultHandler).initialize();
        }
        new OnlinePOIsBootstrap(this, resultHandler, speechEngineMaster).initialize();
        new SUIBootstrap(this, resultHandler).initialize();
    }

    protected void checkServices() {
        if (this.speechEngine == null || this.cioDictionary == null || this.cioDispatcher == null) {
            return;
        }
        this.notifyServiceAvailable();
        this.bootstrap(this.speechEngine);
    }

    private void notifyServiceAvailable() {
        AppLogger.info("The ASL-SpeechNavigation service is ready");
        Framework.fireUIEvent(1443378176);
    }

    static Services getASLServices() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices();
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

