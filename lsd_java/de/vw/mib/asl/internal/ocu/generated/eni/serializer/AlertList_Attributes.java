/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class AlertList_Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean alwaysOn;
    public boolean alertIsActivated;

    public AlertList_Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public AlertList_Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.alwaysOn = false;
        this.alertIsActivated = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AlertList_Attributes alertList_Attributes = (AlertList_Attributes)bAPEntity;
        return this.alwaysOn == alertList_Attributes.alwaysOn && this.alertIsActivated == alertList_Attributes.alertIsActivated;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AlertList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.alwaysOn);
        bitStream.pushBoolean(this.alertIsActivated);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.alwaysOn = bitStream.popFrontBoolean();
        this.alertIsActivated = bitStream.popFrontBoolean();
    }
}

