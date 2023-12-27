/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractResettableAslHsmTarget
extends AbstractASLHsmTarget {
    public boolean isFirstStartupDone = false;

    public AbstractResettableAslHsmTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    public AbstractResettableAslHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public abstract void reset(HashMap hashMap) {
    }

    protected boolean isDsiInHashMap(HashMap hashMap, String string, int n) {
        if (hashMap == null) {
            return false;
        }
        if (hashMap.containsKey(string)) {
            ArrayList arrayList = (ArrayList)hashMap.get(string);
            if (arrayList == null) {
                return false;
            }
            return arrayList.contains(new Integer(n));
        }
        return false;
    }

    protected void resetHsmToState(HsmState hsmState) {
        try {
            this.getHsm().trans(hsmState);
            this.getHsm().activateTransition();
        }
        catch (Exception exception) {
            this.error("Error during transition to state");
        }
    }
}

