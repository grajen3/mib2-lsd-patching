/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import java.io.Serializable;
import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class NumericGenerator
extends AbstractStringIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID;
    private boolean wrapping;
    private long count = 0L;

    public NumericGenerator(boolean bl, long l) {
        this.wrapping = bl;
        this.count = l;
    }

    @Override
    public long maxLength() {
        return AbstractStringIdentifierGenerator.MAX_LONG_NUMERIC_VALUE_LENGTH;
    }

    @Override
    public long minLength() {
        return 1L;
    }

    public boolean isWrap() {
        return this.wrapping;
    }

    public void setWrap(boolean bl) {
        this.wrapping = bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String nextStringIdentifier() {
        long l = 0L;
        if (this.wrapping) {
            NumericGenerator numericGenerator = this;
            synchronized (numericGenerator) {
                l = this.count++;
            }
        }
        NumericGenerator numericGenerator = this;
        synchronized (numericGenerator) {
            if (this.count == Long.MAX_VALUE) {
                throw new IllegalStateException("The maximum number of identifiers has been reached");
            }
            l = this.count++;
        }
        return Long.toString(l);
    }
}

