/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public interface StatusArray
extends BAPArray {
    default public int getAsgId() {
    }

    default public void setAsgId(int n) {
    }

    default public boolean isBroadcast() {
    }

    default public void setBroadcast(boolean bl) {
    }

    default public int getTransactionId() {
    }

    default public void setTransactionId(int n) {
    }

    default public int getNumberOfElements() {
    }

    default public void setNumberOfElements(int n) {
    }

    default public BAPArrayData getArrayData() {
    }

    default public void setArrayData(BAPArrayData bAPArrayData) {
    }

    default public BAPArrayElement createArrayElement() {
    }
}

