/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$SupportedMapViews
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean trafficMapIsSupported;
    public boolean googleEarthMapIsSupported;
    public boolean standardMapIsSupported;

    public MapViewAndOrientation_Status$SupportedMapViews() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$SupportedMapViews(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.trafficMapIsSupported = false;
        this.googleEarthMapIsSupported = false;
        this.standardMapIsSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$SupportedMapViews mapViewAndOrientation_Status$SupportedMapViews = (MapViewAndOrientation_Status$SupportedMapViews)bAPEntity;
        return this.trafficMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.trafficMapIsSupported && this.googleEarthMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.googleEarthMapIsSupported && this.standardMapIsSupported == mapViewAndOrientation_Status$SupportedMapViews.standardMapIsSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedMapViews:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.trafficMapIsSupported);
        bitStream.pushBoolean(this.googleEarthMapIsSupported);
        bitStream.pushBoolean(this.standardMapIsSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

