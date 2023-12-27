/*
 * Decompiled with CFR 0.152.
 */
package java.lang.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public final class Constructor
extends AccessibleObject
implements Member {
    private Class declaringClass;
    private Class[] parameterTypes;
    private Class[] exceptionTypes;
    private Class returnType;
    private String name;
    private long vm1;

    private Constructor() {
    }

    public boolean equals(Object object) {
        Class[] classArray;
        if (this == object) {
            return true;
        }
        if (!(object instanceof Constructor)) {
            return false;
        }
        Constructor constructor = (Constructor)object;
        if (this.getDeclaringClass() != constructor.getDeclaringClass()) {
            return false;
        }
        Class[] classArray2 = this.getParameterTypes();
        if (classArray2.length != (classArray = constructor.getParameterTypes()).length) {
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
        this.name = this.getDeclaringClass().getName();
        return this.name;
    }

    public Class[] getParameterTypes() {
        if (this.parameterTypes == null) {
            this.getParameterTypesImpl();
        }
        return (Class[])this.parameterTypes.clone();
    }

    public int hashCode() {
        return this.getName().hashCode();
    }

    public Object newInstance(Object[] objectArray) {
        Class clazz;
        Object object;
        if (objectArray == null) {
            objectArray = emptyArgs;
        }
        if ((object = this.newInstanceImpl()) == null) {
            throw new InstantiationException();
        }
        if (!this.isAccessible() && !this.checkAccessibility(clazz = Constructor.getStackClass(-1), object)) {
            throw new IllegalAccessException();
        }
        if (this.parameterTypes == null) {
            this.getParameterTypesImpl();
        }
        objectArray = Constructor.marshallArguments(this.parameterTypes, objectArray);
        try {
            Constructor.initializeClass(this.getDeclaringClass());
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
        this.invokeV(object, objectArray);
        return object;
    }

    private native Object newInstanceImpl() {
    }

    public String toString() {
        Class clazz;
        StringBuffer stringBuffer = new StringBuffer();
        String string = Modifier.toString(this.getModifiers());
        if (string.length() != 0) {
            stringBuffer.append(string);
            stringBuffer.append(" ");
        }
        stringBuffer.append(this.getName());
        stringBuffer.append("(");
        Class[] classArray = this.getParameterTypes();
        int n = 0;
        while (n < classArray.length) {
            clazz = classArray[n];
            int n2 = 0;
            while (clazz.isArray()) {
                clazz = clazz.getComponentType();
                ++n2;
            }
            stringBuffer.append(clazz.getName());
            while (n2 > 0) {
                stringBuffer.append("[]");
                --n2;
            }
            if (n != classArray.length - 1) {
                stringBuffer.append(",");
            }
            ++n;
        }
        stringBuffer.append(")");
        classArray = this.getExceptionTypes();
        if (classArray.length > 0) {
            stringBuffer.append(" throws ");
            n = 0;
            while (n < classArray.length) {
                clazz = classArray[n];
                stringBuffer.append(clazz.getName());
                if (n != classArray.length - 1) {
                    stringBuffer.append(",");
                }
                ++n;
            }
        }
        return stringBuffer.toString();
    }
}

