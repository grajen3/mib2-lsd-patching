/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

public interface IFileTransferSender {
    default public boolean sendFileRequest(int n, String string, byte by) {
    }

    default public boolean sendFileStatus(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
    }

    default public boolean sendFileTransfer(int n, int n2, byte by, int n3, byte[] byArray) {
    }
}

