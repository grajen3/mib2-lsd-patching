/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FunctionList_FctList;

public final class FunctionList
extends Function
implements Property,
ASLAudioSDConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FunctionList_FctList;

    protected FunctionList_FctList dequeueBAPEntity() {
        return (FunctionList_FctList)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FunctionList_FctList == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FunctionList_FctList = FunctionList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.FunctionList_FctList")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$FunctionList_FctList);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.usedFunctionList();
    }

    private FunctionList_FctList usedFunctionList() {
        FunctionList_FctList functionList_FctList = this.dequeueBAPEntity();
        functionList_FctList.fctGetAllAvailable = false;
        functionList_FctList.fctBap_ConfigAvailable = true;
        functionList_FctList.fctFunctionListAvailable = true;
        functionList_FctList.fctHeartBeatAvailable = true;
        functionList_FctList.fctFsg_SetupAvailable = true;
        functionList_FctList.fctFsg_OperationStateAvailable = true;
        functionList_FctList.fctActiveSourceAvailable = true;
        functionList_FctList.fctActiveSourceNameAvailable = true;
        functionList_FctList.fctCurrentVolumeAvailable = true;
        functionList_FctList.fctMuteAvailable = true;
        functionList_FctList.fctSourceStateAvailable = true;
        functionList_FctList.fctCurrentStationInfoAvailable = true;
        functionList_FctList.fctCurrentStation_HandleAvailable = true;
        functionList_FctList.fctReceptionListAvailable = true;
        functionList_FctList.fctDedicatedAudioControlAvailable = true;
        functionList_FctList.fctGeneralInfoSwitchesAvailable = true;
        functionList_FctList.fctTpMemoInfoAvailable = false;
        functionList_FctList.fctTpMemoListAvailable = false;
        functionList_FctList.fctAnnouncementInfoAvailable = true;
        functionList_FctList.fctAnnouncementEscapeAvailable = true;
        functionList_FctList.fctInfoStatesAvailable = true;
        functionList_FctList.fctReceptionListTypeAvailable = true;
        functionList_FctList.fctSourceListAvailable = true;
        functionList_FctList.fctRadioTv_PresetListAvailable = true;
        functionList_FctList.fctSwitchSourceAvailable = true;
        functionList_FctList.fctMediaBrowser_FolderLevelAvailable = true;
        functionList_FctList.fctMediaBrowserAvailable = true;
        functionList_FctList.fctMediaPathAvailable = true;
        functionList_FctList.fctMediaBrowserControlAvailable = true;
        functionList_FctList.fctMediaFileInfoAvailable = false;
        functionList_FctList.fctPreferredListAvailable = true;
        functionList_FctList.fctSds_StateAvailable = true;
        functionList_FctList.fctFunctionSynchronisationAvailable = false;
        functionList_FctList.fctAsg_CapabilitiesAvailable = true;
        functionList_FctList.fctGetNextListPosAvailable = true;
        functionList_FctList.fctSwitchRadioMediaAvailable = true;
        functionList_FctList.fctMediaImportStateAvailable = true;
        functionList_FctList.fctCurrentVolumeExtendedAvailable = true;
        functionList_FctList.fctCustomerDownloadStateAvailable = true;
        functionList_FctList.fctOnlineMusic_StateAvailable = true;
        functionList_FctList.fctSiriusAlertListAvailable = false;
        return functionList_FctList;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
    }

    @Override
    public void process(int n) {
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

