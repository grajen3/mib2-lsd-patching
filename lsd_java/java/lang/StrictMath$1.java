/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.security.PrivilegedAction;

final class StrictMath$1
implements PrivilegedAction {
    StrictMath$1() {
    }

    @Override
    public Object run() {
        System.loadLibrary(new StringBuffer("j9fdm").append(System.getProperty("com.ibm.oti.vm.library.version", "23")).toString());
        return null;
    }
}

