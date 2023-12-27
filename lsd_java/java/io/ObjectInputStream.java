/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.vm.VM;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EmulatedFields$ObjectSlot;
import java.io.EmulatedFieldsForLoading;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.ObjectInput;
import java.io.ObjectInputStream$1;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectInputStream$InputValidationDesc;
import java.io.ObjectInputValidation;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamConstants;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.WriteAbortedException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;

public class ObjectInputStream
extends InputStream
implements ObjectInput,
ObjectStreamConstants {
    private static InputStream emptyStream = new ByteArrayInputStream(new byte[0]);
    private boolean hasPushbackTC;
    private byte pushbackTC;
    private int nestedLevels;
    private int currentHandle;
    private DataInputStream input;
    private DataInputStream primitiveTypes;
    private InputStream primitiveData = emptyStream;
    private boolean enableResolve;
    private Hashtable objectsRead;
    private Object currentObject;
    private ObjectStreamClass currentClass;
    private ObjectInputStream$InputValidationDesc[] validations;
    private boolean subclassOverridingImplementation;
    private ClassLoader callerClassLoader;
    private boolean mustResolve = true;
    private Integer descriptorHandle;
    private IdentityHashMap readResolveCache;
    static /* synthetic */ Class class$0;

    protected ObjectInputStream() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.subclassOverridingImplementation = true;
    }

    public ObjectInputStream(InputStream inputStream) {
        boolean bl;
        Class clazz = super.getClass();
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.io.ObjectInputStream");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        Class clazz3 = clazz2;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && clazz != clazz3 && (bl = ((Boolean)AccessController.doPrivileged(new ObjectInputStream$1(this, clazz, clazz3))).booleanValue())) {
            securityManager.checkPermission(ObjectStreamConstants.SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.input = inputStream instanceof DataInputStream ? (DataInputStream)inputStream : new DataInputStream(inputStream);
        this.primitiveTypes = new DataInputStream(this);
        this.enableResolve = false;
        this.subclassOverridingImplementation = false;
        this.readResolveCache = new IdentityHashMap();
        this.resetState();
        this.nestedLevels = 0;
        this.primitiveData = this.input;
        this.readStreamHeader();
        this.primitiveData = emptyStream;
    }

    @Override
    public int available() {
        this.checkReadPrimitiveTypes();
        return this.primitiveData.available();
    }

    private void checkReadPrimitiveTypes() {
        int n;
        if (this.primitiveData == this.input || this.primitiveData.available() > 0) {
            return;
        }
        block5: while (true) {
            n = 0;
            if (this.hasPushbackTC) {
                this.hasPushbackTC = false;
            } else {
                n = this.input.read();
                this.pushbackTC = (byte)n;
            }
            switch (this.pushbackTC) {
                case 119: {
                    this.primitiveData = new ByteArrayInputStream(this.readBlockData());
                    return;
                }
                case 122: {
                    this.primitiveData = new ByteArrayInputStream(this.readBlockDataLong());
                    return;
                }
                case 121: {
                    this.resetState();
                    continue block5;
                }
            }
            break;
        }
        if (n != -1) {
            this.pushbackTC();
        }
    }

    @Override
    public void close() {
        this.input.close();
    }

    public void defaultReadObject() {
        if (this.currentObject == null && this.mustResolve) {
            throw new NotActiveException();
        }
        this.readFieldValues(this.currentObject, this.currentClass);
    }

    protected boolean enableResolveObject(boolean bl) {
        SecurityManager securityManager;
        if (bl && (securityManager = System.getSecurityManager()) != null) {
            securityManager.checkPermission(SUBSTITUTION_PERMISSION);
        }
        boolean bl2 = this.enableResolve;
        this.enableResolve = bl;
        return bl2;
    }

    private boolean inSamePackage(Class clazz, Class clazz2) {
        String string = clazz.getName();
        String string2 = clazz2.getName();
        int n = string.lastIndexOf(46);
        int n2 = string2.lastIndexOf(46);
        if (n != n) {
            return false;
        }
        if (n < 0) {
            return true;
        }
        return string.substring(0, n).equals(string2.substring(0, n2));
    }

    private static native Object newInstance(Class clazz, Class clazz2) {
    }

    private int nextHandle() {
        return this.currentHandle++;
    }

    private byte nextTC() {
        if (this.hasPushbackTC) {
            this.hasPushbackTC = false;
        } else {
            this.pushbackTC = this.input.readByte();
        }
        return this.pushbackTC;
    }

    private void pushbackTC() {
        this.hasPushbackTC = true;
    }

    @Override
    public int read() {
        this.checkReadPrimitiveTypes();
        return this.primitiveData.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (byArray != null) {
            if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
                if (n2 == 0) {
                    return 0;
                }
                this.checkReadPrimitiveTypes();
                return this.primitiveData.read(byArray, n, n2);
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    private byte[] readBlockData() {
        byte[] byArray = new byte[this.input.readByte() & 0xFF];
        this.input.readFully(byArray);
        return byArray;
    }

    private byte[] readBlockDataLong() {
        byte[] byArray = new byte[this.input.readInt()];
        this.input.readFully(byArray);
        return byArray;
    }

    @Override
    public boolean readBoolean() {
        return this.primitiveTypes.readBoolean();
    }

    @Override
    public byte readByte() {
        return this.primitiveTypes.readByte();
    }

    @Override
    public char readChar() {
        return this.primitiveTypes.readChar();
    }

    private void discardData() {
        this.primitiveData = emptyStream;
        boolean bl = this.mustResolve;
        this.mustResolve = false;
        while (true) {
            byte by;
            if ((by = this.nextTC()) == 120) {
                this.mustResolve = bl;
                return;
            }
            this.readContent(by);
        }
    }

    private ObjectStreamClass readClassDesc() {
        byte by = this.nextTC();
        switch (by) {
            case 114: {
                return this.readNewClassDesc(false);
            }
            case 125: {
                Class clazz = this.readNewProxyClassDesc();
                ObjectStreamClass objectStreamClass = ObjectStreamClass.lookup(clazz);
                objectStreamClass.setLoadFields(new ObjectStreamField[0]);
                this.registerObjectRead(objectStreamClass, new Integer(this.nextHandle()));
                objectStreamClass.setSuperclass(this.readClassDesc());
                return objectStreamClass;
            }
            case 113: {
                return (ObjectStreamClass)this.readCyclicReference();
            }
            case 112: {
                return null;
            }
        }
        throw new StreamCorruptedException(Msg.getString("K00d2", Integer.toHexString(by & 0xFF)));
    }

    private Object readContent(byte by) {
        switch (by) {
            case 119: {
                return this.readBlockData();
            }
            case 122: {
                return this.readBlockDataLong();
            }
            case 118: {
                return this.readNewClass(false);
            }
            case 114: {
                return this.readNewClassDesc(false);
            }
            case 117: {
                return this.readNewArray(false);
            }
            case 115: {
                return this.readNewObject(false);
            }
            case 116: {
                return this.readNewString(false);
            }
            case 124: {
                return this.readNewLongString(false);
            }
            case 113: {
                return this.readCyclicReference();
            }
            case 112: {
                return null;
            }
            case 123: {
                Exception exception = this.readException();
                throw new WriteAbortedException(Msg.getString("K00d3"), exception);
            }
            case 121: {
                this.resetState();
                return null;
            }
        }
        throw new StreamCorruptedException(Msg.getString("K00d2", Integer.toHexString(by & 0xFF)));
    }

    private Object readNonPrimitiveContent(boolean bl) {
        byte by;
        this.checkReadPrimitiveTypes();
        if (this.primitiveData.available() > 0) {
            OptionalDataException optionalDataException = new OptionalDataException();
            optionalDataException.length = this.primitiveData.available();
            throw optionalDataException;
        }
        block13: while (true) {
            by = this.nextTC();
            switch (by) {
                case 118: {
                    return this.readNewClass(bl);
                }
                case 114: {
                    return this.readNewClassDesc(bl);
                }
                case 117: {
                    return this.readNewArray(bl);
                }
                case 115: {
                    return this.readNewObject(bl);
                }
                case 116: {
                    return this.readNewString(bl);
                }
                case 124: {
                    return this.readNewLongString(bl);
                }
                case 113: {
                    if (bl) {
                        this.readNewHandle();
                        throw new InvalidObjectException(Msg.getString("K0343"));
                    }
                    return this.readCyclicReference();
                }
                case 112: {
                    return null;
                }
                case 123: {
                    Exception exception = this.readException();
                    throw new WriteAbortedException(Msg.getString("K00d3"), exception);
                }
                case 121: {
                    this.resetState();
                    continue block13;
                }
                case 120: {
                    this.pushbackTC();
                    OptionalDataException optionalDataException = new OptionalDataException();
                    optionalDataException.eof = true;
                    throw optionalDataException;
                }
            }
            break;
        }
        throw new StreamCorruptedException(Msg.getString("K00d2", Integer.toHexString(by & 0xFF)));
    }

    private Object readCyclicReference() {
        return this.registeredObjectRead(this.readNewHandle());
    }

    @Override
    public double readDouble() {
        return this.primitiveTypes.readDouble();
    }

    private Exception readException() {
        this.resetSeenObjects();
        Exception exception = (Exception)this.readObject();
        this.resetSeenObjects();
        return exception;
    }

    private void readFieldDescriptors(ObjectStreamClass objectStreamClass) {
        short s = this.input.readShort();
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[s];
        objectStreamClass.setLoadFields(objectStreamFieldArray);
        short s2 = 0;
        while (s2 < s) {
            ObjectStreamField objectStreamField;
            char c2 = (char)this.input.readByte();
            String string = this.input.readUTF();
            boolean bl = ObjectStreamClass.isPrimitiveType(c2);
            String string2 = bl ? String.valueOf(c2) : (String)this.readObject();
            objectStreamFieldArray[s2] = objectStreamField = new ObjectStreamField(string2, string);
            s2 = (short)(s2 + 1);
        }
    }

    public ObjectInputStream$GetField readFields() {
        if (this.currentObject != null) {
            EmulatedFieldsForLoading emulatedFieldsForLoading = new EmulatedFieldsForLoading(this.currentClass);
            this.readFieldValues(emulatedFieldsForLoading);
            return emulatedFieldsForLoading;
        }
        throw new NotActiveException();
    }

    private void readFieldValues(EmulatedFieldsForLoading emulatedFieldsForLoading) {
        EmulatedFields$ObjectSlot[] emulatedFields$ObjectSlotArray = emulatedFieldsForLoading.emulatedFields().slots();
        int n = 0;
        while (n < emulatedFields$ObjectSlotArray.length) {
            emulatedFields$ObjectSlotArray[n].defaulted = false;
            Class clazz = emulatedFields$ObjectSlotArray[n].field.getType();
            if (clazz == Integer.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Integer(this.input.readInt());
            } else if (clazz == Byte.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Byte(this.input.readByte());
            } else if (clazz == Character.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Character(this.input.readChar());
            } else if (clazz == Short.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Short(this.input.readShort());
            } else if (clazz == Boolean.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Boolean(this.input.readBoolean());
            } else if (clazz == Long.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Long(this.input.readLong());
            } else if (clazz == Float.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Float(this.input.readFloat());
            } else if (clazz == Double.TYPE) {
                emulatedFields$ObjectSlotArray[n].fieldValue = new Double(this.input.readDouble());
            } else {
                try {
                    emulatedFields$ObjectSlotArray[n].fieldValue = this.readObject();
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new InvalidClassException(classNotFoundException.toString());
                }
            }
            ++n;
        }
    }

    private void readFieldValues(Object object, ObjectStreamClass objectStreamClass) {
        ObjectStreamField[] objectStreamFieldArray = objectStreamClass.getLoadFields();
        Class clazz = objectStreamClass.forClass();
        if (clazz == null && this.mustResolve) {
            throw new ClassNotFoundException(objectStreamClass.getName());
        }
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            ObjectStreamField objectStreamField = objectStreamFieldArray[n];
            if (objectStreamField.isPrimitive()) {
                try {
                    switch (objectStreamField.getTypeCode()) {
                        case 'B': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readByte());
                            break;
                        }
                        case 'C': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readChar());
                            break;
                        }
                        case 'D': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readDouble());
                            break;
                        }
                        case 'F': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readFloat());
                            break;
                        }
                        case 'I': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readInt());
                            break;
                        }
                        case 'J': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readLong());
                            break;
                        }
                        case 'S': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readShort());
                            break;
                        }
                        case 'Z': {
                            ObjectInputStream.setField(object, clazz, objectStreamField.getName(), this.input.readBoolean());
                            break;
                        }
                        default: {
                            throw new StreamCorruptedException(Msg.getString("K00d5", objectStreamField.getTypeCode()));
                        }
                    }
                }
                catch (NoSuchFieldError noSuchFieldError) {}
            } else {
                String string = objectStreamField.getName();
                boolean bl = false;
                ObjectStreamField objectStreamField2 = objectStreamClass.getField(string);
                if (this.mustResolve && objectStreamField2 == null) {
                    bl = true;
                    this.mustResolve = false;
                }
                Object object2 = objectStreamField2 != null && objectStreamField2.getUnshared() ? this.readUnshared() : this.readObject();
                if (bl) {
                    this.mustResolve = true;
                }
                if (objectStreamField2 != null && object2 != null) {
                    Class clazz2;
                    Class clazz3 = objectStreamField2.getType();
                    if (!clazz3.isAssignableFrom(clazz2 = object2.getClass())) {
                        throw new ClassCastException(Msg.getString("K00d4", new String[]{clazz3.toString(), clazz2.toString(), new StringBuffer(String.valueOf(objectStreamClass.getName())).append(".").append(string).toString()}));
                    }
                    try {
                        ObjectInputStream.objSetField(object, clazz, string, objectStreamField2.getTypeString(), object2);
                    }
                    catch (NoSuchFieldError noSuchFieldError) {}
                }
            }
            ++n;
        }
    }

    @Override
    public float readFloat() {
        return this.primitiveTypes.readFloat();
    }

    @Override
    public void readFully(byte[] byArray) {
        this.primitiveTypes.readFully(byArray);
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) {
        this.primitiveTypes.readFully(byArray, n, n2);
    }

    private void readHierarchy(Object object, ObjectStreamClass objectStreamClass) {
        if (object == null && this.mustResolve) {
            throw new NotActiveException();
        }
        ArrayList arrayList = new ArrayList(32);
        ObjectStreamClass objectStreamClass2 = objectStreamClass;
        while (objectStreamClass2 != null) {
            arrayList.add(0, objectStreamClass2);
            objectStreamClass2 = objectStreamClass2.getSuperclass();
        }
        if (object == null) {
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                ObjectStreamClass objectStreamClass3 = (ObjectStreamClass)iterator.next();
                this.readObjectForClass(object, objectStreamClass3);
            }
        } else {
            ArrayList arrayList2 = new ArrayList(32);
            Class clazz = object.getClass();
            while (clazz != null) {
                Class clazz2 = clazz.getSuperclass();
                if (clazz2 != null) {
                    arrayList2.add(0, clazz);
                }
                clazz = clazz2;
            }
            int n = 0;
            int n2 = 0;
            while (n2 < arrayList2.size()) {
                Class clazz3 = (Class)arrayList2.get(n2);
                int n3 = this.findStreamSuperclass(clazz3, arrayList, n);
                if (n3 == -1) {
                    this.readObjectNoData(object, clazz3);
                } else {
                    int n4 = n;
                    while (n4 <= n3) {
                        this.readObjectForClass(object, (ObjectStreamClass)arrayList.get(n4));
                        ++n4;
                    }
                }
                n = n3 + 1;
                ++n2;
            }
        }
    }

    private int findStreamSuperclass(Class clazz, ArrayList arrayList, int n) {
        int n2 = n;
        while (n2 < arrayList.size()) {
            if (clazz.getName().equals(((ObjectStreamClass)arrayList.get(n2)).getName())) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private void readObjectNoData(Object object, Class clazz) {
        if (!ObjectStreamClass.isSerializable(clazz)) {
            return;
        }
        Method method = ObjectStreamClass.getPrivateReadObjectNoDataMethod(clazz);
        if (method != null) {
            AccessController.doPrivileged(new PriviAction(method));
            try {
                method.invoke(object, new Object[0]);
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getTargetException();
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                throw (ObjectStreamException)throwable;
            }
            catch (IllegalAccessException illegalAccessException) {
                throw new RuntimeException(illegalAccessException.toString());
            }
        }
    }

    private void readObjectForClass(Object object, ObjectStreamClass objectStreamClass) {
        this.currentObject = object;
        this.currentClass = objectStreamClass;
        boolean bl = (objectStreamClass.getFlags() & 1) > 0;
        Class clazz = objectStreamClass.forClass();
        Method method = clazz == null || !this.mustResolve ? null : ObjectStreamClass.getPrivateReadObjectMethod(clazz);
        try {
            if (method != null) {
                AccessController.doPrivileged(new PriviAction(method));
                try {
                    method.invoke(object, new Object[]{this});
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getTargetException();
                    if (throwable instanceof ClassNotFoundException) {
                        throw (ClassNotFoundException)throwable;
                    }
                    if (throwable instanceof RuntimeException) {
                        throw (RuntimeException)throwable;
                    }
                    if (throwable instanceof Error) {
                        throw (Error)throwable;
                    }
                    throw (IOException)throwable;
                }
                catch (IllegalAccessException illegalAccessException) {
                    throw new RuntimeException(illegalAccessException.toString());
                }
            } else {
                this.defaultReadObject();
            }
            if (bl) {
                this.discardData();
            }
        }
        finally {
            this.currentObject = null;
            this.currentClass = null;
        }
    }

    @Override
    public int readInt() {
        return this.primitiveTypes.readInt();
    }

    @Override
    public String readLine() {
        return this.primitiveTypes.readLine();
    }

    @Override
    public long readLong() {
        return this.primitiveTypes.readLong();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Object readNewArray(boolean bl) {
        ObjectStreamClass objectStreamClass = this.readClassDesc();
        if (objectStreamClass == null) {
            throw new InvalidClassException(Msg.getString("K00d1"));
        }
        Integer n = new Integer(this.nextHandle());
        int n2 = this.input.readInt();
        Class clazz = objectStreamClass.forClass();
        Class clazz2 = clazz.getComponentType();
        Object object = Array.newInstance(clazz2, n2);
        if (!bl) {
            this.registerObjectRead(object, n);
        }
        if (clazz2.isPrimitive()) {
            if (clazz2 == Integer.TYPE) {
                int[] nArray = (int[])object;
                int n3 = 0;
                while (n3 < n2) {
                    nArray[n3] = this.input.readInt();
                    ++n3;
                }
            } else if (clazz2 == Byte.TYPE) {
                byte[] byArray = (byte[])object;
                this.input.readFully(byArray, 0, n2);
            } else if (clazz2 == Character.TYPE) {
                char[] cArray = (char[])object;
                int n4 = 0;
                while (n4 < n2) {
                    cArray[n4] = this.input.readChar();
                    ++n4;
                }
            } else if (clazz2 == Short.TYPE) {
                short[] sArray = (short[])object;
                int n5 = 0;
                while (n5 < n2) {
                    sArray[n5] = this.input.readShort();
                    ++n5;
                }
            } else if (clazz2 == Boolean.TYPE) {
                boolean[] blArray = (boolean[])object;
                int n6 = 0;
                while (n6 < n2) {
                    blArray[n6] = this.input.readBoolean();
                    ++n6;
                }
            } else if (clazz2 == Long.TYPE) {
                long[] lArray = (long[])object;
                int n7 = 0;
                while (n7 < n2) {
                    lArray[n7] = this.input.readLong();
                    ++n7;
                }
            } else if (clazz2 == Float.TYPE) {
                float[] fArray = (float[])object;
                int n8 = 0;
                while (n8 < n2) {
                    fArray[n8] = this.input.readFloat();
                    ++n8;
                }
            } else {
                if (clazz2 != Double.TYPE) throw new ClassNotFoundException(Msg.getString("K00d7", objectStreamClass.getName()));
                double[] dArray = (double[])object;
                int n9 = 0;
                while (n9 < n2) {
                    dArray[n9] = this.input.readDouble();
                    ++n9;
                }
            }
        } else {
            Object[] objectArray = (Object[])object;
            int n10 = 0;
            while (n10 < n2) {
                objectArray[n10] = this.readObject();
                ++n10;
            }
        }
        if (!this.enableResolve) return object;
        object = this.resolveObject(object);
        this.registerObjectRead(object, n);
        return object;
    }

    private Class readNewClass(boolean bl) {
        ObjectStreamClass objectStreamClass = this.readClassDesc();
        if (objectStreamClass != null) {
            Integer n = new Integer(this.nextHandle());
            Class clazz = objectStreamClass.forClass();
            if (clazz != null && !bl) {
                this.registerObjectRead(clazz, n);
            }
            return clazz;
        }
        throw new InvalidClassException(Msg.getString("K00d1"));
    }

    private ObjectStreamClass readNewClassDesc(boolean bl) {
        ObjectStreamClass objectStreamClass;
        block4: {
            this.primitiveData = this.input;
            Integer n = this.descriptorHandle;
            this.descriptorHandle = new Integer(this.nextHandle());
            objectStreamClass = this.readClassDescriptor();
            if (this.descriptorHandle != null && !bl) {
                this.registerObjectRead(objectStreamClass, this.descriptorHandle);
            }
            this.descriptorHandle = n;
            this.primitiveData = emptyStream;
            try {
                objectStreamClass.setClass(this.resolveClass(objectStreamClass));
                this.verifySUID(objectStreamClass);
            }
            catch (ClassNotFoundException classNotFoundException) {
                if (!this.mustResolve) break block4;
                throw classNotFoundException;
            }
        }
        ObjectStreamField[] objectStreamFieldArray = objectStreamClass.getLoadFields();
        ClassLoader classLoader = objectStreamClass.forClass() == null ? this.callerClassLoader : objectStreamClass.forClass().getClassLoader();
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            objectStreamFieldArray[n].resolve(classLoader);
            ++n;
        }
        this.discardData();
        objectStreamClass.setSuperclass(this.readClassDesc());
        return objectStreamClass;
    }

    private Class readNewProxyClassDesc() {
        int n = this.input.readInt();
        String[] stringArray = new String[n];
        int n2 = 0;
        while (n2 < n) {
            stringArray[n2] = this.input.readUTF();
            ++n2;
        }
        Class clazz = this.resolveProxyClass(stringArray);
        this.discardData();
        return clazz;
    }

    protected ObjectStreamClass readClassDescriptor() {
        if (this.descriptorHandle == null) {
            throw new NotActiveException();
        }
        ObjectStreamClass objectStreamClass = new ObjectStreamClass();
        objectStreamClass.setName(this.input.readUTF());
        objectStreamClass.setSerialVersionUID(this.input.readLong());
        objectStreamClass.setFlags(this.input.readByte());
        this.registerObjectRead(objectStreamClass, this.descriptorHandle);
        this.descriptorHandle = null;
        this.readFieldDescriptors(objectStreamClass);
        return objectStreamClass;
    }

    protected Class resolveProxyClass(String[] stringArray) {
        ClassLoader classLoader = VM.getNonBootstrapClassLoader();
        Class[] classArray = new Class[stringArray.length];
        int n = 0;
        while (n < stringArray.length) {
            classArray[n] = Class.forName(stringArray[n], false, classLoader);
            ++n;
        }
        try {
            return Proxy.getProxyClass(classLoader, classArray);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new ClassNotFoundException(illegalArgumentException.toString(), illegalArgumentException);
        }
    }

    private Integer readNewHandle() {
        return new Integer(this.input.readInt());
    }

    private Object readNewObject(boolean bl) {
        Object object;
        Object object2;
        Object object3;
        ObjectStreamClass objectStreamClass = this.readClassDesc();
        if (objectStreamClass == null) {
            throw new InvalidClassException(Msg.getString("K00d1"));
        }
        Integer n = new Integer(this.nextHandle());
        boolean bl2 = (objectStreamClass.getFlags() & 4) > 0;
        boolean bl3 = (objectStreamClass.getFlags() & 2) > 0;
        Class clazz = objectStreamClass.forClass();
        Object object4 = null;
        if (clazz != null) {
            Class clazz2 = clazz;
            if (bl3) {
                while (clazz2 != null & ObjectStreamClass.isSerializable(clazz2)) {
                    clazz2 = clazz2.getSuperclass();
                }
            }
            try {
                object3 = clazz2.getDeclaredConstructor(ObjectStreamClass.EMPTY_CONSTRUCTOR_PARAM_TYPES);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object3 = null;
            }
            if (object3 == null) {
                throw new InvalidClassException(clazz2.getName(), Msg.getString("K00dc"));
            }
            int n2 = ((Constructor)object3).getModifiers();
            if (Modifier.isPrivate(n2) || bl2 && !Modifier.isPublic(n2)) {
                throw new InvalidClassException(clazz2.getName(), Msg.getString("K00dc"));
            }
            if (!(Modifier.isPublic(n2) || Modifier.isProtected(n2) || this.inSamePackage(clazz2, clazz))) {
                throw new InvalidClassException(clazz2.getName(), Msg.getString("K00dc"));
            }
            object2 = ObjectInputStream.newInstance(clazz, clazz2);
            if (!bl) {
                this.registerObjectRead(object2, n);
            }
            object4 = object2;
        } else {
            object2 = null;
        }
        try {
            this.currentObject = object2;
            this.currentClass = objectStreamClass;
            if (bl2) {
                boolean bl4;
                boolean bl5 = bl4 = (objectStreamClass.getFlags() & 8) > 0;
                if (!bl4) {
                    this.primitiveData = this.input;
                }
                if (this.mustResolve) {
                    object3 = (Externalizable)object2;
                    object3.readExternal(this);
                }
                if (bl4) {
                    this.discardData();
                } else {
                    this.primitiveData = emptyStream;
                }
            } else {
                this.readHierarchy(object2, objectStreamClass);
            }
        }
        finally {
            this.currentObject = null;
            this.currentClass = null;
        }
        if (clazz != null && (object = this.readResolveCache.get(clazz)) != this) {
            if (object == null) {
                object3 = ObjectStreamClass.methodReadResolve(clazz);
                if (object3 == null) {
                    this.readResolveCache.put(clazz, this);
                    object = null;
                } else {
                    AccessController.doPrivileged(new PriviAction((AccessibleObject)object3));
                    this.readResolveCache.put(clazz, object3);
                    object = object3;
                }
            }
            if (object != null) {
                try {
                    object2 = ((Method)object).invoke(object2, null);
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (InvocationTargetException invocationTargetException) {
                    Throwable throwable = invocationTargetException.getTargetException();
                    if (throwable instanceof ObjectStreamException) {
                        throw (ObjectStreamException)throwable;
                    }
                    if (throwable instanceof Error) {
                        throw (Error)throwable;
                    }
                    throw (RuntimeException)throwable;
                }
            }
        }
        if (object2 != null && this.enableResolve) {
            object2 = this.resolveObject(object2);
        }
        if (object4 != object2 && !bl) {
            this.registerObjectRead(object2, n);
        }
        return object2;
    }

    private Object readNewString(boolean bl) {
        Object object = this.input.readUTF();
        if (this.enableResolve) {
            object = this.resolveObject(object);
        }
        int n = this.nextHandle();
        if (!bl) {
            this.registerObjectRead(object, new Integer(n));
        }
        return object;
    }

    private Object readNewLongString(boolean bl) {
        long l = this.input.readLong();
        Object object = this.input.decodeUTF((int)l);
        if (this.enableResolve) {
            object = this.resolveObject(object);
        }
        int n = this.nextHandle();
        if (!bl) {
            this.registerObjectRead(object, new Integer(n));
        }
        return object;
    }

    @Override
    public final Object readObject() {
        return this.readObject(false);
    }

    public Object readUnshared() {
        return this.readObject(true);
    }

    private Object readObject(boolean bl) {
        Object object;
        boolean bl2 = this.primitiveData == this.input;
        if (bl2) {
            this.primitiveData = emptyStream;
        }
        if (this.subclassOverridingImplementation && !bl) {
            return this.readObjectOverride();
        }
        try {
            if (++this.nestedLevels == 1) {
                this.callerClassLoader = VM.getNonBootstrapClassLoader();
            }
            object = this.readNonPrimitiveContent(bl);
            if (bl2) {
                this.primitiveData = this.input;
            }
        }
        finally {
            if (--this.nestedLevels == 0) {
                this.callerClassLoader = null;
            }
        }
        if (this.nestedLevels == 0 && this.validations != null) {
            try {
                int n = 0;
                while (n < this.validations.length) {
                    this.validations[n].validator.validateObject();
                    ++n;
                }
            }
            finally {
                this.validations = null;
            }
        }
        return object;
    }

    protected Object readObjectOverride() {
        throw new IOException();
    }

    @Override
    public short readShort() {
        return this.primitiveTypes.readShort();
    }

    protected void readStreamHeader() {
        if (this.input.readShort() == -21267 && this.input.readShort() == 5) {
            return;
        }
        throw new StreamCorruptedException();
    }

    @Override
    public int readUnsignedByte() {
        return this.primitiveTypes.readUnsignedByte();
    }

    @Override
    public int readUnsignedShort() {
        return this.primitiveTypes.readUnsignedShort();
    }

    @Override
    public String readUTF() {
        return this.primitiveTypes.readUTF();
    }

    private Object registeredObjectRead(Integer n) {
        return this.objectsRead.get(n);
    }

    private void registerObjectRead(Object object, Integer n) {
        this.objectsRead.put(n, object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public synchronized void registerValidation(ObjectInputValidation objectInputValidation, int n) {
        if (objectInputValidation == null) throw new InvalidObjectException(Msg.getString("K00d9"));
        Object object = this.currentObject;
        if (object == null) throw new NotActiveException();
        ObjectInputStream$InputValidationDesc objectInputStream$InputValidationDesc = new ObjectInputStream$InputValidationDesc(this);
        objectInputStream$InputValidationDesc.validator = objectInputValidation;
        objectInputStream$InputValidationDesc.priority = n;
        if (this.validations == null) {
            this.validations = new ObjectInputStream$InputValidationDesc[1];
            this.validations[0] = objectInputStream$InputValidationDesc;
            return;
        } else {
            int n2 = 0;
            while (n2 < this.validations.length) {
                ObjectInputStream$InputValidationDesc objectInputStream$InputValidationDesc2 = this.validations[n2];
                if (n >= objectInputStream$InputValidationDesc2.priority) break;
                ++n2;
            }
            ObjectInputStream$InputValidationDesc[] objectInputStream$InputValidationDescArray = this.validations;
            int n3 = objectInputStream$InputValidationDescArray.length;
            this.validations = new ObjectInputStream$InputValidationDesc[n3 + 1];
            System.arraycopy((Object)objectInputStream$InputValidationDescArray, 0, (Object)this.validations, 0, n2);
            System.arraycopy((Object)objectInputStream$InputValidationDescArray, n2, (Object)this.validations, n2 + 1, n3 - n2);
            this.validations[n2] = objectInputStream$InputValidationDesc;
        }
    }

    private void resetSeenObjects() {
        this.objectsRead = new Hashtable();
        this.currentHandle = 32256;
        this.primitiveData = emptyStream;
    }

    private void resetState() {
        this.resetSeenObjects();
        this.hasPushbackTC = false;
        this.pushbackTC = 0;
    }

    protected Class resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return Class.forName(objectStreamClass.getName(), true, this.callerClassLoader);
        }
        catch (ClassNotFoundException classNotFoundException) {
            String string = objectStreamClass.getName();
            if (string.equals("int")) {
                return Integer.TYPE;
            }
            if (string.equals("long")) {
                return Long.TYPE;
            }
            if (string.equals("char")) {
                return Character.TYPE;
            }
            if (string.equals("byte")) {
                return Byte.TYPE;
            }
            if (string.equals("boolean")) {
                return Boolean.TYPE;
            }
            if (string.equals("double")) {
                return Double.TYPE;
            }
            if (string.equals("float")) {
                return Float.TYPE;
            }
            if (string.equals("void")) {
                return Void.TYPE;
            }
            if (string.equals("short")) {
                return Short.TYPE;
            }
            throw classNotFoundException;
        }
    }

    protected Object resolveObject(Object object) {
        return object;
    }

    private static native void setField(Object object, Class clazz, String string, byte by) {
    }

    private static native void setField(Object object, Class clazz, String string, char c2) {
    }

    private static native void setField(Object object, Class clazz, String string, double d2) {
    }

    private static native void setField(Object object, Class clazz, String string, float f2) {
    }

    private static native void setField(Object object, Class clazz, String string, int n) {
    }

    private static native void setField(Object object, Class clazz, String string, long l) {
    }

    private static native void objSetField(Object object, Class clazz, String string, String string2, Object object2) {
    }

    private static native void setField(Object object, Class clazz, String string, short s) {
    }

    private static native void setField(Object object, Class clazz, String string, boolean bl) {
    }

    @Override
    public int skipBytes(int n) {
        int n2 = 0;
        while (n2 < n) {
            this.checkReadPrimitiveTypes();
            long l = this.primitiveData.skip(n - n2);
            if (l == 0L) {
                return n2;
            }
            n2 += (int)l;
        }
        return n;
    }

    private void verifySUID(ObjectStreamClass objectStreamClass) {
        Class clazz = objectStreamClass.forClass();
        ObjectStreamClass objectStreamClass2 = ObjectStreamClass.lookupStreamClass(clazz);
        if (objectStreamClass.getSerialVersionUID() != objectStreamClass2.getSerialVersionUID()) {
            throw new InvalidClassException(objectStreamClass.getName(), Msg.getString("K00da", objectStreamClass, objectStreamClass2));
        }
    }
}

