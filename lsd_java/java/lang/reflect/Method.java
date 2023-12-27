/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class Method
extends AccessibleObject
implements Member {
    private Class declaringClass;
    private Class[] parameterTypes;
    private Class[] exceptionTypes;
    private Class returnType;
    private String name;
    private long vm1;

    private Method() {
    }

    public boolean equals(Object object) {
        Class[] classArray;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Method)) {
            return false;
        }
        Method method = (Method)object;
        if (!this.getName().equals(method.getName())) {
            return false;
        }
        if (this.getDeclaringClass() != method.getDeclaringClass()) {
            return false;
        }
        Class[] classArray2 = this.getParameterTypes();
        if (classArray2.length != (classArray = method.getParameterTypes()).length) {
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

    @Override
    public Class getDeclaringClass() {
        return this.declaringClass;
    }

    public Class[] getExceptionTypes() {
        if (this.exceptionTypes == null) {
            this.getExceptionTypesImpl();
        }
        return (Class[])this.exceptionTypes.clone();
    }

    @Override
    public int getModifiers() {
        return super.getModifiers();
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

    public Class[] getParameterTypes() {
        if (this.parameterTypes == null) {
            this.getParameterTypesImpl();
        }
        return (Class[])this.parameterTypes.clone();
    }

    public Class getReturnType() {
        if (this.returnType != null) {
            return this.returnType;
        }
        return this.getReturnTypeImpl();
    }

    private native Class getReturnTypeImpl() {
    }

    public int hashCode() {
        return this.getName().hashCode() ^ this.getDeclaringClass().getName().hashCode();
    }

    public Object invoke(Object object, Object[] objectArray) {
        Class clazz;
        Class clazz2 = this.getDeclaringClass();
        if ((this.getModifiers() & 8) == 0) {
            if (object == null) {
                throw new NullPointerException();
            }
            if (!clazz2.isInstance(object)) {
                throw new IllegalArgumentException("invalid receiver");
            }
        } else {
            object = null;
        }
        if (objectArray == null) {
            objectArray = emptyArgs;
        }
        if (!this.isAccessible() && !this.checkAccessibility(clazz = Method.getStackClass(-1), object)) {
            throw new IllegalAccessException();
        }
        if (this.parameterTypes == null) {
            this.getParameterTypesImpl();
        }
        objectArray = Method.marshallArguments(this.parameterTypes, objectArray);
        if (object == null) {
            try {
                Method.initializeClass(clazz2);
            }
            catch (Throwable throwable) {
                throw new InvocationTargetException(throwable);
            }
        }
        if (this.returnType == null) {
            this.getReturnTypeImpl();
        }
        if (this.returnType == Void.TYPE) {
            this.invokeV(object, objectArray);
            return null;
        }
        if (this.returnType == Boolean.TYPE) {
            return new Boolean(this.invokeI(object, objectArray) != 0);
        }
        if (this.returnType == Character.TYPE) {
            return new Character((char)this.invokeI(object, objectArray));
        }
        if (this.returnType == Byte.TYPE) {
            return new Byte((byte)this.invokeI(object, objectArray));
        }
        if (this.returnType == Short.TYPE) {
            return new Short((short)this.invokeI(object, objectArray));
        }
        if (this.returnType == Integer.TYPE) {
            return new Integer(this.invokeI(object, objectArray));
        }
        if (this.returnType == Long.TYPE) {
            return new Long(this.invokeJ(object, objectArray));
        }
        if (this.returnType == Float.TYPE) {
            return new Float(this.invokeF(object, objectArray));
        }
        if (this.returnType == Double.TYPE) {
            return new Double(this.invokeD(object, objectArray));
        }
        return this.invokeL(object, objectArray);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string = Modifier.toString(this.getModifiers());
        if (string.length() != 0) {
            stringBuffer.append(string);
            stringBuffer.append(" ");
        }
        Class clazz = this.getReturnType();
        int n = 0;
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
        stringBuffer.append("(");
        Class[] classArray = this.getParameterTypes();
        int n2 = 0;
        while (n2 < classArray.length) {
            clazz = classArray[n2];
            n = 0;
            while (clazz.isArray()) {
                clazz = clazz.getComponentType();
                ++n;
            }
            stringBuffer.append(clazz.getName());
            while (n > 0) {
                stringBuffer.append("[]");
                --n;
            }
            if (n2 != classArray.length - 1) {
                stringBuffer.append(",");
            }
            ++n2;
        }
        stringBuffer.append(")");
        classArray = this.getExceptionTypes();
        if (classArray.length > 0) {
            stringBuffer.append(" throws ");
            n2 = 0;
            while (n2 < classArray.length) {
                clazz = classArray[n2];
                stringBuffer.append(clazz.getName());
                if (n2 != classArray.length - 1) {
                    stringBuffer.append(",");
                }
                ++n2;
            }
        }
        return stringBuffer.toString();
    }
}

