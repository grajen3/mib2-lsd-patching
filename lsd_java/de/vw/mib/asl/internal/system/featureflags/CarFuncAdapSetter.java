/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class CarFuncAdapSetter {
    private final ASLPropertyManager aslPropertyManager;
    private final ConfigurationManagerDiag configurationManagerDiag;

    public CarFuncAdapSetter(ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag) {
        this.aslPropertyManager = aSLPropertyManager;
        this.configurationManagerDiag = configurationManagerDiag;
    }

    public void update(CarFuncAdap carFuncAdap) {
        if (carFuncAdap != null) {
            this.updateOcuEni(carFuncAdap);
            this.updateOcuEcall(carFuncAdap);
            this.updateThinkBlueTrainer(carFuncAdap);
            this.updateDisplayRdk(carFuncAdap);
        }
    }

    private void updateDisplayRdk(CarFuncAdap carFuncAdap) {
        boolean bl = carFuncAdap.getBoolean(245);
        this.aslPropertyManager.valueChangedBoolean(1402017792, bl);
        this.configurationManagerDiag.setFeatureFlagValue("ASL.Configuration.isCarRdk", bl);
    }

    private void updateOcuEcall(CarFuncAdap carFuncAdap) {
        boolean bl = carFuncAdap.getBoolean(440);
        this.aslPropertyManager.valueChangedBoolean(680597504, bl);
        this.configurationManagerDiag.setFeatureFlagValue("ASL.Configuration.isOCU_ECall", bl);
    }

    private void updateOcuEni(CarFuncAdap carFuncAdap) {
        boolean bl = carFuncAdap.getBoolean(445);
        this.aslPropertyManager.valueChangedBoolean(663820288, bl);
        this.configurationManagerDiag.setFeatureFlagValue("ASL.Configuration.isOCU_ENI", bl);
    }

    private void updateThinkBlueTrainer(CarFuncAdap carFuncAdap) {
        boolean bl = carFuncAdap.getBoolean(375);
        this.aslPropertyManager.valueChangedBoolean(1452349440, bl);
        this.configurationManagerDiag.setFeatureFlagValue("ASL.Configuration.isThinkBlueTrainer", bl);
    }
}

