/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class SupportedServiceNumbers_Status$ServiceNumbers
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean emergencyCallSupported;
    public boolean serviceCallSupported;
    public boolean infoCallSupported;
    public boolean voiceMailboxSupported;

    public SupportedServiceNumbers_Status$ServiceNumbers() {
        this.internalReset();
        this.customInitialization();
    }

    public SupportedServiceNumbers_Status$ServiceNumbers(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.emergencyCallSupported = false;
        this.serviceCallSupported = false;
        this.infoCallSupported = false;
        this.voiceMailboxSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SupportedServiceNumbers_Status$ServiceNumbers supportedServiceNumbers_Status$ServiceNumbers = (SupportedServiceNumbers_Status$ServiceNumbers)bAPEntity;
        return this.emergencyCallSupported == supportedServiceNumbers_Status$ServiceNumbers.emergencyCallSupported && this.serviceCallSupported == supportedServiceNumbers_Status$ServiceNumbers.serviceCallSupported && this.infoCallSupported == supportedServiceNumbers_Status$ServiceNumbers.infoCallSupported && this.voiceMailboxSupported == supportedServiceNumbers_Status$ServiceNumbers.voiceMailboxSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ServiceNumbers:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.emergencyCallSupported);
        bitStream.pushBoolean(this.serviceCallSupported);
        bitStream.pushBoolean(this.infoCallSupported);
        bitStream.pushBoolean(this.voiceMailboxSupported);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

