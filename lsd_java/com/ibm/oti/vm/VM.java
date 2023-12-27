/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection;
import com.ibm.oti.util.DeleteOnExit;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.Jxe;
import com.microdoc.j9.Tools;
import java.io.IOException;
import java.util.Vector;

public final class VM {
    private static Vector shutdownHooks = new Vector();
    private static boolean shutdown = false;
    private static final RuntimePermission shutdownHooksPermission = new RuntimePermission("shutdownHooks");
    private static boolean closeJars = false;
    private static boolean deleteOnExit = false;
    private static Vector shutdownClasses = new Vector(4);
    static final int CPE_TYPE_UNKNOWN;
    static final int CPE_TYPE_DIRECTORY;
    static final int CPE_TYPE_JAR;
    static final int CPE_TYPE_TCP;
    static final int CPE_TYPE_JXE;
    static final int CPE_TYPE_UNUSABLE;
    static final int CPE_TYPE_PALMDB;
    static final int CPE_TYPE_ODC;
    static final int CPE_TYPE_JXESL;

    private VM() {
    }

    static final native Class getStackClass(int n) {
    }

    static final native ClassLoader getStackClassLoader(int n) {
    }

    public static final native ClassLoader getNonBootstrapClassLoader() {
    }

    public static final native void initializeClassLoader(ClassLoader classLoader, boolean bl) {
    }

    private static final native boolean isBootstrapClassLoader(ClassLoader classLoader) {
    }

    static native Class findClassOrNull(String string, ClassLoader classLoader) {
    }

    public static ClassLoader callerClassLoader() {
        ClassLoader classLoader = VM.getStackClassLoader(2);
        ClassLoader classLoader2 = VM.getStackClassLoader(1);
        if (!VM.isBootstrapClassLoader(classLoader2)) {
            throw new SecurityException();
        }
        if (VM.isBootstrapClassLoader(classLoader)) {
            return null;
        }
        return classLoader;
    }

    private static ClassLoader caller2ClassLoader() {
        ClassLoader classLoader = VM.getStackClassLoader(3);
        if (VM.isBootstrapClassLoader(classLoader)) {
            return null;
        }
        return classLoader;
    }

    public static native void dumpString(String string) {
    }

    public static void setClassPathImpl(ClassLoader classLoader, String string) {
        VM.setClassPathImpl(classLoader, Util.getBytes(string));
    }

    private static native void setClassPathImpl(ClassLoader classLoader, byte[] byArray) {
    }

    public static void enableClassHotSwap(Class clazz) {
    }

    static native void setPDImpl(Class clazz, Object object) {
    }

    static native int getCPIndexImpl(Class clazz) {
    }

    static void initializeVM() {
        Tools.init();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void addShutdownHook(Thread thread) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(shutdownHooksPermission);
        }
        Vector vector = shutdownHooks;
        synchronized (vector) {
            if (shutdown) {
                throw new IllegalStateException(Msg.getString("K01a4"));
            }
            if (thread == null || shutdownHooks.contains(thread)) {
                throw new IllegalArgumentException(Msg.getString("K01a5", thread));
            }
            shutdownHooks.addElement(thread);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean removeShutdownHook(Thread thread) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(shutdownHooksPermission);
        }
        Vector vector = shutdownHooks;
        synchronized (vector) {
            if (shutdown) {
                throw new IllegalStateException(Msg.getString("K01a4"));
            }
            return shutdownHooks.removeElement(thread);
        }
    }

    public static void closeJars() {
        closeJars = true;
    }

    public static void deleteOnExit() {
        deleteOnExit = true;
    }

    public static void addShutdownClass(Runnable runnable) {
        shutdownClasses.addElement(runnable);
    }

    private static void shutdown() {
        int n = shutdownClasses.size() - 1;
        while (n >= 0) {
            ((Runnable)shutdownClasses.elementAt(n)).run();
            --n;
        }
        if (closeJars) {
            JarURLConnection.closeCachedFiles();
        }
        if (deleteOnExit) {
            DeleteOnExit.deleteOnExit();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void cleanup() {
        Vector vector = shutdownHooks;
        synchronized (vector) {
            if (shutdown) {
                return;
            }
            shutdown = true;
        }
        int n = 0;
        while (n < shutdownHooks.size()) {
            ((Thread)shutdownHooks.elementAt(n)).start();
            ++n;
        }
        n = 0;
        while (n < shutdownHooks.size()) {
            Thread thread = (Thread)shutdownHooks.elementAt(n);
            while (true) {
                try {
                    thread.join();
                }
                catch (InterruptedException interruptedException) {
                    continue;
                }
                break;
            }
            ++n;
        }
    }

    static final native int getClassPathEntryType(Object object, int n) {
    }

    static final native long getJxePointerFromClassPath(Object object, int n) {
    }

    static Jxe getJxeFromClassPath(Object object, int n) {
        long l = VM.getJxePointerFromClassPath(object, n);
        if (l == 0L) {
            return null;
        }
        Jxe jxe = new Jxe(l, false);
        return jxe;
    }

    public static native String[] getVMArgs() {
    }

    static native int getClassPathCount() {
    }

    static native byte[] getPathFromClassPath(int n) {
    }

    public static synchronized void loadLibrary(String string) {
        try {
            Runtime.getRuntime().loadLibrary(string);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            throw new IOException(unsatisfiedLinkError.getMessage());
        }
    }

    public static native void localGC() {
    }

    public static native void globalGC() {
    }

    public static native void runFinalization() {
    }

    public static void disableFinalization(Class clazz) {
        if (VM.callerClassLoader() != null) {
            throw new SecurityException();
        }
        VM.disableFinalizationImpl(clazz);
    }

    private static final native void disableFinalizationImpl(Class clazz) {
    }

    public static final boolean useNatives() {
        return VM.useNativesImpl();
    }

    private static final native boolean useNativesImpl() {
    }

    public static int availableProcessors() {
        return VM.processorsImpl();
    }

    private static native int processorsImpl() {
    }

    public static native boolean enableJIT() {
    }

    public static void enableFinalization(Class clazz) {
    }

    public static String[] getHttpProxyParms() {
        return VM.getHttpProxyImpl();
    }

    private static native String[] getHttpProxyImpl() {
    }
}

