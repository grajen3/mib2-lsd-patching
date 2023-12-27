/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.requests;

import de.vw.mib.bap.datatypes.BAPArray;

public interface GetArray
extends BAPArray {
    default public int getAsgId() {
    }

    default public void setAsgId(int n) {
    }

    default public int getTransactionId() {
    }

    default public void setTransactionId(int n) {
    }
}

