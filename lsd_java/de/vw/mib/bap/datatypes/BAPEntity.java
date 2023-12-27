/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.stream.BitStreamSerializer;

public interface BAPEntity
extends BitStreamSerializer {
    default public void reset() {
    }

    default public boolean equalTo(BAPEntity bAPEntity) {
    }

    default public String toString() {
    }
}

