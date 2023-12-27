/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SDS_State_Status;

public final class SDSState
extends Function
implements TimerNotifier,
Property,
ASLAudioSDConstants,
SystemServiceListener,
SpeechServiceListener,
ConfigurationServiceListener {
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_RESTORE_CURRENT_SDS_STATE;
    protected static final int[] SPEECH_LISTENER_IDS;
    protected static final int[] SPEECH_LISTENER_HMI_EVENT_IDS;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] CONFIGURATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SDS_State_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSpeechService().addSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getSpeechService().addHMIEventListener(this, SPEECH_LISTENER_HMI_EVENT_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getConfigurationService().addConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 2000);
        SDS_State_Status sDS_State_Status = null;
        if (this.getConfigurationService().isSpeechStartupFeatureSelected()) {
            sDS_State_Status = this.computeSDSStateStatus();
        }
        return sDS_State_Status;
    }

    protected SDS_State_Status dequeueBAPEntity() {
        return (SDS_State_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SDS_State_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SDS_State_Status = SDSState.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SDS_State_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SDS_State_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 41;
    }

    private void setSDSStateStatus(SDS_State_Status sDS_State_Status) {
        ConfigurationService configurationService = this.getConfigurationService();
        SpeechService speechService = this.getSpeechService();
        sDS_State_Status.state = configurationService.isSpeechFeatureBuiltIn() && !configurationService.isExboxFeatureSelected() ? (!configurationService.isSpeechCoded() ? 0 : (configurationService.isSpeechFeatureBuiltIn() && configurationService.isSpeechCoded() && !configurationService.isSpeechFeatureSWAPSelected() || configurationService.isSpeechFeatureSelected() && (speechService.getSpeechApplicationState() == 0 || speechService.getSpeechApplicationState() == 1) ? 1 : (speechService.getSpeechApplicationState() == 3 ? 9 : (speechService.getSpeechApplicationState() == 4 ? 10 : (speechService.getIndicatorState() == 2 && speechService.isSpeechActive() ? 3 : (speechService.getIndicatorState() == 3 && speechService.isSpeechActive() ? 4 : (speechService.getIndicatorState() == 5 && speechService.isSpeechActive() ? 5 : (speechService.getIndicatorState() == 4 ? 7 : (speechService.getIndicatorState() == 1 ? 6 : 6))))))))) : 0;
    }

    private void sendSDSStatus(SDS_State_Status sDS_State_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(sDS_State_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getSpeechService().removeSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getSpeechService().removeHMIEventListener(this, SPEECH_LISTENER_HMI_EVENT_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getConfigurationService().removeConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        if (!this.timer.isRunning()) {
            this.sendSDSStatus(this.computeSDSStateStatus());
        }
    }

    private SDS_State_Status computeSDSStateStatus() {
        SDS_State_Status sDS_State_Status = this.dequeueBAPEntity();
        this.setSDSStateStatus(sDS_State_Status);
        return sDS_State_Status;
    }

    protected void pttPressed() {
        if (!this.getConfigurationService().isExboxFeatureSelected()) {
            SDS_State_Status sDS_State_Status = this.computeSDSStateStatus();
            if (sDS_State_Status.state == 1) {
                sDS_State_Status.state = 2;
                this.timer.retrigger(new Integer(1));
            } else if (sDS_State_Status.state == 0) {
                sDS_State_Status.state = 8;
                this.timer.retrigger(new Integer(1));
            }
            this.sendSDSStatus(sDS_State_Status);
        }
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.process(-1);
                break;
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        if (n == 352) {
            this.pttPressed();
        }
    }

    @Override
    public void updateSpeechData(SpeechService speechService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateConfigurationData(ConfigurationService configurationService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SPEECH_LISTENER_IDS = new int[]{-402456448, -385679232, -368902016};
        SPEECH_LISTENER_HMI_EVENT_IDS = new int[]{352};
        SYSTEM_LISTENER_IDS = new int[]{1691};
        CONFIGURATION_LISTENER_IDS = new int[]{-1067646848};
    }
}

