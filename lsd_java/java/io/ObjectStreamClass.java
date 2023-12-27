/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.util.Sorter;
import com.ibm.oti.util.Sorter$Comparator;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectStreamClass$1;
import java.io.ObjectStreamClass$2;
import java.io.ObjectStreamClass$3;
import java.io.ObjectStreamClass$4;
import java.io.ObjectStreamField;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.WeakHashMap;

public class ObjectStreamClass
implements Serializable {
    static final long serialVersionUID;
    private static final String UID_FIELD_NAME;
    private static final int CLASS_MODIFIERS_MASK;
    private static final Class[] READ_PARAM_TYPES;
    private static final Class[] WRITE_PARAM_TYPES;
    static final Class[] EMPTY_CONSTRUCTOR_PARAM_TYPES;
    private static final Class VOID_CLASS;
    static final Class[] UNSHARED_PARAM_TYPES;
    public static final ObjectStreamField[] NO_FIELDS;
    static final Class ARRAY_OF_FIELDS;
    private static final String CLINIT_NAME;
    private static final int CLINIT_MODIFIERS;
    private static final String CLINIT_SIGNATURE;
    private static final Class SERIALIZABLE;
    private static final Class EXTERNALIZABLE;
    static final Class STRINGCLASS;
    static final Class CLASSCLASS;
    static final Class OBJECTSTREAMCLASSCLASS;
    private static final WeakHashMap classesAndDescriptors;
    private String className;
    private WeakReference resolvedClass;
    private long svUID;
    private byte flags;
    private ObjectStreamClass superclass;
    private ObjectStreamField[] fields;
    private ObjectStreamField[] loadFields;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;
    static /* synthetic */ Class class$4;
    static /* synthetic */ Class class$5;
    static /* synthetic */ Class class$6;
    static /* synthetic */ Class class$7;

    static {
        ObjectStreamClass.oneTimeInitialization();
        CLASS_MODIFIERS_MASK = 1553;
        READ_PARAM_TYPES = new Class[1];
        WRITE_PARAM_TYPES = new Class[1];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.io.ObjectInputStream");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        ObjectStreamClass.READ_PARAM_TYPES[0] = clazz;
        Class clazz2 = class$1;
        if (clazz2 == null) {
            try {
                clazz2 = class$1 = Class.forName("java.io.ObjectOutputStream");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        ObjectStreamClass.WRITE_PARAM_TYPES[0] = clazz2;
        EMPTY_CONSTRUCTOR_PARAM_TYPES = new Class[0];
        VOID_CLASS = Void.TYPE;
        UNSHARED_PARAM_TYPES = new Class[1];
        Class clazz3 = class$2;
        if (clazz3 == null) {
            try {
                clazz3 = class$2 = Class.forName("java.lang.Object");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        ObjectStreamClass.UNSHARED_PARAM_TYPES[0] = clazz3;
        NO_FIELDS = new ObjectStreamField[0];
        try {
            ARRAY_OF_FIELDS = Class.forName("[Ljava.io.ObjectStreamField;");
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException();
        }
        Class clazz4 = class$3;
        if (clazz4 == null) {
            try {
                clazz4 = class$3 = Class.forName("java.io.Serializable");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        SERIALIZABLE = clazz4;
        Class clazz5 = class$4;
        if (clazz5 == null) {
            try {
                clazz5 = class$4 = Class.forName("java.io.Externalizable");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        EXTERNALIZABLE = clazz5;
        Class clazz6 = class$5;
        if (clazz6 == null) {
            try {
                clazz6 = class$5 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        STRINGCLASS = clazz6;
        Class clazz7 = class$6;
        if (clazz7 == null) {
            try {
                clazz7 = class$6 = Class.forName("java.lang.Class");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        CLASSCLASS = clazz7;
        Class clazz8 = class$7;
        if (clazz8 == null) {
            try {
                clazz8 = class$7 = Class.forName("java.io.ObjectStreamClass");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        OBJECTSTREAMCLASSCLASS = clazz8;
        classesAndDescriptors = new WeakHashMap();
    }

    private static native void oneTimeInitialization() {
    }

    ObjectStreamClass() {
    }

    private static ObjectStreamClass addToCache(Class clazz, boolean bl) {
        boolean bl2;
        ObjectStreamClass objectStreamClass = new ObjectStreamClass();
        classesAndDescriptors.put(clazz, objectStreamClass);
        objectStreamClass.setName(clazz.getName());
        objectStreamClass.setClass(clazz);
        Class clazz2 = clazz.getSuperclass();
        if (clazz2 != null) {
            objectStreamClass.setSuperclass(ObjectStreamClass.lookup(clazz2));
        }
        Field[] fieldArray = null;
        if (bl) {
            fieldArray = clazz.getDeclaredFields();
            objectStreamClass.setSerialVersionUID(ObjectStreamClass.computeSerialVersionUID(clazz, fieldArray));
        }
        if ((bl2 = ObjectStreamClass.isSerializable(clazz)) && !clazz.isArray()) {
            if (fieldArray == null) {
                fieldArray = clazz.getDeclaredFields();
            }
            objectStreamClass.buildFieldDescriptors(fieldArray);
        } else {
            objectStreamClass.setFields(new ObjectStreamField[0]);
        }
        byte by = 0;
        boolean bl3 = ObjectStreamClass.isExternalizable(clazz);
        if (bl3) {
            by = (byte)(by | 4);
        } else if (bl2) {
            by = (byte)(by | 2);
        }
        if (ObjectStreamClass.getPrivateWriteObjectMethod(clazz) != null) {
            by = (byte)(by | 1);
        }
        objectStreamClass.setFlags(by);
        return objectStreamClass;
    }

    void buildFieldDescriptors(Field[] fieldArray) {
        int n;
        boolean bl;
        Field field = ObjectStreamClass.fieldSerialPersistentFields(this.forClass());
        boolean bl2 = bl = field == null;
        if (!bl) {
            AccessController.doPrivileged(new PriviAction(field));
            try {
                this.fields = (ObjectStreamField[])field.get(null);
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException();
            }
        } else {
            Vector vector = new Vector(fieldArray.length);
            n = 0;
            while (n < fieldArray.length) {
                boolean bl3;
                Field field2 = fieldArray[n];
                int n2 = field2.getModifiers();
                boolean bl4 = bl3 = !Modifier.isStatic(n2) && !Modifier.isTransient(n2);
                if (bl3) {
                    ObjectStreamField objectStreamField = new ObjectStreamField(field2.getName(), field2.getType());
                    vector.addElement(objectStreamField);
                }
                ++n;
            }
            if (vector.size() == 0) {
                this.fields = NO_FIELDS;
            } else {
                this.fields = new ObjectStreamField[vector.size()];
                vector.copyInto(this.fields);
            }
        }
        ObjectStreamField.sortFields(this.fields);
        int n3 = 0;
        n = 0;
        int n4 = 0;
        while (n4 < this.fields.length) {
            Class clazz = this.fields[n4].getType();
            if (clazz.isPrimitive()) {
                this.fields[n4].offset = n3;
                n3 += this.primitiveSize(clazz);
            } else {
                this.fields[n4].offset = n++;
            }
            ++n4;
        }
    }

    private static long computeSerialVersionUID(Class clazz, Field[] fieldArray) {
        Object object;
        MessageDigest messageDigest;
        Object object2;
        int n = 0;
        while (n < fieldArray.length) {
            int n2;
            object2 = fieldArray[n];
            if (Long.TYPE == ((Field)object2).getType() && Modifier.isStatic(n2 = ((Field)object2).getModifiers()) && Modifier.isFinal(n2) && "serialVersionUID".equals(((Field)object2).getName())) {
                AccessController.doPrivileged(new PriviAction((AccessibleObject)object2));
                try {
                    return ((Field)object2).getLong(null);
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new RuntimeException(Msg.getString("K0071", illegalAccessException.toString()));
                }
            }
            ++n;
        }
        try {
            messageDigest = MessageDigest.getInstance("SHA");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new Error(noSuchAlgorithmException.toString());
        }
        object2 = new ByteArrayOutputStream();
        try {
            int n3;
            Object[] objectArray;
            int n4;
            int n5;
            Object[] objectArray2;
            object = new DataOutputStream((OutputStream)object2);
            ((DataOutputStream)object).writeUTF(clazz.getName());
            int n6 = CLASS_MODIFIERS_MASK & clazz.getModifiers();
            boolean bl = clazz.isArray();
            if (bl) {
                n6 |= 0x400;
            }
            if (clazz.isInterface() && !Modifier.isPublic(n6)) {
                n6 &= 0xFFFFFBFF;
            }
            ((DataOutputStream)object).writeInt(n6);
            if (!bl) {
                objectArray2 = clazz.getInterfaces();
                if (objectArray2.length > 1) {
                    ObjectStreamClass$1 objectStreamClass$1 = new ObjectStreamClass$1();
                    Sorter.sort(objectArray2, objectStreamClass$1);
                }
                int n7 = 0;
                while (n7 < objectArray2.length) {
                    ((DataOutputStream)object).writeUTF(((Class)objectArray2[n7]).getName());
                    ++n7;
                }
            }
            if (fieldArray.length > 1) {
                objectArray2 = new ObjectStreamClass$2();
                Sorter.sort(fieldArray, (Sorter$Comparator)objectArray2);
            }
            int n8 = 0;
            while (n8 < fieldArray.length) {
                Field field = fieldArray[n8];
                n5 = field.getModifiers();
                int n9 = n4 = Modifier.isPrivate(n5) && (Modifier.isTransient(n5) || Modifier.isStatic(n5)) ? 1 : 0;
                if (n4 == 0) {
                    ((DataOutputStream)object).writeUTF(field.getName());
                    ((DataOutputStream)object).writeInt(n5);
                    ((DataOutputStream)object).writeUTF(ObjectStreamClass.descriptorForFieldSignature(ObjectStreamClass.getFieldSignature(field)));
                }
                ++n8;
            }
            if (ObjectStreamClass.hasClinit(clazz)) {
                ((DataOutputStream)object).writeUTF("<clinit>");
                ((DataOutputStream)object).writeInt(8);
                ((DataOutputStream)object).writeUTF("()V");
            }
            if ((objectArray = clazz.getDeclaredConstructors()).length > 1) {
                ObjectStreamClass$3 objectStreamClass$3 = new ObjectStreamClass$3();
                Sorter.sort(objectArray, objectStreamClass$3);
            }
            int n10 = 0;
            while (n10 < objectArray.length) {
                Object object3 = objectArray[n10];
                n4 = ((Constructor)object3).getModifiers();
                n3 = Modifier.isPrivate(n4);
                if (n3 == 0) {
                    ((DataOutputStream)object).writeUTF("<init>");
                    ((DataOutputStream)object).writeInt(n4);
                    ((DataOutputStream)object).writeUTF(ObjectStreamClass.descriptorForSignature(ObjectStreamClass.getConstructorSignature((Constructor)object3)));
                }
                ++n10;
            }
            Object[] objectArray3 = clazz.getDeclaredMethods();
            if (objectArray3.length > 1) {
                ObjectStreamClass$4 objectStreamClass$4 = new ObjectStreamClass$4();
                Sorter.sort(objectArray3, objectStreamClass$4);
            }
            n5 = 0;
            while (n5 < objectArray3.length) {
                Object object4 = objectArray3[n5];
                n3 = ((Method)object4).getModifiers();
                boolean bl2 = Modifier.isPrivate(n3);
                if (!bl2) {
                    ((DataOutputStream)object).writeUTF(((Method)object4).getName());
                    ((DataOutputStream)object).writeInt(n3);
                    ((DataOutputStream)object).writeUTF(ObjectStreamClass.descriptorForSignature(ObjectStreamClass.getMethodSignature((Method)object4)));
                }
                ++n5;
            }
        }
        catch (IOException iOException) {
            throw new RuntimeException(Msg.getString("K0072", iOException.toString()));
        }
        object = messageDigest.digest(((ByteArrayOutputStream)object2).toByteArray());
        return ObjectStreamClass.littleEndianLongAt((byte[])object, 0);
    }

    private static String descriptorForFieldSignature(String string) {
        return string.replace('.', '/');
    }

    private static String descriptorForSignature(String string) {
        return string.substring(string.indexOf("("));
    }

    static Field fieldSerialPersistentFields(Class clazz) {
        try {
            Field field = clazz.getDeclaredField("serialPersistentFields");
            int n = field.getModifiers();
            if (Modifier.isStatic(n) && Modifier.isPrivate(n) && Modifier.isFinal(n) && field.getType() == ARRAY_OF_FIELDS) {
                return field;
            }
        }
        catch (NoSuchFieldException noSuchFieldException) {}
        return null;
    }

    public Class forClass() {
        if (this.resolvedClass != null) {
            return (Class)this.resolvedClass.get();
        }
        return null;
    }

    static native String getConstructorSignature(Constructor constructor) {
    }

    public ObjectStreamField getField(String string) {
        ObjectStreamField[] objectStreamFieldArray = this.fields();
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            ObjectStreamField objectStreamField = objectStreamFieldArray[n];
            if (objectStreamField.getName().equals(string)) {
                return objectStreamField;
            }
            ++n;
        }
        return null;
    }

    ObjectStreamField[] fields() {
        if (this.fields == null) {
            Class clazz = this.forClass();
            if (clazz != null && ObjectStreamClass.isSerializable(clazz) && !clazz.isArray()) {
                this.buildFieldDescriptors(clazz.getDeclaredFields());
            } else {
                this.setFields(new ObjectStreamField[0]);
            }
        }
        return this.fields;
    }

    public ObjectStreamField[] getFields() {
        return (ObjectStreamField[])this.fields().clone();
    }

    ObjectStreamField[] getLoadFields() {
        return this.loadFields;
    }

    private static native String getFieldSignature(Field field) {
    }

    byte getFlags() {
        return this.flags;
    }

    static native String getMethodSignature(Method method) {
    }

    public String getName() {
        return this.className;
    }

    public long getSerialVersionUID() {
        return this.svUID;
    }

    ObjectStreamClass getSuperclass() {
        return this.superclass;
    }

    private static native boolean hasClinit(Class clazz) {
    }

    static Method getPrivateReadObjectMethod(Class clazz) {
        try {
            Method method = clazz.getDeclaredMethod("readObject", READ_PARAM_TYPES);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == VOID_CLASS) {
                return method;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        return null;
    }

    static Method getPrivateReadObjectNoDataMethod(Class clazz) {
        try {
            Method method = clazz.getDeclaredMethod("readObjectNoData", EMPTY_CONSTRUCTOR_PARAM_TYPES);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == VOID_CLASS) {
                return method;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        return null;
    }

    static Method getPrivateWriteObjectMethod(Class clazz) {
        try {
            Method method = clazz.getDeclaredMethod("writeObject", WRITE_PARAM_TYPES);
            if (Modifier.isPrivate(method.getModifiers()) && method.getReturnType() == VOID_CLASS) {
                return method;
            }
        }
        catch (NoSuchMethodException noSuchMethodException) {}
        return null;
    }

    static boolean isExternalizable(Class clazz) {
        return EXTERNALIZABLE.isAssignableFrom(clazz);
    }

    static boolean isPrimitiveType(char c2) {
        return c2 != '[' && c2 != 'L';
    }

    static boolean isSerializable(Class clazz) {
        return SERIALIZABLE.isAssignableFrom(clazz);
    }

    private static long littleEndianLongAt(byte[] byArray, int n) {
        long l = 0L;
        int n2 = n + 7;
        while (n2 >= n) {
            l = (l << 8) + (long)(byArray[n2] & 0xFF);
            --n2;
        }
        return l;
    }

    public static ObjectStreamClass lookup(Class clazz) {
        boolean bl = ObjectStreamClass.isSerializable(clazz);
        boolean bl2 = ObjectStreamClass.isExternalizable(clazz);
        if (!bl && !bl2) {
            return null;
        }
        return ObjectStreamClass.lookupStreamClass(clazz, true);
    }

    static ObjectStreamClass lookupStreamClass(Class clazz) {
        return ObjectStreamClass.lookupStreamClass(clazz, ObjectStreamClass.isSerializable(clazz) || ObjectStreamClass.isExternalizable(clazz));
    }

    private static synchronized ObjectStreamClass lookupStreamClass(Class clazz, boolean bl) {
        ObjectStreamClass objectStreamClass = (ObjectStreamClass)classesAndDescriptors.get(clazz);
        if (objectStreamClass != null) {
            return objectStreamClass;
        }
        return ObjectStreamClass.addToCache(clazz, bl);
    }

    static Method methodReadResolve(Class clazz) {
        Class clazz2 = clazz;
        while (clazz2 != null) {
            try {
                Method method = clazz2.getDeclaredMethod("readResolve", null);
                if (clazz2 == clazz || (method.getModifiers() & 2) == 0) {
                    return method;
                }
                return null;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                clazz2 = clazz2.getSuperclass();
            }
        }
        return null;
    }

    static Method methodWriteReplace(Class clazz) {
        Class clazz2 = clazz;
        while (clazz2 != null) {
            try {
                Method method = clazz2.getDeclaredMethod("writeReplace", null);
                if (clazz2 == clazz || (method.getModifiers() & 2) == 0) {
                    return method;
                }
                return null;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                clazz2 = clazz2.getSuperclass();
            }
        }
        return null;
    }

    void setClass(Class clazz) {
        this.resolvedClass = new WeakReference(clazz);
    }

    void setFields(ObjectStreamField[] objectStreamFieldArray) {
        this.fields = objectStreamFieldArray;
    }

    void setLoadFields(ObjectStreamField[] objectStreamFieldArray) {
        this.loadFields = objectStreamFieldArray;
    }

    void setFlags(byte by) {
        this.flags = by;
    }

    void setName(String string) {
        this.className = string;
    }

    void setSerialVersionUID(long l) {
        this.svUID = l;
    }

    void setSuperclass(ObjectStreamClass objectStreamClass) {
        this.superclass = objectStreamClass;
    }

    private int primitiveSize(Class clazz) {
        if (clazz == Byte.TYPE || clazz == Boolean.TYPE) {
            return 1;
        }
        if (clazz == Short.TYPE || clazz == Character.TYPE) {
            return 2;
        }
        if (clazz == Integer.TYPE || clazz == Float.TYPE) {
            return 4;
        }
        if (clazz == Long.TYPE || clazz == Double.TYPE) {
            return 8;
        }
        return 0;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(this.getName())).append(": static final long serialVersionUID =").append(this.getSerialVersionUID()).append("L;").toString();
    }
}

