/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import java.util.jar.JarFile;

final class JarURLConnection$LRUKey {
    JarFile jar;
    long ts;

    JarURLConnection$LRUKey(JarFile jarFile, long l) {
        this.jar = jarFile;
        this.ts = l;
    }

    public boolean equals(Object object) {
        return this.jar == ((JarURLConnection$LRUKey)object).jar;
    }
}

