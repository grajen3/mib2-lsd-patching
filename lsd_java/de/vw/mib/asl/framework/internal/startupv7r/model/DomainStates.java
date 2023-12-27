/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntIntOptHashMap;

public class DomainStates {
    public static final int INVALID;
    private final IntIntMap mapDomain2State = new IntIntOptHashMap();

    public int getRequestedState(int n) {
        if (this.mapDomain2State.containsKey(n)) {
            return this.mapDomain2State.get(n);
        }
        return -1;
    }

    public void setRequestedState(int n, int n2) {
        this.mapDomain2State.put(n, n2);
    }
}

