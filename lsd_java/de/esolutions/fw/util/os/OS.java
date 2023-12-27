/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.os;

public class OS {
    private static OS instance;
    private static boolean libLoadingSuccessful;

    private OS() {
    }

    public static synchronized OS getInstance() {
        if (libLoadingSuccessful && instance == null) {
            instance = new OS();
        }
        return instance;
    }

    public native int kill(long l, int n) {
    }

    public native long getpid() {
    }

    public native int createKernelUserEvent(String string) {
    }

    public native int createKernelUserEvent(int n, String string) {
    }

    public native int createKernelUserEvent(int n, byte[] byArray) {
    }

    public native boolean pinThread(int n) {
    }

    public native long sum(long l) {
    }

    static {
        try {
            System.loadLibrary("jni_fw_util_os");
            libLoadingSuccessful = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            System.out.println("Native Library not found: fw_util_os");
            libLoadingSuccessful = false;
        }
    }
}

