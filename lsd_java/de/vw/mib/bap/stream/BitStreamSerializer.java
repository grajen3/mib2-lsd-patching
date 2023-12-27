/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

import de.vw.mib.bap.stream.BitStream;

public interface BitStreamSerializer {
    default public void serialize(BitStream bitStream) {
    }

    default public void deserialize(BitStream bitStream) {
    }

    default public int bitSize() {
    }
}

