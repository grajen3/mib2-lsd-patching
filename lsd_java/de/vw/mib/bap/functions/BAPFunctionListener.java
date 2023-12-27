/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.BAPFunction;

public interface BAPFunctionListener {
    default public void requestError(int n, BAPFunction bAPFunction) {
    }
}

