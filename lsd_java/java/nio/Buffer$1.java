/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.security.PrivilegedAction;

final class Buffer$1
implements PrivilegedAction {
    Buffer$1() {
    }

    @Override
    public Object run() {
        System.loadLibrary("nio");
        return null;
    }
}

