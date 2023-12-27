/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayData {
    private static final boolean IGNORE_FLAGS = Boolean.getBoolean("ByteArrayData.IGNORE_FLAGS");
    public static final String DEFAULT_ENCODING;
    private String charset;
    private int nrStrings;
    private int[] offset;
    private byte[] data;
    private String[] cache;
    private String[] altCache;
    private byte[] flags = null;

    public ByteArrayData(String string) {
        this.charset = string;
    }

    public ByteArrayData() {
        this("UTF-8");
    }

    public ByteArrayData(InputStream inputStream, String string) {
        this(string);
        this.read(inputStream);
    }

    public ByteArrayData(InputStream inputStream) {
        this(inputStream, "UTF-8");
    }

    public ByteArrayData(String[] stringArray) {
        this(stringArray, stringArray);
    }

    public ByteArrayData(String[] stringArray, String[] stringArray2) {
        this("UTF-8");
        this.cache = stringArray;
        this.altCache = stringArray2;
        this.flags = null;
    }

    public ByteArrayData(String[] stringArray, String[] stringArray2, byte[] byArray) {
        this(stringArray, stringArray2);
        this.flags = byArray;
    }

    final void clearCache() {
        this.cache = new String[this.nrStrings];
        this.altCache = new String[this.nrStrings];
    }

    public final void read(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.nrStrings = dataInputStream.readInt();
        if (this.nrStrings >= 0) {
            this.offset = new int[this.nrStrings + 1];
            for (int i2 = 0; i2 <= this.nrStrings; ++i2) {
                this.offset[i2] = dataInputStream.readInt();
            }
            if (this.offset[this.nrStrings] > 0) {
                this.data = new byte[this.offset[this.nrStrings]];
                dataInputStream.readFully(this.data);
                this.clearCache();
            } else if (this.offset[this.nrStrings] == 0) {
                this.data = new byte[0];
                this.clearCache();
            } else {
                dataInputStream.close();
                throw new IOException("Stream data corrupted!");
            }
            if (!IGNORE_FLAGS) {
                try {
                    this.flags = new byte[this.nrStrings];
                    if (this.nrStrings > 0) {
                        dataInputStream.readFully(this.flags);
                    }
                }
                catch (IOException iOException) {
                    this.flags = null;
                }
            }
        } else {
            dataInputStream.close();
            throw new IOException("Stream data corrupted!");
        }
        dataInputStream.close();
    }

    private static byte[] createBytesForEntry(int n, String[] stringArray, String[] stringArray2, String string) {
        byte[] byArray = (stringArray != null && stringArray.length > n && stringArray[n] != null ? stringArray[n] : "").getBytes(string);
        if (stringArray2 != null && stringArray2.length > n && stringArray2[n] != null) {
            byte[] byArray2 = stringArray2[n].getBytes(string);
            byte[] byArray3 = new byte[4 + byArray2.length + byArray.length];
            int n2 = byArray2.length;
            System.arraycopy((Object)byArray2, 0, (Object)byArray3, 4, byArray2.length);
            System.arraycopy((Object)byArray, 0, (Object)byArray3, 4 + n2, byArray.length);
            byArray3[0] = (byte)(n2 >> 24 & 0xFF);
            byArray3[1] = (byte)(n2 >> 16 & 0xFF);
            byArray3[2] = (byte)(n2 >> 8 & 0xFF);
            byArray3[3] = (byte)(n2 & 0xFF);
            if (byArray3[0] != 0) {
                throw new IllegalArgumentException("Encoding failed! Alt String[] Entry to large ( >= 2^^24 Bytes )");
            }
            return byArray3;
        }
        if (byArray.length > 0 && byArray[0] == 0) {
            throw new IllegalArgumentException("Encoding failed! 0 Byte at start of String ???");
        }
        return byArray;
    }

    public static final void write(OutputStream outputStream, String[] stringArray) {
        ByteArrayData.write(outputStream, stringArray, "UTF-8");
    }

    public static final void write(OutputStream outputStream, String[] stringArray, String[] stringArray2) {
        ByteArrayData.write(outputStream, stringArray, stringArray2, "UTF-8");
    }

    public static final void write(OutputStream outputStream, String[] stringArray, String string) {
        ByteArrayData.write(outputStream, stringArray, (String[])null, string);
    }

    public static final void write(OutputStream outputStream, String[] stringArray, byte[] byArray, String string) {
        ByteArrayData.write(outputStream, stringArray, null, byArray, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void write(OutputStream outputStream, String[] stringArray, String[] stringArray2, String string) {
        if (outputStream == null) {
            return;
        }
        int n = stringArray.length;
        int n2 = 0;
        byte[][] byArrayArray = new byte[n][];
        int[] nArray = new int[n + 1];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = n2;
            byArrayArray[i2] = ByteArrayData.createBytesForEntry(i2, stringArray, stringArray2, string);
            n2 += byArrayArray[i2].length;
        }
        nArray[n] = n2;
        DataOutputStream dataOutputStream = null;
        try {
            int n3;
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(n);
            for (n3 = 0; n3 <= n; ++n3) {
                dataOutputStream.writeInt(nArray[n3]);
            }
            for (n3 = 0; n3 < n; ++n3) {
                dataOutputStream.write(byArrayArray[n3]);
            }
        }
        finally {
            if (dataOutputStream != null) {
                dataOutputStream.flush();
            }
        }
    }

    public static void write(OutputStream outputStream, String[] stringArray, String[] stringArray2, byte[] byArray, String string) {
        ByteArrayData.write(outputStream, stringArray, stringArray2, string);
        if (outputStream != null && byArray != null) {
            if (byArray.length != stringArray.length) {
                throw new IllegalArgumentException("flags must have same size as data!");
            }
            outputStream.write(byArray);
            outputStream.flush();
        }
    }

    private int getUByte(int n) {
        return this.data[n] & 0xFF;
    }

    private void fillCache(int n) {
        if (this.cache[n] == null) {
            int n2 = this.offset[n + 1];
            int n3 = this.offset[n];
            if (n2 == n3) {
                this.cache[n] = "";
                this.altCache[n] = "";
            } else if (this.data[n3] != 0) {
                this.cache[n] = new String(this.data, n3, n2 - n3, this.charset);
                this.altCache[n] = this.cache[n];
            } else {
                int n4 = this.getUByte(n3 + 1);
                n4 = (n4 << 8) + this.getUByte(n3 + 2);
                n4 = (n4 << 8) + this.getUByte(n3 + 3);
                this.altCache[n] = new String(this.data, n3 + 4, n4, this.charset);
                this.cache[n] = new String(this.data, n3 + 4 + n4, n2 - n3 - 4 - n4, this.charset);
            }
        }
    }

    private void fillCache() {
        for (int i2 = 0; i2 < this.nrStrings; ++i2) {
            this.fillCache(i2);
        }
    }

    public String getString(int n) {
        if (n >= 0 && n < this.cache.length) {
            this.fillCache(n);
            return this.cache[n];
        }
        return null;
    }

    public String getAltString(int n) {
        if (n >= 0 && n < this.cache.length) {
            this.fillCache(n);
            return this.altCache[n];
        }
        return null;
    }

    public String[] getStringArray() {
        this.fillCache();
        return this.cache;
    }

    public String[] getAltStringArray() {
        this.fillCache();
        return this.altCache;
    }

    public byte[] getFlags() {
        return this.flags;
    }

    public byte getFlag(int n) {
        if (this.flags != null && n >= 0 && n < this.flags.length) {
            return this.flags[n];
        }
        return 0;
    }
}

