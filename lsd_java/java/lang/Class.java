/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.security.AllPermission;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.Vector;

public final class Class
implements Serializable {
    private static final long serialVersionUID;
    private static ProtectionDomain AllPermissionsPD;
    private static final int j9Version;
    private static final long j9Config;
    private static final Class[] EmptyParameters;
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

    static {
        EmptyParameters = new Class[0];
    }

    private Class() {
    }

    private void checkMemberAccess(int n) {
        ClassLoader classLoader;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null && (classLoader = ClassLoader.getStackClassLoader(2)) != ClassLoader.systemClassLoader) {
            securityManager.checkMemberAccess(this, n);
            String string = this.getPackageName();
            ClassLoader classLoader2 = this.getClassLoaderImpl();
            if (string != "" && classLoader != classLoader2 && !classLoader.isAncestorOf(classLoader2)) {
                securityManager.checkPackageAccess(string);
            }
        }
    }

    public static Class forName(String string) {
        ClassLoader classLoader = ClassLoader.callerClassLoader();
        return Class.forNameImpl(string, true, classLoader);
    }

    public static Class forName(String string, boolean bl, ClassLoader classLoader) {
        SecurityManager securityManager;
        ClassLoader classLoader2;
        if (classLoader == null && (classLoader2 = ClassLoader.callerClassLoader()) != null && (securityManager = System.getSecurityManager()) != null) {
            securityManager.checkPermission(RuntimePermission.permissionToGetClassLoader);
        }
        return Class.forNameImpl(string, bl, classLoader);
    }

    private static native Class forNameImpl(String string, boolean bl, ClassLoader classLoader) {
    }

    public Class[] getClasses() {
        Object[] objectArray;
        this.checkMemberAccess(0);
        Vector vector = new Vector();
        Class clazz = this;
        while (clazz != null) {
            objectArray = clazz.getDeclaredClassesImpl();
            int n = 0;
            while (n < objectArray.length) {
                if (Modifier.isPublic(((Class)objectArray[n]).getModifiers())) {
                    vector.addElement(objectArray[n]);
                }
                ++n;
            }
            clazz = clazz.getSuperclass();
        }
        objectArray = new Class[vector.size()];
        vector.copyInto(objectArray);
        return objectArray;
    }

    public ClassLoader getClassLoader() {
        ClassLoader classLoader = this.getClassLoaderImpl();
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            if (classLoader == ClassLoader.systemClassLoader) {
                return null;
            }
            ClassLoader classLoader2 = ClassLoader.callerClassLoader();
            if (classLoader2 != null && classLoader2 != classLoader && !classLoader2.isAncestorOf(classLoader)) {
                securityManager.checkPermission(RuntimePermission.permissionToGetClassLoader);
            }
        }
        if (classLoader == ClassLoader.systemClassLoader) {
            return null;
        }
        return classLoader;
    }

    native ClassLoader getClassLoaderImpl() {
    }

    public native Class getComponentType() {
    }

    private void throwNoSuchMethodException(String string, Class[] classArray) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.getName()).append('.').append(string).append('(');
        if (classArray.length > 0) {
            stringBuffer.append(classArray[0] == null ? null : classArray[0].getName());
            int n = 1;
            while (n < classArray.length) {
                stringBuffer.append(", ").append(classArray[n] == null ? null : classArray[n].getName());
                ++n;
            }
        }
        stringBuffer.append(')');
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    public Constructor getConstructor(Class[] classArray) {
        this.checkMemberAccess(0);
        if (classArray == null || classArray.length == 0) {
            Constructor constructor = this.getConstructorImpl(EmptyParameters, "()V");
            if (constructor == null) {
                this.throwNoSuchMethodException("<init>", EmptyParameters);
            }
            return constructor;
        }
        int n = 3;
        String[] stringArray = new String[classArray.length];
        int n2 = 0;
        while (n2 < classArray.length) {
            if (classArray[n2] != null) {
                stringArray[n2] = classArray[n2].getSignature();
                n += stringArray[n2].length();
            } else {
                this.throwNoSuchMethodException("<init>", classArray);
            }
            ++n2;
        }
        StringBuffer stringBuffer = new StringBuffer(n);
        stringBuffer.append('(');
        int n3 = 0;
        while (n3 < classArray.length) {
            stringBuffer.append(stringArray[n3]);
            ++n3;
        }
        stringBuffer.append(")V");
        Constructor constructor = this.getConstructorImpl((Class[])classArray.clone(), stringBuffer.toString());
        if (constructor == null) {
            this.throwNoSuchMethodException("<init>", classArray);
        }
        return constructor;
    }

    private native Constructor getConstructorImpl(Class[] classArray, String string) {
    }

    public Constructor[] getConstructors() {
        this.checkMemberAccess(0);
        return this.getConstructorsImpl();
    }

    private native Constructor[] getConstructorsImpl() {
    }

    public Class[] getDeclaredClasses() {
        this.checkMemberAccess(1);
        return this.getDeclaredClassesImpl();
    }

    private native Class[] getDeclaredClassesImpl() {
    }

    public Constructor getDeclaredConstructor(Class[] classArray) {
        this.checkMemberAccess(1);
        if (classArray == null || classArray.length == 0) {
            Constructor constructor = this.getDeclaredConstructorImpl(EmptyParameters, "()V");
            if (constructor == null) {
                this.throwNoSuchMethodException("<init>", EmptyParameters);
            }
            return constructor;
        }
        int n = 3;
        String[] stringArray = new String[classArray.length];
        int n2 = 0;
        while (n2 < classArray.length) {
            if (classArray[n2] != null) {
                stringArray[n2] = classArray[n2].getSignature();
                n += stringArray[n2].length();
            } else {
                this.throwNoSuchMethodException("<init>", classArray);
            }
            ++n2;
        }
        StringBuffer stringBuffer = new StringBuffer(n);
        stringBuffer.append('(');
        int n3 = 0;
        while (n3 < classArray.length) {
            stringBuffer.append(stringArray[n3]);
            ++n3;
        }
        stringBuffer.append(")V");
        Constructor constructor = this.getDeclaredConstructorImpl((Class[])classArray.clone(), stringBuffer.toString());
        if (constructor == null) {
            this.throwNoSuchMethodException("<init>", classArray);
        }
        return constructor;
    }

    private native Constructor getDeclaredConstructorImpl(Class[] classArray, String string) {
    }

    public Constructor[] getDeclaredConstructors() {
        this.checkMemberAccess(1);
        return this.getDeclaredConstructorsImpl();
    }

    private native Constructor[] getDeclaredConstructorsImpl() {
    }

    public Field getDeclaredField(String string) {
        this.checkMemberAccess(1);
        return this.getDeclaredFieldImpl(string);
    }

    private native Field getDeclaredFieldImpl(String string) {
    }

    public Field[] getDeclaredFields() {
        this.checkMemberAccess(1);
        return this.getDeclaredFieldsImpl();
    }

    private native Field[] getDeclaredFieldsImpl() {
    }

    public Method getDeclaredMethod(String string, Class[] classArray) {
        Class[] classArray2;
        String string2;
        this.checkMemberAccess(1);
        if (string == null || classArray == null || classArray.length == 0) {
            string2 = "()";
            classArray2 = EmptyParameters;
        } else {
            string2 = this.getParameterTypesSignature(string, classArray);
            classArray2 = (Class[])classArray.clone();
        }
        Method method = this.getDeclaredMethodImpl(string, classArray2, string2, null);
        if (method == null) {
            this.throwNoSuchMethodException(string, classArray2);
        }
        Method method2 = method;
        int n = method.getReturnType().getClassDepth();
        while ((method = this.getDeclaredMethodImpl(string, classArray2, string2, method)) != null) {
            int n2 = method.getReturnType().getClassDepth();
            if (n2 <= n) continue;
            method2 = method;
            n = n2;
        }
        return method2;
    }

    private native Method getDeclaredMethodImpl(String string, Class[] classArray, String string2, Method method) {
    }

    public Method[] getDeclaredMethods() {
        this.checkMemberAccess(1);
        return this.getDeclaredMethodsImpl();
    }

    private native Method[] getDeclaredMethodsImpl() {
    }

    public Class getDeclaringClass() {
        return this.getDeclaringClassImpl();
    }

    private native Class getDeclaringClassImpl() {
    }

    public Field getField(String string) {
        this.checkMemberAccess(0);
        return this.getFieldImpl(string);
    }

    private native Field getFieldImpl(String string) {
    }

    public Field[] getFields() {
        this.checkMemberAccess(0);
        return this.getFieldsImpl();
    }

    private native Field[] getFieldsImpl() {
    }

    public native Class[] getInterfaces() {
    }

    public Method getMethod(String string, Class[] classArray) {
        Class[] classArray2;
        String string2;
        this.checkMemberAccess(0);
        if (string == null || classArray == null || classArray.length == 0) {
            string2 = "()";
            classArray2 = EmptyParameters;
        } else {
            string2 = this.getParameterTypesSignature(string, classArray);
            classArray2 = (Class[])classArray.clone();
        }
        Method method = this.getMethodImpl(string, classArray2, string2);
        if (method == null) {
            this.throwNoSuchMethodException(string, classArray2);
        }
        Method method2 = method;
        int n = method.getReturnType().getClassDepth();
        Class clazz = method.getDeclaringClass();
        while ((method = clazz.getDeclaredMethodImpl(string, classArray2, string2, method)) != null) {
            int n2;
            if ((method.getModifiers() & 1) == 0 || (n2 = method.getReturnType().getClassDepth()) <= n) continue;
            method2 = method;
            n = n2;
        }
        return method2;
    }

    private native Method getMethodImpl(String string, Class[] classArray, String string2) {
    }

    public Method[] getMethods() {
        this.checkMemberAccess(0);
        if (this.isPrimitive()) {
            return new Method[0];
        }
        if (this.isInterface()) {
            return this.getInterfaceMethodsImpl();
        }
        int n = this.getVirtualMethodCountImpl();
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.reflect.Method");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        Method[] methodArray = (Method[])clazz.allocateAndFillArray(n + this.getStaticMethodCountImpl());
        this.getVirtualMethodsImpl(methodArray, 0);
        this.getStaticMethodsImpl(methodArray, n);
        return methodArray;
    }

    private boolean methodsEqual(Method method, Method method2) {
        Class[] classArray;
        if (!method.getName().equals(method2.getName())) {
            return false;
        }
        if (!method.getReturnType().equals(method2.getReturnType())) {
            return false;
        }
        Class[] classArray2 = method.getParameterTypes();
        if (classArray2.length != (classArray = method2.getParameterTypes()).length) {
            return false;
        }
        int n = 0;
        while (n < classArray2.length) {
            if (classArray2[n] != classArray[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private int getInterfaceMethodCountImpl() {
        int n = this.getDeclaredMethods().length;
        Class[] classArray = this.getInterfaces();
        int n2 = 0;
        while (n2 < classArray.length) {
            n += classArray[n2].getInterfaceMethodCountImpl();
            ++n2;
        }
        return n;
    }

    private Method[] getInterfaceMethodsImpl() {
        Method[] methodArray = new Method[this.getInterfaceMethodCountImpl()];
        Method[] methodArray2 = this.getDeclaredMethods();
        int n = 0;
        int n2 = 0;
        while (n2 < methodArray2.length) {
            if (Modifier.isAbstract(methodArray2[n2].getModifiers())) {
                methodArray[n++] = methodArray2[n2];
            } else {
                methodArray2[n2] = null;
            }
            ++n2;
        }
        Class[] classArray = this.getInterfaces();
        n2 = 0;
        while (n2 < classArray.length) {
            Method[] methodArray3 = classArray[n2].getInterfaceMethodsImpl();
            int n3 = 0;
            while (n3 < methodArray2.length) {
                if (methodArray2[n3] != null) {
                    int n4 = 0;
                    while (n4 < methodArray3.length) {
                        if (methodArray3[n4] != null && this.methodsEqual(methodArray2[n3], methodArray3[n4])) {
                            methodArray3[n4] = null;
                        }
                        ++n4;
                    }
                }
                ++n3;
            }
            n3 = 0;
            while (n3 < methodArray3.length) {
                if (methodArray3[n3] != null) {
                    methodArray[n++] = methodArray3[n3];
                }
                ++n3;
            }
            ++n2;
        }
        n2 = 0;
        while (n2 < methodArray.length) {
            if (methodArray[n2] != null) {
                int n5 = n2 + 1;
                while (n5 < methodArray.length) {
                    if (methodArray[n5] != null && methodArray[n2].equals(methodArray[n5])) {
                        methodArray[n5] = null;
                    }
                    ++n5;
                }
            }
            ++n2;
        }
        int n6 = 0;
        n2 = 0;
        while (n2 < methodArray.length) {
            if (methodArray[n2] != null) {
                ++n6;
            }
            ++n2;
        }
        Method[] methodArray4 = new Method[n6];
        n = 0;
        n2 = 0;
        while (n2 < methodArray.length) {
            if (methodArray[n2] != null) {
                methodArray4[n++] = methodArray[n2];
            }
            ++n2;
        }
        return methodArray4;
    }

    private native int getVirtualMethodCountImpl() {
    }

    private native void getVirtualMethodsImpl(Method[] methodArray, int n) {
    }

    private native int getStaticMethodCountImpl() {
    }

    private native void getStaticMethodsImpl(Method[] methodArray, int n) {
    }

    private native Object[] allocateAndFillArray(int n) {
    }

    public native int getModifiers() {
    }

    private native String getClassNameStringImpl() {
    }

    private native void setClassNameStringImpl(String string) {
    }

    public String getName() {
        String string = this.getClassNameStringImpl();
        if (string != null) {
            return string;
        }
        string = this.getNameImpl().intern();
        this.setClassNameStringImpl(string);
        return string;
    }

    native String getNameImpl() {
    }

    public ProtectionDomain getProtectionDomain() {
        ProtectionDomain protectionDomain;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(RuntimePermission.permissionToGetProtectionDomain);
        }
        if ((protectionDomain = this.getPDImpl()) != null) {
            return protectionDomain;
        }
        if (AllPermissionsPD == null) {
            Permissions permissions = new Permissions();
            permissions.add(new AllPermission());
            AllPermissionsPD = new ProtectionDomain(null, permissions);
        }
        return AllPermissionsPD;
    }

    native ProtectionDomain getPDImpl() {
    }

    String getPackageName() {
        String string = this.getName();
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            return string.substring(0, n);
        }
        return "";
    }

    public URL getResource(String string) {
        ClassLoader classLoader = this.getClassLoaderImpl();
        if (classLoader == ClassLoader.systemClassLoader) {
            return ClassLoader.getSystemResource(this.toResourceName(string));
        }
        return classLoader.getResource(this.toResourceName(string));
    }

    public InputStream getResourceAsStream(String string) {
        ClassLoader classLoader = this.getClassLoaderImpl();
        if (classLoader == ClassLoader.systemClassLoader) {
            return ClassLoader.getSystemResourceAsStream(this.toResourceName(string));
        }
        return classLoader.getResourceAsStream(this.toResourceName(string));
    }

    private String getSignature() {
        if (this.isArray()) {
            return this.getName();
        }
        if (this.isPrimitive()) {
            if (this == Void.TYPE) {
                return "V";
            }
            if (this == Boolean.TYPE) {
                return "Z";
            }
            if (this == Byte.TYPE) {
                return "B";
            }
            if (this == Character.TYPE) {
                return "C";
            }
            if (this == Short.TYPE) {
                return "S";
            }
            if (this == Integer.TYPE) {
                return "I";
            }
            if (this == Long.TYPE) {
                return "J";
            }
            if (this == Float.TYPE) {
                return "F";
            }
            if (this == Double.TYPE) {
                return "D";
            }
        }
        String string = this.getName();
        return new StringBuffer(string.length() + 2).append('L').append(string).append(';').toString();
    }

    public Object[] getSigners() {
        return this.getClassLoaderImpl().getSigners(this);
    }

    public native Class getSuperclass() {
    }

    public native boolean isArray() {
    }

    public native boolean isAssignableFrom(Class clazz) {
    }

    public native boolean isInstance(Object object) {
    }

    public boolean isInterface() {
        return (this.getModifiers() & 0x200) != 0;
    }

    public native boolean isPrimitive() {
    }

    public Object newInstance() {
        this.checkMemberAccess(0);
        return this.newInstanceImpl();
    }

    private Object newInstancePrototype(Class clazz) {
        throw new InstantiationException(this);
    }

    private native Object newInstanceImpl() {
    }

    private String toResourceName(String string) {
        if (string.length() > 0 && string.charAt(0) == '/') {
            return string.substring(1);
        }
        String string2 = this.getName();
        int n = string2.lastIndexOf(46);
        if (n == -1) {
            return string;
        }
        return new StringBuffer(String.valueOf(string2.substring(0, n + 1).replace('.', '/'))).append(string).toString();
    }

    public String toString() {
        if (this.isPrimitive()) {
            return this.getName();
        }
        return new StringBuffer(String.valueOf(this.isInterface() ? "interface " : "class ")).append(this.getName()).toString();
    }

    public Package getPackage() {
        return this.getClassLoaderImpl().getPackage(this.getPackageName());
    }

    public boolean desiredAssertionStatus() {
        ClassLoader classLoader = this.getClassLoaderImpl();
        if (classLoader != null) {
            return classLoader.getClassAssertionStatus(this.getName());
        }
        return false;
    }

    static final native Class[] getStackClasses(int n, boolean bl) {
    }

    private native int getClassDepth() {
    }

    private String getParameterTypesSignature(String string, Class[] classArray) {
        int n = 2;
        String[] stringArray = new String[classArray.length];
        int n2 = 0;
        while (n2 < classArray.length) {
            Class clazz = classArray[n2];
            if (clazz != null) {
                stringArray[n2] = clazz.getSignature();
                n += stringArray[n2].length();
                ClassLoader classLoader = this.getClassLoader();
                if (!clazz.isPrimitive()) {
                    try {
                        if (Class.forName(clazz.getName(), false, classLoader) != clazz) {
                            this.throwNoSuchMethodException(string, classArray);
                        }
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        this.throwNoSuchMethodException(string, classArray);
                    }
                }
            } else {
                this.throwNoSuchMethodException(string, classArray);
            }
            ++n2;
        }
        StringBuffer stringBuffer = new StringBuffer(n);
        stringBuffer.append('(');
        int n3 = 0;
        while (n3 < classArray.length) {
            stringBuffer.append(stringArray[n3]);
            ++n3;
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

