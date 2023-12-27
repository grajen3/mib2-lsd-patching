/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.comfort.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionListener;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionService;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.comfort.impl.BrakeViewOptionWrapper;
import de.vw.mib.asl.internal.car.srv.comfort.impl.DoorLockingViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.comfort.impl.MirrorViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.comfort.impl.RDKViewOptionsCollector;
import de.vw.mib.asl.internal.car.srv.comfort.impl.RGSViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.comfort.impl.UGDOViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.comfort.impl.WiperViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.transformer.CarHDCAvailabilityCollector;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class ComfortViewOptionServiceImpl
extends CarEmptyTarget
implements ComfortViewOptionService,
DeviceManagerListener {
    private static ComfortViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarComfort dsiCarComfort;
    private DSICarComfortListener viewOptionsListener;
    public static final int RGSVIEWOPTIONS;
    public static final int MIRRORVIEWOPTIONS;
    public static final int WIPERVIEWOPTIONS;
    public static final int RDKVIEWOPTIONS;
    public static final int RDKSYSTEMONOFF;
    public static final int RDKTIRESETUPTIRELIST;
    public static final int DOORLOCKINGVIEWOPTIONS;
    public static final int UGDOVIEWOPTIONS;
    public static final int ATTR_BRAKEVIEWOPTIONS;
    private boolean rdkInitialized;
    private int deviceReasonRDK;
    private int deviceReasonBrake;
    private int deviceReasonRGS;
    private int deviceReasonWiper;
    private int deviceReasonMirror;
    private int deviceReasonDoor;
    private int deviceReasonUgdo;
    private int tireInfo = 0;
    private RGSViewOptionsWrapper RGSwrapper;
    private WiperViewOptionsWrapper wiperVOwrapper;
    private MirrorViewOptionsWrapper mirrorVOwrapper;
    private DoorLockingViewOptionsWrapper doorVOwrapper;
    private UGDOViewOptionsWrapper ugdoVOwrapper;
    private RDKViewOptions myRDKViewOptions = new RDKViewOptions(new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new RDKConfiguration(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption(), new CarViewOption());
    private RDKViewOptionsCollector myRDKViewOptionsData = new RDKViewOptionsCollector();
    private static final CarViewOption NOT_EXISTING_VIEWOPTION;
    BrakeViewOptionWrapper brakeViewOptionsWrapper;
    private final boolean[] autoHold = new boolean[3];
    private DoorLockingViewOptions doorLockingViewOptions;
    private static final int AUTOHOLD_ACTIVE;
    private static final int AUTOHOLD_NOTACTIVE;
    private static final int AUTOHOLD_LASTMODE;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    private ComfortViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static ComfortViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new ComfortViewOptionServiceImpl();
        }
        return instance;
    }

    public void registerViewOption(int n) {
        this.dsiCarComfort.setNotification(n, (DSIListener)this.viewOptionsListener);
    }

    private void initDSI() {
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = ComfortViewOptionServiceImpl.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.viewOptionsListener = (DSICarComfortListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = ComfortViewOptionServiceImpl.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener);
    }

    @Override
    public void addListener(ComfortViewOptionListener comfortViewOptionListener) {
        if (!(comfortViewOptionListener instanceof ComfortViewOptionAdapter)) {
            throw new IllegalArgumentException();
        }
        this.listeners.add(comfortViewOptionListener);
        if (this.doorLockingViewOptions != null) {
            if (this.doorVOwrapper != null) {
                comfortViewOptionListener.updateDoorLockingViewOptions(this.doorVOwrapper, 0);
            } else {
                this.doorVOwrapper = new DoorLockingViewOptionsWrapper(this.doorLockingViewOptions);
                comfortViewOptionListener.updateDoorLockingViewOptions(this.doorVOwrapper, 0);
            }
        }
    }

    @Override
    public void removeListener(ComfortViewOptionListener comfortViewOptionListener) {
        this.listeners.removeValue(comfortViewOptionListener);
    }

    public void dsiCarComfortUpdateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        this.RGSwrapper = new RGSViewOptionsWrapper(rGSViewOptions);
        if (this.deviceReasonRGS == 0) {
            this.notifyRGSListeners(0);
        }
    }

    private void notifyRGSListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.RGSwrapper == null) {
                comfortViewOptionListener.updateRGSDevice(n);
                if (this.deviceReasonRGS != 14) continue;
                this.deviceReasonRGS = 0;
                continue;
            }
            if (this.deviceReasonRGS == 14) {
                this.deviceReasonRGS = 0;
                return;
            }
            comfortViewOptionListener.updateRGSViewOptions(this.RGSwrapper, n);
        }
    }

    public void dsiCarComfortUpdateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        this.mirrorVOwrapper = new MirrorViewOptionsWrapper(mirrorViewOptions);
        if (this.deviceReasonMirror == 0) {
            this.notifyMirrorVListeners(0);
        }
    }

    private void notifyMirrorVListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.mirrorVOwrapper == null) {
                comfortViewOptionListener.updateMirrorDevice(n);
                if (this.deviceReasonMirror != 14) continue;
                this.deviceReasonMirror = 0;
                continue;
            }
            if (this.deviceReasonMirror == 14) {
                this.deviceReasonMirror = 0;
                return;
            }
            comfortViewOptionListener.updateMirrorViewOptions(this.mirrorVOwrapper, n);
        }
    }

    public void dsiCarComfortUpdateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        this.ugdoVOwrapper = new UGDOViewOptionsWrapper(uGDOViewOptions);
        if (this.deviceReasonUgdo == 0) {
            this.notifyLUGDOListeners(0);
        }
    }

    private void notifyLUGDOListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.ugdoVOwrapper == null) {
                comfortViewOptionListener.updateUGDODevice(n);
                if (this.deviceReasonUgdo != 14) continue;
                this.deviceReasonUgdo = 0;
                continue;
            }
            if (this.deviceReasonUgdo == 14) {
                this.deviceReasonUgdo = 0;
                return;
            }
            comfortViewOptionListener.updateUGDOViewOptions(this.ugdoVOwrapper, n);
        }
    }

    public void dsiCarComfortUpdateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        this.wiperVOwrapper = new WiperViewOptionsWrapper(wiperViewOptions);
        if (this.deviceReasonWiper == 0) {
            this.notifyWiperVListeners(0);
        }
    }

    private void notifyWiperVListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.wiperVOwrapper == null) {
                comfortViewOptionListener.updateWiperDevice(n);
                if (this.deviceReasonWiper != 14) continue;
                this.deviceReasonWiper = 0;
                continue;
            }
            if (this.deviceReasonWiper == 14) {
                this.deviceReasonWiper = 0;
                return;
            }
            comfortViewOptionListener.updateWiperViewOptions(this.wiperVOwrapper, n);
        }
    }

    public void dsiCarComfortUpdateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        this.myRDKViewOptions = rDKViewOptions;
        this.evaluateRDKViewOptions();
    }

    private void evaluateRDKViewOptions() {
        this.myRDKViewOptionsData = new RDKViewOptionsCollector();
        switch (this.myRDKViewOptions.getConfiguration().getSystem()) {
            case 0: {
                if (this.isRdkInitialized()) {
                    this.myRDKViewOptionsData.setTirePressureDisplay(this.myRDKViewOptions.getTireDisplay());
                }
                this.myRDKViewOptionsData.setRKASetCalibrate(this.myRDKViewOptions.getPressureChanged());
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                if (this.isRdkInitialized()) {
                    this.myRDKViewOptionsData.setTirePressureDisplay(this.myRDKViewOptions.getTireDisplay());
                }
                if (this.getTireInfo() < 2) break;
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
                    this.myRDKViewOptionsData.setTireType(new CarViewOption(2, 0));
                    break;
                }
                this.myRDKViewOptionsData.setTireType(this.myRDKViewOptions.getTireSetup());
                break;
            }
        }
        this.evaluateRDKPartFullLoadViewOptions(this.myRDKViewOptionsData);
        if (this.deviceReasonRDK == 0) {
            this.notifyRDKListeners(0);
        }
    }

    private void evaluateRDKPartFullLoadViewOptions(RDKViewOptionsCollector rDKViewOptionsCollector) {
        if (!ServiceManager.configManagerDiag.isFeatureFlagSet(105) || this.myRDKViewOptions.getConfiguration().getSystem() != 2) {
            if (this.myRDKViewOptions.configuration.pressureLevel2 || this.myRDKViewOptions.configuration.pressureLevel3 || ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
                rDKViewOptionsCollector.setTirePressureLevel(this.myRDKViewOptions.getTireDisplay());
            } else {
                rDKViewOptionsCollector.setTirePressureLevel(NOT_EXISTING_VIEWOPTION);
            }
        }
    }

    public void dsiCarComfortUpdateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        boolean bl = doorLockingViewOptions.getUserProfileOnOff().getState() != 0;
        CarPersistenceServiceImpl.getInstance().loadCar().setPersonalization(bl);
        this.doorVOwrapper = new DoorLockingViewOptionsWrapper(doorLockingViewOptions);
        if (doorLockingViewOptions.getConfiguration().isBootBlind()) {
            this.doorVOwrapper.setBootBlind(doorLockingViewOptions.getComfortOpen());
        } else {
            this.doorVOwrapper.setBootBlind(new CarViewOption(0, 0));
        }
        if (this.deviceReasonDoor == 0) {
            this.notifyLDoorListeners(0);
        }
    }

    private void notifyLDoorListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.doorVOwrapper == null) {
                comfortViewOptionListener.updateDoorLockingDevice(n);
                if (this.deviceReasonDoor != 14) continue;
                this.deviceReasonDoor = 0;
                continue;
            }
            if (this.deviceReasonDoor == 14) {
                this.deviceReasonDoor = 0;
                return;
            }
            comfortViewOptionListener.updateDoorLockingViewOptions(this.doorVOwrapper, n);
        }
    }

    private void notifyRDKListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.myRDKViewOptionsData == null) {
                comfortViewOptionListener.updateRDKDevice(n);
                if (this.deviceReasonRDK != 14) continue;
                this.deviceReasonRDK = 0;
                continue;
            }
            if (this.deviceReasonRDK == 14) {
                this.deviceReasonRDK = 0;
                return;
            }
            comfortViewOptionListener.updateRDKViewOptions(this.myRDKViewOptionsData, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 245: {
                this.deviceReasonRDK = n2;
                if (n2 != 0) {
                    this.notifyRDKListeners(n2);
                    break;
                }
                this.notifyRDKListeners(0);
                break;
            }
            case 380: {
                this.deviceReasonBrake = n2;
                if (n2 != 0) {
                    this.notifyBrakeListeners(n2);
                    break;
                }
                this.notifyBrakeListeners(0);
                break;
            }
            case 330: {
                this.deviceReasonRGS = n2;
                if (n2 != 0) {
                    this.notifyRGSListeners(n2);
                    break;
                }
                this.notifyRGSListeners(0);
                break;
            }
            case 250: {
                this.deviceReasonWiper = n2;
                if (n2 != 0) {
                    this.notifyWiperVListeners(n2);
                    break;
                }
                this.notifyWiperVListeners(0);
                break;
            }
            case 355: {
                this.deviceReasonMirror = n2;
                if (n2 != 0) {
                    this.notifyMirrorVListeners(n2);
                    break;
                }
                this.notifyMirrorVListeners(0);
                break;
            }
            case 265: {
                this.deviceReasonDoor = n2;
                if (n2 != 0) {
                    this.notifyLDoorListeners(n2);
                    break;
                }
                this.notifyLDoorListeners(0);
                break;
            }
            case 315: {
                this.deviceReasonUgdo = n2;
                if (n2 != 0) {
                    this.notifyLUGDOListeners(n2);
                    break;
                }
                this.notifyLUGDOListeners(0);
                break;
            }
        }
    }

    private boolean isRdkInitialized() {
        return this.rdkInitialized;
    }

    public void setRdkInitialized(boolean bl) {
        this.rdkInitialized = bl;
        this.evaluateRDKViewOptions();
    }

    public void setTireInfo(int n) {
        this.tireInfo = n;
        this.evaluateRDKViewOptions();
    }

    public int getTireInfo() {
        return this.tireInfo;
    }

    public void dsiCarComfortUpdateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        if (!brakeViewOptions.getConfiguration().autoHoldOnOff) {
            brakeViewOptions.brakeAutoHold = new CarViewOption(0, 0);
        } else {
            this.autoHold[0] = brakeViewOptions.getConfiguration().autoHoldOnOff;
            this.autoHold[1] = brakeViewOptions.getConfiguration().autoHoldOnOff;
            this.autoHold[2] = brakeViewOptions.getConfiguration().isAutoHoldLastMode();
            ServiceManager.aslPropertyManager.valueChangedFlagVector(10476, this.autoHold);
        }
        CarHDCAvailabilityCollector carHDCAvailabilityCollector = new CarHDCAvailabilityCollector();
        carHDCAvailabilityCollector.car_hdc_availability_state = brakeViewOptions.getBrakeHdcMode().getState() == 2;
        carHDCAvailabilityCollector.car_hdc_availability_reason = this.carViewOptionsReason(brakeViewOptions.getBrakeHdcMode().getReason());
        ListManager.getGenericASLList(10545).updateListItem(0, carHDCAvailabilityCollector);
        boolean bl = brakeViewOptions.getBrakeHdcMode().getState() != 0;
        CarPersistenceServiceImpl.getInstance().loadCar().setHDC(bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10544, bl);
        this.brakeViewOptionsWrapper = new BrakeViewOptionWrapper(brakeViewOptions);
        if (this.deviceReasonBrake == 0) {
            this.notifyBrakeListeners(0);
        }
    }

    private int carViewOptionsReason(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 8: {
                n2 = 5;
                break;
            }
            case 13: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 6;
            }
        }
        return n2;
    }

    private void notifyBrakeListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            if (this.brakeViewOptionsWrapper == null) {
                comfortViewOptionListener.updateBrakeDevice(n);
                if (this.deviceReasonBrake != 14) continue;
                this.deviceReasonBrake = 0;
                continue;
            }
            if (this.deviceReasonBrake == 14) {
                this.deviceReasonBrake = 0;
                return;
            }
            comfortViewOptionListener.updateBrakeViewOptions(this.brakeViewOptionsWrapper, n);
        }
    }

    public void notifyPso() {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Pers.notifyPso1");
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, "Pers.notifyPso2");
            ComfortViewOptionListener comfortViewOptionListener = (ComfortViewOptionListener)iterator.next();
            comfortViewOptionListener.updatePersonalizationConfiguration(true);
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

    static {
        NOT_EXISTING_VIEWOPTION = new CarViewOption(0, 1);
    }
}

