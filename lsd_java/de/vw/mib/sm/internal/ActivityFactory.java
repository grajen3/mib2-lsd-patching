/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.sm.internal.statemachine.StatemachineActivity;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public interface ActivityFactory {
    default public StatemachineActivity createActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
    }
}

