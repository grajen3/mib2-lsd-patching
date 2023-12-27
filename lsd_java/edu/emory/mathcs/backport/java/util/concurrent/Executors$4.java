/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedCallableUsingCurrentClassLoader;
import java.security.PrivilegedAction;

class Executors$4
implements PrivilegedAction {
    private final /* synthetic */ Executors$PrivilegedCallableUsingCurrentClassLoader this$0;

    Executors$4(Executors$PrivilegedCallableUsingCurrentClassLoader executors$PrivilegedCallableUsingCurrentClassLoader) {
        this.this$0 = executors$PrivilegedCallableUsingCurrentClassLoader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object run() {
        ClassLoader classLoader = null;
        Thread thread = Thread.currentThread();
        try {
            ClassLoader classLoader2 = thread.getContextClassLoader();
            if (Executors$PrivilegedCallableUsingCurrentClassLoader.access$300(this.this$0) != classLoader2) {
                thread.setContextClassLoader(Executors$PrivilegedCallableUsingCurrentClassLoader.access$300(this.this$0));
                classLoader = classLoader2;
            }
            Executors$PrivilegedCallableUsingCurrentClassLoader.access$402(this.this$0, Executors$PrivilegedCallableUsingCurrentClassLoader.access$500(this.this$0).call());
            if (classLoader != null) {
                thread.setContextClassLoader(classLoader);
            }
        }
        catch (Exception exception) {
            Executors$PrivilegedCallableUsingCurrentClassLoader.access$602(this.this$0, exception);
        }
        finally {
            if (classLoader != null) {
                thread.setContextClassLoader(classLoader);
            }
        }
        return null;
    }
}

