/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.BitArray;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.BitSet;
import java.util.zip.CRC32;

public final class DebugDataReader {
    private final InputStream stream;
    private long seek;
    private CRC32 crc;
    private StringBuffer string;

    private DebugDataReader(InputStream inputStream) {
        this.stream = inputStream instanceof BufferedInputStream ? inputStream : new BufferedInputStream(inputStream);
        this.seek = 0L;
        this.crc = new CRC32();
    }

    private Object[] readDataInternal() {
        int n = this.readHeader();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = this.readArray(true);
        }
        this.readFooter();
        return objectArray;
    }

    private Object[] readDataInternal(BitSet bitSet) {
        int n = this.readHeader();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = this.readArray(bitSet.get(i2));
        }
        this.readFooter();
        return objectArray;
    }

    private Object[] readDataInternal(BitArray bitArray) {
        int n = this.readHeader();
        Object[] objectArray = new Object[n];
        for (int i2 = 0; i2 < n; ++i2) {
            objectArray[i2] = this.readArray(bitArray.get(i2));
        }
        this.readFooter();
        return objectArray;
    }

    private int readHeader() {
        int n = this.readUnsignedShort();
        if (n != 17476) {
            throw this.errorCorrupt("Stream is not a DebugData stream.");
        }
        int n2 = this.readUnsignedShort();
        return n2;
    }

    private void readFooter() {
        int n = (int)this.crc.getValue();
        int n2 = this.readInt();
        if (n2 != n) {
            throw this.errorCorrupt("Invalid checksum.");
        }
    }

    private Object readArray(boolean bl) {
        int n = this.readUnsignedByte();
        int n2 = n & 0x3F;
        int n3 = this.readArrayLenght(n & 0xC0);
        switch (n2) {
            case 0: {
                return null;
            }
            case 1: {
                return bl ? this.readBooleanArray(n3) : (boolean[])this.skip(4 * BitArray.getInternDataSize(n3));
            }
            case 2: {
                return bl ? this.readByteArray(n3) : (byte[])this.skip(1 * n3);
            }
            case 3: {
                return bl ? this.readCharArray(n3) : (char[])this.skip(2 * n3);
            }
            case 4: {
                return bl ? this.readShortArray(n3) : (short[])this.skip(2 * n3);
            }
            case 5: {
                return bl ? this.readIntArray(n3) : (int[])this.skip(4 * n3);
            }
            case 6: {
                return bl ? this.readLongArray(n3) : (long[])this.skip(8 * n3);
            }
            case 7: {
                return bl ? this.readFloatArray(n3) : (float[])this.skip(4 * n3);
            }
            case 8: {
                return bl ? this.readDoubleArray(n3) : (double[])this.skip(8 * n3);
            }
            case 9: {
                return bl ? this.readStringArray(n3) : this.skipStringArray(n3);
            }
            case 10: {
                return bl ? this.readBitArray(n3) : this.skip(4 * BitArray.getInternDataSize(n3));
            }
        }
        throw this.errorCorrupt("Invalid byte (unsupported data type) found.");
    }

    private int readArrayLenght(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 64: {
                return this.readUnsignedByte();
            }
            case 128: {
                return this.readUnsignedShort();
            }
            case 192: {
                return this.readLenghtInt();
            }
        }
        throw this.errorCorrupt("Invalid byte (unsupported array length) found.");
    }

    private Object skip(int n) {
        this.skipBytes(n);
        return null;
    }

    private BitArray readBitArray(int n) {
        int[] nArray = this.readIntArray(BitArray.getInternDataSize(n));
        return new BitArray(n, nArray);
    }

    private boolean[] readBooleanArray(int n) {
        boolean[] blArray = new boolean[n];
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            if ((n2 <<= 1) == 0) {
                n2 = 1;
                n3 = this.readInt();
            }
            blArray[i2] = (n3 & n2) != 0;
        }
        return blArray;
    }

    private byte[] readByteArray(int n) {
        byte[] byArray = this.readBytes(n);
        return byArray;
    }

    private char[] readCharArray(int n) {
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = this.readChar();
        }
        return cArray;
    }

    private short[] readShortArray(int n) {
        short[] sArray = new short[n];
        for (int i2 = 0; i2 < n; ++i2) {
            sArray[i2] = this.readShort();
        }
        return sArray;
    }

    private int[] readIntArray(int n) {
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < n; ++i2) {
            nArray[i2] = this.readInt();
        }
        return nArray;
    }

    private long[] readLongArray(int n) {
        long[] lArray = new long[n];
        for (int i2 = 0; i2 < n; ++i2) {
            lArray[i2] = this.readLong();
        }
        return lArray;
    }

    private float[] readFloatArray(int n) {
        float[] fArray = new float[n];
        for (int i2 = 0; i2 < n; ++i2) {
            fArray[i2] = this.readFloat();
        }
        return fArray;
    }

    private double[] readDoubleArray(int n) {
        double[] dArray = new double[n];
        for (int i2 = 0; i2 < n; ++i2) {
            dArray[i2] = this.readDouble();
        }
        return dArray;
    }

    private String[] readStringArray(int n) {
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            stringArray[i2] = this.readString(stringArray, i2);
        }
        return stringArray;
    }

    private String readString(String[] stringArray, int n) {
        int n2 = this.readUnsignedByte();
        switch (n2 & 0xC0) {
            case 192: {
                return this.readAsciiString(n2 & 0x3F);
            }
            case 128: {
                return this.readAsciiString(this.readLenghtInt());
            }
            case 64: {
                return this.readJavaString(n2 & 0x3F);
            }
            case 0: {
                switch (n2) {
                    case 48: {
                        return null;
                    }
                    case 49: {
                        return stringArray[this.offset(n, this.readUnsignedShort())];
                    }
                    case 50: {
                        return stringArray[this.offset(n, this.readLenghtInt())];
                    }
                }
                return this.readJavaString(this.readLenghtInt());
            }
        }
        throw this.errorCorrupt("Unknown string format.");
    }

    private int offset(int n, int n2) {
        if (n2 > 0 && n2 <= n) {
            return n - n2;
        }
        throw this.errorCorrupt("Invalid string offset.");
    }

    private String readAsciiString(int n) {
        if (this.string == null) {
            this.string = new StringBuffer(Math.min(16, n));
        } else {
            this.string.setLength(0);
        }
        for (int i2 = 0; i2 < n; ++i2) {
            this.string.append((char)this.readUnsignedByte());
        }
        return this.string.toString();
    }

    private String readJavaString(int n) {
        if (this.string == null) {
            this.string = new StringBuffer(Math.min(16, n));
        } else {
            this.string.setLength(0);
        }
        for (int i2 = 0; i2 < n; ++i2) {
            this.string.append(this.readChar());
        }
        return this.string.toString();
    }

    private Object skipStringArray(int n) {
        for (int i2 = 0; i2 < n; ++i2) {
            this.skipString();
        }
        return null;
    }

    private void skipString() {
        int n = this.readUnsignedByte();
        block0 : switch (n & 0xC0) {
            case 192: {
                this.skip(1 * n & 0x3F);
                break;
            }
            case 128: {
                this.skip(1 * this.readLenghtInt());
                break;
            }
            case 64: {
                this.skip(2 * n & 0x3F);
                break;
            }
            case 0: {
                switch (n) {
                    case 48: {
                        break block0;
                    }
                    case 49: {
                        this.skip(2);
                        break block0;
                    }
                    case 50: {
                        this.skip(4);
                        break block0;
                    }
                }
                this.skip(2 * this.readLenghtInt());
                break;
            }
            default: {
                throw this.errorCorrupt("Unknown string format.");
            }
        }
    }

    public static int checksum(int n, int n2) {
        return n << 5 ^ n2;
    }

    private int next() {
        int n = this.stream.read();
        if (n != -1) {
            this.crc.update(n);
            ++this.seek;
            return n;
        }
        throw this.errorEOF();
    }

    private int readUnsignedByte() {
        return this.next();
    }

    private char readChar() {
        return (char)(this.next() << 0 | this.next() << 8);
    }

    private short readShort() {
        return (short)(this.next() << 0 | this.next() << 8);
    }

    private int readUnsignedShort() {
        return this.next() << 0 | this.next() << 8;
    }

    private int readInt() {
        return this.next() << 0 | this.next() << 8 | this.next() << 16 | this.next() << 24;
    }

    private int readLenghtInt() {
        int n = this.readInt();
        if (n < 0) {
            throw this.errorCorrupt("Invalid unsigned int (invalid length) found.");
        }
        return n;
    }

    private long readLong() {
        return (long)(this.next() << 0 | this.next() << 8 | this.next() << 16) | (long)this.next() << 24 | (long)this.readInt() << 32;
    }

    private float readFloat() {
        return Float.intBitsToFloat(this.readInt());
    }

    private double readDouble() {
        return Double.longBitsToDouble((long)this.readLong());
    }

    private byte[] readBytes(int n) {
        int n2;
        byte[] byArray = new byte[n];
        for (int i2 = n; i2 > 0; i2 -= n2) {
            n2 = this.stream.read(byArray, n - i2, i2);
            if (n2 > 0) continue;
            this.seek += (long)(n - i2);
            throw this.errorEOF();
        }
        this.crc.update(byArray, 0, n);
        this.seek += (long)n;
        return byArray;
    }

    private void skipBytes(int n) {
        int n2;
        int n3 = 8;
        byte[] byArray = new byte[8];
        for (int i2 = n; i2 > 0; i2 -= n2) {
            n2 = this.stream.read(byArray, 0, i2 < 8 ? i2 : 8);
            if (n2 <= 0) {
                this.seek += (long)(n - i2);
                throw this.errorEOF();
            }
            this.crc.update(byArray, 0, n2);
        }
    }

    private EOFException errorEOF() {
        return new EOFException("Unexpected end of debug data stream.");
    }

    private IOException errorCorrupt(String string) {
        return new StreamCorruptedException(new StringBuffer().append(string).append(" (offset: ").append(this.seek).append(")").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Object[] readData(String string) {
        FileInputStream fileInputStream = new FileInputStream(string);
        try {
            Object[] objectArray = new DebugDataReader(fileInputStream).readDataInternal();
            return objectArray;
        }
        finally {
            fileInputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Object[] readData(String string, BitSet bitSet) {
        FileInputStream fileInputStream = new FileInputStream(string);
        try {
            Object[] objectArray = new DebugDataReader(fileInputStream).readDataInternal(bitSet);
            return objectArray;
        }
        finally {
            fileInputStream.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Object[] readData(String string, BitArray bitArray) {
        FileInputStream fileInputStream = new FileInputStream(string);
        try {
            Object[] objectArray = new DebugDataReader(fileInputStream).readDataInternal(bitArray);
            return objectArray;
        }
        finally {
            fileInputStream.close();
        }
    }

    public static Object[] readData(InputStream inputStream) {
        if (inputStream == null) {
            throw new IOException("Input stream not specified.");
        }
        return new DebugDataReader(inputStream).readDataInternal();
    }

    public static Object[] readData(InputStream inputStream, BitSet bitSet) {
        if (inputStream == null) {
            throw new IOException("Input stream not specified.");
        }
        return new DebugDataReader(inputStream).readDataInternal(bitSet);
    }

    public static Object[] readData(InputStream inputStream, BitArray bitArray) {
        if (inputStream == null) {
            throw new IOException("Input stream not specified.");
        }
        return new DebugDataReader(inputStream).readDataInternal(bitArray);
    }
}

