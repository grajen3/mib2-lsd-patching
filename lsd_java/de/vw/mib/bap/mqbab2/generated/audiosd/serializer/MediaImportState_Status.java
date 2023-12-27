/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MediaImportState_Status
implements StatusProperty {
    public int sourceType;
    public static final int SOURCE_TYPE_UNKNOWN_SOURCE;
    public static final int SOURCE_TYPE_ONLINE_RADIO_DF4_1;
    public static final int SOURCE_TYPE_ONLINE_MASS_STORAGE_DF4_1;
    public static final int SOURCE_TYPE_HDMI_DF4_1;
    public static final int SOURCE_TYPE_FLASH_FLASH_MEMORY;
    public static final int SOURCE_TYPE_BLUE_RAY_CHANGER;
    public static final int SOURCE_TYPE_BLUE_RAY;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_RCP_REMOTE_CONTROL_PLAYER;
    public static final int SOURCE_TYPE_WLAN_CONNECTION_MASS_STORAGE;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_REMOTE_CONTROL_PROTOCOL;
    public static final int SOURCE_TYPE_BLUETOOTH_CONNECTION_BT_STREAM;
    public static final int SOURCE_TYPE_JUKEBOX;
    public static final int SOURCE_TYPE_USB;
    public static final int SOURCE_TYPE_DVD_CHANGER;
    public static final int SOURCE_TYPE_GENERIC_PLAYER;
    public static final int SOURCE_TYPE_PORTABLE_DEVICE_MDI_AMI;
    public static final int SOURCE_TYPE_SD;
    public static final int SOURCE_TYPE_HDD;
    public static final int SOURCE_TYPE_DVD;
    public static final int SOURCE_TYPE_CD_CHANGER;
    public static final int SOURCE_TYPE_CD;
    public static final int SOURCE_TYPE_NO_SOURCE_ACTIVE;
    public int instance_Id;
    public static final int INSTANCE_ID_MIN;
    public int state;
    public static final int STATE_IMPORT_ACTIVE_ONGOING;
    public static final int STATE_IMPORT_NOT_ACTIVE;
    public int progress;
    public static final int PROGRESS_MIN;

    public MediaImportState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MediaImportState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.sourceType = 0;
        this.instance_Id = 0;
        this.state = 0;
        this.progress = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MediaImportState_Status mediaImportState_Status = (MediaImportState_Status)bAPEntity;
        return this.sourceType == mediaImportState_Status.sourceType && this.instance_Id == mediaImportState_Status.instance_Id && this.state == mediaImportState_Status.state && this.progress == mediaImportState_Status.progress;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MediaImportState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.sourceType);
        bitStream.pushByte((byte)this.instance_Id);
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.progress);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.sourceType = bitStream.popFrontByte();
        this.instance_Id = bitStream.popFrontByte();
        this.state = bitStream.popFrontByte();
        this.progress = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 46;
    }

    @Override
    public int getFunctionId() {
        return MediaImportState_Status.functionId();
    }
}

