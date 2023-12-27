/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.serial;

import org.apache.commons.id.AbstractStringIdentifierGenerator;

public class PrefixedLeftPaddedNumericGenerator
extends AbstractStringIdentifierGenerator {
    private final String prefix;
    private boolean wrap = true;
    private char[] count = null;
    private static final char NINE_CHAR;

    public PrefixedLeftPaddedNumericGenerator(String string, boolean bl, int n) {
        if (string == null) {
            throw new NullPointerException("prefix must not be null");
        }
        if (n < 1) {
            throw new IllegalArgumentException("size must be at least one");
        }
        if (n <= string.length()) {
            throw new IllegalArgumentException("size less prefix length must be at least one");
        }
        this.wrap = bl;
        this.prefix = string;
        int n2 = n - string.length();
        this.count = new char[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            this.count[i2] = 48;
        }
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public long maxLength() {
        return this.count.length + this.prefix.length();
    }

    @Override
    public long minLength() {
        return this.count.length + this.prefix.length();
    }

    public int getSize() {
        return this.count.length + this.prefix.length();
    }

    public boolean isWrap() {
        return this.wrap;
    }

    public void setWrap(boolean bl) {
        this.wrap = bl;
    }

    @Override
    public String nextStringIdentifier() {
        block3: for (int i2 = this.count.length - 1; i2 >= 0; --i2) {
            switch (this.count[i2]) {
                case '9': {
                    this.count[i2] = 48;
                    if (i2 != 0 || this.wrap) continue block3;
                    throw new IllegalStateException("The maximum number of identifiers has been reached");
                }
                default: {
                    int n = i2;
                    this.count[n] = (char)(this.count[n] + '\u0001');
                    i2 = -1;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(this.prefix);
        stringBuffer.append(this.count);
        return stringBuffer.toString();
    }
}

