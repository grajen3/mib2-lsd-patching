/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

public final class SatSeekDsiException {
    private final int mErrorCode;
    private final String mErrorMsg;
    private final int mRequestType;

    public SatSeekDsiException(int n, String string, int n2) {
        this.mErrorCode = n;
        this.mErrorMsg = string;
        this.mRequestType = n2;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMsg;
    }

    public int getRequestType() {
        return this.mRequestType;
    }
}

