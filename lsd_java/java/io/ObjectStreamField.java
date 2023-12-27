/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Sorter;
import java.io.ObjectStreamField$1;
import java.lang.ref.WeakReference;

public class ObjectStreamField
implements Comparable {
    private String name;
    private Object type;
    int offset;
    private String typeString;
    private boolean unshared = false;

    public ObjectStreamField(String string, Class clazz) {
        if (string == null || clazz == null) {
            throw new NullPointerException();
        }
        this.name = string;
        this.type = new WeakReference(clazz);
    }

    public ObjectStreamField(String string, Class clazz, boolean bl) {
        if (string == null || clazz == null) {
            throw new NullPointerException();
        }
        this.name = string;
        this.type = clazz.getClassLoader() == null ? clazz : new WeakReference(clazz);
        this.unshared = bl;
    }

    ObjectStreamField(String string, String string2) {
        if (string2 == null) {
            throw new NullPointerException();
        }
        this.name = string2;
        this.typeString = string.replace('.', '/');
    }

    @Override
    public int compareTo(Object object) {
        boolean bl;
        ObjectStreamField objectStreamField = (ObjectStreamField)object;
        boolean bl2 = this.isPrimitive();
        if (bl2 != (bl = objectStreamField.isPrimitive())) {
            return bl2 ? -1 : 1;
        }
        return this.getName().compareTo(objectStreamField.getName());
    }

    public String getName() {
        return this.name;
    }

    public int getOffset() {
        return this.offset;
    }

    public Class getType() {
        if (this.type instanceof WeakReference) {
            return (Class)((WeakReference)this.type).get();
        }
        return (Class)this.type;
    }

    public char getTypeCode() {
        Class clazz = this.getType();
        if (clazz == Integer.TYPE) {
            return 'I';
        }
        if (clazz == Byte.TYPE) {
            return 'B';
        }
        if (clazz == Character.TYPE) {
            return 'C';
        }
        if (clazz == Short.TYPE) {
            return 'S';
        }
        if (clazz == Boolean.TYPE) {
            return 'Z';
        }
        if (clazz == Long.TYPE) {
            return 'J';
        }
        if (clazz == Float.TYPE) {
            return 'F';
        }
        if (clazz == Double.TYPE) {
            return 'D';
        }
        if (clazz.isArray()) {
            return '[';
        }
        return 'L';
    }

    public String getTypeString() {
        if (this.typeString == null) {
            this.typeString = this.computeTypeString().intern();
        }
        return this.typeString;
    }

    private String computeTypeString() {
        Class clazz = this.getType();
        if (clazz.isArray()) {
            return clazz.getName().replace('.', '/');
        }
        if (this.isPrimitive()) {
            if (clazz == Integer.TYPE) {
                return "I";
            }
            if (clazz == Byte.TYPE) {
                return "B";
            }
            if (clazz == Character.TYPE) {
                return "C";
            }
            if (clazz == Short.TYPE) {
                return "S";
            }
            if (clazz == Boolean.TYPE) {
                return "Z";
            }
            if (clazz == Long.TYPE) {
                return "J";
            }
            if (clazz == Float.TYPE) {
                return "F";
            }
            if (clazz == Double.TYPE) {
                return "D";
            }
            throw new RuntimeException();
        }
        return new StringBuffer("L").append(clazz.getName()).append(';').toString().replace('.', '/');
    }

    public boolean isPrimitive() {
        Class clazz = this.getType();
        return clazz != null && clazz.isPrimitive();
    }

    protected void setOffset(int n) {
        this.offset = n;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append('(').append(this.getName()).append(':').append(this.getType()).append(')').toString();
    }

    static void sortFields(ObjectStreamField[] objectStreamFieldArray) {
        if (objectStreamFieldArray.length > 1) {
            ObjectStreamField$1 objectStreamField$1 = new ObjectStreamField$1();
            Sorter.sort(objectStreamFieldArray, objectStreamField$1);
        }
    }

    void resolve(ClassLoader classLoader) {
        String string;
        if (this.typeString.length() == 1) {
            switch (this.typeString.charAt(0)) {
                case 'I': {
                    this.type = Integer.TYPE;
                    return;
                }
                case 'B': {
                    this.type = Byte.TYPE;
                    return;
                }
                case 'C': {
                    this.type = Character.TYPE;
                    return;
                }
                case 'S': {
                    this.type = Short.TYPE;
                    return;
                }
                case 'Z': {
                    this.type = Boolean.TYPE;
                    return;
                }
                case 'J': {
                    this.type = Long.TYPE;
                    return;
                }
                case 'F': {
                    this.type = Float.TYPE;
                    return;
                }
                case 'D': {
                    this.type = Double.TYPE;
                    return;
                }
            }
        }
        if ((string = this.typeString.replace('/', '.')).charAt(0) == 'L') {
            string = string.substring(1, string.length() - 1);
        }
        try {
            Class clazz = Class.forName(string, false, classLoader);
            this.type = clazz.getClassLoader() == null ? clazz : new WeakReference(clazz);
        }
        catch (ClassNotFoundException classNotFoundException) {}
    }

    boolean getUnshared() {
        return this.unshared;
    }
}

