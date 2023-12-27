/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  sun.misc.Perf
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils$SunPerfProvider;
import java.security.PrivilegedAction;
import sun.misc.Perf;

class Utils$2
implements PrivilegedAction {
    private final /* synthetic */ Utils$SunPerfProvider this$0;

    Utils$2(Utils$SunPerfProvider utils$SunPerfProvider) {
        this.this$0 = utils$SunPerfProvider;
    }

    @Override
    public Object run() {
        return Perf.getPerf();
    }
}

