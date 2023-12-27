/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MagnetFieldZone_SetGet
implements SetGetProperty {
    public int zone;
    public static final int ZONE_ZONE_1;
    public static final int ZONE_ZONE_2;
    public static final int ZONE_ZONE_3;
    public static final int ZONE_ZONE_4;
    public static final int ZONE_ZONE_5;
    public static final int ZONE_ZONE_6;
    public static final int ZONE_ZONE_7;
    public static final int ZONE_ZONE_8;
    public static final int ZONE_ZONE_9;
    public static final int ZONE_ZONE_10;
    public static final int ZONE_ZONE_11;
    public static final int ZONE_ZONE_12;
    public static final int ZONE_ZONE_13;
    public static final int ZONE_ZONE_14;
    public static final int ZONE_ZONE_15;

    public MagnetFieldZone_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MagnetFieldZone_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.zone = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MagnetFieldZone_SetGet magnetFieldZone_SetGet = (MagnetFieldZone_SetGet)bAPEntity;
        return this.zone == magnetFieldZone_SetGet.zone;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MagnetFieldZone_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.zone = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return MagnetFieldZone_SetGet.functionId();
    }
}

