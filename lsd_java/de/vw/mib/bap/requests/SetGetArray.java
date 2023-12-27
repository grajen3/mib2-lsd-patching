/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.requests.GetArray;

public interface SetGetArray
extends GetArray {
    default public BAPArrayData getArrayData() {
    }

    default public void setArrayData(BAPArrayData bAPArrayData) {
    }

    default public BAPArrayElement createArrayElement() {
    }
}

