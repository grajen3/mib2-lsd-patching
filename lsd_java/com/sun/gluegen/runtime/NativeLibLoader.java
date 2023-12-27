/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.NativeLibLoader$1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;

public class NativeLibLoader {
    private static volatile boolean loadingEnabled = true;
    private static volatile boolean didLoading;
    static /* synthetic */ Class class$com$sun$gluegen$runtime$NativeLibLoader;
    static /* synthetic */ Class class$java$lang$String;

    public static void disableLoading() {
        loadingEnabled = false;
    }

    public static void enableLoading() {
        loadingEnabled = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void loadGlueGenRT() {
        if (!didLoading && loadingEnabled) {
            Class clazz = class$com$sun$gluegen$runtime$NativeLibLoader == null ? (class$com$sun$gluegen$runtime$NativeLibLoader = NativeLibLoader.class$("com.sun.gluegen.runtime.NativeLibLoader")) : class$com$sun$gluegen$runtime$NativeLibLoader;
            synchronized (clazz) {
                if (!didLoading && loadingEnabled) {
                    didLoading = true;
                    AccessController.doPrivileged(new NativeLibLoader$1());
                }
            }
        }
    }

    private static void loadLibraryInternal(String string) {
        String string2 = System.getProperty("sun.jnlp.applet.launcher");
        boolean bl = Boolean.valueOf(string2);
        if (bl) {
            try {
                Class clazz = Class.forName("org.jdesktop.applet.util.JNLPAppletLauncher");
                Method method = clazz.getDeclaredMethod("loadLibrary", new Class[]{class$java$lang$String == null ? (class$java$lang$String = NativeLibLoader.class$("java.lang.String")) : class$java$lang$String});
                method.invoke(null, new Object[]{string});
            }
            catch (Exception exception) {
                Throwable throwable = exception;
                if (throwable instanceof InvocationTargetException) {
                    throwable = ((InvocationTargetException)throwable).getTargetException();
                }
                if (throwable instanceof Error) {
                    throw (Error)throwable;
                }
                if (throwable instanceof RuntimeException) {
                    throw (RuntimeException)throwable;
                }
                throw (UnsatisfiedLinkError)new UnsatisfiedLinkError().initCause(exception);
            }
        } else {
            System.loadLibrary(string);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ void access$000(String string) {
        NativeLibLoader.loadLibraryInternal(string);
    }
}

