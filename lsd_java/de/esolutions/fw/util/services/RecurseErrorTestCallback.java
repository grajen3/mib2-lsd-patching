/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services;

import de.esolutions.fw.util.commons.os.OSCalls;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceChannel;

public class RecurseErrorTestCallback
implements ITraceCallback,
Runnable {
    TraceChannel tc = new TraceChannel("fw.util.test");
    boolean use_native;

    private long sum(long l) {
        long l2 = l == 0L ? 0L : l + this.sum(l - 1L);
        return l2;
    }

    @Override
    public void run() {
        System.out.println("---------- RECURSE ERROR TEST STARTED ----------");
        OSCalls oSCalls = null;
        if (this.use_native && !(oSCalls = new OSCalls()).hasSum()) {
            oSCalls = null;
        }
        int n = 1;
        while ((long)n < 0) {
            long l = System.currentTimeMillis();
            long l2 = oSCalls != null ? oSCalls.sum(n) : this.sum(n);
            long l3 = System.currentTimeMillis();
            System.out.println(new StringBuffer().append("sum: s(").append(n).append(")=").append(l2).append(", delta=").append(l3 - l).toString());
            n *= 2;
        }
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        this.tc.log((short)4, "Trigger endless recursion to test VM!");
        Thread thread = new Thread(this, "RecurseEndless");
        if (byArray != null) {
            try {
                String string = new String(byArray, "UTF-8");
                if (string.equals("max")) {
                    thread.setPriority(10);
                    System.out.println("---------- RECURSE ERROR MAX PRIO ----------");
                }
                if (string.equals("native")) {
                    this.use_native = true;
                    System.out.println("---------- RECURSE NATIVE ----------");
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        thread.start();
    }
}

