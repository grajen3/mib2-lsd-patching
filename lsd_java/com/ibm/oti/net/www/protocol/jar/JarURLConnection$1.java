/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import java.security.PrivilegedAction;

final class JarURLConnection$1
implements PrivilegedAction {
    JarURLConnection$1() {
    }

    @Override
    public Object run() {
        return Integer.getInteger("jar.cacheSize", 500);
    }
}

