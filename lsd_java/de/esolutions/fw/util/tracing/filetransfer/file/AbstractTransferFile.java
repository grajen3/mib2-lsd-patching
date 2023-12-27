/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.IExtendedFile;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferConstants;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils$IdGenerator;

public abstract class AbstractTransferFile
implements IExtendedFile {
    protected boolean writable;
    protected boolean open = false;
    protected String remotePath;
    protected String localPath;
    protected long size = 0L;
    protected long completeSize = 0L;
    protected byte flag;
    protected byte userFlag;
    protected long timestamp;
    protected byte hashType;
    protected byte[] hash;
    protected String filename;
    protected boolean hashValid;
    protected long offset;
    protected FileTransferError errorObject;
    protected boolean error;
    protected long id;

    public AbstractTransferFile(String string) {
        this.localPath = string;
        this.id = FileTransferUtils$IdGenerator.getUniqueId();
    }

    @Override
    public abstract boolean open(boolean bl) {
    }

    @Override
    public abstract boolean write(byte[] byArray) {
    }

    @Override
    public abstract byte[] read(int n) {
    }

    @Override
    public abstract boolean close() {
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setError(FileTransferError fileTransferError) {
        this.error = true;
        this.errorObject = fileTransferError;
    }

    @Override
    public void setCompleteSize(long l) {
        this.completeSize = l;
    }

    @Override
    public void setSize(long l) {
        this.size = l;
    }

    @Override
    public void setPath(String string) {
        this.remotePath = string;
        this.filename = FileTransferUtils.getFileNameFromPath(string, FileTransferUtils.getSeperator(string));
    }

    @Override
    public void setFlag(byte by) {
        this.flag = by;
    }

    @Override
    public void setTimestamp(long l) {
        this.timestamp = l;
    }

    @Override
    public void setHashType(byte by) {
        this.hashType = by;
    }

    @Override
    public void setHash(byte[] byArray) {
        this.hash = byArray;
    }

    @Override
    public void setValidHash(boolean bl) {
        this.hashValid = bl;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public long getCompleteSize() {
        return this.completeSize;
    }

    public byte getFlag() {
        return this.flag;
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }

    public byte getHashType() {
        return this.hashType;
    }

    public byte[] getHash() {
        return this.hash;
    }

    @Override
    public String getFilename() {
        return this.filename;
    }

    @Override
    public boolean isHashValid() {
        return this.hashValid;
    }

    @Override
    public String getLocalPath() {
        return this.localPath;
    }

    @Override
    public String getRemotePath() {
        return this.remotePath;
    }

    @Override
    public boolean isAvailable() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_AVAILABLE) == FileTransferConstants.FLAG_STATUS_AVAILABLE;
    }

    @Override
    public boolean isFile() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_IS_FILE) == FileTransferConstants.FLAG_STATUS_IS_FILE;
    }

    @Override
    public boolean isReadable() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_READABLE) == FileTransferConstants.FLAG_STATUS_READABLE;
    }

    @Override
    public boolean hasError() {
        return (this.flag & FileTransferConstants.FLAG_STATUS_ERROR) == FileTransferConstants.FLAG_STATUS_ERROR || this.error;
    }

    @Override
    public boolean isUpload() {
        return (this.flag & FileTransferConstants.FLAG_FILE_UPLOAD) == FileTransferConstants.FLAG_FILE_UPLOAD;
    }

    @Override
    public FileTransferError getError() {
        return this.errorObject;
    }

    @Override
    public long getOffset() {
        return this.offset;
    }

    @Override
    public byte[] getFileHash() {
        return this.hash;
    }

    @Override
    public void setUserFlag(byte by) {
        this.userFlag = by;
    }

    @Override
    public byte getUserFlag() {
        return this.userFlag;
    }

    public String toString() {
        String string = new StringBuffer().append("TransferFile[class=").append(super.getClass().getName()).append(",filename=").append(this.filename).append(",localPath=").append(this.localPath).append(",remotePath=").append(this.remotePath).append(",flag=").append(this.flag).append(",size=").append(this.size).append(",completeSize").append(this.completeSize).append("]").toString();
        return string;
    }
}

