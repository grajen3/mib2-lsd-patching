/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.esolutions.fw.util.serializer.adapter;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable$Item;
import de.esolutions.fw.util.serializer.adapter.StringEncodings;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GenericSerializable
implements ISerializable {
    private static /*final*/ int INT8;
    private static /*final*/ int INT16;
    private static /*final*/ int INT32;
    private static /*final*/ int INT64;
    private static /*final*/ int STRING;
    private static /*final*/ int FLOAT;
    private static /*final*/ int DOUBLE;
    private static /*final*/ int BOOL;
    private static /*final*/ int UINT8;
    private static /*final*/ int UINT16;
    private static /*final*/ int UINT32;
    private static /*final*/ int UINT64;
    private static /*final*/ int INT8_ARRAY;
    private static /*final*/ int INT16_ARRAY;
    private static /*final*/ int INT32_ARRAY;
    private static /*final*/ int INT64_ARRAY;
    private static /*final*/ int STRING_ARRAY;
    private static /*final*/ int FLOAT_ARRAY;
    private static /*final*/ int DOUBLE_ARRAY;
    private static /*final*/ int BOOL_ARRAY;
    private static /*final*/ int UINT8_ARRAY;
    private static /*final*/ int UINT16_ARRAY;
    private static /*final*/ int UINT32_ARRAY;
    private static /*final*/ int UINT64_ARRAY;
    private static /*final*/ int UCHAR16;
    private static /*final*/ int UCHAR16_ARRAY;
    private int stringEncoding;
    private List items;

    public GenericSerializable() {
        this(0);
    }

    public GenericSerializable(int n) {
        this.stringEncoding = n;
        this.items = new ArrayList();
    }

    public void putBool(boolean bl) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(7, new Boolean(bl)));
    }

    public void putBoolArray(boolean[] blArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(19, blArray));
    }

    public void putDouble(double d2) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(6, new Double(d2)));
    }

    public void putDoubleArray(double[] dArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(18, dArray));
    }

    public void putFloat(float f2) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(5, new Float(f2)));
    }

    public void putFloatArray(float[] fArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(17, fArray));
    }

    public void putInt16(short s) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(1, new Short(s)));
    }

    public void putInt16Array(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(13, sArray));
    }

    public void putInt32(int n) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(2, new Integer(n)));
    }

    public void putInt32Array(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(14, nArray));
    }

    public void putInt64(long l) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(3, new Long(l)));
    }

    public void putInt64Array(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(15, lArray));
    }

    public void putInt8(byte by) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(0, new Byte(by)));
    }

    public void putInt8Array(byte[] byArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(12, byArray));
    }

    public void putUInt16(int n) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(9, new Integer(n)));
    }

    public void putUInt16Array(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(21, nArray));
    }

    public void putUInt32(long l) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(10, new Long(l)));
    }

    public void putUInt32Array(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(22, lArray));
    }

    public void putUInt64(long l) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(11, new Long(l)));
    }

    public void putUInt64Array(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(23, lArray));
    }

    public void putUInt8(short s) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(8, new Short(s)));
    }

    public void putUInt8Array(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(20, sArray));
    }

    public void putUChar16(char c2) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(24, new Character(c2)));
    }

    public void putUChar16Array(char[] cArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.items.add(new GenericSerializable$Item(25, cArray));
    }

    public void putOptionalFlag(boolean bl) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putInt8(bl ? (byte)0 : -1);
    }

    public void putString(String string) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // try {
        //     StringConverter stringConverter = StringEncodings.getConverter(this.stringEncoding);
        //     if (stringConverter == null) {
        //         throw new SerializerException("No converter found");
        //     }
        //     byte[] byArray = stringConverter.getBytes(string);
        //     int n = byArray.length / StringEncodings.byteWidth[this.stringEncoding];
        //     this.putInt8((byte)this.stringEncoding);
        //     this.putInt16((short)n);
        //     this.putInt8Array(byArray);
        // }
        // catch (UnsupportedEncodingException unsupportedEncodingException) {
        //     throw new SerializerException("Invalid String Type");
        // }
    }

    public void putOptionalString(String string) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putOptionalFlag(string != null);
        // if (string != null) {
        //     this.putString(string);
        // }
    }

    public void putOptionalStringVarArray(String[] stringArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putOptionalFlag(stringArray != null);
        // if (stringArray != null) {
        //     this.putInt32(stringArray.length);
        //     for (int i2 = 0; i2 < stringArray.length; ++i2) {
        //         this.putOptionalString(stringArray[i2]);
        //     }
        // }
    }

    public void putEnum(int n) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putInt32(n);
    }

    public void putStringArray(String[] stringArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(stringArray.length);
        // for (int i2 = 0; i2 < stringArray.length; ++i2) {
        //     this.putString(stringArray[i2]);
        // }
    }

    public void putBoolVarArray(boolean[] blArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(blArray.length);
        // this.putBoolArray(blArray);
    }

    public void putUChar16VarArray(char[] cArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(cArray.length);
        // this.putUChar16Array(cArray);
    }

    public void putUInt8VarArray(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(sArray.length);
        // this.putUInt8Array(sArray);
    }

    public void putInt8VarArray(byte[] byArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(byArray.length);
        // this.putInt8Array(byArray);
    }

    public void putUInt16VarArray(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(nArray.length);
        // this.putUInt16Array(nArray);
    }

    public void putInt16VarArray(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(sArray.length);
        // this.putInt16Array(sArray);
    }

    public void putUInt32VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(lArray.length);
        // this.putUInt32Array(lArray);
    }

    public void putInt32VarArray(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(nArray.length);
        // this.putInt32Array(nArray);
    }

    public void putUInt64VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(lArray.length);
        // this.putUInt64Array(lArray);
    }

    public void putInt64VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(lArray.length);
        // this.putInt64Array(lArray);
    }

    public void putFloatVarArray(float[] fArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(fArray.length);
        // this.putFloatArray(fArray);
    }

    public void putDoubleVarArray(double[] dArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // this.putUInt32(dArray.length);
        // this.putDoubleArray(dArray);
    }

    public void putOptionalBoolVarArray(boolean[] blArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = blArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putBoolVarArray(blArray);
        // }
    }

    public void putOptionalUChar16VarArray(char[] cArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = cArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putUChar16VarArray(cArray);
        // }
    }

    public void putOptionalDoubleVarArray(double[] dArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = dArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putDoubleVarArray(dArray);
        // }
    }

    public void putOptionalFloatVarArray(float[] fArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = fArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putFloatVarArray(fArray);
        // }
    }

    public void putOptionalInt16VarArray(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = sArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putInt16VarArray(sArray);
        // }
    }

    public void putOptionalInt32VarArray(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = nArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putInt32VarArray(nArray);
        // }
    }

    public void putOptionalInt64VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = lArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putInt64VarArray(lArray);
        // }
    }

    public void putOptionalInt8VarArray(byte[] byArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = byArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putInt8VarArray(byArray);
        // }
    }

    public void putOptionalUInt16VarArray(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = nArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putUInt16VarArray(nArray);
        // }
    }

    public void putOptionalUInt32VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = lArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putUInt32VarArray(lArray);
        // }
    }

    public void putOptionalUInt64VarArray(long[] lArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = lArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putUInt64VarArray(lArray);
        // }
    }

    public void putOptionalUInt8VarArray(short[] sArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = sArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putUInt8VarArray(sArray);
        // }
    }

    public void putOptionalEnumVarArray(int[] nArray) throws SerializerException {
        throw new SerializerException("COMPILE STUB");
        // boolean bl = nArray == null;
        // this.putBool(bl);
        // if (!bl) {
        //     this.putInt32VarArray(nArray);
        // }
    }

   // @Override
    public void serialize(ISerializer iSerializer) {
        // block28: for (int i2 = 0; i2 < this.items.size(); ++i2) {
        //     GenericSerializable$Item genericSerializable$Item = (GenericSerializable$Item)this.items.get(i2);
        //     switch (genericSerializable$Item.type) {
        //         case 0: {
        //             iSerializer.putInt8((Byte)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 1: {
        //             iSerializer.putInt16((Short)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 2: {
        //             iSerializer.putInt32((Integer)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 3: {
        //             iSerializer.putInt64((Long)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 4: {
        //             iSerializer.putString((String)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 5: {
        //             iSerializer.putFloat(((Float)genericSerializable$Item.value).floatValue());
        //             continue block28;
        //         }
        //         case 6: {
        //             iSerializer.putDouble((Double)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 7: {
        //             iSerializer.putBool((Boolean)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 8: {
        //             iSerializer.putUInt8((Short)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 9: {
        //             iSerializer.putUInt16((Integer)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 10: {
        //             iSerializer.putUInt32((Long)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 11: {
        //             iSerializer.putUInt64((Long)genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 12: {
        //             iSerializer.putInt8Array((byte[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 13: {
        //             iSerializer.putInt16Array((short[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 14: {
        //             iSerializer.putInt32Array((int[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 15: {
        //             iSerializer.putInt64Array((long[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 16: {
        //             iSerializer.putStringArray((String[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 17: {
        //             iSerializer.putFloatArray((float[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 18: {
        //             iSerializer.putDoubleArray((double[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 19: {
        //             iSerializer.putBoolArray((boolean[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 20: {
        //             iSerializer.putUInt8Array((short[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 21: {
        //             iSerializer.putUInt16Array((int[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 22: {
        //             iSerializer.putUInt32Array((long[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 23: {
        //             iSerializer.putUInt64Array((long[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         case 24: {
        //             iSerializer.putUChar16(((Character)genericSerializable$Item.value).charValue());
        //             continue block28;
        //         }
        //         case 25: {
        //             iSerializer.putUChar16Array((char[])genericSerializable$Item.value);
        //             continue block28;
        //         }
        //         default: {
        //             throw new SerializerException(new StringBuffer().append("Unknown item type: ").append(genericSerializable$Item.type).toString());
        //         }
        //     }
        // }
    }
}

