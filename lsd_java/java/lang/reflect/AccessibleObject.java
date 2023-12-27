/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.lang.reflect;

import com.ibm.oti.util.Msg;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ReflectPermission;

public class AccessibleObject {
    private static final ReflectPermission suppressAccessChecksPermission = new ReflectPermission("suppressAccessChecks");
    static final Object[] emptyArgs = new Object[0];
    private int vm1;

    protected AccessibleObject() {
    }

    public boolean isAccessible() {
        return this.getAccessibleImpl();
    }

    public static void setAccessible(AccessibleObject[] accessibleObjectArray, boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(suppressAccessChecksPermission);
        }
        int n = 0;
        while (n < accessibleObjectArray.length) {
            accessibleObjectArray[n].setAccessibleImpl(bl);
            ++n;
        }
    }

    public void setAccessible(boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(suppressAccessChecksPermission);
        }
        this.setAccessibleImpl(bl);
    }

    static Object[] marshallArguments(Class[] classArray, Object[] objectArray) {
        if (classArray.length != objectArray.length) {
            throw new IllegalArgumentException(Msg.getString("K01b3"));
        }
        Object[] objectArray2 = objectArray;
        int n = objectArray.length - 1;
        while (n >= 0) {
            Object object = objectArray[n];
            Class clazz = classArray[n];
            Object object2 = AccessibleObject.marshallArgument(object, clazz);
            if (object2 != object) {
                if (objectArray2 == objectArray) {
                    objectArray2 = (Object[])objectArray.clone();
                }
                objectArray2[n] = object2;
            }
            --n;
        }
        return objectArray2;
    }

    private static Object marshallArgument(Object object, Class clazz) {
        if (clazz.isPrimitive()) {
            if (object instanceof Boolean) {
                if (clazz == Boolean.TYPE) {
                    return object;
                }
            } else if (object instanceof Character) {
                if (clazz == Character.TYPE) {
                    return object;
                }
                char c2 = ((Character)object).charValue();
                if (clazz == Integer.TYPE) {
                    return new Integer(c2);
                }
                if (clazz == Long.TYPE) {
                    return new Long(c2);
                }
                if (clazz == Double.TYPE) {
                    return new Double((double)c2);
                }
                if (clazz == Float.TYPE) {
                    return new Float(c2);
                }
            } else if (object instanceof Byte) {
                if (clazz == Byte.TYPE) {
                    return object;
                }
                if (clazz == Short.TYPE) {
                    return object;
                }
                if (clazz == Integer.TYPE) {
                    return object;
                }
                Number number = AccessibleObject.coerce((Number)object, clazz);
                if (number != null) {
                    return number;
                }
            } else if (object instanceof Short) {
                if (clazz == Short.TYPE) {
                    return object;
                }
                if (clazz == Integer.TYPE) {
                    return object;
                }
                Number number = AccessibleObject.coerce((Number)object, clazz);
                if (number != null) {
                    return number;
                }
            } else if (object instanceof Integer) {
                if (clazz == Integer.TYPE) {
                    return object;
                }
                Number number = AccessibleObject.coerce((Number)object, clazz);
                if (number != null) {
                    return number;
                }
            } else if (object instanceof Long) {
                if (clazz == Long.TYPE) {
                    return object;
                }
                Number number = AccessibleObject.coerce((Number)object, clazz);
                if (number != null) {
                    return number;
                }
            } else if (object instanceof Float) {
                if (clazz == Float.TYPE) {
                    return object;
                }
                if (clazz == Double.TYPE) {
                    return new Double(((Number)object).doubleValue());
                }
            } else if (object instanceof Double) {
                if (clazz == Double.TYPE) {
                    return object;
                }
            } else if (object == null) {
                throw new NullPointerException();
            }
        } else if (object == null || clazz.isInstance(object)) {
            return object;
        }
        String string = null;
        if (object != null) {
            string = object.getClass().getName();
        }
        throw new IllegalArgumentException(Msg.getString("K01b4", string, clazz.getName()));
    }

    private static Number coerce(Number number, Class clazz) {
        if (clazz == Double.TYPE) {
            return new Double(number.doubleValue());
        }
        if (clazz == Float.TYPE) {
            return new Float(number.floatValue());
        }
        if (clazz == Long.TYPE) {
            return new Long(number.longValue());
        }
        return null;
    }

    void invokeV(Object object, Object[] objectArray) {
        try {
            this.invokeImpl(object, objectArray, (Void)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    Object invokeL(Object object, Object[] objectArray) {
        try {
            return this.invokeImpl(object, objectArray, (Object)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    int invokeI(Object object, Object[] objectArray) {
        try {
            return this.invokeImpl(object, objectArray, (Integer)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    long invokeJ(Object object, Object[] objectArray) {
        try {
            return this.invokeImpl(object, objectArray, (Long)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    float invokeF(Object object, Object[] objectArray) {
        try {
            return this.invokeImpl(object, objectArray, (Float)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    double invokeD(Object object, Object[] objectArray) {
        try {
            return this.invokeImpl(object, objectArray, (Double)null);
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }

    private native boolean getAccessibleImpl() {
    }

    private native void setAccessibleImpl(boolean bl) {
    }

    native Class[] getParameterTypesImpl() {
    }

    native int getModifiers() {
    }

    native Class[] getExceptionTypesImpl() {
    }

    native String getSignature() {
    }

    native boolean checkAccessibility(Class clazz, Object object) {
    }

    private native Object invokeImpl(Object object, Object[] objectArray, Object object2) {
    }

    private native double invokeImpl(Object object, Object[] objectArray, Double d2) {
    }

    private native float invokeImpl(Object object, Object[] objectArray, Float f2) {
    }

    private native int invokeImpl(Object object, Object[] objectArray, Integer n) {
    }

    private native long invokeImpl(Object object, Object[] objectArray, Long l) {
    }

    private native void invokeImpl(Object object, Object[] objectArray, Void void_) {
    }

    static native void initializeClass(Class clazz) {
    }

    static final native Class getStackClass(int n) {
    }
}

