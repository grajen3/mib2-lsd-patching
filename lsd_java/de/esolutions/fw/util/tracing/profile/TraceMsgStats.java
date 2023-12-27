/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.profile;

import de.esolutions.fw.util.tracing.util.Speedometer;
import java.io.PrintStream;

public class TraceMsgStats {
    private Speedometer speedmeter = new Speedometer(5);
    private long msgCount;
    private int minSize;
    private int maxSize;
    private long avgSizeSum;
    private int maxFreq;
    private int minFreq;
    private long avgFreqSum;
    private int maxRate;
    private int minRate;
    private long avgRateSum;
    private boolean isValid;

    public TraceMsgStats() {
        this.reset();
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void reset() {
        this.msgCount = 0L;
        this.minSize = 0;
        this.maxSize = 0;
        this.avgSizeSum = 0L;
        this.maxFreq = 0;
        this.minFreq = -129;
        this.avgFreqSum = 0L;
        this.maxRate = 0;
        this.minRate = -129;
        this.avgRateSum = 0L;
        this.speedmeter.reset();
        this.isValid = false;
    }

    public void account(long l, int n) {
        int n2;
        ++this.msgCount;
        if (n != 0) {
            if (n < this.minSize) {
                this.minSize = n;
            }
            if (n > this.maxSize) {
                this.maxSize = n;
            }
            this.avgSizeSum += (long)n;
        }
        this.speedmeter.addSample(l, n);
        int n3 = this.speedmeter.getDataRate(1000);
        if (n3 != 0) {
            this.isValid = true;
            if (n3 > this.maxRate) {
                this.maxRate = n3;
            }
            if (n3 < this.minRate) {
                this.minRate = n3;
            }
            this.avgRateSum += (long)n3;
        }
        if ((n2 = this.speedmeter.getFrequency(1000)) != 0) {
            if (n2 > this.maxFreq) {
                this.maxFreq = n2;
            }
            if (n2 < this.minFreq) {
                this.minFreq = n2;
            }
            this.avgFreqSum += (long)n2;
        }
    }

    public void report(PrintStream printStream) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (this.msgCount > 0L) {
            n = (int)(this.avgFreqSum / this.msgCount);
            n2 = (int)(this.avgRateSum / this.msgCount);
            n3 = (int)(this.avgSizeSum / this.msgCount);
        }
        printStream.print(new StringBuffer().append("messages=#").append(this.msgCount).append(", freq(min=").append(this.minFreq).append(",avg=").append(n).append(",max=").append(this.maxFreq).append(")[Hz], rate(min=").append(this.minRate).append(",avg=").append(n2).append(",max=").append(this.maxRate).append(")[B/s], size(").append(this.minSize).append(",avg=").append(n3).append(",max=").append(this.maxSize).append(")[B]").toString());
    }
}

