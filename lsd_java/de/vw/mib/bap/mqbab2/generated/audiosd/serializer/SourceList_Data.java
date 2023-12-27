/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Attributes;
import de.vw.mib.bap.stream.BitStream;

public final class SourceList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES_NAME;
    public static final int RECORD_ADDRESS_SOURCE_TYPE_INSTANCE_ID_MEDIA_TYPE_ATTRIBUTES;
    public static final int RECORD_ADDRESS_NAME;
    public static final int RECORD_ADDRESS_ATTRIBUTES;
    public static final int RECORD_ADDRESS_MEDIA_TYPE;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    public static final int SOURCE_TYPE_NO_SOURCE;
    public static final int SOURCE_TYPE_FM;
    public static final int SOURCE_TYPE_AM;
    public static final int SOURCE_TYPE_DAB;
    public static final int SOURCE_TYPE_SDARS_XM;
    public static final int SOURCE_TYPE_SDARS_SIRIUS;
    public static final int SOURCE_TYPE_CD;
    public static final int SOURCE_TYPE_CD_CHANGER;
    public static final int SOURCE_TYPE_DVD;
    public static final int SOURCE_TYPE_TV;
    public static final int SOURCE_TYPE_HDD;
    public static final int SOURCE_TYPE_SD;
    public static final int SOURCE_TYPE_TP_MEMO_TIM;
    public static final int SOURCE_TYPE_AUX_IN_AUDIO;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI;
    public static final int SOURCE_TYPE_GENERIC_PLAYER;
    public static final int SOURCE_TYPE_AM_TI_JAPAN;
    public static final int SOURCE_TYPE_DVD_CHANGER;
    public static final int SOURCE_TYPE_USB;
    public static final int SOURCE_TYPE_JUKEBOX;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL;
    public static final int SOURCE_TYPE_DVB_VIDEO_SERVICE;
    public static final int SOURCE_TYPE_DVB_AUDIO_SERVICE;
    public static final int SOURCE_TYPE_AM_SW_KURZWELLE_SHORT_WAVE;
    public static final int SOURCE_TYPE_AM_LW_LANGWELLE_LONG_WAVE;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER;
    public static final int SOURCE_TYPE_BLUE_RAY;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY;
    public static final int SOURCE_TYPE_AUX_IN_VIDEO_TV;
    public static final int SOURCE_TYPE_HDMI_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1;
    public static final int SOURCE_TYPE_COMMON_LIST_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_APPLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_MIRROR_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_GOOGLE_LINK_DF4_2;
    public static final int SOURCE_TYPE_MOBILE_DEVICE_BAIDU_LINK_DF4_4;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public int sourceType;
    public static final int INSTANCE_ID_MIN;
    public int instance_Id;
    public static final int MEDIA_TYPE_MEDIA_TYPE_NOT_AVAIALBLE_NOT_APPLICABLE;
    public static final int MEDIA_TYPE_CD_AUDIO;
    public static final int MEDIA_TYPE_DVD_AUDIO;
    public static final int MEDIA_TYPE_DVD_VIDEO;
    public static final int MEDIA_TYPE_CD_VIDEO;
    public static final int MEDIA_TYPE_CD_ROM;
    public static final int MEDIA_TYPE_DVD_ROM;
    public static final int MEDIA_TYPE_FILE_SYSTEM;
    public static final int MEDIA_TYPE_RAW;
    public static final int MEDIA_TYPE_RCP_REMOTE_CONTROL_PROTOCOL;
    public static final int MEDIA_TYPE_AUDIO_BROADCASTING_RADIO;
    public static final int MEDIA_TYPE_VIDEO_BROADCASTING_TV_DVB;
    public static final int MEDIA_TYPE_I_POD;
    public static final int MEDIA_TYPE_BLUE_RAY;
    public static final int MEDIA_TYPE_UNKNOWN_MEDIA_TYPE;
    public int mediaType;
    public SourceList_Attributes attributes;
    private static final int MAX_NAME_LENGTH;
    public final BAPString name;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public SourceList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.attributes = new SourceList_Attributes();
        this.name = new BAPString(61);
        this.internalReset();
        this.customInitialization();
    }

    public SourceList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.sourceType = 0;
        this.instance_Id = 0;
        this.mediaType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.attributes.reset();
        this.name.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SourceList_Data sourceList_Data = (SourceList_Data)bAPEntity;
        return this.arrayHeader.equalTo(sourceList_Data.arrayHeader) && this.pos == sourceList_Data.pos && this.sourceType == sourceList_Data.sourceType && this.instance_Id == sourceList_Data.instance_Id && this.mediaType == sourceList_Data.mediaType && this.attributes.equalTo(sourceList_Data.attributes) && this.name.equalTo(sourceList_Data.name);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SourceList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 4: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.mediaType);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.attributes.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.name.serialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                bitStream.pushByte((byte)this.instance_Id);
                bitStream.pushByte((byte)this.mediaType);
                this.attributes.serialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.sourceType);
                bitStream.pushByte((byte)this.instance_Id);
                bitStream.pushByte((byte)this.mediaType);
                this.attributes.serialize(bitStream);
                this.name.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 4: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.mediaType = bitStream.popFrontByte();
                break;
            }
            case 3: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.attributes.deserialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.name.deserialize(bitStream);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.sourceType = bitStream.popFrontByte();
                this.instance_Id = bitStream.popFrontByte();
                this.mediaType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                break;
            }
            case 0: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.sourceType = bitStream.popFrontByte();
                this.instance_Id = bitStream.popFrontByte();
                this.mediaType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.name.deserialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

