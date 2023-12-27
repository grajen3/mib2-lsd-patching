/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.car.light.transformer.AmbienceLightAreaCollector;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import generated.de.vw.mib.asl.internal.car.ASLCarPropertyManager;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public final class ASLCarContainer {
    private static final ASLCarContainer ASL_CAR_CONTAINER = new ASLCarContainer();
    private DSIProxy dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private DSIProxyAdapterFactory adapterFactory = DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory();
    public static int DP_ILLUMINATION_FOOTWELL_FRONT;
    public static int DP_ILLUMINATION_DOORS_FRONTWELL_FRONT;
    public static int DP_ILLUMINATION_COCKPIT;
    public static int DP_ILLUMINATION_ALL_SYNC;
    public static int DP_ILLUMINATION_ROOF_FRONT;
    public static int DP_ILLUMINATION_ROOF_FRONT_REAR;
    public static int DP_ILLUMINATION_CENTER_CONSOLE;
    public static int DP_ILLUMINATION_FOOTWELL_FRONT_REAR;
    public static int DP_ILLUMINATION_FOOTWELL_REAR;
    public static int DP_ILLUMINATION_ROOF_REAR;
    public static int NOT_DOORS_FOOTWELLREAR;
    public static int DP_ILLUMINATION_DOORS_FRONT_REAR;
    public static int DP_ILLUMINATION_FRONT;
    public static int DP_ILLUMINATION_INT_SETTINGS_1;
    public static int DP_ILLUMINATION_INT_SETTINGS_2;
    public static int DP_ILLUMINATION_INT_SETTINGS_3;
    public static int DP_ILLUMINATION_INT_SETTINGS_4;
    public static int DP_ILLUMINATION_INT_SETTINGS_5;
    public static int DP_ILLUMINATION_INT_SETTINGS_6;
    public static int DP_ILLUMINATION_INT_SETTINGS_7;
    public static int DP_ILLUMINATION_INT_SETTINGS_8;
    public static AmbienceLightAreaCollector[] LIGHT_AREAR_COLLECTOR;
    public static int STEP_HOUR;
    public static int STEP_MINUTES;
    public static int HOUR_IN_MINUTES;
    public static final int WEEKDAY_SUNDAY;
    public static final int WEEKDAY_MONDAY;
    public static final int WEEKDAY_TUESDAY;
    public static final int WEEKDAY_WEDNESDAY;
    public static final int WEEKDAY_THURSDAY;
    public static final int WEEKDAY_FRIDAY;
    public static final int WEEKDAY_SATURDAY;
    public static boolean[] functionExistent;
    public static CarFunctionCollector[] collector;
    public static CarFunctionCollector[] tempCollector;
    public static CarFunctionCollector[] oldSettings;
    private boolean[] menuCoding = new boolean[38];
    private boolean[] speedThreshold = new boolean[38];
    private boolean[] standstill = new boolean[38];
    private int numberOfWindows;
    private boolean sunRoof;
    private int awvSystem;
    private ClockDate myDate = new ClockDate();
    private int lastDay;
    private ClockTime mainUnitTime = new ClockTime();

    public static ASLCarContainer getInstance() {
        return ASL_CAR_CONTAINER;
    }

    private ASLCarContainer() {
    }

    public DSIProxyAdapterFactory getAdapterFactory() {
        return this.adapterFactory;
    }

    public DSIProxy getDSIProxy() {
        return this.dsiProxy;
    }

    public void setNumberOfWindows(int n) {
        this.numberOfWindows = n;
    }

    public int getNumberOfWindows() {
        return this.numberOfWindows;
    }

    public void setSunRoofAvailable(boolean bl) {
        this.sunRoof = bl;
    }

    public boolean getSunRoofAvailable() {
        return this.sunRoof;
    }

    public void setMenuCoding(int n, boolean bl) {
        this.menuCoding[n] = bl;
    }

    public boolean[] getMenuCoding() {
        return this.menuCoding;
    }

    public boolean isMenuCoded(int n) {
        return this.menuCoding[n];
    }

    public int getMenuCodingLength() {
        return this.menuCoding.length;
    }

    public void setMenuSpeedThreshold(int n, boolean bl) {
        this.speedThreshold[n] = bl;
    }

    public boolean[] getMenuSpeedThreshold() {
        return this.speedThreshold;
    }

    public void setMenuStandStill(int n, boolean bl) {
        this.standstill[n] = bl;
    }

    public boolean[] getMenuStandStill() {
        return this.standstill;
    }

    public void setMainUnitDate(ClockDate clockDate) {
        this.myDate = clockDate;
    }

    public ClockDate getMainUnitDate() {
        return this.myDate;
    }

    public void setLastDayInWeek(int n) {
        this.lastDay = n;
    }

    public int getLastDayInWeek() {
        return this.lastDay;
    }

    public void setMainUnitTime(ClockTime clockTime) {
        this.mainUnitTime = clockTime;
    }

    public ClockTime getMainUnitTime() {
        return this.mainUnitTime;
    }

    static {
        DP_ILLUMINATION_INT_SETTINGS_1 = 1;
        DP_ILLUMINATION_INT_SETTINGS_2 = 2;
        DP_ILLUMINATION_INT_SETTINGS_3 = 3;
        DP_ILLUMINATION_INT_SETTINGS_4 = 4;
        DP_ILLUMINATION_INT_SETTINGS_5 = 5;
        DP_ILLUMINATION_INT_SETTINGS_6 = 6;
        DP_ILLUMINATION_INT_SETTINGS_7 = 7;
        DP_ILLUMINATION_INT_SETTINGS_8 = 8;
        STEP_HOUR = 1;
        STEP_MINUTES = 5;
        HOUR_IN_MINUTES = 60;
        functionExistent = new boolean[ASLCarPropertyManager.FUNCTION_EXISTENT_STATE__DEFAULT_VALUE.length];
        collector = new CarFunctionCollector[ASLCarPropertyManager.FUNCTION_EXISTENT_STATE__DEFAULT_VALUE.length];
        tempCollector = new CarFunctionCollector[ASLCarPropertyManager.FUNCTION_EXISTENT_STATE__DEFAULT_VALUE.length];
        oldSettings = new CarFunctionCollector[ASLCarPropertyManager.FUNCTION_EXISTENT_STATE__DEFAULT_VALUE.length];
    }
}

