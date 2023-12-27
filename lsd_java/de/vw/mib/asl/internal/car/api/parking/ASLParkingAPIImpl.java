/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.parking;

import de.vw.mib.asl.api.car.parking.ASLParkingAPI;
import de.vw.mib.asl.api.car.parking.ParkingService;
import de.vw.mib.asl.api.car.parking.ParkingServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.parking.NotAvailableParkingService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLParkingAPIImpl
implements ASLParkingAPI,
ServiceClient,
ParkingServiceListener {
    private HashSet registeredParkingClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ParkingService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ParkingServiceListener;

    private HashSet getRegisteredParkingClients() {
        if (this.registeredParkingClients == null) {
            this.registeredParkingClients = new HashSet();
        }
        return this.registeredParkingClients;
    }

    @Override
    public void onParkingActivated() {
        Iterator iterator = this.getRegisteredParkingClients().iterator();
        while (iterator.hasNext()) {
            ParkingServiceListener parkingServiceListener = (ParkingServiceListener)iterator.next();
            parkingServiceListener.onParkingActivated();
        }
    }

    @Override
    public void onParkingDeactivated() {
        Iterator iterator = this.getRegisteredParkingClients().iterator();
        while (iterator.hasNext()) {
            ParkingServiceListener parkingServiceListener = (ParkingServiceListener)iterator.next();
            parkingServiceListener.onParkingDeactivated();
        }
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$parking$ParkingService == null ? (class$de$vw$mib$asl$api$car$parking$ParkingService = ASLParkingAPIImpl.class$("de.vw.mib.asl.api.car.parking.ParkingService")) : class$de$vw$mib$asl$api$car$parking$ParkingService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$parking$ParkingServiceListener == null ? (class$de$vw$mib$asl$api$car$parking$ParkingServiceListener = ASLParkingAPIImpl.class$("de.vw.mib.asl.api.car.parking.ParkingServiceListener")) : class$de$vw$mib$asl$api$car$parking$ParkingServiceListener, this);
        }
    }

    @Override
    public ParkingService getParkingService() {
        ParkingService parkingService = (ParkingService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$parking$ParkingService == null ? (class$de$vw$mib$asl$api$car$parking$ParkingService = ASLParkingAPIImpl.class$("de.vw.mib.asl.api.car.parking.ParkingService")) : class$de$vw$mib$asl$api$car$parking$ParkingService);
        if (parkingService == null) {
            parkingService = new NotAvailableParkingService();
        }
        return parkingService;
    }

    @Override
    public void addParkingServiceListener(ParkingServiceListener parkingServiceListener) {
        this.getRegisteredParkingClients().add(parkingServiceListener);
    }

    @Override
    public void removeParkingServiceListener(ParkingServiceListener parkingServiceListener) {
        this.getRegisteredParkingClients().remove(parkingServiceListener);
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

