/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.ConnectionState_SynchronisationState;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class ConnectionState_Status
implements StatusProperty {
    public int connectionIndication;
    public static final int CONNECTION_INDICATION_INFORMATION_ABOUT_DATA_CONNECTING_IS_NOT_AVAILABLE;
    public static final int CONNECTION_INDICATION_NO_DATA_CONNECTION_ACTIVE;
    public static final int CONNECTION_INDICATION_DATA_CONNECTION_ACTIVE;
    public static final int CONNECTION_INDICATION_INITIALIZING;
    public ConnectionState_SynchronisationState synchronisationState = new ConnectionState_SynchronisationState();
    public int extension1;
    public static final int EXTENSION1_MIN;
    public int extension2;
    public static final int EXTENSION2_MIN;
    public int extension3;
    public static final int EXTENSION3_MIN;
    public int extension4;
    public static final int EXTENSION4_MIN;

    public ConnectionState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public ConnectionState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.connectionIndication = 0;
        this.extension1 = 0;
        this.extension2 = 0;
        this.extension3 = 0;
        this.extension4 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.synchronisationState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConnectionState_Status connectionState_Status = (ConnectionState_Status)bAPEntity;
        return this.connectionIndication == connectionState_Status.connectionIndication && this.synchronisationState.equalTo(connectionState_Status.synchronisationState) && this.extension1 == connectionState_Status.extension1 && this.extension2 == connectionState_Status.extension2 && this.extension3 == connectionState_Status.extension3 && this.extension4 == connectionState_Status.extension4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ConnectionState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.connectionIndication);
        this.synchronisationState.serialize(bitStream);
        bitStream.pushByte((byte)this.extension1);
        bitStream.pushByte((byte)this.extension2);
        bitStream.pushByte((byte)this.extension3);
        bitStream.pushByte((byte)this.extension4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.connectionIndication = bitStream.popFrontByte();
        this.synchronisationState.deserialize(bitStream);
        this.extension1 = bitStream.popFrontByte();
        this.extension2 = bitStream.popFrontByte();
        this.extension3 = bitStream.popFrontByte();
        this.extension4 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return ConnectionState_Status.functionId();
    }
}

