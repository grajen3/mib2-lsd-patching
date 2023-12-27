/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  sun.misc.Perf
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.NanoTimer;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils$2;
import java.security.AccessController;
import sun.misc.Perf;

final class Utils$SunPerfProvider
implements NanoTimer {
    final Perf perf = (Perf)AccessController.doPrivileged(new Utils$2(this));
    final long multiplier;
    final long divisor;

    Utils$SunPerfProvider() {
        int n = 0;
        long l = this.perf.highResFrequency();
        long l2 = Utils.access$000(n, l);
        this.multiplier = n / l2;
        this.divisor = l / l2;
    }

    @Override
    public long nanoTime() {
        long l = this.perf.highResCounter();
        return l / this.divisor * this.multiplier + l % this.divisor * this.multiplier / this.divisor;
    }
}

