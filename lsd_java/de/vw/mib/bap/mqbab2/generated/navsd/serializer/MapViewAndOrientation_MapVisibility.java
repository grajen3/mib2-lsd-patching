/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_MapVisibility
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean supplementaryMapViewIsVisible;
    public boolean lvdsMapIsVisible;

    public MapViewAndOrientation_MapVisibility() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_MapVisibility(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.supplementaryMapViewIsVisible = false;
        this.lvdsMapIsVisible = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_MapVisibility mapViewAndOrientation_MapVisibility = (MapViewAndOrientation_MapVisibility)bAPEntity;
        return this.supplementaryMapViewIsVisible == mapViewAndOrientation_MapVisibility.supplementaryMapViewIsVisible && this.lvdsMapIsVisible == mapViewAndOrientation_MapVisibility.lvdsMapIsVisible;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MapViewAndOrientation_MapVisibility:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.supplementaryMapViewIsVisible);
        bitStream.pushBoolean(this.lvdsMapIsVisible);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.supplementaryMapViewIsVisible = bitStream.popFrontBoolean();
        this.lvdsMapIsVisible = bitStream.popFrontBoolean();
    }
}

