/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.bench;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public class TraceRateBenchmark {
    private static final TraceChannel benchChannel = TraceClient.createTraceChannel("Bench_Channel", (short)7);

    public static void main(String[] stringArray) {
        TraceClient.init("dummy", "client", false);
        int n = 100;
        int n2 = 5000;
        int n3 = 100;
        long l = 0L;
        int n4 = stringArray.length;
        if (n4 > 0) {
            n = Integer.parseInt(stringArray[0]);
        }
        if (n4 > 1) {
            n2 = Integer.parseInt(stringArray[1]);
        }
        if (n4 > 2) {
            n3 = Integer.parseInt(stringArray[2]);
        }
        if (n4 > 3) {
            l = Long.parseLong(stringArray[3]) * 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < n3; ++i2) {
            stringBuffer.append("0123456789");
        }
        String string = stringBuffer.toString();
        int n5 = 1000 * (n3 *= 10) / (n *= 1024);
        System.out.println(new StringBuffer().append("rate=").append(n).append(" messages=").append(n2).append(" msg_len=").append(n3).toString());
        System.out.println(new StringBuffer().append("pkt_delay=").append(n5).toString());
        System.out.println(new StringBuffer().append("starting in ").append(l).append("ms").toString());
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        for (int i3 = 0; i3 < n2; ++i3) {
            long l2 = System.currentTimeMillis();
            benchChannel.log((short)3, string);
            long l3 = System.currentTimeMillis();
            long l4 = l3 - l2;
            if (l4 >= (long)n5) continue;
            try {
                Thread.sleep((long)n5 - l4);
                continue;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        System.out.println("end");
        TraceClient.exit();
    }
}

