/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.NativeLibLoader$1;
import com.sun.opengl.impl.NativeLibLoader$2;
import com.sun.opengl.impl.NativeLibLoader$3;
import com.sun.opengl.impl.NativeLibLoader$DefaultAction;
import com.sun.opengl.impl.NativeLibLoader$LoaderAction;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.HashSet;

public class NativeLibLoader {
    private static final HashSet loaded = new HashSet();
    private static NativeLibLoader$LoaderAction loaderAction = new NativeLibLoader$DefaultAction(null);
    private static boolean usingJNLPAppletLauncher;
    private static Method jnlpLoadLibraryMethod;
    static /* synthetic */ Class class$java$lang$String;

    public static void disableLoading() {
        NativeLibLoader.setLoadingAction(null);
    }

    public static void enableLoading() {
        NativeLibLoader.setLoadingAction(new NativeLibLoader$DefaultAction(null));
    }

    public static synchronized void setLoadingAction(NativeLibLoader$LoaderAction nativeLibLoader$LoaderAction) {
        loaderAction = nativeLibLoader$LoaderAction;
    }

    private static synchronized void loadLibrary(String string, String[] stringArray, boolean bl, boolean bl2) {
        if (loaderAction != null && !loaded.contains(string)) {
            loaderAction.loadLibrary(string, stringArray, bl, bl2);
            loaded.add(string);
        }
    }

    public static void loadCore() {
        AccessController.doPrivileged(new NativeLibLoader$1());
    }

    public static void loadCgImpl() {
        AccessController.doPrivileged(new NativeLibLoader$2());
    }

    private static void loadLibraryInternal(String string) {
        if (usingJNLPAppletLauncher && !string.equals("jawt")) {
            try {
                if (jnlpLoadLibraryMethod == null) {
                    Class clazz = Class.forName("org.jdesktop.applet.util.JNLPAppletLauncher");
                    jnlpLoadLibraryMethod = clazz.getDeclaredMethod("loadLibrary", new Class[]{class$java$lang$String == null ? (class$java$lang$String = NativeLibLoader.class$("java.lang.String")) : class$java$lang$String});
                }
                jnlpLoadLibraryMethod.invoke(null, new Object[]{string});
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

    static /* synthetic */ void access$000(String string) {
        NativeLibLoader.loadLibraryInternal(string);
    }

    static /* synthetic */ void access$200(String string, String[] stringArray, boolean bl, boolean bl2) {
        NativeLibLoader.loadLibrary(string, stringArray, bl, bl2);
    }

    static /* synthetic */ boolean access$302(boolean bl) {
        usingJNLPAppletLauncher = bl;
        return usingJNLPAppletLauncher;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        AccessController.doPrivileged(new NativeLibLoader$3());
    }
}

