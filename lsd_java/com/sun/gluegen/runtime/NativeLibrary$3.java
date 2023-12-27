/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import java.security.PrivilegedAction;

final class NativeLibrary$3
implements PrivilegedAction {
    NativeLibrary$3() {
    }

    @Override
    public Object run() {
        return System.getProperty("user.dir");
    }
}

