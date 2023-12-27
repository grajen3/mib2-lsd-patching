/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.Units;

public class PersistenceUnitChangeListener
implements UnitChangeListener {
    private Units loadUnits;
    private SystemServices services;

    public PersistenceUnitChangeListener(SystemServices systemServices) {
        SystemCommonPersistenceService systemCommonPersistenceService = systemServices.getSystemCommonPersistenceService();
        this.loadUnits = systemCommonPersistenceService.loadUnits();
        this.services = systemServices;
    }

    public void registerUnitChangeListener() {
        this.services.getSystemData().addUnitChangeListener(this);
    }

    @Override
    public void onUnitChanged(int n, int n2) {
        switch (n) {
            case 0: {
                this.loadUnits.setTemperatureUnit(n2);
                break;
            }
            case 1: {
                this.loadUnits.setSpeedUnit(n2);
                break;
            }
            case 2: {
                this.loadUnits.setAstaWeightUnit(n2);
                break;
            }
            case 3: {
                this.loadUnits.setDistanceUnit(n2);
                break;
            }
            case 4: {
                this.loadUnits.setVolumeUnit(n2);
                break;
            }
            case 5: {
                this.loadUnits.setPetrolConsumptionUnit(n2);
                break;
            }
            case 6: {
                this.loadUnits.setGasConsumptionUnit(n2);
                break;
            }
            case 7: {
                this.loadUnits.setElectricConsumptionUnit(n2);
                break;
            }
            case 8: {
                this.loadUnits.setPressureUnit(n2);
                break;
            }
        }
    }
}

