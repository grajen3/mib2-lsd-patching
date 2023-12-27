/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UTFDataFormatException;

public class RandomAccessFile
implements DataInput,
DataOutput {
    private static final int WRITABLE;
    private static final int SYNC;
    FileDescriptor fd;
    private boolean syncMetadata = false;

    static {
        RandomAccessFile.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public RandomAccessFile(File file, String string) {
        if (string.equals("r") || string.equals("rw") || string.equals("rws") || string.equals("rwd")) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(file.getPath());
                if (!string.equals("r")) {
                    securityManager.checkWrite(file.getPath());
                }
            }
            this.fd = new FileDescriptor();
            if (this.openImpl2(file.properPath(true), this.getOptions(string)) != 0) {
                throw new FileNotFoundException(file.getPath());
            }
            if (this.syncMetadata) {
                try {
                    this.fd.sync();
                }
                catch (IOException iOException) {}
            }
        } else {
            throw new IllegalArgumentException(Msg.getString("K03bb"));
        }
    }

    public RandomAccessFile(String string, String string2) {
        if (string2.equals("r") || string2.equals("rw") || string2.equals("rws") || string2.equals("rwd")) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(string);
                if (!string2.equals("r")) {
                    securityManager.checkWrite(string);
                }
            }
            this.fd = new FileDescriptor();
            File file = new File(string);
            if (this.openImpl2(file.properPath(true), this.getOptions(string2)) != 0) {
                throw new FileNotFoundException(string);
            }
            if (this.syncMetadata) {
                try {
                    this.fd.sync();
                }
                catch (IOException iOException) {}
            }
        } else {
            throw new IllegalArgumentException(Msg.getString("K03bb"));
        }
    }

    private int getOptions(String string) {
        int n = 0;
        if (!string.equals("r")) {
            n |= 1;
        }
        if (string.equals("rwd")) {
            n |= 2;
        } else if (string.equals("rws")) {
            this.syncMetadata = true;
        }
        return n;
    }

    public void close() {
        this.closeImpl();
    }

    private native void closeImpl() {
    }

    public final FileDescriptor getFD() {
        return this.fd;
    }

    public native long getFilePointer() {
    }

    public native long length() {
    }

    private native int openImpl2(byte[] byArray, int n) {
    }

    public int read() {
        if (this.fd != null) {
            return this.readByteImpl(this.fd.descriptor);
        }
        throw new IOException();
    }

    private native int readByteImpl(long l) {
    }

    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) {
        if (this.fd != null) {
            return this.readImpl(byArray, n, n2, this.fd.descriptor);
        }
        throw new IOException();
    }

    private native int readImpl(byte[] byArray, int n, int n2, long l) {
    }

    @Override
    public final boolean readBoolean() {
        int n = this.read();
        if (n >= 0) {
            return n != 0;
        }
        throw new EOFException();
    }

    @Override
    public final byte readByte() {
        int n = this.read();
        if (n >= 0) {
            return (byte)n;
        }
        throw new EOFException();
    }

    @Override
    public final char readChar() {
        byte[] byArray = new byte[2];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return (char)(((byArray[0] & 0xFF) << 8) + (byArray[1] & 0xFF));
        }
        throw new EOFException();
    }

    @Override
    public final double readDouble() {
        return Double.longBitsToDouble((long)this.readLong());
    }

    @Override
    public final float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public final void readFully(byte[] byArray) {
        this.readFully(byArray, 0, byArray.length);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public final void readFully(byte[] byArray, int n, int n2) {
        if (byArray == null) throw new NullPointerException(Msg.getString("K0047"));
        if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) throw new IndexOutOfBoundsException();
        while (n2 > 0) {
            int n3 = this.read(byArray, n, n2);
            if (n3 < 0) throw new EOFException();
            n += n3;
            n2 -= n3;
        }
    }

    @Override
    public final int readInt() {
        byte[] byArray = new byte[4];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return ((byArray[0] & 0xFF) << 24) + ((byArray[1] & 0xFF) << 16) + ((byArray[2] & 0xFF) << 8) + (byArray[3] & 0xFF);
        }
        throw new EOFException();
    }

    @Override
    public final String readLine() {
        StringBuffer stringBuffer = new StringBuffer(80);
        boolean bl = false;
        long l = 0L;
        block5: while (true) {
            int n = this.read();
            switch (n) {
                case -1: {
                    return stringBuffer.length() != 0 ? stringBuffer.toString() : null;
                }
                case 13: {
                    if (bl) {
                        this.seek(l);
                        return stringBuffer.toString();
                    }
                    bl = true;
                    l = this.getFilePointer();
                    continue block5;
                }
                case 10: {
                    return stringBuffer.toString();
                }
            }
            if (bl) {
                this.seek(l);
                return stringBuffer.toString();
            }
            stringBuffer.append((char)n);
        }
    }

    @Override
    public final long readLong() {
        byte[] byArray = new byte[8];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return ((long)(((byArray[0] & 0xFF) << 24) + ((byArray[1] & 0xFF) << 16) + ((byArray[2] & 0xFF) << 8) + (byArray[3] & 0xFF)) << 32) + ((long)(byArray[4] & 0xFF) << 24) + (long)((byArray[5] & 0xFF) << 16) + (long)((byArray[6] & 0xFF) << 8) + (long)(byArray[7] & 0xFF);
        }
        throw new EOFException();
    }

    @Override
    public final short readShort() {
        byte[] byArray = new byte[2];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return (short)(((byArray[0] & 0xFF) << 8) + (byArray[1] & 0xFF));
        }
        throw new EOFException();
    }

    @Override
    public final int readUnsignedByte() {
        int n = this.read();
        if (n >= 0) {
            return n;
        }
        throw new EOFException();
    }

    @Override
    public final int readUnsignedShort() {
        byte[] byArray = new byte[2];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return ((byArray[0] & 0xFF) << 8) + (byArray[1] & 0xFF);
        }
        throw new EOFException();
    }

    @Override
    public final String readUTF() {
        int n = this.readUnsignedShort();
        if (n == 0) {
            return new String();
        }
        byte[] byArray = new byte[n];
        if (this.read(byArray, 0, byArray.length) == byArray.length) {
            return Util.convertFromUTF8(byArray, 0, n);
        }
        throw new EOFException();
    }

    public native void seek(long l) {
    }

    public void setLength(long l) {
        this.setLengthImpl(l);
        if (this.syncMetadata) {
            this.fd.sync();
        }
    }

    private native void setLengthImpl(long l) {
    }

    @Override
    public int skipBytes(int n) {
        if (n > 0) {
            long l;
            long l2 = this.getFilePointer();
            int n2 = (int)(l2 + (long)n > (l = this.length()) ? l - l2 : (long)n);
            this.seek(l2 + (long)n2);
            return n2;
        }
        return 0;
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.fd != null) {
            this.writeImpl(byArray, n, n2, this.fd.descriptor);
            if (this.syncMetadata) {
                this.fd.sync();
            }
        } else {
            throw new IOException();
        }
    }

    private native void writeImpl(byte[] byArray, int n, int n2, long l) {
    }

    @Override
    public void write(int n) {
        if (this.fd == null) {
            throw new IOException();
        }
        this.writeByteImpl(n, this.fd.descriptor);
    }

    private native void writeByteImpl(int n, long l) {
    }

    @Override
    public final void writeBoolean(boolean bl) {
        this.write(bl ? 1 : 0);
    }

    @Override
    public final void writeByte(int n) {
        this.write(n & 0xFF);
    }

    @Override
    public final void writeBytes(String string) {
        byte[] byArray = new byte[string.length()];
        int n = 0;
        while (n < string.length()) {
            byArray[n] = (byte)(string.charAt(n) & 0xFF);
            ++n;
        }
        this.write(byArray);
    }

    @Override
    public final void writeChar(int n) {
        byte[] byArray = new byte[]{(byte)(n >> 8), (byte)n};
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public final void writeChars(String string) {
        byte[] byArray = new byte[string.length() * 2];
        int n = 0;
        while (n < string.length()) {
            int n2 = n == 0 ? n : n * 2;
            byArray[n2] = (byte)(string.charAt(n) >> 8 & 0xFF);
            byArray[n2 + 1] = (byte)(string.charAt(n) & 0xFF);
            ++n;
        }
        this.write(byArray);
    }

    @Override
    public final void writeDouble(double d2) {
        this.writeLong(Double.doubleToLongBits((double)d2));
    }

    @Override
    public final void writeFloat(float f2) {
        this.writeInt(Float.floatToIntBits(f2));
    }

    @Override
    public final void writeInt(int n) {
        byte[] byArray = new byte[]{(byte)(n >> 24), (byte)(n >> 16), (byte)(n >> 8), (byte)n};
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public final void writeLong(long l) {
        byte[] byArray = new byte[8];
        int n = (int)(l >> 32);
        byArray[0] = (byte)(n >> 24);
        byArray[1] = (byte)(n >> 16);
        byArray[2] = (byte)(n >> 8);
        byArray[3] = (byte)n;
        byArray[4] = (byte)(l >> 24);
        byArray[5] = (byte)(l >> 16);
        byArray[6] = (byte)(l >> 8);
        byArray[7] = (byte)l;
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public final void writeShort(int n) {
        this.writeChar(n);
    }

    @Override
    public final void writeUTF(String string) {
        byte[] byArray;
        int n;
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        while (n4 < n3) {
            n = string.charAt(n4);
            n2 = n > 0 && n <= 127 ? ++n2 : (n <= 2047 ? (n2 += 2) : (n2 += 3));
            ++n4;
        }
        if (n2 <= -65536) {
            byArray = new byte[n2 + 2];
            n = 2;
            int n5 = 0;
            while (n5 < n3) {
                char c2 = string.charAt(n5);
                if (c2 > '\u0000' && c2 <= '\u007f') {
                    byArray[n++] = (byte)c2;
                } else if (c2 <= '\u07ff') {
                    byArray[n++] = (byte)(0xC0 | 0x1F & c2 >> 6);
                    byArray[n++] = (byte)(0x80 | 0x3F & c2);
                } else {
                    byArray[n++] = (byte)(0xE0 | 0xF & c2 >> 12);
                    byArray[n++] = (byte)(0x80 | 0x3F & c2 >> 6);
                    byArray[n++] = (byte)(0x80 | 0x3F & c2);
                }
                ++n5;
            }
        } else {
            throw new UTFDataFormatException(Msg.getString("K0068"));
        }
        byArray[0] = (byte)(n2 >> 8);
        byArray[1] = (byte)n2;
        this.write(byArray);
    }
}

