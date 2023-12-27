/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.IFile;

public interface IExtendedFile
extends IFile {
    default public void setPath(String string) {
    }

    default public void setFlag(byte by) {
    }

    default public void setUserFlag(byte by) {
    }

    default public byte getUserFlag() {
    }

    default public void setTimestamp(long l) {
    }

    default public void setHashType(byte by) {
    }

    default public void setHash(byte[] byArray) {
    }

    default public void setSize(long l) {
    }

    default public void setCompleteSize(long l) {
    }

    default public void setError(FileTransferError fileTransferError) {
    }

    default public void setValidHash(boolean bl) {
    }
}

