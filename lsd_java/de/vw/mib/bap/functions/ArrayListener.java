/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionListener;

public interface ArrayListener
extends BAPFunctionListener {
    default public void statusArray(BAPStatusArray bAPStatusArray, Array array) {
    }

    default public void changedArray(BAPChangedArray bAPChangedArray, Array array) {
    }
}

