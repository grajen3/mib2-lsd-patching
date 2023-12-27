/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public interface IFileTransferListener {
    default public boolean confirmFileTransfer(IFile iFile) {
    }

    default public void fileTransferBegin(IFile iFile) {
    }

    default public void fileTransferProgress(IFile iFile) {
    }

    default public void fileTransferComplete(IFile iFile) {
    }

    default public void fileTransferStatus(IFile iFile) {
    }

    default public void fileTransferError(IFile iFile) {
    }
}

