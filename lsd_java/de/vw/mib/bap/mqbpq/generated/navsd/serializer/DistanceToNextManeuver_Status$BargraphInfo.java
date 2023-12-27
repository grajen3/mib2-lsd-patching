/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$BargraphInfo
implements BAPEntity {
    public int bargraphOnOff;
    public static final int BARGRAPH_ON_OFF_BARGRAPH_SHALL_NOT_BE_DISPLAYED;
    public static final int BARGRAPH_ON_OFF_DISPLAY_BARGRAPH;
    public static final int BARGRAPH_ON_OFF_NOT_SUPPORTED;
    public int bargraph;

    public DistanceToNextManeuver_Status$BargraphInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$BargraphInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.bargraphOnOff = 0;
        this.bargraph = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$BargraphInfo distanceToNextManeuver_Status$BargraphInfo = (DistanceToNextManeuver_Status$BargraphInfo)bAPEntity;
        return this.bargraphOnOff == distanceToNextManeuver_Status$BargraphInfo.bargraphOnOff && this.bargraph == distanceToNextManeuver_Status$BargraphInfo.bargraph;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "BargraphInfo:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.bargraphOnOff);
        bitStream.pushByte((byte)this.bargraph);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

