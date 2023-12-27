/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PreferredList_Status
implements StatusProperty {
    public int list;
    public static final int LIST_LAST_STATION_LIST_PREFERRED_DF4_5;
    public static final int LIST_SIRIUS_ALERT_LIST_PREFERRED_DF4_5;
    public static final int LIST_PRESET_LIST_PREFERRED;
    public static final int LIST_RECEPTION_LIST_MEDIA_BROWSER_PREFERRED;
    public static final int LIST_NO_LIST_PREFERRED;

    public PreferredList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public PreferredList_Status(BitStream bitStream) {
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
        PreferredList_Status preferredList_Status = (PreferredList_Status)bAPEntity;
        return this.list == preferredList_Status.list;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PreferredList_Status:";
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
        return PreferredList_Status.functionId();
    }
}

