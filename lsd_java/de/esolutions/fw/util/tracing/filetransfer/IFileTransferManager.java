/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;

public interface IFileTransferManager {
    default public void registerListener(IFileTransferListener iFileTransferListener) {
    }

    default public void unregisterListener(IFileTransferListener iFileTransferListener) {
    }

    default public void setFileFactory(IFileFactory iFileFactory) {
    }

    default public String getDownloadDirectory() {
    }

    default public boolean uploadFile(IFile iFile) {
    }

    default public boolean requestFileStatus(String string, IFile iFile) {
    }

    default public boolean requestFileDownload(String string, IFile iFile) {
    }
}

