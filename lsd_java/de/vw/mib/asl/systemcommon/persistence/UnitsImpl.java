/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.Units;

class UnitsImpl
extends AbstractPersistable
implements Units {
    private final PersistenceModule module;
    private int distanceUnit;
    private int temperatureUnit;
    private int volumeUnit;
    private int petrolConsumptionUnit;
    private int gasConsumptionUnit;
    private int electricConsumptionUnit;
    private int pressureUnit;
    private int speedUnit;
    private int astaWeightUnit;

    UnitsImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    @Override
    public void setDistanceUnit(int n) {
        this.distanceUnit = n;
        this.markDirty();
    }

    @Override
    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    @Override
    public void setTemperatureUnit(int n) {
        this.temperatureUnit = n;
        this.markDirty();
    }

    @Override
    public int getVolumeUnit() {
        return this.volumeUnit;
    }

    @Override
    public void setVolumeUnit(int n) {
        this.volumeUnit = n;
        this.markDirty();
    }

    @Override
    public int getPetrolConsumptionUnit() {
        return this.petrolConsumptionUnit;
    }

    @Override
    public void setPetrolConsumptionUnit(int n) {
        this.petrolConsumptionUnit = n;
        this.markDirty();
    }

    @Override
    public int getGasConsumptionUnit() {
        return this.gasConsumptionUnit;
    }

    @Override
    public void setGasConsumptionUnit(int n) {
        this.gasConsumptionUnit = n;
        this.markDirty();
    }

    @Override
    public int getElectricConsumptionUnit() {
        return this.electricConsumptionUnit;
    }

    @Override
    public void setElectricConsumptionUnit(int n) {
        this.electricConsumptionUnit = n;
        this.markDirty();
    }

    @Override
    public int getPressureUnit() {
        return this.pressureUnit;
    }

    @Override
    public void setPressureUnit(int n) {
        this.pressureUnit = n;
        this.markDirty();
    }

    @Override
    public int getSpeedUnit() {
        return this.speedUnit;
    }

    @Override
    public void setSpeedUnit(int n) {
        this.speedUnit = n;
        this.markDirty();
    }

    @Override
    public int getAstaWeightUnit() {
        return this.astaWeightUnit;
    }

    @Override
    public void setAstaWeightUnit(int n) {
        this.astaWeightUnit = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

