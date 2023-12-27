/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_OriginGpsposition
implements BAPEntity {
    public static final int POSITION_LATITUDE_MIN;
    public int positionLatitude;
    public static final int POSITION_LONGITUDE_MIN;
    public int positionLongitude;

    public ActiveTrip_OriginGpsposition() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_OriginGpsposition(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.positionLatitude = -90;
        this.positionLongitude = -180;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_OriginGpsposition activeTrip_OriginGpsposition = (ActiveTrip_OriginGpsposition)bAPEntity;
        return this.positionLatitude == activeTrip_OriginGpsposition.positionLatitude && this.positionLongitude == activeTrip_OriginGpsposition.positionLongitude;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveTrip_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.positionLatitude);
        bitStream.pushInt(this.positionLongitude);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.positionLatitude = bitStream.popFrontInt();
        this.positionLongitude = bitStream.popFrontInt();
    }
}

