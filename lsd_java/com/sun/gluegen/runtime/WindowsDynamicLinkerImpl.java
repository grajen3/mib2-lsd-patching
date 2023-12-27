/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.DynamicLinker;

public class WindowsDynamicLinkerImpl
implements DynamicLinker {
    private static native int FreeLibrary(long l) {
    }

    private static native int GetLastError() {
    }

    private static native long GetProcAddress(long l, String string) {
    }

    private static native long LoadLibraryA(String string) {
    }

    @Override
    public long openLibrary(String string) {
        return WindowsDynamicLinkerImpl.LoadLibraryA(string);
    }

    @Override
    public long lookupSymbol(long l, String string) {
        return WindowsDynamicLinkerImpl.GetProcAddress(l, string);
    }

    @Override
    public void closeLibrary(long l) {
        WindowsDynamicLinkerImpl.FreeLibrary(l);
    }
}

