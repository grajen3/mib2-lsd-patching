/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import com.ibm.oti.vm.VM;
import java.lang.reflect.Method;

public final class Void {
    public static final Class TYPE;
    static /* synthetic */ Class class$0;

    static {
        Class clazz = null;
        try {
            Class clazz2 = class$0;
            if (clazz2 == null) {
                try {
                    clazz2 = class$0 = Class.forName("java.lang.Runnable");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            Method method = clazz2.getMethod("run", new Class[0]);
            clazz = method.getReturnType();
        }
        catch (Exception exception) {
            VM.dumpString("Cannot initialize Void.TYPE\n");
        }
        TYPE = clazz;
    }

    private Void() {
    }
}

