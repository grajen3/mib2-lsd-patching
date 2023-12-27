/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ReceptionListType_Status
implements StatusProperty {
    public int type;
    public static final int TYPE_NO_RECEPTION_LIST_AVAILABLE_RECEPTION_LIST_NOT_SUPPORTED;
    public static final int TYPE_ONLINE_PODCAST_DF4_5;
    public static final int TYPE_COMMON_LIST_DF4_2;
    public static final int TYPE_ONLINE_RADIO_RECEPTION_LIST_DF4_1;
    public static final int TYPE_AM_LW_RECEPTION_LIST;
    public static final int TYPE_AM_SW_RECEPTION_LIST;
    public static final int TYPE_TV_RECEPTION_LIST;
    public static final int TYPE_DVB_RECEPTION_LIST;
    public static final int TYPE_SDARS_RECEPTION_LIST;
    public static final int TYPE_DAB_RECEPTION_LIST;
    public static final int TYPE_AM_RECEPTION_LIST;
    public static final int TYPE_FM_RECEPTION_LIST;
    public static final int TYPE_UNKNOWN_TYPE_UNSPECIFIC;

    public ReceptionListType_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ReceptionListType_Status(BitStream bitStream) {
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
        ReceptionListType_Status receptionListType_Status = (ReceptionListType_Status)bAPEntity;
        return this.type == receptionListType_Status.type;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ReceptionListType_Status:";
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
        this.type = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 31;
    }

    @Override
    public int getFunctionId() {
        return ReceptionListType_Status.functionId();
    }
}

