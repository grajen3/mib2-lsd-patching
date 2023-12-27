/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.BitArray;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.zip.CRC32;

public final class DebugDataWriter {
    private final OutputStream stream;
    private final CRC32 crc;
    private final int arrayCount;
    private int arrayIndex;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$String;

    public DebugDataWriter(OutputStream outputStream, int n) {
        this.stream = outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream);
        this.arrayCount = n;
        this.arrayIndex = 0;
        this.crc = new CRC32();
    }

    public void close() {
        if (this.arrayIndex != this.arrayCount) {
            throw new IOException(new StringBuffer().append("Not enough arrays in DebugData (").append(this.arrayIndex).append(" of ").append(this.arrayCount).append(").").toString());
        }
        this.writeHeader();
        this.writeInt((int)this.crc.getValue());
        this.stream.close();
    }

    private void writeHeader() {
        if (this.arrayIndex == 0) {
            if (this.arrayCount > -65536) {
                throw new InvalidObjectException("To many arrays to write. MAX=65535.");
            }
            this.writeShort(17476);
            this.writeShort(this.arrayCount);
        }
        ++this.arrayIndex;
    }

    public void write(BitArray bitArray) {
        this.writeHeader();
        this.writeArrayHeader(10, bitArray.length());
        int[] nArray = bitArray.getInternData();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.writeInt(nArray[i2]);
        }
    }

    public void write(boolean[] blArray) {
        this.writeHeader();
        this.writeArrayHeader(1, blArray.length);
        BitArray bitArray = new BitArray(blArray.length, null);
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            bitArray.set(i2, blArray[i2]);
        }
        int[] nArray = bitArray.getInternData();
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            this.writeInt(nArray[i3]);
        }
    }

    public void writeNull() {
        this.writeHeader();
        this.writeArrayHeader(0, 0);
    }

    public void write(byte[] byArray) {
        this.writeHeader();
        this.writeArrayHeader(2, byArray.length);
        this.writeBytes(byArray);
    }

    public void write(char[] cArray) {
        this.writeHeader();
        this.writeArrayHeader(3, cArray.length);
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            this.writeChar(cArray[i2]);
        }
    }

    public void write(short[] sArray) {
        this.writeHeader();
        this.writeArrayHeader(4, sArray.length);
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            this.writeShort(sArray[i2]);
        }
    }

    public void write(int[] nArray) {
        this.writeHeader();
        this.writeArrayHeader(5, nArray.length);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.writeInt(nArray[i2]);
        }
    }

    public void write(long[] lArray) {
        this.writeHeader();
        this.writeArrayHeader(6, lArray.length);
        for (int i2 = 0; i2 < lArray.length; ++i2) {
            this.writeLong(lArray[i2]);
        }
    }

    public void write(float[] fArray) {
        this.writeHeader();
        this.writeArrayHeader(7, fArray.length);
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            this.writeFloat(fArray[i2]);
        }
    }

    public void write(double[] dArray) {
        this.writeHeader();
        this.writeArrayHeader(8, dArray.length);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            this.writeDouble(dArray[i2]);
        }
    }

    public void write(String[] stringArray) {
        this.writeHeader();
        this.writeArrayHeader(9, stringArray.length);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            if (string != null) {
                int[] nArray = (int[])hashMap.get(string);
                if (nArray != null) {
                    this.writeOffsetString(i2 - nArray[0]);
                    nArray[0] = i2;
                    continue;
                }
                this.writeString(string.toCharArray());
                hashMap.put(string, new int[]{i2});
                continue;
            }
            this.writeNullString();
        }
    }

    private void writeString(char[] cArray) {
        int n;
        boolean bl = true;
        for (n = 0; bl && n < cArray.length; ++n) {
            bl = cArray[n] <= '\u00ff';
        }
        if (bl) {
            this.writeStringHeader(192, 128, cArray.length);
            for (n = 0; n < cArray.length; ++n) {
                this.writeByte(cArray[n]);
            }
        } else {
            this.writeStringHeader(64, 0, cArray.length);
            for (n = 0; n < cArray.length; ++n) {
                this.writeChar(cArray[n]);
            }
        }
    }

    private void writeNullString() {
        this.writeByte(48);
    }

    private void writeOffsetString(int n) {
        if (n < 256) {
            this.writeByte(49);
            this.writeShort(n);
        } else {
            this.writeByte(50);
            this.writeInt(n);
        }
    }

    private void writeStringHeader(int n, int n2, int n3) {
        if (n3 <= 63) {
            this.writeByte(n | n3);
        } else {
            this.writeByte(n2);
            this.writeInt(n3);
        }
    }

    public void writeArray(Object object) {
        if (object == null) {
            this.writeNull();
        } else if (object instanceof BitArray) {
            BitArray bitArray = (BitArray)object;
            this.write(bitArray);
        } else {
            Class clazz = object.getClass().getComponentType();
            if (clazz == Boolean.TYPE || clazz == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = DebugDataWriter.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
                boolean[] blArray = (boolean[])this.asData(object, Boolean.TYPE);
                this.write(blArray);
            } else if (clazz == Byte.TYPE || clazz == (class$java$lang$Byte == null ? (class$java$lang$Byte = DebugDataWriter.class$("java.lang.Byte")) : class$java$lang$Byte)) {
                byte[] byArray = (byte[])this.asData(object, Byte.TYPE);
                this.write(byArray);
            } else if (clazz == Character.TYPE || clazz == (class$java$lang$Character == null ? (class$java$lang$Character = DebugDataWriter.class$("java.lang.Character")) : class$java$lang$Character)) {
                char[] cArray = (char[])this.asData(object, Character.TYPE);
                this.write(cArray);
            } else if (clazz == Short.TYPE || clazz == (class$java$lang$Short == null ? (class$java$lang$Short = DebugDataWriter.class$("java.lang.Short")) : class$java$lang$Short)) {
                short[] sArray = (short[])this.asData(object, Short.TYPE);
                this.write(sArray);
            } else if (clazz == Integer.TYPE || clazz == (class$java$lang$Integer == null ? (class$java$lang$Integer = DebugDataWriter.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                int[] nArray = (int[])this.asData(object, Integer.TYPE);
                this.write(nArray);
            } else if (clazz == Long.TYPE || clazz == (class$java$lang$Long == null ? (class$java$lang$Long = DebugDataWriter.class$("java.lang.Long")) : class$java$lang$Long)) {
                long[] lArray = (long[])this.asData(object, Long.TYPE);
                this.write(lArray);
            } else if (clazz == Float.TYPE || clazz == (class$java$lang$Float == null ? (class$java$lang$Float = DebugDataWriter.class$("java.lang.Float")) : class$java$lang$Float)) {
                float[] fArray = (float[])this.asData(object, Float.TYPE);
                this.write(fArray);
            } else if (clazz == Double.TYPE || clazz == (class$java$lang$Double == null ? (class$java$lang$Double = DebugDataWriter.class$("java.lang.Double")) : class$java$lang$Double)) {
                double[] dArray = (double[])this.asData(object, Double.TYPE);
                this.write(dArray);
            } else if (clazz == (class$java$lang$String == null ? (class$java$lang$String = DebugDataWriter.class$("java.lang.String")) : class$java$lang$String)) {
                String[] stringArray = (String[])object;
                this.write(stringArray);
            } else {
                throw new IllegalArgumentException(new StringBuffer().append("Unsupported array type ").append(clazz.getName()).append("[].").toString());
            }
        }
    }

    private Object asData(Object object, Class clazz) {
        if (object.getClass().getComponentType() == clazz) {
            return object;
        }
        int n = Array.getLength(object);
        Object object2 = Array.newInstance(clazz, n);
        for (int i2 = 0; i2 < n; ++i2) {
            Object object3 = Array.get(object, i2);
            Array.set(object2, i2, object3);
        }
        return object2;
    }

    private void writeArrayHeader(int n, int n2) {
        if (n2 == 0) {
            this.writeByte(n | 0);
        } else if (n2 <= 255) {
            this.writeByte(n | 0x40);
            this.writeByte(n2);
        } else if (n2 <= -65536) {
            this.writeByte(n | 0x80);
            this.writeShort(n2);
        } else {
            this.writeByte(n | 0xC0);
            this.writeInt(n2);
        }
    }

    private void writeBytes(byte[] byArray) {
        int n = byArray.length;
        this.crc.update(byArray, 0, n);
        this.stream.write(byArray, 0, n);
    }

    private void writeByte(int n) {
        this.crc.update(n);
        this.stream.write(n);
    }

    private void writeChar(int n) {
        this.writeByte(n >> 0 & 0xFF);
        this.writeByte(n >> 8 & 0xFF);
    }

    private void writeShort(int n) {
        this.writeByte(n >> 0 & 0xFF);
        this.writeByte(n >> 8 & 0xFF);
    }

    private void writeInt(int n) {
        this.writeByte(n >> 0 & 0xFF);
        this.writeByte(n >> 8 & 0xFF);
        this.writeByte(n >> 16 & 0xFF);
        this.writeByte(n >> 24 & 0xFF);
    }

    private void writeLong(long l) {
        this.writeInt((int)(l >> 0));
        this.writeInt((int)(l >> 32));
    }

    private void writeFloat(float f2) {
        this.writeInt(Float.floatToIntBits(f2));
    }

    private void writeDouble(double d2) {
        this.writeLong(Double.doubleToLongBits((double)d2));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

