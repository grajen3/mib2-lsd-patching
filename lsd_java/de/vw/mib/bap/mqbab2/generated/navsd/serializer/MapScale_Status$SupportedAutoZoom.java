/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapScale_Status$SupportedAutoZoom
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean autozoomOnForIntersectionSupported;

    public MapScale_Status$SupportedAutoZoom() {
        this.internalReset();
        this.customInitialization();
    }

    public MapScale_Status$SupportedAutoZoom(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.autozoomOnForIntersectionSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapScale_Status$SupportedAutoZoom mapScale_Status$SupportedAutoZoom = (MapScale_Status$SupportedAutoZoom)bAPEntity;
        return this.autozoomOnForIntersectionSupported == mapScale_Status$SupportedAutoZoom.autozoomOnForIntersectionSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedAutoZoom:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.autozoomOnForIntersectionSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

