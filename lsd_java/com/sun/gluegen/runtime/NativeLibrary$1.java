/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.NativeLibrary;
import java.security.PrivilegedAction;

final class NativeLibrary$1
implements PrivilegedAction {
    NativeLibrary$1() {
    }

    @Override
    public Object run() {
        String string = System.getProperty("os.name").toLowerCase();
        if (string.startsWith("wind")) {
            NativeLibrary.access$002(1);
        } else if (string.startsWith("mac os x")) {
            NativeLibrary.access$002(3);
        } else {
            NativeLibrary.access$002(2);
        }
        NativeLibrary.access$102(System.getProperty("gluegen.debug.NativeLibrary") != null);
        return null;
    }
}

