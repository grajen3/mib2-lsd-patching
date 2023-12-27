/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;

public interface IFile {
    default public boolean open(boolean bl) {
    }

    default public boolean write(byte[] byArray) {
    }

    default public boolean close() {
    }

    default public byte[] read(int n) {
    }

    default public String getLocalPath() {
    }

    default public String getRemotePath() {
    }

    default public boolean isHashValid() {
    }

    default public boolean isAvailable() {
    }

    default public boolean isFile() {
    }

    default public boolean isUpload() {
    }

    default public boolean isReadable() {
    }

    default public boolean hasError() {
    }

    default public FileTransferError getError() {
    }

    default public String getFilename() {
    }

    default public long getTimestamp() {
    }

    default public long getSize() {
    }

    default public long getCompleteSize() {
    }

    default public long getOffset() {
    }

    default public byte[] getFileHash() {
    }

    default public long getId() {
    }
}

