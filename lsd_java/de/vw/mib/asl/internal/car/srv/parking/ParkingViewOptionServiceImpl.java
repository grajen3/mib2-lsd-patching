/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.parking;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionListener;
import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.parking.ParkingViewOptionWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystem;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class ParkingViewOptionServiceImpl
extends CarEmptyTarget
implements ParkingViewOptionService,
DeviceManagerListener {
    private static ParkingViewOptionServiceImpl instance;
    public static final int ATTR_PARKINGSYSTEMVIEWOPTIONS;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarParkingSystem dsiCarParking;
    private DSICarParkingSystemListener viewOptionsListener;
    private ParkingViewOptionWrapper parkingViewOptionWrapper;
    private int deviceReason;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem;
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener;

    private ParkingViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    private void initDSI() {
        this.dsiCarParking = (DSICarParkingSystem)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem = ParkingViewOptionServiceImpl.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystem")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystem);
        this.viewOptionsListener = (DSICarParkingSystemListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = ParkingViewOptionServiceImpl.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener);
    }

    public static ParkingViewOptionServiceImpl getInstance() {
        if (instance == null) {
            try {
                instance = new ParkingViewOptionServiceImpl();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return instance;
    }

    public void registerViewOption(int n) {
        this.dsiCarParking.setNotification(n, (DSIListener)this.viewOptionsListener);
    }

    @Override
    public void addListener(ParkingViewOptionListener parkingViewOptionListener) {
        this.listeners.add(parkingViewOptionListener);
    }

    @Override
    public void removeListener(ParkingViewOptionListener parkingViewOptionListener) {
        this.listeners.removeValue(parkingViewOptionListener);
    }

    public void dsiCarParkingSystemUpdateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions:").append(parkingSystemViewOptions).toString());
        this.parkingViewOptionWrapper = new ParkingViewOptionWrapper(parkingSystemViewOptions);
        this.evaluate5thCamConfig(parkingSystemViewOptions);
        if (this.deviceReason == 0) {
            this.notifyListeners(0);
        }
    }

    private void evaluate5thCamConfig(ParkingSystemViewOptions parkingSystemViewOptions) {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions extCamConfig1:").append(parkingSystemViewOptions.vpsExtCamConfig.getState()).append(", ").append(parkingSystemViewOptions.getVpsExtCamConfig().getReason()).toString());
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions extCamManAct1:").append(parkingSystemViewOptions.vpsExtCamManActivation.getState()).append(", ").append(parkingSystemViewOptions.vpsExtCamManActivation.getReason()).toString());
        CarViewOption carViewOption = new CarViewOption(0, 0);
        CarViewOption carViewOption2 = new CarViewOption(0, 0);
        if (parkingSystemViewOptions.vpsExtCamManActivation.state == 2 && parkingSystemViewOptions.vpsExtCamConfig.state == 2) {
            carViewOption.state = 2;
            carViewOption.reason = 0;
            carViewOption2.state = 2;
            carViewOption2.reason = 0;
        } else if (parkingSystemViewOptions.vpsExtCamManActivation.state == 1 && parkingSystemViewOptions.vpsExtCamConfig.state == 1) {
            carViewOption.state = 1;
            carViewOption.reason = parkingSystemViewOptions.vpsExtCamManActivation.reason;
            carViewOption2.state = 1;
            carViewOption2.reason = parkingSystemViewOptions.vpsExtCamConfig.reason;
        } else if (parkingSystemViewOptions.vpsExtCamManActivation.state == 1 && parkingSystemViewOptions.vpsExtCamConfig.state == 2) {
            carViewOption.state = 1;
            carViewOption.reason = parkingSystemViewOptions.vpsExtCamManActivation.reason;
            carViewOption2.state = 2;
            carViewOption2.reason = 0;
        } else if (parkingSystemViewOptions.vpsExtCamManActivation.state == 2 && parkingSystemViewOptions.vpsExtCamConfig.state == 1) {
            carViewOption.state = 2;
            carViewOption.reason = 0;
            carViewOption2.state = 1;
            carViewOption2.reason = parkingSystemViewOptions.vpsExtCamConfig.reason;
        }
        if (parkingSystemViewOptions.vpsExtCamManActivation.state == 2 && parkingSystemViewOptions.vpsExtCamConfig.state == 0) {
            carViewOption.state = 2;
            carViewOption.reason = 0;
            carViewOption2.state = 0;
            carViewOption2.reason = 0;
        } else if (parkingSystemViewOptions.vpsExtCamManActivation.state == 1 && parkingSystemViewOptions.vpsExtCamConfig.state == 0) {
            carViewOption.state = 1;
            carViewOption.reason = parkingSystemViewOptions.vpsExtCamManActivation.reason;
            carViewOption2.state = 0;
            carViewOption2.reason = 0;
        }
        this.parkingViewOptionWrapper.setExtCamInterior(carViewOption);
        this.parkingViewOptionWrapper.setExtCamExterior(carViewOption2);
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions cameraInt:").append(carViewOption.getState()).append(", ").append(carViewOption.getReason()).toString());
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions cameraExt:").append(carViewOption2.getState()).append(", ").append(carViewOption2.getReason()).toString());
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 200) {
            this.deviceReason = n2;
            if (n2 != 0) {
                this.notifyListeners(n2);
            } else {
                this.notifyListeners(0);
            }
        }
    }

    private void notifyListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ParkingViewOptionListener parkingViewOptionListener = (ParkingViewOptionListener)iterator.next();
            if (this.parkingViewOptionWrapper == null) {
                parkingViewOptionListener.updateParkingDevice(n);
                if (this.deviceReason != 14) continue;
                this.deviceReason = 0;
                continue;
            }
            if (this.deviceReason == 14) {
                this.deviceReason = 0;
                return;
            }
            parkingViewOptionListener.updateParkingViewOptions(this.parkingViewOptionWrapper, n);
        }
    }

    public void notifyFifthCam() {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Parking.notifyFifthCam1");
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Pers.notifyFifthCam2");
            ParkingViewOptionListener parkingViewOptionListener = (ParkingViewOptionListener)iterator.next();
            parkingViewOptionListener.updateParkingFifthCamCoded();
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

