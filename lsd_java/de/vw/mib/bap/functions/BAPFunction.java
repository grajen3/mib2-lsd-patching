/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.BAPFunctionListener;

public interface BAPFunction {
    default public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    default public void requestAcknowledge() {
    }

    default public void errorAcknowledge() {
    }
}

