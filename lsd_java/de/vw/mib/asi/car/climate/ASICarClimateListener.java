/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.vw.mib.asi.ASIListener;

public interface ASICarClimateListener
extends ASIListener {
    default public void updateAirconMaxAC(boolean bl, boolean bl2) {
    }

    default public void updateAirconTempZone1(IntBaseType intBaseType, boolean bl) {
    }

    default public void updateAirconTempZone2(IntBaseType intBaseType, boolean bl) {
    }
}

