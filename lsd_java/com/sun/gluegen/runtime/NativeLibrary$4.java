/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import com.sun.gluegen.runtime.NativeLibrary;
import java.security.PrivilegedAction;

final class NativeLibrary$4
implements PrivilegedAction {
    NativeLibrary$4() {
    }

    @Override
    public Object run() {
        try {
            NativeLibrary.access$202((NativeLibrary.class$java$lang$ClassLoader == null ? (NativeLibrary.class$java$lang$ClassLoader = NativeLibrary.class$("java.lang.ClassLoader")) : NativeLibrary.class$java$lang$ClassLoader).getDeclaredMethod("findLibrary", new Class[]{NativeLibrary.class$java$lang$String == null ? (NativeLibrary.class$java$lang$String = NativeLibrary.class$("java.lang.String")) : NativeLibrary.class$java$lang$String}));
            NativeLibrary.access$200().setAccessible(true);
        }
        catch (Exception exception) {
            // empty catch block
        }
        NativeLibrary.access$302(true);
        return null;
    }
}

