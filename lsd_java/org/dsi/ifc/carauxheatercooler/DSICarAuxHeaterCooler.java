/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public interface DSICarAuxHeaterCooler
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AUXHEATERCOOLERVIEWOPTIONS;
    public static final int ATTR_AUXHEATERCOOLERSTATE;
    public static final int ATTR_AUXHEATERCOOLERONOFF;
    public static final int ATTR_AUXHEATERCOOLERREMAININGTIME;
    public static final int ATTR_AUXHEATERCOOLERRUNNINGTIME;
    public static final int ATTR_AUXHEATERCOOLERMODE;
    public static final int ATTR_AUXHEATERCOOLERENGINEHEATER;
    public static final int ATTR_AUXHEATERCOOLERACTIVETIMER;
    public static final int ATTR_AUXHEATERCOOLERTIMER1;
    public static final int ATTR_AUXHEATERCOOLERTIMER2;
    public static final int ATTR_AUXHEATERCOOLERTIMER3;
    public static final int ATTR_AUXHEATERCOOLERDEFAULTSTARTMODE;
    public static final int ATTR_AUXHEATERCOOLERERRORREASON;
    public static final int ATTR_AUXHEATERCOOLERCURRENTHEATERSTATE;
    public static final int ATTR_AUXHEATERCOOLERPOPUP;
    public static final int ATTR_AUXHEATERCOOLERMODE2;
    public static final int ATTR_AUXHEATERCOOLEREXTENDEDCONDITIONING;
    public static final int ATTR_AUXHEATERCOOLERWINDOWHEATING;
    public static final int ATTR_AUXHEATERCOOLERUNLOCKCLIMATING;
    public static final int ATTR_AUXHEATERCOOLERTARGETTEMPERATURE;
    public static final int ATTR_AUXHEATERCOOLERAIRQUALITY;
    public static final int TIMERMODE_STARTTIMER;
    public static final int TIMERMODE_GOALTIMER;
    public static final int AUXHEATERCOOLERSTATE_OFF;
    public static final int AUXHEATERCOOLERSTATE_HEATING;
    public static final int AUXHEATERCOOLERSTATE_VENTILATION;
    public static final int AUXHEATERCOOLERHEATERSTATE_OK;
    public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOW;
    public static final int AUXHEATERCOOLERHEATERSTATE_BATTERYLOW;
    public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOWBATTERYLOW;
    public static final int AUXHEATERCOOLERHEATERSTATE_HEATERDEFECT;
    public static final int AUXHEATERCOOLERACTIVETIMER_NONE;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER1;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER2;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER3;
    public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_VENTILATION;
    public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_HEATING;
    public static final int AUXHEATERCOOLERDATEMODE_ABSOLUTEDATE;
    public static final int AUXHEATERCOOLERDATEMODE_RELATIVEDATE;
    public static final int AUXHEATERCOOLERDATEMODE_WEEKDATE;
    public static final int AUXHEATERCOOLERDATEMODE_NEXTOCCURENCE;
    public static final int AUXHEATERCOOLERMODE_ECONOMY;
    public static final int AUXHEATERCOOLERMODE_NORMAL;
    public static final int AUXHEATERCOOLERMODE_COMFORT;
    public static final int AUXHEATERCOOLERREASON_NOREASON;
    public static final int AUXHEATERCOOLERREASON_IMMEDIATESTARTUP;
    public static final int AUXHEATERCOOLERREASON_TIMER1;
    public static final int AUXHEATERCOOLERREASON_TIMER2;
    public static final int AUXHEATERCOOLERREASON_TIMER3;
    public static final int AUXHEATERCOOLERPOPUP_NONE;
    public static final int AUXHEATERCOOLERPOPUP_CHANGEAUXHEATERTIMERORSTARTAUXHEATER;
    public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_OFF;
    public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_ON;
    public static final int RT_SETAUXHEATERCOOLERONOFF;
    public static final int RT_SETAUXHEATERCOOLERRUNNINGTIME;
    public static final int RT_SETAUXHEATERCOOLERMODE;
    public static final int RT_SETAUXHEATERCOOLERENGINEHEATER;
    public static final int RT_SETAUXHEATERCOOLERACTIVETIMER;
    public static final int RT_SETAUXHEATERCOOLERTIMER1;
    public static final int RT_SETAUXHEATERCOOLERTIMER2;
    public static final int RT_SETAUXHEATERCOOLERTIMER3;
    public static final int RT_SETAUXHEATERSETFACTORYDEFAULT;
    public static final int RT_SETAUXHEATERCOOLERDEFAULTSTARTMODE;
    public static final int RT_SETAUXHEATERCOOLEREXTENDEDCONDITIONING;
    public static final int RT_SETAUXHEATERCOOLERWINDOWHEATING;
    public static final int RT_SETAUXHEATERCOOLERUNLOCKCLIMATING;
    public static final int RT_SETAUXHEATERCOOLERTARGETTEMPERATURE;
    public static final int RT_SETAUXHEATERCOOLERAIRQUALITY;
    public static final int RT_SETAUXHEATERCOOLERPOPUP;
    public static final int RP_ACKNOWLEDGEAUXHEATERSETFACTORYDEFAULT;

    default public void setAuxHeaterCoolerOnOff(boolean bl) {
    }

    default public void setAuxHeaterCoolerRunningTime(short s) {
    }

    default public void setAuxHeaterCoolerMode(int n) {
    }

    default public void setAuxHeaterCoolerDefaultStartMode(int n) {
    }

    default public void setAuxHeaterCoolerEngineHeater(boolean bl) {
    }

    default public void setAuxHeaterCoolerActiveTimer(int n) {
    }

    default public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
    }

    default public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
    }

    default public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
    }

    default public void setAuxHeaterCoolerPopup(int n) {
    }

    default public void setAuxHeaterSetFactoryDefault() {
    }

    default public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
    }

    default public void setAuxHeaterCoolerWindowHeating(boolean bl) {
    }

    default public void setAuxHeaterCoolerUnlockClimating(int n) {
    }

    default public void setAuxHeaterCoolerTargetTemperature(float f2) {
    }

    default public void setAuxHeaterCoolerAirQuality(boolean bl) {
    }
}

