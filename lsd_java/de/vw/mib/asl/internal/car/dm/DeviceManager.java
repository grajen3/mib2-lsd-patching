/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm;

import de.vw.mib.asl.api.car.vo.DeviceManagerInterface;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.ViewOptionFactory;
import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.dm.DeviceManager$AdaptationData;
import de.vw.mib.asl.internal.car.dm.states.VehicleState;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateClamp15;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateMoving;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateNormal;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateSpeed;
import de.vw.mib.asl.internal.car.dm.states.VehicleStateUnknown;
import de.vw.mib.asl.internal.car.srv.ViewOptionServiceFactory;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntCollection;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class DeviceManager
extends AbstractTarget
implements DeviceManagerInterface,
DSIServiceStateListener,
AdaptionResponse {
    public static final int DEVICE_AVAILABLE_REASON_NORMAL;
    public static final int DEVICE_AVAILABLE_REASON_CLAMP15;
    public static final int DEVICE_AVAILABLE_REASON_MOVING;
    public static final int DEVICE_AVAILABLE_REASON_SPEED;
    public static final int DEVICE_AVAILABLE_REASON_UNKNOWN;
    public static final int VALUE_UNKNOWN;
    public static final int VALUE_TRUE;
    public static final int VALUE_FALSE;
    private int clamp15 = -1;
    private int standstill = -1;
    private int speedTooHigh = -1;
    private VehicleState stateClamp15;
    private VehicleState stateNormal;
    private VehicleState stateMoving;
    private VehicleState stateSpeed;
    private VehicleState stateUnknown;
    private VehicleState state;
    ObjectArrayList listener = new ObjectArrayList();
    private IntObjectMap menuCodingTable = new IntObjectOptHashMap();
    private IntCollection deviceList;
    private IntArrayList standStillDevices = new IntArrayList();
    private IntArrayList speedDevices = new IntArrayList();
    private IntArrayList disclaimerDevices = new IntArrayList();
    private IntArrayList allCodedDevices = new IntArrayList();
    private IntArrayList noCodingDevices = new IntArrayList();
    private boolean dsiRegistrationDone;
    private ViewOptionFactory voFactory;
    Logger aslLogger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public DeviceManager(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.stateClamp15 = new VehicleStateClamp15(this);
        this.stateNormal = new VehicleStateNormal(this);
        this.stateMoving = new VehicleStateMoving(this);
        this.stateSpeed = new VehicleStateSpeed(this);
        this.state = this.stateUnknown = new VehicleStateUnknown(this);
        this.initTable();
        this.voFactory = ViewOptionServiceFactory.getInstance();
    }

    public void requestMenuCoding() {
        ServiceManager.adaptionApi.requestCarFuncAdap(this);
    }

    private void initTable() {
        this.menuCodingTable.put(190, new DeviceManager$AdaptationData(this, 190, 191, 192, 193, 194));
        this.menuCodingTable.put(195, new DeviceManager$AdaptationData(this, 195, 196, 197, 198, 199));
        this.menuCodingTable.put(200, new DeviceManager$AdaptationData(this, 200, 201, 202, 203, 204));
        this.menuCodingTable.put(205, new DeviceManager$AdaptationData(this, 205, 206, 207, 208, 209));
        this.menuCodingTable.put(210, new DeviceManager$AdaptationData(this, 210, 211, 212, 213, 214));
        this.menuCodingTable.put(215, new DeviceManager$AdaptationData(this, 215, 216, 217, 218, 219));
        this.menuCodingTable.put(220, new DeviceManager$AdaptationData(this, 220, 221, 222, 223, 224));
        this.menuCodingTable.put(225, new DeviceManager$AdaptationData(this, 225, 226, 227, 228, 229));
        this.menuCodingTable.put(230, new DeviceManager$AdaptationData(this, 230, 231, 232, 233, 234));
        this.menuCodingTable.put(240, new DeviceManager$AdaptationData(this, 240, 241, 242, 243, 244));
        this.menuCodingTable.put(245, new DeviceManager$AdaptationData(this, 245, 246, 247, 248, 249));
        this.menuCodingTable.put(250, new DeviceManager$AdaptationData(this, 250, 251, 252, 253, 254));
        this.menuCodingTable.put(255, new DeviceManager$AdaptationData(this, 255, 256, 257, 258, 259));
        this.menuCodingTable.put(260, new DeviceManager$AdaptationData(this, 260, 261, 262, 263, 264));
        this.menuCodingTable.put(265, new DeviceManager$AdaptationData(this, 265, 266, 267, 268, 269));
        this.menuCodingTable.put(285, new DeviceManager$AdaptationData(this, 285, 286, 287, 288, 289));
        this.menuCodingTable.put(290, new DeviceManager$AdaptationData(this, 290, 291, 292, 293, 294));
        this.menuCodingTable.put(295, new DeviceManager$AdaptationData(this, 295, 296, 297, 298, 299));
        this.menuCodingTable.put(300, new DeviceManager$AdaptationData(this, 300, 301, 302, 303, 304));
        this.menuCodingTable.put(305, new DeviceManager$AdaptationData(this, 305, 306, 307, 308, 309));
        this.menuCodingTable.put(310, new DeviceManager$AdaptationData(this, 310, 311, 312, 313, 314));
        this.menuCodingTable.put(315, new DeviceManager$AdaptationData(this, 315, 316, 317, 318, 319));
        this.menuCodingTable.put(320, new DeviceManager$AdaptationData(this, 320, 321, 322, 323, 324));
        this.menuCodingTable.put(330, new DeviceManager$AdaptationData(this, 330, 331, 332, 333, 334));
        this.menuCodingTable.put(340, new DeviceManager$AdaptationData(this, 340, 341, 342, 343, 344));
        this.menuCodingTable.put(355, new DeviceManager$AdaptationData(this, 355, 356, 357, 358, 359));
        this.menuCodingTable.put(360, new DeviceManager$AdaptationData(this, 360, 361, 362, 363, 364));
        this.menuCodingTable.put(365, new DeviceManager$AdaptationData(this, 365, 366, 367, 368, 369));
        this.menuCodingTable.put(380, new DeviceManager$AdaptationData(this, 380, 381, 382, 383, 384));
        this.menuCodingTable.put(385, new DeviceManager$AdaptationData(this, 385, 386, 387, 388, 389));
        this.menuCodingTable.put(395, new DeviceManager$AdaptationData(this, 395, 396, 397, 398, 399));
        this.menuCodingTable.put(425, new DeviceManager$AdaptationData(this, 425, 426, 427, 428, 429));
        this.menuCodingTable.put(465, new DeviceManager$AdaptationData(this, 465, 466, 467, 468, 469));
    }

    public void readCarFuncAdapt(CarFuncAdap carFuncAdap) {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        IntIterator intIterator = this.menuCodingTable.keySet().iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            DeviceManager$AdaptationData deviceManager$AdaptationData = (DeviceManager$AdaptationData)this.menuCodingTable.get(n);
            if (!carFuncAdap.getBoolean(deviceManager$AdaptationData.deviceID)) continue;
            if (this.aslLogger.isTraceEnabled(1)) {
                this.aslLogger.trace(1, new StringBuffer().append("DM.Device ID:").append(deviceManager$AdaptationData.deviceID).toString());
            }
            intOptHashSet.add(n);
            this.allCodedDevices.add(n);
            boolean bl = carFuncAdap.getBoolean(deviceManager$AdaptationData.standstillID);
            if (this.aslLogger.isTraceEnabled(1)) {
                this.aslLogger.trace(1, new StringBuffer().append("DM.isStandStillID:").append(deviceManager$AdaptationData.standstillID).append(", value: ").append(bl).toString());
            }
            boolean bl2 = carFuncAdap.getBoolean(deviceManager$AdaptationData.speedTooHighID);
            if (this.aslLogger.isTraceEnabled(1)) {
                this.aslLogger.trace(1, new StringBuffer().append("DM.isSpeedID:").append(deviceManager$AdaptationData.speedTooHighID).append(", value: ").append(bl2).toString());
            }
            boolean bl3 = carFuncAdap.getBoolean(deviceManager$AdaptationData.disclaimerID);
            if (this.aslLogger.isTraceEnabled(1)) {
                this.aslLogger.trace(1, new StringBuffer().append("DM.disclaimerID:").append(deviceManager$AdaptationData.disclaimerID).append(", value: ").append(bl3).toString());
            }
            if (bl2) {
                this.noCodingDevices.add(n);
                continue;
            }
            this.speedDevices.add(n);
            if (!bl) continue;
            this.standStillDevices.add(n);
            this.speedDevices.removeValue(n);
        }
        this.voFactory.createViewOption(intOptHashSet.toArray());
        this.readDevicesConfig();
    }

    private void readDevicesConfig() {
        Car car = CarPersistenceServiceImpl.getInstance().loadCar();
        ServiceManager.aslPropertyManager.valueChangedBoolean(319, car.isFrontWindowHeater());
        ServiceManager.aslPropertyManager.valueChangedBoolean(318, car.isSteeringWheelheater());
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("ParkingSystemViewOptions readConfigAsBoolean: ").append(car.isFifthCamera()).toString());
        if (car.isFifthCamera()) {
            this.voFactory.createViewOption(new int[]{1015});
        }
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("IsPSOCoded:").append(car.isPersonalization()).toString());
        if (car.isPersonalization()) {
            this.voFactory.createViewOption(new int[]{1000});
        }
        if (car.isAmbientLight()) {
            this.voFactory.createViewOption(new int[]{1010});
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10544, car.isHDC());
        ServiceManager.aslPropertyManager.valueChangedBoolean(321, car.isClimateSetupButton());
        ServiceManager.aslPropertyManager.valueChangedInteger(10900, car.getRDKSystem());
        ServiceManager.aslPropertyManager.valueChangedInteger(10487, car.getRDKLoadChange());
        ServiceManager.aslPropertyManager.valueChangedInteger(10553, car.getSportLeftTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10552, car.getSportMiddleTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10558, car.getSportRightTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10555, car.getOffroadLeftTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10556, car.getOffroadMiddleTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10557, car.getOffroadRightTube());
    }

    private void registerDSI() {
        if (this.dsiRegistrationDone) {
            return;
        }
        this.dsiRegistrationDone = true;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = DeviceManager.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        DSIPowerManagementListener dSIPowerManagementListener = (DSIPowerManagementListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = DeviceManager.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        dSIPowerManagement.setNotification(4, (DSIListener)dSIPowerManagementListener);
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DeviceManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    public VehicleState getVehicleState() {
        return this.state;
    }

    public void notify(IntArrayList intArrayList, int n) {
        if (this.isTraceEnabled()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().trace(1, new StringBuffer().append("DM.notify: ").append(intArrayList.toString()).append(",").append(n).toString());
        }
        IntIterator intIterator = intArrayList.iterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            Iterator iterator = this.listener.iterator();
            while (iterator.hasNext()) {
                DeviceManagerListener deviceManagerListener = (DeviceManagerListener)iterator.next();
                deviceManagerListener.onDeviceAvailableReasonChange(n2, n);
            }
        }
    }

    public IntArrayList diffList(IntArrayList intArrayList, IntArrayList intArrayList2) {
        IntArrayList intArrayList3 = new IntArrayList();
        IntIterator intIterator = intArrayList.iterator();
        while (intIterator.hasNext()) {
            intArrayList3.add(intIterator.next());
        }
        IntIterator intIterator2 = intArrayList2.iterator();
        while (intIterator2.hasNext()) {
            intArrayList3.removeValue(intIterator2.next());
        }
        return intArrayList3;
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (this.clamp15 == 1 && clampSignal.clamp15) {
            return;
        }
        if (this.clamp15 == 0 && !clampSignal.clamp15) {
            return;
        }
        this.clamp15 = clampSignal.clamp15 ? 1 : 0;
        this.state.onClamp15(clampSignal.clamp15);
        if (this.aslLogger.isTraceEnabled(1)) {
            this.aslLogger.trace(1, new StringBuffer().append("DM.Clamp15: ").append(this.clamp15).append(", newState: ").append(super.getClass()).toString());
        }
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        this.standstill = bl ? 1 : 0;
        this.state.onStandstill(bl);
        if (this.aslLogger.isTraceEnabled(1)) {
            this.aslLogger.trace(1, new StringBuffer().append("DM.Standstill: ").append(this.standstill).append(", newState: ").append(super.getClass()).toString());
        }
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        this.speedTooHigh = bl ? 1 : 0;
        this.state.onSpeed(bl);
        if (this.aslLogger.isTraceEnabled(1)) {
            this.aslLogger.trace(1, new StringBuffer().append("DM.CarVelo: ").append(this.speedTooHigh).append(", newState: ").append(super.getClass()).toString());
        }
    }

    public void setState(VehicleState vehicleState) {
        this.state.onExit();
        this.state = vehicleState;
        vehicleState.onEntry();
    }

    public VehicleState getState() {
        return this.state;
    }

    public boolean isDeviceCoded(int n) {
        if (this.deviceList == null) {
            return false;
        }
        return this.deviceList.contains(n);
    }

    public boolean isDeviceOnClamp15Coded(int n) {
        if (this.allCodedDevices == null) {
            return false;
        }
        return this.allCodedDevices.contains(n);
    }

    public boolean isDeviceOnStandstillCoded(int n) {
        if (this.standStillDevices == null) {
            return false;
        }
        return this.standStillDevices.contains(n);
    }

    public boolean isDeviceOnSpeedCoded(int n) {
        if (this.speedDevices == null) {
            return false;
        }
        return this.speedDevices.contains(n);
    }

    public IntArrayList getAllCodedDevices() {
        return this.allCodedDevices;
    }

    public IntArrayList getNoCodingDevices() {
        return this.noCodingDevices;
    }

    public IntArrayList getStandStillDevices() {
        return this.standStillDevices;
    }

    public IntArrayList getSpeedDevices() {
        return this.speedDevices;
    }

    public VehicleState getStateClamp15() {
        return this.stateClamp15;
    }

    public VehicleState getStateNormal() {
        return this.stateNormal;
    }

    public VehicleState getStateMoving() {
        return this.stateMoving;
    }

    public VehicleState getStateSpeed() {
        return this.stateSpeed;
    }

    public VehicleState getStateUnknown() {
        return this.stateUnknown;
    }

    public int getClamp15() {
        return this.clamp15;
    }

    public int getStandstill() {
        return this.standstill;
    }

    public int getSpeedTooHigh() {
        return this.speedTooHigh;
    }

    public boolean isMoving() {
        return this.clamp15 == 1 && this.standstill == 0 && this.speedTooHigh == 0;
    }

    public boolean isSpeedTooHigh() {
        return this.clamp15 == 1 && this.standstill == 0 && this.speedTooHigh == 1;
    }

    public boolean isNormal() {
        return this.clamp15 == 1 && this.standstill == 1 && this.speedTooHigh == 0;
    }

    @Override
    public int getDefaultTargetId() {
        return -1756425728;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            default: 
        }
    }

    @Override
    public void addListener(DeviceManagerListener deviceManagerListener) {
        this.listener.add(deviceManagerListener);
    }

    @Override
    public void removeListener(DeviceManagerListener deviceManagerListener) {
        this.listener.removeValue(deviceManagerListener);
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DeviceManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DeviceManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{22, 7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = DeviceManager.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void onSuccess(Access access) {
        this.readCarFuncAdapt((CarFuncAdap)access);
        this.registerDSI();
    }

    @Override
    public void onError() {
        if (this.isTraceEnabled()) {
            ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().error(1, "DM.onError: Error requesting car function adapter");
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

