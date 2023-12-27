/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import java.security.PrivilegedAction;

final class Debug$2
implements PrivilegedAction {
    private final /* synthetic */ String val$property;

    Debug$2(String string) {
        this.val$property = string;
    }

    @Override
    public Object run() {
        String string = System.getProperty(this.val$property);
        return string != null ? Boolean.TRUE : Boolean.FALSE;
    }
}

