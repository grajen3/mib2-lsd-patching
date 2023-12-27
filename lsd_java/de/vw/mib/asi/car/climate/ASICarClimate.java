/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.climate;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.car.climate.ASICarClimateListener;
import de.vw.mib.asi.car.climate.ASICarClimateResponse;

public interface ASICarClimate
extends ASIService {
    default public ASICarClimateListener getASICarClimateListener() {
    }

    default public void setASICarClimateListener(ASICarClimateListener aSICarClimateListener) {
    }

    default public void setAirconAC(boolean bl, ASICarClimateResponse aSICarClimateResponse) {
    }
}

