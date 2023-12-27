/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;
import java.util.ResourceBundle;

final class ResourceBundle$2
implements PrivilegedAction {
    ResourceBundle$2() {
    }

    @Override
    public Object run() {
        try {
            Class clazz = ResourceBundle.class$1;
            if (clazz == null) {
                try {
                    clazz = ResourceBundle.class$1 = Class.forName("java.lang.ClassLoader");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            Method method = clazz.getDeclaredMethod("getBundleCache", new Class[0]);
            method.setAccessible(true);
            return method;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            return null;
        }
    }
}

