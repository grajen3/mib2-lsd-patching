/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.AbstractStringIdentifierGenerator;
import org.apache.commons.id.StringIdentifierGenerator;

public class ConstantIdentifierGenerator
extends AbstractStringIdentifierGenerator {
    private final String identifier;

    public static StringIdentifierGenerator getInstance(String string) {
        return new ConstantIdentifierGenerator(string);
    }

    public ConstantIdentifierGenerator() {
        this.identifier = "";
    }

    public ConstantIdentifierGenerator(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Constant identifier value must not be null");
        }
        this.identifier = string;
    }

    @Override
    public String nextStringIdentifier() {
        return this.identifier;
    }

    @Override
    public long maxLength() {
        if (this.identifier == null) {
            return 0L;
        }
        return this.identifier.length();
    }

    @Override
    public long minLength() {
        return this.maxLength();
    }
}

