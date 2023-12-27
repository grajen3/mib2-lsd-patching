/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api;

import de.vw.mib.asl.api.car.ASLCarAPI;
import de.vw.mib.asl.api.car.ASLCarFactory;
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
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.bordcomputer.ASLCarBordComputerAPIImpl;
import de.vw.mib.asl.internal.car.api.e_traction.ASLCarEtrakAPIImpl;
import de.vw.mib.asl.internal.car.api.rdk.ASLCarRDKAPIImpl;
import de.vw.mib.asl.internal.car.api.thinkblue.ASLCarTBTAPIImpl;
import de.vw.mib.asl.internal.car.api.vehicle.ASLCarVehicleAPIImpl;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.framework.speller.GenericSpeller;
import de.vw.mib.asl.internal.car.personal.api.PersonalizationServiceImpl;
import de.vw.mib.asl.internal.car.srv.ViewOptionServiceFactory;
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
import de.vw.mib.asl.internal.car.viewoption.StateWork;

public class ASLCarAPIImpl
implements ASLCarAPI,
ServiceClient {
    private static ASLCarVehicleAPI carVehicleAPI;
    private static ASLCarRDKAPI rdkAPI;
    private static ASLCarTBTAPI tbtAPI;
    private static ASLCarBordComputerAPI carBordComputerAPIImpl;
    private static ASLCarEtrakAPI etrakAPI;

    @Override
    public ASLCarArrayFactory getCarBapArrayFactory() {
        return BapArrayFactory.getInstance();
    }

    @Override
    public Speller createSpeller(int n, int n2) {
        return new GenericSpeller(n, n2);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        ((ServiceClient)((Object)ASLCarFactory.getClimateApi())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)this.getCarVehicleAPI())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)this.getCarRDKAPI())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)this.getCarTBTAPI())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)this.getCarBordComputerAPI())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)this.getCarEtrakAPI())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)ASLCarFactory.getSeatApi())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)ASLCarFactory.getAmbienceLightApi())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)ASLCarFactory.getFpaApi())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)ASLCarFactory.getParkingApi())).informClientsThatProviderIsAvailable(clazz);
        ((ServiceClient)((Object)ASLCarFactory.getLightAPI())).informClientsThatProviderIsAvailable(clazz);
    }

    @Override
    public PersonalizationService getCarPersonalizationService() {
        return PersonalizationServiceImpl.getInstance();
    }

    @Override
    public ASLCarVehicleAPI getCarVehicleAPI() {
        if (carVehicleAPI == null) {
            carVehicleAPI = new ASLCarVehicleAPIImpl();
        }
        return carVehicleAPI;
    }

    @Override
    public ASLCarRDKAPI getCarRDKAPI() {
        if (rdkAPI == null) {
            rdkAPI = new ASLCarRDKAPIImpl();
        }
        return rdkAPI;
    }

    @Override
    public ASLCarTBTAPI getCarTBTAPI() {
        if (tbtAPI == null) {
            tbtAPI = new ASLCarTBTAPIImpl();
        }
        return tbtAPI;
    }

    @Override
    public ASLCarBordComputerAPI getCarBordComputerAPI() {
        if (carBordComputerAPIImpl == null) {
            carBordComputerAPIImpl = new ASLCarBordComputerAPIImpl();
        }
        return carBordComputerAPIImpl;
    }

    @Override
    public ASLCarEtrakAPI getCarEtrakAPI() {
        if (etrakAPI == null) {
            etrakAPI = new ASLCarEtrakAPIImpl();
        }
        return etrakAPI;
    }

    @Override
    public SeatViewOptionService getSeatViewOptionService() {
        return SeatViewOptionServiceImpl.getInstance();
    }

    @Override
    public LightViewOptionService getLightViewOptionService() {
        return LightViewOptionServiceImpl.getInstance();
    }

    @Override
    public ComfortViewOptionService getComfortViewOptionService() {
        return ComfortViewOptionServiceImpl.getInstance();
    }

    @Override
    public DriverAssistanceViewOptionService getDriverAssistanceViewOptionService() {
        return DriverAssistanceViewOptionsServiceImpl.getInstance();
    }

    @Override
    public KombiViewOptionService getKombiViewOptionService() {
        return KombiViewOptionServiceImpl.getInstance();
    }

    @Override
    public VehicleStatesViewOptionService getVehicleStatesViewOptionService() {
        return VehicleStatesViewOptionServiceImpl.getInstance();
    }

    @Override
    public DrivingCharacteristicsViewOptionService getDrivingCharacteristicsViewOptionService() {
        return DrivingCharacteristicsViewOptionServiceImpl.getInstance();
    }

    @Override
    public ViewOptionFactory getViewOptionFactory() {
        return ViewOptionServiceFactory.getInstance();
    }

    @Override
    public DeviceManagerInterface getDeviceManager() {
        return StateWork.getDeviceManager();
    }

    @Override
    public ParkingViewOptionService getParkingViewOptionService() {
        return ParkingViewOptionServiceImpl.getInstance();
    }

    @Override
    public ClimateViewOptionService getClimateViewOptionService() {
        return ClimateViewOptionServiceImpl.getInstance();
    }

    @Override
    public E_TractionViewOptionService getE_TractionViewOptionService() {
        return E_TractionViewOptionServiceImpl.getInstance();
    }

    @Override
    public EcoViewOptionService getEcoViewOptionService() {
        return EcoViewOptionsServiceImpl.getInstance();
    }

    @Override
    public TimeUnitsLanguageViewOptionService getTimeUniTsLanguageViewOptionsService() {
        return TimeUnitsLanguageViewOptionServiceImpl.getInstance();
    }

    static {
        if (ServiceManager.configManagerDiag != null) {
            PreRegisteredIds.addServiceOrObserverToArray(0, -1991306752, 638263296, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -2008083968, 0x220B2000, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -2008083968, 0, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1974529536, 705372160, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1974529536, 856367104, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1991306752, 0x2B0B2000, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1957752320, 755703808, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1991306752, 772481024, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1991306752, 789258240, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -2024861184, 806035456, true);
            PreRegisteredIds.addServiceOrObserverToArray(0, -1857089024, 906698752, true);
        }
    }
}

