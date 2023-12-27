/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.util;

import java.util.zip.CRC32;

final class CrcCalculator$1
extends CRC32 {
    CrcCalculator$1() {
    }

    @Override
    public long getValue() {
        return (int)super.getValue();
    }
}

