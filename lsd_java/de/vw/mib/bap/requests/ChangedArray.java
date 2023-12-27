/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface ChangedArray
extends BAPArray {
    default public void setArrayData(BAPArrayData bAPArrayData) {
    }

    default public BAPArrayData getArrayData() {
    }

    default public BAPArrayElement createArrayElement() {
    }
}

