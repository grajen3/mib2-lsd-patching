/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EmulatedFields;
import java.io.EmulatedFields$ObjectSlot;
import java.io.EmulatedFieldsForDumping;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamClass;
import java.io.ObjectStreamConstants;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.util.IdentityHashMap;

public class ObjectOutputStream
extends OutputStream
implements ObjectOutput,
ObjectStreamConstants {
    private int nestedLevels;
    private DataOutputStream output;
    private boolean enableReplace;
    private DataOutputStream primitiveTypes;
    private ByteArrayOutputStream primitiveTypesBuffer;
    private IdentityHashMap objectsWritten;
    private int currentHandle;
    private Object currentObject;
    private ObjectStreamClass currentClass;
    private int protocolVersion;
    private StreamCorruptedException nestedException;
    private EmulatedFieldsForDumping currentPutField;
    private boolean subclassOverridingImplementation;
    private IdentityHashMap writeReplaceCache;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    protected ObjectOutputStream() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
        this.subclassOverridingImplementation = true;
    }

    public ObjectOutputStream(OutputStream outputStream) {
        Class clazz;
        Class clazz2 = super.getClass();
        Class clazz3 = class$0;
        if (clazz3 == null) {
            try {
                clazz3 = class$0 = Class.forName("java.io.ObjectOutputStream");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        if (clazz2 != (clazz = clazz3)) {
            Object object;
            boolean bl = false;
            try {
                object = clazz2.getMethod("putFields", ObjectStreamClass.EMPTY_CONSTRUCTOR_PARAM_TYPES);
                bl = ((Method)object).getDeclaringClass() != clazz;
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            if (!bl) {
                try {
                    object = clazz2.getMethod("writeUnshared", ObjectStreamClass.UNSHARED_PARAM_TYPES);
                    bl = ((Method)object).getDeclaringClass() != clazz;
                }
                catch (NoSuchMethodException noSuchMethodException) {}
            }
            if (bl && (object = System.getSecurityManager()) != null) {
                ((SecurityManager)object).checkPermission(ObjectStreamConstants.SUBCLASS_IMPLEMENTATION_PERMISSION);
            }
        }
        this.output = outputStream instanceof DataOutputStream ? (DataOutputStream)outputStream : new DataOutputStream(outputStream);
        this.enableReplace = false;
        this.protocolVersion = 2;
        this.subclassOverridingImplementation = false;
        this.writeReplaceCache = new IdentityHashMap();
        this.resetState();
        this.nestedException = new StreamCorruptedException();
        this.primitiveTypes = this.output;
        this.writeStreamHeader();
        this.primitiveTypes = null;
    }

    protected void annotateClass(Class clazz) {
    }

    protected void annotateProxyClass(Class clazz) {
    }

    private void checkWritePrimitiveTypes() {
        if (this.primitiveTypes == null) {
            this.primitiveTypesBuffer = new ByteArrayOutputStream(128);
            this.primitiveTypes = new DataOutputStream(this.primitiveTypesBuffer);
        }
    }

    @Override
    public void close() {
        this.flush();
        this.output.close();
    }

    private void computePutField() {
        this.currentPutField = new EmulatedFieldsForDumping(this.currentClass);
    }

    public void defaultWriteObject() {
        if (this.currentObject == null) {
            throw new NotActiveException();
        }
        this.writeFieldValues(this.currentObject, this.currentClass);
    }

    protected void drain() {
        if (this.primitiveTypes == null) {
            return;
        }
        int n = 0;
        byte[] byArray = this.primitiveTypesBuffer.toByteArray();
        while (n < byArray.length) {
            int n2;
            int n3 = n2 = byArray.length - n > 1024 ? 1024 : byArray.length - n;
            if (n2 < 256) {
                this.output.writeByte(119);
                this.output.writeByte((byte)n2);
            } else {
                this.output.writeByte(122);
                this.output.writeInt(n2);
            }
            this.output.write(byArray, n, n2);
            n += n2;
        }
        this.primitiveTypes = null;
        this.primitiveTypesBuffer = null;
    }

    private Integer dumpCycle(Object object) {
        Integer n = this.registeredObjectHandleFor(object);
        if (n != null) {
            this.writeCyclicReference(n);
            return n;
        }
        return null;
    }

    protected boolean enableReplaceObject(boolean bl) {
        SecurityManager securityManager;
        if (bl && (securityManager = System.getSecurityManager()) != null) {
            securityManager.checkPermission(SUBSTITUTION_PERMISSION);
        }
        boolean bl2 = this.enableReplace;
        this.enableReplace = bl;
        return bl2;
    }

    @Override
    public void flush() {
        this.drain();
        this.output.flush();
    }

    private static native boolean getFieldBool(Object object, Class clazz, String string) {
    }

    private static native byte getFieldByte(Object object, Class clazz, String string) {
    }

    private static native char getFieldChar(Object object, Class clazz, String string) {
    }

    private static native double getFieldDouble(Object object, Class clazz, String string) {
    }

    private static native float getFieldFloat(Object object, Class clazz, String string) {
    }

    private static native int getFieldInt(Object object, Class clazz, String string) {
    }

    private static native long getFieldLong(Object object, Class clazz, String string) {
    }

    private static native Object getFieldObj(Object object, Class clazz, String string, String string2) {
    }

    private static native short getFieldShort(Object object, Class clazz, String string) {
    }

    private int nextHandle() {
        return this.currentHandle++;
    }

    public ObjectOutputStream$PutField putFields() {
        if (this.currentObject != null) {
            if (this.currentPutField == null) {
                this.computePutField();
            }
            return this.currentPutField;
        }
        throw new NotActiveException();
    }

    private Integer registeredObjectHandleFor(Object object) {
        return (Integer)this.objectsWritten.get(object);
    }

    private Integer registerObjectWritten(Object object) {
        Integer n = new Integer(this.nextHandle());
        this.registerObjectWritten(object, n);
        return n;
    }

    private void removeUnsharedReference(Object object, Integer n) {
        if (n != null) {
            this.registerObjectWritten(object, n);
        } else {
            this.objectsWritten.remove(object);
        }
    }

    private void registerObjectWritten(Object object, Integer n) {
        this.objectsWritten.put(object, n);
    }

    protected Object replaceObject(Object object) {
        return object;
    }

    public void reset() {
        this.drain();
        this.output.writeByte(121);
        this.resetState();
    }

    private void resetSeenObjects() {
        this.objectsWritten = new IdentityHashMap();
        this.currentHandle = 32256;
    }

    private void resetState() {
        this.resetSeenObjects();
        this.nestedLevels = 0;
    }

    public void useProtocolVersion(int n) {
        this.protocolVersion = n;
    }

    @Override
    public void write(byte[] byArray) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.write(byArray);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.write(byArray, n, n2);
    }

    @Override
    public void write(int n) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.write(n);
    }

    @Override
    public void writeBoolean(boolean bl) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeBoolean(bl);
    }

    @Override
    public void writeByte(int n) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeByte(n);
    }

    @Override
    public void writeBytes(String string) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeBytes(string);
    }

    @Override
    public void writeChar(int n) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeChar(n);
    }

    @Override
    public void writeChars(String string) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeChars(string);
    }

    private Integer writeClassDesc(ObjectStreamClass objectStreamClass, boolean bl) {
        if (objectStreamClass == null) {
            this.writeNull();
            return null;
        }
        Integer n = null;
        if (!bl) {
            n = this.dumpCycle(objectStreamClass);
        }
        if (n == null) {
            Class clazz = objectStreamClass.forClass();
            Integer n2 = (Integer)this.objectsWritten.get(objectStreamClass);
            n = this.registerObjectWritten(objectStreamClass);
            if (Proxy.isProxyClass(clazz)) {
                this.output.writeByte(125);
                Class[] classArray = clazz.getInterfaces();
                this.output.writeInt(classArray.length);
                int n3 = 0;
                while (n3 < classArray.length) {
                    this.output.writeUTF(classArray[n3].getName());
                    ++n3;
                }
                this.annotateProxyClass(clazz);
                this.output.writeByte(120);
                Class clazz2 = class$1;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$1 = Class.forName("java.lang.reflect.Proxy");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                this.writeClassDescForClass(clazz2);
                if (bl) {
                    this.removeUnsharedReference(objectStreamClass, n2);
                }
                return n;
            }
            this.output.writeByte(114);
            if (this.protocolVersion == 1) {
                this.writeNewClassDesc(objectStreamClass);
            } else {
                this.primitiveTypes = this.output;
                this.writeClassDescriptor(objectStreamClass);
                this.primitiveTypes = null;
            }
            this.annotateClass(clazz);
            this.drain();
            this.output.writeByte(120);
            this.writeClassDesc(objectStreamClass.getSuperclass(), false);
            if (bl) {
                this.removeUnsharedReference(objectStreamClass, n2);
            }
        }
        return n;
    }

    private Integer writeClassDescForClass(Class clazz) {
        return this.writeClassDesc(ObjectStreamClass.lookup(clazz), false);
    }

    private void writeCyclicReference(Integer n) {
        this.output.writeByte(113);
        this.output.writeInt(n);
    }

    @Override
    public void writeDouble(double d2) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeDouble(d2);
    }

    private void writeFieldDescriptors(ObjectStreamClass objectStreamClass, boolean bl) {
        Class clazz = objectStreamClass.forClass();
        ObjectStreamField[] objectStreamFieldArray = null;
        int n = 0;
        if (!bl && clazz != ObjectStreamClass.STRINGCLASS) {
            objectStreamFieldArray = objectStreamClass.fields();
            n = objectStreamFieldArray.length;
        }
        this.output.writeShort(n);
        int n2 = 0;
        while (n2 < n) {
            ObjectStreamField objectStreamField = objectStreamFieldArray[n2];
            this.output.writeByte(objectStreamField.getTypeCode());
            this.output.writeUTF(objectStreamField.getName());
            if (!objectStreamField.isPrimitive()) {
                this.writeObject(objectStreamField.getTypeString());
            }
            ++n2;
        }
    }

    public void writeFields() {
        if (this.currentPutField == null) {
            throw new NotActiveException();
        }
        this.writeFieldValues(this.currentPutField);
    }

    private void writeFieldValues(EmulatedFieldsForDumping emulatedFieldsForDumping) {
        EmulatedFields emulatedFields = emulatedFieldsForDumping.emulatedFields();
        EmulatedFields$ObjectSlot[] emulatedFields$ObjectSlotArray = emulatedFields.slots();
        int n = 0;
        while (n < emulatedFields$ObjectSlotArray.length) {
            EmulatedFields$ObjectSlot emulatedFields$ObjectSlot = emulatedFields$ObjectSlotArray[n];
            Object object = emulatedFields$ObjectSlot.getFieldValue();
            Class clazz = emulatedFields$ObjectSlot.getField().getType();
            if (clazz == Integer.TYPE) {
                this.output.writeInt(object != null ? (Integer)object : 0);
            } else if (clazz == Byte.TYPE) {
                this.output.writeByte(object != null ? (int)((Byte)object).byteValue() : 0);
            } else if (clazz == Character.TYPE) {
                this.output.writeChar(object != null ? (int)((Character)object).charValue() : 0);
            } else if (clazz == Short.TYPE) {
                this.output.writeShort(object != null ? (int)((Short)object).shortValue() : 0);
            } else if (clazz == Boolean.TYPE) {
                this.output.writeBoolean(object != null ? (Boolean)object : false);
            } else if (clazz == Long.TYPE) {
                this.output.writeLong(object != null ? (Long)object : 0L);
            } else if (clazz == Float.TYPE) {
                this.output.writeFloat(object != null ? ((Float)object).floatValue() : 0.0f);
            } else if (clazz == Double.TYPE) {
                this.output.writeDouble(object != null ? (Double)object : 0.0);
            } else {
                this.writeObject(object);
            }
            ++n;
        }
    }

    private void writeFieldValues(Object object, ObjectStreamClass objectStreamClass) {
        ObjectStreamField[] objectStreamFieldArray = objectStreamClass.fields();
        Class clazz = objectStreamClass.forClass();
        int n = 0;
        while (n < objectStreamFieldArray.length) {
            block16: {
                try {
                    ObjectStreamField objectStreamField = objectStreamFieldArray[n];
                    if (objectStreamField.isPrimitive()) {
                        switch (objectStreamField.getTypeCode()) {
                            case 'B': {
                                this.output.writeByte(ObjectOutputStream.getFieldByte(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'C': {
                                this.output.writeChar(ObjectOutputStream.getFieldChar(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'D': {
                                this.output.writeDouble(ObjectOutputStream.getFieldDouble(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'F': {
                                this.output.writeFloat(ObjectOutputStream.getFieldFloat(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'I': {
                                this.output.writeInt(ObjectOutputStream.getFieldInt(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'J': {
                                this.output.writeLong(ObjectOutputStream.getFieldLong(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'S': {
                                this.output.writeShort(ObjectOutputStream.getFieldShort(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            case 'Z': {
                                this.output.writeBoolean(ObjectOutputStream.getFieldBool(object, clazz, objectStreamField.getName()));
                                break block16;
                            }
                            default: {
                                throw new IOException(Msg.getString("K00d5", objectStreamField.getTypeCode()));
                            }
                        }
                    }
                    Object object2 = ObjectOutputStream.getFieldObj(object, clazz, objectStreamField.getName(), objectStreamField.getTypeString());
                    if (objectStreamField.getUnshared()) {
                        this.writeUnshared(object2);
                    } else {
                        this.writeObject(object2);
                    }
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    throw new InvalidClassException(objectStreamClass.getName());
                }
            }
            ++n;
        }
    }

    @Override
    public void writeFloat(float f2) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeFloat(f2);
    }

    private void writeHierarchy(Object object, ObjectStreamClass objectStreamClass) {
        if (object != null) {
            if (objectStreamClass.getSuperclass() != null) {
                this.writeHierarchy(object, objectStreamClass.getSuperclass());
            }
            this.currentObject = object;
            this.currentClass = objectStreamClass;
            boolean bl = false;
            Class clazz = objectStreamClass.forClass();
            try {
                Method method = ObjectStreamClass.getPrivateWriteObjectMethod(clazz);
                if (method != null) {
                    AccessController.doPrivileged(new PriviAction(method));
                    try {
                        method.invoke(object, new Object[]{this});
                        bl = true;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        Throwable throwable = invocationTargetException.getTargetException();
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
                }
                if (bl) {
                    this.drain();
                    this.output.writeByte(120);
                }
                this.defaultWriteObject();
            }
            finally {
                this.currentObject = null;
                this.currentClass = null;
                this.currentPutField = null;
            }
        } else {
            throw new NotActiveException();
        }
    }

    @Override
    public void writeInt(int n) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeInt(n);
    }

    @Override
    public void writeLong(long l) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeLong(l);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Integer writeNewArray(Object object, Class clazz, Class clazz2) {
        this.output.writeByte(117);
        this.writeClassDescForClass(clazz);
        Integer n = this.registerObjectWritten(object);
        if (clazz2.isPrimitive()) {
            if (clazz2 == Integer.TYPE) {
                int[] nArray = (int[])object;
                this.output.writeInt(nArray.length);
                int n2 = 0;
                while (n2 < nArray.length) {
                    this.output.writeInt(nArray[n2]);
                    ++n2;
                }
                return n;
            } else if (clazz2 == Byte.TYPE) {
                byte[] byArray = (byte[])object;
                this.output.writeInt(byArray.length);
                this.output.write(byArray, 0, byArray.length);
                return n;
            } else if (clazz2 == Character.TYPE) {
                char[] cArray = (char[])object;
                this.output.writeInt(cArray.length);
                int n3 = 0;
                while (n3 < cArray.length) {
                    this.output.writeChar(cArray[n3]);
                    ++n3;
                }
                return n;
            } else if (clazz2 == Short.TYPE) {
                short[] sArray = (short[])object;
                this.output.writeInt(sArray.length);
                int n4 = 0;
                while (n4 < sArray.length) {
                    this.output.writeShort(sArray[n4]);
                    ++n4;
                }
                return n;
            } else if (clazz2 == Boolean.TYPE) {
                boolean[] blArray = (boolean[])object;
                this.output.writeInt(blArray.length);
                int n5 = 0;
                while (n5 < blArray.length) {
                    this.output.writeBoolean(blArray[n5]);
                    ++n5;
                }
                return n;
            } else if (clazz2 == Long.TYPE) {
                long[] lArray = (long[])object;
                this.output.writeInt(lArray.length);
                int n6 = 0;
                while (n6 < lArray.length) {
                    this.output.writeLong(lArray[n6]);
                    ++n6;
                }
                return n;
            } else if (clazz2 == Float.TYPE) {
                float[] fArray = (float[])object;
                this.output.writeInt(fArray.length);
                int n7 = 0;
                while (n7 < fArray.length) {
                    this.output.writeFloat(fArray[n7]);
                    ++n7;
                }
                return n;
            } else {
                if (clazz2 != Double.TYPE) throw new InvalidClassException(Msg.getString("K00d7", clazz.getName()));
                double[] dArray = (double[])object;
                this.output.writeInt(dArray.length);
                int n8 = 0;
                while (n8 < dArray.length) {
                    this.output.writeDouble(dArray[n8]);
                    ++n8;
                }
            }
            return n;
        } else {
            Object[] objectArray = (Object[])object;
            this.output.writeInt(objectArray.length);
            int n9 = 0;
            while (n9 < objectArray.length) {
                this.writeObject(objectArray[n9]);
                ++n9;
            }
        }
        return n;
    }

    private Integer writeNewClass(Class clazz) {
        this.output.writeByte(118);
        this.writeClassDesc(ObjectStreamClass.lookupStreamClass(clazz), false);
        return this.registerObjectWritten(clazz);
    }

    private void writeNewClassDesc(ObjectStreamClass objectStreamClass) {
        this.output.writeUTF(objectStreamClass.getName());
        this.output.writeLong(objectStreamClass.getSerialVersionUID());
        byte by = objectStreamClass.getFlags();
        boolean bl = false;
        bl = ObjectStreamClass.isExternalizable(objectStreamClass.forClass());
        if (this.protocolVersion != 1 && bl) {
            by = (byte)(by | 8);
        }
        this.output.writeByte(by);
        this.writeFieldDescriptors(objectStreamClass, bl);
    }

    protected void writeClassDescriptor(ObjectStreamClass objectStreamClass) {
        this.writeNewClassDesc(objectStreamClass);
    }

    private void writeNewException(Exception exception) {
        this.output.writeByte(123);
        this.resetSeenObjects();
        this.writeObjectInternal(exception, false, false, false);
        this.resetSeenObjects();
    }

    private void checkSerializable(Class clazz, boolean bl) {
        boolean bl2 = ObjectStreamClass.isSerializable(clazz);
        if (!bl && !bl2) {
            throw new NotSerializableException(clazz.getName());
        }
    }

    private Integer writeNewObject(Object object, Class clazz, boolean bl) {
        EmulatedFieldsForDumping emulatedFieldsForDumping = this.currentPutField;
        this.currentPutField = null;
        boolean bl2 = ObjectStreamClass.isExternalizable(clazz);
        this.checkSerializable(clazz, bl2);
        this.output.writeByte(115);
        this.writeClassDescForClass(clazz);
        Integer n = (Integer)this.objectsWritten.get(object);
        Integer n2 = this.registerObjectWritten(object);
        this.currentObject = object;
        this.currentClass = ObjectStreamClass.lookup(clazz);
        try {
            if (bl2) {
                boolean bl3;
                boolean bl4 = bl3 = this.protocolVersion == 1;
                if (bl3) {
                    this.primitiveTypes = this.output;
                }
                ((Externalizable)object).writeExternal(this);
                if (bl3) {
                    this.primitiveTypes = null;
                } else {
                    this.drain();
                    this.output.writeByte(120);
                }
            } else {
                this.writeHierarchy(object, this.currentClass);
            }
        }
        finally {
            if (bl) {
                this.removeUnsharedReference(object, n);
            }
            this.currentObject = null;
            this.currentClass = null;
            this.currentPutField = emulatedFieldsForDumping;
        }
        return n2;
    }

    private Integer writeNewString(String string) {
        long l = this.output.countUTFBytes(string);
        if (l <= 0) {
            this.output.writeByte(116);
            this.output.writeShort((short)l);
        } else {
            this.output.writeByte(124);
            this.output.writeLong(l);
        }
        this.output.writeUTFBytes(string, l);
        return this.registerObjectWritten(string);
    }

    private void writeNull() {
        this.output.writeByte(112);
    }

    @Override
    public final void writeObject(Object object) {
        this.writeObject(object, false);
    }

    public void writeUnshared(Object object) {
        this.writeObject(object, true);
    }

    private void writeObject(Object object, boolean bl) {
        boolean bl2 = this.primitiveTypes == this.output;
        if (bl2) {
            this.primitiveTypes = null;
        }
        if (this.subclassOverridingImplementation && !bl) {
            this.writeObjectOverride(object);
        } else {
            try {
                this.drain();
                this.writeObjectInternal(object, bl, true, true);
                if (bl2) {
                    this.primitiveTypes = this.output;
                }
            }
            catch (IOException iOException) {
                if (this.nestedLevels == 0 && iOException != this.nestedException) {
                    try {
                        this.writeNewException(iOException);
                    }
                    catch (IOException iOException2) {
                        this.nestedException.fillInStackTrace();
                        throw this.nestedException;
                    }
                }
                throw iOException;
            }
        }
    }

    private Integer writeObjectInternal(Object object, boolean bl, boolean bl2, boolean bl3) {
        if (object == null) {
            this.writeNull();
            return null;
        }
        Integer n = null;
        if (!bl && (n = this.dumpCycle(object)) != null) {
            return n;
        }
        Class clazz = object.getClass();
        ++this.nestedLevels;
        try {
            Object object2;
            Object object3;
            if (clazz == ObjectStreamClass.CLASSCLASS) {
                Integer n2 = this.writeNewClass((Class)object);
                return n2;
            }
            if (clazz == ObjectStreamClass.OBJECTSTREAMCLASSCLASS) {
                Integer n3 = this.writeClassDesc((ObjectStreamClass)object, bl);
                return n3;
            }
            if (bl2 && (object3 = this.writeReplaceCache.get(clazz)) != this) {
                if (object3 == null) {
                    object2 = ObjectStreamClass.methodWriteReplace(clazz);
                    if (object2 == null) {
                        this.writeReplaceCache.put(clazz, this);
                        object3 = null;
                    } else {
                        boolean bl4 = ObjectStreamClass.isExternalizable(clazz);
                        this.checkSerializable(clazz, bl4);
                        AccessController.doPrivileged(new PriviAction((AccessibleObject)object2));
                        this.writeReplaceCache.put(clazz, object2);
                        object3 = object2;
                    }
                }
                if (object3 != null) {
                    try {
                        object2 = ((Method)object3).invoke(object, null);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        object2 = object;
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
                    if (object2 != object) {
                        Integer n4 = this.writeObjectInternal(object2, false, false, bl3);
                        if (n4 != null) {
                            this.registerObjectWritten(object, n4);
                        }
                        Integer n5 = n4;
                        return n5;
                    }
                }
            }
            if (this.enableReplace && bl3 && (object3 = this.replaceObject(object)) != object) {
                object2 = this.writeObjectInternal(object3, false, bl2, false);
                if (object2 != null) {
                    this.registerObjectWritten(object, (Integer)object2);
                }
                Object object4 = object2;
                return object4;
            }
            if (clazz == ObjectStreamClass.STRINGCLASS) {
                Integer n6 = this.writeNewString((String)object);
                return n6;
            }
            if (clazz.isArray()) {
                Integer n7 = this.writeNewArray(object, clazz, clazz.getComponentType());
                return n7;
            }
            Integer n8 = this.writeNewObject(object, clazz, bl);
            return n8;
        }
        finally {
            --this.nestedLevels;
        }
    }

    protected void writeObjectOverride(Object object) {
        throw new IOException();
    }

    @Override
    public void writeShort(int n) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeShort(n);
    }

    protected void writeStreamHeader() {
        this.output.writeShort(-21267);
        this.output.writeShort(5);
    }

    @Override
    public void writeUTF(String string) {
        this.checkWritePrimitiveTypes();
        this.primitiveTypes.writeUTF(string);
    }
}

