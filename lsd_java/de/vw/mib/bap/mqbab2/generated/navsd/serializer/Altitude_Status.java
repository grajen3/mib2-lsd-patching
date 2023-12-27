/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Altitude_Status
implements StatusProperty {
    public int altitude;
    public int unit;
    public static final int UNIT_METER;
    public static final int UNIT_FEET;

    public Altitude_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Altitude_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.altitude = 0;
        this.unit = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Altitude_Status altitude_Status = (Altitude_Status)bAPEntity;
        return this.altitude == altitude_Status.altitude && this.unit == altitude_Status.unit;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Altitude_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.altitude);
        bitStream.pushByte((byte)this.unit);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 47;
    }

    @Override
    public int getFunctionId() {
        return Altitude_Status.functionId();
    }
}

