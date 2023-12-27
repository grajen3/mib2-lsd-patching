/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.calc.table;

import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;

public final class ConditionsContainer {
    public static final int COND_CURR_GEAR_NULL;
    public static final int COND_CORR_GEAR;
    public static final int COND_WRONG_GEAR;
    public static final int COND_CLUTCH_IN;
    public static final int COND_CLUTCH_OUT;
    public static final int COND_ACCPEDAL_HIGH;
    public static final int COND_ACCPEDAL_LOW;
    public static final int COND_NO_STDSTILL_NO_RGEAR;
    public static final int COND_NO_BRAKE;
    public static final int COND_BRAKE;
    public static final int COND_NO_KICKDOWN;
    public static final int COND_KICKDOWN;
    public static final int COND_CORR_GEAR_LONGTERM;
    public static final int COND_CURR_CONS;
    public static final int COND_CURR_GEAR_ASG;
    public static final int COND_AUTO_GEAR_ASG_D_E;
    public static final int COND_AUTO_GEAR_B;
    public static final int COND_RECUP_LEVEL_ON;
    public static final int COND_AUTO_GEAR_D;
    public static final int COND_CONSUMPTION1_GREATER_THEN_ZERO_COMBUSTION_ELECTRIC;
    public static final int COND_CONSUMPTION2_GREATER_THEN_ZERO_COMBUSTION_ELECTRIC;
    public static final int COND_AUTO_GEAR_ASG_S;
    public static final int COND_AUTO_GEAR_ASG_N;
    public static final int COND_COASTING_ACTIVE;
    public static final int COND_AUTO_GEAR_OFFROAD;
    public static final int COND_AUTO_GEAR_E;
    public static final int COND_AUTO_GEAR_ASG_MS;
    public static final int COND_AUTO_GEAR_ASG_S_PLUS;
    public static final int COND_AUTO_GEAR_ASG_MS_PLUS;
    private static final int RGEAR_NOT_RECEIVED;
    private static final int RGEAR_TRUE;
    private static final int RGEAR_FALSE;
    private int rgear = -1;
    private static final int STANDSTILL_NOT_RECEIVED;
    private static final int STANDSTILL_TRUE;
    private static final int STANDSTILL_FALSE;
    private static final byte ACC_PEDAL_POS;
    private int standstill = -1;
    private static ConditionsContainer instance;
    public boolean[] conditions = new boolean[29];

    private ConditionsContainer() {
    }

    public static ConditionsContainer getInstance() {
        if (instance == null) {
            instance = new ConditionsContainer();
        }
        return instance;
    }

    public void refreshConditions(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent) {
        this.conditions[5] = dynamicVehicleInfoHighFrequent.acceleratorPosition > 2;
        this.conditions[6] = dynamicVehicleInfoHighFrequent.acceleratorPosition <= 2;
    }

    public void refreshConditions(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent) {
        this.conditions[0] = dynamicVehicleInfoMidFrequent.currentGear == 0;
        this.conditions[1] = dynamicVehicleInfoMidFrequent.currentGear == dynamicVehicleInfoMidFrequent.recommendedGear && dynamicVehicleInfoMidFrequent.currentGear > 0;
        this.conditions[2] = dynamicVehicleInfoMidFrequent.recommendedGear != dynamicVehicleInfoMidFrequent.currentGear;
        this.conditions[3] = dynamicVehicleInfoMidFrequent.clutch == 1;
        this.conditions[4] = dynamicVehicleInfoMidFrequent.clutch == 0;
        this.conditions[8] = !dynamicVehicleInfoMidFrequent.driverIsBraking;
        this.conditions[9] = dynamicVehicleInfoMidFrequent.driverIsBraking;
        this.conditions[10] = !dynamicVehicleInfoMidFrequent.acceleratorKickDown;
        this.conditions[11] = dynamicVehicleInfoMidFrequent.acceleratorKickDown;
        this.conditions[14] = dynamicVehicleInfoMidFrequent.currentGear >= 1 && dynamicVehicleInfoMidFrequent.currentGear <= 9;
        this.conditions[16] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 9;
        this.conditions[18] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 4;
        this.conditions[25] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 8;
        this.conditions[24] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 13;
        this.conditions[17] = dynamicVehicleInfoMidFrequent.recuperationLevel > 0;
        this.conditions[15] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 4 || dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 8;
        this.conditions[21] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 5;
        this.conditions[27] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 11;
        this.conditions[26] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 10;
        this.conditions[28] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 12;
        this.conditions[22] = dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode == 3 || dynamicVehicleInfoMidFrequent.coastingIsActive;
        this.conditions[23] = dynamicVehicleInfoMidFrequent.coastingIsActive;
    }

    public void refreshConditionsStandStill(boolean bl) {
        int n = this.standstill = bl ? 1 : 0;
        if (this.rgear == -1) {
            return;
        }
        this.conditions[7] = !bl && this.rgear == 0;
    }

    public void refreshConditionsRGear(boolean bl) {
        int n = this.rgear = bl ? 1 : 0;
        if (this.standstill == -1) {
            return;
        }
        this.conditions[7] = this.standstill == 0 && !bl;
    }

    public void refreshConditionCorrectGearLong(boolean bl) {
        this.conditions[12] = this.conditions[1] && bl;
    }

    public boolean refreshConditionsConsumption1(double d2) {
        return this.refreshConditionsConsumption(d2, 19);
    }

    public boolean refreshConditionsConsumption2(double d2) {
        return this.refreshConditionsConsumption(d2, 20);
    }

    private boolean refreshConditionsConsumption(double d2, int n) {
        boolean bl;
        boolean bl2 = this.conditions[n];
        boolean bl3 = d2 > 0.0 && d2 < 6553.5;
        boolean bl4 = bl = bl2 != bl3;
        if (bl) {
            this.conditions[n] = bl3;
        }
        return bl;
    }

    public String toString() {
        return new StringBuffer().append("ConditionsContainer [conditions=").append(this.conditions != null ? this.arrayToString(this.conditions, this.conditions.length) : null).append("]").toString();
    }

    private String arrayToString(Object object, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        for (int i2 = 0; i2 < n; ++i2) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            if (!(object instanceof boolean[])) continue;
            stringBuffer.append(((boolean[])object)[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

