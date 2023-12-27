/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSource_ListAvailable;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSource_ListAvailable2;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveSource_Status
implements StatusProperty {
    public int sourceType;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_BAIDU_LINK_DF4_4;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_GOOGLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_MIRROR_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_APPLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_COMMON_LIST_DF4_2;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1;
    public static final int SOURCE_TYPE_HDMI_DF4_1;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO_TV;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER;
    public static final int SOURCE_TYPE_BLUE_RAY;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE;
    public static final int SOURCE_TYPE_DVB_AUDIO_SERVICE;
    public static final int SOURCE_TYPE_DVB_VIDEO_SERVICE;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM;
    public static final int SOURCE_TYPE_JUKEBOX;
    public static final int SOURCE_TYPE_USB;
    public static final int SOURCE_TYPE_DVD_CHANGER;
    public static final int SOURCE_TYPE_AM_TI_JAPAN;
    public static final int SOURCE_TYPE_GENERIC_PLAYER;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO;
    public static final int SOURCE_TYPE_AUX_IN_AUDIO;
    public static final int SOURCE_TYPE_TP_MEMO_TIM;
    public static final int SOURCE_TYPE_SD;
    public static final int SOURCE_TYPE_HDD;
    public static final int SOURCE_TYPE_TV;
    public static final int SOURCE_TYPE_DVD;
    public static final int SOURCE_TYPE_CD_CHANGER;
    public static final int SOURCE_TYPE_CD;
    public static final int SOURCE_TYPE_SDARS_SIRIUS;
    public static final int SOURCE_TYPE_SDARS_XM;
    public static final int SOURCE_TYPE_DAB;
    public static final int SOURCE_TYPE_AM;
    public static final int SOURCE_TYPE_FM;
    public static final int SOURCE_TYPE_NO_SOURCE_ACTIVE;
    public int sourceList_Reference;
    public static final int SOURCE_LIST_REFERENCE_MIN;
    public int typeOfNumber;
    public static final int TYPE_OF_NUMBER_INVALID_NUMBER;
    public static final int TYPE_OF_NUMBER_CD_DVD_BLUE_RAY_ID_CD_NO_FROM_CD_CHANGER_DVD_NO_FROM_DVD_CHANGER_BLUE_RAY_NO_FROM_BLUE_RAY_CHANGER;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_ID;
    public static final int TYPE_OF_NUMBER_AUTO_STORE_BANK_ID;
    public static final int TYPE_OF_NUMBER_PRESET_ID;
    public static final int TYPE_OF_NUMBER_PRESET_BANK_ID;
    public static final int TYPE_OF_NUMBER_ANY_MEANING;
    private static final int TYPE_OF_NUMBER_BITSIZE;
    public ActiveSource_ListAvailable listAvailable = new ActiveSource_ListAvailable();
    public int list_State;
    public static final int LIST_STATE_LIST_IS_BEING_UPDATED;
    public static final int LIST_STATE_LIST_COMPLETELY_LOADED;
    public static final int LIST_STATE_LIST_IS_INCOMPLETELY_LOADED;
    public static final int LIST_STATE_LIST_IS_BEING_LOADED;
    public static final int LIST_STATE_UNKNOWN_LIST_STATE;
    private static final int LIST_STATE_BITSIZE;
    public ActiveSource_ListAvailable2 listAvailable2 = new ActiveSource_ListAvailable2();
    public int number;
    public static final int NUMBER_MIN;

    public ActiveSource_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveSource_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceType = 0;
        this.sourceList_Reference = 0;
        this.typeOfNumber = 0;
        this.list_State = 0;
        this.number = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.listAvailable.reset();
        this.listAvailable2.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveSource_Status activeSource_Status = (ActiveSource_Status)bAPEntity;
        return this.sourceType == activeSource_Status.sourceType && this.sourceList_Reference == activeSource_Status.sourceList_Reference && this.typeOfNumber == activeSource_Status.typeOfNumber && this.listAvailable.equalTo(activeSource_Status.listAvailable) && this.list_State == activeSource_Status.list_State && this.listAvailable2.equalTo(activeSource_Status.listAvailable2) && this.number == activeSource_Status.number;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveSource_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sourceType);
        bitStream.pushShort((short)this.sourceList_Reference);
        bitStream.pushBits(4, this.typeOfNumber);
        this.listAvailable.serialize(bitStream);
        bitStream.pushBits(4, this.list_State);
        this.listAvailable2.serialize(bitStream);
        bitStream.pushByte((byte)this.number);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceType = bitStream.popFrontByte();
        this.sourceList_Reference = bitStream.popFrontShort();
        this.typeOfNumber = bitStream.popFrontBits(4);
        this.listAvailable.deserialize(bitStream);
        this.list_State = bitStream.popFrontBits(4);
        this.listAvailable2.deserialize(bitStream);
        this.number = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return ActiveSource_Status.functionId();
    }
}

