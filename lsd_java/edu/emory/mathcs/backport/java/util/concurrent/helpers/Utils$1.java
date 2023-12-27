/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import java.security.PrivilegedAction;

class Utils$1
implements PrivilegedAction {
    Utils$1() {
    }

    @Override
    public Object run() {
        return System.getProperty("edu.emory.mathcs.backport.java.util.concurrent.NanoTimerProvider");
    }
}

