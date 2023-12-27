/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.util;

public interface DebugInfoFilesArchiveFetcherListener {
    default public void connected() {
    }

    default public void connectionFailed(Exception exception) {
    }

    default public void connectionClosed() {
    }

    default public void localFileError(Exception exception) {
    }

    default public void fileTransferError(Exception exception) {
    }

    default public void fileTransferFinished() {
    }
}

