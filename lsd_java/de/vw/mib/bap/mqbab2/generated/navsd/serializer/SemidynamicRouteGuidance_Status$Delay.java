/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SemidynamicRouteGuidance_Status$Delay
implements BAPEntity {
    public int minute;
    public int hour;

    public SemidynamicRouteGuidance_Status$Delay() {
        this.internalReset();
        this.customInitialization();
    }

    public SemidynamicRouteGuidance_Status$Delay(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.minute = 0;
        this.hour = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SemidynamicRouteGuidance_Status$Delay semidynamicRouteGuidance_Status$Delay = (SemidynamicRouteGuidance_Status$Delay)bAPEntity;
        return this.minute == semidynamicRouteGuidance_Status$Delay.minute && this.hour == semidynamicRouteGuidance_Status$Delay.hour;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Delay:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.minute);
        bitStream.pushByte((byte)this.hour);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

