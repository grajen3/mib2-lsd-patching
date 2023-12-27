/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import java.security.PrivilegedAction;

final class Debug$1
implements PrivilegedAction {
    private final /* synthetic */ String val$property;

    Debug$1(String string) {
        this.val$property = string;
    }

    @Override
    public Object run() {
        boolean bl = Boolean.getBoolean(this.val$property);
        return bl ? Boolean.TRUE : Boolean.FALSE;
    }
}

