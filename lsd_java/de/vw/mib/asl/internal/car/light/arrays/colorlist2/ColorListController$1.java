/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist2;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListClientsUpdater;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListController;

class ColorListController$1
extends ASGArrayListClientsUpdater {
    private final /* synthetic */ ColorListController this$0;

    ColorListController$1(ColorListController colorListController, String string, CarLogger carLogger, int n, int n2) {
        this.this$0 = colorListController;
        super(string, carLogger, n, n2);
    }

    @Override
    protected void updatePersistence(Object[] objectArray) {
    }
}

