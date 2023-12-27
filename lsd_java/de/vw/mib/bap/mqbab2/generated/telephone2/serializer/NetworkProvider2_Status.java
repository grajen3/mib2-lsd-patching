/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class NetworkProvider2_Status
implements StatusProperty {
    public int networkProviderState;
    public static final int NETWORK_PROVIDER_STATE_NETWORK_PROVIDER_UNKNOWN;
    public static final int NETWORK_PROVIDER_STATE_NETWORK_PROVIDER_NAME_AVAILABLE;
    public final BAPString networkProviderName = new BAPString(40);
    private static final int MAX_NETWORK_PROVIDER_NAME_LENGTH;
    public int serviceProviderState;
    public static final int SERVICE_PROVIDER_STATE_SERVICE_PROVIDER_UNKNOWN;
    public static final int SERVICE_PROVIDER_STATE_SERVICE_PROVIDER_NAME_AVAILABLE;
    public final BAPString serviceProviderName = new BAPString(40);
    private static final int MAX_SERVICE_PROVIDER_NAME_LENGTH;

    public NetworkProvider2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public NetworkProvider2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.networkProviderState = 0;
        this.serviceProviderState = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.networkProviderName.reset();
        this.serviceProviderName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NetworkProvider2_Status networkProvider2_Status = (NetworkProvider2_Status)bAPEntity;
        return this.networkProviderState == networkProvider2_Status.networkProviderState && this.networkProviderName.equalTo(networkProvider2_Status.networkProviderName) && this.serviceProviderState == networkProvider2_Status.serviceProviderState && this.serviceProviderName.equalTo(networkProvider2_Status.serviceProviderName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NetworkProvider2_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.networkProviderState);
        this.networkProviderName.serialize(bitStream);
        bitStream.pushByte((byte)this.serviceProviderState);
        this.serviceProviderName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 19;
    }

    @Override
    public int getFunctionId() {
        return NetworkProvider2_Status.functionId();
    }
}

