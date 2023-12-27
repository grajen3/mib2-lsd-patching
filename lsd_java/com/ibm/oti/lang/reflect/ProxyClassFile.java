/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package com.ibm.oti.lang.reflect;

import com.ibm.oti.lang.reflect.ProxyConstantPool;
import com.ibm.oti.lang.reflect.ProxyConstants;
import com.ibm.oti.lang.reflect.ProxyMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

public final class ProxyClassFile
implements ProxyConstants {
    private ProxyConstantPool constantPool;
    byte[] header = new byte[500];
    int headerOffset;
    private byte[] contents;
    private int contentsOffset;
    private int constantPoolOffset;
    private ProxyMethod[] proxyMethods;
    private static final int INITIAL_CONTENTS_SIZE;
    private static final int INITIAL_HEADER_SIZE;
    private static final int INCREMENT_SIZE;
    private static Method ObjectEqualsMethod;
    private static Method ObjectHashCodeMethod;
    private static Method ObjectToStringMethod;
    private static Method ClassForNameMethod;
    private static Method ClassGetMethod;
    private static Method HandlerInvokeMethod;
    private static Constructor ProxyConstructor;
    private static Constructor UndeclaredThrowableExceptionConstructor;
    private static Field ProxyHandlerField;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;
    static /* synthetic */ Class class$3;
    static /* synthetic */ Class class$4;
    static /* synthetic */ Class class$5;
    static /* synthetic */ Class class$6;
    static /* synthetic */ Class class$7;
    static /* synthetic */ Class class$8;
    static /* synthetic */ Class class$9;
    static /* synthetic */ Class class$10;
    static /* synthetic */ Class class$11;
    static /* synthetic */ Class class$12;
    static /* synthetic */ Class class$13;
    static /* synthetic */ Class class$14;
    static /* synthetic */ Class class$15;
    static /* synthetic */ Class class$16;
    static /* synthetic */ Class class$17;
    static /* synthetic */ Class class$18;
    static /* synthetic */ Class class$19;
    static /* synthetic */ Class class$20;
    static /* synthetic */ Class class$21;
    static /* synthetic */ Class class$22;
    static /* synthetic */ Class class$23;
    static /* synthetic */ Class class$24;
    static /* synthetic */ Class class$25;
    static /* synthetic */ Class class$26;

    public static byte[] generateBytes(String string, Class[] classArray) {
        ProxyClassFile proxyClassFile = new ProxyClassFile(string, classArray);
        proxyClassFile.addFields();
        proxyClassFile.findMethods(classArray);
        proxyClassFile.addMethods();
        proxyClassFile.addAttributes();
        return proxyClassFile.getBytes();
    }

    static char[] getConstantPoolName(Class clazz) {
        if (clazz.isArray()) {
            return clazz.getName().replace('.', '/').toCharArray();
        }
        if (clazz.isPrimitive()) {
            if (clazz == Void.TYPE) {
                return new char[]{'V'};
            }
            if (clazz == Integer.TYPE) {
                return new char[]{'I'};
            }
            if (clazz == Boolean.TYPE) {
                return new char[]{'Z'};
            }
            if (clazz == Byte.TYPE) {
                return new char[]{'B'};
            }
            if (clazz == Character.TYPE) {
                return new char[]{'C'};
            }
            if (clazz == Short.TYPE) {
                return new char[]{'S'};
            }
            if (clazz == Long.TYPE) {
                return new char[]{'J'};
            }
            if (clazz == Float.TYPE) {
                return new char[]{'F'};
            }
            if (clazz == Double.TYPE) {
                return new char[]{'D'};
            }
        }
        return new StringBuffer("L").append(clazz.getName().replace('.', '/')).append(";").toString().toCharArray();
    }

    static char[] getConstantPoolName(Constructor constructor) {
        Class[] classArray = constructor.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer(classArray.length + 20);
        stringBuffer.append('(');
        int n = 0;
        int n2 = classArray.length;
        while (n < n2) {
            stringBuffer.append(ProxyClassFile.getConstantPoolName(classArray[n]));
            ++n;
        }
        stringBuffer.append(')');
        stringBuffer.append(ProxyClassFile.getConstantPoolName(Void.TYPE));
        return stringBuffer.toString().toCharArray();
    }

    static char[] getConstantPoolName(Method method) {
        Class[] classArray = method.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer(classArray.length + 20);
        stringBuffer.append('(');
        int n = 0;
        int n2 = classArray.length;
        while (n < n2) {
            stringBuffer.append(ProxyClassFile.getConstantPoolName(classArray[n]));
            ++n;
        }
        stringBuffer.append(')');
        stringBuffer.append(ProxyClassFile.getConstantPoolName(method.getReturnType()));
        return stringBuffer.toString().toCharArray();
    }

    ProxyClassFile(String string, Class[] classArray) {
        this.header[this.headerOffset++] = -54;
        this.header[this.headerOffset++] = -2;
        this.header[this.headerOffset++] = -70;
        this.header[this.headerOffset++] = -66;
        this.header[this.headerOffset++] = 0;
        this.header[this.headerOffset++] = 0;
        this.header[this.headerOffset++] = 0;
        this.header[this.headerOffset++] = 46;
        this.constantPoolOffset = this.headerOffset;
        this.headerOffset += 2;
        this.constantPool = new ProxyConstantPool(this);
        this.contents = new byte[1000];
        int n = 49;
        this.contents[this.contentsOffset++] = (byte)(n >> 8);
        this.contents[this.contentsOffset++] = (byte)n;
        int n2 = this.constantPool.typeIndex(string);
        this.contents[this.contentsOffset++] = (byte)(n2 >> 8);
        this.contents[this.contentsOffset++] = (byte)n2;
        int n3 = this.constantPool.typeIndex("java/lang/reflect/Proxy");
        this.contents[this.contentsOffset++] = (byte)(n3 >> 8);
        this.contents[this.contentsOffset++] = (byte)n3;
        int n4 = classArray.length;
        this.contents[this.contentsOffset++] = (byte)(n4 >> 8);
        this.contents[this.contentsOffset++] = (byte)n4;
        int n5 = 0;
        while (n5 < n4) {
            int n6 = this.constantPool.typeIndex(classArray[n5].getName());
            this.contents[this.contentsOffset++] = (byte)(n6 >> 8);
            this.contents[this.contentsOffset++] = (byte)n6;
            ++n5;
        }
    }

    private void addAttributes() {
        this.writeUnsignedShort(0);
        this.header = this.constantPool.poolContent;
        this.headerOffset = this.constantPool.currentOffset;
        int n = this.constantPool.currentIndex;
        this.header[this.constantPoolOffset++] = (byte)(n >> 8);
        this.header[this.constantPoolOffset] = (byte)n;
    }

    private void addFields() {
        this.writeUnsignedShort(0);
    }

    private void addMethods() {
        int n = this.proxyMethods.length;
        this.writeUnsignedShort(n + 1);
        this.writeUnsignedShort(1);
        this.writeUnsignedShort(this.constantPool.literalIndex(Init));
        if (ProxyConstructor == null) {
            try {
                Class clazz = class$9;
                if (clazz == null) {
                    try {
                        clazz = class$9 = Class.forName("java.lang.reflect.Proxy");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class[] classArray = new Class[1];
                Class clazz2 = class$10;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$10 = Class.forName("java.lang.reflect.InvocationHandler");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray[0] = clazz2;
                ProxyConstructor = clazz.getDeclaredConstructor(classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(ProxyClassFile.getConstantPoolName(ProxyConstructor)));
        this.writeUnsignedShort(1);
        this.writeUnsignedShort(this.constantPool.literalIndex(CodeName));
        int n2 = 6;
        this.writeUnsignedWord(12 + n2);
        this.writeUnsignedShort(2);
        this.writeUnsignedShort(2);
        this.writeUnsignedWord(n2);
        this.writeUnsignedByte(42);
        this.writeUnsignedByte(43);
        this.writeUnsignedByte(183);
        this.writeUnsignedShort(this.constantPool.literalIndex(ProxyConstructor));
        this.writeUnsignedByte(177);
        this.writeUnsignedShort(0);
        this.writeUnsignedShort(0);
        int n3 = 0;
        while (n3 < n) {
            ProxyMethod proxyMethod = this.proxyMethods[n3];
            Method method = proxyMethod.method;
            this.writeUnsignedShort(17);
            this.writeUnsignedShort(this.constantPool.literalIndex(method.getName().toCharArray()));
            this.writeUnsignedShort(this.constantPool.literalIndex(ProxyClassFile.getConstantPoolName(method)));
            Class[] classArray = proxyMethod.commonExceptions;
            int n4 = classArray.length;
            if (n4 > 0) {
                this.writeUnsignedShort(2);
                this.writeUnsignedShort(this.constantPool.literalIndex(ExceptionsName));
                this.writeUnsignedWord(n4 * 2 + 2);
                this.writeUnsignedShort(n4);
                int n5 = 0;
                while (n5 < n4) {
                    this.writeUnsignedShort(this.constantPool.typeIndex(classArray[n5].getName()));
                    ++n5;
                }
            } else {
                this.writeUnsignedShort(1);
            }
            this.generateCodeAttribute(proxyMethod);
            ++n3;
        }
    }

    private void findMethods(Class[] classArray) {
        if (ObjectEqualsMethod == null) {
            try {
                Class clazz = class$11;
                if (clazz == null) {
                    try {
                        clazz = class$11 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class[] classArray2 = new Class[1];
                Class clazz2 = class$11;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$11 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[0] = clazz2;
                ObjectEqualsMethod = clazz.getMethod("equals", classArray2);
                Class clazz3 = class$11;
                if (clazz3 == null) {
                    try {
                        clazz3 = class$11 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                ObjectHashCodeMethod = clazz3.getMethod("hashCode", new Class[0]);
                Class clazz4 = class$11;
                if (clazz4 == null) {
                    try {
                        clazz4 = class$11 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                ObjectToStringMethod = clazz4.getMethod("toString", new Class[0]);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        ArrayList arrayList = new ArrayList(25);
        arrayList.add(new ProxyMethod(ObjectEqualsMethod));
        arrayList.add(new ProxyMethod(ObjectHashCodeMethod));
        arrayList.add(new ProxyMethod(ObjectToStringMethod));
        HashSet hashSet = new HashSet();
        int n = 0;
        int n2 = classArray.length;
        while (n < n2) {
            this.findMethods(classArray[n], arrayList, hashSet);
            ++n;
        }
        this.proxyMethods = new ProxyMethod[arrayList.size()];
        arrayList.toArray(this.proxyMethods);
    }

    private void findMethods(Class clazz, ArrayList arrayList, HashSet hashSet) {
        if (hashSet.contains(clazz)) {
            return;
        }
        hashSet.add(clazz);
        int n = arrayList.size();
        Method[] methodArray = clazz.getMethods();
        int n2 = 0;
        int n3 = methodArray.length;
        while (n2 < n3) {
            block5: {
                Method method = methodArray[n2];
                int n4 = 0;
                while (n4 < n) {
                    if (!((ProxyMethod)arrayList.get(n4)).matchMethod(method)) {
                        ++n4;
                        continue;
                    }
                    break block5;
                }
                arrayList.add(new ProxyMethod(method));
            }
            ++n2;
        }
        Class[] classArray = clazz.getInterfaces();
        n3 = 0;
        int n5 = classArray.length;
        while (n3 < n5) {
            this.findMethods(classArray[n3], arrayList, hashSet);
            ++n3;
        }
    }

    private void generateCodeAttribute(ProxyMethod proxyMethod) {
        int n;
        int n2;
        int n3 = this.contentsOffset;
        int n4 = this.contents.length;
        if (this.contentsOffset + 20 + 100 >= n4) {
            this.contents = new byte[n4 + 250];
            System.arraycopy((Object)this.contents, 0, (Object)this.contents, 0, n4);
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(CodeName));
        this.contentsOffset += 12;
        int n5 = this.contentsOffset;
        this.writeUnsignedByte(42);
        this.writeUnsignedByte(180);
        if (ProxyHandlerField == null) {
            try {
                Class clazz = class$9;
                if (clazz == null) {
                    try {
                        clazz = class$9 = Class.forName("java.lang.reflect.Proxy");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                ProxyHandlerField = clazz.getDeclaredField("h");
            }
            catch (NoSuchFieldException noSuchFieldException) {
                throw new InternalError();
            }
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(ProxyHandlerField));
        this.writeUnsignedByte(42);
        Method method = proxyMethod.method;
        Class[] classArray = method.getParameterTypes();
        this.genCallGetMethod(method.getDeclaringClass(), method.getName(), classArray);
        int n6 = this.genInvokeArgs(classArray);
        this.writeUnsignedByte(185);
        if (HandlerInvokeMethod == null) {
            try {
                Class clazz = class$10;
                if (clazz == null) {
                    try {
                        clazz = class$10 = Class.forName("java.lang.reflect.InvocationHandler");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class[] classArray2 = new Class[3];
                Class clazz2 = class$11;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$11 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[0] = clazz2;
                Class clazz3 = class$12;
                if (clazz3 == null) {
                    try {
                        clazz3 = class$12 = Class.forName("java.lang.reflect.Method");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[1] = clazz3;
                Class clazz4 = class$13;
                if (clazz4 == null) {
                    try {
                        clazz4 = class$13 = Class.forName("[Ljava.lang.Object;");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[2] = clazz4;
                HandlerInvokeMethod = clazz.getMethod("invoke", classArray2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(HandlerInvokeMethod));
        this.writeUnsignedByte(4);
        this.writeUnsignedByte(0);
        this.genCastReturnType(method.getReturnType());
        int n7 = this.contentsOffset - n5;
        Class[] classArray3 = proxyMethod.getCheckedExceptions();
        int n8 = classArray3.length;
        if (n8 > 0) {
            n2 = this.contentsOffset - n5;
            this.writeUnsignedByte(191);
            this.genStoreArg(n6);
            this.writeUnsignedByte(187);
            this.writeUnsignedShort(this.constantPool.typeIndex("java/lang/reflect/UndeclaredThrowableException"));
            this.writeUnsignedByte(89);
            this.genLoadArg(n6);
            ++n6;
            this.writeUnsignedByte(183);
            if (UndeclaredThrowableExceptionConstructor == null) {
                try {
                    Class clazz = class$14;
                    if (clazz == null) {
                        try {
                            clazz = class$14 = Class.forName("java.lang.reflect.UndeclaredThrowableException");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    Class[] classArray4 = new Class[1];
                    Class clazz5 = class$15;
                    if (clazz5 == null) {
                        try {
                            clazz5 = class$15 = Class.forName("java.lang.Throwable");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    classArray4[0] = clazz5;
                    UndeclaredThrowableExceptionConstructor = clazz.getConstructor(classArray4);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    throw new InternalError();
                }
            }
            this.writeUnsignedShort(this.constantPool.literalIndex(UndeclaredThrowableExceptionConstructor));
            this.writeUnsignedByte(191);
            n7 = this.contentsOffset - n5;
            this.writeUnsignedShort(n8 + 1);
            n = 0;
            while (n < n8) {
                this.writeUnsignedShort(0);
                this.writeUnsignedShort(n2);
                this.writeUnsignedShort(n2);
                this.writeUnsignedShort(this.constantPool.typeIndex(classArray3[n].getName()));
                ++n;
            }
            this.writeUnsignedShort(0);
            this.writeUnsignedShort(n2);
            this.writeUnsignedShort(n2 + 1);
            this.writeUnsignedShort(this.constantPool.typeIndex("java/lang/Throwable"));
        } else {
            this.writeUnsignedShort(0);
        }
        this.writeUnsignedShort(0);
        n2 = this.contentsOffset - (n3 + 6);
        this.contents[n3 + 2] = (byte)(n2 >> 24);
        this.contents[n3 + 3] = (byte)(n2 >> 16);
        this.contents[n3 + 4] = (byte)(n2 >> 8);
        this.contents[n3 + 5] = (byte)n2;
        n = n6 + 10;
        this.contents[n3 + 6] = (byte)(n >> 8);
        this.contents[n3 + 7] = (byte)n;
        this.contents[n3 + 8] = (byte)(n6 >> 8);
        this.contents[n3 + 9] = (byte)n6;
        this.contents[n3 + 10] = (byte)(n7 >> 24);
        this.contents[n3 + 11] = (byte)(n7 >> 16);
        this.contents[n3 + 12] = (byte)(n7 >> 8);
        this.contents[n3 + 13] = (byte)n7;
    }

    private void genCallGetMethod(Class clazz, String string, Class[] classArray) {
        this.genCallClassForName(clazz.getName());
        this.writeLdc(string);
        int n = classArray.length;
        this.writeIntConstant(n);
        this.writeUnsignedByte(189);
        this.writeUnsignedShort(this.constantPool.typeIndex("java/lang/Class"));
        int n2 = 0;
        while (n2 < n) {
            this.writeUnsignedByte(89);
            this.writeIntConstant(n2);
            Class clazz2 = classArray[n2];
            if (clazz2.isPrimitive()) {
                this.writeUnsignedByte(178);
                this.writeUnsignedShort(this.constantPool.literalIndex(this.typeField(clazz2)));
            } else {
                this.genCallClassForName(clazz2.getName());
            }
            this.writeUnsignedByte(83);
            ++n2;
        }
        this.writeUnsignedByte(182);
        if (ClassGetMethod == null) {
            try {
                Class clazz3 = class$16;
                if (clazz3 == null) {
                    try {
                        clazz3 = class$16 = Class.forName("java.lang.Class");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class[] classArray2 = new Class[2];
                Class clazz4 = class$17;
                if (clazz4 == null) {
                    try {
                        clazz4 = class$17 = Class.forName("java.lang.String");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[0] = clazz4;
                Class clazz5 = class$18;
                if (clazz5 == null) {
                    try {
                        clazz5 = class$18 = Class.forName("[Ljava.lang.Class;");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray2[1] = clazz5;
                ClassGetMethod = clazz3.getMethod("getMethod", classArray2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(ClassGetMethod));
    }

    private int genInvokeArgs(Class[] classArray) {
        int n = 1;
        int n2 = classArray.length;
        if (n2 == 0) {
            this.writeUnsignedByte(1);
        } else {
            this.writeIntConstant(n2);
            this.writeUnsignedByte(189);
            this.writeUnsignedShort(this.constantPool.typeIndex("java/lang/Object"));
            int n3 = 0;
            while (n3 < n2) {
                this.writeUnsignedByte(89);
                this.writeIntConstant(n3);
                n = this.genInvokeArg(classArray[n3], n);
                this.writeUnsignedByte(83);
                ++n3;
            }
        }
        return n;
    }

    private int genInvokeArg(Class clazz, int n) {
        if (clazz.isPrimitive()) {
            this.writeUnsignedByte(187);
            this.writeUnsignedShort(this.constantPool.typeIndex(this.typeWrapperName(clazz)));
            this.writeUnsignedByte(89);
            if (n > 255) {
                this.writeUnsignedByte(196);
            }
            if (clazz == Long.TYPE) {
                switch (n) {
                    case 0: {
                        this.writeUnsignedByte(30);
                        break;
                    }
                    case 1: {
                        this.writeUnsignedByte(31);
                        break;
                    }
                    case 2: {
                        this.writeUnsignedByte(32);
                        break;
                    }
                    case 3: {
                        this.writeUnsignedByte(33);
                        break;
                    }
                    default: {
                        this.writeUnsignedByte(22);
                        if (n > 255) {
                            this.writeUnsignedShort(n);
                            break;
                        }
                        this.writeUnsignedByte(n);
                    }
                }
                n += 2;
            } else if (clazz == Float.TYPE) {
                switch (n) {
                    case 0: {
                        this.writeUnsignedByte(34);
                        break;
                    }
                    case 1: {
                        this.writeUnsignedByte(35);
                        break;
                    }
                    case 2: {
                        this.writeUnsignedByte(36);
                        break;
                    }
                    case 3: {
                        this.writeUnsignedByte(37);
                        break;
                    }
                    default: {
                        this.writeUnsignedByte(23);
                        if (n > 255) {
                            this.writeUnsignedShort(n);
                            break;
                        }
                        this.writeUnsignedByte(n);
                    }
                }
                ++n;
            } else if (clazz == Double.TYPE) {
                switch (n) {
                    case 0: {
                        this.writeUnsignedByte(38);
                        break;
                    }
                    case 1: {
                        this.writeUnsignedByte(39);
                        break;
                    }
                    case 2: {
                        this.writeUnsignedByte(40);
                        break;
                    }
                    case 3: {
                        this.writeUnsignedByte(41);
                        break;
                    }
                    default: {
                        this.writeUnsignedByte(24);
                        if (n > 255) {
                            this.writeUnsignedShort(n);
                            break;
                        }
                        this.writeUnsignedByte(n);
                    }
                }
                n += 2;
            } else {
                switch (n) {
                    case 0: {
                        this.writeUnsignedByte(26);
                        break;
                    }
                    case 1: {
                        this.writeUnsignedByte(27);
                        break;
                    }
                    case 2: {
                        this.writeUnsignedByte(28);
                        break;
                    }
                    case 3: {
                        this.writeUnsignedByte(29);
                        break;
                    }
                    default: {
                        this.writeUnsignedByte(21);
                        if (n > 255) {
                            this.writeUnsignedShort(n);
                            break;
                        }
                        this.writeUnsignedByte(n);
                    }
                }
                ++n;
            }
            this.writeUnsignedByte(183);
            this.writeUnsignedShort(this.constantPool.literalIndex(this.typeInitMethod(clazz)));
        } else {
            this.genLoadArg(n);
            ++n;
        }
        return n;
    }

    private void genCastReturnType(Class clazz) {
        if (clazz.isPrimitive()) {
            if (clazz == Void.TYPE) {
                this.writeUnsignedByte(87);
                this.writeUnsignedByte(177);
            } else {
                this.writeUnsignedByte(192);
                this.writeUnsignedShort(this.constantPool.typeIndex(this.typeWrapperName(clazz)));
                this.writeUnsignedByte(182);
                this.writeUnsignedShort(this.constantPool.literalIndex(this.typeAccessMethod(clazz)));
                if (clazz == Long.TYPE) {
                    this.writeUnsignedByte(173);
                } else if (clazz == Float.TYPE) {
                    this.writeUnsignedByte(174);
                } else if (clazz == Double.TYPE) {
                    this.writeUnsignedByte(175);
                } else {
                    this.writeUnsignedByte(172);
                }
            }
        } else {
            this.writeUnsignedByte(192);
            this.writeUnsignedShort(this.constantPool.typeIndex(clazz.getName()));
            this.writeUnsignedByte(176);
        }
    }

    private void genCallClassForName(String string) {
        this.writeLdc(string);
        this.writeUnsignedByte(184);
        if (ClassForNameMethod == null) {
            try {
                Class clazz = class$16;
                if (clazz == null) {
                    try {
                        clazz = class$16 = Class.forName("java.lang.Class");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                Class[] classArray = new Class[1];
                Class clazz2 = class$17;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$17 = Class.forName("java.lang.String");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray[0] = clazz2;
                ClassForNameMethod = clazz.getMethod("forName", classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        this.writeUnsignedShort(this.constantPool.literalIndex(ClassForNameMethod));
    }

    private void genLoadArg(int n) {
        if (n > 255) {
            this.writeUnsignedByte(196);
            this.writeUnsignedByte(25);
            this.writeUnsignedShort(n);
        } else {
            switch (n) {
                case 0: {
                    this.writeUnsignedByte(42);
                    break;
                }
                case 1: {
                    this.writeUnsignedByte(43);
                    break;
                }
                case 2: {
                    this.writeUnsignedByte(44);
                    break;
                }
                case 3: {
                    this.writeUnsignedByte(45);
                    break;
                }
                default: {
                    this.writeUnsignedByte(25);
                    this.writeUnsignedByte(n);
                }
            }
        }
    }

    private void genStoreArg(int n) {
        if (n > 255) {
            this.writeUnsignedByte(196);
            this.writeUnsignedByte(58);
            this.writeUnsignedShort(n);
        } else {
            switch (n) {
                case 0: {
                    this.writeUnsignedByte(75);
                    break;
                }
                case 1: {
                    this.writeUnsignedByte(76);
                    break;
                }
                case 2: {
                    this.writeUnsignedByte(77);
                    break;
                }
                case 3: {
                    this.writeUnsignedByte(78);
                    break;
                }
                default: {
                    this.writeUnsignedByte(58);
                    this.writeUnsignedByte(n);
                }
            }
        }
    }

    private byte[] getBytes() {
        byte[] byArray = new byte[this.headerOffset + this.contentsOffset];
        System.arraycopy((Object)this.header, 0, (Object)byArray, 0, this.headerOffset);
        System.arraycopy((Object)this.contents, 0, (Object)byArray, this.headerOffset, this.contentsOffset);
        return byArray;
    }

    private Method typeAccessMethod(Class clazz) {
        block40: {
            try {
                if (clazz == Integer.TYPE) {
                    Class clazz2 = class$19;
                    if (clazz2 == null) {
                        try {
                            clazz2 = class$19 = Class.forName("java.lang.Integer");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz2.getMethod("intValue", null);
                }
                if (clazz == Short.TYPE) {
                    Class clazz3 = class$20;
                    if (clazz3 == null) {
                        try {
                            clazz3 = class$20 = Class.forName("java.lang.Short");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz3.getMethod("shortValue", null);
                }
                if (clazz == Byte.TYPE) {
                    Class clazz4 = class$21;
                    if (clazz4 == null) {
                        try {
                            clazz4 = class$21 = Class.forName("java.lang.Byte");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz4.getMethod("byteValue", null);
                }
                if (clazz == Boolean.TYPE) {
                    Class clazz5 = class$22;
                    if (clazz5 == null) {
                        try {
                            clazz5 = class$22 = Class.forName("java.lang.Boolean");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz5.getMethod("booleanValue", null);
                }
                if (clazz == Character.TYPE) {
                    Class clazz6 = class$23;
                    if (clazz6 == null) {
                        try {
                            clazz6 = class$23 = Class.forName("java.lang.Character");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz6.getMethod("charValue", null);
                }
                if (clazz == Long.TYPE) {
                    Class clazz7 = class$24;
                    if (clazz7 == null) {
                        try {
                            clazz7 = class$24 = Class.forName("java.lang.Long");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz7.getMethod("longValue", null);
                }
                if (clazz == Float.TYPE) {
                    Class clazz8 = class$25;
                    if (clazz8 == null) {
                        try {
                            clazz8 = class$25 = Class.forName("java.lang.Float");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz8.getMethod("floatValue", null);
                }
                if (clazz != Double.TYPE) break block40;
                Class clazz9 = class$26;
                if (clazz9 == null) {
                    try {
                        clazz9 = class$26 = Class.forName("java.lang.Double");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                return clazz9.getMethod("doubleValue", null);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        return null;
    }

    private Field typeField(Class clazz) {
        block40: {
            try {
                if (clazz == Integer.TYPE) {
                    Class clazz2 = class$19;
                    if (clazz2 == null) {
                        try {
                            clazz2 = class$19 = Class.forName("java.lang.Integer");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz2.getField("TYPE");
                }
                if (clazz == Short.TYPE) {
                    Class clazz3 = class$20;
                    if (clazz3 == null) {
                        try {
                            clazz3 = class$20 = Class.forName("java.lang.Short");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz3.getField("TYPE");
                }
                if (clazz == Byte.TYPE) {
                    Class clazz4 = class$21;
                    if (clazz4 == null) {
                        try {
                            clazz4 = class$21 = Class.forName("java.lang.Byte");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz4.getField("TYPE");
                }
                if (clazz == Boolean.TYPE) {
                    Class clazz5 = class$22;
                    if (clazz5 == null) {
                        try {
                            clazz5 = class$22 = Class.forName("java.lang.Boolean");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz5.getField("TYPE");
                }
                if (clazz == Character.TYPE) {
                    Class clazz6 = class$23;
                    if (clazz6 == null) {
                        try {
                            clazz6 = class$23 = Class.forName("java.lang.Character");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz6.getField("TYPE");
                }
                if (clazz == Long.TYPE) {
                    Class clazz7 = class$24;
                    if (clazz7 == null) {
                        try {
                            clazz7 = class$24 = Class.forName("java.lang.Long");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz7.getField("TYPE");
                }
                if (clazz == Float.TYPE) {
                    Class clazz8 = class$25;
                    if (clazz8 == null) {
                        try {
                            clazz8 = class$25 = Class.forName("java.lang.Float");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz8.getField("TYPE");
                }
                if (clazz != Double.TYPE) break block40;
                Class clazz9 = class$26;
                if (clazz9 == null) {
                    try {
                        clazz9 = class$26 = Class.forName("java.lang.Double");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                return clazz9.getField("TYPE");
            }
            catch (NoSuchFieldException noSuchFieldException) {
                throw new InternalError();
            }
        }
        return null;
    }

    private Constructor typeInitMethod(Class clazz) {
        block40: {
            try {
                if (clazz == Integer.TYPE) {
                    Class clazz2 = class$19;
                    if (clazz2 == null) {
                        try {
                            clazz2 = class$19 = Class.forName("java.lang.Integer");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz2.getConstructor(new Class[]{Integer.TYPE});
                }
                if (clazz == Short.TYPE) {
                    Class clazz3 = class$20;
                    if (clazz3 == null) {
                        try {
                            clazz3 = class$20 = Class.forName("java.lang.Short");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz3.getConstructor(new Class[]{Short.TYPE});
                }
                if (clazz == Byte.TYPE) {
                    Class clazz4 = class$21;
                    if (clazz4 == null) {
                        try {
                            clazz4 = class$21 = Class.forName("java.lang.Byte");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz4.getConstructor(new Class[]{Byte.TYPE});
                }
                if (clazz == Boolean.TYPE) {
                    Class clazz5 = class$22;
                    if (clazz5 == null) {
                        try {
                            clazz5 = class$22 = Class.forName("java.lang.Boolean");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz5.getConstructor(new Class[]{Boolean.TYPE});
                }
                if (clazz == Character.TYPE) {
                    Class clazz6 = class$23;
                    if (clazz6 == null) {
                        try {
                            clazz6 = class$23 = Class.forName("java.lang.Character");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz6.getConstructor(new Class[]{Character.TYPE});
                }
                if (clazz == Long.TYPE) {
                    Class clazz7 = class$24;
                    if (clazz7 == null) {
                        try {
                            clazz7 = class$24 = Class.forName("java.lang.Long");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz7.getConstructor(new Class[]{Long.TYPE});
                }
                if (clazz == Float.TYPE) {
                    Class clazz8 = class$25;
                    if (clazz8 == null) {
                        try {
                            clazz8 = class$25 = Class.forName("java.lang.Float");
                        }
                        catch (ClassNotFoundException classNotFoundException) {
                            throw new NoClassDefFoundError(classNotFoundException.getMessage());
                        }
                    }
                    return clazz8.getConstructor(new Class[]{Float.TYPE});
                }
                if (clazz != Double.TYPE) break block40;
                Class clazz9 = class$26;
                if (clazz9 == null) {
                    try {
                        clazz9 = class$26 = Class.forName("java.lang.Double");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                return clazz9.getConstructor(new Class[]{Double.TYPE});
            }
            catch (NoSuchMethodException noSuchMethodException) {
                throw new InternalError();
            }
        }
        return null;
    }

    private String typeWrapperName(Class clazz) {
        if (clazz == Integer.TYPE) {
            return "java/lang/Integer";
        }
        if (clazz == Short.TYPE) {
            return "java/lang/Short";
        }
        if (clazz == Byte.TYPE) {
            return "java/lang/Byte";
        }
        if (clazz == Boolean.TYPE) {
            return "java/lang/Boolean";
        }
        if (clazz == Character.TYPE) {
            return "java/lang/Character";
        }
        if (clazz == Long.TYPE) {
            return "java/lang/Long";
        }
        if (clazz == Float.TYPE) {
            return "java/lang/Float";
        }
        if (clazz == Double.TYPE) {
            return "java/lang/Double";
        }
        return null;
    }

    private void writeIntConstant(int n) {
        switch (n) {
            case 0: {
                this.writeUnsignedByte(3);
                break;
            }
            case 1: {
                this.writeUnsignedByte(4);
                break;
            }
            case 2: {
                this.writeUnsignedByte(5);
                break;
            }
            case 3: {
                this.writeUnsignedByte(6);
                break;
            }
            case 4: {
                this.writeUnsignedByte(7);
                break;
            }
            case 5: {
                this.writeUnsignedByte(8);
                break;
            }
            default: {
                this.writeUnsignedByte(16);
                this.writeUnsignedByte(n);
            }
        }
    }

    private void writeLdc(String string) {
        int n = this.constantPool.literalIndexForLdc(string.toCharArray());
        if (n <= 0) {
            throw new InternalError();
        }
        if (n > 255) {
            this.writeUnsignedByte(19);
            this.writeUnsignedShort(n);
        } else {
            this.writeUnsignedByte(18);
            this.writeUnsignedByte(n);
        }
    }

    private void writeUnsignedByte(int n) {
        try {
            this.contents[this.contentsOffset++] = (byte)n;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            int n2 = this.contents.length;
            this.contents = new byte[n2 + 250];
            System.arraycopy((Object)this.contents, 0, (Object)this.contents, 0, n2);
            this.contents[this.contentsOffset - 1] = (byte)n;
        }
    }

    private void writeUnsignedShort(int n) {
        this.writeUnsignedByte(n >>> 8);
        this.writeUnsignedByte(n);
    }

    private void writeUnsignedWord(int n) {
        this.writeUnsignedByte(n >>> 24);
        this.writeUnsignedByte(n >>> 16);
        this.writeUnsignedByte(n >>> 8);
        this.writeUnsignedByte(n);
    }
}

