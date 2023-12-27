/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.pso.PersonalizationAdapter;

public class PersonalizationResetAvailablityUpdater
extends PersonalizationAdapter {
    private final ASLPropertyManager propertyManager;

    public PersonalizationResetAvailablityUpdater(ASLPropertyManager aSLPropertyManager) {
        if (aSLPropertyManager == null) {
            throw new IllegalArgumentException("Parameter >propertyManager< must not be null!");
        }
        this.propertyManager = aSLPropertyManager;
    }

    @Override
    public void onResetStateChanged(int n) {
        boolean bl = n == 3;
        this.updateDatapoolValue(bl);
    }

    public void updateDatapoolValue(boolean bl) {
        this.propertyManager.valueChangedBoolean(1412571136, bl);
    }
}

