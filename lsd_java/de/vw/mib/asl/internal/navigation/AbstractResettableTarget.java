/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEvents;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractResettableTarget
extends AbstractTarget {
    public boolean isFirstStartupDone = false;

    public AbstractResettableTarget() {
    }

    public AbstractResettableTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public AbstractResettableTarget(GenericEvents genericEvents, int n) {
        super(genericEvents, n);
    }

    public AbstractResettableTarget(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    public AbstractResettableTarget(GenericEvents genericEvents) {
        super(genericEvents);
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
}

