/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carlife;

import de.vw.mib.asl.api.smartphoneintegration.ASLSmartphoneIntegrationFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.carlife.CarlifeHSMTarget;
import de.vw.mib.asl.internal.carlife.audio.CarLifeAudiohandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeGlobalProperties;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeHandling;
import de.vw.mib.asl.internal.carlife.common.CarLifeModeParameter;
import de.vw.mib.asl.internal.carlife.common.CarLifeResourceOwner;
import de.vw.mib.asl.internal.carlife.common.CarLifeUserInputHandler;
import de.vw.mib.asl.internal.carlife.common.NoVideoAvailableHandler;
import de.vw.mib.asl.internal.carlife.common.VideoStateHandler;
import de.vw.mib.asl.internal.carlife.speech.SpeechApplicant;
import de.vw.mib.dialogactivation.ActivationState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.timer.Timer;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.carlife.transformer.CarLifeCanvasDimensionCollector;
import org.dsi.ifc.carlife.ServiceConfiguration;

public class ASLHandler
implements VideoStateHandler {
    public final String classname;
    private final CarLifeGlobalProperties properties;
    private final CarlifeHSMTarget target;
    private final SpeechApplicant speechapplicant;
    private final CarLifeAudiohandling audiohandling;
    private final CarLifeModeHandling modehandling;
    private final CarLifeUserInputHandler inputHandler;
    private Timer carLifeNoVideoContentTimer;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;

    public ASLHandler(CarlifeHSMTarget carlifeHSMTarget, CarLifeGlobalProperties carLifeGlobalProperties, SpeechApplicant speechApplicant, CarLifeAudiohandling carLifeAudiohandling, CarLifeModeHandling carLifeModeHandling) {
        this.classname = "ASLHandler";
        Preconditions.checkNotNull(carlifeHSMTarget, "CarlifeHSMTarget must not be null!");
        Preconditions.checkNotNull(carLifeGlobalProperties, "Porperties must not be null!");
        Preconditions.checkNotNull(speechApplicant, "SpeechApplicant must not be null!");
        Preconditions.checkNotNull(carLifeAudiohandling, "AudioHandling must not be null!");
        Preconditions.checkNotNull(carLifeModeHandling, "ModeHandling must not be null!");
        this.target = carlifeHSMTarget;
        this.properties = carLifeGlobalProperties;
        this.speechapplicant = speechApplicant;
        this.audiohandling = carLifeAudiohandling;
        this.modehandling = carLifeModeHandling;
        this.inputHandler = new CarLifeUserInputHandler(carlifeHSMTarget, carLifeGlobalProperties);
    }

    public void handleAslApiEnterCarLifeCanvas() {
        this.properties.setCanvasVisible(true);
        this.modehandling.requestVideo(2);
        this.handleVideoAvailable(this.properties.isVideoAvailable());
    }

    public void handleAslApiLeaveCarLifeCanvas() {
        this.properties.setCanvasVisible(false);
        if (this.carLifeNoVideoContentTimer != null && this.carLifeNoVideoContentTimer.isStarted()) {
            this.carLifeNoVideoContentTimer.stop();
        }
        this.modehandling.requestVideo(1);
    }

    public void handleConnectionEstablished() {
        LogMessage logMessage;
        if (this.target.isTraceEnabled()) {
            logMessage = this.target.trace();
            logMessage.append("ASLHandler").append(".").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_ESTABLISHED_CARLIFE").log();
        }
        if (this.properties.getConnectionState() == 0) {
            this.properties.setConnectionState(1);
        } else if (this.properties.getConnectionState() == 2) {
            if (!this.speechapplicant.isRegistered()) {
                if (this.target.isTraceEnabled()) {
                    logMessage = this.target.trace();
                    logMessage.append("ASLHandler").append(".").append(" call speechapplicant.registerService()").log();
                }
                this.speechapplicant.registerService();
            }
            this.properties.setConnectionState(3);
            this.audiohandling.setAudioConnection(170, false);
            this.audiohandling.resetPauseButtonSend();
            this.sendStartService();
        }
    }

    public void handleConnectionStarted() {
        this.modehandling.sendInitialRequest();
    }

    public void handleConnectionStopped() {
        this.properties.setVideoAvailable(false);
        this.properties.setVideoAvailableInSession(false);
        this.properties.setSetModeActive(false);
    }

    public void handleConnectionLost() {
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("ASLHandler").append(".").append("handleAslApiASL_SMARTPHONEINTEGRATION_CONNECTION_LOST_CARLIFE").log();
        }
        if (this.carLifeNoVideoContentTimer != null && this.carLifeNoVideoContentTimer.isStarted()) {
            this.carLifeNoVideoContentTimer.stop();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1265052672);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1332161536);
        if (this.properties.getConnectionState() == 3) {
            this.properties.setConnectionState(2);
        } else if (this.properties.getConnectionState() == 1) {
            this.properties.setConnectionState(0);
        }
        this.audiohandling.handleConnectionLost();
        if (this.speechapplicant.isCarLifeActive()) {
            this.speechapplicant.forceChangeState(ActivationState.INACTIVE);
        }
        if (this.speechapplicant.isRegistered()) {
            this.speechapplicant.unregister();
        }
        if (this.properties.getActiveNavigation() == 2) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1332161536, false);
            this.properties.setActiveNavigation(0);
        }
        this.properties.setVideoAvailable(false);
        this.properties.setVideoAvailableInSession(false);
    }

    public void handleHmiTouchEventGesture(EventGeneric eventGeneric) {
        this.inputHandler.processTouchEventGesture(eventGeneric);
    }

    public void handleHmiSimpleTouchEvent(EventGeneric eventGeneric) {
        this.inputHandler.processSimpleTouchEvent(eventGeneric);
    }

    public void handleHmiRotaryEvent(EventGeneric eventGeneric) {
        this.inputHandler.processRotaryEvent(eventGeneric);
    }

    public void handleHmiMflEvent(EventGeneric eventGeneric) {
        this.inputHandler.processMflEvent(eventGeneric);
    }

    public void sendStartService() {
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            int n = ServiceManager.configManagerDiag.getLayoutCarLifeCanvasDimensionWidth();
            int n2 = ServiceManager.configManagerDiag.getLayoutCarLifeCanvasDimensionHeight();
            ServiceConfiguration serviceConfiguration = new ServiceConfiguration();
            CarLifeResourceOwner carLifeResourceOwner = new CarLifeResourceOwner(1, 1, 1, 1, 0, 0);
            serviceConfiguration.initialResources = CarLifeModeParameter.getResources(carLifeResourceOwner);
            serviceConfiguration.initialAppState = CarLifeModeParameter.getAppStates(carLifeResourceOwner);
            serviceConfiguration.displayResolutionX = n;
            serviceConfiguration.displayResolutionY = n2;
            serviceConfiguration.displayOffsetX = 0;
            serviceConfiguration.displayOffsetY = 0;
            Object[] objectArray = new CarLifeCanvasDimensionCollector[]{new CarLifeCanvasDimensionCollector()};
            objectArray[0].carlife_height = serviceConfiguration.displayResolutionY;
            objectArray[0].carlife_width = serviceConfiguration.displayResolutionX;
            ListManager.getGenericASLList(1315384320).updateList(objectArray);
            serviceConfiguration.displayName = this.properties.getOemIconTitle();
            serviceConfiguration.useRightHandDrive = false;
            if (ServiceManager.configManagerDiag.getDriverSide() == 2) {
                serviceConfiguration.useRightHandDrive = true;
            }
            serviceConfiguration.touchscreenAvailable = true;
            serviceConfiguration.touchscreenResolutionX = n;
            serviceConfiguration.touchscreenResolutionY = n2;
            serviceConfiguration.touchpadAvailable = false;
            serviceConfiguration.touchpadResolutionX = 0;
            serviceConfiguration.touchpadResolutionY = 0;
            serviceConfiguration.startInNightMode = false;
            serviceConfiguration.physicalDisplayHeight = (int)((double)n2 * ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi().getPixelDimensionHeight());
            serviceConfiguration.physicalDisplayWidth = (int)((double)n * ASLSmartphoneIntegrationFactory.getSmartphoneIntegrationApi().getPixelDimensionWidth());
            this.target.getDSICarLife().startService(serviceConfiguration);
            this.properties.getCurrentResourceOwner().update(serviceConfiguration.initialResources, serviceConfiguration.initialAppState);
        } else if (this.target.isTraceEnabled()) {
            this.target.trace("target CarLife ==> starting service not possible right now...");
        }
    }

    public void handleDayNightMode(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("ASLHandler").append(".handle(DAYNIGHT_MODE)").append(" new mode: night mode is ").append(bl).log();
        }
        this.properties.setNightMode(bl);
        if (this.properties.isConnected() && this.properties.isDSIRegistered()) {
            this.target.getDSICarLife().requestNightMode(bl);
        }
    }

    public void handleTaActive() {
        if (this.speechapplicant.isCarLifeActive()) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("ASLHandler").append(".handleTaActive - cancel running siri session to make the TA hearable").log();
            }
            this.speechapplicant.forceChangeState(ActivationState.INACTIVE);
        }
    }

    @Override
    public void handleVideoAvailable(boolean bl) {
        this.properties.setVideoAvailable(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1281829888, bl);
        if (bl) {
            if (this.target.isTraceEnabled()) {
                LogMessage logMessage = this.target.trace();
                logMessage.append("ASLHandler").append(".handleVideoAvailable(videoAvailable=true)").log();
            }
            if (this.carLifeNoVideoContentTimer != null && this.carLifeNoVideoContentTimer.isStarted()) {
                this.carLifeNoVideoContentTimer.stop();
            }
            this.properties.setVideoAvailableInSession(true);
            ServiceManager.aslPropertyManager.valueChangedBoolean(1348938752, false);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1265052672);
        } else if (this.properties.isCanvasVisible()) {
            if (this.carLifeNoVideoContentTimer != null && this.carLifeNoVideoContentTimer.isStarted()) {
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ASLHandler").append(".handleVideoAvailable(videoAvailable=false) - timer already running").log();
                }
            } else {
                ThreadSwitchingTarget threadSwitchingTarget = (ThreadSwitchingTarget)ServiceManager.bundleContext.getService(ServiceManager.bundleContext.getServiceReference((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = ASLHandler.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName()));
                int n = 3000;
                NoVideoAvailableHandler noVideoAvailableHandler = new NoVideoAvailableHandler();
                this.carLifeNoVideoContentTimer = ServiceManager.timerManager.createTimer("carLifeNoVideoContentTimer", 0, false, noVideoAvailableHandler, threadSwitchingTarget);
                if (this.target.isTraceEnabled()) {
                    LogMessage logMessage = this.target.trace();
                    logMessage.append("ASLHandler").append(".handleVideoAvailable(videoAvailable=false) - start timer").log();
                }
                this.carLifeNoVideoContentTimer.start();
            }
        } else if (this.target.isTraceEnabled()) {
            LogMessage logMessage = this.target.trace();
            logMessage.append("ASLHandler").append(".handleVideoAvailable(videoAvailable=false) - canvas not visible").log();
        }
    }

    public void sendRelaunchApp() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1348938752, true);
        this.modehandling.sendRelaunchApp();
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

