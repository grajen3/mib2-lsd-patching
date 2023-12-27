/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.driving;

import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.car.driving.ASICarDrivingListener;

public interface ASICarDriving
extends ASIService {
    default public ASICarDrivingListener getASICarDrivingListener() {
    }

    default public void setASICarDrivingListener(ASICarDrivingListener aSICarDrivingListener) {
    }
}

