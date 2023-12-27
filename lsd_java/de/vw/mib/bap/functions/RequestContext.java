/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface RequestContext {
    default public void status(BAPEntity bAPEntity) {
    }

    default public void requestError(int n) {
    }

    default public RequestContext copy() {
    }
}

