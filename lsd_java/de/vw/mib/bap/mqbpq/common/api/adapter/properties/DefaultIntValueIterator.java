/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.adapter.properties;

import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;

public final class DefaultIntValueIterator
extends IntegerIterator {
    private final int defaultValue;

    public DefaultIntValueIterator(int n) {
        this.defaultValue = n;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int nextInteger() {
        return this.defaultValue;
    }
}

