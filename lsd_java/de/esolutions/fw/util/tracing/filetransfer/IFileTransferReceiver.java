/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferManager;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferSender;

public interface IFileTransferReceiver
extends IFileTransferManager {
    default public void setFileTransferSender(IFileTransferSender iFileTransferSender) {
    }

    default public boolean handleInitExitMessage() {
    }

    default public boolean handleFileRequestMessage(int n, String string, byte by) {
    }

    default public boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
    }

    default public boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
    }

    default public boolean reset(String string) {
    }
}

