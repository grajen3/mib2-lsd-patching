/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.filetransfer.file;

import de.esolutions.fw.util.tracing.filetransfer.file.AbstractTransferFile;

public class MemoryTransferFile
extends AbstractTransferFile {
    private byte[] data = null;

    public MemoryTransferFile(String string) {
        super(string);
        this.localPath = string;
        this.open = false;
        this.data = new byte[0];
        this.size = 0L;
        this.completeSize = 0L;
        this.error = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean open(boolean bl) {
        MemoryTransferFile memoryTransferFile = this;
        synchronized (memoryTransferFile) {
            if (!this.open) {
                this.open = true;
                this.offset = 0L;
                this.writable = bl;
                this.error = false;
                this.errorObject = null;
                if (bl) {
                    this.data = new byte[0];
                } else {
                    this.size = this.completeSize;
                }
                return true;
            }
            return false;
        }
    }

    public void setLocalPath(String string) {
        this.localPath = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean write(byte[] byArray) {
        MemoryTransferFile memoryTransferFile = this;
        synchronized (memoryTransferFile) {
            if (this.open && this.writable) {
                if (this.size == 0L) {
                    this.data = byArray;
                    this.size = this.data.length;
                } else {
                    this.completeSize = this.size = (long)(this.data.length + byArray.length);
                    byte[] byArray2 = new byte[(int)this.size];
                    System.arraycopy((Object)this.data, 0, (Object)byArray2, 0, this.data.length);
                    System.arraycopy((Object)byArray, 0, (Object)byArray2, this.data.length, byArray.length);
                    this.data = byArray2;
                }
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte[] read(int n) {
        MemoryTransferFile memoryTransferFile = this;
        synchronized (memoryTransferFile) {
            if (this.open && !this.writable) {
                int n2 = n;
                if (this.offset >= this.size) {
                    return new byte[0];
                }
                if (this.offset + (long)n2 > this.size) {
                    n2 = (int)(this.size - this.offset);
                }
                byte[] byArray = new byte[n2];
                try {
                    System.arraycopy((Object)this.data, (int)this.offset, (Object)byArray, 0, n2);
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    this.offset = this.size;
                    return new byte[0];
                }
                this.offset += (long)n2;
                return byArray;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean close() {
        MemoryTransferFile memoryTransferFile = this;
        synchronized (memoryTransferFile) {
            if (this.open) {
                this.open = false;
                return true;
            }
            return false;
        }
    }
}

