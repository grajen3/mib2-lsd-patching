/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$SupportedSupplementaryMapViews
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean _1BoxSupported;
    public boolean compassSupported;
    public boolean intersectionZoomSupported;

    public MapViewAndOrientation_Status$SupportedSupplementaryMapViews() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$SupportedSupplementaryMapViews(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this._1BoxSupported = false;
        this.compassSupported = false;
        this.intersectionZoomSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$SupportedSupplementaryMapViews mapViewAndOrientation_Status$SupportedSupplementaryMapViews = (MapViewAndOrientation_Status$SupportedSupplementaryMapViews)bAPEntity;
        return this._1BoxSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews._1BoxSupported && this.compassSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews.compassSupported && this.intersectionZoomSupported == mapViewAndOrientation_Status$SupportedSupplementaryMapViews.intersectionZoomSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedSupplementaryMapViews:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(5);
        bitStream.pushBoolean(this._1BoxSupported);
        bitStream.pushBoolean(this.compassSupported);
        bitStream.pushBoolean(this.intersectionZoomSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

