/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.ASGCapabilities;
import de.vw.mib.bap.mqbab2.audiosd.functions.ActiveSource;
import de.vw.mib.bap.mqbab2.audiosd.functions.ActiveSourceName;
import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementEscape;
import de.vw.mib.bap.mqbab2.audiosd.functions.AnnouncementInfo;
import de.vw.mib.bap.mqbab2.audiosd.functions.CommonList;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationHandle;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentVolume;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentVolumeExtended;
import de.vw.mib.bap.mqbab2.audiosd.functions.CustomerDownloadState;
import de.vw.mib.bap.mqbab2.audiosd.functions.DedicatedAudioControl;
import de.vw.mib.bap.mqbab2.audiosd.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbab2.audiosd.functions.FSGSetup;
import de.vw.mib.bap.mqbab2.audiosd.functions.FunctionList;
import de.vw.mib.bap.mqbab2.audiosd.functions.FunctionSynchronisation;
import de.vw.mib.bap.mqbab2.audiosd.functions.GeneralInfoSwitches;
import de.vw.mib.bap.mqbab2.audiosd.functions.GetNextListPos;
import de.vw.mib.bap.mqbab2.audiosd.functions.InfoStates;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowser;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowserControl;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowserFolderLevel;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaFileInfo;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaImportState;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaPath;
import de.vw.mib.bap.mqbab2.audiosd.functions.Mute;
import de.vw.mib.bap.mqbab2.audiosd.functions.OnlineMusicState;
import de.vw.mib.bap.mqbab2.audiosd.functions.PreferredList;
import de.vw.mib.bap.mqbab2.audiosd.functions.RadioTVPresetList;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionList;
import de.vw.mib.bap.mqbab2.audiosd.functions.ReceptionListType;
import de.vw.mib.bap.mqbab2.audiosd.functions.SDSState;
import de.vw.mib.bap.mqbab2.audiosd.functions.SourceList;
import de.vw.mib.bap.mqbab2.audiosd.functions.SourceState;
import de.vw.mib.bap.mqbab2.audiosd.functions.SwitchRadioMedia;
import de.vw.mib.bap.mqbab2.audiosd.functions.SwitchSource;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.audiosd.AudioSDBindingFactory;

public class AudioSDBindingFactoryAll
implements AudioSDBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetup();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewActiveSourceStage() {
        return new ActiveSource();
    }

    @Override
    public BAPStage createNewActiveSourceNameStage() {
        return new ActiveSourceName();
    }

    @Override
    public BAPStage createNewCurrentVolumeStage() {
        return new CurrentVolume();
    }

    @Override
    public BAPStage createNewMuteStage() {
        return new Mute();
    }

    @Override
    public BAPStage createNewSourceStateStage() {
        return new SourceState();
    }

    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfo();
    }

    @Override
    public BAPStage createNewCurrentStationHandleStage() {
        return new CurrentStationHandle();
    }

    @Override
    public BAPStage createNewReceptionListStage() {
        return new ReceptionList();
    }

    @Override
    public BAPStage createNewDedicatedAudioControlStage() {
        return new DedicatedAudioControl();
    }

    @Override
    public BAPStage createNewGeneralInfoSwitchesStage() {
        return new GeneralInfoSwitches();
    }

    @Override
    public BAPStage createNewTpMemoInfoStage() {
        return null;
    }

    @Override
    public BAPStage createNewTpMemoListStage() {
        return null;
    }

    @Override
    public BAPStage createNewAnnouncementInfoStage() {
        return new AnnouncementInfo();
    }

    @Override
    public BAPStage createNewAnnouncementEscapeStage() {
        return new AnnouncementEscape();
    }

    @Override
    public BAPStage createNewInfoStatesStage() {
        return new InfoStates();
    }

    @Override
    public BAPStage createNewReceptionListTypeStage() {
        return new ReceptionListType();
    }

    @Override
    public BAPStage createNewSourceListStage() {
        return new SourceList();
    }

    @Override
    public BAPStage createNewRadioTVPresetListStage() {
        return new RadioTVPresetList();
    }

    @Override
    public BAPStage createNewSwitchSourceStage() {
        return new SwitchSource();
    }

    @Override
    public BAPStage createNewMediaBrowserFolderLevelStage() {
        return new MediaBrowserFolderLevel();
    }

    @Override
    public BAPStage createNewMediaBrowserStage() {
        return new MediaBrowser();
    }

    @Override
    public BAPStage createNewMediaPathStage() {
        return new MediaPath();
    }

    @Override
    public BAPStage createNewMediaBrowserControlStage() {
        return new MediaBrowserControl();
    }

    @Override
    public BAPStage createNewMediaFileInfoStage() {
        return new MediaFileInfo();
    }

    @Override
    public BAPStage createNewPreferredListStage() {
        return new PreferredList();
    }

    @Override
    public BAPStage createNewSDSStateStage() {
        return new SDSState();
    }

    @Override
    public BAPStage createNewFunctionSynchronisationStage() {
        return new FunctionSynchronisation();
    }

    @Override
    public BAPStage createNewASGCapabilitiesStage() {
        return new ASGCapabilities();
    }

    @Override
    public BAPStage createNewGetNextListPosStage() {
        return new GetNextListPos();
    }

    @Override
    public BAPStage createNewSwitchRadioMediaStage() {
        return new SwitchRadioMedia();
    }

    @Override
    public BAPStage createNewMediaImportStateStage() {
        return new MediaImportState();
    }

    @Override
    public BAPStage createNewCurrentVolumeExtendedStage() {
        return new CurrentVolumeExtended();
    }

    @Override
    public BAPStage createNewCustomerDownloadStateStage() {
        return new CustomerDownloadState();
    }

    @Override
    public BAPStage createNewOnlineMusicStateStage() {
        return new OnlineMusicState();
    }

    @Override
    public BAPStage createNewCommonListStage() {
        return new CommonList();
    }
}

