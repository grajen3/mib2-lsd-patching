/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class InfoListType_Status
implements StatusProperty {
    public int type;
    public static final int TYPE_UNKNOWN_TYPE_UNSPECIFIC;
    public static final int TYPE_TRACK_LIST_TITLE_LIST;
    public static final int TYPE_PRESET_LIST;
    public static final int TYPE_RECEPTION_LIST;
    public static final int TYPE_AUTO_STORE_LIST;
    public static final int TYPE_DIRECTORY_LIST_FILE_LIST;
    public static final int TYPE_CD_LIST_LIST_OF_C_DS_BEING_IN_CD_CHANGER;
    public static final int TYPE_NO_LIST_AVAILABLE;

    public InfoListType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public InfoListType_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.type = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        InfoListType_Status infoListType_Status = (InfoListType_Status)bAPEntity;
        return this.type == infoListType_Status.type;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "InfoListType_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.type);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return InfoListType_Status.functionId();
    }
}

