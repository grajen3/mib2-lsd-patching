/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapViewAndOrientation_Status$Modification
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean googleMapCanNotBeModified;

    public MapViewAndOrientation_Status$Modification() {
        this.internalReset();
        this.customInitialization();
    }

    public MapViewAndOrientation_Status$Modification(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.googleMapCanNotBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapViewAndOrientation_Status$Modification mapViewAndOrientation_Status$Modification = (MapViewAndOrientation_Status$Modification)bAPEntity;
        return this.googleMapCanNotBeModified == mapViewAndOrientation_Status$Modification.googleMapCanNotBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Modification:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.googleMapCanNotBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

