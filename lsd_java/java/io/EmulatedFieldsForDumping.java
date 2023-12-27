/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import java.io.EmulatedFields;
import java.io.EmulatedFields$ObjectSlot;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamClass;

class EmulatedFieldsForDumping
extends ObjectOutputStream$PutField {
    private EmulatedFields emulatedFields;

    EmulatedFieldsForDumping(ObjectStreamClass objectStreamClass) {
        this.emulatedFields = new EmulatedFields(objectStreamClass.fields(), null);
    }

    EmulatedFields emulatedFields() {
        return this.emulatedFields;
    }

    @Override
    public void put(String string, byte by) {
        this.emulatedFields.put(string, by);
    }

    @Override
    public void put(String string, char c2) {
        this.emulatedFields.put(string, c2);
    }

    @Override
    public void put(String string, double d2) {
        this.emulatedFields.put(string, d2);
    }

    @Override
    public void put(String string, float f2) {
        this.emulatedFields.put(string, f2);
    }

    @Override
    public void put(String string, int n) {
        this.emulatedFields.put(string, n);
    }

    @Override
    public void put(String string, long l) {
        this.emulatedFields.put(string, l);
    }

    @Override
    public void put(String string, Object object) {
        this.emulatedFields.put(string, object);
    }

    @Override
    public void put(String string, short s) {
        this.emulatedFields.put(string, s);
    }

    @Override
    public void put(String string, boolean bl) {
        this.emulatedFields.put(string, bl);
    }

    @Override
    public void write(ObjectOutput objectOutput) {
        EmulatedFields$ObjectSlot[] emulatedFields$ObjectSlotArray = this.emulatedFields.slots();
        int n = 0;
        while (n < emulatedFields$ObjectSlotArray.length) {
            EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = emulatedFields$ObjectSlotArray[n];
            Object object = emulatedFields$ObjectSlot.getFieldValue();
            Class clazz = emulatedFields$ObjectSlot.getField().getType();
            if (clazz == Integer.TYPE) {
                objectOutput.writeInt(object != null ? (Integer)object : 0);
            } else if (clazz == Byte.TYPE) {
                objectOutput.writeByte(object != null ? (int)((Byte)object).byteValue() : 0);
            } else if (clazz == Character.TYPE) {
                objectOutput.writeChar(object != null ? (int)((Character)object).charValue() : 0);
            } else if (clazz == Short.TYPE) {
                objectOutput.writeShort(object != null ? (int)((Short)object).shortValue() : 0);
            } else if (clazz == Boolean.TYPE) {
                objectOutput.writeBoolean(object != null ? (Boolean)object : false);
            } else if (clazz == Long.TYPE) {
                objectOutput.writeLong(object != null ? (Long)object : 0L);
            } else if (clazz == Float.TYPE) {
                objectOutput.writeFloat(object != null ? ((Float)object).floatValue() : 0.0f);
            } else if (clazz == Double.TYPE) {
                objectOutput.writeDouble(object != null ? (Double)object : 0.0);
            } else {
                objectOutput.writeObject(object);
            }
            ++n;
        }
    }
}

