/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.car.driving;

import de.vw.mib.asi.car.driving.ASICarDriving;
import de.vw.mib.asi.car.driving.ASICarDrivingListener;

public class ASICarDrivingAdapter
implements ASICarDriving {
    protected ASICarDrivingListener listener;

    @Override
    public ASICarDrivingListener getASICarDrivingListener() {
        return this.listener;
    }

    @Override
    public void setASICarDrivingListener(ASICarDrivingListener aSICarDrivingListener) {
        this.listener = aSICarDrivingListener;
    }
}

