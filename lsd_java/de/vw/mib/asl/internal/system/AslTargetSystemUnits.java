/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.asl.internal.system.AslTargetSystemUnits$1;
import de.vw.mib.asl.internal.system.AstaUpdater;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.persistence.PersistenceUnitChangeListener;
import de.vw.mib.asl.internal.system.util.SystemUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class AslTargetSystemUnits
extends AbstractASLTarget
implements DSICarTimeUnitsLanguageListener {
    private static final String LOGGING_DELIM;
    private DSICarTimeUnitsLanguage dsiCarTimeUnits;
    private boolean clamp15State = false;
    private final SystemData systemData = SystemData.getInstance();
    private boolean unitMasterFactoryResetAllowed = false;
    private boolean unitsMenuAvailable = true;
    private int collectedViewOptionReasons = 2;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;

    public AslTargetSystemUnits(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        SystemAccessor.setUnitsTarget(this);
    }

    public AslTargetSystemUnits(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        SystemAccessor.setUnitsTarget(this);
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300004: {
                this.clamp15State = eventGeneric.getBoolean(0);
                this.updateUnitsMenuAvailabilityReason();
                break;
            }
            case 1073743197: {
                this.processAslDownToggleDistanceUnit();
                break;
            }
            case 1073743203: {
                this.processAslDownToggleTemperatureUnit();
                break;
            }
            case 1073743210: {
                this.processAslDownVolumeUnit(eventGeneric.getInt(0));
                break;
            }
            case 1073743182: {
                this.processAslDownPressureUnit(eventGeneric.getInt(0));
                break;
            }
            case 1073743181: {
                this.processAslDownPetrolConsumptionUnit(eventGeneric.getInt(0));
                break;
            }
            case 1073743199: {
                this.processAslDownToggleSpeedUnit();
                break;
            }
            case 0x40000540: {
                this.processAslDownGasConsumptionUnit(eventGeneric.getInt(0));
                break;
            }
            case 1075841827: {
                this.processAslDownElectroConsumptionUnit(eventGeneric.getInt(0));
                break;
            }
            case 1075841841: {
                this.processAslDownAstaWeightUnit(eventGeneric.getInt(0));
                break;
            }
        }
    }

    public int getConfiguredDistanceUnit() {
        return this.systemData.getDistanceUnit();
    }

    @Override
    public int getDefaultTargetId() {
        return 5607;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.warn().append("[AslTargetSystemUnits] ").append("DSICarTimeUnitsLanguage-ASYNC:ErrorCode[").append(n).append("] Text:'").append(string).append("' RequestId[").append(n2).append("]").log();
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemUnits] ").append("updateUnitmasterViewOptions").log();
            this.trace().append(" distanceUnit ").append(unitmasterViewOptions.distanceUnit).log();
            this.trace().append(" speedUnit ").append(unitmasterViewOptions.speedUnit).log();
            this.trace().append(" pressureUnit ").append(unitmasterViewOptions.pressureUnit).log();
            this.trace().append(" temperatureUnit ").append(unitmasterViewOptions.temperatureUnit).log();
            this.trace().append(" volumeUnit ").append(unitmasterViewOptions.volumeUnit).log();
            this.trace().append(" consumptionPetrolUnit ").append(unitmasterViewOptions.consumptionPetrolUnit).log();
            this.trace().append(" consumptionGasUnit ").append(unitmasterViewOptions.consumptionGasUnit).log();
            this.trace().append(" consumptionElectricUnit ").append(unitmasterViewOptions.consumptionElectricUnit).log();
            this.trace().append(" umSetFactoryDefault ").append(unitmasterViewOptions.umSetFactoryDefault).log();
        }
        this.collectedViewOptionReasons = 0;
        boolean bl = unitmasterViewOptions.distanceUnit.state != 0;
        boolean bl2 = unitmasterViewOptions.distanceUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1662, bl);
        AslTargetSystemUnits.writeBooleanToDatapool(1663, bl2);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.distanceUnit.reason);
        boolean bl3 = unitmasterViewOptions.speedUnit.state != 0;
        boolean bl4 = unitmasterViewOptions.speedUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1694, bl3);
        AslTargetSystemUnits.writeBooleanToDatapool(1695, bl4);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.speedUnit.reason);
        boolean bl5 = unitmasterViewOptions.pressureUnit.state != 0;
        boolean bl6 = unitmasterViewOptions.pressureUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1682, bl5);
        AslTargetSystemUnits.writeBooleanToDatapool(1683, bl6);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.pressureUnit.reason);
        boolean bl7 = unitmasterViewOptions.temperatureUnit.state != 0;
        boolean bl8 = unitmasterViewOptions.temperatureUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1699, bl7);
        AslTargetSystemUnits.writeBooleanToDatapool(1700, bl8);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.temperatureUnit.reason);
        boolean bl9 = unitmasterViewOptions.volumeUnit.state != 0;
        boolean bl10 = unitmasterViewOptions.volumeUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1716, bl9);
        AslTargetSystemUnits.writeBooleanToDatapool(1717, bl10);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.volumeUnit.reason);
        boolean bl11 = unitmasterViewOptions.consumptionPetrolUnit.state != 0;
        boolean bl12 = unitmasterViewOptions.consumptionPetrolUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1679, bl11);
        AslTargetSystemUnits.writeBooleanToDatapool(1668, bl12);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.consumptionPetrolUnit.reason);
        boolean bl13 = unitmasterViewOptions.consumptionGasUnit.state != 0;
        boolean bl14 = unitmasterViewOptions.consumptionGasUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(1666, bl13);
        AslTargetSystemUnits.writeBooleanToDatapool(1667, bl14);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.consumptionGasUnit.reason);
        boolean bl15 = unitmasterViewOptions.consumptionElectricUnit.state != 0;
        boolean bl16 = unitmasterViewOptions.consumptionElectricUnit.state != 1;
        AslTargetSystemUnits.writeBooleanToDatapool(942809088, bl15);
        AslTargetSystemUnits.writeBooleanToDatapool(926031872, bl16);
        this.collectedViewOptionReasons |= SystemUtil.collectReason(unitmasterViewOptions.consumptionElectricUnit.reason);
        this.unitsMenuAvailable = bl || bl3 || bl5 || bl7 || bl9 || bl11 || bl13 || bl15;
        this.updateUnitsMenuAvailability();
        boolean bl17 = bl2 || bl4 || bl6 || bl8 || bl10 || bl12 || bl14 || bl16;
        AslTargetSystemUnits.writeBooleanToDatapool(10107, bl17);
        this.updateUnitsMenuAvailabilityReason();
        this.unitMasterFactoryResetAllowed = unitmasterViewOptions.umSetFactoryDefault.state == 2;
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemUnits] ").append("updateUnitmasterViewOptions umConfiguration:").log();
            if (unitmasterViewOptions.umConfiguration != null) {
                UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits = unitmasterViewOptions.umConfiguration.supportedConsumptionUnits;
                this.trace().append("[AslTargetSystemUnits] ").append("supportedConsumptionUnits kWhPerMiles: ").append(unitmasterSupportedConsumptionUnits.kWhPerMiles).append(" milesPerKg: ").append(unitmasterSupportedConsumptionUnits.milesPerKg).append(" milesPerM3: ").append(unitmasterSupportedConsumptionUnits.milesPerM3).append(" mpgeUS: ").append(unitmasterSupportedConsumptionUnits.mpgeUS).log();
            } else {
                this.trace().append("[AslTargetSystemUnits] ").append("umConfiguration is null").log();
            }
        }
    }

    @Override
    public void updateMenuLanguage(int n, int n2) {
    }

    @Override
    public void updateTemperatureUnit(int n, int n2) {
        int n3 = -1;
        if (1 == n) {
            n3 = 1;
        } else if (0 == n) {
            n3 = 0;
        }
        if (n3 != -1 && n3 != this.systemData.getTemperatureUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1592, n3);
            this.systemData.setTemperatureUnit(n3);
            SystemHasBridgeImpl.getInstance().setPropertyTemperatureUnit(n3);
        }
        SystemAccessor.getGeneralTarget().updateOutsideTemperature();
    }

    @Override
    public void updateDistanceUnit(int n, int n2) {
        int n3 = -1;
        if (n == 1) {
            n3 = 1;
        } else if (n == 0) {
            n3 = 0;
        }
        if (n3 != -1) {
            if (n3 != this.systemData.getDistanceUnit()) {
                AslTargetSystemUnits.writeIntegerToDatapool(1584, n3);
                this.systemData.setDistanceUnit(n3);
                SystemHasBridgeImpl.getInstance().setPropertyDistanceUnit(n3);
            }
            this.triggerDistanceUnitChanged();
        }
    }

    @Override
    public void updateSpeedUnit(int n, int n2) {
        int n3 = -1;
        if (n == 0) {
            n3 = 0;
        } else if (n == 1) {
            n3 = 1;
        }
        if (n3 != -1 && n3 != this.systemData.getSpeedUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1590, n3);
            this.systemData.setSpeedUnit(n3);
            SystemHasBridgeImpl.getInstance().setPropertySpeedUnit(n3);
        }
    }

    @Override
    public void updatePressureUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 2: {
                n3 = 0;
                break;
            }
            case 0: {
                n3 = 1;
                break;
            }
            case 1: {
                n3 = 2;
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getPressureUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1588, n3);
            this.systemData.setPressureUnit(n3);
            SystemHasBridgeImpl.getInstance().setPropertyPressureUnit(n3);
        }
    }

    @Override
    public void updateVolumeUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 3: {
                n3 = 2;
                break;
            }
            case 4: {
                n3 = 1;
                break;
            }
            case 2: {
                n3 = 0;
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getVolumeUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1596, n3);
            this.systemData.setVolumeUnit(n3);
        }
    }

    @Override
    public void updateConsumptionPetrolUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 3: {
                n3 = 3;
                break;
            }
            case 4: {
                n3 = 2;
                break;
            }
            case 0: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 1;
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getPetrolConsumptionUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1587, n3);
            this.systemData.setPetrolConsumptionUnit(n3);
            SystemHasBridgeImpl.getInstance().setPropertyLiquidConsumptionUnit(n3);
        }
    }

    @Override
    public void updateConsumptionGasUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 6: {
                n3 = 0;
                break;
            }
            case 7: {
                n3 = 1;
                break;
            }
            case 9: {
                n3 = 2;
                break;
            }
            case 10: {
                n3 = 3;
                break;
            }
            case 23: {
                break;
            }
            case 24: {
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getGasConsumptionUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1585, n3);
            this.systemData.setGasConsumptionUnit(n3);
        }
    }

    @Override
    public void updateConsumptionElectricUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 18: {
                n3 = 0;
                break;
            }
            case 19: {
                n3 = 1;
                break;
            }
            case 21: {
                n3 = 2;
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getElectricConsumptionUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(959586304, n3);
            this.systemData.setElectricConsumptionUnit(n3);
        }
    }

    @Override
    public void updateClockFormat(int n, int n2) {
    }

    @Override
    public void updateDateFormat(int n, int n2) {
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
    }

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
    }

    @Override
    public void updateClockSource(int n, int n2) {
    }

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
    }

    @Override
    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
    }

    @Override
    public void updateClockTimeZoneOffset(float f2, int n) {
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
    }

    @Override
    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
    }

    @Override
    public void acknowledgeUmSetFactoryDefault(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemUnits] ").append("acknowledgeUmSetFactoryDefault: ").append(bl).log();
        }
    }

    @Override
    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
    }

    @Override
    public void updateSkin(int n, int n2) {
    }

    @Override
    public void updateWeightUnit(int n, int n2) {
        int n3 = -1;
        switch (n) {
            case 0: {
                n3 = 0;
                break;
            }
            case 1: {
                n3 = 1;
                break;
            }
        }
        if (n3 != -1 && n3 != this.systemData.getAstaWeightUnit()) {
            AslTargetSystemUnits.writeIntegerToDatapool(1479680000, n3);
            this.systemData.setAstaWeightUnit(n3);
        }
    }

    void processRevertSystemUnits() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemUnits] ").append("processRevertSystemUnits").log();
        }
        if (this.unitMasterFactoryResetAllowed) {
            this.dsiCarTimeUnits.setUmSetFactoryDefault();
        }
    }

    private void processAslDownGasConsumptionUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 9;
                break;
            }
            case 3: {
                n2 = 10;
                break;
            }
            case 4: {
                n2 = 23;
                break;
            }
            case 5: {
                n2 = 24;
                break;
            }
            default: {
                n2 = -1;
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownGasConsumptionUnit, unknown unit value: ").append(n).log();
            }
        }
        if (n2 != -1) {
            this.dsiCarTimeUnits.setConsumptionGasUnit(n2);
        }
    }

    private void processAslDownPetrolConsumptionUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                n2 = -1;
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownPetrolConsumptionUnit, unknown unit value: ").append(n).log();
            }
        }
        if (n2 != -1) {
            this.dsiCarTimeUnits.setConsumptionPetrolUnit(n2);
        }
    }

    private void processAslDownAstaWeightUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = -1;
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownAstaWeightUnit, unknown unit value: ").append(n).log();
            }
        }
        if (n2 != -1) {
            this.dsiCarTimeUnits.setWeightUnit(n2);
        }
    }

    private void processAslDownElectroConsumptionUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 18;
                break;
            }
            case 1: {
                n2 = 19;
                break;
            }
            case 2: {
                n2 = 21;
                break;
            }
            default: {
                n2 = -1;
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownElectroConsumptionUnit, unknown unit value: ").append(n).log();
            }
        }
        if (n2 != -1) {
            this.dsiCarTimeUnits.setConsumptionElectricUnit(n2);
        }
    }

    private void processAslDownPressureUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                n2 = -1;
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownPressureUnit, unknown unit value: ").append(n).log();
            }
        }
        if (n2 != -1) {
            this.dsiCarTimeUnits.setPressureUnit(n2);
        }
    }

    private void processAslDownToggleDistanceUnit() {
        int n = this.systemData.isDistanceUnitKm() ? 1 : 0;
        this.dsiCarTimeUnits.setDistanceUnit(n);
    }

    private void processAslDownToggleSpeedUnit() {
        int n = this.systemData.isSpeedUnitKmph() ? 1 : 0;
        this.dsiCarTimeUnits.setSpeedUnit(n);
    }

    private void processAslDownToggleTemperatureUnit() {
        int n = this.systemData.isTemperatureUnitCelsius() ? 1 : 0;
        this.dsiCarTimeUnits.setTemperatureUnit(n);
    }

    private void processAslDownVolumeUnit(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                this.error().append("[AslTargetSystemUnits] ").append("processAslDownVolumeUnit, unknown unit value: ").append(n).log();
                n2 = 2;
            }
        }
        this.dsiCarTimeUnits.setVolumeUnit(n2);
    }

    private void processPowerOn() {
        if (!ASLStartupv7rFactory.getStartupv7rApi().isNonCustomerSwdlIsInProgress()) {
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetSystemUnits] ").append("processPowerOn").log();
            }
            SystemServices systemServices = SystemServicesProvider.getSystemServices();
            new PersistenceUnitChangeListener(systemServices).registerUnitChangeListener();
            this.setServiceAndNotificationForCarTimeUnitsLanguage();
            this.registerBordComputerUpdater();
            this.registerFactoryResetParticipant();
            this.addObserviers();
        }
    }

    private void addObserviers() {
        ServiceRegister serviceRegister = SystemServicesProvider.getSystemServices().getServiceRegister();
        serviceRegister.addObserver(822812736, this.getTargetId());
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = SystemServicesProvider.getSystemServices().getFactoryResetService();
        AslTargetSystemUnits$1 aslTargetSystemUnits$1 = new AslTargetSystemUnits$1(this);
        factoryResetService.addParticipant(aslTargetSystemUnits$1, FactoryResetComponents.SYSTEM);
    }

    private void registerBordComputerUpdater() {
        ASLPropertyManager aSLPropertyManager = SystemServicesProvider.getSystemServices().getPropertyManager();
        ASLCarFactory.getCarApi().getCarBordComputerAPI().addServiceListener(new AstaUpdater(aSLPropertyManager));
    }

    private void setServiceAndNotificationForCarTimeUnitsLanguage() {
        if (this.isTraceEnabled()) {
            this.trace().append("[AslTargetSystemUnits] ").append("setServiceAndNotificationForCarTimeUnitsLanguage").log();
        }
        DSIProxy dSIProxy = SystemServicesProvider.getSystemServices().getDsiProxy();
        this.dsiCarTimeUnits = (DSICarTimeUnitsLanguage)dSIProxy.getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = AslTargetSystemUnits.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = AslTargetSystemUnits.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener, this);
        this.dsiCarTimeUnits.setNotification(new int[]{13, 17, 22, 12, 16, 18, 15, 14, 10, 24}, (DSIListener)this);
    }

    private void updateUnitsMenuAvailabilityReason() {
        AslTargetSystemUnits.writeIntegerToDatapool(10110, SystemUtil.getRelevantReason(this.collectedViewOptionReasons, this.clamp15State));
    }

    void triggerDistanceUnitChanged() {
        if (SystemAccessor.getGeneralTarget().isNaviTargetReady()) {
            if (this.isTraceEnabled()) {
                this.trace().append("[AslTargetSystemUnits] ").append("unitmasterDistanceUnitChanged, trigger ASLSystemServiceIds.DISTANCEUNIT_CHANGED").log();
            }
            int n = this.systemData.getDistanceUnit();
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId());
            eventGeneric.setInt(0, n);
            this.triggerObserver(278741248, eventGeneric);
        }
    }

    void updateUnitsMenuAvailability() {
        AslTargetSystemFeaturesAndCoding aslTargetSystemFeaturesAndCoding = SystemAccessor.getFeaturesAndCodingTarget();
        if (aslTargetSystemFeaturesAndCoding.isTableCarFunctionsAdaptationAlreadyRead()) {
            AslTargetSystemUnits.writeBooleanToDatapool(1711, aslTargetSystemFeaturesAndCoding.isUnitMasterDisplayActivated() && this.unitsMenuAvailable);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

