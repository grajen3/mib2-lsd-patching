/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.BAPOperationState;

public interface FSGOperationState
extends BAPOperationState {
    default public void setState(int n) {
    }

    default public void setHMISystemDependent(boolean bl) {
    }

    default public boolean isSystemDependent() {
    }
}

