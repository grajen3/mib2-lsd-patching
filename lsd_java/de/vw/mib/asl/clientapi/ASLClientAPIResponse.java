/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi;

public interface ASLClientAPIResponse {
    public static final int RESULT_OK;
    public static final int RESULT_ERROR;
    public static final int RESULT_NOT_READY;
    public static final int RESULT_NOT_IMPLEMENTED;
    public static final int RESULT_REJECTED;
    public static final int RESULT_TIMEOUT;
    public static final int RESULT_QUEUE_FULL;

    default public void _finished(int n) {
    }
}

