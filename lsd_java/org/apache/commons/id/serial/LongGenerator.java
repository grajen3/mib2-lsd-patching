/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import java.io.Serializable;
import org.apache.commons.id.AbstractLongIdentifierGenerator;

public class LongGenerator
extends AbstractLongIdentifierGenerator
implements Serializable {
    private static final long serialVersionUID;
    private boolean wrapping;
    private long count = 0L;

    public LongGenerator(boolean bl, long l) {
        this.wrapping = bl;
        this.count = l;
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
    public Long nextLongIdentifier() {
        long l = 0L;
        if (this.wrapping) {
            LongGenerator longGenerator = this;
            synchronized (longGenerator) {
                l = this.count++;
            }
        }
        LongGenerator longGenerator = this;
        synchronized (longGenerator) {
            if (this.count == Long.MAX_VALUE) {
                throw new IllegalStateException("The maximum number of identifiers has been reached");
            }
            l = this.count++;
        }
        return new Long(l);
    }
}

