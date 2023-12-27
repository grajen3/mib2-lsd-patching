/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.e_traction.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.e_traction.E_TractionViewOptionListener;
import de.vw.mib.asl.api.car.vo.e_traction.E_TractionViewOptionService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.e_traction.impl.BatteryControlViewOptionWrapper;
import de.vw.mib.asl.internal.car.srv.e_traction.impl.HybridViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public final class E_TractionViewOptionServiceImpl
extends CarEmptyTarget
implements E_TractionViewOptionService,
DSIServiceStateListener,
DeviceManagerListener {
    public static final int HYBRIDVIEWOPTIONS;
    public static final int BATTERYCONTROLVIEWOPTIONS;
    private static E_TractionViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarHybrid dsiE_Traction;
    private DSICarHybridListener dsiE_TractionListener;
    private boolean registerForHybrid;
    private boolean registerForBatteryControl;
    private BatteryControlViewOptionWrapper batteryControlViewOptionWrapper;
    private HybridViewOptionsWrapper hybridViewOptionsWrapper;
    private int hybridDeviceReason;
    private int batteryDeviceReason;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;

    private E_TractionViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static E_TractionViewOptionServiceImpl getInstance() {
        if (instance == null) {
            try {
                instance = new E_TractionViewOptionServiceImpl();
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return instance;
    }

    private void initDSI() {
        this.dsiE_Traction = (DSICarHybrid)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = E_TractionViewOptionServiceImpl.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid);
        this.dsiE_TractionListener = (DSICarHybridListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = E_TractionViewOptionServiceImpl.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener);
        ASLCarContainer.getInstance().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = E_TractionViewOptionServiceImpl.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid, this);
    }

    public void registerViewOption(int n) {
        if (n == 1) {
            this.registerForHybrid = true;
        } else if (n == 6) {
            this.registerForBatteryControl = true;
        }
    }

    @Override
    public void addListener(E_TractionViewOptionListener e_TractionViewOptionListener) {
        this.listeners.add(e_TractionViewOptionListener);
    }

    @Override
    public void removeListener(E_TractionViewOptionListener e_TractionViewOptionListener) {
        this.listeners.removeValue(e_TractionViewOptionListener);
    }

    public int getSubClassifier() {
        return 1;
    }

    public void dsiCarHybridUpdateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.batteryControlViewOptionWrapper = new BatteryControlViewOptionWrapper(batteryControlViewOptions);
        if (this.batteryDeviceReason == 0) {
            this.notifyBatteryControlListeners(0);
        }
    }

    public void dsiCarHybridUpdateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        this.hybridViewOptionsWrapper = new HybridViewOptionsWrapper(hybridViewOptions);
        if (this.hybridDeviceReason == 0) {
            this.notifyHybridListeners(0);
        }
    }

    private void notifyBatteryControlListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            E_TractionViewOptionListener e_TractionViewOptionListener = (E_TractionViewOptionListener)iterator.next();
            if (this.batteryControlViewOptionWrapper == null) {
                e_TractionViewOptionListener.updateBatteryControlDevice(n);
                if (this.batteryDeviceReason != 14) continue;
                this.batteryDeviceReason = 0;
                continue;
            }
            if (this.batteryDeviceReason == 14) {
                this.batteryDeviceReason = 0;
                return;
            }
            e_TractionViewOptionListener.updateBatteryControlViewOptions(this.batteryControlViewOptionWrapper, n);
        }
    }

    private void notifyHybridListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            E_TractionViewOptionListener e_TractionViewOptionListener = (E_TractionViewOptionListener)iterator.next();
            if (this.hybridViewOptionsWrapper == null) {
                e_TractionViewOptionListener.updateHybridDevice(n);
                if (this.hybridDeviceReason != 14) continue;
                this.hybridDeviceReason = 0;
                continue;
            }
            if (this.hybridDeviceReason == 14) {
                this.hybridDeviceReason = 0;
                return;
            }
            e_TractionViewOptionListener.updateHybridViewOptions(this.hybridViewOptionsWrapper, n);
        }
    }

    @Override
    public void registered(String string, int n) {
        if ((class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = E_TractionViewOptionServiceImpl.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid).getName().equals(string)) {
            if (this.registerForHybrid) {
                this.dsiE_Traction.setNotification(1, (DSIListener)this.dsiE_TractionListener);
            }
            if (this.registerForBatteryControl) {
                this.dsiE_Traction.setNotification(6, (DSIListener)this.dsiE_TractionListener);
            }
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 310: {
                this.hybridDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyHybridListeners(n2);
                    break;
                }
                this.notifyHybridListeners(0);
                break;
            }
            case 395: {
                this.batteryDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyBatteryControlListeners(n2);
                    break;
                }
                this.notifyBatteryControlListeners(0);
                break;
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

