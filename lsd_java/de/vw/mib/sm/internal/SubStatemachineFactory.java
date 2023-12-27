/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.sm.internal.statemachine.SubStatemachine;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public interface SubStatemachineFactory {
    default public SubStatemachine createSubStatemachine(int n, TopStatemachine topStatemachine) {
    }
}

