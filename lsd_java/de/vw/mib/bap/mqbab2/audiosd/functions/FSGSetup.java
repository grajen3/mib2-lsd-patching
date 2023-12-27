/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_ReceptionList_AutoUpdate;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_Status;

public class FSGSetup
extends Function
implements Property,
ASLAudioSDConstants,
SoundServiceListener,
SystemServiceListener {
    private boolean dabDoubleTunerPresent;
    private boolean navigationPresent;
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{335};
    protected static final int[] SOUND_LISTENER_IDS = new int[]{1522};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FSG_Setup_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        ConfigurationService configurationService = this.getConfigurationService();
        this.dabDoubleTunerPresent = configurationService.isBAPTunerDABDoubleTunerAvailable();
        this.navigationPresent = configurationService.isNavigationFeatureSelected();
        return this.computeFSGSetupStatus();
    }

    protected final FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FSG_Setup_Status = FSGSetup.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FSG_Setup_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 14;
    }

    private void sendFsgSetupStatus(FSG_Setup_Status fSG_Setup_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this);
    }

    protected void setReceptionListAutoUpdateFlags(FSG_Setup_ReceptionList_AutoUpdate fSG_Setup_ReceptionList_AutoUpdate) {
        fSG_Setup_ReceptionList_AutoUpdate.fmReceptionListIsAutomaticallyUpdated = true;
        fSG_Setup_ReceptionList_AutoUpdate.amReceptionListIsAutomaticallyUpdated = false;
        fSG_Setup_ReceptionList_AutoUpdate.dabReceptionListIsAutomaticallyUpdated = this.dabDoubleTunerPresent && this.getSystemService().isDABAvailable();
        fSG_Setup_ReceptionList_AutoUpdate.sdarsReceptionListIsAutomaticallyUpdated = false;
        fSG_Setup_ReceptionList_AutoUpdate.amLwReceptionListIsAutomaticallyUpdated = false;
        fSG_Setup_ReceptionList_AutoUpdate.amSwReceptionListIsAutomaticallyUpdated = false;
        fSG_Setup_ReceptionList_AutoUpdate.tvDvbReceptionListIsAutomaticallyUpdated = this.getConfigurationService().isTvFeatureSelected();
    }

    private void setSupportedVolumeTypeFlags(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.supportedVolumeTypes.entertainmentVolumeAvaiblable = true;
        fSG_Setup_Status.supportedVolumeTypes.navigationVolumeAvailable = this.navigationPresent;
        fSG_Setup_Status.supportedVolumeTypes.announcementVolumeTaVolumeAvailable = true;
        fSG_Setup_Status.supportedVolumeTypes.phoneVolumeAvailable = true;
        fSG_Setup_Status.supportedVolumeTypes.sdsVolumeAvailable = true;
    }

    private void setFsgSetupStatusData(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.maxVolume = this.getSoundService().getVolumeEntertainmentMax();
        this.setSupportedVolumeTypeFlags(fSG_Setup_Status);
        this.setReceptionListAutoUpdateFlags(fSG_Setup_Status.receptionList_AutoUpdate);
        fSG_Setup_Status.setup_Extensions.dabServiceSortedList = this.getBapDABServiceSortedListType();
    }

    private boolean getBapDABServiceSortedListType() {
        return true;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
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
        this.sendFsgSetupStatus(this.computeFSGSetupStatus());
    }

    private FSG_Setup_Status computeFSGSetupStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFsgSetupStatusData(fSG_Setup_Status);
        return fSG_Setup_Status;
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

