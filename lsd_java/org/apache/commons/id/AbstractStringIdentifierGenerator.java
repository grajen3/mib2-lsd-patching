/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.StringIdentifierGenerator;

public abstract class AbstractStringIdentifierGenerator
implements StringIdentifierGenerator {
    protected static final int MAX_LONG_NUMERIC_VALUE_LENGTH = Long.toString(Long.MIN_VALUE).length();
    protected static final int ALPHA_NUMERIC_CHARSET_SIZE;
    protected static final int MAX_LONG_ALPHANUMERIC_VALUE_LENGTH;
    protected static final int MAX_INT_NUMERIC_VALUE_LENGTH;
    protected static final int MAX_INT_ALPHANUMERIC_VALUE_LENGTH;
    protected static final int DEFAULT_ALPHANUMERIC_IDENTIFIER_SIZE;

    protected AbstractStringIdentifierGenerator() {
    }

    @Override
    public abstract String nextStringIdentifier() {
    }

    @Override
    public long maxLength() {
        return -1L;
    }

    @Override
    public long minLength() {
        return 0L;
    }

    @Override
    public Object nextIdentifier() {
        return this.nextStringIdentifier();
    }

    static {
        MAX_LONG_ALPHANUMERIC_VALUE_LENGTH = Long.toString(Long.MAX_VALUE, 36).length();
        MAX_INT_NUMERIC_VALUE_LENGTH = Integer.toString(128).length();
        MAX_INT_ALPHANUMERIC_VALUE_LENGTH = Integer.toString(-129, 36).length();
    }
}

