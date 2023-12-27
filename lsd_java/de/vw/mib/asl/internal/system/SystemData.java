/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.UnitSetter;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.Units;
import de.vw.mib.collections.ints.IntObjectMultimap;
import java.util.ArrayList;
import java.util.Iterator;

public final class SystemData {
    private static SystemData myInstance = new SystemData();
    private final IntObjectMultimap mapUnitType2Listener = new IntObjectMultimap();
    private int distanceUnit;
    private int temperatureUnit;
    private int volumeUnit;
    private int petrolConsumptionUnit;
    private int gasConsumptionUnit;
    private int electricConsumptionUnit;
    private int pressureUnit;
    private int speedUnit;
    private int astaWeightUnit;
    private boolean daylightSaving;
    private boolean daylightSavingHasBeenSet;
    private int timeformat;
    private int timezone;
    private int dateformat;
    private int timemaster;
    private final ASLPropertyManager propertyManager;
    private SystemServices systemServices = SystemServicesProvider.getSystemServices();
    private UnitSetter unitSetter;

    private SystemData() {
        SystemCommonPersistenceService systemCommonPersistenceService = this.systemServices.getSystemCommonPersistenceService();
        this.propertyManager = this.systemServices.getPropertyManager();
        this.initValues(systemCommonPersistenceService.loadUnits());
    }

    public static SystemData getInstance() {
        return myInstance;
    }

    public boolean getDaylightSaving() {
        return this.daylightSaving;
    }

    public int getTimeformat() {
        return this.timeformat;
    }

    public boolean is24hTimeFormat() {
        return this.timeformat == 1;
    }

    public int getTimezone() {
        return this.timezone;
    }

    public int getDateformat() {
        return this.dateformat;
    }

    public int getTimemaster() {
        return this.timemaster;
    }

    public int getDistanceUnit() {
        return this.distanceUnit;
    }

    public boolean isDistanceUnitKm() {
        return this.distanceUnit == 0;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public boolean isTemperatureUnitCelsius() {
        return this.temperatureUnit == 0;
    }

    public int getVolumeUnit() {
        return this.volumeUnit;
    }

    public int getPetrolConsumptionUnit() {
        return this.petrolConsumptionUnit;
    }

    public int getGasConsumptionUnit() {
        return this.gasConsumptionUnit;
    }

    public int getElectricConsumptionUnit() {
        return this.electricConsumptionUnit;
    }

    public int getPressureUnit() {
        return this.pressureUnit;
    }

    public int getSpeedUnit() {
        return this.speedUnit;
    }

    public int getAstaWeightUnit() {
        return this.astaWeightUnit;
    }

    public boolean isAstaWeightUnitKg() {
        return this.astaWeightUnit == 0;
    }

    public boolean isSpeedUnitKmph() {
        return this.speedUnit == 0;
    }

    public void addUnitChangeListener(int n, UnitChangeListener unitChangeListener) {
        this.mapUnitType2Listener.put(n, unitChangeListener);
    }

    public void addUnitChangeListener(UnitChangeListener unitChangeListener) {
        this.mapUnitType2Listener.put(9, unitChangeListener);
    }

    void setDaylightSaving(boolean bl) {
        this.daylightSavingHasBeenSet = true;
        this.daylightSaving = bl;
    }

    boolean hasDaylightSavingBeenSet() {
        return this.daylightSavingHasBeenSet;
    }

    void setTimeformat(int n) {
        this.timeformat = n;
    }

    void setTimezone(int n) {
        this.timezone = n;
    }

    void setDateformat(int n) {
        this.dateformat = n;
    }

    void setTimemaster(int n) {
        this.timemaster = n;
    }

    void setDistanceUnit(int n) {
        this.distanceUnit = n;
        this.notifyUnitChangeListeners(3, n);
    }

    void setTemperatureUnit(int n) {
        this.temperatureUnit = n;
        this.notifyUnitChangeListeners(0, n);
    }

    void setVolumeUnit(int n) {
        this.volumeUnit = n;
        this.notifyUnitChangeListeners(4, n);
    }

    void setPetrolConsumptionUnit(int n) {
        this.petrolConsumptionUnit = n;
        this.notifyUnitChangeListeners(5, n);
    }

    void setGasConsumptionUnit(int n) {
        this.gasConsumptionUnit = n;
        this.notifyUnitChangeListeners(6, n);
    }

    void setElectricConsumptionUnit(int n) {
        this.electricConsumptionUnit = n;
        this.notifyUnitChangeListeners(7, n);
    }

    void setPressureUnit(int n) {
        this.pressureUnit = n;
        this.notifyUnitChangeListeners(8, n);
    }

    void setSpeedUnit(int n) {
        this.speedUnit = n;
        this.notifyUnitChangeListeners(1, n);
    }

    void setAstaWeightUnit(int n) {
        this.astaWeightUnit = n;
        this.notifyUnitChangeListeners(2, n);
    }

    private void initValues(Units units) {
        this.daylightSavingHasBeenSet = false;
        this.daylightSaving = false;
        this.timeformat = -1;
        this.timezone = -1;
        this.dateformat = -1;
        this.timemaster = -1;
        this.updateUnits(units);
    }

    private void updateUnits(Units units) {
        this.unitSetter = new UnitSetter(this.systemServices.getSystemHasBridge());
        this.distanceUnit = units.getDistanceUnit();
        this.updateUnitDatapool(1584, this.distanceUnit);
        this.unitSetter.setDistanceUnit(this.distanceUnit);
        this.temperatureUnit = units.getTemperatureUnit();
        this.updateUnitDatapool(1592, this.temperatureUnit);
        this.unitSetter.setTemperatureUnit(this.temperatureUnit);
        this.volumeUnit = units.getVolumeUnit();
        this.updateUnitDatapool(1596, this.volumeUnit);
        this.petrolConsumptionUnit = units.getPetrolConsumptionUnit();
        this.updateUnitDatapool(1587, this.petrolConsumptionUnit);
        this.unitSetter.setPetrolConsumptionUnit(this.petrolConsumptionUnit);
        this.gasConsumptionUnit = units.getGasConsumptionUnit();
        this.updateUnitDatapool(1585, this.gasConsumptionUnit);
        this.electricConsumptionUnit = units.getElectricConsumptionUnit();
        this.updateUnitDatapool(959586304, this.electricConsumptionUnit);
        this.pressureUnit = units.getPressureUnit();
        this.updateUnitDatapool(1588, this.pressureUnit);
        this.unitSetter.setPressureUnit(this.pressureUnit);
        this.speedUnit = units.getSpeedUnit();
        this.updateUnitDatapool(1590, this.speedUnit);
        this.unitSetter.setSpeedUnit(this.speedUnit);
        this.astaWeightUnit = units.getAstaWeightUnit();
        this.updateUnitDatapool(1479680000, this.astaWeightUnit);
    }

    private void updateUnitDatapool(int n, int n2) {
        this.propertyManager.valueChangedInteger(n, n2);
    }

    private void notifyUnitChangeListeners(int n, int n2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mapUnitType2Listener.getAll(n));
        arrayList.addAll(this.mapUnitType2Listener.getAll(9));
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            UnitChangeListener unitChangeListener = (UnitChangeListener)iterator.next();
            unitChangeListener.onUnitChanged(n, n2);
        }
    }
}

