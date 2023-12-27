/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_SupportedVolumeTypes
implements BAPEntity {
    public boolean readMessageVolumeAvailableDf4_1;
    public boolean carParkingFaderAvailableDf4_1;
    public boolean phoneRingingVolumeAvailableDf4_1;
    public boolean sdsVolumeAvailable;
    public boolean phoneVolumeAvailable;
    public boolean announcementVolumeTaVolumeAvailable;
    public boolean navigationVolumeAvailable;
    public boolean entertainmentVolumeAvaiblable;

    public FSG_Setup_SupportedVolumeTypes() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_SupportedVolumeTypes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.readMessageVolumeAvailableDf4_1 = false;
        this.carParkingFaderAvailableDf4_1 = false;
        this.phoneRingingVolumeAvailableDf4_1 = false;
        this.sdsVolumeAvailable = false;
        this.phoneVolumeAvailable = false;
        this.announcementVolumeTaVolumeAvailable = false;
        this.navigationVolumeAvailable = false;
        this.entertainmentVolumeAvaiblable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_SupportedVolumeTypes fSG_Setup_SupportedVolumeTypes = (FSG_Setup_SupportedVolumeTypes)bAPEntity;
        return this.readMessageVolumeAvailableDf4_1 == fSG_Setup_SupportedVolumeTypes.readMessageVolumeAvailableDf4_1 && this.carParkingFaderAvailableDf4_1 == fSG_Setup_SupportedVolumeTypes.carParkingFaderAvailableDf4_1 && this.phoneRingingVolumeAvailableDf4_1 == fSG_Setup_SupportedVolumeTypes.phoneRingingVolumeAvailableDf4_1 && this.sdsVolumeAvailable == fSG_Setup_SupportedVolumeTypes.sdsVolumeAvailable && this.phoneVolumeAvailable == fSG_Setup_SupportedVolumeTypes.phoneVolumeAvailable && this.announcementVolumeTaVolumeAvailable == fSG_Setup_SupportedVolumeTypes.announcementVolumeTaVolumeAvailable && this.navigationVolumeAvailable == fSG_Setup_SupportedVolumeTypes.navigationVolumeAvailable && this.entertainmentVolumeAvaiblable == fSG_Setup_SupportedVolumeTypes.entertainmentVolumeAvaiblable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.readMessageVolumeAvailableDf4_1);
        bitStream.pushBoolean(this.carParkingFaderAvailableDf4_1);
        bitStream.pushBoolean(this.phoneRingingVolumeAvailableDf4_1);
        bitStream.pushBoolean(this.sdsVolumeAvailable);
        bitStream.pushBoolean(this.phoneVolumeAvailable);
        bitStream.pushBoolean(this.announcementVolumeTaVolumeAvailable);
        bitStream.pushBoolean(this.navigationVolumeAvailable);
        bitStream.pushBoolean(this.entertainmentVolumeAvaiblable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.readMessageVolumeAvailableDf4_1 = bitStream.popFrontBoolean();
        this.carParkingFaderAvailableDf4_1 = bitStream.popFrontBoolean();
        this.phoneRingingVolumeAvailableDf4_1 = bitStream.popFrontBoolean();
        this.sdsVolumeAvailable = bitStream.popFrontBoolean();
        this.phoneVolumeAvailable = bitStream.popFrontBoolean();
        this.announcementVolumeTaVolumeAvailable = bitStream.popFrontBoolean();
        this.navigationVolumeAvailable = bitStream.popFrontBoolean();
        this.entertainmentVolumeAvaiblable = bitStream.popFrontBoolean();
    }
}

