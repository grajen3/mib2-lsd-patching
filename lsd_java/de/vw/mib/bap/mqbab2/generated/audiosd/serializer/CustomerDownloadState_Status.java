/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CustomerDownloadState_Status
implements StatusProperty {
    public int customerDownloadState;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_PAUSED;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_FAILED;
    public static final int CUSTOMER_DOWNLOAD_STATE_CUSTOMER_DOWNLOAD_ACTIVE_ONGOING;
    public static final int CUSTOMER_DOWNLOAD_STATE_NO_CUSTOMER_DOWNLOAD_ACTIVE;
    public int progressCustomerDownload;
    public static final int PROGRESS_CUSTOMER_DOWNLOAD_MIN;

    public CustomerDownloadState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CustomerDownloadState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.customerDownloadState = 0;
        this.progressCustomerDownload = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CustomerDownloadState_Status customerDownloadState_Status = (CustomerDownloadState_Status)bAPEntity;
        return this.customerDownloadState == customerDownloadState_Status.customerDownloadState && this.progressCustomerDownload == customerDownloadState_Status.progressCustomerDownload;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CustomerDownloadState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.customerDownloadState);
        bitStream.pushByte((byte)this.progressCustomerDownload);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.customerDownloadState = bitStream.popFrontByte();
        this.progressCustomerDownload = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 48;
    }

    @Override
    public int getFunctionId() {
        return CustomerDownloadState_Status.functionId();
    }
}

