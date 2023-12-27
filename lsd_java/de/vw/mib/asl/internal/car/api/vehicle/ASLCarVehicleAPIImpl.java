/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.vehicle;

import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.car.vehicle.VehicleService;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.vehicle.NotAvailableVehicleService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLCarVehicleAPIImpl
implements ASLCarVehicleAPI,
ServiceClient,
VehicleServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$VehicleService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public VehicleService getVehicleService() {
        VehicleService vehicleService = (VehicleService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$vehicle$VehicleService == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleService = ASLCarVehicleAPIImpl.class$("de.vw.mib.asl.api.car.vehicle.VehicleService")) : class$de$vw$mib$asl$api$car$vehicle$VehicleService);
        if (vehicleService == null) {
            vehicleService = new NotAvailableVehicleService();
        }
        return vehicleService;
    }

    @Override
    public void addVehicleServiceListener(VehicleServiceListener vehicleServiceListener) {
        this.getRegisteredCarClients().add(vehicleServiceListener);
    }

    @Override
    public void removeVehicleServiceListener(VehicleServiceListener vehicleServiceListener) {
        this.getRegisteredCarClients().remove(vehicleServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$vehicle$VehicleService == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleService = ASLCarVehicleAPIImpl.class$("de.vw.mib.asl.api.car.vehicle.VehicleService")) : class$de$vw$mib$asl$api$car$vehicle$VehicleService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener = ASLCarVehicleAPIImpl.class$("de.vw.mib.asl.api.car.vehicle.VehicleServiceListener")) : class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener, this);
        }
    }

    @Override
    public void updateValetParkingActive(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateValetParkingActive(bl);
        }
    }

    @Override
    public void updateValetParkingAvailable(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateValetParkingAvailable(bl);
        }
    }

    @Override
    public void updateOilLevel(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOilLevel(n);
        }
    }

    @Override
    public void updateOilLevelAvailability(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOilLevelAvailability(n);
        }
    }

    @Override
    public void updateOilRefillQuantity(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOilRefillQuantity(n);
        }
    }

    @Override
    public void updateOilRefillUnit(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOilRefillUnit(n);
        }
    }

    @Override
    public void updateOilWarning(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOilWarning(n);
        }
    }

    @Override
    public void updateWarningCount(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateWarningCount(n);
        }
    }

    @Override
    public void updateCarStatusTileSFunctionAvailabilty(int n, boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateCarStatusTileSFunctionAvailabilty(n, bl);
        }
    }

    @Override
    public void updateCarStatusTileSFunctionExistence(int n, boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateCarStatusTileSFunctionExistence(n, bl);
        }
    }

    @Override
    public void updateOillevelFunctionAvailableReason(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateOillevelFunctionAvailableReason(n);
        }
    }

    @Override
    public void updateRDKFunctionAvailableReason(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateRDKFunctionAvailableReason(n);
        }
    }

    @Override
    public void updateCarGearType(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateCarGearType(n);
        }
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateAutomaticGearShiftTransMode(n);
        }
    }

    @Override
    public void updateClutchState(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateClutchState(n);
        }
    }

    @Override
    public void updateParkingBrakeState(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateParkingBrakeState(n);
        }
    }

    @Override
    public void updateSystemState(boolean bl, boolean bl2) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            VehicleServiceListener vehicleServiceListener = (VehicleServiceListener)iterator.next();
            vehicleServiceListener.updateSystemState(bl, bl2);
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

