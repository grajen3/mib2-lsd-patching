/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.internal.car.e_traction.HsmTargetBatteryManager;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class StateBatteryControlBase
extends AbstractHsmState {
    protected static final String BATTERY_CONTROL_HSM_ENTRY;
    protected static final String BATTERY_CONTROL_HSM_START;
    protected static final String BATTERY_CONTROL_HSM_EXIT;
    protected HsmTargetBatteryManager myTarget;

    public StateBatteryControlBase(HsmTargetBatteryManager hsmTargetBatteryManager, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetBatteryManager;
    }
}

