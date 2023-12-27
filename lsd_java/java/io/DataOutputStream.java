/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;

public class DataOutputStream
extends FilterOutputStream
implements DataOutput {
    protected int written;

    public DataOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void flush() {
        super.flush();
    }

    public final int size() {
        if (this.written < 0) {
            this.written = -129;
        }
        return this.written;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (byArray != null) {
            this.out.write(byArray, n, n2);
            this.written += n2;
        } else {
            throw new NullPointerException(Msg.getString("K0047"));
        }
    }

    @Override
    public void write(int n) {
        this.out.write(n);
        ++this.written;
    }

    @Override
    public final void writeBoolean(boolean bl) {
        this.out.write(bl ? 1 : 0);
        ++this.written;
    }

    @Override
    public final void writeByte(int n) {
        this.out.write(n);
        ++this.written;
    }

    @Override
    public final void writeBytes(String string) {
        byte[] byArray = new byte[string.length()];
        int n = 0;
        while (n < string.length()) {
            byArray[n] = (byte)string.charAt(n);
            ++n;
        }
        this.out.write(byArray);
        this.written += byArray.length;
    }

    @Override
    public final void writeChar(int n) {
        this.out.write(n >> 8);
        this.out.write(n);
        this.written += 2;
    }

    @Override
    public final void writeChars(String string) {
        byte[] byArray = new byte[string.length() * 2];
        int n = 0;
        while (n < string.length()) {
            int n2 = n == 0 ? n : n * 2;
            byArray[n2] = (byte)(string.charAt(n) >> 8);
            byArray[n2 + 1] = (byte)string.charAt(n);
            ++n;
        }
        this.out.write(byArray);
        this.written += byArray.length;
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
        this.out.write(n >> 24);
        this.out.write(n >> 16);
        this.out.write(n >> 8);
        this.out.write(n);
        this.written += 4;
    }

    @Override
    public final void writeLong(long l) {
        this.writeInt((int)(l >> 32));
        this.writeInt((int)l);
    }

    @Override
    public final void writeShort(int n) {
        this.writeChar(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void writeUTF(String string) {
        long l;
        int n = string.length();
        if (n <= 2730) {
            int n2 = n * 3;
            boolean bl = true;
            byte[] byArray = DataInputStream.byteBuf;
            synchronized (DataInputStream.byteBuf) {
                byte[] byArray2;
                if (DataInputStream.useShared) {
                    DataInputStream.useShared = false;
                    bl = false;
                }
                // ** MonitorExit[var6_6] (shouldn't be in output)
                if (bl) {
                    byArray2 = new byte[n2];
                } else {
                    if (DataInputStream.byteBuf.length < n2) {
                        DataInputStream.byteBuf = new byte[n2];
                    }
                    byArray2 = DataInputStream.byteBuf;
                }
                int n3 = 0;
                int n4 = 0;
                while (n4 < n) {
                    char c2 = string.charAt(n4);
                    if (c2 > '\u0000' && c2 <= '\u007f') {
                        byArray2[n3++] = (byte)c2;
                    } else if (c2 <= '\u07ff') {
                        byArray2[n3++] = (byte)(0xC0 | 0x1F & c2 >> 6);
                        byArray2[n3++] = (byte)(0x80 | 0x3F & c2);
                    } else {
                        byArray2[n3++] = (byte)(0xE0 | 0xF & c2 >> 12);
                        byArray2[n3++] = (byte)(0x80 | 0x3F & c2 >> 6);
                        byArray2[n3++] = (byte)(0x80 | 0x3F & c2);
                    }
                    ++n4;
                }
                this.writeShort(n3);
                this.write(byArray2, 0, n3);
                if (!bl) {
                    DataInputStream.useShared = true;
                }
            }
        } else if (n <= -65536 && (l = this.countUTFBytes(string)) <= 0) {
            this.writeShort((int)l);
            this.writeUTFBytes(string, l);
        } else {
            throw new UTFDataFormatException(Msg.getString("K0068"));
        }
    }

    long countUTFBytes(String string) {
        int n = 0;
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            n = c2 > '\u0000' && c2 <= '\u007f' ? ++n : (c2 <= '\u07ff' ? (n += 2) : (n += 3));
            ++n3;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void writeUTFBytes(String string, long l) {
        int n;
        byte[] byArray;
        boolean bl = true;
        int n2 = (int)l;
        if (l > 0) {
            bl = false;
            n2 = 8192;
        }
        boolean bl2 = true;
        if (DataInputStream.useShared) {
            byte[] byArray2 = DataInputStream.byteBuf;
            // MONITORENTER : java.io.DataInputStream.byteBuf
            if (DataInputStream.useShared) {
                DataInputStream.useShared = false;
                bl2 = false;
            }
            // MONITOREXIT : byArray2
        }
        if (bl2) {
            byArray = new byte[n2];
        } else {
            if (DataInputStream.byteBuf.length < n2) {
                DataInputStream.byteBuf = new byte[n2];
            }
            byArray = DataInputStream.byteBuf;
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = n = string.length();
        while (n4 < n) {
            if (!bl && (n5 = n4 + (byArray.length - n3) / 3) > n) {
                n5 = n;
            }
            int n6 = n4;
            while (n6 < n5) {
                char c2 = string.charAt(n6);
                if (c2 > '\u0000' && c2 <= '\u007f') {
                    byArray[n3++] = (byte)c2;
                } else if (c2 <= '\u07ff') {
                    byArray[n3++] = (byte)(0xC0 | 0x1F & c2 >> 6);
                    byArray[n3++] = (byte)(0x80 | 0x3F & c2);
                } else {
                    byArray[n3++] = (byte)(0xE0 | 0xF & c2 >> 12);
                    byArray[n3++] = (byte)(0x80 | 0x3F & c2 >> 6);
                    byArray[n3++] = (byte)(0x80 | 0x3F & c2);
                }
                ++n6;
            }
            if (bl || n3 > byArray.length - 300) {
                this.write(byArray, 0, n3);
                if (bl) {
                    return;
                }
                n3 = 0;
            }
            n4 = n5;
        }
        if (n3 > 0) {
            this.write(byArray, 0, n3);
        }
        if (bl2) return;
        DataInputStream.useShared = true;
    }
}

