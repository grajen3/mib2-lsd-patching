/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.SystemDateUtil;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.clock.PropagatingDateTimeService;
import de.vw.mib.asl.internal.system.AslTargetSystemDate$1;
import de.vw.mib.asl.internal.system.AslTargetSystemDate$2;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.internal.system.util.SystemUtil;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockConfig;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class AslTargetSystemDate
extends AbstractASLTarget {
    private DSICarTimeUnitsLanguage dsiCarTimeUnits;
    private boolean clamp15State = false;
    private boolean clockMenuClockFunctionsAvailable = true;
    private boolean clockMenuClockFunctionsAccessible = false;
    private boolean clockMenuUnitsFunctionsAvailable = true;
    private boolean clockMenuUnitsFunctionsAccessible = false;
    private boolean timezoneOptionAccessible = false;
    private boolean daylightSavingOptionAccessible = false;
    private boolean timeOptionAvailable = false;
    private boolean dateOptionAvailable = false;
    private boolean timeZoneOptionAvailable = false;
    private boolean timeMasterOptionAvailable = false;
    private boolean clockFormatExists = false;
    private boolean dateFormatExists = false;
    private int collectedViewOptionReasonsClock = 2;
    private int collectedViewOptionReasonsUnitmaster = 2;
    private final IPersistableEarlyData persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    private final ClockDate date = new ClockDate(2000, 1, 1);
    private final ClockTime clockTime = new ClockTime();
    private boolean validTimeReceived = false;
    private boolean validDateReceived = false;
    private boolean validClockViewOptionReceived = false;
    private final ClockDate cachedDate = new ClockDate(-78, 1, 1);
    private byte cachedHour = 0;
    private byte cachedMin = 0;
    private boolean manualDSTAvailable = false;
    private boolean autoDSTAvailable = false;
    private boolean daylightSavingOptionAvailable = false;
    private int daylightSavingOptionState = 0;
    private int clockSourceOptionState = 0;
    private int timeZoneOptionState = 0;
    private int gpsSyncOptionState = 0;
    private int gpsSyncOptionReason = 0;
    private boolean timeModeAM = AslTargetSystemDate.equals(0, 0);
    private final SystemData systemData = SystemData.getInstance();
    private boolean isGPSTimeValid = false;
    private boolean isGPSAvailableAsClockSource = false;
    private static final int EV_TIME_SETUP_TIMER;
    private static final int EV_TIME_RESPONSE_TIMER;
    private static final int EV_DATE_SETUP_TIMER;
    private static final int EV_DATE_RESPONSE_TIMER;
    private static final int EV_TIME_DATE_CHANGE_TRIGGER_TIMER;
    private static final long SETUP_TIMER_DURATION;
    private static final long RESPONSE_TIMER_DURATION;
    private static final long TIME_DATE_CHANGE_TRIGGER_TIMER_DURATION;
    private boolean timeDateChangeTimerActive = false;
    private boolean timeSetupTimerActive = false;
    private boolean timeResponseTimerActive = false;
    private boolean dateSetupTimerActive = false;
    private boolean dateResponseTimerActive = false;
    private ConfigurationManagerDiag configurationManager;
    private PropagatingDateTimeService dateTimeService;
    private SystemLogger systemLogger;
    private SystemServices systemServices;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;

    public AslTargetSystemDate(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.initializeTarget();
    }

    public AslTargetSystemDate(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initializeTarget();
    }

    private void initializeTarget() {
        SystemAccessor.setDateTarget(this);
        this.systemServices = SystemServicesProvider.getSystemServices();
        this.systemLogger = new SystemLogger(this.systemServices.getAsl1Logger(), super.getClass());
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
                this.updateClockMenuAvailabilityReason();
                break;
            }
            case 4300062: {
                this.systemLogger.trace("ASLSystemServiceIds.RELOAD_PERSISTABLES event received!");
                this.initDataFromNamespaceEarly();
                break;
            }
            case 1073743170: {
                this.processAslDownDeIncreaseDateDay(true);
                break;
            }
            case 1073743171: {
                this.processAslDownDeIncreaseDateMonth(true);
                break;
            }
            case 0x40000544: {
                this.processAslDownDeIncreaseDateYear(true);
                break;
            }
            case 1073743159: {
                this.processAslDownDeIncreaseDateDay(false);
                break;
            }
            case 1073743160: {
                this.processAslDownDeIncreaseDateMonth(false);
                break;
            }
            case 1073743161: {
                this.processAslDownDeIncreaseDateYear(false);
                break;
            }
            case 1073743155: {
                this.processAslDownDateFormat(eventGeneric.getInt(0));
                break;
            }
            case 1073743174: {
                this.processAslDownDeIncreaseTimeMinute(true);
                break;
            }
            case 0x40000545: {
                this.processAslDownDeIncreaseTimeHour(true);
                break;
            }
            case 1073743163: {
                this.processAslDownDeIncreaseTimeMinute(false);
                break;
            }
            case 1073743162: {
                this.processAslDownDeIncreaseTimeHour(false);
                break;
            }
            case 1073743205: {
                this.processAslDownToggleTimeMode();
                break;
            }
            case 1073743204: {
                this.processAslDownToggleTimeFormat();
                break;
            }
            case 1073743201: {
                this.processAslDownToggleSummerTime();
                break;
            }
            case 1073743202: {
                this.processAslDownToggleAutoSummerTime();
                break;
            }
            case 1073743195: {
                this.processAslDownTimeMaster(eventGeneric.getInt(0));
                break;
            }
            case 1073743196: {
                this.processAslDownTimezone(eventGeneric.getInt(0));
                break;
            }
            case 100001: {
                this.processTimeSetupTimer();
                break;
            }
            case 100002: {
                this.processTimeResponseTimer();
                break;
            }
            case 100003: {
                this.processDateSetupTimer();
                break;
            }
            case 100004: {
                this.processDateResponseTimer();
                break;
            }
            case 100005: {
                this.processTimeDateChangeTriggerTimer();
                break;
            }
        }
    }

    public boolean isTimeDateValid() {
        return this.validTimeReceived && this.validDateReceived;
    }

    public ClockTime getCurrentTime() {
        return this.clockTime;
    }

    public byte getCurrentTimeHour() {
        return this.clockTime.hours;
    }

    public byte getCurrentTimeMinute() {
        return this.clockTime.minutes;
    }

    public byte getCurrentTimeSecond() {
        return this.clockTime.seconds;
    }

    public ClockDate getCurrentDate() {
        return this.date;
    }

    public long getCurrentTimestamp() {
        if (this.validDateReceived && this.validTimeReceived) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(this.date.year, this.date.month - 1, this.date.day, this.clockTime.hours, this.clockTime.minutes, this.clockTime.seconds);
            long l = gregorianCalendar.getTimeInMillis();
            this.systemLogger.info(new StringBuffer().append("getCurrentTimestamp timestamp: ").append(l).toString());
            return l;
        }
        if (!this.validDateReceived) {
            this.systemLogger.info(new StringBuffer().append("getCurrentTimestamp called but date not valid: ").append(this.validDateReceived).toString());
        }
        if (!this.validTimeReceived) {
            this.systemLogger.info(new StringBuffer().append("getCurrentTimestamp called but time not valid: ").append(this.validTimeReceived).toString());
        }
        return -1L;
    }

    public Calendar getCurrentCalendar(int n) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(this.date.year, this.date.month - 1, this.date.day, this.clockTime.hours, this.clockTime.minutes, this.clockTime.seconds);
        if (n != 0) {
            gregorianCalendar.add(14, n);
        }
        return gregorianCalendar;
    }

    public String getCurrentDateTimeAsString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(this.date.year);
        stringBuffer.append("_");
        if (this.date.month < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(this.date.month);
        stringBuffer.append("_");
        if (this.date.day < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(this.date.day);
        stringBuffer.append("_");
        if (this.clockTime.hours < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(this.clockTime.hours);
        stringBuffer.append("_");
        if (this.clockTime.minutes < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(this.clockTime.minutes);
        stringBuffer.append("_");
        if (this.clockTime.seconds < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(this.clockTime.seconds);
        return stringBuffer.toString();
    }

    public int getConfiguredDateFormat() {
        return this.systemData.getDateformat();
    }

    public int getConfiguredTimeFormat() {
        return this.systemData.getTimeformat();
    }

    @Override
    public int getDefaultTargetId() {
        return 5600;
    }

    void dsiUpdateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions) {
        int n = unitmasterViewOptions.clockFormat.state;
        int n2 = unitmasterViewOptions.dateFormat.state;
        this.collectedViewOptionReasonsUnitmaster = 0;
        this.clockFormatExists = n != 0;
        boolean bl = n != 1;
        AslTargetSystemDate.writeBooleanToDatapool(1659, bl);
        this.collectedViewOptionReasonsUnitmaster |= SystemUtil.collectReason(unitmasterViewOptions.clockFormat.reason);
        this.dateFormatExists = n2 != 0;
        boolean bl2 = n2 != 1;
        AslTargetSystemDate.writeBooleanToDatapool(1658, bl2);
        this.collectedViewOptionReasonsUnitmaster |= SystemUtil.collectReason(unitmasterViewOptions.dateFormat.reason);
        this.clockMenuUnitsFunctionsAccessible = bl2 || bl;
        this.clockMenuUnitsFunctionsAvailable = this.clockFormatExists || this.dateFormatExists;
        this.updateClockMenuAvailability();
        this.systemLogger.trace(new Object[]{"updateUnitmasterViewOptions called.", " dateFormat = ", unitmasterViewOptions.dateFormat, ", clockFormat = ", unitmasterViewOptions.clockFormat});
    }

    void dsiUpdateClockFormat(int n) {
        this.systemLogger.trace(new Object[]{"updateClockFormat called. clockFormat = ", new Integer(n)});
        int n2 = -1;
        if (n == 1) {
            n2 = 0;
            if (this.clockTime.hours >= 12) {
                AslTargetSystemDate.writeIntegerToDatapool(1639, 1);
            } else {
                AslTargetSystemDate.writeIntegerToDatapool(1639, 0);
            }
        } else if (n == 0) {
            n2 = 1;
        }
        if (n2 != -1 && n2 != this.systemData.getTimeformat()) {
            AslTargetSystemDate.writeIntegerToDatapool(1643, n2);
            this.systemData.setTimeformat(n2);
            SystemHasBridgeImpl.getInstance().setPropertyTimeFormat(n2);
            this.triggerTimeFormatChanged(n);
        }
    }

    void dsiUpdateDateFormat(int n) {
        this.systemLogger.trace(new Object[]{"updateDateFormat called. dateFormat = ", new Integer(n)});
        boolean bl = this.configurationManager.isFeatureFlagSet(401);
        if (bl) {
            int n2 = this.transformDsiDateFormatToAslDateFormat(n);
            this.updateDateFormat(n2);
        }
    }

    private void updateDateFormat(int n) {
        if (n != -1 && n != this.systemData.getDateformat()) {
            AslTargetSystemDate.writeIntegerToDatapool(1601, n);
            this.systemData.setDateformat(n);
            SystemHasBridgeImpl.getInstance().setPropertyDateFormat(n);
        }
    }

    private int transformDsiDateFormatToAslDateFormat(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    void dsiUpdateClockViewOptions(ClockViewOptions clockViewOptions) {
        this.systemLogger.trace(new Object[]{"updateClockViewOptions called.", " time = ", clockViewOptions.time, " date = ", clockViewOptions.date, " timeZone = ", clockViewOptions.timeZone, " dayLightSaving = ", clockViewOptions.dayLightSaving, " dayLightSavingData = ", clockViewOptions.dayLightSavingData, " clockSource = ", clockViewOptions.clockSource, " gpsSyncData = ", clockViewOptions.gpsSyncData, " clockConfig = ", clockViewOptions.clockConfig});
        ClockConfig clockConfig = clockViewOptions.clockConfig;
        this.isGPSAvailableAsClockSource = clockConfig.timeSourcesInstallation.gps;
        AslTargetSystemDate.writeBooleanToDatapool(1669, this.isGPSAvailableAsClockSource);
        this.gpsSyncOptionState = clockViewOptions.gpsSyncData.state;
        this.gpsSyncOptionReason = clockViewOptions.gpsSyncData.reason;
        this.collectedViewOptionReasonsClock = 0;
        this.dateOptionAvailable = clockViewOptions.date.state != 0;
        boolean bl = clockViewOptions.date.state != 1;
        AslTargetSystemDate.writeBooleanToDatapool(1655, bl);
        this.collectedViewOptionReasonsClock |= SystemUtil.collectReason(clockViewOptions.date.reason);
        this.timeOptionAvailable = clockViewOptions.time.state != 0;
        boolean bl2 = clockViewOptions.time.state != 1;
        AslTargetSystemDate.writeBooleanToDatapool(1706, bl2);
        this.collectedViewOptionReasonsClock |= SystemUtil.collectReason(clockViewOptions.time.reason);
        this.clockSourceOptionState = clockViewOptions.clockSource.state;
        this.timeMasterOptionAvailable = this.clockSourceOptionState != 0;
        boolean bl3 = this.clockSourceOptionState != 1;
        AslTargetSystemDate.writeBooleanToDatapool(1704, bl3);
        this.collectedViewOptionReasonsClock |= SystemUtil.collectReason(clockViewOptions.clockSource.reason);
        this.timeZoneOptionState = clockViewOptions.timeZone.state;
        this.timeZoneOptionAvailable = this.timeZoneOptionState != 0;
        this.collectedViewOptionReasonsClock |= SystemUtil.collectReason(clockViewOptions.timeZone.reason);
        this.updateTimezoneOptionAccessibility();
        this.daylightSavingOptionState = clockViewOptions.dayLightSaving.state;
        this.collectedViewOptionReasonsClock |= SystemUtil.collectReason(clockViewOptions.dayLightSaving.reason);
        this.updateDaylightSavingAvailability();
        this.clockMenuClockFunctionsAvailable = this.dateOptionAvailable || this.timeOptionAvailable || this.timeMasterOptionAvailable || this.timeZoneOptionAvailable || this.daylightSavingOptionAvailable;
        this.clockMenuClockFunctionsAccessible = bl || bl2 || bl3 || this.timezoneOptionAccessible || this.daylightSavingOptionAccessible;
        this.updateClockMenuAvailability();
        this.setClockSourceToNotAccessibleIfGpsNotAvailable();
        this.systemLogger.trace(new Object[]{"write SYSTEM__GPS_CLOCK_AVAILABLE__BOOLEAN: ", new Boolean(this.isGPSAvailableAsClockSource)});
        this.systemLogger.trace(new Object[]{"updateClockViewOptions daylightSavingMode: ", new Integer(clockConfig.dayLightSavingMode)});
        if (!this.validClockViewOptionReceived) {
            if (this.dateOptionAvailable && this.timeOptionAvailable) {
                this.validClockViewOptionReceived = true;
            }
            this.updateTimeDateValidity();
        }
    }

    void dsiUpdateClockDate(ClockDate clockDate) {
        if (this.dateResponseTimerActive) {
            this.dateResponseTimerActive = false;
            this.stopTimer(-1534721792);
            this.systemLogger.trace("updateClockDate stop EV_DATE_RESPONSE_TIMER");
        }
        this.date.day = clockDate.day;
        this.date.month = clockDate.month;
        this.date.year = (short)(clockDate.year + 2000);
        if (!this.dateSetupTimerActive) {
            this.writeDateToDatapool(this.date.year, this.date.month, this.date.day);
        }
        if (!this.validDateReceived) {
            this.validDateReceived = true;
            this.updateTimeDateValidity();
        }
        this.dateTimeService.applyCurrentDate(this.date);
    }

    void dsiUpdateClockTime(ClockTime clockTime) {
        byte by;
        this.dateTimeService.applyCurrentTime(clockTime);
        if (this.timeResponseTimerActive) {
            this.timeResponseTimerActive = false;
            this.stopTimer(-1568276224);
            this.systemLogger.trace("updateClockTime stop EV_TIME_RESPONSE_TIMER");
        }
        this.clockTime.hours = by = clockTime.hours;
        if (by != this.cachedHour && !this.timeSetupTimerActive) {
            this.cachedHour = by;
            this.setTimeModeAM(by);
            AslTargetSystemDate.writeIntegerToDatapool(1640, by);
            this.systemLogger.trace(new Object[]{"updateClockTime Write to Datapool SYSTEM__TIME__HOUR__INTEGER ", new Byte(by)});
        }
        byte by2 = clockTime.minutes;
        byte by3 = clockTime.seconds;
        this.clockTime.minutes = by2;
        if (by2 != this.cachedMin) {
            this.systemLogger.trace(new Object[]{"updateClockTime ", clockTime});
            if (!this.timeSetupTimerActive) {
                this.cachedMin = by2;
                AslTargetSystemDate.writeIntegerToDatapool(1641, by2);
                if (this.date != null && by3 == 0) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(329072896);
                    eventGeneric.setObject(0, this.date);
                    eventGeneric.setObject(1, clockTime);
                    this.triggerObserver(329072896, eventGeneric);
                    this.systemLogger.trace(new Object[]{"trigger ASLSystemServiceIds.MINUTE_TRIGGER with date and time ", clockTime});
                }
                this.systemLogger.trace(new Object[]{"updateClockTime current time: ", clockTime, " Write to Datapool SYSTEM__TIME__MINUTE__INTEGER ", new Byte(by2)});
            }
        }
        if (by3 != this.clockTime.seconds) {
            this.clockTime.seconds = by3;
            AslTargetSystemDate.writeIntegerToDatapool(1642, by3);
        }
        this.processDSIUpdateDayLightSaving(clockTime.summerTime);
        this.processDSIUpdateTimeZoneOffset(clockTime.timeZone);
        if (!this.validTimeReceived) {
            this.validTimeReceived = true;
            this.updateTimeDateValidity();
        }
    }

    void dsiUpdateClockSource(int n) {
        int n2;
        this.systemLogger.trace(new Object[]{"updateClockSource ", new Integer(n)});
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 0: {
                n2 = -1;
                this.systemLogger.warn("updateClockSource has invalid value: CLOCKSOURCE_NOTVALID");
                break;
            }
            default: {
                n2 = -1;
                this.systemLogger.error(new StringBuffer().append("updateClockSource has unknown value: ").append(n).toString());
            }
        }
        if (n2 != -1) {
            this.systemData.setTimemaster(n2);
            this.updateTimezoneOptionAccessibility();
            this.updateDaylightSavingAvailability();
            if (!this.isGPSTimeValid && n2 == 2) {
                n2 = 1;
            }
            AslTargetSystemDate.writeIntegerToDatapool(1593, n2);
            this.setClockSourceToNotAccessibleIfGpsNotAvailable();
        }
    }

    void dsiUpdateClockDayLightSaving(boolean bl) {
        this.processDSIUpdateDayLightSaving(bl);
    }

    void dsiUpdateClockTimeSourcesAvailable(ClockSources clockSources) {
        this.systemLogger.trace(new Object[]{"updateClockTimeSourcesAvailable ClockSources: ", clockSources});
        boolean bl = clockSources.gps;
        AslTargetSystemDate.writeBooleanToDatapool(1670, bl);
        if (bl != this.isGPSTimeValid) {
            if (this.systemData.getTimemaster() == 2) {
                if (bl) {
                    AslTargetSystemDate.writeIntegerToDatapool(1593, 2);
                    this.systemLogger.trace("Set timemaster to the configured value (gps) again");
                } else {
                    AslTargetSystemDate.writeIntegerToDatapool(1593, 1);
                    this.systemLogger.trace("set timemaster temporarily from gps to manual");
                }
            }
            this.isGPSTimeValid = bl;
        }
        this.setClockSourceToNotAccessibleIfGpsNotAvailable();
    }

    void setManualDSTAvailable(boolean bl) {
        this.manualDSTAvailable = bl;
    }

    void setAutoDSTAvailable(boolean bl) {
        this.autoDSTAvailable = bl;
    }

    void updateDaylightSavingAvailability() {
        AslTargetSystemFeaturesAndCoding aslTargetSystemFeaturesAndCoding = SystemAccessor.getFeaturesAndCodingTarget();
        if (aslTargetSystemFeaturesAndCoding.isTableAdaptationAlreadyRead() && aslTargetSystemFeaturesAndCoding.isTableCarFunctionsAdaptationAlreadyRead()) {
            boolean bl = aslTargetSystemFeaturesAndCoding.isClockDisplayActivated();
            if (this.manualDSTAvailable) {
                this.daylightSavingOptionAvailable = this.daylightSavingOptionState != 0;
                AslTargetSystemDate.writeBooleanToDatapool(1696, this.daylightSavingOptionAvailable && bl);
            }
            if (this.autoDSTAvailable) {
                this.daylightSavingOptionAvailable = this.daylightSavingOptionState != 0;
                AslTargetSystemDate.writeBooleanToDatapool(1649, this.daylightSavingOptionAvailable && bl);
            }
            boolean bl2 = this.daylightSavingOptionAccessible = this.daylightSavingOptionState != 1;
            if (this.systemData.getTimemaster() == 2 && this.gpsSyncOptionState == 1 && this.gpsSyncOptionReason == 12) {
                this.daylightSavingOptionAccessible = false;
            }
            AslTargetSystemDate.writeBooleanToDatapool(1697, this.daylightSavingOptionAccessible);
        }
    }

    void updateTimezoneOptionAccessibility() {
        boolean bl = this.timezoneOptionAccessible = this.timeZoneOptionState != 1;
        if (this.systemData.getTimemaster() == 2 && this.gpsSyncOptionState == 1 && this.gpsSyncOptionReason == 12) {
            this.timezoneOptionAccessible = false;
        }
        AslTargetSystemDate.writeBooleanToDatapool(1708, this.timezoneOptionAccessible);
    }

    void setClockDayLightSaving(boolean bl) {
        this.dsiCarTimeUnits.setClockDayLightSaving(bl);
    }

    void updateClockMenuAvailability() {
        AslTargetSystemFeaturesAndCoding aslTargetSystemFeaturesAndCoding = SystemAccessor.getFeaturesAndCodingTarget();
        if (aslTargetSystemFeaturesAndCoding.isTableCarFunctionsAdaptationAlreadyRead()) {
            boolean bl = aslTargetSystemFeaturesAndCoding.isClockDisplayActivated();
            boolean bl2 = aslTargetSystemFeaturesAndCoding.isUnitMasterDisplayActivated();
            AslTargetSystemDate.writeBooleanToDatapool(10107, this.clockMenuClockFunctionsAccessible || this.clockMenuUnitsFunctionsAccessible);
            this.updateClockMenuAvailabilityReason();
            AslTargetSystemDate.writeBooleanToDatapool(1702, !(!bl && !bl2 || !this.clockMenuClockFunctionsAvailable && !this.clockMenuUnitsFunctionsAvailable));
            AslTargetSystemDate.writeBooleanToDatapool(1705, this.timeOptionAvailable && bl);
            AslTargetSystemDate.writeBooleanToDatapool(1653, this.dateOptionAvailable && bl);
            AslTargetSystemDate.writeBooleanToDatapool(1707, this.timeZoneOptionAvailable && bl);
            AslTargetSystemDate.writeBooleanToDatapool(1703, this.timeMasterOptionAvailable && bl);
            AslTargetSystemDate.writeBooleanToDatapool(1656, this.dateFormatExists && bl2);
            AslTargetSystemDate.writeBooleanToDatapool(1657, this.clockFormatExists && bl2);
        }
    }

    void processRevertDate() {
        this.systemLogger.trace("processRevertDate");
        this.resetManualDaylightSaving();
        this.resetClockSource();
        this.triggerTimeDateChangeEvent();
    }

    private static boolean equals(int n, int n2) {
        return n == n2;
    }

    private void installDefaultDateFormat() {
        this.updateDateFormat(this.configurationManager.getSystemDefaultDateFormat());
    }

    private void processDSIUpdateDayLightSaving(boolean bl) {
        if (this.manualDSTAvailable && (!this.systemData.hasDaylightSavingBeenSet() || bl != this.systemData.getDaylightSaving())) {
            this.systemLogger.trace(new Object[]{"processDSIUpdateDayLightSaving write to Datapool SYSTEM__SUMMERTIME__BOOLEAN ", new Boolean(bl)});
            AslTargetSystemDate.writeBooleanToDatapool(1631, bl);
            this.systemData.setDaylightSaving(bl);
            this.clockTime.summerTime = bl;
        }
    }

    private void processDSIUpdateTimeZoneOffset(float f2) {
        int n = SystemDateUtil.getTimezoneIndex(f2);
        if (n == -1) {
            this.systemLogger.error(new StringBuffer().append("processDSIUpdateTimeZoneOffset: Unknown timezone offset sent by DSI!: ").append(f2).toString());
        } else if (n != this.systemData.getTimezone()) {
            this.systemLogger.trace(new Object[]{"processDSIUpdateTimeZoneOffset Write to Datapool Timezone Index ", new Integer(n), " Offset ", new Float(f2)});
            AslTargetSystemDate.writeIntegerToDatapool(1594, n);
            this.systemData.setTimezone(n);
            this.clockTime.timeZone = f2;
            SystemHasBridgeImpl.getInstance().setPropertyGMTOffset((int)(f2 * 28738));
        }
    }

    private DSICarTimeUnitsLanguageListener createDsiCarTimeUnitsLanguageListener() {
        return new AslTargetSystemDate$1(this);
    }

    private void processPowerOn() {
        this.systemLogger.trace("processPowerOn");
        this.setNotificationForCarTimeUnitsLanguage();
        this.configurationManager = this.systemServices.getConfigManagerDiag();
        this.dateTimeService = this.systemServices.getDateTimeService();
        this.registerFactoryResetParticipant();
        boolean bl = this.configurationManager.isFeatureFlagSet(401);
        if (!bl) {
            this.installDefaultDateFormat();
        }
    }

    private void setNotificationForCarTimeUnitsLanguage() {
        DSIProxy dSIProxy = this.systemServices.getDsiProxy();
        this.dsiCarTimeUnits = (DSICarTimeUnitsLanguage)dSIProxy.getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = AslTargetSystemDate.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        DSICarTimeUnitsLanguageListener dSICarTimeUnitsLanguageListener = this.createDsiCarTimeUnitsLanguageListener();
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = AslTargetSystemDate.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener, dSICarTimeUnitsLanguageListener);
        this.dsiCarTimeUnits.setNotification(new int[]{19, 3, 4, 20, 2, 8, 5, 1, 10}, (DSIListener)dSICarTimeUnitsLanguageListener);
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = SystemServicesProvider.getSystemServices().getFactoryResetService();
        AslTargetSystemDate$2 aslTargetSystemDate$2 = new AslTargetSystemDate$2(this);
        factoryResetService.addParticipant(aslTargetSystemDate$2, FactoryResetComponents.SYSTEM);
    }

    private void initDataFromNamespaceEarly() {
        this.systemLogger.trace("initDataFromNamespaceEarly");
        boolean bl = this.persistableEarlyData.isAutoDaylightSaving();
        AslTargetSystemDate.writeBooleanToDatapool(1648, bl);
        if (SystemAccessor.getFeaturesAndCodingTarget().isTableAdaptationAlreadyRead() && this.autoDSTAvailable) {
            this.dsiCarTimeUnits.setClockDayLightSaving(this.persistableEarlyData.isAutoDaylightSaving());
            this.triggerTimeDateChangeEvent();
        }
    }

    private void processAslDownDateFormat(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                this.systemLogger.error(new StringBuffer().append("processDateFormat: wrong format value: ").append(n).toString());
                n2 = 0;
            }
        }
        this.dsiCarTimeUnits.setDateFormat(n2);
    }

    private void processAslDownDeIncreaseTimeHour(boolean bl) {
        this.cachedHour = SystemDateUtil.changeHour(this.cachedHour, bl, this.systemData.is24hTimeFormat());
        this.setTimeModeAM(this.cachedHour);
        AslTargetSystemDate.writeIntegerToDatapool(1640, this.cachedHour);
        this.triggerTimeSetupTimer();
    }

    private void processAslDownDeIncreaseTimeMinute(boolean bl) {
        this.cachedMin = SystemDateUtil.changeMinute(this.cachedMin, bl);
        AslTargetSystemDate.writeIntegerToDatapool(1641, this.cachedMin);
        this.triggerTimeSetupTimer();
    }

    private void processAslDownDeIncreaseDateDay(boolean bl) {
        byte by = SystemDateUtil.getNextDayInOrder(this.cachedDate, bl);
        this.writeDateToDatapool(this.cachedDate.year, this.cachedDate.month, by);
        this.triggerDateSetupTimer();
    }

    private void processAslDownDeIncreaseDateMonth(boolean bl) {
        byte by = SystemDateUtil.changeMonth(this.cachedDate.month, bl);
        byte by2 = !SystemDateUtil.isDateValid(this.cachedDate.year, by, this.cachedDate.day) ? SystemDateUtil.getMaxNumberOfDaysForMonth(by, this.cachedDate.year) : this.cachedDate.day;
        this.writeDateToDatapool(this.cachedDate.year, by, by2);
        this.triggerDateSetupTimer();
    }

    private void processAslDownDeIncreaseDateYear(boolean bl) {
        short s = SystemDateUtil.changeYear(this.cachedDate.year, bl);
        byte by = !SystemDateUtil.isDateValid(s, this.cachedDate.month, this.cachedDate.day) ? SystemDateUtil.getMaxNumberOfDaysForMonth(this.cachedDate.month, s) : this.cachedDate.day;
        this.writeDateToDatapool(s, this.cachedDate.month, by);
        this.triggerDateSetupTimer();
    }

    private void processAslDownTimeMaster(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                this.systemLogger.error(new StringBuffer().append("processTimeMaster: wrong timeMaster value: ").append(n).toString());
                n2 = 0;
            }
        }
        this.systemLogger.trace(new Object[]{"processTimeMaster, new ClockSource ", new Integer(n), " wrapped (DSI) ClockSource ", new Integer(n2)});
        this.dsiCarTimeUnits.setClockSource(n2);
        this.triggerTimeDateChangeEvent();
    }

    private void processAslDownTimezone(int n) {
        this.dsiCarTimeUnits.setClockTimeZoneOffset(SystemDateUtil.TIMEZONE_OFFSETS[n]);
        this.triggerTimeDateChangeEvent();
    }

    private void processAslDownToggleAutoSummerTime() {
        this.systemLogger.trace("processAslDownToggleAutoSummerTime");
        boolean bl = !this.persistableEarlyData.isAutoDaylightSaving();
        AslTargetSystemDate.writeBooleanToDatapool(1648, bl);
        this.dsiCarTimeUnits.setClockDayLightSaving(bl);
        this.persistableEarlyData.setAutoDaylightSaving(bl);
        this.triggerTimeDateChangeEvent();
    }

    private void processAslDownToggleSummerTime() {
        this.dsiCarTimeUnits.setClockDayLightSaving(!this.systemData.getDaylightSaving());
        this.triggerTimeDateChangeEvent();
    }

    private void processAslDownToggleTimeFormat() {
        int n = this.systemData.is24hTimeFormat() ? 1 : 0;
        this.dsiCarTimeUnits.setClockFormat(n);
    }

    private void processAslDownToggleTimeMode() {
        this.cachedHour = this.timeModeAM ? (byte)(this.cachedHour + 12) : (byte)(this.cachedHour - 12);
        this.setTimeModeAM(this.cachedHour);
        AslTargetSystemDate.writeIntegerToDatapool(1640, this.cachedHour);
        this.triggerTimeSetupTimer();
    }

    private void processTimeDateChangeTriggerTimer() {
        if (this.timeDateChangeTimerActive) {
            this.systemLogger.trace("processTimeDateChangeTriggerTimer, trigger ASLSystemServiceIds.NEW_DATE_TIME");
            this.triggerObserver(-425967360, null);
            this.timeDateChangeTimerActive = false;
        }
    }

    private void processTimeSetupTimer() {
        if (this.timeSetupTimerActive) {
            this.timeSetupTimerActive = false;
            if (this.timeResponseTimerActive) {
                this.retriggerTimer(-1568276224);
                this.systemLogger.trace("processTimeSetupTimer retriggerTimer( EV_TIME_RESPONSE_TIMER )");
            } else {
                this.startTimer(-1568276224, (long)0, false);
                this.timeResponseTimerActive = true;
                this.systemLogger.trace("processTimeSetupTimer startTimer( EV_TIME_RESPONSE_TIMER )");
            }
            this.dsiCarTimeUnits.setClockTime(this.cachedHour, this.cachedMin, (byte)0);
            this.triggerTimeDateChangeEvent();
        }
    }

    private void processTimeResponseTimer() {
        this.systemLogger.trace("processTimeSetupTimer");
        if (this.timeResponseTimerActive) {
            this.timeResponseTimerActive = false;
            AslTargetSystemDate.writeIntegerToDatapool(1641, this.clockTime.minutes);
            AslTargetSystemDate.writeIntegerToDatapool(1640, this.clockTime.hours);
            this.cachedMin = this.clockTime.minutes;
            this.cachedHour = this.clockTime.hours;
        }
    }

    private void processDateSetupTimer() {
        if (this.dateSetupTimerActive) {
            this.dateSetupTimerActive = false;
            if (this.dateResponseTimerActive) {
                this.retriggerTimer(-1534721792);
                this.systemLogger.trace("processDateSetupTimer retriggerTimer( EV_DATE_RESPONSE_TIMER )");
            } else {
                this.startTimer(-1534721792, (long)0, false);
                this.dateResponseTimerActive = true;
                this.systemLogger.trace("processDateSetupTimer startTimer( EV_DATE_RESPONSE_TIMER )");
            }
            this.dsiCarTimeUnits.setClockDate(new ClockDate((short)(this.cachedDate.year - 2000), this.cachedDate.month, this.cachedDate.day));
            this.triggerTimeDateChangeEvent();
        }
    }

    private void processDateResponseTimer() {
        this.systemLogger.trace("processDateResponseTimer");
        if (this.dateResponseTimerActive) {
            this.dateResponseTimerActive = false;
            this.writeDateToDatapool(this.date.year, this.date.month, this.date.day);
            this.cachedDate.year = this.date.year;
            this.cachedDate.month = this.date.month;
            this.cachedDate.day = this.date.day;
        }
    }

    private void triggerTimeDateChangeEvent() {
        if (this.timeDateChangeTimerActive) {
            this.systemLogger.trace("triggerTimeDateChangeEvent, retriggerTimer( EV_TIME_DATE_CHANGE_TRIGGER_TIMER )");
            this.retriggerTimer(-1517944576);
        } else {
            this.systemLogger.trace("triggerTimeSetupTimer, startTimer( EV_TIME_DATE_CHANGE_TRIGGER_TIMER )");
            this.startTimer(-1517944576, (long)0, false);
            this.timeDateChangeTimerActive = true;
        }
    }

    private void triggerTimeFormatChanged(int n) {
        this.systemLogger.trace("triggerTimeFormatChanged, trigger ASLSystemServiceIds.TIME_FORMAT_CHANGED");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId());
        eventGeneric.setInt(0, n);
        this.triggerObserver(412958976, eventGeneric);
    }

    private void triggerTimeSetupTimer() {
        if (this.timeSetupTimerActive) {
            this.systemLogger.trace("triggerTimeSetupTimer, retriggerTimer( EV_TIME_SETUP_TIMER )");
            this.retriggerTimer(-1585053440);
        } else {
            this.systemLogger.trace("triggerTimeSetupTimer, startTimer( EV_TIME_SETUP_TIMER )");
            this.startTimer(-1585053440, (long)0, false);
            this.timeSetupTimerActive = true;
        }
    }

    private void triggerDateSetupTimer() {
        if (this.dateSetupTimerActive) {
            this.systemLogger.trace("triggerDateSetupTimer, retriggerTimer( EV_DATE_SETUP_TIMER )");
            this.retriggerTimer(-1551499008);
        } else {
            this.systemLogger.trace("triggerDateSetupTimer, startTimer( EV_DATE_SETUP_TIMER )");
            this.startTimer(-1551499008, (long)0, false);
            this.dateSetupTimerActive = true;
        }
    }

    private void resetManualDaylightSaving() {
        if (this.manualDSTAvailable) {
            this.dsiCarTimeUnits.setClockDayLightSaving(this.configurationManager.getSystemSummertimeOnDefaultBoolean());
        }
    }

    private void resetClockSource() {
        int n;
        switch (this.configurationManager.getSystemTimeMasterDefault()) {
            case 0: {
                n = 1;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            default: {
                n = 1;
            }
        }
        this.dsiCarTimeUnits.setClockSource(n);
    }

    private void setTimeModeAM(byte by) {
        int n;
        this.systemLogger.trace(new Object[]{"setTimeModeAM ", new Byte(by)});
        if (by >= 12) {
            n = 1;
            this.timeModeAM = false;
        } else {
            n = 0;
            this.timeModeAM = true;
        }
        AslTargetSystemDate.writeIntegerToDatapool(1639, n);
    }

    private void writeDateToDatapool(short s, byte by, byte by2) {
        this.systemLogger.trace(new Object[]{"writeDateToDatapool: ", new Byte(by2), ".", new Byte(by), ".", new Short(s)});
        if (this.cachedDate.day != by2) {
            this.cachedDate.day = by2;
            AslTargetSystemDate.writeIntegerToDatapool(1598, by2);
        }
        if (this.cachedDate.month != by || this.cachedDate.year != s) {
            this.cachedDate.month = by;
            this.cachedDate.year = s;
            AslTargetSystemDate.writeIntegerToDatapool(1599, by);
            AslTargetSystemDate.writeIntegerToDatapool(1600, s);
            ClockDate clockDate = new ClockDate(s, by, by2);
            byte by3 = SystemDateUtil.getDayOfWeek(clockDate);
            ListManager.getGenericASLList(1580).updateList(SystemDateUtil.getDaysOfPreviousMonth(clockDate, by3));
            ListManager.getGenericASLList(1579).updateList(SystemDateUtil.getDaysOfCurrentMonth(clockDate));
            ListManager.getGenericASLList(1581).updateList(SystemDateUtil.getDaysOfNextMonth(clockDate, by3));
        }
    }

    private void updateTimeDateValidity() {
        this.systemLogger.trace(new Object[]{"updateTimeDateValidity validDateReceived ", new Boolean(this.validDateReceived), " validTimeReceived ", new Boolean(this.validTimeReceived), " validClockViewOptionReceived ", new Boolean(this.validClockViewOptionReceived)});
        if (this.validDateReceived && this.validTimeReceived && this.validClockViewOptionReceived) {
            AslTargetSystemDate.writeBooleanToDatapool(3572, true);
            if (this.getCurrentTimeHour() == 0 && this.getCurrentTimeMinute() == 0 && this.getCurrentTimeSecond() == 0) {
                this.systemLogger.warn("Illegal first ClockTime 0:00:00!");
                this.validTimeReceived = false;
            } else {
                this.systemLogger.info(new StringBuffer().append("First valid ClockTime: ").append(this.getCurrentTime()).append(" triggerObserver VALID_TIME_DATE_AVAILABLE").toString());
            }
            this.triggerObserver(345850112, null);
        }
    }

    private void setClockSourceToNotAccessibleIfGpsNotAvailable() {
        if (this.isGPSAvailableAsClockSource) {
            if (this.systemData.getTimemaster() == 0 && !this.isGPSTimeValid) {
                AslTargetSystemDate.writeBooleanToDatapool(1704, false);
                return;
            }
            AslTargetSystemDate.writeBooleanToDatapool(1704, this.clockSourceOptionState != 1);
        }
    }

    private void updateClockMenuAvailabilityReason() {
        AslTargetSystemDate.writeIntegerToDatapool(10108, SystemUtil.getRelevantReason(this.collectedViewOptionReasonsClock | this.collectedViewOptionReasonsUnitmaster, this.clamp15State));
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

