/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DestinationInfo_Status$Position
implements BAPEntity {
    public int latitude;
    public int longitude;

    public DestinationInfo_Status$Position() {
        this.internalReset();
        this.customInitialization();
    }

    public DestinationInfo_Status$Position(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.latitude = 0;
        this.longitude = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DestinationInfo_Status$Position destinationInfo_Status$Position = (DestinationInfo_Status$Position)bAPEntity;
        return this.latitude == destinationInfo_Status$Position.latitude && this.longitude == destinationInfo_Status$Position.longitude;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Position:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.latitude);
        bitStream.pushInt(this.longitude);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

