/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.DataInput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class DataInputStream
extends FilterInputStream
implements DataInput {
    static final int MAX_BUF_SIZE;
    private static final boolean useNative;
    static boolean useShared;
    static byte[] byteBuf;
    static char[] charBuf;
    static /* synthetic */ Class class$0;

    static {
        useNative = VM.useNatives();
        useShared = true;
        byteBuf = new byte[0];
        charBuf = new char[0];
    }

    public DataInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override
    public final int read(byte[] byArray) {
        return this.in.read(byArray, 0, byArray.length);
    }

    @Override
    public final int read(byte[] byArray, int n, int n2) {
        return this.in.read(byArray, n, n2);
    }

    @Override
    public final boolean readBoolean() {
        int n = this.in.read();
        if (n >= 0) {
            return n != 0;
        }
        throw new EOFException();
    }

    @Override
    public final byte readByte() {
        int n = this.in.read();
        if (n >= 0) {
            return (byte)n;
        }
        throw new EOFException();
    }

    @Override
    public final char readChar() {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (char)((n2 << 8) + n);
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
            int n3 = this.in.read(byArray, n, n2);
            if (n3 < 0) throw new EOFException();
            n += n3;
            n2 -= n3;
        }
    }

    @Override
    public final int readInt() {
        int n;
        int n2;
        int n3;
        int n4 = this.in.read();
        if ((n4 | (n3 = this.in.read()) | (n2 = this.in.read()) | (n = this.in.read())) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }

    @Override
    public final String readLine() {
        StringBuffer stringBuffer = new StringBuffer(80);
        boolean bl = false;
        block7: while (true) {
            int n = this.in.read();
            switch (n) {
                case -1: {
                    if (stringBuffer.length() == 0 && !bl) {
                        return null;
                    }
                    return stringBuffer.toString();
                }
                case 13: {
                    if (bl) {
                        ((PushbackInputStream)this.in).unread(n);
                        return stringBuffer.toString();
                    }
                    bl = true;
                    Class clazz = super.getClass();
                    Class clazz2 = class$0;
                    if (clazz2 == null) {
                        try {
                            clazz2 = Class.forName("java.io.PushbackInputStream");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    if (clazz == clazz2) continue block7;
                    this.in = new PushbackInputStream(this.in);
                    continue block7;
                }
                case 10: {
                    return stringBuffer.toString();
                }
            }
            if (bl) {
                ((PushbackInputStream)this.in).unread(n);
                return stringBuffer.toString();
            }
            stringBuffer.append((char)n);
        }
    }

    @Override
    public final long readLong() {
        int n;
        int n2;
        int n3;
        int n4 = this.readInt();
        int n5 = this.in.read();
        if ((n5 | (n3 = this.in.read()) | (n2 = this.in.read()) | (n = this.in.read())) >= 0) {
            return ((long)n4 << 32) + ((long)n5 << 24) + (long)(n3 << 16) + (long)(n2 << 8) + (long)n;
        }
        throw new EOFException();
    }

    @Override
    public final short readShort() {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (short)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    @Override
    public final int readUnsignedByte() {
        int n = this.in.read();
        if (n >= 0) {
            return n;
        }
        throw new EOFException();
    }

    @Override
    public final int readUnsignedShort() {
        int n;
        int n2 = this.in.read();
        if ((n2 | (n = this.in.read())) >= 0) {
            return (n2 << 8) + n;
        }
        throw new EOFException();
    }

    @Override
    public final String readUTF() {
        int n = this.readUnsignedShort();
        return this.decodeUTF(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    String decodeUTF(int n) {
        byte[] byArray;
        Object object;
        char[] cArray = null;
        boolean bl = true;
        if (n <= 8192 && useShared) {
            object = byteBuf;
            // MONITORENTER : byteBuf
            if (useShared) {
                useShared = false;
                bl = false;
            }
            // MONITOREXIT : object
        }
        if (bl) {
            byArray = new byte[n];
            if (!useNative) {
                cArray = new char[n];
            }
        } else {
            if (byteBuf.length < n) {
                byteBuf = new byte[n];
            }
            if (!useNative && charBuf.length < n) {
                charBuf = new char[n];
            }
            byArray = byteBuf;
            cArray = charBuf;
        }
        this.readFully(byArray, 0, n);
        object = useNative ? (Object)Util.convertFromUTF8(byArray, 0, n) : (Object)Util.convertUTF8WithBuf(byArray, cArray, 0, n);
        if (bl) return object;
        useShared = true;
        return object;
    }

    public static final String readUTF(DataInput dataInput) {
        return dataInput.readUTF();
    }

    @Override
    public final int skipBytes(int n) {
        long l;
        int n2 = 0;
        while (n2 < n && (l = this.in.skip(n - n2)) != 0L) {
            n2 = (int)((long)n2 + l);
        }
        if (n2 >= 0) {
            return n2;
        }
        throw new EOFException();
    }
}

