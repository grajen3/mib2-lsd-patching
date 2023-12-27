/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import java.io.EmulatedFields$ObjectSlot;
import java.io.ObjectStreamField;

class EmulatedFields {
    private EmulatedFields$ObjectSlot[] slotsToSerialize;
    private ObjectStreamField[] declaredFields;

    public EmulatedFields(ObjectStreamField[] objectStreamFieldArray, ObjectStreamField[] objectStreamFieldArray2) {
        this.buildSlots(objectStreamFieldArray);
        this.declaredFields = objectStreamFieldArray2;
    }

    private void buildSlots(ObjectStreamField[] objectStreamFieldArray) {
        this.slotsToSerialize = new EmulatedFields$ObjectSlot[objectStreamFieldArray.length];
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            EmulatedFields$ObjectSlot emulatedFields$ObjectSlot;
            this.slotsToSerialize[n] = emulatedFields$ObjectSlot = new EmulatedFields$ObjectSlot();
            emulatedFields$ObjectSlot.field = objectStreamFieldArray[n];
            ++n;
        }
    }

    public boolean defaulted(String string) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, null);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted;
        }
        throw new IllegalArgumentException();
    }

    private EmulatedFields$ObjectSlot findSlot(String string, Class clazz) {
        Object object;
        boolean bl = clazz != null && clazz.isPrimitive();
        int n = 0;
        while (n < this.slotsToSerialize.length) {
            object = this.slotsToSerialize[n];
            if (((EmulatedFields$ObjectSlot)object).field.getName().equals(string)) {
                if (bl) {
                    if (((EmulatedFields$ObjectSlot)object).field.getType() == clazz) {
                        return object;
                    }
                } else {
                    if (clazz == null) {
                        return object;
                    }
                    if (((EmulatedFields$ObjectSlot)object).field.getType().isAssignableFrom(clazz)) {
                        return object;
                    }
                }
            }
            ++n;
        }
        if (this.declaredFields != null) {
            n = 0;
            while (n < this.declaredFields.length) {
                object = this.declaredFields[n];
                if (((ObjectStreamField)object).getName().equals(string) && (bl ? ((ObjectStreamField)object).getType() == clazz : clazz == null || ((ObjectStreamField)object).getType().isAssignableFrom(clazz))) {
                    EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = new EmulatedFields$ObjectSlot();
                    emulatedFields$ObjectSlot.field = object;
                    emulatedFields$ObjectSlot.defaulted = true;
                    return emulatedFields$ObjectSlot;
                }
                ++n;
            }
        }
        return null;
    }

    public byte get(String string, byte by) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Byte.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? by : (Byte)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public char get(String string, char c2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Character.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? c2 : ((Character)emulatedFields$ObjectSlot.fieldValue).charValue();
        }
        throw new IllegalArgumentException();
    }

    public double get(String string, double d2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Double.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? d2 : (Double)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public float get(String string, float f2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Float.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? f2 : ((Float)emulatedFields$ObjectSlot.fieldValue).floatValue();
        }
        throw new IllegalArgumentException();
    }

    public int get(String string, int n) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Integer.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? n : (Integer)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public long get(String string, long l) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Long.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? l : (Long)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public Object get(String string, Object object) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, null);
        if (emulatedFields$ObjectSlot != null && !emulatedFields$ObjectSlot.field.getType().isPrimitive()) {
            return emulatedFields$ObjectSlot.defaulted ? object : emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public short get(String string, short s) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Short.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? s : (Short)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public boolean get(String string, boolean bl) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Boolean.TYPE);
        if (emulatedFields$ObjectSlot != null) {
            return emulatedFields$ObjectSlot.defaulted ? bl : (Boolean)emulatedFields$ObjectSlot.fieldValue;
        }
        throw new IllegalArgumentException();
    }

    public void put(String string, byte by) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Byte.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Byte(by);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, char c2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Character.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Character(c2);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, double d2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Double.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Double(d2);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, float f2) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Float.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Float(f2);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, int n) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Integer.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Integer(n);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, long l) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Long.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Long(l);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, Object object) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot;
        Class clazz = null;
        if (object != null) {
            clazz = object.getClass();
        }
        if ((emulatedFields$ObjectSlot = this.findSlot(string, clazz)) == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = object;
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, short s) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Short.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Short(s);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public void put(String string, boolean bl) {
        EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = this.findSlot(string, Boolean.TYPE);
        if (emulatedFields$ObjectSlot == null) {
            throw new IllegalArgumentException();
        }
        emulatedFields$ObjectSlot.fieldValue = new Boolean(bl);
        emulatedFields$ObjectSlot.defaulted = false;
    }

    public EmulatedFields$ObjectSlot[] slots() {
        return this.slotsToSerialize;
    }
}

