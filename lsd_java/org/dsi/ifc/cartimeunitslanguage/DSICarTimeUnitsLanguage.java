/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

public interface DSICarTimeUnitsLanguage
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_CLOCKVIEWOPTIONS;
    public static final int ATTR_CLOCKDATE;
    public static final int ATTR_CLOCKTIME;
    public static final int ATTR_CLOCKSOURCE;
    public static final int ATTR_CLOCKDAYLIGHTSAVING;
    public static final int ATTR_CLOCKDAYLIGHTSAVINGDATA;
    public static final int ATTR_CLOCKTIMEZONEOFFSET;
    public static final int ATTR_CLOCKTIMESOURCESAVAILABLE;
    public static final int ATTR_CLOCKGPSSYNCDATA;
    public static final int ATTR_UNITMASTERVIEWOPTIONS;
    public static final int ATTR_MENULANGUAGE;
    public static final int ATTR_TEMPERATUREUNIT;
    public static final int ATTR_DISTANCEUNIT;
    public static final int ATTR_SPEEDUNIT;
    public static final int ATTR_PRESSUREUNIT;
    public static final int ATTR_VOLUMEUNIT;
    public static final int ATTR_CONSUMPTIONPETROLUNIT;
    public static final int ATTR_CONSUMPTIONGASUNIT;
    public static final int ATTR_CLOCKFORMAT;
    public static final int ATTR_DATEFORMAT;
    public static final int ATTR_UTCOFFSET;
    public static final int ATTR_CONSUMPTIONELECTRICUNIT;
    public static final int ATTR_SKIN;
    public static final int ATTR_WEIGHTUNIT;
    public static final int VOLUMEGASUNIT_LBS;
    public static final int VOLUMEGASUNIT_M3;
    public static final int VOLUMEGASUNIT_YARD3;
    public static final int VOLUMEGASUNIT_KG;
    public static final int DATEFORMAT_DAY_MONTH_YEAR;
    public static final int DATEFORMAT_MONTH_DAY_YEAR;
    public static final int DATEFORMAT_YEAR_MONTH_DAY;
    public static final int CLOCKFORMAT_24H;
    public static final int CLOCKFORMAT_12AMPM;
    public static final int CONSUMPTIONUNITELECTRICKWHPMSUPPORT_NOTSUPPORTED;
    public static final int CONSUMPTIONUNITELECTRICKWHPMSUPPORT_SUPPORTED;
    public static final int CONSUMPTIONUNITMPGUSESUPPORT_NOTSUPPORTED;
    public static final int CONSUMPTIONUNITMPGUSESUPPORT_SUPPORTED;
    public static final int MENULANGUAGE_GERMAN;
    public static final int MENULANGUAGE_ENGLISH_UK;
    public static final int MENULANGUAGE_ENGLISH_US;
    public static final int MENULANGUAGE_FRENCH;
    public static final int MENULANGUAGE_ITALIAN;
    public static final int MENULANGUAGE_SPANISH;
    public static final int MENULANGUAGE_PORTUGUESE;
    public static final int MENULANGUAGE_POLISH;
    public static final int MENULANGUAGE_CZECH;
    public static final int MENULANGUAGE_HUNGARIAN;
    public static final int MENULANGUAGE_DANISH;
    public static final int MENULANGUAGE_SWEDISH;
    public static final int MENULANGUAGE_FINNISH;
    public static final int MENULANGUAGE_DUTCH;
    public static final int MENULANGUAGE_CHINESE_TRADITIONAL;
    public static final int MENULANGUAGE_JAPANESE;
    public static final int MENULANGUAGE_RUSSIAN;
    public static final int MENULANGUAGE_GREEK;
    public static final int MENULANGUAGE_KOREAN;
    public static final int MENULANGUAGE_FRENCH_CANADIAN;
    public static final int MENULANGUAGE_SPANISH_US;
    public static final int MENULANGUAGE_PORTUGUESE_US;
    public static final int MENULANGUAGE_TURKISH;
    public static final int MENULANGUAGE_CHINESE_MANDARIN;
    public static final int MENULANGUAGE_CHINESE_CANTONESE;
    public static final int MENULANGUAGE_ARABIC;
    public static final int MENULANGUAGE_PORTUGUESE_BRAZIL;
    public static final int MENULANGUAGE_MALAYSIAN;
    public static final int MENULANGUAGE_THAI;
    public static final int MENULANGUAGE_NORWEGIAN;
    public static final int MENULANGUAGE_CROATIAN;
    public static final int MENULANGUAGE_SERBIAN;
    public static final int MENULANGUAGE_SLOVAK;
    public static final int MENULANGUAGE_ROMANIAN;
    public static final int MENULANGUAGE_HINDI;
    public static final int MENULANGUAGE_INDONESIAN;
    public static final int MENULANGUAGE_AZERBAIJANIAN;
    public static final int MENULANGUAGE_BOSNIAN;
    public static final int MENULANGUAGE_SLOWENIAN;
    public static final int MENULANGUAGE_BULGARIAN;
    public static final int MENULANGUAGE_LATVIAN;
    public static final int MENULANGUAGE_ESTONIAN;
    public static final int MENULANGUAGE_LITHUANIAN;
    public static final int MENULANGUAGE_UKRAINIAN;
    public static final int CLOCKSOURCE_NOTVALID;
    public static final int CLOCKSOURCE_QUARTZ;
    public static final int CLOCKSOURCE_DCF77;
    public static final int CLOCKSOURCE_GPS;
    public static final int CLOCKDAYLIGHTSAVINGMODE_NONE;
    public static final int CLOCKDAYLIGHTSAVINGMODE_PLUSONEHOUR;
    public static final int CLOCKDAYLIGHTSAVINGMODE_MESZ;
    public static final int CLOCKDAYLIGHTSAVINGMODE_USA;
    public static final int CLOCKDAYLIGHTSAVINGMODE_NAVIGATION_DB;
    public static final int TIME_INVALID;
    public static final int TIME_SUMMERTIME;
    public static final int TIME_WINTERTIME;
    public static final int UTCOFFSETSTATE_INVALID;
    public static final int UTCOFFSETSTATE_VALID_NOT_SYNCED_TO_UTC;
    public static final int UTCOFFSETSTATE_VALID_SYNCED_TO_UTC;
    public static final int SKIN_SKIN1;
    public static final int SKIN_SKIN2;
    public static final int SKIN_SKIN3;
    public static final int SKIN_UNKNOWN;
    public static final int RT_SETCLOCKDATE;
    public static final int RT_SETCLOCKTIME;
    public static final int RT_SETCLOCKSOURCE;
    public static final int RT_SETCLOCKDAYLIGHTSAVING;
    public static final int RT_SETCLOCKTIMEZONEOFFSET;
    public static final int RT_SETCLOCKGPSSYNCDATA;
    public static final int RT_SETMENULANGUAGE;
    public static final int RT_SETPRESSUREUNIT;
    public static final int RT_SETVOLUMEUNIT;
    public static final int RT_SETTEMPERATUREUNIT;
    public static final int RT_SETDISTANCEUNIT;
    public static final int RT_SETSPEEDUNIT;
    public static final int RT_SETCONSUMPTIONPETROLUNIT;
    public static final int RT_SETCONSUMPTIONGASUNIT;
    public static final int RT_SETCLOCKFORMAT;
    public static final int RT_SETDATEFORMAT;
    public static final int RT_SETUMSETFACTORYDEFAULT;
    public static final int RT_SETCONSUMPTIONELECTRICUNIT;
    public static final int RT_SETSKIN;
    public static final int RT_SETCLOCKSUMMERTIMEDATA;
    public static final int RT_SETWEIGHTUNIT;
    public static final int RP_ACKNOWLEDGEUMSETFACTORYDEFAULT;

    default public void setMenuLanguage(int n) {
    }

    default public void setPressureUnit(int n) {
    }

    default public void setVolumeUnit(int n) {
    }

    default public void setTemperatureUnit(int n) {
    }

    default public void setDistanceUnit(int n) {
    }

    default public void setSpeedUnit(int n) {
    }

    default public void setConsumptionPetrolUnit(int n) {
    }

    default public void setConsumptionGasUnit(int n) {
    }

    default public void setConsumptionElectricUnit(int n) {
    }

    default public void setClockFormat(int n) {
    }

    default public void setDateFormat(int n) {
    }

    default public void setClockDate(ClockDate clockDate) {
    }

    default public void setClockTime(byte by, byte by2, byte by3) {
    }

    default public void setClockSource(int n) {
    }

    default public void setClockDayLightSaving(boolean bl) {
    }

    default public void setClockTimeZoneOffset(float f2) {
    }

    default public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
    }

    default public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
    }

    default public void setUmSetFactoryDefault() {
    }

    default public void setSkin(int n) {
    }

    default public void setWeightUnit(int n) {
    }
}

