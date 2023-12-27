/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncListBap;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class CarFuncListBapSetter {
    private final ASLPropertyManager aslPropertyManager;
    private final ConfigurationManagerDiag configurationManagerDiag;

    public CarFuncListBapSetter(ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag) {
        this.aslPropertyManager = aSLPropertyManager;
        this.configurationManagerDiag = configurationManagerDiag;
    }

    public void update(CarFuncListBap carFuncListBap) {
        if (carFuncListBap != null) {
            this.updateOffRoadContextShownInMainMenu(carFuncListBap);
        }
    }

    private void updateOffRoadContextShownInMainMenu(CarFuncListBap carFuncListBap) {
        if (carFuncListBap.contains(526)) {
            boolean bl = carFuncListBap.getValue(526) == 1;
            this.aslPropertyManager.valueChangedBoolean(1435572224, bl);
            this.configurationManagerDiag.setFeatureFlagValue("ASL.Configuration.isCarOffroadContextShownInMainMenu", bl);
        }
    }
}

