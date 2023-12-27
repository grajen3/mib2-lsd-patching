/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.hsm;

import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class AbstractHsmState
implements HsmState {
    private final String name;
    protected Hsm myHsm = null;
    protected HsmState myParent = null;

    public AbstractHsmState(Hsm hsm, String string, HsmState hsmState) {
        this.name = string;
        this.myHsm = hsm;
        this.myParent = hsmState;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final HsmState getParent() {
        return this.myParent;
    }

    public final void trans(HsmState hsmState) {
        if (this.myHsm == null) {
            throw new IllegalAccessError("My hsm state is null.");
        }
        this.myHsm.trans(hsmState);
    }

    public String toString() {
        return this.name;
    }
}

