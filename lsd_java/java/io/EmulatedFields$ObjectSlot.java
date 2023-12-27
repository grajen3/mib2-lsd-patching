/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.ObjectStreamField;

class EmulatedFields$ObjectSlot {
    ObjectStreamField field;
    Object fieldValue;
    boolean defaulted = true;

    EmulatedFields$ObjectSlot() {
    }

    public ObjectStreamField getField() {
        return this.field;
    }

    public Object getFieldValue() {
        return this.fieldValue;
    }
}

