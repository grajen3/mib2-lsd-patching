/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.jvm;

public class Dump {
    public static void JavaDump() {
        Dump.JavaDumpImpl();
    }

    public static void HeapDump() {
        Dump.HeapDumpImpl();
    }

    public static void SystemDump() {
        Dump.SystemDumpImpl();
    }

    private Dump() {
    }

    private static native void JavaDumpImpl() {
    }

    private static native void HeapDumpImpl() {
    }

    private static native void SystemDumpImpl() {
    }
}

