/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.PrivilegedAction;

final class J9VMInternals$1
implements PrivilegedAction {
    private final /* synthetic */ Throwable val$throwable;

    J9VMInternals$1(Throwable throwable) {
        this.val$throwable = throwable;
    }

    @Override
    public Object run() {
        Throwable throwable;
        try {
            Class clazz = super.getClass();
            Class clazz2 = J9VMInternals.class$0;
            if (clazz2 == null) {
                try {
                    clazz2 = J9VMInternals.class$0 = Class.forName("java.lang.Object");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            throwable = J9VMInternals.access$0(clazz, clazz2);
            while (clazz != null) {
                Field[] fieldArray = clazz.getDeclaredFields();
                int n = 0;
                while (n < fieldArray.length) {
                    if (!Modifier.isStatic(fieldArray[n].getModifiers())) {
                        Class clazz3 = J9VMInternals.class$1;
                        if (clazz3 == null) {
                            try {
                                clazz3 = Class.forName("java.lang.Throwable");
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                throw new NoClassDefFoundError(classNotFoundException.getMessage());
                            }
                        }
                        if (clazz != clazz3 || !fieldArray[n].getName().equals("walkback")) {
                            fieldArray[n].setAccessible(true);
                            Class clazz4 = J9VMInternals.class$1;
                            if (clazz4 == null) {
                                try {
                                    clazz4 = Class.forName("java.lang.Throwable");
                                }
                                catch (ClassNotFoundException classNotFoundException) {
                                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                                }
                            }
                            Object object = clazz == clazz4 && fieldArray[n].getName().equals("cause") ? throwable : fieldArray[n].get(this.val$throwable);
                            fieldArray[n].set(throwable, object);
                        }
                    }
                    ++n;
                }
                clazz = clazz.getSuperclass();
            }
        }
        catch (Throwable throwable2) {
            throwable = new Throwable(new StringBuffer("Error cloning Throwable (").append(throwable2).append("). The original exception was: ").append(this.val$throwable.toString()).toString());
        }
        return throwable;
    }
}

