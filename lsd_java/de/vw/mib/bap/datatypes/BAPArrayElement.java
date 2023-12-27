/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPArrayElement
extends BAPEntity {
    default public int getPos() {
    }

    default public void setPos(int n) {
    }

    default public void setArrayHeader(ArrayHeader arrayHeader) {
    }

    default public ArrayHeader getArrayHeader() {
    }
}

