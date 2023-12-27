/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DisconnectReason_Status
implements StatusProperty {
    public int disconnectReason;
    public static final int DISCONNECT_REASON_TEMPORARY_BLOCKED_NOT_AVAILABLE;
    public static final int DISCONNECT_REASON_NO_INFO_AVAILABLE_DISCONNECT_REASON_UNKNOWN;
    public static final int DISCONNECT_REASON_SERVICE_NOT_AVAILABLE;
    public static final int DISCONNECT_REASON_NUMBER_INVALID_INCOMPLETE;
    public static final int DISCONNECT_REASON_NUMBER_CHANGED;
    public static final int DISCONNECT_REASON_CALL_REJECT;
    public static final int DISCONNECT_REASON_USER_NOT_RESPONDING;
    public static final int DISCONNECT_REASON_CALL_BARRING_ACTIVE;
    public static final int DISCONNECT_REASON_NETWORK_FAILURE;
    public static final int DISCONNECT_REASON_NUMBER_NOT_REACHABLE;
    public static final int DISCONNECT_REASON_NUMBER_NOT_ASSIGNED;
    public static final int DISCONNECT_REASON_LINE_BUSY_NUMBER_BUSY;
    public static final int DISCONNECT_REASON_SYSTEM_BUSY;
    public static final int DISCONNECT_REASON_CONNECTED_LINE_BUSY;
    public static final int DISCONNECT_REASON_NO_LINE;
    public static final int DISCONNECT_REASON_REGULAR_DISCONNECTING_DEFAULT_VALUE;

    public DisconnectReason_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DisconnectReason_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.disconnectReason = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DisconnectReason_Status disconnectReason_Status = (DisconnectReason_Status)bAPEntity;
        return this.disconnectReason == disconnectReason_Status.disconnectReason;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DisconnectReason_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.disconnectReason);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.disconnectReason = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return DisconnectReason_Status.functionId();
    }
}

