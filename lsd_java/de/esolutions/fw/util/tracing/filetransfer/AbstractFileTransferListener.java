/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public class AbstractFileTransferListener
implements IFileTransferListener {
    @Override
    public void fileTransferBegin(IFile iFile) {
    }

    @Override
    public void fileTransferProgress(IFile iFile) {
    }

    @Override
    public void fileTransferComplete(IFile iFile) {
    }

    @Override
    public void fileTransferStatus(IFile iFile) {
    }

    @Override
    public void fileTransferError(IFile iFile) {
    }

    @Override
    public boolean confirmFileTransfer(IFile iFile) {
        return true;
    }
}

