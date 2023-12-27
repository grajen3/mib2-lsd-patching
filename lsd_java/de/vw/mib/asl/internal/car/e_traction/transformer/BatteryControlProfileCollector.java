/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlPowerProviderCollector;

public class BatteryControlProfileCollector {
    public int posId;
    public String profileName;
    public int targetChargeLevel;
    public int temperatureUnit;
    public int temperatureValue;
    public boolean isAirConditioning;
    public boolean autoDefrost;
    public boolean seatHeaterFrontLeft;
    public boolean seatHeaterFrontRight;
    public boolean seatHeaterRearLeft;
    public boolean seatHeaterRearRight;
    public boolean isCharing;
    private boolean isUsedByTimer;
    public boolean isWindowHeating;
    public boolean windowHeaterRear;
    private boolean parkHeater;
    public boolean parkHeaterAutomatic;
    public int maxCurrent;
    private int powerProviderId;
    private BatteryControlPowerProviderCollector powerProvider;
    public int minChargeLevel;
    private boolean climateWithoutExternalSupply;
    private int minRange;
    private int targetChargeDuration;
    private int targetChargeRange;
    private int unitRange;
    private boolean rangeCalculationSetup;
    public int leadTime;
    public int holdingTimePlug;
    public int holdingTimeBattery;
    private static final boolean IS_MLB = ServiceManager.configManagerDiag.isFeatureFlagSet(101);
    private static final int INVALID_POWER_PROVIDER_ID;
    public static final int MIDRANGE_VALUE_DEFAULT;
    public static final int TARGET_CHARGE_DURATION_VALUE_DEFAULT;
    public static final int TARGET_CHARGE_RANGE_VALUE_DEFAULT;
    public static final int UNIT_RANGE_VALUE_DEFAULT;
    public static final boolean RANGE_CALCULATION_SETUP_VALUE_DEFAULT;
    public static final int LEADTIME_VALUE_DEFAULT;
    public static final int HOLDING_TIME_PLUG_VALUE_DEFAULT;
    public static final int HOLDING_TIME_BATTERY_VALUE_DEFAULT;
    public static final boolean AUTO_DEFROST_DEFAULT;
    public static final boolean SEAT_HEATER_FRONT_LEFT_DEFAULT;
    public static final boolean SEAT_HEATER_FRONT_RIGHT_DEFAULT;
    public static final boolean SEAT_HEATER_REAR_LEFT_DEFAULT;
    public static final boolean SEAT_HEATER_REAR_RIGHT_DEFAULT;
    public static final boolean WINDOW_HEATER_REAR_DEFAULT;
    public static final boolean PARK_HEATER_AUTOMATIC_DEFAULT;
    private BatteryControlPowerProviderCollector cachedPowerProvider;
    private BatteryControlProfileCollector cachedProfileCopy;

    public BatteryControlProfileCollector() {
        this.posId = 0;
        this.temperatureValue = 0;
        this.temperatureUnit = 0;
        this.maxCurrent = 1;
        this.targetChargeLevel = 100;
        this.profileName = "";
        this.isAirConditioning = false;
        this.isCharing = false;
        this.isUsedByTimer = false;
        this.isWindowHeating = false;
        this.powerProviderId = 0;
        this.minChargeLevel = 0;
        this.climateWithoutExternalSupply = false;
        this.parkHeater = false;
        this.minRange = 0;
        this.targetChargeDuration = 0;
        this.targetChargeRange = 0;
        this.unitRange = 0;
        this.rangeCalculationSetup = false;
        this.leadTime = 0;
        this.holdingTimePlug = 0;
        this.holdingTimeBattery = 0;
        this.autoDefrost = false;
        this.seatHeaterFrontLeft = false;
        this.seatHeaterFrontRight = false;
        this.seatHeaterRearLeft = false;
        this.seatHeaterRearRight = false;
        this.windowHeaterRear = false;
        this.parkHeaterAutomatic = false;
    }

    public BatteryControlProfileCollector(int n, int n2, int n3, int n4, int n5, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, boolean bl5, boolean bl6, int n8, int n9, int n10, int n11, boolean bl7, int n12, int n13, int n14, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14) {
        this.posId = n;
        this.temperatureValue = n2;
        this.temperatureUnit = n3;
        this.maxCurrent = n4;
        this.targetChargeLevel = n5;
        this.profileName = string;
        this.isAirConditioning = bl;
        this.isCharing = bl2;
        this.isUsedByTimer = bl3;
        this.isWindowHeating = bl4;
        this.powerProviderId = n6;
        this.minChargeLevel = n7;
        this.climateWithoutExternalSupply = bl5;
        this.parkHeater = bl6;
        this.minRange = n8;
        this.targetChargeDuration = n9;
        this.targetChargeRange = n10;
        this.unitRange = n11;
        this.rangeCalculationSetup = bl7;
        this.leadTime = n12;
        this.holdingTimePlug = n13;
        this.holdingTimeBattery = n14;
        this.autoDefrost = bl8;
        this.seatHeaterFrontLeft = bl9;
        this.seatHeaterFrontRight = bl10;
        this.seatHeaterRearLeft = bl11;
        this.seatHeaterRearRight = bl12;
        this.windowHeaterRear = bl13;
        this.parkHeaterAutomatic = bl14;
    }

