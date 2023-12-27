/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MapColorAndType_Status$SupportedMapTypes
implements BAPEntity {
    private static final int RESERVED_BIT_6__7_BITSIZE;
    public boolean rangeMapIsSupported;
    public boolean overviewMapIsSupported;
    public boolean position3DMapIsSupported;
    public boolean position2DMapIsSupported;
    public boolean destinationMapIsSupported;
    public boolean mainMapSetupIsSupported;

    public MapColorAndType_Status$SupportedMapTypes() {
        this.internalReset();
        this.customInitialization();
    }

    public MapColorAndType_Status$SupportedMapTypes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.rangeMapIsSupported = false;
        this.overviewMapIsSupported = false;
        this.position3DMapIsSupported = false;
        this.position2DMapIsSupported = false;
        this.destinationMapIsSupported = false;
        this.mainMapSetupIsSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MapColorAndType_Status$SupportedMapTypes mapColorAndType_Status$SupportedMapTypes = (MapColorAndType_Status$SupportedMapTypes)bAPEntity;
        return this.rangeMapIsSupported == mapColorAndType_Status$SupportedMapTypes.rangeMapIsSupported && this.overviewMapIsSupported == mapColorAndType_Status$SupportedMapTypes.overviewMapIsSupported && this.position3DMapIsSupported == mapColorAndType_Status$SupportedMapTypes.position3DMapIsSupported && this.position2DMapIsSupported == mapColorAndType_Status$SupportedMapTypes.position2DMapIsSupported && this.destinationMapIsSupported == mapColorAndType_Status$SupportedMapTypes.destinationMapIsSupported && this.mainMapSetupIsSupported == mapColorAndType_Status$SupportedMapTypes.mainMapSetupIsSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SupportedMapTypes:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(2);
        bitStream.pushBoolean(this.rangeMapIsSupported);
        bitStream.pushBoolean(this.overviewMapIsSupported);
        bitStream.pushBoolean(this.position3DMapIsSupported);
        bitStream.pushBoolean(this.position2DMapIsSupported);
        bitStream.pushBoolean(this.destinationMapIsSupported);
        bitStream.pushBoolean(this.mainMapSetupIsSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

