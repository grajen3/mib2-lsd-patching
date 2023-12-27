/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.DynamicLinker;

public class UnixDynamicLinkerImpl
implements DynamicLinker {
    public static final int RTLD_LAZY;
    public static final int RTLD_NOW;
    public static final int RTLD_NOLOAD;
    public static final int RTLD_GLOBAL;
    public static final int RTLD_LOCAL;
    public static final int RTLD_PARENT;
    public static final int RTLD_GROUP;
    public static final int RTLD_WORLD;
    public static final int RTLD_NODELETE;
    public static final int RTLD_FIRST;

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
        return UnixDynamicLinkerImpl.dlopen(string, 257);
    }

    @Override
    public long lookupSymbol(long l, String string) {
        return UnixDynamicLinkerImpl.dlsym(l, string);
    }

    @Override
    public void closeLibrary(long l) {
        UnixDynamicLinkerImpl.dlclose(l);
    }
}

