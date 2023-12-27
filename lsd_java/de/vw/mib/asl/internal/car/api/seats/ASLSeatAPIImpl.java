/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.seats;

import de.vw.mib.asl.api.car.seat.ASLSeatAPI;
import de.vw.mib.asl.api.car.seat.SeatAdjustment;
import de.vw.mib.asl.api.car.seat.SeatDisplayRequest;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatServiceListener;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.seats.NotAvailableSeatService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLSeatAPIImpl
implements ASLSeatAPI,
ServiceClient,
SeatServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$seat$SeatService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$seat$SeatServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public void addSeatServiceListener(SeatServiceListener seatServiceListener) {
        this.getRegisteredCarClients().add(seatServiceListener);
    }

    @Override
    public void removeSeatServiceListener(SeatServiceListener seatServiceListener) {
        this.getRegisteredCarClients().remove(seatServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$seat$SeatService == null ? (class$de$vw$mib$asl$api$car$seat$SeatService = ASLSeatAPIImpl.class$("de.vw.mib.asl.api.car.seat.SeatService")) : class$de$vw$mib$asl$api$car$seat$SeatService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$seat$SeatServiceListener == null ? (class$de$vw$mib$asl$api$car$seat$SeatServiceListener = ASLSeatAPIImpl.class$("de.vw.mib.asl.api.car.seat.SeatServiceListener")) : class$de$vw$mib$asl$api$car$seat$SeatServiceListener, this);
            this.updateSeatServiceExisting(true);
        }
    }

    @Override
    public SeatService getSeatService() {
        SeatService seatService = (SeatService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$seat$SeatService == null ? (class$de$vw$mib$asl$api$car$seat$SeatService = ASLSeatAPIImpl.class$("de.vw.mib.asl.api.car.seat.SeatService")) : class$de$vw$mib$asl$api$car$seat$SeatService);
        if (seatService == null) {
            seatService = new NotAvailableSeatService();
        }
        return seatService;
    }

    @Override
    public void updateSeatMassage(SeatMassage seatMassage) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.updateSeatMassage(seatMassage);
        }
    }

    @Override
    public void updateSeatServiceExisting(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.updateSeatServiceExisting(bl);
        }
    }

    @Override
    public void updateSeatServiceAvailable(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.updateSeatServiceAvailable(bl);
        }
    }

    @Override
    public void updateSeatDisplayContent(SeatDisplayRequest seatDisplayRequest) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.updateSeatDisplayContent(seatDisplayRequest);
        }
    }

    @Override
    public void requestSeatPopup(SeatDisplayRequest seatDisplayRequest) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.requestSeatPopup(seatDisplayRequest);
        }
    }

    @Override
    public void updateSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            SeatServiceListener seatServiceListener = (SeatServiceListener)iterator.next();
            seatServiceListener.updateSeatSetupSetting(seatSetupSetting);
        }
    }

    @Override
    public void updateSeatAdjustment(SeatAdjustment seatAdjustment) {
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

