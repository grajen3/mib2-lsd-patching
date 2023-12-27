/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car;

import de.vw.mib.asl.api.car.ASLCarAPI;
import de.vw.mib.asl.api.car.ambiencelight.ASLAmbienceLightAPI;
import de.vw.mib.asl.api.car.bordcomputer.ASLCarBordComputerAPI;
import de.vw.mib.asl.api.car.climate.ASLClimateAPI;
import de.vw.mib.asl.api.car.e_traction.ASLCarEtrakAPI;
import de.vw.mib.asl.api.car.fpa.ASLFPACharismaProfileAPI;
import de.vw.mib.asl.api.car.light.ASLLightAPI;
import de.vw.mib.asl.api.car.parking.ASLParkingAPI;
import de.vw.mib.asl.api.car.rdk.ASLCarRDKAPI;
import de.vw.mib.asl.api.car.seat.ASLSeatAPI;
import de.vw.mib.asl.api.car.thinkblue.ASLCarTBTAPI;
import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLCarFactory
extends ASLFactoryBase {
    private static final String NEW_CLIMATE_API_CLASS_NAME;
    private static final String NEW_CAR_API_CLASS_NAME;
    private static final String NEW_SEAT_API_CLASS_NAME;
    private static final String NEW_AMBIENCELIGHT_API_CLASS_NAME;
    private static final String NEW_FPA_API_CLASS_NAME;
    private static final String NEW_PARKING_API_CLASS_NAME;
    private static final String NEW_LIGHT_API_CLASS_NAME;
    private static ASLCarAPI carApiInstance;
    private static ASLCarFactory instance;
    private static ASLClimateAPI climateApiInstance;
    private static ASLSeatAPI seatApiInstance;
    private static ASLAmbienceLightAPI ambienceLightApiInstance;
    private static ASLFPACharismaProfileAPI fpaApiInstance;
    private static ASLParkingAPI parkingApiInstance;
    private static ASLLightAPI lightApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ASLCarAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ASLClimateAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$seat$ASLSeatAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ambiencelight$ASLAmbienceLightAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$fpa$ASLFPACharismaProfileAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ASLParkingAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$light$ASLLightAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ASLCarFactory;

    ASLCarFactory() {
    }

    public static ASLCarAPI getCarApi() {
        if (carApiInstance == null) {
            carApiInstance = (ASLCarAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$ASLCarAPI == null ? (class$de$vw$mib$asl$api$car$ASLCarAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.ASLCarAPI")) : class$de$vw$mib$asl$api$car$ASLCarAPI, ASLCarFactory.getInstance().getCarApiClassName());
        }
        return carApiInstance;
    }

    public static ASLClimateAPI getClimateApi() {
        if (climateApiInstance == null) {
            climateApiInstance = (ASLClimateAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$climate$ASLClimateAPI == null ? (class$de$vw$mib$asl$api$car$climate$ASLClimateAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.climate.ASLClimateAPI")) : class$de$vw$mib$asl$api$car$climate$ASLClimateAPI, "de.vw.mib.asl.internal.car.api.climate.ASLClimateAPIImpl");
        }
        return climateApiInstance;
    }

    public static ASLSeatAPI getSeatApi() {
        if (seatApiInstance == null) {
            seatApiInstance = (ASLSeatAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$seat$ASLSeatAPI == null ? (class$de$vw$mib$asl$api$car$seat$ASLSeatAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.seat.ASLSeatAPI")) : class$de$vw$mib$asl$api$car$seat$ASLSeatAPI, "de.vw.mib.asl.internal.car.api.seats.ASLSeatAPIImpl");
        }
        return seatApiInstance;
    }

    public static ASLAmbienceLightAPI getAmbienceLightApi() {
        if (ambienceLightApiInstance == null) {
            ambienceLightApiInstance = (ASLAmbienceLightAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$ambiencelight$ASLAmbienceLightAPI == null ? (class$de$vw$mib$asl$api$car$ambiencelight$ASLAmbienceLightAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.ambiencelight.ASLAmbienceLightAPI")) : class$de$vw$mib$asl$api$car$ambiencelight$ASLAmbienceLightAPI, "de.vw.mib.asl.internal.car.api.ambiencelight.ASLAmbienceLightAPIImpl");
        }
        return ambienceLightApiInstance;
    }

    public static ASLFPACharismaProfileAPI getFpaApi() {
        if (fpaApiInstance == null) {
            fpaApiInstance = (ASLFPACharismaProfileAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$fpa$ASLFPACharismaProfileAPI == null ? (class$de$vw$mib$asl$api$car$fpa$ASLFPACharismaProfileAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.fpa.ASLFPACharismaProfileAPI")) : class$de$vw$mib$asl$api$car$fpa$ASLFPACharismaProfileAPI, "de.vw.mib.asl.internal.car.api.fpa.ASLFPACharimsaProfileAPIImpl");
        }
        return fpaApiInstance;
    }

    public static ASLParkingAPI getParkingApi() {
        if (parkingApiInstance == null) {
            parkingApiInstance = (ASLParkingAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$parking$ASLParkingAPI == null ? (class$de$vw$mib$asl$api$car$parking$ASLParkingAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.parking.ASLParkingAPI")) : class$de$vw$mib$asl$api$car$parking$ASLParkingAPI, "de.vw.mib.asl.internal.car.api.parking.ASLParkingAPIImpl");
        }
        return parkingApiInstance;
    }

    public static ASLCarVehicleAPI getCarVehicleApi() {
        return ASLCarFactory.getCarApi().getCarVehicleAPI();
    }

    public static ASLCarTBTAPI getTBTApi() {
        return ASLCarFactory.getCarApi().getCarTBTAPI();
    }

    public static ASLCarRDKAPI getRDKApi() {
        return ASLCarFactory.getCarApi().getCarRDKAPI();
    }

    public static ASLCarEtrakAPI getEtrakApi() {
        return ASLCarFactory.getCarApi().getCarEtrakAPI();
    }

    public static ASLCarBordComputerAPI getBordComputerAPI() {
        return ASLCarFactory.getCarApi().getCarBordComputerAPI();
    }

    public static ASLLightAPI getLightAPI() {
        if (lightApiInstance == null) {
            lightApiInstance = (ASLLightAPI)ASLCarFactory.createServiceInstance(class$de$vw$mib$asl$api$car$light$ASLLightAPI == null ? (class$de$vw$mib$asl$api$car$light$ASLLightAPI = ASLCarFactory.class$("de.vw.mib.asl.api.car.light.ASLLightAPI")) : class$de$vw$mib$asl$api$car$light$ASLLightAPI, "de.vw.mib.asl.internal.car.api.light.ASLLightAPIImpl");
        }
        return lightApiInstance;
    }

    private static ASLCarFactory getInstance() {
        return ASLCarFactory.getInstance(class$de$vw$mib$asl$api$car$ASLCarFactory == null ? (class$de$vw$mib$asl$api$car$ASLCarFactory = ASLCarFactory.class$("de.vw.mib.asl.api.car.ASLCarFactory")) : class$de$vw$mib$asl$api$car$ASLCarFactory);
    }

    protected static ASLCarFactory getInstance(Class clazz) {
        if (instance == null) {
            try {
                instance = (ASLCarFactory)clazz.newInstance();
            }
            catch (Exception exception) {
                if (null != logger) {
                    logger.error(1).append("ASLFactoryBase#ASLCarFactory, error=").attachThrowable(exception).log();
                } else {
                    exception.printStackTrace();
                }
                return new ASLCarFactory();
            }
        }
        return instance;
    }

    protected String getCarApiClassName() {
        return "de.vw.mib.asl.internal.car.api.ASLCarAPIImpl";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        climateApiInstance = null;
        seatApiInstance = null;
        ambienceLightApiInstance = null;
        fpaApiInstance = null;
        parkingApiInstance = null;
        lightApiInstance = null;
    }
}

