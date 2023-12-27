/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv;

import de.vw.mib.asl.api.car.vo.ViewOptionFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.srv.climate.impl.ClimateViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.comfort.impl.ComfortViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.drivingcharacteristics.impl.DrivingCharacteristicsViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.drvass.impl.DriverAssistanceViewOptionsServiceImpl;
import de.vw.mib.asl.internal.car.srv.e_traction.impl.E_TractionViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.eco.impl.EcoViewOptionsServiceImpl;
import de.vw.mib.asl.internal.car.srv.kombi.impl.KombiViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.light.impl.LightViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.parking.ParkingViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.seat.impl.SeatViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.timeunitslanguage.impl.TimeUnitsLanguageViewOptionServiceImpl;
import de.vw.mib.asl.internal.car.srv.vehiclestates.impl.VehicleStatesViewOptionServiceImpl;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public final class ViewOptionServiceFactory
extends AbstractTarget
implements ViewOptionFactory {
    private static ViewOptionServiceFactory INSTANCE;
    private boolean doorLockingNotificationDone;

    private ViewOptionServiceFactory() {
        super(ServiceManager.eventMain, "hsmtask");
    }

    public static ViewOptionFactory getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new ViewOptionServiceFactory();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return INSTANCE;
    }

    @Override
    public int getDefaultTargetId() {
        return -1773202944;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public void createViewOption(int[] nArray) {
        ComfortViewOptionServiceImpl comfortViewOptionServiceImpl = ComfortViewOptionServiceImpl.getInstance();
        KombiViewOptionServiceImpl kombiViewOptionServiceImpl = KombiViewOptionServiceImpl.getInstance();
        ClimateViewOptionServiceImpl climateViewOptionServiceImpl = ClimateViewOptionServiceImpl.getInstance();
        LightViewOptionServiceImpl lightViewOptionServiceImpl = LightViewOptionServiceImpl.getInstance();
        E_TractionViewOptionServiceImpl e_TractionViewOptionServiceImpl = E_TractionViewOptionServiceImpl.getInstance();
        DriverAssistanceViewOptionsServiceImpl driverAssistanceViewOptionsServiceImpl = DriverAssistanceViewOptionsServiceImpl.getInstance();
        EcoViewOptionsServiceImpl ecoViewOptionsServiceImpl = EcoViewOptionsServiceImpl.getInstance();
        VehicleStatesViewOptionServiceImpl vehicleStatesViewOptionServiceImpl = VehicleStatesViewOptionServiceImpl.getInstance();
        ParkingViewOptionServiceImpl parkingViewOptionServiceImpl = ParkingViewOptionServiceImpl.getInstance();
        TimeUnitsLanguageViewOptionServiceImpl timeUnitsLanguageViewOptionServiceImpl = TimeUnitsLanguageViewOptionServiceImpl.getInstance();
        block37: for (int i2 = 0; i2 < nArray.length; ++i2) {
            switch (nArray[i2]) {
                case 260: {
                    SeatViewOptionServiceImpl.getInstance().registerViewOption(1);
                    continue block37;
                }
                case 195: {
                    LightViewOptionServiceImpl.getInstance().registerViewOption(1);
                    continue block37;
                }
                case 330: {
                    comfortViewOptionServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 355: {
                    comfortViewOptionServiceImpl.registerViewOption(39);
                    continue block37;
                }
                case 250: {
                    comfortViewOptionServiceImpl.registerViewOption(21);
                    continue block37;
                }
                case 190: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(24);
                    continue block37;
                }
                case 300: {
                    kombiViewOptionServiceImpl.registerViewOption(37);
                    continue block37;
                }
                case 285: {
                    VehicleStatesViewOptionServiceImpl.getInstance().registerViewOption(3);
                    continue block37;
                }
                case 295: {
                    DrivingCharacteristicsViewOptionServiceImpl.getInstance().registerViewOption(1);
                    continue block37;
                }
                case 255: {
                    kombiViewOptionServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 240: {
                    kombiViewOptionServiceImpl.registerViewOption(4);
                    continue block37;
                }
                case 225: 
                case 265: {
                    if (this.doorLockingNotificationDone) continue block37;
                    comfortViewOptionServiceImpl.registerViewOption(5);
                    this.doorLockingNotificationDone = true;
                    continue block37;
                }
                case 200: {
                    parkingViewOptionServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 315: {
                    comfortViewOptionServiceImpl.registerViewOption(29);
                    continue block37;
                }
                case 230: {
                    climateViewOptionServiceImpl.registerViewOption(92);
                    ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(this.getClassifier(), "ViewOptions: Register for Climate Master viewoptions");
                    continue block37;
                }
                case 395: {
                    e_TractionViewOptionServiceImpl.registerViewOption(6);
                    continue block37;
                }
                case 310: {
                    e_TractionViewOptionServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 220: {
                    lightViewOptionServiceImpl.registerViewOption(12);
                    continue block37;
                }
                case 245: {
                    comfortViewOptionServiceImpl.registerViewOption(33);
                    continue block37;
                }
                case 205: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(30);
                    continue block37;
                }
                case 210: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(19);
                    continue block37;
                }
                case 425: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(58);
                    continue block37;
                }
                case 215: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 365: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(44);
                    continue block37;
                }
                case 340: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(35);
                    continue block37;
                }
                case 380: {
                    comfortViewOptionServiceImpl.registerViewOption(45);
                    continue block37;
                }
                case 320: {
                    driverAssistanceViewOptionsServiceImpl.registerViewOption(8);
                    continue block37;
                }
                case 1000: {
                    comfortViewOptionServiceImpl.notifyPso();
                    continue block37;
                }
                case 1010: {
                    lightViewOptionServiceImpl.notifyAmbienceLight();
                    continue block37;
                }
                case 465: {
                    ecoViewOptionsServiceImpl.registerViewOption(42);
                    continue block37;
                }
                case 360: {
                    vehicleStatesViewOptionServiceImpl.registerViewOption(11);
                    continue block37;
                }
                case 385: {
                    ecoViewOptionsServiceImpl.registerViewOption(12);
                    continue block37;
                }
                case 1015: {
                    parkingViewOptionServiceImpl.notifyFifthCam();
                    continue block37;
                }
                case 290: {
                    timeUnitsLanguageViewOptionServiceImpl.registerViewOption(1);
                    continue block37;
                }
                case 305: {
                    timeUnitsLanguageViewOptionServiceImpl.registerViewOption(10);
                    continue block37;
                }
            }
        }
    }
}

