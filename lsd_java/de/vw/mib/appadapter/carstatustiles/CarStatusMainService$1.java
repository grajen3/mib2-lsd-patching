/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.carstatustiles;

import de.vw.mib.appadapter.carstatustiles.CarStatusMainService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalAdapter;

class CarStatusMainService$1
extends ClampSignalAdapter {
    private final /* synthetic */ CarStatusMainService this$0;

    CarStatusMainService$1(CarStatusMainService carStatusMainService) {
        this.this$0 = carStatusMainService;
    }

    @Override
    public void onClamp15ValueChanged(boolean bl) {
        this.this$0.getCarStatusMainModelApiCallback()._update_getSystemStates(new boolean[]{CarStatusMainService.access$000(this.this$0), bl});
    }
}

