/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class Field
extends AccessibleObject
implements Member {
    private Class declaringClass;
    private Class type;
    private String name;
    private long vm1;

    private Field() {
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Field)) {
            return false;
        }
        Field field = (Field)object;
        if (!this.getName().equals(field.getName())) {
            return false;
        }
        if (this.getDeclaringClass() != field.getDeclaringClass()) {
            return false;
        }
        return this.getType() == field.getType();
    }

    public Object get(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getImpl(object);
    }

    private boolean requiresProtectedCheck() {
        return !this.isAccessible() && (this.getModifiers() & 0xC) == 4;
    }

    private native Object getImpl(Object object) {
    }

    private boolean samePackage(Class clazz) {
        if (this.declaringClass.equals(clazz)) {
            return true;
        }
        String string = Field.getPackageName(this.declaringClass.getName());
        String string2 = Field.getPackageName(clazz.getName());
        return string.equals(string2);
    }

    private void doProtectedCheck(Class clazz, Object object) {
        if (!this.samePackage(clazz) && !clazz.isInstance(object)) {
            if (!this.declaringClass.isInstance(object)) {
                throw new IllegalArgumentException();
            }
            throw new IllegalAccessException();
        }
    }

    private static String getPackageName(String string) {
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            return string.substring(0, n);
        }
        return "";
    }

    public boolean getBoolean(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getBooleanImpl(object);
    }

    private native boolean getBooleanImpl(Object object) {
    }

    public byte getByte(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getByteImpl(object);
    }

    private native byte getByteImpl(Object object) {
    }

    public char getChar(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getCharImpl(object);
    }

    private native char getCharImpl(Object object) {
    }

    @Override
    public Class getDeclaringClass() {
        return this.declaringClass;
    }

    public double getDouble(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getDoubleImpl(object);
    }

    private native double getDoubleImpl(Object object) {
    }

    public float getFloat(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getFloatImpl(object);
    }

    private native float getFloatImpl(Object object) {
    }

    public int getInt(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getIntImpl(object);
    }

    private native int getIntImpl(Object object) {
    }

    public long getLong(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getLongImpl(object);
    }

    private native long getLongImpl(Object object) {
    }

    @Override
    public native int getModifiers() {
    }

    @Override
    public String getName() {
        if (this.name != null) {
            return this.name;
        }
        return this.getNameImpl();
    }

    private native String getNameImpl() {
    }

    public short getShort(Object object) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        return this.getShortImpl(object);
    }

    private native short getShortImpl(Object object) {
    }

    @Override
    native String getSignature() {
    }

    public Class getType() {
        if (this.type != null) {
            return this.type;
        }
        return this.getTypeImpl();
    }

    private native Class getTypeImpl() {
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public void set(Object object, Object object2) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setImpl(object, object2);
    }

    private native void setImpl(Object object, Object object2) {
    }

    public void setBoolean(Object object, boolean bl) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setBooleanImpl(object, bl);
    }

    private native void setBooleanImpl(Object object, boolean bl) {
    }

    public void setByte(Object object, byte by) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setByteImpl(object, by);
    }

    private native void setByteImpl(Object object, byte by) {
    }

    public void setChar(Object object, char c2) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setCharImpl(object, c2);
    }

    private native void setCharImpl(Object object, char c2) {
    }

    public void setDouble(Object object, double d2) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setDoubleImpl(object, d2);
    }

    private native void setDoubleImpl(Object object, double d2) {
    }

    public void setFloat(Object object, float f2) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setFloatImpl(object, f2);
    }

    private native void setFloatImpl(Object object, float f2) {
    }

    public void setInt(Object object, int n) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setIntImpl(object, n);
    }

    private native void setIntImpl(Object object, int n) {
    }

    public void setLong(Object object, long l) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setLongImpl(object, l);
    }

    private native void setLongImpl(Object object, long l) {
    }

    public void setShort(Object object, short s) {
        if (this.requiresProtectedCheck()) {
            this.doProtectedCheck(Field.getStackClass(-1), object);
        }
        this.setShortImpl(object, s);
    }

    private native void setShortImpl(Object object, short s) {
    }

    public String toString() {
        int n = 0;
        StringBuffer stringBuffer = new StringBuffer();
        String string = Modifier.toString(this.getModifiers());
        if (string.length() > 0) {
            stringBuffer.append(string);
            stringBuffer.append(" ");
        }
        Class clazz = this.getType();
        while (clazz.isArray()) {
            clazz = clazz.getComponentType();
            ++n;
        }
        stringBuffer.append(clazz.getName());
        while (n > 0) {
            stringBuffer.append("[]");
            --n;
        }
        stringBuffer.append(" ");
        stringBuffer.append(this.getDeclaringClass().getName());
        stringBuffer.append(".");
        stringBuffer.append(this.getName());
        return stringBuffer.toString();
    }
}

