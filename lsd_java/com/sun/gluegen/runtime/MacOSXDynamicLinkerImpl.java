/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.DynamicLinker;

public class MacOSXDynamicLinkerImpl
implements DynamicLinker {
    public static final int RTLD_LAZY;
    public static final int RTLD_NOW;
    public static final int RTLD_LOCAL;
    public static final int RTLD_GLOBAL;

    private static native int dlclose(long l) {
    }

    private static native String dlerror() {
    }

    private static native long dlopen(String string, int n) {
    }

    private static native long dlsym(long l, String string) {
    }

    @Override
    public long openLibrary(String string) {
        return MacOSXDynamicLinkerImpl.dlopen(string, 9);
    }

    @Override
    public long lookupSymbol(long l, String string) {
        return MacOSXDynamicLinkerImpl.dlsym(l, string);
    }

    @Override
    public void closeLibrary(long l) {
        MacOSXDynamicLinkerImpl.dlclose(l);
    }
}

