/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.variant.high2;

import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncListCan;
import de.vw.mib.asl.framework.internal.diagnosis.config.AccessImpl;
import de.vw.mib.asl.framework.internal.diagnosis.config.util.Engine;

public final class CarFuncListCanImpl
extends AccessImpl
implements CarFuncListCan {
    public CarFuncListCanImpl(byte[] byArray) {
        super(byArray, new int[]{8}, -536825343, 0);
        this.mConfiguration = new int[]{20051, 4, 0, 0, 0, -1, 20051, 4, 0, 4, 0, -1, 20051, 4, 2, 0, 0, -1, 20051, 4, 2, 4, 0, -1, 20051, 4, 3, 0, 0, -1, 20051, 4, 3, 4, 0, -1, 20051, 4, 4, 0, 0, -1, 20051, 4, 4, 4, 0, -1, 20051, 4, 5, 0, 0, -1, 20051, 4, 5, 4, 0, -1, 20051, 4, 6, 0, 0, -1, 20051, 4, 6, 4, 0, -1, 20051, 4, 7, 0, 0, -1, 20051, 4, 7, 4, 0, -1, 34, 476, 24, 128, 128, 485, 78, 481, 54, 477, 30, 128, 128, 128, 128, 482, 60, 478, 36, 474, 12, 470, 0, 483, 66, 479, 42, 475, 18, 471, 6, 484, 72, 480, 48, 84};
        this.mEngine = new Engine(this.mConfiguration);
    }
}

