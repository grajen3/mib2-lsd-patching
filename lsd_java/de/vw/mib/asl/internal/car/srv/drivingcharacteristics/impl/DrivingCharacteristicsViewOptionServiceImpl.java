/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drivingcharacteristics.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.DrivingCharacteristicsViewOptionListener;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.DrivingCharacteristicsViewOptionService;
import de.vw.mib.asl.api.car.vo.drivingcharacteristics.SuspensionControlViewOptionsData;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.drivingcharacteristics.impl.SuspensionControlViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;

public final class DrivingCharacteristicsViewOptionServiceImpl
extends CarEmptyTarget
implements DrivingCharacteristicsViewOptionService,
DeviceManagerListener {
    public static final int SUSPENSIONCONTROLVIEWOPTIONS;
    private static DrivingCharacteristicsViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarDrivingCharacteristics dsiCarTarget;
    private DSICarDrivingCharacteristicsListener dsiCarListener;
    private int deviceReason;
    private SuspensionControlViewOptionsData data;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;

    private DrivingCharacteristicsViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static DrivingCharacteristicsViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new DrivingCharacteristicsViewOptionServiceImpl();
        }
        return instance;
    }

    private void initDSI() {
        this.dsiCarTarget = (DSICarDrivingCharacteristics)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = DrivingCharacteristicsViewOptionServiceImpl.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics);
        this.dsiCarListener = (DSICarDrivingCharacteristicsListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = DrivingCharacteristicsViewOptionServiceImpl.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarTarget.setNotification(n, (DSIListener)this.dsiCarListener);
    }

    @Override
    public void addListener(DrivingCharacteristicsViewOptionListener drivingCharacteristicsViewOptionListener) {
        this.listeners.add(drivingCharacteristicsViewOptionListener);
    }

    @Override
    public void removeListener(DrivingCharacteristicsViewOptionListener drivingCharacteristicsViewOptionListener) {
        this.listeners.removeValue(drivingCharacteristicsViewOptionListener);
    }

    public void dsiCarDrivingCharacteristicsUpdateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        this.data = new SuspensionControlViewOptionsWrapper(suspensionControlViewOptions);
        if (this.deviceReason == 0) {
            this.notifyListeners(0);
        }
    }

    private void notifyListeners(int n) {
        if (this.data == null) {
            return;
        }
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DrivingCharacteristicsViewOptionListener drivingCharacteristicsViewOptionListener = (DrivingCharacteristicsViewOptionListener)iterator.next();
            if (this.data == null) {
                drivingCharacteristicsViewOptionListener.updateSuspensionControlDevice(n);
                if (this.deviceReason != 14) continue;
                this.deviceReason = 0;
                continue;
            }
            if (this.deviceReason == 14) {
                this.deviceReason = 0;
                return;
            }
            drivingCharacteristicsViewOptionListener.updateSuspensionControlViewOptions(this.data, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 295) {
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

