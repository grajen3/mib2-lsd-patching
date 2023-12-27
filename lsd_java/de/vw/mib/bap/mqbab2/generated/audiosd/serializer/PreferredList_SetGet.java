/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredList_SetGet
implements SetGetProperty {
    public int list;
    public static final int LIST_LAST_STATION_LIST_PREFERRED_DF4_5;
    public static final int LIST_SIRIUS_ALERT_LIST_PREFERRED_DF4_5;
    public static final int LIST_PRESET_LIST_PREFERRED;
    public static final int LIST_RECEPTION_LIST_MEDIA_BROWSER_PREFERRED;
    public static final int LIST_NO_LIST_PREFERRED;

    public PreferredList_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredList_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.list = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PreferredList_SetGet preferredList_SetGet = (PreferredList_SetGet)bAPEntity;
        return this.list == preferredList_SetGet.list;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PreferredList_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.list);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.list = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 40;
    }

    @Override
    public int getFunctionId() {
        return PreferredList_SetGet.functionId();
    }
}

