/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.IdentifierGenerator;

public interface LongIdentifierGenerator
extends IdentifierGenerator {
    default public Long nextLongIdentifier() {
    }

    default public long maxValue() {
    }

    default public long minValue() {
    }
}

