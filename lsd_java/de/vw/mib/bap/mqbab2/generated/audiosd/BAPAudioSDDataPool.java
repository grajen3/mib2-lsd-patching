/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.generated.audiosd.AudioSDBindingFactory;

public class BAPAudioSDDataPool
extends AbstractBAPDataPool {
    private AudioSDBindingFactory _factory;

    public BAPAudioSDDataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public AudioSDBindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(AudioSDBindingFactory audioSDBindingFactory) {
        this._factory = audioSDBindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(AudioSDBindingFactory audioSDBindingFactory) {
        this.addStage(audioSDBindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(audioSDBindingFactory.createNewFSGSetupStage(), 3, 1, "FSGSetup");
        this.addStage(audioSDBindingFactory.createNewFSGOperationStateStage(), 3, 1, "FSGOperationState");
        this.addStage(audioSDBindingFactory.createNewActiveSourceStage(), 3, 1, "ActiveSource");
        this.addStage(audioSDBindingFactory.createNewActiveSourceNameStage(), 3, 1, "ActiveSourceName");
        this.addStage(audioSDBindingFactory.createNewCurrentVolumeStage(), 3, 1, "CurrentVolume");
        this.addStage(audioSDBindingFactory.createNewMuteStage(), 0, 1, "Mute");
        this.addStage(audioSDBindingFactory.createNewSourceStateStage(), 3, 1, "SourceState");
        this.addStage(audioSDBindingFactory.createNewCurrentStationInfoStage(), 3, 1, "CurrentStationInfo");
        this.addStage(audioSDBindingFactory.createNewCurrentStationHandleStage(), 3, 1, "CurrentStationHandle");
        this.addStage(audioSDBindingFactory.createNewReceptionListStage(), 3, 2, "ReceptionList");
        this.addStage(audioSDBindingFactory.createNewDedicatedAudioControlStage(), 0, 3, "DedicatedAudioControl");
        this.addStage(audioSDBindingFactory.createNewGeneralInfoSwitchesStage(), 3, 1, "GeneralInfoSwitches");
        this.addStage(audioSDBindingFactory.createNewTpMemoInfoStage(), 3, 1, "TpMemoInfo");
        this.addStage(audioSDBindingFactory.createNewTpMemoListStage(), 3, 2, "TpMemoList");
        this.addStage(audioSDBindingFactory.createNewAnnouncementInfoStage(), 3, 1, "AnnouncementInfo");
        this.addStage(audioSDBindingFactory.createNewAnnouncementEscapeStage(), 0, 3, "AnnouncementEscape");
        this.addStage(audioSDBindingFactory.createNewInfoStatesStage(), 0, 1, "InfoStates");
        this.addStage(audioSDBindingFactory.createNewReceptionListTypeStage(), 0, 1, "ReceptionListType");
        this.addStage(audioSDBindingFactory.createNewSourceListStage(), 3, 2, "SourceList");
        this.addStage(audioSDBindingFactory.createNewRadioTVPresetListStage(), 3, 2, "RadioTVPresetList");
        this.addStage(audioSDBindingFactory.createNewSwitchSourceStage(), 0, 3, "SwitchSource");
        this.addStage(audioSDBindingFactory.createNewMediaBrowserFolderLevelStage(), 3, 1, "MediaBrowserFolderLevel");
        this.addStage(audioSDBindingFactory.createNewMediaBrowserStage(), 3, 2, "MediaBrowser");
        this.addStage(audioSDBindingFactory.createNewMediaPathStage(), 3, 1, "MediaPath");
        this.addStage(audioSDBindingFactory.createNewMediaBrowserControlStage(), 0, 3, "MediaBrowserControl");
        this.addStage(audioSDBindingFactory.createNewMediaFileInfoStage(), 3, 3, "MediaFileInfo");
        this.addStage(audioSDBindingFactory.createNewPreferredListStage(), 0, 1, "PreferredList");
        this.addStage(audioSDBindingFactory.createNewSDSStateStage(), 0, 1, "SDSState");
        this.addStage(audioSDBindingFactory.createNewFunctionSynchronisationStage(), 3, 1, "FunctionSynchronisation");
        this.addStage(audioSDBindingFactory.createNewASGCapabilitiesStage(), 0, 1, "ASGCapabilities");
        this.addStage(audioSDBindingFactory.createNewGetNextListPosStage(), 3, 3, "GetNextListPos");
        this.addStage(audioSDBindingFactory.createNewSwitchRadioMediaStage(), 0, 3, "SwitchRadioMedia");
        this.addStage(audioSDBindingFactory.createNewMediaImportStateStage(), 3, 1, "MediaImportState");
        this.addStage(audioSDBindingFactory.createNewCurrentVolumeExtendedStage(), 3, 1, "CurrentVolumeExtended");
        this.addStage(audioSDBindingFactory.createNewCustomerDownloadStateStage(), 3, 1, "CustomerDownloadState");
        this.addStage(audioSDBindingFactory.createNewOnlineMusicStateStage(), 3, 1, "OnlineMusicState");
        this.addStage(audioSDBindingFactory.createNewCommonListStage(), 3, 2, "CommonList");
    }
}

