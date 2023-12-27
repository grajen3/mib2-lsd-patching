/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.seat.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionListener;
import de.vw.mib.asl.api.car.vo.seat.SeatViewOptionService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.seat.impl.SeatViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carseat.DSICarSeat;
import org.dsi.ifc.carseat.DSICarSeatListener;
import org.dsi.ifc.carseat.SeatViewOptions;

public final class SeatViewOptionServiceImpl
extends AbstractTarget
implements SeatViewOptionService,
DeviceManagerListener {
    public static final int SEATVIEWOPTIONS;
    private static SeatViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarSeat dsiCarSeat;
    private DSICarSeatListener viewOptionsListener;
    private SeatViewOptionsWrapper seatViewOptionsWrapper;
    private int deviceReason;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeat;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$DSICarSeatListener;

    private SeatViewOptionServiceImpl() {
        super(ServiceManager.eventMain, "hsmtask");
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static SeatViewOptionServiceImpl getInstance() {
        if (instance == null) {
            try {
                instance = new SeatViewOptionServiceImpl();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return instance;
    }

    private void initDSI() {
        this.dsiCarSeat = (DSICarSeat)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carseat$DSICarSeat == null ? (class$org$dsi$ifc$carseat$DSICarSeat = SeatViewOptionServiceImpl.class$("org.dsi.ifc.carseat.DSICarSeat")) : class$org$dsi$ifc$carseat$DSICarSeat);
        this.viewOptionsListener = (DSICarSeatListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carseat$DSICarSeatListener == null ? (class$org$dsi$ifc$carseat$DSICarSeatListener = SeatViewOptionServiceImpl.class$("org.dsi.ifc.carseat.DSICarSeatListener")) : class$org$dsi$ifc$carseat$DSICarSeatListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarSeat.setNotification(n, (DSIListener)this.viewOptionsListener);
    }

    @Override
    public void addListener(SeatViewOptionListener seatViewOptionListener) {
        this.listeners.add(seatViewOptionListener);
    }

    @Override
    public void removeListener(SeatViewOptionListener seatViewOptionListener) {
        this.listeners.removeValue(seatViewOptionListener);
    }

    public void dsiCarSeatUpdateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        this.seatViewOptionsWrapper = new SeatViewOptionsWrapper(seatViewOptions);
        if (this.deviceReason == 0) {
            this.notifyListeners(0);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return -1739648512;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2100021: {
                int n = eventGeneric.getInt(0);
                if (n != 260) break;
                int n2 = eventGeneric.getInt(1);
                if (n2 != 0) {
                    this.notifyListeners(n2);
                    break;
                }
                this.notifyListeners(0);
                break;
            }
        }
    }

    private void notifyListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            SeatViewOptionListener seatViewOptionListener = (SeatViewOptionListener)iterator.next();
            if (this.seatViewOptionsWrapper == null) {
                seatViewOptionListener.updateSeatDevice(n);
                if (this.deviceReason != 14) continue;
                this.deviceReason = 0;
                continue;
            }
            if (this.deviceReason == 14) {
                this.deviceReason = 0;
                return;
            }
            seatViewOptionListener.updateSeatViewOptions(this.seatViewOptionsWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 260) {
            this.deviceReason = n2;
            if (n2 != 0) {
                this.notifyListeners(n2);
            } else {
                this.notifyListeners(0);
            }
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

