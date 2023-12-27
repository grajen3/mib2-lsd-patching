/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.helper.trace;

import de.vw.mib.asl.internal.testmode.TestmodeServiceManagerImpl;

public final class TraceHelper {
    private static boolean mTcpState = true;
    private static boolean mFileState = false;
    private static boolean mSerialState = false;

    private TraceHelper() {
    }

    public static boolean isLoggingEnabled() {
        return true;
    }

    public static void setLoggingEnabled(boolean bl) {
    }

    public static int[] getClassifierIds() {
        return TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().getClassifierIds();
    }

    public static String[] getClassifierNames() {
        return TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().getClassifierNames();
    }

    public static String[] getSubClassifierNames(int n) {
        return TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().getSubClassifierNames(n);
    }

    public static int getSubClassifierMask(int n) {
        return TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().getTraceSubClassifierMask(n);
    }

    public static void setSubClassifierMask(int n, int n2) {
        TestmodeServiceManagerImpl.INSTANCE.getLogManagerDiag().setTraceSubClassifierMask(n, n2);
    }

    public static boolean getTcpSinkState() {
        return mTcpState;
    }

    public static void setTcpSinkState(boolean bl) {
        mTcpState = bl;
    }

    public static boolean getFileSinkState() {
        return mFileState;
    }

    public static void setFileSinkState(boolean bl) {
        mFileState = bl;
    }

    public static boolean getSerialSinkState() {
        return mSerialState;
    }

    public static void setSerialSinkState(boolean bl) {
        mSerialState = bl;
    }
}

