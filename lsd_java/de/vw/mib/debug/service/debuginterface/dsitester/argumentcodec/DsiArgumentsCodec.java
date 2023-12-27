/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.debug.service.debuginterface.dsitester.argumentcodec;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.codec.ByteArrayWriter;
import de.vw.mib.debug.service.debuginterface.dsitester.argumentcodec.DSIEventArgument;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;

public class DsiArgumentsCodec {
    public static final byte TYPE_INT;
    public static final byte TYPE_LONG;
    public static final byte TYPE_DOUBLE;
    public static final byte TYPE_STRING;
    public static final byte TYPE_BYTE;
    public static final byte TYPE_BOOLEAN;
    public static final byte TYPE_CHAR;
    public static final byte TYPE_SHORT;
    public static final byte TYPE_FLOAT;
    public static final byte TYPE_ARRAY;
    public static final byte TYPE_OBJECT;
    public static final int NULL_VAL;
    public static final int EMPTY_VAL;
    static /* synthetic */ Class class$java$lang$String;

    public void saveArgsToEvent(DSIEventArgument[] dSIEventArgumentArray, int n, ByteArrayWriter byteArrayWriter) {
        for (int i2 = 0; i2 < n; ++i2) {
            Object object = dSIEventArgumentArray[i2].getValue();
            String string = dSIEventArgumentArray[i2].getFullQualifiedName();
            if (object instanceof Number) {
                this.writeNumber(byteArrayWriter, string, object);
                continue;
            }
            if (string.equals("String")) {
                byteArrayWriter.writeByte(3);
                byteArrayWriter.writeString((String)object);
                continue;
            }
            if (string.equals("boolean")) {
                byteArrayWriter.writeByte(5);
                byteArrayWriter.writeBoolean((Boolean)object);
                continue;
            }
            if (string.equals("char")) {
                byteArrayWriter.writeByte(6);
                byteArrayWriter.writeChar(object.toString().charAt(0));
                continue;
            }
            if (string.endsWith("[]")) {
                String string2;
                String string3;
                Object object2;
                byteArrayWriter.writeByte(8);
                if (object instanceof DSIEventArgument[][]) {
                    object2 = (DSIEventArgument[][])object;
                    byteArrayWriter.writeInt(((DSIEventArgument[][])object2).length);
                    string3 = dSIEventArgumentArray[i2].getFullQualifiedName();
                    string2 = string3.substring(0, string3.indexOf("["));
                    byteArrayWriter.writeString(string2);
                    for (int i3 = 0; i3 < ((DSIEventArgument[][])object2).length; ++i3) {
                        this.writeObject(string2, (DSIEventArgument[])object2[i3], byteArrayWriter);
                    }
                    continue;
                }
                if (object instanceof DSIEventArgument[]) {
                    object2 = (DSIEventArgument[])object;
                    byteArrayWriter.writeInt(((DSIEventArgument[][])object2).length);
                    string3 = dSIEventArgumentArray[i2].getFullQualifiedName();
                    string2 = string3.substring(0, string3.indexOf("["));
                    byteArrayWriter.writeString(string2);
                    this.saveArgsToEvent((DSIEventArgument[])object2, ((Object)object2).length, byteArrayWriter);
                    continue;
                }
                if (object != null) continue;
                if (dSIEventArgumentArray[i2].isNull()) {
                    byteArrayWriter.writeInt(-1);
                    continue;
                }
                if (!dSIEventArgumentArray[i2].isEmpty()) continue;
                byteArrayWriter.writeInt(-2);
                object2 = dSIEventArgumentArray[i2].getFullQualifiedName();
                string3 = ((String)object2).substring(0, ((String)object2).indexOf("["));
                byteArrayWriter.writeString(string3);
                continue;
            }
            this.writeObject(dSIEventArgumentArray[i2].getFullQualifiedName(), (DSIEventArgument[])dSIEventArgumentArray[i2].getValue(), byteArrayWriter);
        }
    }

    private void writeNumber(ByteArrayWriter byteArrayWriter, String string, Object object) {
        if (string.equals("int")) {
            byteArrayWriter.writeByte(0);
            byteArrayWriter.writeInt((Integer)object);
        } else if (string.equals("long")) {
            byteArrayWriter.writeByte(1);
            byteArrayWriter.writeLong((Long)object);
        } else if (string.equals("double")) {
            byteArrayWriter.writeByte(2);
            byteArrayWriter.writeDouble((Double)object);
        } else if (string.equals("byte")) {
            byteArrayWriter.writeByte(4);
            byteArrayWriter.writeByte(((Byte)object).byteValue());
        } else if (string.equals("short")) {
            byteArrayWriter.writeByte(7);
            byteArrayWriter.writeShort(((Short)object).shortValue());
        } else if (string.equals("float")) {
            byteArrayWriter.writeByte(10);
            byteArrayWriter.writeFloat(((Float)object).floatValue());
        }
    }

