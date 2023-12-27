/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.LongIdentifierGenerator;

public abstract class AbstractLongIdentifierGenerator
implements LongIdentifierGenerator {
    protected AbstractLongIdentifierGenerator() {
    }

    @Override
    public long maxValue() {
        return Long.MAX_VALUE;
    }

    @Override
    public long minValue() {
        return Long.MIN_VALUE;
    }

    @Override
    public Object nextIdentifier() {
        return this.nextLongIdentifier();
    }

    @Override
    public abstract Long nextLongIdentifier() {
    }
}

