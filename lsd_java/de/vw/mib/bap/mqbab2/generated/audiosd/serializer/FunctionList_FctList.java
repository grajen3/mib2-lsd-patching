/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_FctList
implements BAPEntity {
    public boolean reserved_bit_0;
    public boolean fctGetAllAvailable;
    public boolean fctBap_ConfigAvailable;
    public boolean fctFunctionListAvailable;
    public boolean fctHeartBeatAvailable;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsg_SetupAvailable;
    public boolean fctFsg_OperationStateAvailable;
    public boolean fctActiveSourceAvailable;
    public boolean fctActiveSourceNameAvailable;
    public boolean fctCurrentVolumeAvailable;
    public boolean fctMuteAvailable;
    public boolean fctSourceStateAvailable;
    public boolean fctCurrentStationInfoAvailable;
    public boolean fctCurrentStation_HandleAvailable;
    public boolean fctReceptionListAvailable;
    public boolean fctDedicatedAudioControlAvailable;
    public boolean fctGeneralInfoSwitchesAvailable;
    public boolean fctTpMemoInfoAvailable;
    public boolean fctTpMemoListAvailable;
    public boolean fctAnnouncementInfoAvailable;
    public boolean fctAnnouncementEscapeAvailable;
    public boolean fctInfoStatesAvailable;
    public boolean fctReceptionListTypeAvailable;
    public boolean fctSourceListAvailable;
    public boolean fctRadioTv_PresetListAvailable;
    public boolean fctSwitchSourceAvailable;
    public boolean fctMediaBrowser_FolderLevelAvailable;
    public boolean fctMediaBrowserAvailable;
    public boolean fctMediaPathAvailable;
    public boolean fctMediaBrowserControlAvailable;
    public boolean fctMediaFileInfoAvailable;
    public boolean fctPreferredListAvailable;
    public boolean fctSds_StateAvailable;
    public boolean fctFunctionSynchronisationAvailable;
    public boolean fctAsg_CapabilitiesAvailable;
    public boolean fctGetNextListPosAvailable;
    public boolean fctSwitchRadioMediaAvailable;
    public boolean fctMediaImportStateAvailable;
    public boolean fctCurrentVolumeExtendedAvailable;
    public boolean fctCustomerDownloadStateAvailable;
    public boolean fctOnlineMusic_StateAvailable;
    public boolean fctSiriusAlertListAvailable;
    public boolean fctCurrentStation_Handle2Available;
    public boolean fctPlayPositionAvailable;
    public boolean fctSds_RecognizerStateAvailable;
    public boolean fctCurrentStationInfo2Available;
    public boolean fctLast_ActiveSourceAvailable;
    public boolean fctLastStationListAvailable;
    private static final int RESERVED_BIT_57__63_BITSIZE;

    public FunctionList_FctList() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_FctList(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctGetAllAvailable = false;
        this.fctBap_ConfigAvailable = false;
        this.fctFunctionListAvailable = false;
        this.fctHeartBeatAvailable = false;
        this.fctFsg_SetupAvailable = false;
        this.fctFsg_OperationStateAvailable = false;
        this.fctActiveSourceAvailable = false;
        this.fctActiveSourceNameAvailable = false;
        this.fctCurrentVolumeAvailable = false;
        this.fctMuteAvailable = false;
        this.fctSourceStateAvailable = false;
        this.fctCurrentStationInfoAvailable = false;
        this.fctCurrentStation_HandleAvailable = false;
        this.fctReceptionListAvailable = false;
        this.fctDedicatedAudioControlAvailable = false;
        this.fctGeneralInfoSwitchesAvailable = false;
        this.fctTpMemoInfoAvailable = false;
        this.fctTpMemoListAvailable = false;
        this.fctAnnouncementInfoAvailable = false;
        this.fctAnnouncementEscapeAvailable = false;
        this.fctInfoStatesAvailable = false;
        this.fctReceptionListTypeAvailable = false;
        this.fctSourceListAvailable = false;
        this.fctRadioTv_PresetListAvailable = false;
        this.fctSwitchSourceAvailable = false;
        this.fctMediaBrowser_FolderLevelAvailable = false;
        this.fctMediaBrowserAvailable = false;
        this.fctMediaPathAvailable = false;
        this.fctMediaBrowserControlAvailable = false;
        this.fctMediaFileInfoAvailable = false;
        this.fctPreferredListAvailable = false;
        this.fctSds_StateAvailable = false;
        this.fctFunctionSynchronisationAvailable = false;
        this.fctAsg_CapabilitiesAvailable = false;
        this.fctGetNextListPosAvailable = false;
        this.fctSwitchRadioMediaAvailable = false;
        this.fctMediaImportStateAvailable = false;
        this.fctCurrentVolumeExtendedAvailable = false;
        this.fctCustomerDownloadStateAvailable = false;
        this.fctOnlineMusic_StateAvailable = false;
        this.fctSiriusAlertListAvailable = false;
        this.fctCurrentStation_Handle2Available = false;
        this.fctPlayPositionAvailable = false;
        this.fctSds_RecognizerStateAvailable = false;
        this.fctCurrentStationInfo2Available = false;
        this.fctLast_ActiveSourceAvailable = false;
        this.fctLastStationListAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_FctList functionList_FctList = (FunctionList_FctList)bAPEntity;
        return this.reserved_bit_0 == functionList_FctList.reserved_bit_0 && this.fctGetAllAvailable == functionList_FctList.fctGetAllAvailable && this.fctBap_ConfigAvailable == functionList_FctList.fctBap_ConfigAvailable && this.fctFunctionListAvailable == functionList_FctList.fctFunctionListAvailable && this.fctHeartBeatAvailable == functionList_FctList.fctHeartBeatAvailable && this.fctFsg_SetupAvailable == functionList_FctList.fctFsg_SetupAvailable && this.fctFsg_OperationStateAvailable == functionList_FctList.fctFsg_OperationStateAvailable && this.fctActiveSourceAvailable == functionList_FctList.fctActiveSourceAvailable && this.fctActiveSourceNameAvailable == functionList_FctList.fctActiveSourceNameAvailable && this.fctCurrentVolumeAvailable == functionList_FctList.fctCurrentVolumeAvailable && this.fctMuteAvailable == functionList_FctList.fctMuteAvailable && this.fctSourceStateAvailable == functionList_FctList.fctSourceStateAvailable && this.fctCurrentStationInfoAvailable == functionList_FctList.fctCurrentStationInfoAvailable && this.fctCurrentStation_HandleAvailable == functionList_FctList.fctCurrentStation_HandleAvailable && this.fctReceptionListAvailable == functionList_FctList.fctReceptionListAvailable && this.fctDedicatedAudioControlAvailable == functionList_FctList.fctDedicatedAudioControlAvailable && this.fctGeneralInfoSwitchesAvailable == functionList_FctList.fctGeneralInfoSwitchesAvailable && this.fctTpMemoInfoAvailable == functionList_FctList.fctTpMemoInfoAvailable && this.fctTpMemoListAvailable == functionList_FctList.fctTpMemoListAvailable && this.fctAnnouncementInfoAvailable == functionList_FctList.fctAnnouncementInfoAvailable && this.fctAnnouncementEscapeAvailable == functionList_FctList.fctAnnouncementEscapeAvailable && this.fctInfoStatesAvailable == functionList_FctList.fctInfoStatesAvailable && this.fctReceptionListTypeAvailable == functionList_FctList.fctReceptionListTypeAvailable && this.fctSourceListAvailable == functionList_FctList.fctSourceListAvailable && this.fctRadioTv_PresetListAvailable == functionList_FctList.fctRadioTv_PresetListAvailable && this.fctSwitchSourceAvailable == functionList_FctList.fctSwitchSourceAvailable && this.fctMediaBrowser_FolderLevelAvailable == functionList_FctList.fctMediaBrowser_FolderLevelAvailable && this.fctMediaBrowserAvailable == functionList_FctList.fctMediaBrowserAvailable && this.fctMediaPathAvailable == functionList_FctList.fctMediaPathAvailable && this.fctMediaBrowserControlAvailable == functionList_FctList.fctMediaBrowserControlAvailable && this.fctMediaFileInfoAvailable == functionList_FctList.fctMediaFileInfoAvailable && this.fctPreferredListAvailable == functionList_FctList.fctPreferredListAvailable && this.fctSds_StateAvailable == functionList_FctList.fctSds_StateAvailable && this.fctFunctionSynchronisationAvailable == functionList_FctList.fctFunctionSynchronisationAvailable && this.fctAsg_CapabilitiesAvailable == functionList_FctList.fctAsg_CapabilitiesAvailable && this.fctGetNextListPosAvailable == functionList_FctList.fctGetNextListPosAvailable && this.fctSwitchRadioMediaAvailable == functionList_FctList.fctSwitchRadioMediaAvailable && this.fctMediaImportStateAvailable == functionList_FctList.fctMediaImportStateAvailable && this.fctCurrentVolumeExtendedAvailable == functionList_FctList.fctCurrentVolumeExtendedAvailable && this.fctCustomerDownloadStateAvailable == functionList_FctList.fctCustomerDownloadStateAvailable && this.fctOnlineMusic_StateAvailable == functionList_FctList.fctOnlineMusic_StateAvailable && this.fctSiriusAlertListAvailable == functionList_FctList.fctSiriusAlertListAvailable && this.fctCurrentStation_Handle2Available == functionList_FctList.fctCurrentStation_Handle2Available && this.fctPlayPositionAvailable == functionList_FctList.fctPlayPositionAvailable && this.fctSds_RecognizerStateAvailable == functionList_FctList.fctSds_RecognizerStateAvailable && this.fctCurrentStationInfo2Available == functionList_FctList.fctCurrentStationInfo2Available && this.fctLast_ActiveSourceAvailable == functionList_FctList.fctLast_ActiveSourceAvailable && this.fctLastStationListAvailable == functionList_FctList.fctLastStationListAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fctGetAllAvailable);
        bitStream.pushBoolean(this.fctBap_ConfigAvailable);
        bitStream.pushBoolean(this.fctFunctionListAvailable);
        bitStream.pushBoolean(this.fctHeartBeatAvailable);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupAvailable);
        bitStream.pushBoolean(this.fctFsg_OperationStateAvailable);
        bitStream.pushBoolean(this.fctActiveSourceAvailable);
        bitStream.pushBoolean(this.fctActiveSourceNameAvailable);
        bitStream.pushBoolean(this.fctCurrentVolumeAvailable);
        bitStream.pushBoolean(this.fctMuteAvailable);
        bitStream.pushBoolean(this.fctSourceStateAvailable);
        bitStream.pushBoolean(this.fctCurrentStationInfoAvailable);
        bitStream.pushBoolean(this.fctCurrentStation_HandleAvailable);
        bitStream.pushBoolean(this.fctReceptionListAvailable);
        bitStream.pushBoolean(this.fctDedicatedAudioControlAvailable);
        bitStream.pushBoolean(this.fctGeneralInfoSwitchesAvailable);
        bitStream.pushBoolean(this.fctTpMemoInfoAvailable);
        bitStream.pushBoolean(this.fctTpMemoListAvailable);
        bitStream.pushBoolean(this.fctAnnouncementInfoAvailable);
        bitStream.pushBoolean(this.fctAnnouncementEscapeAvailable);
        bitStream.pushBoolean(this.fctInfoStatesAvailable);
        bitStream.pushBoolean(this.fctReceptionListTypeAvailable);
        bitStream.pushBoolean(this.fctSourceListAvailable);
        bitStream.pushBoolean(this.fctRadioTv_PresetListAvailable);
        bitStream.pushBoolean(this.fctSwitchSourceAvailable);
        bitStream.pushBoolean(this.fctMediaBrowser_FolderLevelAvailable);
        bitStream.pushBoolean(this.fctMediaBrowserAvailable);
        bitStream.pushBoolean(this.fctMediaPathAvailable);
        bitStream.pushBoolean(this.fctMediaBrowserControlAvailable);
        bitStream.pushBoolean(this.fctMediaFileInfoAvailable);
        bitStream.pushBoolean(this.fctPreferredListAvailable);
        bitStream.pushBoolean(this.fctSds_StateAvailable);
        bitStream.pushBoolean(this.fctFunctionSynchronisationAvailable);
        bitStream.pushBoolean(this.fctAsg_CapabilitiesAvailable);
        bitStream.pushBoolean(this.fctGetNextListPosAvailable);
        bitStream.pushBoolean(this.fctSwitchRadioMediaAvailable);
        bitStream.pushBoolean(this.fctMediaImportStateAvailable);
        bitStream.pushBoolean(this.fctCurrentVolumeExtendedAvailable);
        bitStream.pushBoolean(this.fctCustomerDownloadStateAvailable);
        bitStream.pushBoolean(this.fctOnlineMusic_StateAvailable);
        bitStream.pushBoolean(this.fctSiriusAlertListAvailable);
        bitStream.pushBoolean(this.fctCurrentStation_Handle2Available);
        bitStream.pushBoolean(this.fctPlayPositionAvailable);
        bitStream.pushBoolean(this.fctSds_RecognizerStateAvailable);
        bitStream.pushBoolean(this.fctCurrentStationInfo2Available);
        bitStream.pushBoolean(this.fctLast_ActiveSourceAvailable);
        bitStream.pushBoolean(this.fctLastStationListAvailable);
        bitStream.resetBits(7);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllAvailable = bitStream.popFrontBoolean();
        this.fctBap_ConfigAvailable = bitStream.popFrontBoolean();
        this.fctFunctionListAvailable = bitStream.popFrontBoolean();
        this.fctHeartBeatAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(9);
        this.fctFsg_SetupAvailable = bitStream.popFrontBoolean();
        this.fctFsg_OperationStateAvailable = bitStream.popFrontBoolean();
        this.fctActiveSourceAvailable = bitStream.popFrontBoolean();
        this.fctActiveSourceNameAvailable = bitStream.popFrontBoolean();
        this.fctCurrentVolumeAvailable = bitStream.popFrontBoolean();
        this.fctMuteAvailable = bitStream.popFrontBoolean();
        this.fctSourceStateAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStationInfoAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStation_HandleAvailable = bitStream.popFrontBoolean();
        this.fctReceptionListAvailable = bitStream.popFrontBoolean();
        this.fctDedicatedAudioControlAvailable = bitStream.popFrontBoolean();
        this.fctGeneralInfoSwitchesAvailable = bitStream.popFrontBoolean();
        this.fctTpMemoInfoAvailable = bitStream.popFrontBoolean();
        this.fctTpMemoListAvailable = bitStream.popFrontBoolean();
        this.fctAnnouncementInfoAvailable = bitStream.popFrontBoolean();
        this.fctAnnouncementEscapeAvailable = bitStream.popFrontBoolean();
        this.fctInfoStatesAvailable = bitStream.popFrontBoolean();
        this.fctReceptionListTypeAvailable = bitStream.popFrontBoolean();
        this.fctSourceListAvailable = bitStream.popFrontBoolean();
        this.fctRadioTv_PresetListAvailable = bitStream.popFrontBoolean();
        this.fctSwitchSourceAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowser_FolderLevelAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowserAvailable = bitStream.popFrontBoolean();
        this.fctMediaPathAvailable = bitStream.popFrontBoolean();
        this.fctMediaBrowserControlAvailable = bitStream.popFrontBoolean();
        this.fctMediaFileInfoAvailable = bitStream.popFrontBoolean();
        this.fctPreferredListAvailable = bitStream.popFrontBoolean();
        this.fctSds_StateAvailable = bitStream.popFrontBoolean();
        this.fctFunctionSynchronisationAvailable = bitStream.popFrontBoolean();
        this.fctAsg_CapabilitiesAvailable = bitStream.popFrontBoolean();
        this.fctGetNextListPosAvailable = bitStream.popFrontBoolean();
        this.fctSwitchRadioMediaAvailable = bitStream.popFrontBoolean();
        this.fctMediaImportStateAvailable = bitStream.popFrontBoolean();
        this.fctCurrentVolumeExtendedAvailable = bitStream.popFrontBoolean();
        this.fctCustomerDownloadStateAvailable = bitStream.popFrontBoolean();
        this.fctOnlineMusic_StateAvailable = bitStream.popFrontBoolean();
        this.fctSiriusAlertListAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStation_Handle2Available = bitStream.popFrontBoolean();
        this.fctPlayPositionAvailable = bitStream.popFrontBoolean();
        this.fctSds_RecognizerStateAvailable = bitStream.popFrontBoolean();
        this.fctCurrentStationInfo2Available = bitStream.popFrontBoolean();
        this.fctLast_ActiveSourceAvailable = bitStream.popFrontBoolean();
        this.fctLastStationListAvailable = bitStream.popFrontBoolean();
        bitStream.discardBits(7);
    }
}

