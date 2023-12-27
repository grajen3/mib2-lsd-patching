/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_SynchronisationState
implements BAPEntity {
    private static final int RESERVED_BIT_2__7_BITSIZE;
    public boolean serviceListWasSynchronised;
    public boolean userListWasSynchronised;

    public ConnectionState_SynchronisationState() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_SynchronisationState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.serviceListWasSynchronised = false;
        this.userListWasSynchronised = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_SynchronisationState connectionState_SynchronisationState = (ConnectionState_SynchronisationState)bAPEntity;
        return this.serviceListWasSynchronised == connectionState_SynchronisationState.serviceListWasSynchronised && this.userListWasSynchronised == connectionState_SynchronisationState.userListWasSynchronised;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ConnectionState_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(6);
        bitStream.pushBoolean(this.serviceListWasSynchronised);
        bitStream.pushBoolean(this.userListWasSynchronised);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(6);
        this.serviceListWasSynchronised = bitStream.popFrontBoolean();
        this.userListWasSynchronised = bitStream.popFrontBoolean();
    }
}

