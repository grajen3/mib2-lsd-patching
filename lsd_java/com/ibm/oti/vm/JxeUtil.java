/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.JxeOutputStream;
import java.io.InputStream;

public final class JxeUtil {
    static {
        try {
            System.loadLibrary(new StringBuffer("iverel").append(System.getProperty("com.ibm.oti.vm.library.version", "23")).toString());
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            try {
                System.loadLibrary(new StringBuffer("j9vmall").append(System.getProperty("com.ibm.oti.vm.library.version", "23")).toString());
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {}
        }
    }

    private static native long nativeGetRomImagePointerFromJxePointer(long l) {
    }

    private static native String nativeGetRelocationMessage(int n) {
    }

    static String getRelocationMessage(int n) {
        return JxeUtil.nativeGetRelocationMessage(n);
    }

    public static byte[] getRomClass(Jxe jxe, String string) {
        byte[] byArray = new byte[40];
        if (jxe.romSegmentPointer == 0L) {
            return null;
        }
        if (!JxeUtil.nativeGetRomClassCookie(jxe.romSegmentPointer, jxe.getJxePointer(), string, byArray)) {
            return null;
        }
        return byArray;
    }

    private static native boolean nativeGetRomClassCookie(long l, long l2, String string, byte[] byArray) {
    }

    private static native long nativeRomImageLoad(long l, ClassLoader classLoader, long l2, long l3) {
    }

    public static void romImageLoad(Jxe jxe, ClassLoader classLoader) {
        if (jxe.romSegmentPointer != 0L) {
            throw new JxeException(Msg.getString("K0228"));
        }
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            throw new JxeException(Msg.getString("K01a1"));
        }
        long l2 = JxeUtil.nativeRomImageLoad(l, classLoader, jxe.getJxePointer(), jxe.getJxeAlloc());
        if (0L == l2) {
            throw new JxeException(Msg.getString("K01a2"));
        }
        jxe.romSegmentPointer = l2;
    }

    private static native int nativeRelocateJxeInPlace(long l) {
    }

    static void relocateJxeInPlace(long l) {
        int n = JxeUtil.nativeRelocateJxeInPlace(l);
        if (n != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n);
        }
    }

    private static native int nativeRelocateJxeStreaming(InputStream inputStream, JxeOutputStream jxeOutputStream, int n, int n2, long l) {
    }

    public static void relocateJxeStreaming(InputStream inputStream, JxeOutputStream jxeOutputStream, int n, int n2, long l) {
        int n3 = JxeUtil.nativeRelocateJxeStreaming(inputStream, jxeOutputStream, n, n2, l);
        if (n3 != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n3);
        }
    }

    private static native String nativeGetEnvironmentVariable(String string) {
    }

    public static String getEnvironmentVariable(String string) {
        return JxeUtil.nativeGetEnvironmentVariable(string);
    }

    private static native int nativeVerifyJxe(long l) {
    }

    public static void verifyJxe(long l) {
        int n = JxeUtil.nativeVerifyJxe(l);
        if (n != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n);
        }
    }

    private static native int nativeGetCurrentRomImageVersion() {
    }

    public static long getCurrentRomImageVersion() {
        return JxeUtil.nativeGetCurrentRomImageVersion();
    }

    private static native int nativeGetLowestRomImageVersion() {
    }

    public static long getLowestRomImageVersion() {
        return JxeUtil.nativeGetLowestRomImageVersion();
    }

    public static native String[] nativeGetClassList(byte[] byArray) {
    }

    public static String[] getClassList(String string) {
        byte[] byArray = Util.getBytes(string);
        return JxeUtil.nativeGetClassList(byArray);
    }

    static boolean registerJxe(Jxe jxe) {
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            return false;
        }
        JxeUtil.nativeRegisterJxe(l, jxe.getJxePointer(), jxe.getJxeAlloc());
        return true;
    }

    static native void nativeRegisterJxe(long l, long l2, long l3) {
    }

    static boolean unregisterJxe(Jxe jxe) {
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            return false;
        }
        JxeUtil.nativeUnregisterJxe(l);
        return true;
    }

    static native void nativeUnregisterJxe(long l) {
    }
}

