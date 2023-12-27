/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RegisterState_Status
implements StatusProperty {
    public int registerState;
    public static final int REGISTER_STATE_NOT_REGISTERED_AND_NOT_SEARCHING;
    public static final int REGISTER_STATE_REGISTERED;
    public static final int REGISTER_STATE_NOT_REGISTERED_AND_SEARCHING;
    public static final int REGISTER_STATE_REGISTRATION_DENIED;
    public static final int REGISTER_STATE_REGISTERED_AND_ROAMING;
    public static final int REGISTER_STATE_REGISTERED_AND_ROAMING_ALTERNATIVE;
    public static final int REGISTER_STATE_FUNCTION_NOT_SUPPORTED_BY_ME;
    public int networkType;
    public static final int NETWORK_TYPE_UNKNOWN;
    public static final int NETWORK_TYPE_GSM;
    public static final int NETWORK_TYPE_UMTS;
    public static final int NETWORK_TYPE_CDMA;
    public static final int NETWORK_TYPE_LTE;
    public static final int NETWORK_TYPE_HSPA_DF4_2;
    public static final int NETWORK_TYPE_LTE_ADVANCED_DF4_2;
    public int packetDataNetworkType;
    public static final int PACKET_DATA_NETWORK_TYPE_NO_DATA_SERVICE;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_GPRS;
    public static final int PACKET_DATA_NETWORK_TYPE_GSM_EDGE;
    public static final int PACKET_DATA_NETWORK_TYPE_HSDPA_HIGH_SPEED_DOWNLINK_PACKET_ACCESS;
    public static final int PACKET_DATA_NETWORK_TYPE_HSUPA_HIGH_SPEED_UPLINK_PACKET_ACCESS;
    public static final int PACKET_DATA_NETWORK_TYPE_CDMA;
    public static final int PACKET_DATA_NETWORK_TYPE_LTE;
    public static final int PACKET_DATA_NETWORK_TYPE_HSPA_DF4_2;
    public static final int PACKET_DATA_NETWORK_TYPE_LTE_ADVANCED_DF4_2;
    public static final int PACKET_DATA_NETWORK_TYPE_UNKNOWN_PACKET_DATA_NETWORK;

    public RegisterState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RegisterState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.registerState = 0;
        this.networkType = 0;
        this.packetDataNetworkType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RegisterState_Status registerState_Status = (RegisterState_Status)bAPEntity;
        return this.registerState == registerState_Status.registerState && this.networkType == registerState_Status.networkType && this.packetDataNetworkType == registerState_Status.packetDataNetworkType;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RegisterState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.registerState);
        bitStream.pushByte((byte)this.networkType);
        bitStream.pushByte((byte)this.packetDataNetworkType);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return RegisterState_Status.functionId();
    }
}

