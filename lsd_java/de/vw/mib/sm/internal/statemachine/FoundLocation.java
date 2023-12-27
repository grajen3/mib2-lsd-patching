/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.sm.internal.statemachine.SubStatemachine;

final class FoundLocation {
    public SubStatemachine subStatemachine;
    public short stateId;
    public short transitionId;

    FoundLocation() {
    }

    public void set(SubStatemachine subStatemachine, short s, short s2) {
        this.subStatemachine = subStatemachine;
        this.stateId = s;
        this.transitionId = s2;
    }
}

