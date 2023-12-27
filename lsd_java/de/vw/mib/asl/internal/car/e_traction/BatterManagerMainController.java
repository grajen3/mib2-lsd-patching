/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.e_traction.EtrakService;
import de.vw.mib.asl.api.car.e_traction.EtrakServiceListener;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.car.speller.Speller;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.e_traction.HsmTargetBatteryManager;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListController;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.profiles.ProfileListController;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlPowerProviderCollector;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlTimerCollector;
import de.vw.mib.asl.internal.car.e_traction.transformer.CarE_TractionProfileListTransformer;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.e_traction.ASLCarE_TractionPropertyManager;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class BatterManagerMainController
implements ProfileListContext,
PowerProviderListContext,
TimerNotifier,
EtrakService {
    private BatteryControlViewOptions curentViewOptions;
    private HsmTargetBatteryManager batteryManagerTarget;
    private ProfileListController profileListController;
    private PowerProviderListController powerProviderController;
    private boolean isProfileListLoaded;
    private boolean isPowerProviderListLoaded;
    protected boolean isActivePedal;
    private boolean isClockFormatAmPm = false;
    private Speller currentSpeller;
    private int currentEditingProfileIndex = -1;
    private static final int EV_TIME_OUT_REQUESTING_PROFILES;
    private static final int EV_TIME_OUT_ACTIVE_TIMER_EXPIRE;
    private boolean isAmNigthRateStart = false;
    private Timer activeTimerExpire;
    private boolean isAmNigthRateEnd = false;
    private boolean[] isAmTimer = new boolean[3];
    private static final int TIMER_1;
    private static final int TIMER_2;
    private static final int TIMER_3;
    private int TIMER_DEFAULT = 3;
    private BatteryControlTimerCollector[] timers = new BatteryControlTimerCollector[3];
    private BatteryControlWeekdays[] weekDays_timers = new BatteryControlWeekdays[3];
    boolean[] isSingleTimerOutOfRange = new boolean[]{false, false, false};
    private static final int STEP_MINUTES;
    private int currentActiveTimer;
    private static final int AIR_CONDITION_STEP_SIZE_C;
    private static final int AIR_CONDITION_MIN_SIZE_C;
    private static final int AIR_CONDITION_MAX_SIZE_C;
    private static final int AIR_CONDITION_STEP_SIZE_F;
    private static final int AIR_CONDITION_MIN_SIZE_F;
    private static final int AIR_CONDITION_MAX_SIZE_F;
    static final int MAX_CURRENT_DSI_VALUE_5;
    static final int MAX_CURRENT_DSI_VALUE_10;
    static final int MAX_CURRENT_DSI_VALUE_13;
    static final int MAX_CURRENT_DSI_VALUE_16;
    static final int MAX_CURRENT_DSI_VALUE_32;
    private BatteryControlProfileCollector _currentEditingProfileData;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$e_traction$EtrakService;

    public BatterManagerMainController(HsmTargetBatteryManager hsmTargetBatteryManager) {
        this.batteryManagerTarget = hsmTargetBatteryManager;
        this.registerAsServiceProvider();
    }

    private ProfileListController getProfileListController() {
        if (this.profileListController == null) {
            this.profileListController = new ProfileListController(this);
        }
        return this.profileListController;
    }

    private PowerProviderListController getPowerProviderListController() {
        if (this.powerProviderController == null) {
            this.powerProviderController = new PowerProviderListController(this);
        }
        return this.powerProviderController;
    }

    public final boolean isTraceEnabled() {
        return this.batteryManagerTarget.isTraceEnabled();
    }

    private static boolean isBatteryManagerAvailable(BatteryControlViewOptions batteryControlViewOptions) {
        return batteryControlViewOptions != null && batteryControlViewOptions.getProfileList().getState() == 2 && batteryControlViewOptions.getTimer1().getState() == 2 && batteryControlViewOptions.getTimer2().getState() == 2 && batteryControlViewOptions.getTimer3().getState() == 2 && batteryControlViewOptions.getTimerState().getState() == 2;
    }

    public boolean isBatteryManagerAvailable() {
        return BatterManagerMainController.isBatteryManagerAvailable(this.curentViewOptions);
    }

    private void updateModelCarBatteryControlViewOptions() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setObject(0, this.curentViewOptions);
        this.batteryManagerTarget.triggerObserver(772481024, eventGeneric);
    }

    private void updateModelBatteryManagerWaitPopup() {
        if (this.isProfileListLoaded && this.isPowerProviderListLoaded) {
            this.linkTimersWithProfileList();
            this.linkProfileListWithPowerProviderList();
            ServiceManager.aslPropertyManager.valueChangedBoolean(10481, false);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10481, true);
        }
    }

    private void clearCurrentEditingProfileData() {
        this._currentEditingProfileData = null;
    }

    private void saveCurrentEditingProfileData() {
        if (this._currentEditingProfileData != null) {
            this.getProfileListController().modifyProfileAttributes(this._currentEditingProfileData, 5);
            this.clearCurrentEditingProfileData();
        } else {
            this.getCarLogger().warn("BatterManagerMainController::saveCurrentEditingProfileData: _currentEditingProfileData = null");
        }
    }

    private void saveCurrentEditingProfilePowerProvider() {
        if (this._currentEditingProfileData != null) {
            this.getPowerProviderListController().modifyPowerProviderElement(this._currentEditingProfileData.getPowerProvider());
            this.clearCurrentEditingProfileData();
        } else {
            this.getCarLogger().warn("BatterManagerMainController::saveCurrentEditingProfilePowerProvider: _currentEditingProfileData = null");
        }
    }

    private BatteryControlProfileCollector getCurrentEditingProfileData(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getProfileViaModelProfileListIndex(n);
        if (batteryControlProfileCollector != null) {
            if (this._currentEditingProfileData == null || batteryControlProfileCollector.posId != this._currentEditingProfileData.posId) {
                this._currentEditingProfileData = batteryControlProfileCollector.copyCollector();
            }
        } else {
            this._currentEditingProfileData = null;
        }
        return this._currentEditingProfileData;
    }

    public void handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1073745062: {
                this.deIncreaseGlobalSettingsAirCon(true);
                break;
            }
            case 1073745061: {
                this.deIncreaseGlobalSettingsAirCon(false);
                break;
            }
            case 1073745063: {
                this.setGlobalSettingAirConditionTemp(eventGeneric.getInt(0));
                break;
            }
            case 1073745066: {
                this.deIncreaseGlobalSettingsMinimumSoc(true);
                break;
            }
            case 1073745065: {
                this.deIncreaseGlobalSettingsMinimumSoc(false);
                break;
            }
            case 1073745067: {
                this.setGlobalSettingMinimumSoc(eventGeneric.getInt(0));
                break;
            }
            case 1073745064: {
                int n = this.maxCurrentProfileDSI(eventGeneric.getInt(0));
                this.setGlobalProfileMaxCurrent(n);
                break;
            }
            case 1073745068: {
                this.toogleGlobalSettingAirCondition();
                break;
            }
            case 1073745119: {
                this.getProfileListController().toggleParkHeaterInGlobalProfile();
                break;
            }
            case 1073745075: {
                this.currentSpeller = ASLCarFactory.getCarApi().createSpeller(0, 10377);
                this.currentSpeller.setEnteredText("");
                break;
            }
            case 1073745086: {
                String string = this.currentSpeller.getEnteredText();
                this.getProfileListController().insertProfile(string);
                break;
            }
            case 1073745081: {
                this.getCarLogger().info("NEW NAME_PROFILE_SPELLER_CLOSED");
                break;
            }
            case 1073745091: {
                this.getCarLogger().info("RENAME_PROFILE_SPELLER_CLOSED");
                break;
            }
            case 1073745097: {
                String string = this.currentSpeller.getEnteredText();
                this.getProfileListController().renameProfile(this.currentEditingProfileIndex, string);
                break;
            }
            case 1073745053: {
                this.currentEditingProfileIndex = eventGeneric.getInt(0);
                break;
            }
            case 1073745095: {
                this.currentSpeller = ASLCarFactory.getCarApi().createSpeller(0, 10442);
                this.currentSpeller.setEnteredText(eventGeneric.getString(0));
                break;
            }
            case 1073745085: 
            case 1073745096: {
                this.currentSpeller.deleteAllCharacters();
                break;
            }
            case 1073745159: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, eventGeneric.getBoolean(0));
                break;
            }
            case 1073745160: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(1127358464, eventGeneric.getBoolean(0));
                break;
            }
            case 1073745038: {
                this.getProfileListController().deleteProfile(eventGeneric.getInt(0));
                break;
            }
            case 1073745069: {
                this.getCarLogger().info("DELETE ALL PROFILES");
                break;
            }
            case 1073745044: {
                this.increaseTimerNightRate(eventGeneric.getInt(0), eventGeneric.getInt(2), !eventGeneric.getBoolean(1), true);
                break;
            }
            case 1073745041: {
                this.decreaseTimerNightRate(eventGeneric.getInt(0), eventGeneric.getInt(2), !eventGeneric.getBoolean(1), false);
                break;
            }
            case 1073745048: {
                this.deIncreaseProfileSoc(eventGeneric.getInt(0), true);
                break;
            }
            case 1073745047: {
                this.deIncreaseProfileSoc(eventGeneric.getInt(0), false);
                break;
            }
            case 1073745049: {
                this.setProfileSoc(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745046: {
                this.setProfileMaxCurrent(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745051: {
                this.activateAirCondition(eventGeneric.getInt(0));
                this.saveCurrentEditingProfileData();
                break;
            }
            case 1073745052: {
                this.activateCharging(eventGeneric.getInt(0));
                this.saveCurrentEditingProfileData();
                break;
            }
            case 1073745050: {
                this.assignProfileToTimer(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745055: {
                this.activateTimer(eventGeneric.getInt(0));
                break;
            }
            case 1073745057: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.setTimerMode(n, n2);
                break;
            }
            case 1073745058: {
                this.settingUpWeekDays(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745060: {
                this.deIncreaseTimerBatteryWeekDay(true, eventGeneric.getInt(0));
                break;
            }
            case 1073745059: {
                this.deIncreaseTimerBatteryWeekDay(false, eventGeneric.getInt(0));
                break;
            }
            case 1073745074: {
                this.sendingNewTimerValues(this.currentActiveTimer);
                break;
            }
            case 1073745042: {
                this.increaseTimerBattery(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745039: {
                this.decreaseTimerBattery(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745054: {
                this.toggleStateOfNightRate(eventGeneric.getInt(0));
                break;
            }
            case 1073745073: {
                this.saveCurrentEditingProfilePowerProvider();
                break;
            }
            case 1073745071: {
                this.saveCurrentEditingProfileData();
                this.currentEditingProfileIndex = eventGeneric.getInt(0);
                break;
            }
            case 1073744866: {
                this.resetBev(eventGeneric.getInt(0));
                break;
            }
            case 1073745079: {
                int n = eventGeneric.getInt(0);
                if (this.noWeekDayLeft(this.timers[n].timeWeekDays)) {
                    this.timers[n].timeWeekDays[this.timers[n].timeNextWeekDay] = true;
                }
                this.currentActiveTimer = n;
                this.informHmiWeekDays(n);
                break;
            }
            case 4300051: {
                ASLCarContainer.getInstance().setMainUnitTime((ClockTime)eventGeneric.getObject(1));
                break;
            }
            case 100001: {
                break;
            }
            case 1073745125: {
                this.batteryManagerTarget.stopTimer(-1585053440);
                break;
            }
            case 1073745124: {
                break;
            }
            case 1073745181: 
            case 1073745182: {
                this.currentSpeller.addCharacter(eventGeneric.getString(0), eventGeneric.getInt(3), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073745082: 
            case 0x40000CC4: {
                this.currentSpeller.deleteCharacter();
                break;
            }
            case 1073745084: 
            case 1073745094: {
                this.currentSpeller.setCursorPosition(eventGeneric.getInt(0));
                break;
            }
            case 1073745190: {
                this.getCarHybrid().setHybridActivePedal(!this.isActivePedal);
                break;
            }
            case 1073745191: {
                this.selectWeekdayforSingleTimer(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073745186: {
                this.setGlobalMaxCurrentReducedMax(eventGeneric.getInt(0));
                break;
            }
        }
    }

    private void setTimerMode(int n, int n2) {
        if (this.timers[n].isCycle != n2) {
            this.timers[n].isCycle = n2;
            if (n2 == 1) {
                this.timers[n].timer_currentDay = ASLCarUtil.getNextActiveDay(this.timers[n].getTimeWeekDays()) + 1;
            } else {
                this.timers[n].timeWeekDays[0] = this.timers[n].timeNextWeekDay == 0;
                this.timers[n].timeWeekDays[1] = this.timers[n].timeNextWeekDay == 1;
                this.timers[n].timeWeekDays[2] = this.timers[n].timeNextWeekDay == 2;
                this.timers[n].timeWeekDays[3] = this.timers[n].timeNextWeekDay == 3;
                this.timers[n].timeWeekDays[4] = this.timers[n].timeNextWeekDay == 4;
                this.timers[n].timeWeekDays[5] = this.timers[n].timeNextWeekDay == 5;
                this.timers[n].timeWeekDays[6] = this.timers[n].timeNextWeekDay == 6;
                this.informHmiWeekDays(n);
            }
        }
        this.sendingNewTimerValues(n);
    }

    private void setGlobalProfileMaxCurrent(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getGlobalProfile();
        batteryControlProfileCollector.maxCurrent = n;
        this.getProfileListController().modifyProfileAttributes(batteryControlProfileCollector, 0);
    }

    public void dsiCarHybridUpdateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.curentViewOptions = batteryControlViewOptions;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10509, batteryControlViewOptions.configuration.parkheaterInstallation);
        this.updateModelCarBatteryControlViewOptions();
        this.getEtrakServiceListener().updateEtrakAvailableStatus(this.getEtrakAvailableStatus());
    }

    void setBatteryMangerBecomesAvailable() {
    }

    void setBatteryMangerBecomesNotAvailable() {
        this.getProfileListController().stopLoadingData();
        this.getPowerProviderListController().stopLoadingData();
    }

    @Override
    public CarLogger getCarLogger() {
        return this.batteryManagerTarget;
    }

    @Override
    public DSICarHybrid getCarHybrid() {
        return this.batteryManagerTarget.dsiCarHybrid;
    }

    @Override
    public void profileListLoadedState(boolean bl) {
        this.isProfileListLoaded = bl;
        this.updateModelBatteryManagerWaitPopup();
        this.informProfiles();
    }

    @Override
    public void powerProviderListLoadedState(boolean bl) {
        this.isPowerProviderListLoaded = bl;
        this.updateModelBatteryManagerWaitPopup();
    }

    @Override
    public void profileListUpdated() {
        if (this.isProfileListLoaded) {
            this.linkTimersWithProfileList();
            this.linkProfileListWithPowerProviderList();
            this.clearCurrentEditingProfileData();
        }
    }

    @Override
    public void powerProviderListUpdated() {
        if (this.isPowerProviderListLoaded) {
            this.linkProfileListWithPowerProviderList();
        }
    }

    public void dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        this.getProfileListController().getProfileListDsiListener().dsiCarHybridUpdateBatteryControlTotalNumberOfProfiles(n, n2);
    }

    public void dsiCarHybridResponseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA1(batteryControlProfilesAH, batteryControlProfileRA1Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA2(batteryControlProfilesAH, batteryControlProfileRA2Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA4(batteryControlProfilesAH, batteryControlProfileRA4Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
            this.getNextActiveTimer();
        }
    }

    public void dsiCarHybridResponseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA6(batteryControlProfilesAH, batteryControlProfileRA6Array);
        }
    }

    public void dsiCarHybridResponseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRA7(batteryControlProfilesAH, batteryControlProfileRA7Array);
        }
    }

    public void dsiCarHybridResponseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridResponseProfileListRAF(batteryControlProfilesAH, nArray);
        }
    }

    public void dsiCarHybridAcknowledgeBatteryControlSetFactoryDefault(boolean bl) {
    }

    public void dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        if (this.isBatteryManagerAvailable()) {
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridUpdateBatteryControlTotalNumberOfPowerProvider(n, n2);
        }
    }

    public void dsiCarHybridResponsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        if (this.isBatteryManagerAvailable()) {
            BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array2 = batteryControlPowerProviderRA0Array;
            for (int i2 = 0; i2 < batteryControlPowerProviderRA0Array2.length; ++i2) {
                batteryControlPowerProviderRA0Array2[i2].nrEndHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA0Array[i2].nrEndHour, batteryControlPowerProviderRA0Array[i2].nrEndMinute);
                batteryControlPowerProviderRA0Array2[i2].nrStartHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA0Array[i2].nrStartHour, batteryControlPowerProviderRA0Array[i2].nrStartMinute);
                batteryControlPowerProviderRA0Array2[i2].nrEndMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA0Array[i2].nrEndMinute);
                batteryControlPowerProviderRA0Array2[i2].nrStartMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA0Array[i2].nrStartMinute);
            }
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridResponsePowerProviderListRA0(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array2);
        }
    }

    public void dsiCarHybridResponsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        if (this.isBatteryManagerAvailable()) {
            BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array2 = batteryControlPowerProviderRA1Array;
            for (int i2 = 0; i2 < batteryControlPowerProviderRA1Array2.length; ++i2) {
                batteryControlPowerProviderRA1Array2[i2].nrEndHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA1Array[i2].nrEndHour, batteryControlPowerProviderRA1Array[i2].nrEndMinute);
                batteryControlPowerProviderRA1Array2[i2].nrStartHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA1Array[i2].nrStartHour, batteryControlPowerProviderRA1Array[i2].nrStartMinute);
                batteryControlPowerProviderRA1Array2[i2].nrEndMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA1Array[i2].nrEndMinute);
                batteryControlPowerProviderRA1Array2[i2].nrStartMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA1Array[i2].nrStartMinute);
            }
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridResponsePowerProviderListRA1(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array2);
        }
    }

    public void dsiCarHybridResponsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        if (this.isBatteryManagerAvailable()) {
            BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array2 = batteryControlPowerProviderRA2Array;
            for (int i2 = 0; i2 < batteryControlPowerProviderRA2Array2.length; ++i2) {
                batteryControlPowerProviderRA2Array2[i2].nrEndHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA2Array[i2].nrEndHour, batteryControlPowerProviderRA2Array[i2].nrEndMinute);
                batteryControlPowerProviderRA2Array2[i2].nrStartHour = this.bringNightRateHourInRange(batteryControlPowerProviderRA2Array[i2].nrStartHour, batteryControlPowerProviderRA2Array[i2].nrStartMinute);
                batteryControlPowerProviderRA2Array2[i2].nrEndMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA2Array[i2].nrEndMinute);
                batteryControlPowerProviderRA2Array2[i2].nrStartMinute = this.bringNightRateMinuteInRange(batteryControlPowerProviderRA2Array[i2].nrStartMinute);
            }
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridResponsePowerProviderListRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array2);
        }
    }

    public void dsiCarHybridResponsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        if (this.isBatteryManagerAvailable()) {
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridResponsePowerProviderListRAE(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
        }
    }

    public void dsiCarHybridResponsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        if (this.isBatteryManagerAvailable()) {
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridResponsePowerProviderListRAF(batteryControlPowerProviderAH, nArray);
        }
    }

    public void dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        if (this.isBatteryManagerAvailable()) {
            this.getPowerProviderListController().getPowerProviderListDsiListener().dsiCarHybridUpdateBatteryControlPowerProviderListUpdateInfo(batteryControlPowerProviderAH, nArray, n);
        }
    }

    public void dsiCarHybridUpdateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        switch (batteryControlChargeState.getChargeState()) {
            case 11: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 2);
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 15: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 0);
                break;
            }
        }
    }

    public void dsiCarHybridUpdateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        switch (batteryControlClimateState.getClimateState()) {
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 4);
                break;
            }
            case 10: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 5);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 3);
                break;
            }
        }
    }

    public void dsiCarHybridUpdateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        switch (batteryControlPlug.getLockState()) {
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10367, 1);
                break;
            }
        }
    }

    public void dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        if (this.isBatteryManagerAvailable()) {
            this.getProfileListController().getProfileListDsiListener().dsiCarHybridUpdateBatteryControlProfilesListUpdateInfo(batteryControlProfilesAH, nArray, n);
        }
    }

    public void updateBatteryControlTimer(BatteryControlTimer batteryControlTimer, int n) {
        if (batteryControlTimer.getWeekdays().isCyclic()) {
            this.fillTimerArray(n, batteryControlTimer.getRefID(), batteryControlTimer.getHour(), ASLCarUtil.evaluateMinute(batteryControlTimer.getMinute()), batteryControlTimer.getYear(), batteryControlTimer.getMonth(), batteryControlTimer.getDay(), this.timers[n].timeNextWeekDay, new boolean[]{batteryControlTimer.getWeekdays().isMonday(), batteryControlTimer.getWeekdays().isTuesday(), batteryControlTimer.getWeekdays().isWednesday(), batteryControlTimer.getWeekdays().isThursday(), batteryControlTimer.getWeekdays().isFriday(), batteryControlTimer.getWeekdays().isSaturday(), batteryControlTimer.getWeekdays().isSunday()}, this.timers[n].isActive(), batteryControlTimer.getWeekdays().isCyclic());
        } else {
            this.timers[n].timer_currentDay = ASLCarUtil.informHMIBatteryControl(batteryControlTimer.getYear() + 2000, batteryControlTimer.getMonth(), batteryControlTimer.getDay()) + 1;
            this.timers[n].timeNextWeekDay = ASLCarUtil.informHMIBatteryControl(batteryControlTimer.getYear() + 2000, batteryControlTimer.getMonth(), batteryControlTimer.getDay());
            this.fillTimerArray(n, batteryControlTimer.getRefID(), batteryControlTimer.getHour(), ASLCarUtil.evaluateMinute(batteryControlTimer.getMinute()), batteryControlTimer.getYear(), batteryControlTimer.getMonth(), batteryControlTimer.getDay(), this.timers[n].timeNextWeekDay, this.timers[n].timeWeekDays, this.timers[n].isActive(), batteryControlTimer.getWeekdays().isCyclic());
        }
        if (this.isSingleTimerOutOfRange[n]) {
            this.isSingleTimerOutOfRange[n] = false;
            this.getCarHybrid().setBatteryControlTimerState(new BatteryControlProgrammedTimer(this.timers[0].isActivated, this.timers[1].isActivated, this.timers[2].isActivated, false));
        } else {
            this.informingHMIAboutCurrentTimer();
        }
    }

    public void dsiCarHybridUpdateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
        batteryControlTimer2.minute = this.bringTimerMinuteInRange(batteryControlTimer.minute);
        this.updateBatteryControlTimer(batteryControlTimer2, 0);
    }

    public void dsiCarHybridUpdateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
        batteryControlTimer2.minute = this.bringTimerMinuteInRange(batteryControlTimer.minute);
        this.updateBatteryControlTimer(batteryControlTimer2, 1);
    }

    public void dsiCarHybridUpdateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
        batteryControlTimer2.minute = this.bringTimerMinuteInRange(batteryControlTimer.minute);
        this.updateBatteryControlTimer(batteryControlTimer2, 2);
    }

    public void dsiCarHybridUpdateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.activeStateOfTimer(0, BatterManagerMainController.isTimerProgrammed(batteryControlTimerState.getProgrammedTimer().isTimer1(), batteryControlTimerState.getExpiredTimer().isTimer1()));
        this.activeStateOfTimer(1, BatterManagerMainController.isTimerProgrammed(batteryControlTimerState.getProgrammedTimer().isTimer2(), batteryControlTimerState.getExpiredTimer().isTimer2()));
        this.activeStateOfTimer(2, BatterManagerMainController.isTimerProgrammed(batteryControlTimerState.getProgrammedTimer().isTimer3(), batteryControlTimerState.getExpiredTimer().isTimer3()));
        this.updateTimers();
        this.getNextActiveTimer();
    }

    public void dsiCarTimeUnitsLanguageUpdateClockDate(ClockDate clockDate, int n) {
        ASLCarUtil.calculateNextRange(clockDate);
        ASLCarContainer.getInstance().setMainUnitDate(clockDate);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockFormat(int n, int n2) {
        this.isClockFormatAmPm = n == 1;
    }

    public void dsiCarTimeUnitsLanguageUpdateClockTime(ClockTime clockTime, int n) {
        ASLCarContainer.getInstance().setMainUnitTime(clockTime);
    }

    private void activateAirCondition(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        batteryControlProfileCollector.isAirConditioning = !batteryControlProfileCollector.isAirConditioning;
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    private void deIncreaseGlobalSettingsAirCon(boolean bl) {
        int n;
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getGlobalProfile();
        if (batteryControlProfileCollector.temperatureUnit == 0) {
            int n2 = batteryControlProfileCollector.temperatureValue + 100;
            n = ASLCarUtil.incDecValueInStepSize(bl, n2, 5);
            n = ASLCarUtil.bringValuesIntoRange(n, 300, 155);
            batteryControlProfileCollector.setTemperatureValue(n - 100);
        } else {
            int n3 = (batteryControlProfileCollector.temperatureValue / 4 + 50) * 10;
            n = ASLCarUtil.incDecValueInStepSize(bl, n3, 10);
            n = ASLCarUtil.bringValuesIntoRange(n, 880, 590);
            batteryControlProfileCollector.setTemperatureValue((n / 10 - 50) * 4);
        }
        if (n != -1) {
            this.setGlobalSettingAirConditionTemp(n);
        } else {
            this.getCarLogger().warn("increase air condition not possible");
        }
    }

    private void activateCharging(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        batteryControlProfileCollector.isCharing = !batteryControlProfileCollector.isCharing;
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    private void setProfileMaxCurrent(int n, int n2) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        batteryControlProfileCollector.maxCurrent = CarE_TractionProfileListTransformer.maxCurrentProfileDSI(n2);
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    private void setGlobalMaxCurrentReducedMax(int n) {
        int n2 = 5;
        switch (n) {
            case 0: {
                n2 = 32;
                break;
            }
            case 1: {
                n2 = 5;
                break;
            }
        }
        this.setGlobalProfileMaxCurrent(n2);
    }

    int maxCurrentProfileDSI(int n) {
        switch (n) {
            case 0: {
                return 5;
            }
            case 1: {
                return 10;
            }
            case 2: {
                return 13;
            }
            case 3: {
                return 16;
            }
            case 4: {
                return 32;
            }
        }
        this.getCarLogger().error("[ERROR] Car Hybrid could not match max_current for profile!!!! Using default value");
        return 10;
    }

    private void increaseTimerNightRate(int n, int n2, boolean bl, boolean bl2) {
        switch (n2) {
            case 0: {
                this.nightRateHour(n, bl, bl2);
                break;
            }
            case 1: {
                this.nightRateMinutes(n, bl, bl2);
                break;
            }
            case 2: {
                this.nightRateAmPm(n, bl);
                break;
            }
            default: {
                this.getCarLogger().error("BatterManagerMainController.increaseTimerNightRate:: Not valid time value");
            }
        }
    }

    private void decreaseTimerNightRate(int n, int n2, boolean bl, boolean bl2) {
        if (this.getProfileListController().getProfileViaModelProfileListIndex(n) != null) {
            switch (n2) {
                case 0: {
                    this.nightRateHour(n, bl, bl2);
                    break;
                }
                case 1: {
                    this.nightRateMinutes(n, bl, bl2);
                    break;
                }
                case 2: {
                    this.nightRateAmPm(n, bl);
                    break;
                }
                default: {
                    this.getCarLogger().error("BatterManagerMainController.decreaseTimerNightRate:: Not valid time value");
                }
            }
        }
    }

    private void nightRateHour(int n, boolean bl, boolean bl2) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        BatteryControlPowerProviderCollector batteryControlPowerProviderCollector = batteryControlProfileCollector.getPowerProvider();
        if (bl) {
            batteryControlPowerProviderCollector.NR_StartHour = bl2 ? this.increaseHours(1, batteryControlPowerProviderCollector.NR_StartHour, 23, 0, this.isClockFormatAmPm, this.isAmNigthRateStart) : this.decreaseHours(1, batteryControlPowerProviderCollector.NR_StartHour, 23, 0, this.isClockFormatAmPm, this.isAmNigthRateStart);
        } else {
            batteryControlPowerProviderCollector.NR_EndHour = bl2 ? this.increaseHours(1, batteryControlPowerProviderCollector.NR_EndHour, 23, 0, this.isClockFormatAmPm, this.isAmNigthRateEnd) : this.decreaseHours(1, batteryControlPowerProviderCollector.NR_EndHour, 23, 0, this.isClockFormatAmPm, this.isAmNigthRateEnd);
        }
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
        this.memorizeIsAmNightRate(batteryControlPowerProviderCollector.NR_StartHour, batteryControlPowerProviderCollector.NR_EndHour);
    }

    private void nightRateMinutes(int n, boolean bl, boolean bl2) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        BatteryControlPowerProviderCollector batteryControlPowerProviderCollector = batteryControlProfileCollector.getPowerProvider();
        if (bl) {
            if (bl2) {
                batteryControlPowerProviderCollector.NR_StartMinutes = ASLCarUtil.increaseTimer(30, batteryControlPowerProviderCollector.NR_StartMinutes, 30, 0, this.isClockFormatAmPm, this.isAmNigthRateStart);
            } else {
                int n2 = 30 - batteryControlPowerProviderCollector.NR_StartMinutes == 60 ? 0 : 30 - batteryControlPowerProviderCollector.NR_StartMinutes;
                batteryControlPowerProviderCollector.NR_StartMinutes = n2;
            }
        } else if (bl2) {
            batteryControlPowerProviderCollector.NR_EndMinutes = ASLCarUtil.increaseTimer(30, batteryControlPowerProviderCollector.NR_EndMinutes, 30, 0, this.isClockFormatAmPm, this.isAmNigthRateEnd);
        } else {
            int n3 = 30 - batteryControlPowerProviderCollector.NR_EndMinutes == 60 ? 0 : 30 - batteryControlPowerProviderCollector.NR_EndMinutes;
            batteryControlPowerProviderCollector.NR_EndMinutes = n3;
        }
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    private void toggleNightRateOnMlb(BatteryControlProfileCollector batteryControlProfileCollector) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
            BatteryControlPowerProviderCollector batteryControlPowerProviderCollector = batteryControlProfileCollector.getPowerProvider();
            if (batteryControlPowerProviderCollector == null) {
                this.linkProfileWithPowerProvider(batteryControlProfileCollector);
                if (batteryControlProfileCollector.getPowerProvider() == null) {
                    this.getProfileListController().assignNewPowerProviderToProfile(batteryControlProfileCollector);
                }
                batteryControlPowerProviderCollector = batteryControlProfileCollector.getPowerProvider();
            }
            if (batteryControlPowerProviderCollector != null) {
                if (batteryControlProfileCollector.isNightRate()) {
                    batteryControlPowerProviderCollector.NR_StartHour = 23;
                    batteryControlPowerProviderCollector.NR_EndHour = 23;
                    batteryControlPowerProviderCollector.NR_StartMinutes = 0;
                    batteryControlPowerProviderCollector.NR_EndMinutes = 0;
                } else {
                    batteryControlPowerProviderCollector.NR_EndMinutes = ASLCarUtil.increaseTimer(30, batteryControlPowerProviderCollector.NR_EndMinutes, 30, 0, this.isClockFormatAmPm, this.isAmNigthRateEnd);
                }
                this.saveCurrentEditingProfilePowerProvider();
            }
        }
    }

    private void nightRateAmPm(int n, boolean bl) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        BatteryControlPowerProviderCollector batteryControlPowerProviderCollector = batteryControlProfileCollector.getPowerProvider();
        if (bl) {
            batteryControlPowerProviderCollector.NR_StartHour = ASLCarUtil.calculateAmPm(batteryControlPowerProviderCollector.NR_StartHour);
        } else {
            batteryControlPowerProviderCollector.NR_EndHour = ASLCarUtil.calculateAmPm(batteryControlPowerProviderCollector.NR_EndHour);
        }
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
        this.memorizeIsAmNightRate(batteryControlPowerProviderCollector.NR_StartHour, batteryControlPowerProviderCollector.NR_EndHour);
    }

    private void toggleStateOfNightRate(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
            this.toggleNightRateOnMlb(batteryControlProfileCollector);
        } else if (batteryControlProfileCollector.isNightRate()) {
            batteryControlProfileCollector.setPowerProvider(null);
        } else {
            this.linkProfileWithPowerProvider(batteryControlProfileCollector);
            if (batteryControlProfileCollector.getPowerProvider() == null) {
                this.getProfileListController().assignNewPowerProviderToProfile(batteryControlProfileCollector);
            }
        }
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    private void memorizeIsAmNightRate(int n, int n2) {
        if (this.isClockFormatAmPm) {
            this.isAmNigthRateStart = n < 12;
            this.isAmNigthRateEnd = n2 < 12;
        }
    }

    private int bringNightRateHourInRange(int n, int n2) {
        int n3 = 0;
        if (n2 >= 46 && n2 <= 59) {
            if (n != 23) {
                n3 = n + 1;
            }
        } else {
            n3 = n;
        }
        return n3;
    }

    private int bringNightRateMinuteInRange(int n) {
        int n2 = 0;
        if (n >= 1 && n <= 15) {
            n2 = 0;
        }
        if (n >= 16 && n <= 45) {
            n2 = 30;
        }
        if (n >= 46 && n <= 59) {
            n2 = 0;
        }
        return n2;
    }

    private void activateTimer(int n) {
        boolean bl = this.timers[n].isActivated = !this.timers[n].isActivated;
        if (this.timers[n].isCycle == 1) {
            BatteryControlTimer batteryControlTimer = new BatteryControlTimer(this.timers[n].year, this.timers[n].month, this.timers[n].day, this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], 0, 0, this.timers[n].posId);
            if (!ASLCarUtil.isSelectedTimerInSystemTimeRange(batteryControlTimer)) {
                BatteryControlTimer batteryControlTimer2 = ASLCarUtil.checkingTimerIsInRangeBatteryControl(batteryControlTimer, this.timers[n].timer_currentDay);
                this.getCarHybrid().setBatteryControlTimer(n + 1, batteryControlTimer2.year, batteryControlTimer2.month, batteryControlTimer2.day, batteryControlTimer2.hour, batteryControlTimer2.minute, this.weekDays_timers[n], batteryControlTimer2.refID);
                this.isSingleTimerOutOfRange[n] = true;
            }
            this.getCarHybrid().setBatteryControlTimerState(new BatteryControlProgrammedTimer(this.timers[0].isActivated, this.timers[1].isActivated, this.timers[2].isActivated, false));
        } else {
            this.getCarHybrid().setBatteryControlTimerState(new BatteryControlProgrammedTimer(this.timers[0].isActivated, this.timers[1].isActivated, this.timers[2].isActivated, false));
        }
    }

    private int increaseHours(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        int n6 = n3 = bl2 && bl ? 11 : n3;
        if (n2 < n3) {
            n5 = n2;
            n5 += n;
        } else {
            n5 = bl ? (bl2 ? 0 : 12) : n4;
        }
        return n5;
    }

    private int increaseMinutes(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5 = n2;
        if ((n5 += n) == ASLCarContainer.HOUR_IN_MINUTES) {
            n5 = n4;
        }
        return n5;
    }

    private int decreaseHours(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        if (n2 > n4) {
            n5 = n2;
            n5 = !bl2 && bl && n5 == 11 ? 23 : (n5 -= n);
        } else {
            n5 = bl2 && bl ? 11 : n3;
        }
        return n5;
    }

    private int decreaseMinutes(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5;
        if (n2 > n4) {
            n5 = n2;
            n5 -= n;
        } else {
            n5 = 55;
        }
        return n5;
    }

    private void refreshProfilesIsUsedByTimer() {
        int n = this.timers.length;
        for (int i2 = 0; i2 < n; ++i2) {
            this.timers[i2].refreshIsUsed();
        }
    }

    private void assignProfileToTimer(int n, int n2) {
        if (n2 != ProfileListController.INDEX_NOT_FOUND) {
            BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getProfileViaModelProfileListIndex(n2);
            this.timers[n].setProfile(batteryControlProfileCollector, n2);
            this.refreshProfilesIsUsedByTimer();
            this.updateTimers();
            if (!ASLCarUtil.checkingTimerIsInRange(this.timers[n].timeHours, this.timers[n].timeMinutes, this.timers[n].timer_currentDay)) {
                this.batteryManagerTarget.dsiCarHybrid.setBatteryControlTimer(BatterManagerMainController.mapTimerIdToDsiTimerEnum(n), ASLCarUtil.getDate(0).get(1) % 250, ASLCarUtil.getDate(0).get(2) + 1, ASLCarUtil.getDate(0).get(5), this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], this.timers[n].posId);
                this.timers[n].day = ASLCarUtil.getDate(0).get(5);
            } else {
                this.batteryManagerTarget.dsiCarHybrid.setBatteryControlTimer(BatterManagerMainController.mapTimerIdToDsiTimerEnum(n), ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(1) % 250, ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(2) + 1, ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(5), this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], this.timers[n].posId);
            }
        } else {
            this.getCarLogger().error("Wrong profile selection");
        }
    }

    private void settingUpWeekDays(int n, int n2) {
        this.timers[n].isCycle = 0;
        this.timers[n].timeWeekDays = this.days(this.timers[n].getTimeWeekDays(), n2);
        ListManager.getGenericASLList(10360).updateList(new Object[]{this.timers[n].timeWeekDays[0], this.timers[n].timeWeekDays[1], this.timers[n].timeWeekDays[2], this.timers[n].timeWeekDays[3], this.timers[n].timeWeekDays[4], this.timers[n].timeWeekDays[5], this.timers[n].timeWeekDays[6]});
        this.informingHMIAboutCurrentTimer();
    }

    private boolean[] days(boolean[] blArray, int n) {
        switch (n) {
            case 0: {
                boolean bl = blArray[0] = !blArray[0];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[0] = !blArray[0];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 1: {
                boolean bl = blArray[1] = !blArray[1];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[1] = !blArray[1];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 2: {
                boolean bl = blArray[2] = !blArray[2];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[2] = !blArray[2];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 3: {
                boolean bl = blArray[3] = !blArray[3];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[3] = !blArray[3];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 4: {
                boolean bl = blArray[4] = !blArray[4];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[4] = !blArray[4];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 5: {
                boolean bl = blArray[5] = !blArray[5];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[5] = !blArray[5];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 6: {
                boolean bl = blArray[6] = !blArray[6];
                if (!this.noWeekDayLeft(blArray)) break;
                blArray[6] = !blArray[6];
                this.batteryManagerTarget.sendHMIEvent(10022);
                break;
            }
            case 7: {
                for (int i2 = 0; i2 < blArray.length; ++i2) {
                    blArray[i2] = true;
                }
                break;
            }
        }
        return blArray;
    }

    private boolean noWeekDayLeft(boolean[] blArray) {
        int n = 0;
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            if (!blArray[i2]) continue;
            ++n;
        }
        return n == 0;
    }

    private static int mapTimerIdToDsiTimerEnum(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private void sendingNewTimerValues(int n) {
        this.getNextActiveTimer();
        if (this.timers[n].isCycle == 0) {
            this.weekDays_timers[n].cyclic = this.timers[n].isCycle == 0;
            this.weekDays_timers[n].monday = this.timers[n].timeWeekDays[0];
            this.weekDays_timers[n].tuesday = this.timers[n].timeWeekDays[1];
            this.weekDays_timers[n].wednesday = this.timers[n].timeWeekDays[2];
            this.weekDays_timers[n].thursday = this.timers[n].timeWeekDays[3];
            this.weekDays_timers[n].friday = this.timers[n].timeWeekDays[4];
            this.weekDays_timers[n].saturday = this.timers[n].timeWeekDays[5];
            this.weekDays_timers[n].sunday = this.timers[n].timeWeekDays[6];
            this.informHmiWeekDays(n);
            this.batteryManagerTarget.dsiCarHybrid.setBatteryControlTimer(BatterManagerMainController.mapTimerIdToDsiTimerEnum(n), 255, 255, 255, this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], this.timers[n].posId);
        } else {
            this.weekDays_timers[n].cyclic = false;
            if (!ASLCarUtil.checkingTimerIsInRange(this.timers[n].timeHours, this.timers[n].timeMinutes, this.timers[n].timer_currentDay)) {
                this.batteryManagerTarget.dsiCarHybrid.setBatteryControlTimer(BatterManagerMainController.mapTimerIdToDsiTimerEnum(n), ASLCarUtil.getDate(0).get(1) % 250, ASLCarUtil.getDate(0).get(2) + 1, ASLCarUtil.getDate(0).get(5), this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], this.timers[n].posId);
                this.timers[n].day = ASLCarUtil.getDate(0).get(5);
            } else {
                this.batteryManagerTarget.dsiCarHybrid.setBatteryControlTimer(BatterManagerMainController.mapTimerIdToDsiTimerEnum(n), ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(1) % 250, ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(2) + 1, ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(5), this.timers[n].timeHours, this.timers[n].timeMinutes, this.weekDays_timers[n], this.timers[n].posId);
            }
        }
    }

    int getWeekDayHmi(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        return -1;
    }

    private void increaseTimerBattery(int n, int n2) {
        switch (n2) {
            case 0: {
                this.timers[n].timeHours = this.increaseHours(1, this.timers[n].getHour(), 23, 0, this.isClockFormatAmPm, this.isAmTimer[n]);
                break;
            }
            case 1: {
                this.timers[n].timeMinutes = this.increaseMinutes(5, this.timers[n].getMinute(), 59, 0, this.isClockFormatAmPm, this.isAmTimer[n]);
                break;
            }
            case 2: {
                this.timers[n].timeHours = ASLCarUtil.calculateAmPm(this.timers[n].getHour());
                break;
            }
        }
        this.informingHMIAboutCurrentTimer();
    }

    private void decreaseTimerBattery(int n, int n2) {
        switch (n2) {
            case 0: {
                this.timers[n].timeHours = this.decreaseHours(1, this.timers[n].getHour(), 23, 0, this.isClockFormatAmPm, this.isAmTimer[n]);
                break;
            }
            case 1: {
                this.timers[n].timeMinutes = this.decreaseMinutes(5, this.timers[n].getMinute(), 59, 0, this.isClockFormatAmPm, this.isAmTimer[n]);
                break;
            }
            case 2: {
                this.timers[n].timeHours = ASLCarUtil.calculateAmPm(this.timers[n].getHour());
                break;
            }
        }
        this.informingHMIAboutCurrentTimer();
    }

    private void deIncreaseTimerBatteryWeekDay(boolean bl, int n) {
        this.timers[n].isCycle = 1;
        this.timers[n].timer_currentDay = bl ? ASLCarUtil.increaseWeekDay(this.timers[n].timer_currentDay) : ASLCarUtil.decreaseWeekDay(this.timers[n].timer_currentDay);
        this.timers[n].timeNextWeekDay = this.batteryManagerTarget.getWeekDayHmi(ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(7));
        this.timers[n].day = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(5);
        this.timers[n].month = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(2) + 1;
        this.timers[n].year = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(1);
        this.informingHMIAboutCurrentTimer();
    }

    private void selectWeekdayforSingleTimer(int n, int n2) {
        this.timers[n].isCycle = 1;
        this.timers[n].timer_currentDay = n2 + 1;
        this.timers[n].timeNextWeekDay = n2;
        this.timers[n].day = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(5);
        this.timers[n].month = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(2) + 1;
        this.timers[n].year = ASLCarUtil.getDate(this.timers[n].timer_currentDay).get(1);
        this.informingHMIAboutCurrentTimer();
    }

    private void informingHMIAboutCurrentTimer() {
        if (this.isClockFormatAmPm) {
            this.isAmTimer[0] = this.timers[0].getHour() < 12;
            this.isAmTimer[1] = this.timers[1].getHour() < 12;
            this.isAmTimer[2] = this.timers[2].getHour() < 12;
        }
        this.getNextActiveTimer();
        this.updateTimers();
    }

    void informHmiWeekDays(int n) {
        ListManager.getGenericASLList(10360).updateList(new Object[]{this.timers[n].timeWeekDays[0], this.timers[n].timeWeekDays[1], this.timers[n].timeWeekDays[2], this.timers[n].timeWeekDays[3], this.timers[n].timeWeekDays[4], this.timers[n].timeWeekDays[5], this.timers[n].timeWeekDays[6]});
    }

    private void fillTimerArray(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean[] blArray, boolean bl, boolean bl2) {
        if (n5 != 255) {
            n5 += 2000;
        }
        this.timers[n] = new BatteryControlTimerCollector(n3, n4, n5, n6, n7, n8, blArray, bl, bl2 ? 0 : 1, n2);
        this.timers[n].timer_currentDay = ASLCarUtil.informHMIBatteryControl(this.timers[n].getYear() + 2000, this.timers[n].getMonth(), this.timers[n].getDay()) + 1;
        this.informProfiles();
        this.updateTimers();
        this.informHmiWeekDays(n);
    }

    private void linkTimersWithProfileList() {
        for (BatteryControlTimerCollector batteryControlTimerCollector : this.timers) {
            batteryControlTimerCollector.profileListIndex = this.getProfileListController().getIndexOfProfileInModelProfileList(batteryControlTimerCollector.posId);
            if (batteryControlTimerCollector.profileListIndex != ProfileListController.INDEX_NOT_FOUND) {
                batteryControlTimerCollector.setProfile(this.getProfileListController().getProfileListElementByProfile(batteryControlTimerCollector.posId), batteryControlTimerCollector.profileListIndex);
                continue;
            }
            batteryControlTimerCollector.setProfile(null, 0);
        }
        this.refreshProfilesIsUsedByTimer();
        this.updateTimers();
    }

    private void updateTimers() {
        ListManager.getGenericASLList(10375).updateList(this.timers);
    }

    private int bringTimerMinuteInRange(int n) {
        int n2 = 0;
        if (n > 0) {
            n2 = n / 5 * 5;
        }
        return n2;
    }

    private void linkProfileWithPowerProvider(BatteryControlProfileCollector batteryControlProfileCollector) {
        int n = PowerProviderListController.INDEX_NOT_FOUND;
        n = ServiceManager.configManagerDiag.isFeatureFlagSet(101) ? this.getPowerProviderListController().getIndexOfProvider(batteryControlProfileCollector.posId) : this.getPowerProviderListController().getIndexOfProvider(batteryControlProfileCollector.getPowerProviderId());
        if (n != PowerProviderListController.INDEX_NOT_FOUND) {
            batteryControlProfileCollector.setPowerProvider(this.getPowerProviderListController().getPowerProviderElement(n));
        } else {
            batteryControlProfileCollector.setPowerProvider(null);
        }
    }

    private void linkProfileListWithPowerProviderList() {
        int n = this.getProfileListController().getProfileListSize();
        for (int i2 = 0; i2 < n; ++i2) {
            BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getProfileListElement(i2);
            this.linkProfileWithPowerProvider(batteryControlProfileCollector);
        }
        this.getProfileListController().updateListToModel();
    }

    void getNextActiveTimer() {
        if (!(this.timers[0].isActive() || this.timers[1].isActive() || this.timers[2].isActive())) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10368, this.TIMER_DEFAULT);
            ServiceManager.aslPropertyManager.valueChangedInteger(10335, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(10336, 0);
            ServiceManager.aslPropertyManager.valueChangedInteger(10334, 0);
        } else {
            int n;
            long[][] lArray = new long[3][2];
            lArray[0][0] = -1L;
            lArray[0][1] = -1L;
            lArray[1][0] = -1L;
            lArray[1][1] = -1L;
            lArray[2][0] = -1L;
            lArray[2][1] = -1L;
            long l = 0L;
            int n2 = -1;
            GregorianCalendar gregorianCalendar = new GregorianCalendar(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000, ASLCarContainer.getInstance().getMainUnitDate().getMonth() - 1, ASLCarContainer.getInstance().getMainUnitDate().getDay(), ASLCarContainer.getInstance().getMainUnitTime().getHours(), ASLCarContainer.getInstance().getMainUnitTime().getMinutes());
            long l2 = gregorianCalendar.getTimeInMillis();
            int n3 = gregorianCalendar.get(7);
            int[] nArray = new int[]{2, 3, 4, 5, 6, 7, 1};
            int[] nArray2 = new int[]{6, 0, 1, 2, 3, 4, 5};
            long l3 = -1L;
            int n4 = -1;
            long l4 = -1L;
            int n5 = -1;
            for (n = 0; n < this.timers.length; ++n) {
                if (!this.timers[n].isActive()) continue;
                if (this.timers[n].isCycle == 0) {
                    for (int i2 = 0; i2 < this.timers[n].timeWeekDays.length; ++i2) {
                        GregorianCalendar gregorianCalendar2;
                        if (!this.timers[n].timeWeekDays[i2]) continue;
                        GregorianCalendar gregorianCalendar3 = ASLCarUtil.getDate(i2 + 1);
                        l4 = -1L;
                        n5 = -1;
                        if (nArray[i2 % nArray.length] == n3) {
                            if (this.isTraceEnabled()) {
                                this.batteryManagerTarget.trace().append("Battery Today Timer: ").append(n).append(" ").append(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000).append(" ").append(ASLCarContainer.getInstance().getMainUnitDate().getMonth()).append(" ").append(ASLCarContainer.getInstance().getMainUnitDate().getDay()).append(" ").append(this.timers[n].getHour()).append(" ").append(this.timers[n].getMinute()).log();
                            }
                            gregorianCalendar2 = new GregorianCalendar(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000, ASLCarContainer.getInstance().getMainUnitDate().getMonth() - 1, ASLCarContainer.getInstance().getMainUnitDate().getDay(), this.timers[n].getHour(), this.timers[n].getMinute());
                            l4 = gregorianCalendar2.getTimeInMillis();
                            n5 = this.getWeekDayHmi(gregorianCalendar2.get(7));
                            if (l4 <= l2) {
                                gregorianCalendar2 = new GregorianCalendar(gregorianCalendar3.get(1), gregorianCalendar3.get(2), gregorianCalendar3.get(5), this.timers[n].getHour(), this.timers[n].getMinute());
                                l4 = gregorianCalendar2.getTimeInMillis();
                                n5 = this.getWeekDayHmi(gregorianCalendar2.get(7));
                            }
                        } else {
                            gregorianCalendar2 = new GregorianCalendar(gregorianCalendar3.get(1), gregorianCalendar3.get(2), gregorianCalendar3.get(5), this.timers[n].getHour(), this.timers[n].getMinute());
                            l4 = gregorianCalendar2.getTimeInMillis();
                            n5 = this.getWeekDayHmi(gregorianCalendar2.get(7));
                        }
                        if (l3 == -1L) {
                            l3 = l4;
                            n4 = n5;
                            continue;
                        }
                        if (l4 <= l2 || l4 >= l3) continue;
                        l3 = l4;
                        n4 = n5;
                    }
                    lArray[n][0] = l3;
                    lArray[n][1] = n4;
                    l3 = -1L;
                    continue;
                }
                if (this.isTraceEnabled()) {
                    this.batteryManagerTarget.trace().append("Battery Timer: ").append(n).append(" ").append(this.timers[n].year).append(" ").append(this.timers[n].month).append(" ").append(this.timers[n].day).append(" ").append(this.timers[n].getHour()).append(" ").append(this.timers[n].getMinute()).log();
                }
                lArray[n][0] = new GregorianCalendar(this.timers[n].year, this.timers[n].month - 1, this.timers[n].day, this.timers[n].getHour(), this.timers[n].getMinute()).getTimeInMillis();
                lArray[n][1] = this.timers[n].timeNextWeekDay;
            }
            for (n = 0; n < lArray.length; ++n) {
                if (lArray[n][0] == -1L) continue;
                if (l == 0L) {
                    l = lArray[n][0];
                    n2 = n;
                    continue;
                }
                long l5 = lArray[n][0];
                if (l5 >= l) continue;
                l = l5;
                n2 = n;
            }
            if (n2 != -1) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(l);
                BatteryControlTimerCollector batteryControlTimerCollector = this.timers[n2];
                boolean bl = false;
                if (calendar.get(7) == n3) {
                    if (batteryControlTimerCollector.getHour() > ASLCarContainer.getInstance().getMainUnitTime().getHours()) {
                        bl = true;
                    } else if (batteryControlTimerCollector.getHour() == ASLCarContainer.getInstance().getMainUnitTime().getHours() && batteryControlTimerCollector.getMinute() > ASLCarContainer.getInstance().getMainUnitTime().getMinutes()) {
                        bl = true;
                    }
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(10369, bl);
                ServiceManager.aslPropertyManager.valueChangedInteger(10335, this.timers[n2].getHour());
                ServiceManager.aslPropertyManager.valueChangedInteger(10336, this.timers[n2].getMinute());
                ServiceManager.aslPropertyManager.valueChangedInteger(10334, (int)lArray[n2][1]);
                if (this.isProfileListLoaded && this.timers[n2].profileListIndex != ProfileListController.INDEX_NOT_FOUND) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(10338, this.timers[n2].getProfile().isAirConditioning);
                    ServiceManager.aslPropertyManager.valueChangedBoolean(10337, this.timers[n2].getProfile().isCharing);
                    ServiceManager.aslPropertyManager.valueChangedString(10340, this.timers[n2].getProfile().profileName);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10339, this.timers[n2].getProfile().targetChargeLevel);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10368, n2);
                    ServiceManager.aslPropertyManager.valueChangedInteger(10484, CarE_TractionProfileListTransformer.maxCurrentProfileHmi(this.timers[n2].getProfile().maxCurrent));
                }
            }
            this.startNextActiveTimerCalulcationTimer(lArray[n2][0]);
        }
    }

    public boolean checkIsToday(int n, int n2, int n3) {
        boolean bl = false;
        if (ASLCarUtil.getDate(0).get(7) == ASLCarUtil.getDate(n3).get(7)) {
            if (ASLCarContainer.getInstance().getMainUnitTime().getHours() < n) {
                bl = true;
            } else if (ASLCarContainer.getInstance().getMainUnitTime().getHours() == n && ASLCarContainer.getInstance().getMainUnitTime().getMinutes() <= n2) {
                bl = true;
            }
        }
        return bl;
    }

    void activeStateOfTimer(int n, boolean bl) {
        this.timers[n].isActivated = bl;
    }

    private static boolean isTimerProgrammed(boolean bl, boolean bl2) {
        return bl;
    }

    private void startNextActiveTimerCalulcationTimer(long l) {
        long l2;
        if (l != -1L && (l2 = this.nextActiveTimerCalulcationDelay(l)) > 0L) {
            this.getNextActiveTimerCalulcationTimer(l2);
            if (this.activeTimerExpire != null) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric.setReceiverEventId(-1568276224);
                this.activeTimerExpire.retrigger(eventGeneric);
            }
        }
    }

    private Timer getNextActiveTimerCalulcationTimer(long l) {
        if (this.activeTimerExpire != null && this.activeTimerExpire.isRunning()) {
            this.activeTimerExpire.stop();
        }
        if (l > 0L) {
            this.activeTimerExpire = BapArrayFactory.getInstance().createBapArrayTimer(this, l);
        }
        return this.activeTimerExpire;
    }

    private long nextActiveTimerCalulcationDelay(long l) {
        long l2 = 0L;
        long l3 = new GregorianCalendar(ASLCarContainer.getInstance().getMainUnitDate().getYear() + 2000, ASLCarContainer.getInstance().getMainUnitDate().getMonth() - 1, ASLCarContainer.getInstance().getMainUnitDate().getDay(), ASLCarContainer.getInstance().getMainUnitTime().getHours(), ASLCarContainer.getInstance().getMainUnitTime().getMinutes()).getTimeInMillis();
        l2 = l - l3;
        if (l2 < 0L) {
            l2 = 0L;
        }
        return l2;
    }

    private void informProfiles() {
        if (this.isProfileListLoaded) {
            this.linkTimersWithProfileList();
            if (this.isPowerProviderListLoaded) {
                this.linkProfileListWithPowerProviderList();
            }
            this.getNextActiveTimer();
        }
    }

    private void setGlobalSettingAirConditionTemp(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getGlobalProfile();
        batteryControlProfileCollector.temperatureValue = batteryControlProfileCollector.temperatureUnit == 0 ? n - 100 : (n / 10 - 50) * 4;
        this.getProfileListController().modifyProfileSliderAttributes(batteryControlProfileCollector);
    }

    private void toogleGlobalSettingAirCondition() {
        BatteryControlProfileCollector batteryControlProfileCollector;
        batteryControlProfileCollector.setClimateWithoutExternalSupply(!(batteryControlProfileCollector = this.getProfileListController().getGlobalProfile()).isClimateWithoutExternalSupply());
        this.getProfileListController().modifyProfileAttributes(batteryControlProfileCollector, 0);
    }

    private void deIncreaseGlobalSettingsMinimumSoc(boolean bl) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getGlobalProfile();
        int n = ASLCarUtil.durationTimeMinMaxValue(bl, batteryControlProfileCollector.getMinChargeLevel(), 10, 0, 100);
        if (n != -1) {
            this.setGlobalSettingMinimumSoc(n);
        }
    }

    private void setGlobalSettingMinimumSoc(int n) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getProfileListController().getGlobalProfile();
        batteryControlProfileCollector.setMinChargeLevel(n);
        this.getProfileListController().modifyProfileSliderAttributes(batteryControlProfileCollector);
    }

    private void deIncreaseProfileSoc(int n, boolean bl) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        int n2 = ASLCarUtil.durationTimeMinMaxValue(bl, batteryControlProfileCollector.targetChargeLevel, 10, 0, 100);
        if (n2 != -1) {
            batteryControlProfileCollector.targetChargeLevel = n2;
            this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
        } else {
            this.getCarLogger().error("deIncreaseProfileSoc: Invalid value");
        }
    }

    private void setProfileSoc(int n, int n2) {
        BatteryControlProfileCollector batteryControlProfileCollector = this.getCurrentEditingProfileData(n);
        batteryControlProfileCollector.targetChargeLevel = n2;
        this.getProfileListController().updateListElementToModel(batteryControlProfileCollector, n);
    }

    public void initValues() {
        this.timers[0] = new BatteryControlTimerCollector(0, 0, 0, 0, 0, 0, ASLCarE_TractionPropertyManager.TIMER_LIST__TIMER_LIST__DEPARTURE_TIME_WEEK_DAYS__DEFAULT_VALUE, false, 1, 0);
        this.timers[1] = new BatteryControlTimerCollector(0, 0, 0, 0, 0, 0, ASLCarE_TractionPropertyManager.TIMER_LIST__TIMER_LIST__DEPARTURE_TIME_WEEK_DAYS__DEFAULT_VALUE, false, 1, 0);
        this.timers[2] = new BatteryControlTimerCollector(0, 0, 0, 0, 0, 0, ASLCarE_TractionPropertyManager.TIMER_LIST__TIMER_LIST__DEPARTURE_TIME_WEEK_DAYS__DEFAULT_VALUE, false, 1, 0);
        this.updateTimers();
        this.weekDays_timers[0] = new BatteryControlWeekdays();
        this.weekDays_timers[1] = new BatteryControlWeekdays();
        this.weekDays_timers[2] = new BatteryControlWeekdays();
        ListManager.getGenericASLList(10374).updateList(new BatteryControlProfileCollector[]{new BatteryControlProfileCollector(0, 0, 0, 1, 100, "", false, false, false, false, 0, 0, false, false, 0, 0, 0, 0, false, 0, 0, 0, false, false, false, false, false, false, false)});
        ListManager.getGenericASLList(10360).updateList(new Object[]{Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE});
        ServiceManager.aslPropertyManager.valueChangedInteger(10335, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(10336, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(10334, 0);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10338, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10337, false);
        ServiceManager.aslPropertyManager.valueChangedString(10340, "");
        ServiceManager.aslPropertyManager.valueChangedInteger(10339, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(10368, 0);
    }

    private void resetBev(int n) {
        if (n == 8 || n == 0) {
            this.batteryManagerTarget.dsiCarHybrid.setBatteryControlSetFactoryDefault();
        }
    }

    @Override
    public void timerFired(Timer timer) {
        EventGeneric eventGeneric = (EventGeneric)timer.getUserInfo();
        switch (eventGeneric.getReceiverEventId()) {
            case 100002: {
                this.getNextActiveTimer();
                break;
            }
        }
    }

    private EtrakServiceListener getEtrakServiceListener() {
        return (EtrakServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener == null ? (class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener = BatterManagerMainController.class$("de.vw.mib.asl.api.car.e_traction.EtrakServiceListener")) : class$de$vw$mib$asl$api$car$e_traction$EtrakServiceListener);
    }

    @Override
    public boolean getEtrakAvailableStatus() {
        return this.curentViewOptions.getProfileList().getState() == 2;
    }

    private void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$e_traction$EtrakService == null ? (class$de$vw$mib$asl$api$car$e_traction$EtrakService = BatterManagerMainController.class$("de.vw.mib.asl.api.car.e_traction.EtrakService")) : class$de$vw$mib$asl$api$car$e_traction$EtrakService, this);
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

