/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases;

import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.global.CarViewOption;

public interface ServiceStateListener$ServiceStateResult {
    default public DCViewOptions getServiceViewOptions() {
    }

    default public boolean isServiceAvailable() {
    }

    default public boolean isServiceAvailable(CarViewOption carViewOption) {
    }
}

