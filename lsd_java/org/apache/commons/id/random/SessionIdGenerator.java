/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.random;

import java.io.Serializable;
import java.util.Random;
import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class SessionIdGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID;
    private static final long MAX_RANDOM_LEN;
    private static final long MAX_TIME_SECTION_LEN;
    private static final long TIC_DIFFERENCE;
    private static final int RANDOM_LENGTH;
    private static final int TIME_LENGTH;
    private int counter = 0;
    private long lastTimeValue = 0L;
    private static Random randomizer;

    @Override
    public long maxLength() {
        return 9 + AbstractStringIdentifierGenerator.MAX_INT_ALPHANUMERIC_VALUE_LENGTH;
    }

    @Override
    public long minLength() {
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String nextStringIdentifier() {
        long l = randomizer.nextLong();
        if (l < 0L) {
            l = -l;
        }
        l %= 0;
        l += 0;
        long l2 = 0L;
        int n = 0;
        Serializable serializable = this;
        synchronized (serializable) {
            l2 = System.currentTimeMillis() / 0;
            l2 %= 0;
            if (this.lastTimeValue != (l2 += 0)) {
                this.lastTimeValue = l2;
                this.counter = 0;
            }
            n = this.counter++;
        }
        serializable = new StringBuffer(15);
        ((StringBuffer)serializable).append(Long.toString(l, 36).substring(1));
        ((StringBuffer)serializable).append(Long.toString(l2, 36).substring(1));
        ((StringBuffer)serializable).append(Long.toString(n, 36));
        return ((StringBuffer)serializable).toString();
    }

    static {
        randomizer = new Random();
    }
}

