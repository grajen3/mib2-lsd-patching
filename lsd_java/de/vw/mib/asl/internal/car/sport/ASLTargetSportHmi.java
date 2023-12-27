/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.sport;

import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.sport.RaceStatistics;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;

public class ASLTargetSportHmi
extends AbstractASLTarget
implements DSIServiceStateListener {
    private DSIPowerManagement dsiPowerManagement;
    private DSIListener dsiPowerManagementListener;
    private DSICarVehicleStates dsiCarVehicleState;
    private DSICarVehicleStatesListener dsiCarVehicleStateListener;
    private boolean isClamp15Active = false;
    private RaceStatistics statistics;
    private int currentPressureUnit = 0;
    private float dsiAbsChargingAirPressure;
    private boolean vehicleDataDynamicVehicleInfoHighFrequentNotificationSet;
    private float dsiDynamicVehicleInfoHighFrequentInfoLateralAcceleration;
    private float dsiDynamicVehicleInfoHighFrequentInfoLongitudinalAcceleration;
    private float dsiDynamicVehicleInfoHighFrequentInfoVehicleSpeedInfo;
    private int dsiDynamicVehicleInfoCurrentOutputPower;
    private int boostPressureIntValue;
    private float maxBoostPressure;
    private int lastMeterValue = 0;
    private int lastMeterAngle = 0;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public ASLTargetSportHmi(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        if (this.isTraceEnabled()) {
            this.trace().append("SportHmiASLTarget.SportHmiASLTarget()").log();
        }
    }

    public ASLTargetSportHmi(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        if (this.isTraceEnabled()) {
            this.trace().append("SportHmiASLTarget.SportHmiASLTarget()").log();
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -2108747264;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace().append("SportHmiASLTarget.POWER_ON()").log();
                }
                this.addObserver(822812672);
                break;
            }
            case 2100017: {
                boolean bl = eventGeneric.getBoolean(0);
                if (this.isTraceEnabled()) {
                    this.trace().append("SportHmiASLTarget.SWAP coded:").append(bl).log();
                }
                if (!bl) break;
                this.startApp();
                break;
            }
            case 1073745089: {
                int n2 = eventGeneric.getInt(0);
                if (this.isTraceEnabled()) {
                    this.trace().append("SportHmiASLTarget.NEW_LAP_TIME:").append(n2).log();
                }
                this.statistics.addLap(n2);
                int n3 = this.statistics.getNoOfLaps();
                ASLTargetSportHmi.writeIntegerToDatapool(10410, n2);
                if (n3 <= 1) break;
                ASLTargetSportHmi.writeIntegerToDatapool(10409, this.statistics.getLapNo((int)(n3 - 1)).lapTime);
                break;
            }
            case 1073745087: {
                if (this.isTraceEnabled()) {
                    this.trace().append("SportHmiASLTarget.RESET_STATISTICS:").log();
                }
                this.statistics.resetStatistics();
                break;
            }
            case 1073745148: {
                if (this.isTraceEnabled()) {
                    this.trace().append("SportHmiASLTarget.SET_SPORT_DISPLAY_PERSISTENCE:").log();
                }
                int n4 = eventGeneric.getInt(0);
                int n5 = eventGeneric.getInt(1);
                int n6 = eventGeneric.getInt(2);
                ServiceManager.aslPropertyManager.valueChangedInteger(10553, n4);
                ServiceManager.aslPropertyManager.valueChangedInteger(10552, n5);
                ServiceManager.aslPropertyManager.valueChangedInteger(10558, n6);
                CarPersistenceServiceImpl.getInstance().loadCar().setSportLeftTube(n4);
                CarPersistenceServiceImpl.getInstance().loadCar().setSportMiddleTube(n5);
                CarPersistenceServiceImpl.getInstance().loadCar().setSportRightTube(n6);
                break;
            }
        }
    }

    private void startApp() {
        this.dsiPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = ASLTargetSportHmi.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = ASLTargetSportHmi.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        this.dsiCarVehicleState = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = ASLTargetSportHmi.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiCarVehicleStateListener = (DSICarVehicleStatesListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = ASLTargetSportHmi.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
        this.setDefaultValues();
        this.registerModelEvents();
        this.registerDSIUpdates();
        this.statistics = new RaceStatistics();
    }

    private void setDefaultValues() {
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{-1056178112, -1089732544, -66322368});
    }

    private void registerDSIUpdates() {
        DSIProxy dSIProxy = ASLCarContainer.getInstance().getDSIProxy();
        DSIProxyAdapterFactory dSIProxyAdapterFactory = ASLCarContainer.getInstance().getAdapterFactory();
        DSICarTimeUnitsLanguage dSICarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)dSIProxy.getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = ASLTargetSportHmi.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        dSICarTimeUnitsLanguage.setNotification(15, dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = ASLTargetSportHmi.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener));
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetSportHmi.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
        this.dsiPowerManagement.setNotification(new int[]{4}, this.dsiPowerManagementListener);
        this.dsiCarVehicleState.setNotification(new int[]{12}, (DSIListener)this.dsiCarVehicleStateListener);
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.isClamp15Active = clampSignal.isClamp15();
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        int n2 = dynamicVehicleInfoHighFrequentViewOptions.getAbsChargingAirPressure().getState();
        int n3 = dynamicVehicleInfoHighFrequentViewOptions.getCurrentOutputPower().getState();
        int n4 = dynamicVehicleInfoHighFrequentViewOptions.getLongitudinalAcceleration().getState();
        int n5 = dynamicVehicleInfoHighFrequentViewOptions.getLateralAcceleration().getState();
        boolean bl6 = n4 != 0;
        boolean bl7 = bl5 = n5 != 0;
        if (n2 == 0) {
            bl4 = false;
            bl3 = false;
        } else if (n2 == 1) {
            bl4 = true;
            bl3 = false;
        } else {
            bl4 = true;
            bl3 = true;
        }
        if (n3 == 0) {
            bl2 = false;
            bl = false;
        } else if (n3 == 1) {
            bl2 = true;
            bl = false;
        } else {
            bl2 = true;
            bl = true;
        }
        ASLTargetSportHmi.writeBooleanToDatapool(10408, bl4);
        ASLTargetSportHmi.writeBooleanToDatapool(10400, bl3);
        ASLTargetSportHmi.writeBooleanToDatapool(10469, bl2);
        ASLTargetSportHmi.writeBooleanToDatapool(10396, bl);
        ASLTargetSportHmi.writeBooleanToDatapool(10404, n4 == 2 && n5 == 2);
        CarPersistenceServiceImpl.getInstance().loadCar().setTurboCharger(bl4);
        CarPersistenceServiceImpl.getInstance().loadCar().setPowerInstrument(bl2);
        if (bl2 || bl4 && bl5 && bl6) {
            if (!this.vehicleDataDynamicVehicleInfoHighFrequentNotificationSet) {
                this.dsiCarVehicleState.setNotification(new int[]{17, 14}, (DSIListener)this.dsiCarVehicleStateListener);
                this.vehicleDataDynamicVehicleInfoHighFrequentNotificationSet = true;
            }
        } else if (this.vehicleDataDynamicVehicleInfoHighFrequentNotificationSet) {
            this.dsiCarVehicleState.clearNotification(new int[]{17, 14}, (DSIListener)this.dsiCarVehicleStateListener);
            this.vehicleDataDynamicVehicleInfoHighFrequentNotificationSet = false;
        }
    }

    public void dsiCarTimeUnitsLanguageUpdatePressureUnit(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        int n3 = (int)this.convertPressure(this.currentPressureUnit, n, this.dsiAbsChargingAirPressure);
        ASLTargetSportHmi.writeIntegerToDatapool(10397, n3);
        ASLTargetSportHmi.writeIntegerToDatapool(10399, this.getHMIPressureUnitValue(n));
        n3 = this.calculateMaxBoostToUnit(n, this.maxBoostPressure);
        ASLTargetSportHmi.writeIntegerToDatapool(10405, n3);
    }

    private int getHMIPressureUnitValue(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 2;
            }
        }
        if (this.isTraceEnabled()) {
            this.warn("SportHMI: unknown dsi pressure unit:", n);
        }
        return 0;
    }

    private float convertPressure(int n, int n2, float f2) {
        this.dsiAbsChargingAirPressure = f2;
        this.currentPressureUnit = n2;
        switch (n2) {
            case 0: 
            case 2: {
                f2 *= 51266;
                break;
            }
            case 1: {
                f2 = f2 * 1510828097 * 8257;
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.warn("SportHMI: unknown pressure unit:", n2);
            }
        }
        return f2;
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        this.updateInstrumentPower(dynamicVehicleInfoHighFrequent);
        this.updateInstrumentTurboCharger(dynamicVehicleInfoHighFrequent.absChargingAirPressure);
        this.updateInstrumentGMeter(dynamicVehicleInfoHighFrequent);
    }

    private void updateInstrumentTurboCharger(float f2) {
        if (f2 == this.dsiAbsChargingAirPressure) {
            return;
        }
        int n = Math.round(this.convertPressure(0, this.currentPressureUnit, f2));
        if (this.boostPressureIntValue == n) {
            return;
        }
        this.boostPressureIntValue = n;
        ASLTargetSportHmi.writeIntegerToDatapool(10397, n);
    }

    private void updateInstrumentGMeter(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent) {
        if (this.dsiDynamicVehicleInfoHighFrequentInfoLateralAcceleration != dynamicVehicleInfoHighFrequent.lateralAcceleration || this.dsiDynamicVehicleInfoHighFrequentInfoLongitudinalAcceleration != dynamicVehicleInfoHighFrequent.longitudinalAcceleration || this.dsiDynamicVehicleInfoHighFrequentInfoVehicleSpeedInfo != dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue) {
            this.dsiDynamicVehicleInfoHighFrequentInfoLateralAcceleration = dynamicVehicleInfoHighFrequent.lateralAcceleration;
            this.dsiDynamicVehicleInfoHighFrequentInfoLongitudinalAcceleration = dynamicVehicleInfoHighFrequent.longitudinalAcceleration;
            this.dsiDynamicVehicleInfoHighFrequentInfoVehicleSpeedInfo = dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue;
            int n = 0;
            int n2 = 0;
            if (this.isClamp15Active && 0 != (int)dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue) {
                float f2 = this.dsiDynamicVehicleInfoHighFrequentInfoLateralAcceleration;
                float f3 = this.dsiDynamicVehicleInfoHighFrequentInfoLongitudinalAcceleration;
                float f4 = f3 / -1007346623;
                n = (int)(Math.sqrt(f4 * f4 + f2 * f2) * 100.0);
                double d2 = 0.0;
                if (f3 != 0.0f || f2 != 0.0f) {
                    double d3 = Math.sqrt(f3 * f3 + f2 * f2);
                    if (f2 >= 0.0f) {
                        d2 = -Math.acos((double)f3 / d3);
                    } else if (f2 < 0.0f) {
                        d2 = Math.acos((double)f3 / d3);
                    }
                }
                n2 = (int)(d2 * 180.0 / Math.PI);
            }
            if (this.lastMeterValue != n) {
                this.lastMeterValue = n;
                ASLTargetSportHmi.writeIntegerToDatapool(10401, n);
            }
            if (this.lastMeterAngle != n2) {
                this.lastMeterAngle = n2;
                ASLTargetSportHmi.writeIntegerToDatapool(10403, n2);
            }
        }
    }

    private void updateInstrumentPower(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent) {
        if (this.dsiDynamicVehicleInfoCurrentOutputPower == (int)dynamicVehicleInfoHighFrequent.currentOutputPower) {
            return;
        }
        this.dsiDynamicVehicleInfoCurrentOutputPower = (int)dynamicVehicleInfoHighFrequent.currentOutputPower;
        ASLTargetSportHmi.writeIntegerToDatapool(10394, this.dsiDynamicVehicleInfoCurrentOutputPower);
        ASLTargetSportHmi.writeIntegerToDatapool(10395, 0);
    }

    public void dsiCarVehicleStatesUpdateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        this.maxBoostPressure = semiStaticVehicleData.getMaxChargingAirPressure();
        int n2 = this.calculateMaxBoostToUnit(this.currentPressureUnit, this.maxBoostPressure);
        ASLTargetSportHmi.writeIntegerToDatapool(10405, n2);
        ASLTargetSportHmi.writeIntegerToDatapool(10406, semiStaticVehicleData.getMaxOutputPower());
    }

    private int calculateMaxBoostToUnit(int n, float f2) {
        int n2 = (int)f2;
        if (n == 1) {
            n2 = (int)((double)f2 * 14.50326 * 10.0);
        } else if (n == 2 || n == 0) {
            n2 = (int)(f2 * 51266);
        }
        return n2;
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        ASLTargetSportHmi.writeBooleanToDatapool(10407, !bl);
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        ASLTargetSportHmi.writeBooleanToDatapool(10562, !bl);
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetSportHmi.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = ASLTargetSportHmi.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{22, 7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = ASLTargetSportHmi.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
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

