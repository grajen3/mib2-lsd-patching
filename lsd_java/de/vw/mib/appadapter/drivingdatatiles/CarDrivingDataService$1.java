/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.drivingdatatiles;

import de.vw.mib.appadapter.drivingdatatiles.CarDrivingDataService;
import de.vw.mib.configuration.FeatureFlagValueChangeReceiver;

class CarDrivingDataService$1
implements FeatureFlagValueChangeReceiver {
    private final /* synthetic */ CarDrivingDataService this$0;

    CarDrivingDataService$1(CarDrivingDataService carDrivingDataService) {
        this.this$0 = carDrivingDataService;
    }

    @Override
    public void receiveFeatureFlagValue(int n, boolean bl) {
        if (n == 55 && CarDrivingDataService.access$000(this.this$0) == 2) {
            if (CarDrivingDataService.access$100(this.this$0) == 2 && bl) {
                CarDrivingDataService.access$200(this.this$0, 2, 3);
            } else if (CarDrivingDataService.access$100(this.this$0) == 3 && !bl) {
                CarDrivingDataService.access$200(this.this$0, 3, 2);
            }
        }
    }
}

