/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ManeuverState_Status
implements StatusProperty {
    public int state;
    public static final int STATE_INIT_UNKNOWN;
    public static final int STATE_FOLLOW;
    public static final int STATE_PREPARE;
    public static final int STATE_DISTANCE;
    public static final int STATE_CALL_FOR_ACTION;
    public int dummy1;
    public int dummy2;
    public int dummy3;

    public ManeuverState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ManeuverState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.dummy1 = 0;
        this.dummy2 = 0;
        this.dummy3 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ManeuverState_Status maneuverState_Status = (ManeuverState_Status)bAPEntity;
        return this.state == maneuverState_Status.state && this.dummy1 == maneuverState_Status.dummy1 && this.dummy2 == maneuverState_Status.dummy2 && this.dummy3 == maneuverState_Status.dummy3;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ManeuverState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.dummy1);
        bitStream.pushByte((byte)this.dummy2);
        bitStream.pushByte((byte)this.dummy3);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return ManeuverState_Status.functionId();
    }
}

