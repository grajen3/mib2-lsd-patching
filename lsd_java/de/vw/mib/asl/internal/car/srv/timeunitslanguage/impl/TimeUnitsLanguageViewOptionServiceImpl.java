/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeUnitsLanguageViewOptionListener;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeUnitsLanguageViewOptionService;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl.TimeViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl.UnitsViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class TimeUnitsLanguageViewOptionServiceImpl
extends CarEmptyTarget
implements TimeUnitsLanguageViewOptionService,
DeviceManagerListener {
    public static final int ATTR_CLOCKVIEWOPTIONS;
    public static final int ATTR_UNITMASTERVIEWOPTIONS;
    private static TimeUnitsLanguageViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarTimeUnitsLanguage dsiCarTiemUnitsLanguage;
    private DSICarTimeUnitsLanguageListener viewOptionsListener;
    private int timeDeviceReason;
    private int unitsDeviceReason;
    private final int[] reasons = new int[6];
    private ClockViewOptions myClockViewOptions = new ClockViewOptions();
    private UnitmasterViewOptions myUnitMasterViewOptions = new UnitmasterViewOptions();
    private TimeViewOptionsWrapper timeViewOptionsWrapper;
    private UnitsViewOptionsWrapper unitsViewOptionsWrapper;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;

    private TimeUnitsLanguageViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
        this.initClockTimeMasterViewOptions();
    }

    private void initDSI() {
        this.dsiCarTiemUnitsLanguage = (DSICarTimeUnitsLanguage)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = TimeUnitsLanguageViewOptionServiceImpl.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        this.viewOptionsListener = (DSICarTimeUnitsLanguageListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = TimeUnitsLanguageViewOptionServiceImpl.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarTiemUnitsLanguage.setNotification(n, (DSIListener)this.viewOptionsListener);
    }

    public static TimeUnitsLanguageViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new TimeUnitsLanguageViewOptionServiceImpl();
        }
        return instance;
    }

    @Override
    public void addListener(TimeUnitsLanguageViewOptionListener timeUnitsLanguageViewOptionListener) {
        this.listeners.add(timeUnitsLanguageViewOptionListener);
    }

    @Override
    public void removeListener(TimeUnitsLanguageViewOptionListener timeUnitsLanguageViewOptionListener) {
        this.listeners.removeValue(timeUnitsLanguageViewOptionListener);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        this.myClockViewOptions = clockViewOptions;
        this.checkingViewOptions();
    }

    public void dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        this.myUnitMasterViewOptions = unitmasterViewOptions;
        this.unitsViewOptionsWrapper = new UnitsViewOptionsWrapper(unitmasterViewOptions);
        this.checkingViewOptions();
        int n2 = 0;
        int n3 = 0;
        if (unitmasterViewOptions.getDistanceUnit().getState() == 2 || unitmasterViewOptions.getPressureUnit().getState() == 2 || unitmasterViewOptions.getSpeedUnit().getState() == 2 || unitmasterViewOptions.getTemperatureUnit().getState() == 2 || unitmasterViewOptions.getVolumeUnit().getState() == 2 || unitmasterViewOptions.getConsumptionGasUnit().getState() == 2 || unitmasterViewOptions.getConsumptionPetrolUnit().getState() == 2) {
            n2 = 2;
        } else if (unitmasterViewOptions.getDistanceUnit().getState() == 0 && unitmasterViewOptions.getPressureUnit().getState() == 0 && unitmasterViewOptions.getSpeedUnit().getState() == 0 && unitmasterViewOptions.getTemperatureUnit().getState() == 0 && unitmasterViewOptions.getVolumeUnit().getState() == 0 && unitmasterViewOptions.getConsumptionGasUnit().getState() == 0 && unitmasterViewOptions.getConsumptionPetrolUnit().getState() == 0) {
            n2 = 0;
        } else {
            n2 = 1;
            if (unitmasterViewOptions.getDistanceUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getDistanceUnit().getReason());
            }
            if (unitmasterViewOptions.getPressureUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getPressureUnit().getReason());
            }
            if (unitmasterViewOptions.getSpeedUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getSpeedUnit().getReason());
            }
            if (unitmasterViewOptions.getTemperatureUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getTemperatureUnit().getReason());
            }
            if (unitmasterViewOptions.getVolumeUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getVolumeUnit().getReason());
            }
            if (unitmasterViewOptions.getConsumptionGasUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getConsumptionGasUnit().getReason());
            }
            if (unitmasterViewOptions.getConsumptionPetrolUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getConsumptionPetrolUnit().getReason());
            }
            n3 = this.gettingHighestReason();
            this.clearReasons();
        }
        this.unitsViewOptionsWrapper.setUnits(new CarViewOption(n2, n3));
        if (this.unitsDeviceReason == 0) {
            this.notifyUnitsListeners(0);
        }
    }

    private void notifyUnitsListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            TimeUnitsLanguageViewOptionListener timeUnitsLanguageViewOptionListener = (TimeUnitsLanguageViewOptionListener)iterator.next();
            if (this.unitsViewOptionsWrapper == null) {
                timeUnitsLanguageViewOptionListener.updateUnitsDevice(n);
                if (this.unitsDeviceReason != 14) continue;
                this.unitsDeviceReason = 0;
                continue;
            }
            if (this.unitsDeviceReason == 14) {
                this.unitsDeviceReason = 0;
                return;
            }
            timeUnitsLanguageViewOptionListener.updateUnitsViewOptions(this.unitsViewOptionsWrapper, n);
        }
    }

    private void notifyTimeListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            TimeUnitsLanguageViewOptionListener timeUnitsLanguageViewOptionListener = (TimeUnitsLanguageViewOptionListener)iterator.next();
            if (this.timeViewOptionsWrapper == null) {
                timeUnitsLanguageViewOptionListener.updateClockDevice(n);
                if (this.timeDeviceReason != 14) continue;
                this.timeDeviceReason = 0;
                continue;
            }
            if (this.timeDeviceReason == 14) {
                this.timeDeviceReason = 0;
                return;
            }
            timeUnitsLanguageViewOptionListener.updateClockViewOptions(this.timeViewOptionsWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 290) {
            this.timeDeviceReason = n2;
            if (n2 != 0) {
                this.notifyTimeListeners(n2);
            } else {
                this.notifyTimeListeners(0);
            }
        }
        if (n == 305) {
            this.unitsDeviceReason = n2;
            if (n2 != 0) {
                this.notifyUnitsListeners(n2);
            } else {
                this.notifyUnitsListeners(0);
            }
        }
    }

    private void checkingViewOptions() {
        this.timeViewOptionsWrapper = new TimeViewOptionsWrapper(this.myClockViewOptions);
        int n = 0;
        int n2 = 0;
        if (this.myClockViewOptions.getTime().getState() == 2 || this.myClockViewOptions.getDate().getState() == 2 || this.myClockViewOptions.getTimeZone().getState() == 2 || this.myClockViewOptions.getDayLightSaving().getState() == 2 || this.myClockViewOptions.getDayLightSavingData().getState() == 2 || this.myClockViewOptions.getClockSource().getState() == 2 || this.myClockViewOptions.getGpsSyncData().getState() == 2 || this.myUnitMasterViewOptions.getClockFormat().getState() == 2 || this.myUnitMasterViewOptions.getDateFormat().getState() == 2) {
            n = 2;
        } else if (this.myClockViewOptions.getTime().getState() == 0 && this.myClockViewOptions.getDate().getState() == 0 && this.myClockViewOptions.getTimeZone().getState() == 0 && this.myClockViewOptions.getDayLightSaving().getState() == 0 && this.myClockViewOptions.getDayLightSavingData().getState() == 0 && this.myClockViewOptions.getClockSource().getState() == 0 && this.myClockViewOptions.getGpsSyncData().getState() == 0 && this.myUnitMasterViewOptions.getClockFormat().getState() == 0 && this.myUnitMasterViewOptions.getDateFormat().getState() == 0) {
            n = 0;
        } else {
            n = 1;
            if (this.myClockViewOptions.getTime().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getTime().getReason());
            }
            if (this.myClockViewOptions.getDate().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDate().getReason());
            }
            if (this.myClockViewOptions.getTimeZone().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getTimeZone().getReason());
            }
            if (this.myClockViewOptions.getDayLightSaving().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDayLightSaving().getReason());
            }
            if (this.myClockViewOptions.getDayLightSavingData().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDayLightSavingData().getReason());
            }
            if (this.myClockViewOptions.getClockSource().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getClockSource().getReason());
            }
            if (this.myClockViewOptions.getGpsSyncData().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getGpsSyncData().getReason());
            }
            if (this.myUnitMasterViewOptions.getClockFormat().getState() != 2) {
                this.collectingReason(this.myUnitMasterViewOptions.getClockFormat().getReason());
            }
            if (this.myUnitMasterViewOptions.getDateFormat().getState() != 2) {
                this.collectingReason(this.myUnitMasterViewOptions.getDateFormat().getReason());
            }
            n2 = this.gettingHighestReason();
            this.clearReasons();
        }
        this.timeViewOptionsWrapper.setTime(new CarViewOption(n, n2));
        if (this.timeDeviceReason == 0) {
            this.notifyTimeListeners(0);
        }
    }

    private void collectingReason(int n) {
        switch (n) {
            case 2: {
                this.reasons[0] = 2;
                break;
            }
            case 3: {
                this.reasons[1] = 3;
                break;
            }
            case 4: {
                this.reasons[2] = 4;
                break;
            }
            case 8: {
                this.reasons[3] = 8;
                break;
            }
            case 1: {
                this.reasons[4] = 1;
                break;
            }
            default: {
                this.reasons[5] = 1;
            }
        }
    }

    private int gettingHighestReason() {
        int n = 0;
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            if (this.reasons[i2] == 0) continue;
            n = this.reasons[i2];
            break;
        }
        return n;
    }

    private void clearReasons() {
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            this.reasons[i2] = 0;
        }
    }

    private void initClockTimeMasterViewOptions() {
        this.myClockViewOptions.time = new CarViewOption(0, 1);
        this.myClockViewOptions.date = new CarViewOption(0, 1);
        this.myClockViewOptions.timeZone = new CarViewOption(0, 1);
        this.myClockViewOptions.dayLightSaving = new CarViewOption(0, 1);
        this.myClockViewOptions.dayLightSavingData = new CarViewOption(0, 1);
        this.myClockViewOptions.clockSource = new CarViewOption(0, 1);
        this.myClockViewOptions.gpsSyncData = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.clockFormat = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.dateFormat = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.distanceUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.pressureUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.speedUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.temperatureUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.volumeUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.consumptionGasUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.consumptionPetrolUnit = new CarViewOption(0, 1);
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

