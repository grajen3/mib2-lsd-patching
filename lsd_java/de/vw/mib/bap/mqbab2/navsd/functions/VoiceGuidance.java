/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.VoiceGuidance_SetGet;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.VoiceGuidance_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class VoiceGuidance
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener,
SoundServiceListener,
SystemServiceListener {
    private int lastNavigationVolume = -1;
    private static final int INVALID_NAVIGATION_VOLUME;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] SYSTEM_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$VoiceGuidance_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return this.computeVoiceGuidanceStatus();
    }

    protected VoiceGuidance_Status dequeueBAPEntity() {
        return (VoiceGuidance_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$VoiceGuidance_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$VoiceGuidance_Status = VoiceGuidance.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.VoiceGuidance_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$VoiceGuidance_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 36;
    }

    @Override
    public void process(int n) {
        this.sendVoiceGuidanceStateStatus(this.computeVoiceGuidanceStatus());
    }

    private void sendVoiceGuidanceStateStatus(VoiceGuidance_Status voiceGuidance_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(voiceGuidance_Status, this);
    }

    private boolean isVoiceAnnouncementsOn() {
        int n;
        SoundService soundService = this.getSoundService();
        int n2 = soundService.getVolumeNavi();
        return n2 > (n = soundService.getVolumeNaviMin());
    }

    private void setVoiceAnnouncementsOff() {
        SoundService soundService = this.getSoundService();
        this.lastNavigationVolume = soundService.getVolumeNavi();
        soundService.setSoundVolume(1, soundService.getVolumeNaviMin());
    }

    private void setVoiceAnnouncementsOn() {
        SoundService soundService = this.getSoundService();
        int n = this.lastNavigationVolume == -1 ? soundService.getVolumeNaviMin() - -1 : this.lastNavigationVolume;
        soundService.setSoundVolume(1, n);
    }

    private boolean isNavigationAvailable() {
        NavigationService navigationService = this.getNavigationService();
        return this.getSystemService().getNavigationDomainAvailable() == 1 && navigationService.getNavigationOperationState() == 1 && navigationService.getNavigationStatus() == 0;
    }

    private int getVoiceGuidanceState() {
        int n;
        if (this.isVoiceAnnouncementsOn()) {
            switch (this.getNavigationService().getVoiceGuidanceStatus()) {
                case 1: {
                    n = 1;
                    break;
                }
                case 3: {
                    n = 3;
                    break;
                }
                case 2: {
                    n = 2;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 1;
        }
        return n;
    }

    private VoiceGuidance_Status computeVoiceGuidanceStatus() {
        VoiceGuidance_Status voiceGuidance_Status = this.dequeueBAPEntity();
        voiceGuidance_Status.voiceGuidance_State = this.getVoiceGuidanceState();
        return voiceGuidance_Status;
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
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    private boolean areVoiceGuidanceParametersValid(VoiceGuidance_SetGet voiceGuidance_SetGet) {
        boolean bl;
        switch (voiceGuidance_SetGet.voiceGuidance_State) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        VoiceGuidance_SetGet voiceGuidance_SetGet = (VoiceGuidance_SetGet)bAPEntity;
        if (this.areVoiceGuidanceParametersValid(voiceGuidance_SetGet)) {
            if (this.isNavigationAvailable() && voiceGuidance_SetGet.voiceGuidance_State != this.getVoiceGuidanceState()) {
                switch (voiceGuidance_SetGet.voiceGuidance_State) {
                    case 1: {
                        this.setVoiceAnnouncementsOff();
                        break;
                    }
                    case 0: {
                        if (!this.isVoiceAnnouncementsOn()) {
                            this.setVoiceAnnouncementsOn();
                        }
                        this.getNavigationService().setVoiceGuidanceStatus(0);
                        break;
                    }
                    case 2: {
                        if (!this.isVoiceAnnouncementsOn()) {
                            this.setVoiceAnnouncementsOn();
                        }
                        this.getNavigationService().setVoiceGuidanceStatus(2);
                        break;
                    }
                    case 3: {
                        if (!this.isVoiceAnnouncementsOn()) {
                            this.setVoiceAnnouncementsOn();
                        }
                        this.getNavigationService().setVoiceGuidanceStatus(3);
                        break;
                    }
                    default: {
                        propertyListener.requestError(65, this);
                        break;
                    }
                }
            } else {
                propertyListener.statusProperty(this.computeVoiceGuidanceStatus(), this);
            }
        } else {
            propertyListener.requestError(65, this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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
        NAVIGATION_LISTENER_IDS = new int[]{736, 735, 733};
        SOUND_LISTENER_IDS = new int[]{1525, 1496};
        SYSTEM_LISTENER_IDS = new int[]{1676};
    }
}

