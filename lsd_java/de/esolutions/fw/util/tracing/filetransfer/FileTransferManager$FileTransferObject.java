/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer;

import de.esolutions.fw.util.tracing.filetransfer.file.IExtendedFile;

class FileTransferManager$FileTransferObject {
    private final IExtendedFile file;
    private boolean ignore = false;
    private int lastBlock = -1;
    private boolean lastBlockFlagReceived = false;
    private boolean firstStatusRunDone = false;
    private byte operation = (byte)-1;

    public FileTransferManager$FileTransferObject(IExtendedFile iExtendedFile) {
        this.file = iExtendedFile;
    }

    static /* synthetic */ boolean access$000(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.ignore;
    }

    static /* synthetic */ boolean access$002(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, boolean bl) {
        fileTransferManager$FileTransferObject.ignore = bl;
        return fileTransferManager$FileTransferObject.ignore;
    }

    static /* synthetic */ byte access$102(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, byte by) {
        fileTransferManager$FileTransferObject.operation = by;
        return fileTransferManager$FileTransferObject.operation;
    }

    static /* synthetic */ IExtendedFile access$200(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.file;
    }

    static /* synthetic */ boolean access$302(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, boolean bl) {
        fileTransferManager$FileTransferObject.firstStatusRunDone = bl;
        return fileTransferManager$FileTransferObject.firstStatusRunDone;
    }

    static /* synthetic */ byte access$100(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.operation;
    }

    static /* synthetic */ boolean access$300(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.firstStatusRunDone;
    }

    static /* synthetic */ int access$400(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.lastBlock;
    }

    static /* synthetic */ boolean access$500(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject) {
        return fileTransferManager$FileTransferObject.lastBlockFlagReceived;
    }

    static /* synthetic */ boolean access$502(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, boolean bl) {
        fileTransferManager$FileTransferObject.lastBlockFlagReceived = bl;
        return fileTransferManager$FileTransferObject.lastBlockFlagReceived;
    }

    static /* synthetic */ int access$402(FileTransferManager$FileTransferObject fileTransferManager$FileTransferObject, int n) {
        fileTransferManager$FileTransferObject.lastBlock = n;
        return fileTransferManager$FileTransferObject.lastBlock;
    }
}

