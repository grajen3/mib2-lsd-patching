/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.api.system.powerstate.PowerStateService;

public interface PropagatingPowerStateService
extends PowerStateService {
    default public void applyAslApiPowerState(int n) {
    }
}

