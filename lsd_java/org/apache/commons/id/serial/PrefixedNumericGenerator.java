/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import org.apache.commons.id.serial.NumericGenerator;

public class PrefixedNumericGenerator
extends NumericGenerator {
    private final String prefix;

    public PrefixedNumericGenerator(String string, boolean bl, long l) {
        super(bl, l);
        if (string == null) {
            throw new NullPointerException("prefix must not be null");
        }
        this.prefix = string;
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public long maxLength() {
        return super.maxLength() + (long)this.prefix.length();
    }

    @Override
    public long minLength() {
        return super.minLength() + (long)this.prefix.length();
    }

    @Override
    public String nextStringIdentifier() {
        StringBuffer stringBuffer = new StringBuffer(this.prefix);
        stringBuffer.append(super.nextStringIdentifier());
        return stringBuffer.toString();
    }
}

