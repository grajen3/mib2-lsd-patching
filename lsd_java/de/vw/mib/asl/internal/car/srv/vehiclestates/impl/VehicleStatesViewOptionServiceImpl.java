/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.vehiclestates.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionListener;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleStatesViewOptionService;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.CarViewOptionWrapper;
import de.vw.mib.asl.internal.car.srv.vehiclestates.impl.VehicleInfoViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class VehicleStatesViewOptionServiceImpl
extends CarEmptyTarget
implements VehicleStatesViewOptionService,
DeviceManagerListener {
    public static final int VINVIEWOPTION;
    public static final int VEHICLEINFOVIEWOPTIONS;
    private static VehicleStatesViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarVehicleStates dsiCarTarget;
    private DSICarVehicleStatesListener dsiCarListener;
    private int deviceReason;
    private int drivingSchoolReason;
    private CarViewOptionWrapper viewOptionWrapper;
    private VehicleInfoViewOptionsWrapper vehicleInfoViewOptionWrapper;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;

    private VehicleStatesViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static VehicleStatesViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new VehicleStatesViewOptionServiceImpl();
        }
        return instance;
    }

    private void initDSI() {
        this.dsiCarTarget = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = VehicleStatesViewOptionServiceImpl.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiCarListener = (DSICarVehicleStatesListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = VehicleStatesViewOptionServiceImpl.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarTarget.setNotification(n, (DSIListener)this.dsiCarListener);
    }

    @Override
    public void addListener(VehicleStatesViewOptionListener vehicleStatesViewOptionListener) {
        this.listeners.add(vehicleStatesViewOptionListener);
    }

    @Override
    public void removeListener(VehicleStatesViewOptionListener vehicleStatesViewOptionListener) {
        this.listeners.removeValue(vehicleStatesViewOptionListener);
    }

    public void dsiCarVehicleStatesUpdateVINViewOption(CarViewOption carViewOption, int n) {
        this.viewOptionWrapper = new CarViewOptionWrapper(carViewOption);
        if (this.deviceReason == 0) {
            this.notifyListeners(0);
        }
    }

    private void notifyListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            VehicleStatesViewOptionListener vehicleStatesViewOptionListener = (VehicleStatesViewOptionListener)iterator.next();
            if (this.viewOptionWrapper == null) {
                vehicleStatesViewOptionListener.updateVINDevice(n);
                if (this.deviceReason != 14) continue;
                this.deviceReason = 0;
                continue;
            }
            if (this.deviceReason == 14) {
                this.deviceReason = 0;
                return;
            }
            vehicleStatesViewOptionListener.updateVINViewOption(this.viewOptionWrapper, n);
        }
    }

    public void dsiCarVehicleStatesUpdateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        this.vehicleInfoViewOptionWrapper = new VehicleInfoViewOptionsWrapper(vehicleInfoViewOptions);
        if (this.drivingSchoolReason == 0) {
            this.notifyVehicleInfoListeners(0);
        }
    }

    private void notifyVehicleInfoListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            VehicleStatesViewOptionListener vehicleStatesViewOptionListener = (VehicleStatesViewOptionListener)iterator.next();
            if (this.vehicleInfoViewOptionWrapper == null) {
                vehicleStatesViewOptionListener.updateVehicleInfoDevice(n);
                if (this.drivingSchoolReason != 14) continue;
                this.drivingSchoolReason = 0;
                continue;
            }
            if (this.drivingSchoolReason == 14) {
                this.drivingSchoolReason = 0;
                return;
            }
            vehicleStatesViewOptionListener.updateVehicleInfoViewOption(this.vehicleInfoViewOptionWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 285) {
            this.deviceReason = n2;
            if (n2 != 0) {
                this.notifyListeners(n2);
            } else {
                this.notifyListeners(0);
            }
        }
        if (n == 360) {
            this.drivingSchoolReason = n2;
            if (n2 != 0) {
                this.notifyVehicleInfoListeners(n2);
            } else {
                this.notifyVehicleInfoListeners(0);
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

