/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate;

import de.vw.mib.asi.car.climate.ASICarClimate;
import de.vw.mib.asi.car.climate.ASICarClimateListener;
import de.vw.mib.asi.car.climate.ASICarClimateResponse;

public class ASICarClimateAdapter
implements ASICarClimate {
    protected ASICarClimateListener listener;

    @Override
    public ASICarClimateListener getASICarClimateListener() {
        return this.listener;
    }

    @Override
    public void setASICarClimateListener(ASICarClimateListener aSICarClimateListener) {
        this.listener = aSICarClimateListener;
    }

    @Override
    public void setAirconAC(boolean bl, ASICarClimateResponse aSICarClimateResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

