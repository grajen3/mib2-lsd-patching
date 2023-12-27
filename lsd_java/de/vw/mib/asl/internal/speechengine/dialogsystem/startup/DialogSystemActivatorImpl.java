/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.startup;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.DialogSystemInitializer;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.activity.ActivityManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.AsrAdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler.TtsAdapterHandlerRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrDsiAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrGenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsDsiAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsGenericEventsAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemActivator;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;

public class DialogSystemActivatorImpl
implements DialogSystemActivator {
    private static final String TRACE_PREFIX;
    private final Services aslServices;
    private final SpeechDialogSystem dialogSystem;
    private final DialogSystemInitializer dialogSystemInitializer;
    private final ConfigurationManagerDiag configManager;
    private final ActivityManager activityManager = new ActivityManager();
    private ApplicationStateTracker applicationStateTracker;
    private DialogSystemDiagnosisImpl diagnosis;

    public DialogSystemActivatorImpl() {
        this.aslServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.configManager = this.aslServices.getConfigurationManagerDiag();
        this.dialogSystem = new DialogSystemImpl(this.aslServices, this.activityManager);
        this.dialogSystemInitializer = (DialogSystemInitializer)((Object)this.dialogSystem);
    }

    private void activateDiagnosis(Logger logger, DialogSystemParameter dialogSystemParameter) {
        if (this.diagnosis != null) {
            return;
        }
        this.diagnosis = new DialogSystemDiagnosisImpl(logger);
        this.dialogSystemInitializer.setDiagnosis(this.diagnosis);
        dialogSystemParameter.getSpeechEngineStarter().onDialogDystemDiagnosisReady(this.diagnosis);
    }

    private void activateAppStateTracker(DialogSystemParameter dialogSystemParameter, ConfigurationManager configurationManager, ThreadSwitchingTarget threadSwitchingTarget, ActivityManager activityManager) {
        if (this.applicationStateTracker == null) {
            this.applicationStateTracker = new ApplicationStateTracker(1, this.activityManager, this.dialogSystemInitializer, dialogSystemParameter.getDialogSystemPublisher(), dialogSystemParameter.getLogger(), threadSwitchingTarget, configurationManager);
        }
    }

    @Override
    public void activateTts(DialogSystemParameter dialogSystemParameter, String string, int n) {
        int n2 = 412162048;
        int n3 = 428939264;
        if (n == 1) {
            n2 = 479270912;
            n3 = 496048128;
        }
        this.activateAppStateTracker(dialogSystemParameter, this.configManager, this.aslServices.getASLThreadSwitch(), this.activityManager);
        this.activateDiagnosis(dialogSystemParameter.getLogger(), dialogSystemParameter);
        this.activateTtsInstance(dialogSystemParameter, string, n, n2, n3);
    }

    private void activateTtsInstance(DialogSystemParameter dialogSystemParameter, String string, int n, int n2, int n3) {
        Object object;
        this.dialogSystemInitializer.setParameter(dialogSystemParameter);
        Logger logger = dialogSystemParameter.getLogger();
        GenericEvents genericEvents = dialogSystemParameter.getAslServices().getGenericEvents();
        TtsDsiAdapter ttsDsiAdapter = null;
        TtsGenericEventsAdapter ttsGenericEventsAdapter = null;
        try {
            object = new TtsAdapterHandlerRegistry();
            ttsDsiAdapter = new TtsDsiAdapter(genericEvents, string, logger, (TtsAdapterHandlerRegistry)object, n, n2);
            ttsGenericEventsAdapter = new TtsGenericEventsAdapter(logger, genericEvents, string, n3);
        }
        catch (Exception exception) {
            logger.fatal(8, "[DialogSystemActivator] Exception while creating the adapter for speech output. ", exception);
        }
        object = new TtsController(dialogSystemParameter, this.dialogSystemInitializer, ttsDsiAdapter, ttsGenericEventsAdapter, this.diagnosis, this.activityManager, this.applicationStateTracker);
        ((TtsController)object).start();
    }

    @Override
    public void activateAsr(DialogSystemParameter dialogSystemParameter, String string) {
        Object object;
        this.dialogSystemInitializer.setParameter(dialogSystemParameter);
        Logger logger = dialogSystemParameter.getLogger();
        GenericEvents genericEvents = dialogSystemParameter.getAslServices().getGenericEvents();
        AsrDsiAdapter asrDsiAdapter = null;
        AsrGenericEventsAdapter asrGenericEventsAdapter = null;
        try {
            object = new AsrAdapterHandlerRegistry();
            asrDsiAdapter = new AsrDsiAdapter(genericEvents, string, logger, (AsrAdapterHandlerRegistry)object);
            asrGenericEventsAdapter = new AsrGenericEventsAdapter(logger, genericEvents, string, (AsrAdapterHandlerRegistry)object);
        }
        catch (Exception exception) {
            logger.fatal(8, "[DialogSystemActivator] Exception while creating the adapter for speech input. ", exception);
        }
        this.activateAppStateTracker(dialogSystemParameter, this.configManager, this.aslServices.getASLThreadSwitch(), this.activityManager);
        this.activateDiagnosis(dialogSystemParameter.getLogger(), dialogSystemParameter);
        object = new AsrController(dialogSystemParameter, this.dialogSystemInitializer, asrDsiAdapter, asrGenericEventsAdapter, this.diagnosis, this.configManager, this.activityManager, this.applicationStateTracker);
        ((AsrController)object).start();
    }
}