    public final BatteryControlProfileCollector copyCollector() {
        if (this.cachedProfileCopy == null) {
            BatteryControlProfileCollector batteryControlProfileCollector = this.copyCollector(this.posId, this.temperatureValue, this.temperatureUnit, this.maxCurrent, this.targetChargeLevel, this.profileName, this.isAirConditioning, this.isCharing, this.isUsedByTimer, this.isWindowHeating, this.powerProviderId, this.minChargeLevel, this.climateWithoutExternalSupply, this.parkHeater, this.minRange, this.targetChargeDuration, this.targetChargeRange, this.unitRange, this.rangeCalculationSetup, this.leadTime, this.holdingTimePlug, this.holdingTimeBattery, this.autoDefrost, this.seatHeaterFrontLeft, this.seatHeaterFrontRight, this.seatHeaterRearLeft, this.seatHeaterRearRight, this.windowHeaterRear, this.parkHeaterAutomatic);
            BatteryControlPowerProviderCollector batteryControlPowerProviderCollector = this.getPowerProvider();
            if (batteryControlPowerProviderCollector != null) {
                batteryControlProfileCollector.setPowerProvider(batteryControlPowerProviderCollector.copyCollector());
            }
            this.cachedProfileCopy = batteryControlProfileCollector;
        }
        return this.cachedProfileCopy;
    }

    protected BatteryControlProfileCollector copyCollector(int n, int n2, int n3, int n4, int n5, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, boolean bl5, boolean bl6, int n8, int n9, int n10, int n11, boolean bl7, int n12, int n13, int n14, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14) {
        return new BatteryControlProfileCollector(n, n2, n3, n4, n5, string, bl, bl2, bl3, bl4, n6, n7, bl5, bl6, n8, n9, n10, n11, bl7, n12, n13, n14, bl8, bl9, bl10, bl11, bl12, bl13, bl14);
    }

    public int getNR_StartHour() {
        if (this.powerProvider != null) {
            return this.powerProvider.NR_StartHour;
        }
        int n = this.cachedPowerProvider != null ? this.cachedPowerProvider.NR_StartHour : 0;
        return n;
    }

    public int getNR_StartMinutes() {
        int n = this.powerProvider != null ? this.powerProvider.NR_StartMinutes : (this.cachedPowerProvider != null ? this.cachedPowerProvider.NR_StartMinutes : 0);
        return n;
    }

    public int getNR_EndHour() {
        int n = this.powerProvider != null ? this.powerProvider.NR_EndHour : (this.cachedPowerProvider != null ? this.cachedPowerProvider.NR_EndHour : 0);
        return n;
    }

    public int getNR_EndMinutes() {
        int n = this.powerProvider != null ? this.powerProvider.NR_EndMinutes : (this.cachedPowerProvider != null ? this.cachedPowerProvider.NR_EndMinutes : 0);
        return n;
    }

    public boolean isNightRageChargingTimeValid() {
        return this.getNR_StartHour() != this.getNR_EndHour() || this.getNR_StartMinutes() != this.getNR_EndMinutes();
    }

    public boolean isNightRate() {
        if (!IS_MLB) {
            return this.powerProviderId != 0;
        }
        return this.isNightRageChargingTimeValid();
    }

    public BatteryControlPowerProviderCollector getPowerProvider() {
        return this.powerProvider;
    }

    public void setPowerProvider(BatteryControlPowerProviderCollector batteryControlPowerProviderCollector) {
        if (batteryControlPowerProviderCollector == null && this.powerProvider != null) {
            this.cachedPowerProvider = this.powerProvider.copyCollector();
        }
        this.powerProvider = batteryControlPowerProviderCollector;
        if (this.powerProvider != null) {
            this.setPowerProviderId(this.powerProvider.posID);
            this.cachedPowerProvider = null;
        } else {
            this.setPowerProviderId(0);
        }
    }

    protected void setPowerProviderId(int n) {
        this.powerProviderId = n;
        this.cachedProfileCopy = null;
    }

    public int getPowerProviderId() {
        return this.powerProviderId;
    }

    boolean isUsedByTimer() {
        return this.isUsedByTimer;
    }

    void setUsedByTimer(boolean bl) {
        this.isUsedByTimer = bl;
        this.cachedProfileCopy = null;
    }

    public int getMinChargeLevel() {
        return this.minChargeLevel;
    }

    public boolean isClimateWithoutExternalSupply() {
        return this.climateWithoutExternalSupply;
    }

    public void setClimateWithoutExternalSupply(boolean bl) {
        this.climateWithoutExternalSupply = bl;
    }

    public boolean isParkHeater() {
        return this.parkHeater;
    }

    public void setParkHeater(boolean bl) {
        this.parkHeater = bl;
        this.cachedProfileCopy = null;
    }

    public void setMinChargeLevel(int n) {
        this.minChargeLevel = n;
        this.cachedProfileCopy = null;
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void setTemperatureUnit(int n) {
        this.temperatureUnit = n;
        this.cachedProfileCopy = null;
    }

    public int getTemperatureValue() {
        return this.temperatureValue;
    }

    public void setTemperatureValue(int n) {
        this.temperatureValue = n;
        this.cachedProfileCopy = null;
    }

    public int getMinRange() {
        return this.minRange;
    }

    public int getTargetChargeDuration() {
        return this.targetChargeDuration;
    }

    public int getTargetChargeRange() {
        return this.targetChargeRange;
    }

    public int getUnitRange() {
        return this.unitRange;
    }

    public boolean isRangeCalculationSetup() {
        return this.rangeCalculationSetup;
    }
}

