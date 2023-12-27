/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkHeater;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer1Collector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer2Collector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateParkHeatingTimer3Collector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler;
import org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;

public class ASLTargetCarParkHeater
extends AbstractASLTarget {
    private DSICarAuxHeaterCooler dsiCarAuxHeaterCooler;
    private DSICarAuxHeaterCoolerListener dsiCarAuxHeaterCoolerListener;
    private DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage;
    private ClimateParkHeatingTimer1Collector myCollectorTimer1;
    private ClimateParkHeatingTimer1Collector[] myCollectorTimer1Array;
    private ClimateParkHeatingTimer2Collector myCollectorTimer2;
    private ClimateParkHeatingTimer2Collector[] myCollectorTimer2Array;
    private ClimateParkHeatingTimer3Collector myCollectorTimer3;
    private ClimateParkHeatingTimer3Collector[] myCollectorTimer3Array;
    private boolean isParkHeatingModus = false;
    private AuxHeaterCoolerTimer dsiTimer1;
    private AuxHeaterCoolerTimer dsiTimer2;
    private AuxHeaterCoolerTimer dsiTimer3;
    private boolean isClockFormatAmPm = false;
    private boolean isAmTimer1 = false;
    private boolean isAmTimer2 = false;
    private boolean isAmTimer3 = false;
    private int arrayPositionTimer1 = 0;
    private int arrayPositionTimer2 = 0;
    private int arrayPositionTimer3 = 0;
    private int myActiveTimer = -1;
    private boolean isNotify = false;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener;

    public ASLTargetCarParkHeater(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -2058415616;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{-285212608, -301989824, -318767040, -335544256, -50331584, -67108800, 1107886144});
    }

    private void registerOnCarAuxHeaterCooler() {
        this.dsiCarAuxHeaterCooler.setNotification(new int[]{4, 6, 9, 3, 14, 13}, (DSIListener)this.dsiCarAuxHeaterCoolerListener);
    }

    void registerOnCarTimeUnitsLanguage() {
        this.dsiCarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = ASLTargetCarParkHeater.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
        this.dsiCarTimeUnitsLanguage.setNotification(new int[]{2, 3, 19}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = ASLTargetCarParkHeater.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener));
    }

    void registerOnAUXHeaterTimer() {
        this.dsiCarAuxHeaterCooler.setNotification(new int[]{10, 11, 12}, (DSIListener)this.dsiCarAuxHeaterCoolerListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("CLIMATE Event received: ").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.myCollectorTimer1 = new ClimateParkHeatingTimer1Collector();
                this.myCollectorTimer1Array = new ClimateParkHeatingTimer1Collector[]{this.myCollectorTimer1};
                this.myCollectorTimer2 = new ClimateParkHeatingTimer2Collector();
                this.myCollectorTimer2Array = new ClimateParkHeatingTimer2Collector[]{this.myCollectorTimer2};
                this.myCollectorTimer3 = new ClimateParkHeatingTimer3Collector();
                this.myCollectorTimer3Array = new ClimateParkHeatingTimer3Collector[]{this.myCollectorTimer3};
                this.dsiCarAuxHeaterCooler = (DSICarAuxHeaterCooler)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler = ASLTargetCarParkHeater.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCooler")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCooler);
                this.dsiCarAuxHeaterCoolerListener = (DSICarAuxHeaterCoolerListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener == null ? (class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener = ASLTargetCarParkHeater.class$("org.dsi.ifc.carauxheatercooler.DSICarAuxHeaterCoolerListener")) : class$org$dsi$ifc$carauxheatercooler$DSICarAuxHeaterCoolerListener);
                this.isParkHeatingModus = true;
                this.registerOnModelEvents();
                this.registerOnCarAuxHeaterCooler();
                this.registerOnAUXHeaterTimer();
                this.registerOnCarTimeUnitsLanguage();
                this.initParkHeater();
                break;
            }
            case 1073742063: {
                this.increaseParkHeatingTime(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 0x400000EE: {
                this.decreaseParkHeatingTime(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073742061: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerRunningTime((short)eventGeneric.getInt(0));
                break;
            }
            case 1073742060: {
                this.settingUpActiveTimer(eventGeneric.getInt(0));
                break;
            }
            case 1073742077: {
                this.toggelParkHeatingModus(!this.isParkHeatingModus);
                break;
            }
            case 1073742076: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerOnOff(false);
                break;
            }
            case 1073744194: {
                this.applyTimers(eventGeneric.getInt(0));
                break;
            }
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerActiveTimer(int n, int n2) {
        this.myActiveTimer = n;
        switch (n) {
            case 0: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(293, -1);
                break;
            }
            case 1: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(293, 0);
                break;
            }
            case 2: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(293, 1);
                break;
            }
            case 3: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(293, 2);
                break;
            }
            default: {
                this.error("Active Timer does not exists in Climate");
            }
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.dsiTimer1 = auxHeaterCoolerTimer;
        if (this.isTraceEnabled()) {
            this.trace().append("Parkheater timer 1: ").append(this.dsiTimer1.getDay()).append(".").append(this.dsiTimer1.getMonth()).append(".").append(this.dsiTimer1.getYear()).log();
        }
        if (!ASLCarUtil.isInRange(this.dsiTimer1)) {
            this.myCollectorTimer1.climate_park_heating_timer1day = ASLCarUtil.informHMIParkHeater1Day(this.dsiTimer1);
            this.calcNewDateTimer1();
        } else if (ASLCarUtil.evaluateMinuteParkheater(auxHeaterCoolerTimer)) {
            this.informingHmiTimer1(auxHeaterCoolerTimer);
        } else {
            this.dsiTimer1.minute = (short)(auxHeaterCoolerTimer.getMinute() - ASLCarUtil.double2IntArray((float)((double)auxHeaterCoolerTimer.getMinute() / 10.0), 1)[1]);
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer1(this.dsiTimer1);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.dsiTimer2 = auxHeaterCoolerTimer;
        if (this.isTraceEnabled()) {
            this.trace().append("Parkheater timer 2: ").append(this.dsiTimer2.getDay()).append(".").append(this.dsiTimer2.getMonth()).append(".").append(this.dsiTimer2.getYear()).log();
        }
        if (!ASLCarUtil.isInRange(this.dsiTimer2)) {
            this.myCollectorTimer2.climate_park_heating_timer2day = ASLCarUtil.informHMIParkHeater2Day(this.dsiTimer2);
            this.calcNewDateTimer2();
        } else if (ASLCarUtil.evaluateMinuteParkheater(auxHeaterCoolerTimer)) {
            this.informingHmiTimer2(auxHeaterCoolerTimer);
        } else {
            this.dsiTimer2.minute = (short)(auxHeaterCoolerTimer.getMinute() - ASLCarUtil.double2IntArray((float)((double)auxHeaterCoolerTimer.getMinute() / 10.0), 1)[1]);
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer2(this.dsiTimer2);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.dsiTimer3 = auxHeaterCoolerTimer;
        if (this.isTraceEnabled()) {
            this.trace().append("Parkheater timer 3: ").append(this.dsiTimer3.getDay()).append(".").append(this.dsiTimer3.getMonth()).append(new StringBuffer().append(".").append(this.dsiTimer3.getYear()).toString()).log();
        }
        if (!ASLCarUtil.isInRange(this.dsiTimer3)) {
            this.myCollectorTimer3.climate_park_heating_timer3day = ASLCarUtil.informHMIParkHeater3Day(this.dsiTimer3);
            this.calcNewDateTimer3();
        } else if (ASLCarUtil.evaluateMinuteParkheater(auxHeaterCoolerTimer)) {
            this.informingHmiTimer3(auxHeaterCoolerTimer);
        } else {
            this.dsiTimer3.minute = (short)(auxHeaterCoolerTimer.getMinute() - ASLCarUtil.double2IntArray((float)((double)auxHeaterCoolerTimer.getMinute() / 10.0), 1)[1]);
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer3(this.dsiTimer3);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerOnOff(boolean bl, int n) {
        if (!bl) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(305, 0);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerDefaultStartMode(int n, int n2) {
        switch (n) {
            case 2: {
                this.isParkHeatingModus = true;
                ASLTargetCarParkHeater.writeIntegerToDatapool(306, 0);
                break;
            }
            case 1: {
                this.isParkHeatingModus = false;
                ASLTargetCarParkHeater.writeIntegerToDatapool(306, 1);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("NO INFORMATION FOR HMI: ").append(n).log();
            }
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        if (auxHeaterCoolerErrorReason.isBatteryLow() && auxHeaterCoolerErrorReason.isFuelLow()) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 3);
        } else if (auxHeaterCoolerErrorReason.isBatteryLow()) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 2);
        } else if (auxHeaterCoolerErrorReason.isFuelLow()) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 1);
        } else if (auxHeaterCoolerErrorReason.isHeaterDefect()) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 4);
        } else if (auxHeaterCoolerErrorReason.isMaxOperationTime()) {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 5);
        } else {
            ASLTargetCarParkHeater.writeIntegerToDatapool(-273874688, 0);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerRunningTime(short s, int n) {
        if (s < 10 || s > 60) {
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerRunningTime((short)10);
        } else {
            ASLTargetCarParkHeater.writeIntegerToDatapool(301, s);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerState(int n, int n2) {
        switch (n) {
            case 0: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(305, 0);
                break;
            }
            case 1: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(305, 1);
                break;
            }
            case 2: {
                ASLTargetCarParkHeater.writeIntegerToDatapool(305, 2);
                break;
            }
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateClockTime(ClockTime clockTime, int n) {
        ASLCarContainer.getInstance().setMainUnitTime(clockTime);
    }

    public void dsiCarTimeUnitsLanguageUpdateClockFormat(int n, int n2) {
        this.isClockFormatAmPm = n == 1;
    }

    public void dsiCarTimeUnitsLanguageUpdateClockDate(ClockDate clockDate, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("New Date: ").append(clockDate.getDay()).append(".").append(clockDate.getMonth()).append(".").append(clockDate.getYear() + 2000).log();
        }
        ASLCarContainer.getInstance().setMainUnitDate(clockDate);
        ASLCarUtil.calculateNextRange(clockDate);
        if (!this.isNotify) {
            this.registerOnAUXHeaterTimer();
            this.isNotify = true;
        } else {
            this.checkTimer1IsInRange();
            this.checkTimer2IsInRange();
            this.checkTimer3IsInRange();
        }
    }

    private void initParkHeater() {
        this.dsiTimer1 = new AuxHeaterCoolerTimer(0, 0, 0, 2255, 255, 255, 3);
        this.dsiTimer2 = new AuxHeaterCoolerTimer(0, 0, 0, 2255, 255, 255, 3);
        this.dsiTimer3 = new AuxHeaterCoolerTimer(0, 0, 0, 2255, 255, 255, 3);
        this.myCollectorTimer1.climate_park_heating_timer1day = 0;
        this.myCollectorTimer1.climate_park_heating_timer1hour = 0;
        this.myCollectorTimer1.climate_park_heating_timer1minute = 0;
        this.myCollectorTimer1.climate_park_heating_timer1set = false;
        this.myCollectorTimer2.climate_park_heating_timer2day = 0;
        this.myCollectorTimer2.climate_park_heating_timer2hour = 0;
        this.myCollectorTimer2.climate_park_heating_timer2minute = 0;
        this.myCollectorTimer2.climate_park_heating_timer2set = false;
        this.myCollectorTimer3.climate_park_heating_timer3day = 0;
        this.myCollectorTimer3.climate_park_heating_timer3hour = 0;
        this.myCollectorTimer3.climate_park_heating_timer3minute = 0;
        this.myCollectorTimer3.climate_park_heating_timer3set = false;
        ListManager.getGenericASLList(328).updateList(this.myCollectorTimer1Array);
        ListManager.getGenericASLList(329).updateList(this.myCollectorTimer2Array);
        ListManager.getGenericASLList(330).updateList(this.myCollectorTimer3Array);
    }

    private void increaseParkHeatingTime(int n, int n2) {
        switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.increaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer1.climate_park_heating_timer1hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer1), this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer1.climate_park_heating_timer1hour, ASLCarUtil.increaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer1.climate_park_heating_timer1minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer1), this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer1 = ASLCarUtil.toIncrease(this.arrayPositionTimer1);
                        this.parkHeaterTimer(this.myCollectorTimer1.climate_park_heating_timer1hour, this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer1.climate_park_heating_timer1hour), this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                }
                this.informingHmiTimer1(this.dsiTimer1);
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.increaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer2.climate_park_heating_timer2hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer2), this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer2.climate_park_heating_timer2hour, ASLCarUtil.increaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer2.climate_park_heating_timer2minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer2), this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer2 = ASLCarUtil.toIncrease(this.arrayPositionTimer2);
                        this.parkHeaterTimer(this.myCollectorTimer2.climate_park_heating_timer2hour, this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer2.climate_park_heating_timer2hour), this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                }
                this.informingHmiTimer2(this.dsiTimer2);
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.increaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer3.climate_park_heating_timer3hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer3), this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer3.climate_park_heating_timer3hour, ASLCarUtil.increaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer3.climate_park_heating_timer3minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer3), this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer3 = ASLCarUtil.toIncrease(this.arrayPositionTimer3);
                        this.parkHeaterTimer(this.myCollectorTimer3.climate_park_heating_timer3hour, this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer3.climate_park_heating_timer3hour), this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                }
                this.informingHmiTimer3(this.dsiTimer3);
                break;
            }
        }
    }

    private void decreaseParkHeatingTime(int n, int n2) {
        switch (n) {
            case 0: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer1.climate_park_heating_timer1hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer1), this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer1.climate_park_heating_timer1hour, ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer1.climate_park_heating_timer1minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer1), this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer1 = ASLCarUtil.toDecrease(this.arrayPositionTimer1);
                        this.parkHeaterTimer(this.myCollectorTimer1.climate_park_heating_timer1hour, this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer1.climate_park_heating_timer1hour), this.myCollectorTimer1.climate_park_heating_timer1minute, this.arrayPositionTimer1, this.dsiTimer1);
                        break;
                    }
                }
                this.informingHmiTimer1(this.dsiTimer1);
                break;
            }
            case 1: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer2.climate_park_heating_timer2hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer2), this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer2.climate_park_heating_timer2hour, ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer2.climate_park_heating_timer2minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer2), this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer2 = ASLCarUtil.toDecrease(this.arrayPositionTimer2);
                        this.parkHeaterTimer(this.myCollectorTimer2.climate_park_heating_timer2hour, this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer2.climate_park_heating_timer2hour), this.myCollectorTimer2.climate_park_heating_timer2minute, this.arrayPositionTimer2, this.dsiTimer2);
                        break;
                    }
                }
                this.informingHmiTimer2(this.dsiTimer2);
                break;
            }
            case 2: {
                switch (n2) {
                    case 0: {
                        this.parkHeaterTimer(ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_HOUR, this.myCollectorTimer3.climate_park_heating_timer3hour, 23, 0, this.isClockFormatAmPm, this.isAmTimer3), this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 1: {
                        this.parkHeaterTimer(this.myCollectorTimer3.climate_park_heating_timer3hour, ASLCarUtil.decreaseTimer(ASLCarContainer.STEP_MINUTES, this.myCollectorTimer3.climate_park_heating_timer3minute, 55, 0, this.isClockFormatAmPm, this.isAmTimer3), this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 2: {
                        this.arrayPositionTimer3 = ASLCarUtil.toDecrease(this.arrayPositionTimer3);
                        this.parkHeaterTimer(this.myCollectorTimer3.climate_park_heating_timer3hour, this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                    case 3: {
                        this.parkHeaterTimer(ASLCarUtil.calculateAmPm(this.myCollectorTimer3.climate_park_heating_timer3hour), this.myCollectorTimer3.climate_park_heating_timer3minute, this.arrayPositionTimer3, this.dsiTimer3);
                        break;
                    }
                }
                this.informingHmiTimer3(this.dsiTimer3);
                break;
            }
        }
    }

    private void parkHeaterTimer(int n, int n2, int n3, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        auxHeaterCoolerTimer.hour = (short)n;
        auxHeaterCoolerTimer.minute = (short)n2;
        auxHeaterCoolerTimer.dateMode = (short)(n3 == 0 ? 3 : 0);
        auxHeaterCoolerTimer.year = (short)(auxHeaterCoolerTimer.dateMode == 3 ? 2255 : (short)ASLCarUtil.getDate(n3).get(1));
        auxHeaterCoolerTimer.month = (short)(auxHeaterCoolerTimer.dateMode == 3 ? 255 : (short)(ASLCarUtil.getDate(n3).get(2) + 1));
        auxHeaterCoolerTimer.day = (short)(auxHeaterCoolerTimer.dateMode == 3 ? 255 : (short)ASLCarUtil.getDate(n3).get(5));
    }

    private void informingHmiTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("Parkheater timer 1 for HMI: ").append(auxHeaterCoolerTimer.getDay()).append(".").append(auxHeaterCoolerTimer.getMonth()).append(".").append(auxHeaterCoolerTimer.getYear()).toString()).log();
        }
        if (auxHeaterCoolerTimer.getDateMode() == 3) {
            this.myCollectorTimer1.climate_park_heating_timer1day = 0;
            this.arrayPositionTimer1 = 0;
        } else {
            this.myCollectorTimer1.climate_park_heating_timer1day = ASLCarUtil.informHMIParkHeater1Day(auxHeaterCoolerTimer);
        }
        if (this.isClockFormatAmPm) {
            this.isAmTimer1 = auxHeaterCoolerTimer.getHour() < 12;
        }
        this.myCollectorTimer1.climate_park_heating_timer1hour = auxHeaterCoolerTimer.getHour();
        this.myCollectorTimer1.climate_park_heating_timer1minute = auxHeaterCoolerTimer.getMinute();
        this.myCollectorTimer1.climate_park_heating_timer1set = true;
        this.arrayPositionTimer1 = ASLCarUtil.parkheatingTimer1Day(this.myCollectorTimer1.climate_park_heating_timer1day);
        ListManager.getGenericASLList(328).updateList(this.myCollectorTimer1Array);
    }

    private void informingHmiTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("Parkheater timer 2 for HMI: ").append(auxHeaterCoolerTimer.getDay()).append(".").append(auxHeaterCoolerTimer.getMonth()).append(".").append(auxHeaterCoolerTimer.getYear()).toString()).log();
        }
        if (auxHeaterCoolerTimer.getDateMode() == 3) {
            this.myCollectorTimer2.climate_park_heating_timer2day = 0;
            this.arrayPositionTimer2 = 0;
        } else {
            this.myCollectorTimer2.climate_park_heating_timer2day = ASLCarUtil.informHMIParkHeater2Day(auxHeaterCoolerTimer);
        }
        if (this.isClockFormatAmPm) {
            this.isAmTimer2 = auxHeaterCoolerTimer.getHour() < 12;
        }
        this.myCollectorTimer2.climate_park_heating_timer2hour = auxHeaterCoolerTimer.getHour();
        this.myCollectorTimer2.climate_park_heating_timer2minute = auxHeaterCoolerTimer.getMinute();
        this.myCollectorTimer2.climate_park_heating_timer2set = true;
        this.arrayPositionTimer2 = ASLCarUtil.parkheatingTimer2Day(this.myCollectorTimer2.climate_park_heating_timer2day);
        ListManager.getGenericASLList(329).updateList(this.myCollectorTimer2Array);
    }

    private void informingHmiTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("Parkheater timer 3 for HMI: ").append(auxHeaterCoolerTimer.getDay()).append(".").append(auxHeaterCoolerTimer.getMonth()).append(".").append(auxHeaterCoolerTimer.getYear()).toString()).log();
        }
        if (auxHeaterCoolerTimer.getDateMode() == 3) {
            this.myCollectorTimer3.climate_park_heating_timer3day = 0;
            this.arrayPositionTimer3 = 0;
        } else {
            this.myCollectorTimer3.climate_park_heating_timer3day = ASLCarUtil.informHMIParkHeater3Day(auxHeaterCoolerTimer);
        }
        if (this.isClockFormatAmPm) {
            this.isAmTimer3 = auxHeaterCoolerTimer.getHour() < 12;
        }
        this.myCollectorTimer3.climate_park_heating_timer3hour = auxHeaterCoolerTimer.getHour();
        this.myCollectorTimer3.climate_park_heating_timer3minute = auxHeaterCoolerTimer.getMinute();
        this.myCollectorTimer3.climate_park_heating_timer3set = true;
        this.arrayPositionTimer3 = ASLCarUtil.parkheatingTimer3Day(this.myCollectorTimer3.climate_park_heating_timer3day);
        ListManager.getGenericASLList(330).updateList(this.myCollectorTimer3Array);
    }

    private void settingUpActiveTimer(int n) {
        switch (n) {
            case -1: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(0);
                break;
            }
            case 0: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer1(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer1, this.arrayPositionTimer1));
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(1);
                break;
            }
            case 1: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer2(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer2, this.arrayPositionTimer2));
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(2);
                break;
            }
            case 2: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer3(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer3, this.arrayPositionTimer3));
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(3);
                break;
            }
        }
    }

    private void toggelParkHeatingModus(boolean bl) {
        this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerDefaultStartMode(bl ? 2 : 1);
    }

    private void applyTimers(int n) {
        switch (n) {
            case 0: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer1(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer1, this.arrayPositionTimer1));
                break;
            }
            case 1: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer2(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer2, this.arrayPositionTimer2));
                break;
            }
            case 2: {
                this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer3(ASLCarUtil.checkingTimeDayInRange(this.dsiTimer3, this.arrayPositionTimer3));
                break;
            }
        }
    }

    private void calcNewDateTimer1() {
        this.arrayPositionTimer1 = ASLCarUtil.parkheatingTimer1Day(this.myCollectorTimer1.climate_park_heating_timer1day);
        this.dsiTimer1.dateMode = (short)(this.arrayPositionTimer1 == 0 ? 3 : 0);
        this.dsiTimer1.year = (short)(this.dsiTimer1.dateMode == 3 ? 2255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer1).get(1));
        this.dsiTimer1.month = (short)(this.dsiTimer1.dateMode == 3 ? 255 : (short)(ASLCarUtil.getDate(this.arrayPositionTimer1).get(2) + 1));
        this.dsiTimer1.day = (short)(this.dsiTimer1.dateMode == 3 ? 255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer1).get(5));
        this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer1(this.dsiTimer1);
        if (this.myActiveTimer == 1) {
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(0);
        }
    }

    private void calcNewDateTimer2() {
        this.arrayPositionTimer2 = ASLCarUtil.parkheatingTimer2Day(this.myCollectorTimer2.climate_park_heating_timer2day);
        this.dsiTimer2.dateMode = (short)(this.arrayPositionTimer2 == 0 ? 3 : 0);
        this.dsiTimer2.year = (short)(this.dsiTimer2.dateMode == 3 ? 2255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer2).get(1));
        this.dsiTimer2.month = (short)(this.dsiTimer2.dateMode == 3 ? 255 : (short)(ASLCarUtil.getDate(this.arrayPositionTimer2).get(2) + 1));
        this.dsiTimer2.day = (short)(this.dsiTimer2.dateMode == 3 ? 255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer2).get(5));
        this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer2(this.dsiTimer2);
        if (this.myActiveTimer == 2) {
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(0);
        }
    }

    private void calcNewDateTimer3() {
        this.arrayPositionTimer3 = ASLCarUtil.parkheatingTimer3Day(this.myCollectorTimer3.climate_park_heating_timer3day);
        this.dsiTimer3.dateMode = (short)(this.arrayPositionTimer3 == 0 ? 3 : 0);
        this.dsiTimer3.year = (short)(this.dsiTimer3.dateMode == 3 ? 2255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer3).get(1));
        this.dsiTimer3.month = (short)(this.dsiTimer3.dateMode == 3 ? 255 : (short)(ASLCarUtil.getDate(this.arrayPositionTimer3).get(2) + 1));
        this.dsiTimer3.day = (short)(this.dsiTimer3.dateMode == 3 ? 255 : (short)ASLCarUtil.getDate(this.arrayPositionTimer3).get(5));
        this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerTimer3(this.dsiTimer3);
        if (this.myActiveTimer == 3) {
            this.dsiCarAuxHeaterCooler.setAuxHeaterCoolerActiveTimer(0);
        }
    }

    private void checkTimer1IsInRange() {
        if (!ASLCarUtil.isInRange(this.dsiTimer1)) {
            this.calcNewDateTimer1();
        } else {
            this.arrayPositionTimer1 = ASLCarUtil.parkheatingTimer1Day(this.myCollectorTimer1.climate_park_heating_timer1day);
        }
    }

    private void checkTimer2IsInRange() {
        if (!ASLCarUtil.isInRange(this.dsiTimer2)) {
            this.calcNewDateTimer2();
        } else {
            this.arrayPositionTimer2 = ASLCarUtil.parkheatingTimer2Day(this.myCollectorTimer2.climate_park_heating_timer2day);
        }
    }

    private void checkTimer3IsInRange() {
        if (!ASLCarUtil.isInRange(this.dsiTimer3)) {
            this.calcNewDateTimer3();
        } else {
            this.arrayPositionTimer3 = ASLCarUtil.parkheatingTimer3Day(this.myCollectorTimer3.climate_park_heating_timer3day);
        }
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

