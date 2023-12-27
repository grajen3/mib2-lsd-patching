/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.appadapter.carstatustiles.CarStatusTiresService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;

class CarStatusTiresService$1
extends ClampSignalAdapter {
    private final /* synthetic */ CarStatusTiresService this$0;

    CarStatusTiresService$1(CarStatusTiresService carStatusTiresService) {
        this.this$0 = carStatusTiresService;
    }

    @Override
    public void onClamp15ValueChanged(boolean bl) {
        CarStatusTiresService.access$100(this.this$0)._update_getRKA_RDKS_States(new boolean[]{bl, CarStatusTiresService.access$000(this.this$0)});
    }
}

