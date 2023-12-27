/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import org.dsi.ifc.global.CarViewOption;

public class CarViewOptionWrapper
implements CarFunctionState {
    public static final int STATE_NORMAL_OPERATION;
    public static final int STATE_NOT_ACCESSIBLE;
    public static final int STATE_NOT_EXISTING;
    private CarViewOption vo;

    public CarViewOptionWrapper(CarViewOption carViewOption) {
        this.vo = carViewOption;
    }

    @Override
    public int getState() {
        return this.vo.getState();
    }

    @Override
    public int getAvailableReason() {
        return this.vo.getReason();
    }
}

