/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.EmulatedFields;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectStreamClass;

class EmulatedFieldsForLoading
extends ObjectInputStream$GetField {
    private ObjectStreamClass streamClass;
    private EmulatedFields emulatedFields;

    EmulatedFieldsForLoading(ObjectStreamClass objectStreamClass) {
        this.streamClass = objectStreamClass;
        this.emulatedFields = new EmulatedFields(objectStreamClass.getLoadFields(), objectStreamClass.fields());
    }

    @Override
    public boolean defaulted(String string) {
        return this.emulatedFields.defaulted(string);
    }

    EmulatedFields emulatedFields() {
        return this.emulatedFields;
    }

    @Override
    public byte get(String string, byte by) {
        return this.emulatedFields.get(string, by);
    }

    @Override
    public char get(String string, char c2) {
        return this.emulatedFields.get(string, c2);
    }

    @Override
    public double get(String string, double d2) {
        return this.emulatedFields.get(string, d2);
    }

    @Override
    public float get(String string, float f2) {
        return this.emulatedFields.get(string, f2);
    }

    @Override
    public int get(String string, int n) {
        return this.emulatedFields.get(string, n);
    }

    @Override
    public long get(String string, long l) {
        return this.emulatedFields.get(string, l);
    }

    @Override
    public Object get(String string, Object object) {
        return this.emulatedFields.get(string, object);
    }

    @Override
    public short get(String string, short s) {
        return this.emulatedFields.get(string, s);
    }

    @Override
    public boolean get(String string, boolean bl) {
        return this.emulatedFields.get(string, bl);
    }

    @Override
    public ObjectStreamClass getObjectStreamClass() {
        return this.streamClass;
    }
}

