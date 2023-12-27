/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionSynchronisation_FctList_1
implements BAPEntity {
    public boolean reserved_bit_0;
    private static final int RESERVED_BIT_1__15_BITSIZE;
    public boolean fctActiveSourceIsToBeSynchronised;
    public boolean fctActiveSourceNameIsToBeSynchronised;
    public boolean fctCurrentVolumeIsToBeSynchronised;
    public boolean fctMuteIsToBeSynchronised;
    public boolean fctSourceStateIsToBeSynchronised;
    public boolean fctCurrentStationInfoIsToBeSynchronised;
    public boolean fctCurrentStation_HandleIsToBeSynchronised;
    public boolean reserved_bit_23;
    public boolean reserved_bit_24;
    public boolean fctGeneralInfoSwitchesIsToBeSynchronised;
    public boolean fctTpMemoInfoIsToBeSynchronised;
    public boolean reserved_bit_27;
    public boolean fctAnnouncementInfoIsToBeSynchronised;
    public boolean reserved_bit_29;
    public boolean fctInfoStatesIsToBeSynchronised;
    public boolean fctReceptionListTypeIsToBeSynchronised;
    public boolean reserved_bit_32;
    public boolean reserved_bit_33;
    public boolean reserved_bit_34;
    public boolean fctMediaBrowser_FolderLevelIsToBeSynchronised;
    public boolean reserved_bit_36;
    public boolean fctMediaPathIsToBeSynchronised;
    public boolean reserved_bit_38;
    public boolean reserved_bit_39;
    public boolean fctPreferredListIsToBeSynchronised;
    public boolean fctSds_StateIsToBeSynchronised;
    public boolean reserved_bit_42;
    public boolean fctAsg_CapabilitiesIsToBeSynchronised;
    public boolean reserved_bit_44;
    public boolean reserved_bit_45;
    public boolean fctMediaImportStateIsToBeSynchronised;
    public boolean fctCurrentVolumeExtendedIsToBeSynchronised;

    public FunctionSynchronisation_FctList_1() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionSynchronisation_FctList_1(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctActiveSourceIsToBeSynchronised = false;
        this.fctActiveSourceNameIsToBeSynchronised = false;
        this.fctCurrentVolumeIsToBeSynchronised = false;
        this.fctMuteIsToBeSynchronised = false;
        this.fctSourceStateIsToBeSynchronised = false;
        this.fctCurrentStationInfoIsToBeSynchronised = false;
        this.fctCurrentStation_HandleIsToBeSynchronised = false;
        this.reserved_bit_23 = false;
        this.reserved_bit_24 = false;
        this.fctGeneralInfoSwitchesIsToBeSynchronised = false;
        this.fctTpMemoInfoIsToBeSynchronised = false;
        this.reserved_bit_27 = false;
        this.fctAnnouncementInfoIsToBeSynchronised = false;
        this.reserved_bit_29 = false;
        this.fctInfoStatesIsToBeSynchronised = false;
        this.fctReceptionListTypeIsToBeSynchronised = false;
        this.reserved_bit_32 = false;
        this.reserved_bit_33 = false;
        this.reserved_bit_34 = false;
        this.fctMediaBrowser_FolderLevelIsToBeSynchronised = false;
        this.reserved_bit_36 = false;
        this.fctMediaPathIsToBeSynchronised = false;
        this.reserved_bit_38 = false;
        this.reserved_bit_39 = false;
        this.fctPreferredListIsToBeSynchronised = false;
        this.fctSds_StateIsToBeSynchronised = false;
        this.reserved_bit_42 = false;
        this.fctAsg_CapabilitiesIsToBeSynchronised = false;
        this.reserved_bit_44 = false;
        this.reserved_bit_45 = false;
        this.fctMediaImportStateIsToBeSynchronised = false;
        this.fctCurrentVolumeExtendedIsToBeSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionSynchronisation_FctList_1 functionSynchronisation_FctList_1 = (FunctionSynchronisation_FctList_1)bAPEntity;
        return this.reserved_bit_0 == functionSynchronisation_FctList_1.reserved_bit_0 && this.fctActiveSourceIsToBeSynchronised == functionSynchronisation_FctList_1.fctActiveSourceIsToBeSynchronised && this.fctActiveSourceNameIsToBeSynchronised == functionSynchronisation_FctList_1.fctActiveSourceNameIsToBeSynchronised && this.fctCurrentVolumeIsToBeSynchronised == functionSynchronisation_FctList_1.fctCurrentVolumeIsToBeSynchronised && this.fctMuteIsToBeSynchronised == functionSynchronisation_FctList_1.fctMuteIsToBeSynchronised && this.fctSourceStateIsToBeSynchronised == functionSynchronisation_FctList_1.fctSourceStateIsToBeSynchronised && this.fctCurrentStationInfoIsToBeSynchronised == functionSynchronisation_FctList_1.fctCurrentStationInfoIsToBeSynchronised && this.fctCurrentStation_HandleIsToBeSynchronised == functionSynchronisation_FctList_1.fctCurrentStation_HandleIsToBeSynchronised && this.reserved_bit_23 == functionSynchronisation_FctList_1.reserved_bit_23 && this.reserved_bit_24 == functionSynchronisation_FctList_1.reserved_bit_24 && this.fctGeneralInfoSwitchesIsToBeSynchronised == functionSynchronisation_FctList_1.fctGeneralInfoSwitchesIsToBeSynchronised && this.fctTpMemoInfoIsToBeSynchronised == functionSynchronisation_FctList_1.fctTpMemoInfoIsToBeSynchronised && this.reserved_bit_27 == functionSynchronisation_FctList_1.reserved_bit_27 && this.fctAnnouncementInfoIsToBeSynchronised == functionSynchronisation_FctList_1.fctAnnouncementInfoIsToBeSynchronised && this.reserved_bit_29 == functionSynchronisation_FctList_1.reserved_bit_29 && this.fctInfoStatesIsToBeSynchronised == functionSynchronisation_FctList_1.fctInfoStatesIsToBeSynchronised && this.fctReceptionListTypeIsToBeSynchronised == functionSynchronisation_FctList_1.fctReceptionListTypeIsToBeSynchronised && this.reserved_bit_32 == functionSynchronisation_FctList_1.reserved_bit_32 && this.reserved_bit_33 == functionSynchronisation_FctList_1.reserved_bit_33 && this.reserved_bit_34 == functionSynchronisation_FctList_1.reserved_bit_34 && this.fctMediaBrowser_FolderLevelIsToBeSynchronised == functionSynchronisation_FctList_1.fctMediaBrowser_FolderLevelIsToBeSynchronised && this.reserved_bit_36 == functionSynchronisation_FctList_1.reserved_bit_36 && this.fctMediaPathIsToBeSynchronised == functionSynchronisation_FctList_1.fctMediaPathIsToBeSynchronised && this.reserved_bit_38 == functionSynchronisation_FctList_1.reserved_bit_38 && this.reserved_bit_39 == functionSynchronisation_FctList_1.reserved_bit_39 && this.fctPreferredListIsToBeSynchronised == functionSynchronisation_FctList_1.fctPreferredListIsToBeSynchronised && this.fctSds_StateIsToBeSynchronised == functionSynchronisation_FctList_1.fctSds_StateIsToBeSynchronised && this.reserved_bit_42 == functionSynchronisation_FctList_1.reserved_bit_42 && this.fctAsg_CapabilitiesIsToBeSynchronised == functionSynchronisation_FctList_1.fctAsg_CapabilitiesIsToBeSynchronised && this.reserved_bit_44 == functionSynchronisation_FctList_1.reserved_bit_44 && this.reserved_bit_45 == functionSynchronisation_FctList_1.reserved_bit_45 && this.fctMediaImportStateIsToBeSynchronised == functionSynchronisation_FctList_1.fctMediaImportStateIsToBeSynchronised && this.fctCurrentVolumeExtendedIsToBeSynchronised == functionSynchronisation_FctList_1.fctCurrentVolumeExtendedIsToBeSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionSynchronisation_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.resetBits(15);
        bitStream.pushBoolean(this.fctActiveSourceIsToBeSynchronised);
        bitStream.pushBoolean(this.fctActiveSourceNameIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentVolumeIsToBeSynchronised);
        bitStream.pushBoolean(this.fctMuteIsToBeSynchronised);
        bitStream.pushBoolean(this.fctSourceStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentStationInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentStation_HandleIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_23);
        bitStream.pushBoolean(this.reserved_bit_24);
        bitStream.pushBoolean(this.fctGeneralInfoSwitchesIsToBeSynchronised);
        bitStream.pushBoolean(this.fctTpMemoInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_27);
        bitStream.pushBoolean(this.fctAnnouncementInfoIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_29);
        bitStream.pushBoolean(this.fctInfoStatesIsToBeSynchronised);
        bitStream.pushBoolean(this.fctReceptionListTypeIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_32);
        bitStream.pushBoolean(this.reserved_bit_33);
        bitStream.pushBoolean(this.reserved_bit_34);
        bitStream.pushBoolean(this.fctMediaBrowser_FolderLevelIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_36);
        bitStream.pushBoolean(this.fctMediaPathIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_38);
        bitStream.pushBoolean(this.reserved_bit_39);
        bitStream.pushBoolean(this.fctPreferredListIsToBeSynchronised);
        bitStream.pushBoolean(this.fctSds_StateIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_42);
        bitStream.pushBoolean(this.fctAsg_CapabilitiesIsToBeSynchronised);
        bitStream.pushBoolean(this.reserved_bit_44);
        bitStream.pushBoolean(this.reserved_bit_45);
        bitStream.pushBoolean(this.fctMediaImportStateIsToBeSynchronised);
        bitStream.pushBoolean(this.fctCurrentVolumeExtendedIsToBeSynchronised);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        bitStream.discardBits(15);
        this.fctActiveSourceIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctActiveSourceNameIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentVolumeIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctMuteIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctSourceStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentStationInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentStation_HandleIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_23 = bitStream.popFrontBoolean();
        this.reserved_bit_24 = bitStream.popFrontBoolean();
        this.fctGeneralInfoSwitchesIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctTpMemoInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_27 = bitStream.popFrontBoolean();
        this.fctAnnouncementInfoIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_29 = bitStream.popFrontBoolean();
        this.fctInfoStatesIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctReceptionListTypeIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_32 = bitStream.popFrontBoolean();
        this.reserved_bit_33 = bitStream.popFrontBoolean();
        this.reserved_bit_34 = bitStream.popFrontBoolean();
        this.fctMediaBrowser_FolderLevelIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_36 = bitStream.popFrontBoolean();
        this.fctMediaPathIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_38 = bitStream.popFrontBoolean();
        this.reserved_bit_39 = bitStream.popFrontBoolean();
        this.fctPreferredListIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctSds_StateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_42 = bitStream.popFrontBoolean();
        this.fctAsg_CapabilitiesIsToBeSynchronised = bitStream.popFrontBoolean();
        this.reserved_bit_44 = bitStream.popFrontBoolean();
        this.reserved_bit_45 = bitStream.popFrontBoolean();
        this.fctMediaImportStateIsToBeSynchronised = bitStream.popFrontBoolean();
        this.fctCurrentVolumeExtendedIsToBeSynchronised = bitStream.popFrontBoolean();
    }
}

