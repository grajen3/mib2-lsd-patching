/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.IdentifierGenerator;

public interface StringIdentifierGenerator
extends IdentifierGenerator {
    public static final int INFINITE_MAX_LENGTH;

    default public String nextStringIdentifier() {
    }

    default public long maxLength() {
    }

    default public long minLength() {
    }
}

