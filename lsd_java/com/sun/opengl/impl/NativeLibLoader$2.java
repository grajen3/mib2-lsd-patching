/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.NativeLibLoader;
import java.security.PrivilegedAction;

final class NativeLibLoader$2
implements PrivilegedAction {
    NativeLibLoader$2() {
    }

    @Override
    public Object run() {
        String[] stringArray = new String[]{"cg", "cgGL"};
        NativeLibLoader.access$200("jogl_cg", stringArray, true, true);
        return null;
    }
}

