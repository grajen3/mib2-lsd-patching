/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.NativeLibLoader;
import java.security.PrivilegedAction;

final class NativeLibLoader$3
implements PrivilegedAction {
    NativeLibLoader$3() {
    }

    @Override
    public Object run() {
        String string = System.getProperty("sun.jnlp.applet.launcher");
        NativeLibLoader.access$302(Boolean.valueOf(string));
        return null;
    }
}

