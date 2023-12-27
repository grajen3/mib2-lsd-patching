/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MagnetFieldZone_Status
implements StatusProperty {
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

    public MagnetFieldZone_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MagnetFieldZone_Status(BitStream bitStream) {
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
        MagnetFieldZone_Status magnetFieldZone_Status = (MagnetFieldZone_Status)bAPEntity;
        return this.zone == magnetFieldZone_Status.zone;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MagnetFieldZone_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.zone);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 25;
    }

    @Override
    public int getFunctionId() {
        return MagnetFieldZone_Status.functionId();
    }
}

