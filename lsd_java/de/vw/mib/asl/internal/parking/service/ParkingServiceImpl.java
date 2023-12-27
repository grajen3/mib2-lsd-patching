/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.parking.service;

import de.vw.mib.asl.api.car.parking.ParkingService;
import de.vw.mib.asl.api.car.parking.ParkingServiceListener;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;

public class ParkingServiceImpl
implements ParkingService {
    private boolean isParkingActivated = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ParkingService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$parking$ParkingServiceListener;

    public ParkingServiceImpl() {
        this.registerServiceProvider();
    }

    @Override
    public boolean isParkingActivated() {
        return this.isParkingActivated;
    }

    private void registerServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$parking$ParkingService == null ? (class$de$vw$mib$asl$api$car$parking$ParkingService = ParkingServiceImpl.class$("de.vw.mib.asl.api.car.parking.ParkingService")) : class$de$vw$mib$asl$api$car$parking$ParkingService, this);
    }

    private ParkingServiceListener getParkingServiceListener() {
        return (ParkingServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$parking$ParkingServiceListener == null ? (class$de$vw$mib$asl$api$car$parking$ParkingServiceListener = ParkingServiceImpl.class$("de.vw.mib.asl.api.car.parking.ParkingServiceListener")) : class$de$vw$mib$asl$api$car$parking$ParkingServiceListener);
    }

    @Override
    public void triggerParking(boolean bl) {
        this.isParkingActivated = bl;
        if (bl) {
            this.getParkingServiceListener().onParkingActivated();
        } else {
            this.getParkingServiceListener().onParkingDeactivated();
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

