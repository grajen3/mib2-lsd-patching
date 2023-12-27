/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.FileTransferError;
import de.esolutions.fw.util.tracing.filetransfer.file.AbstractTransferFile;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RealTransferFile
extends AbstractTransferFile {
    private RandomAccessFile randomAccessFile = null;
    private File fileHandler = null;

    public RealTransferFile(String string) {
        super(string);
        this.offset = 0L;
        this.size = 0L;
        this.completeSize = 0L;
        this.open = false;
        this.localPath = string;
        this.error = false;
        this.errorObject = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean open(boolean bl) {
        RealTransferFile realTransferFile = this;
        synchronized (realTransferFile) {
            if (!this.open) {
                this.writable = bl;
                try {
                    this.fileHandler = new File(this.localPath);
                    if (bl) {
                        if (this.fileHandler.exists() && !this.fileHandler.delete()) {
                            return false;
                        }
                        String string = FileTransferUtils.getPath(this.fileHandler.getAbsolutePath(), File.separator);
                        new File(string).mkdirs();
                        this.randomAccessFile = new RandomAccessFile(this.fileHandler, "rw");
                    } else {
                        this.randomAccessFile = new RandomAccessFile(this.fileHandler, "r");
                        this.size = this.randomAccessFile.length();
                    }
                    this.offset = 0L;
                    this.errorObject = null;
                    this.error = false;
                    this.open = true;
                    return true;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    this.errorObject = new FileTransferError(iOException);
                    this.closeOnError();
                    return false;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean write(byte[] byArray) {
        RealTransferFile realTransferFile = this;
        synchronized (realTransferFile) {
            if (this.open && this.writable) {
                try {
                    this.randomAccessFile.write(byArray);
                    this.size += (long)byArray.length;
                    return true;
                }
                catch (IOException iOException) {
                    this.errorObject = new FileTransferError(iOException);
                    this.closeOnError();
                    return false;
                }
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte[] read(int n) {
        RealTransferFile realTransferFile = this;
        synchronized (realTransferFile) {
            if (this.open && !this.writable) {
                if (this.offset >= this.size) {
                    return new byte[0];
                }
                byte[] byArray = null;
                try {
                    int n2 = n;
                    if (this.offset + (long)n > this.size) {
                        n2 = (int)(this.size - this.offset);
                    }
                    byArray = new byte[n2];
                    this.randomAccessFile.readFully(byArray);
                    this.offset = this.randomAccessFile.getFilePointer();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                return byArray;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void closeOnError() {
        RealTransferFile realTransferFile = this;
        synchronized (realTransferFile) {
            try {
                this.randomAccessFile.close();
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (this.writable && this.fileHandler != null) {
                if (!this.fileHandler.delete()) {
                    return;
                }
                this.fileHandler = null;
            }
            this.open = false;
            this.error = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean close() {
        RealTransferFile realTransferFile = this;
        synchronized (realTransferFile) {
            if (this.open) {
                try {
                    this.open = false;
                    this.offset = 0L;
                    this.randomAccessFile.close();
                    if (this.writable && this.fileHandler != null && (this.filename == null || this.filename != null && this.filename.length() > 0)) {
                        String string = new StringBuffer().append(FileTransferUtils.getPath(this.localPath, FileTransferUtils.getSeperator(this.localPath))).append(this.filename).toString();
                        File file = new File(string = FileTransferUtils.findAvailableFileName(string));
                        if (file.exists() && !file.delete()) {
                            return false;
                        }
                        if (!this.fileHandler.renameTo(file)) {
                            return false;
                        }
                        this.fileHandler = file;
                        this.localPath = string;
                    }
                    return true;
                }
                catch (Exception exception) {
                    this.error = true;
                    this.errorObject = new FileTransferError(exception);
                    exception.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void setError(FileTransferError fileTransferError) {
        super.setError(fileTransferError);
        this.closeOnError();
    }
}

