/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import java.security.PrivilegedAction;

final class NativeLibrary$2
implements PrivilegedAction {
    NativeLibrary$2() {
    }

    @Override
    public Object run() {
        return System.getProperty("java.library.path");
    }
}

