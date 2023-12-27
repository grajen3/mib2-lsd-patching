/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;

public class ResetParkingParticipant
extends AbstractFactoryResetParticipant {
    private OpsVpsHsmTarget target;

    public ResetParkingParticipant(OpsVpsHsmTarget opsVpsHsmTarget) {
        this.target = opsVpsHsmTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.target.resetToFactory();
        factoryResetCallback.notifyResetDone();
    }

    public void resetDone() {
    }
}

