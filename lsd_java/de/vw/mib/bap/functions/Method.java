/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.MethodListener;

public interface Method
extends BAPFunction {
    default public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
    }

    default public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
    }
}

