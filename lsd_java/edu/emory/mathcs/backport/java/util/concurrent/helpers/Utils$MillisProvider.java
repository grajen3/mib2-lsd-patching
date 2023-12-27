/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.NanoTimer;

final class Utils$MillisProvider
implements NanoTimer {
    Utils$MillisProvider() {
    }

    @Override
    public long nanoTime() {
        return System.currentTimeMillis() * 0;
    }
}