    private void writeObject(String string, DSIEventArgument[] dSIEventArgumentArray, ByteArrayWriter byteArrayWriter) {
        byteArrayWriter.writeByte(9);
        if (dSIEventArgumentArray == null) {
            byteArrayWriter.writeInt(-1);
        } else {
            byteArrayWriter.writeInt(dSIEventArgumentArray.length);
            byteArrayWriter.writeString(string);
            this.saveArgsToEvent(dSIEventArgumentArray, dSIEventArgumentArray.length, byteArrayWriter);
        }
    }

    public Object[] getArguments(byte[] byArray) {
        ByteArrayReader byteArrayReader = new ByteArrayReader(byArray);
        int n = byteArrayReader.readInt();
        return this.getArguments(n, byteArrayReader);
    }

    public Object[] getArguments(int n, ByteArrayReader byteArrayReader) {
        Object[] objectArray = new Object[n];
        block13: for (int i2 = 0; i2 < n; ++i2) {
            byte by = byteArrayReader.readByte();
            switch (by) {
                case 0: {
                    objectArray[i2] = new Integer(byteArrayReader.readInt());
                    continue block13;
                }
                case 1: {
                    objectArray[i2] = new Long(byteArrayReader.readLong());
                    continue block13;
                }
                case 2: {
                    objectArray[i2] = new Double(byteArrayReader.readDouble());
                    continue block13;
                }
                case 3: {
                    objectArray[i2] = byteArrayReader.readString();
                    continue block13;
                }
                case 6: {
                    objectArray[i2] = new Character(byteArrayReader.readChar());
                    continue block13;
                }
                case 4: {
                    objectArray[i2] = new Byte(byteArrayReader.readByte());
                    continue block13;
                }
                case 5: {
                    objectArray[i2] = new Boolean(byteArrayReader.readBoolean());
                    continue block13;
                }
                case 7: {
                    objectArray[i2] = new Short(byteArrayReader.readShort());
                    continue block13;
                }
                case 10: {
                    objectArray[i2] = new Float(byteArrayReader.readFloat());
                    continue block13;
                }
                case 8: {
                    int n2 = byteArrayReader.readInt();
                    if (n2 == -1) {
                        objectArray[i2] = null;
                        continue block13;
                    }
                    if (n2 == -2) {
                        objectArray[i2] = this.emptyArray(byteArrayReader);
                        continue block13;
                    }
                    objectArray[i2] = this.readArray(n2, byteArrayReader);
                    continue block13;
                }
                case 9: {
                    int n3 = byteArrayReader.readInt();
                    if (n3 == -1) {
                        objectArray[i2] = null;
                        continue block13;
                    }
                    objectArray[i2] = this.readObject(n3, byteArrayReader);
                    continue block13;
                }
            }
        }
        return objectArray;
    }

    private Object readArray(int n, ByteArrayReader byteArrayReader) {
        String string = byteArrayReader.readString();
        Class clazz = this.getBoxedClass(string);
        Object object = Array.newInstance(clazz, n);
        Object[] objectArray = this.getArguments(n, byteArrayReader);
        for (int i2 = 0; i2 < n; ++i2) {
            Array.set(object, i2, objectArray[i2]);
        }
        return object;
    }

    private Object emptyArray(ByteArrayReader byteArrayReader) {
        String string = byteArrayReader.readString();
        Class clazz = this.getBoxedClass(string);
        Object object = Array.newInstance(clazz, 0);
        return object;
    }

    private Object readObject(int n, ByteArrayReader byteArrayReader) {
        String string = byteArrayReader.readString();
        Object[] objectArray = this.getArguments(n, byteArrayReader);
        Class clazz = this.getBoxedClass(string);
        Constructor[] constructorArray = clazz.getConstructors();
        for (int i2 = 0; i2 < constructorArray.length; ++i2) {
            if (constructorArray[i2].getParameterTypes().length != n) continue;
            return constructorArray[i2].newInstance(objectArray);
        }
        return null;
    }

    private Class getBoxedClass(String string) {
        if (string.equals("int")) {
            return Integer.TYPE;
        }
        if (string.equals("long")) {
            return Long.TYPE;
        }
        if (string.equals("double")) {
            return Double.TYPE;
        }
        if (string.equals("String")) {
            return class$java$lang$String == null ? (class$java$lang$String = DsiArgumentsCodec.class$("java.lang.String")) : class$java$lang$String;
        }
        if (string.equals("byte")) {
            return Byte.TYPE;
        }
        if (string.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (string.equals("short")) {
            return Short.TYPE;
        }
        if (string.equals("char")) {
            return Character.TYPE;
        }
        if (string.equals("float")) {
            return Float.TYPE;
        }
        return Class.forName(string);
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

