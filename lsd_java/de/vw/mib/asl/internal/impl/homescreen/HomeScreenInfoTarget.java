/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.system.clock.DateTimeService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfo;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.internal.homescreen.HomeScreenServices;
import de.vw.mib.asl.internal.impl.homescreen.AbstractHomeScreenTarget;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget$1;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget$2;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget$3;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget$4;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HomeScreenInfoTarget
extends AbstractHomeScreenTarget {
    private final ASLPropertyManager aslPropertyManager;
    private final PersonalizationService personalizationService;
    private final FactoryResetService factoryResetService;
    private final HomescreenPersistenceService persistenceService;
    private final DateTimeService dateTimeService;
    private HomescreenInfo homescreenInfo;

    public HomeScreenInfoTarget(HomeScreenServices homeScreenServices) {
        super(homeScreenServices.getGenericEvents(), homeScreenServices.getLogger(), -1240000000);
        this.aslPropertyManager = homeScreenServices.getASLPropertyManager();
        this.persistenceService = homeScreenServices.getHomeScreenPersistenceService();
        this.homescreenInfo = this.persistenceService.loadHomescreenInfo();
        this.personalizationService = homeScreenServices.getPersonalizationService();
        this.dateTimeService = homeScreenServices.getDateTimeService();
        this.factoryResetService = homeScreenServices.getFactoryResetService();
        this.registerPersonalizationListener();
        this.registerDateTimeListener();
        this.registerProfileChangeListener();
        this.registerFactoryResetParticipant();
        this.registerObservers(homeScreenServices.getServiceRegister());
        this.updateProfileNameDatapool(this.personalizationService.getActiveProfileName());
        this.updateClockLayoutDatapool(this.homescreenInfo.getClockLayout());
        this.updateTimeDate(this.dateTimeService.getGregorianCalendar());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1078641828: {
                int n = eventGeneric.getInt(0);
                this.homescreenInfo.setClockLayout(n);
                this.updateClockLayoutDatapool(n);
                break;
            }
        }
    }

    void updateTimeDatapool(byte by, byte by2, byte by3) {
        this.aslPropertyManager.valueChangedInteger(-1226094080, by);
        this.aslPropertyManager.valueChangedInteger(-1209316864, by2);
        this.aslPropertyManager.valueChangedInteger(-1192539648, by3);
    }

    void updateProfileNameDatapool(String string) {
        this.aslPropertyManager.valueChangedString(-1259648512, string);
    }

    void loadDataFromHomescreenInfoAppPersistence() {
        this.homescreenInfo = this.persistenceService.loadHomescreenInfo();
        this.refreshHomeScreen();
    }

    void resetHomeScreen() {
        this.homescreenInfo.setClockLayout(0);
        this.refreshHomeScreen();
    }

    void updateDateDatapool(short s, byte by, byte by2) {
        this.aslPropertyManager.valueChangedInteger(-1142208000, s);
        this.aslPropertyManager.valueChangedInteger(-1158985216, by);
        this.aslPropertyManager.valueChangedInteger(-1175762432, by2);
        int n = this.calcDayOfWeek(s, by, by2);
        this.aslPropertyManager.valueChangedInteger(-1276425728, n);
    }

    private void updateTimeDate(GregorianCalendar gregorianCalendar) {
        this.initTime(gregorianCalendar);
        this.initDate(gregorianCalendar);
    }

    private void initTime(Calendar calendar) {
        byte by = (byte)calendar.get(11);
        byte by2 = (byte)calendar.get(12);
        byte by3 = (byte)calendar.get(13);
        this.updateTimeDatapool(by, by2, by3);
    }

    private void initDate(Calendar calendar) {
        short s = (short)calendar.get(1);
        byte by = (byte)(calendar.get(2) + 1);
        byte by2 = (byte)calendar.get(5);
        this.updateDateDatapool(s, by, by2);
    }

    private int calcDayOfWeek(short s, byte by, byte by2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(s, by - 1, by2);
        switch (gregorianCalendar.get(7)) {
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
            case 1: {
                return 6;
            }
        }
        return 0;
    }

    private void refreshHomeScreen() {
        this.updateProfileNameDatapool(this.personalizationService.getActiveProfileName());
        this.updateClockLayoutDatapool(this.homescreenInfo.getClockLayout());
    }

    private void updateClockLayoutDatapool(int n) {
        this.aslPropertyManager.valueChangedInteger(-1242871296, n);
    }

    private void registerPersonalizationListener() {
        HomeScreenInfoTarget$1 homeScreenInfoTarget$1 = new HomeScreenInfoTarget$1(this);
        this.personalizationService.addListener(homeScreenInfoTarget$1);
    }

    private void registerProfileChangeListener() {
        HomeScreenInfoTarget$2 homeScreenInfoTarget$2 = new HomeScreenInfoTarget$2(this);
        this.persistenceService.addProfileChangeListener(homeScreenInfoTarget$2);
    }

    private void registerFactoryResetParticipant() {
        HomeScreenInfoTarget$3 homeScreenInfoTarget$3 = new HomeScreenInfoTarget$3(this);
        this.factoryResetService.addParticipant(homeScreenInfoTarget$3, FactoryResetComponents.SYSTEM);
    }

    private void registerDateTimeListener() {
        HomeScreenInfoTarget$4 homeScreenInfoTarget$4 = new HomeScreenInfoTarget$4(this);
        this.dateTimeService.addListener(homeScreenInfoTarget$4);
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(-1530639808, this.getTargetId());
    }
}

