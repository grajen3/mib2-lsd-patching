/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection$LRUKey;
import java.util.Comparator;

final class JarURLConnection$LRUComparitor
implements Comparator {
    JarURLConnection$LRUComparitor() {
    }

    @Override
    public int compare(Object object, Object object2) {
        if (((JarURLConnection$LRUKey)object).ts > ((JarURLConnection$LRUKey)object2).ts) {
            return 1;
        }
        return ((JarURLConnection$LRUKey)object).ts == ((JarURLConnection$LRUKey)object2).ts ? 0 : -1;
    }

    public boolean equals(Object object, Object object2) {
        return object.equals(object2);
    }
}

