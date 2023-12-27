/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car;

import de.vw.mib.asl.api.car.arrays.ASLCarArrayFactory;
import de.vw.mib.asl.api.car.bordcomputer.ASLCarBordComputerAPI;
import de.vw.mib.asl.api.car.e_traction.ASLCarEtrakAPI;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.car.rdk.ASLCarRDKAPI;
import de.vw.mib.asl.api.car.speller.Speller;
import de.vw.mib.asl.api.car.thinkblue.ASLCarTBTAPI;
import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.car.vo.DeviceManagerInterface;
import de.vw.mib.asl.api.car.vo.ViewOptionFactory;
import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionService;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.DrivingCharacteristicsViewOptionService;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionService;
import de.vw.mib.asl.api.car.vo.e_traction.E_TractionViewOptionService;
import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionService;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.api.car.vo.light.LightViewOptionService;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionService;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionService;
import de.vw.mib.asl.api.car.vo.timeunitslanguage.TimeUnitsLanguageViewOptionService;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionService;

public interface ASLCarAPI {
    public static final int ASL_NAVIGATION_TRAFFIC_SIGN_NONE;
    public static final int ASL_NAVIGATION_TRAFFIC_SIGN_VZA;
    public static final int ASL_NAVIGATION_TRAFFIC_SIGN_VZE;

    default public ASLCarArrayFactory getCarBapArrayFactory() {
    }

    default public Speller createSpeller(int n, int n2) {
    }

    default public PersonalizationService getCarPersonalizationService() {
    }

    default public ASLCarVehicleAPI getCarVehicleAPI() {
    }

    default public ASLCarRDKAPI getCarRDKAPI() {
    }

    default public ASLCarTBTAPI getCarTBTAPI() {
    }

    default public ASLCarEtrakAPI getCarEtrakAPI() {
    }

    default public ASLCarBordComputerAPI getCarBordComputerAPI() {
    }

    default public SeatViewOptionService getSeatViewOptionService() {
    }

    default public LightViewOptionService getLightViewOptionService() {
    }

    default public ComfortViewOptionService getComfortViewOptionService() {
    }

    default public DriverAssistanceViewOptionService getDriverAssistanceViewOptionService() {
    }

    default public KombiViewOptionService getKombiViewOptionService() {
    }

    default public VehicleStatesViewOptionService getVehicleStatesViewOptionService() {
    }

    default public DrivingCharacteristicsViewOptionService getDrivingCharacteristicsViewOptionService() {
    }

    default public ViewOptionFactory getViewOptionFactory() {
    }

    default public DeviceManagerInterface getDeviceManager() {
    }

    default public ParkingViewOptionService getParkingViewOptionService() {
    }

    default public ClimateViewOptionService getClimateViewOptionService() {
    }

    default public E_TractionViewOptionService getE_TractionViewOptionService() {
    }

    default public EcoViewOptionService getEcoViewOptionService() {
    }

    default public TimeUnitsLanguageViewOptionService getTimeUniTsLanguageViewOptionsService() {
    }
}

