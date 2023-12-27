/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import org.apache.commons.id.serial.AlphanumericGenerator;

public class PrefixedAlphanumericGenerator
extends AlphanumericGenerator {
    private final String prefix;

    public PrefixedAlphanumericGenerator(String string, boolean bl, int n) {
        super(bl, n - (string == null ? 0 : string.length()));
        if (string == null) {
            throw new NullPointerException("prefix must not be null");
        }
        if (n <= string.length()) {
            throw new IllegalArgumentException("size less prefix length must be at least one");
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
    public int getSize() {
        return super.getSize() + this.prefix.length();
    }

    @Override
    public String nextStringIdentifier() {
        StringBuffer stringBuffer = new StringBuffer(this.prefix);
        stringBuffer.append(super.nextStringIdentifier());
        return stringBuffer.toString();
    }
}

