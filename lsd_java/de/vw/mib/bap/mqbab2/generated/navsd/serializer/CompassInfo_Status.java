/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CompassInfo_Status
implements StatusProperty {
    public int direction_Symbolic;
    public static final int DIRECTION_SYMBOLIC_N;
    public static final int DIRECTION_SYMBOLIC_NNO;
    public static final int DIRECTION_SYMBOLIC_NO;
    public static final int DIRECTION_SYMBOLIC_ONO;
    public static final int DIRECTION_SYMBOLIC_O;
    public static final int DIRECTION_SYMBOLIC_OSO;
    public static final int DIRECTION_SYMBOLIC_SO;
    public static final int DIRECTION_SYMBOLIC_SSO;
    public static final int DIRECTION_SYMBOLIC_S;
    public static final int DIRECTION_SYMBOLIC_SSW;
    public static final int DIRECTION_SYMBOLIC_SW;
    public static final int DIRECTION_SYMBOLIC_WSW;
    public static final int DIRECTION_SYMBOLIC_W;
    public static final int DIRECTION_SYMBOLIC_WNW;
    public static final int DIRECTION_SYMBOLIC_NW;
    public static final int DIRECTION_SYMBOLIC_NNW;
    public static final int DIRECTION_SYMBOLIC_NOT_SUPPORTED;
    public int direction_Angle;

    public CompassInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CompassInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.direction_Symbolic = 0;
        this.direction_Angle = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CompassInfo_Status compassInfo_Status = (CompassInfo_Status)bAPEntity;
        return this.direction_Symbolic == compassInfo_Status.direction_Symbolic && this.direction_Angle == compassInfo_Status.direction_Angle;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CompassInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.direction_Symbolic);
        bitStream.pushShort((short)this.direction_Angle);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 16;
    }

    @Override
    public int getFunctionId() {
        return CompassInfo_Status.functionId();
    }
}

