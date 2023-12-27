/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal;

import de.vw.mib.sm.internal.statemachine.MainStatemachineOrder;
import de.vw.mib.sm.internal.statemachine.StatemachineActivationGuardEvaluator;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;

public interface StatemachineFactory {
    default public TopStatemachine[] createStatemachines(boolean bl, StatemachineActivationGuardEvaluator statemachineActivationGuardEvaluator) {
    }

    default public MainStatemachineOrder createMainStatemachineOrder() {
    }
}

