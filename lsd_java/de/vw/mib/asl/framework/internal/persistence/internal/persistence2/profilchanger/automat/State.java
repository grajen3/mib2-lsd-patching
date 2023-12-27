/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;

public abstract class State {
    public abstract boolean isFinalState() {
    }

    public void onEnter(Context context) {
    }

    public void onExit(Context context) {
    }

    public void onTimeout(Context context) {
    }
}

