/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.drvass.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionListener;
import de.vw.mib.asl.api.car.vo.drvass.DriverAssistanceViewOptionService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.drvass.impl.ACCViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.AWVViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.LdwhcaViewOptionWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.MKEViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.NVViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.PAViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.SWAViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.drvass.impl.TSDViewOptionsWrapper;
import de.vw.mib.asl.internal.car.viewoption.StateWork;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistance;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class DriverAssistanceViewOptionsServiceImpl
extends AbstractTarget
implements DriverAssistanceViewOptionService,
DeviceManagerListener {
    private static DriverAssistanceViewOptionsServiceImpl instance;
    private DSICarDriverAssistance dsiDriverAssist;
    private DSICarDriverAssistanceListener dsiDriverAssistListener;
    private ObjectArrayList listeners = new ObjectArrayList();
    public static final int ATTR_ACCVIEWOPTIONS;
    public static final int ATTR_AWVVIEWOPTIONS;
    public static final int ATTR_LDWHCAVIEWOPTIONS;
    public static final int ATTR_MKEVIEWOPTIONS;
    public static final int ATTR_PAVIEWOPTIONS;
    public static final int ATTR_SWAVIEWOPTIONS;
    public static final int ATTR_TSDVIEWOPTIONS;
    public static final int ATTR_NVVIEWOPTIONS;
    public static final int ATTR_FTAVIEWOPTIONS;
    private ACCViewOptionsWrapper accVOWrapper;
    private SWAViewOptionsWrapper swaVOWrapper;
    private AWVViewOptionsWrapper awvVOWrapper;
    private LdwhcaViewOptionWrapper ldwhcaVOWrapper;
    private MKEViewOptionsWrapper mkeVOWrapper;
    private PAViewOptionsWrapper paVOWrapper;
    private TSDViewOptionsWrapper tsdVOWrapper;
    private NVViewOptionsWrapper nvVOWrapper;
    private int accDeviceReason;
    private int awvDeviceReason;
    private int swaDeviceReason;
    private int ldwhcaDeviceReason;
    private int mkeDeviceReason;
    private int paDeviceReason;
    private int tsdDeviceReason;
    private int nvDeviceReason;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;

    private DriverAssistanceViewOptionsServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    private void initDSI() {
        this.dsiDriverAssist = (DSICarDriverAssistance)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = DriverAssistanceViewOptionsServiceImpl.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance);
        this.dsiDriverAssistListener = (DSICarDriverAssistanceListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = DriverAssistanceViewOptionsServiceImpl.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener);
    }

    public void registerViewOption(int n) {
        this.dsiDriverAssist.setNotification(n, (DSIListener)this.dsiDriverAssistListener);
    }

    public static DriverAssistanceViewOptionsServiceImpl getInstance() {
        if (instance == null) {
            instance = new DriverAssistanceViewOptionsServiceImpl();
        }
        return instance;
    }

    public void dsiCarDriverAssistanceUpdateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger().info(1, new StringBuffer().append("dsiCarDriverAssistanceUpdateACCViewOptions 1, accReason=").append(this.accDeviceReason).toString());
        int n2 = 0;
        ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms = aCCViewOptions.getConfiguration().getDrivingPrograms();
        if (aCCAvailableDrivingPrograms.isEco()) {
            ++n2;
        }
        if (aCCAvailableDrivingPrograms.isComfort()) {
            ++n2;
        }
        if (aCCAvailableDrivingPrograms.isDynamic()) {
            ++n2;
        }
        if (aCCAvailableDrivingPrograms.isStandard()) {
            ++n2;
        }
        if (!(aCCViewOptions.getConfiguration().getDrivingPrograms().isEco() || aCCViewOptions.getConfiguration().getDrivingPrograms().isComfort() || aCCViewOptions.getConfiguration().getDrivingPrograms().isDynamic())) {
            n2 = 3;
        }
        if (n2 < 2) {
            aCCViewOptions.drivingProgram = new CarViewOption(0, 0);
        }
        if (!StateWork.isNavi) {
            aCCViewOptions.curveAssist = new CarViewOption(0, 0);
        }
        this.accVOWrapper = new ACCViewOptionsWrapper(aCCViewOptions);
        if (this.accDeviceReason == 0) {
            this.notifyACCListeners(0);
        }
    }

    private void notifyACCListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.accVOWrapper == null) {
                driverAssistanceViewOptionListener.updateACCDevice(n);
                if (this.accDeviceReason != 14) continue;
                this.accDeviceReason = 0;
                continue;
            }
            if (this.accDeviceReason == 14) {
                this.accDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateACCViewOptions(this.accVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        this.swaVOWrapper = new SWAViewOptionsWrapper(sWAViewOptions);
        switch (sWAViewOptions.getConfiguration().system) {
            case 1: {
                this.swaVOWrapper.setSwaSystem(new CarViewOption(0, 0));
                this.swaVOWrapper.setBrightness(new CarViewOption(0, 0));
                this.swaVOWrapper.setBsdSystem(sWAViewOptions.getSystem());
                this.swaVOWrapper.setGongState(sWAViewOptions.getGongState());
                break;
            }
            case 0: {
                this.swaVOWrapper.setSwaSystem(sWAViewOptions.getSystem());
                this.swaVOWrapper.setBrightness(sWAViewOptions.getBrightness());
                this.swaVOWrapper.setBsdSystem(new CarViewOption(0, 0));
                this.swaVOWrapper.setGongState(new CarViewOption(0, 0));
                break;
            }
        }
        if (this.swaDeviceReason == 0) {
            this.notifySWAListeners(0);
        }
    }

    private void notifySWAListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.swaVOWrapper == null) {
                driverAssistanceViewOptionListener.updateSWADevice(n);
                if (this.swaDeviceReason != 14) continue;
                this.swaDeviceReason = 0;
                continue;
            }
            if (this.swaDeviceReason == 14) {
                this.swaDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateSWAViewOptions(this.swaVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        this.awvVOWrapper = new AWVViewOptionsWrapper(aWVViewOptions);
        switch (aWVViewOptions.getConfiguration().getSystemMode()) {
            case 1: {
                this.awvVOWrapper.setAwvSystem(aWVViewOptions.getSystem());
                this.awvVOWrapper.setCityBrakeSystem(new CarViewOption(0, 0));
                break;
            }
            case 2: {
                this.awvVOWrapper.setAwvSystem(new CarViewOption(0, 0));
                this.awvVOWrapper.setCityBrakeSystem(aWVViewOptions.getSystem());
                break;
            }
        }
        if (this.awvDeviceReason == 0) {
            this.notifyAWVListeners(0);
        }
    }

    private void notifyAWVListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.awvVOWrapper == null) {
                driverAssistanceViewOptionListener.updateAWVDevice(n);
                if (this.awvDeviceReason != 14) continue;
                this.awvDeviceReason = 0;
                continue;
            }
            if (this.awvDeviceReason == 14) {
                this.awvDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateAWVViewOptions(this.awvVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        this.ldwhcaVOWrapper = new LdwhcaViewOptionWrapper(lDWHCAViewOptions);
        if (this.ldwhcaDeviceReason == 0) {
            this.notifyLDWHCAListeners(0);
        }
    }

    private void notifyLDWHCAListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.ldwhcaVOWrapper == null) {
                driverAssistanceViewOptionListener.updateLDWHCADevice(n);
                if (this.ldwhcaDeviceReason != 14) continue;
                this.ldwhcaDeviceReason = 0;
                continue;
            }
            if (this.ldwhcaDeviceReason == 14) {
                this.ldwhcaDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateLDWHCAViewOptions(this.ldwhcaVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        this.tsdVOWrapper = new TSDViewOptionsWrapper(tSDViewOptions);
        if (this.tsdDeviceReason == 0) {
            this.notifyTSDListeners(0);
        }
    }

    private void notifyTSDListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.tsdVOWrapper == null) {
                driverAssistanceViewOptionListener.updateTSDDevice(n);
                if (this.tsdDeviceReason != 14) continue;
                this.tsdDeviceReason = 0;
                continue;
            }
            if (this.tsdDeviceReason == 14) {
                this.tsdDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateTSDViewOptions(this.tsdVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        this.nvVOWrapper = new NVViewOptionsWrapper(nVViewOptions);
        if (this.nvDeviceReason == 0) {
            this.notifyNVListeners(0);
        }
    }

    private void notifyNVListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.nvVOWrapper == null) {
                driverAssistanceViewOptionListener.updateNVDevice(n);
                if (this.nvDeviceReason != 14) continue;
                this.nvDeviceReason = 0;
                continue;
            }
            if (this.nvDeviceReason == 14) {
                this.nvDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateNVViewOptions(this.nvVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        this.mkeVOWrapper = new MKEViewOptionsWrapper(mKEViewOptions);
        if (this.mkeDeviceReason == 0) {
            this.notifyMKEListeners(0);
        }
    }

    private void notifyMKEListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.mkeVOWrapper == null) {
                driverAssistanceViewOptionListener.updateMKEDevice(n);
                if (this.mkeDeviceReason != 14) continue;
                this.mkeDeviceReason = 0;
                continue;
            }
            if (this.mkeDeviceReason == 14) {
                this.mkeDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updateMKEViewOptions(this.mkeVOWrapper, n);
        }
    }

    public void dsiCarDriverAssistanceUpdatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        this.paVOWrapper = new PAViewOptionsWrapper(pAViewOptions);
        if (this.paDeviceReason == 0) {
            this.notifyPAListeners(0);
        }
    }

    private void notifyPAListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DriverAssistanceViewOptionListener driverAssistanceViewOptionListener = (DriverAssistanceViewOptionListener)iterator.next();
            if (this.paVOWrapper == null) {
                driverAssistanceViewOptionListener.updatePADevice(n);
                if (this.paDeviceReason != 14) continue;
                this.paDeviceReason = 0;
                continue;
            }
            if (this.paDeviceReason == 14) {
                this.paDeviceReason = 0;
                return;
            }
            driverAssistanceViewOptionListener.updatePAViewOptions(this.paVOWrapper, n);
        }
    }

    @Override
    public void addListener(DriverAssistanceViewOptionListener driverAssistanceViewOptionListener) {
        if (!(driverAssistanceViewOptionListener instanceof DriverAssistanceViewOptionAdapter)) {
            throw new IllegalArgumentException();
        }
        this.listeners.add(driverAssistanceViewOptionListener);
    }

    @Override
    public void removeListener(DriverAssistanceViewOptionListener driverAssistanceViewOptionListener) {
        this.listeners.removeValue(driverAssistanceViewOptionListener);
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 190: {
                this.accDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyACCListeners(n2);
                    break;
                }
                this.notifyACCListeners(0);
                break;
            }
            case 205: {
                this.awvDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyAWVListeners(n2);
                    break;
                }
                this.notifyAWVListeners(0);
                break;
            }
            case 215: {
                this.swaDeviceReason = n2;
                if (n2 != 0) {
                    this.notifySWAListeners(n2);
                    break;
                }
                this.notifySWAListeners(0);
                break;
            }
            case 210: {
                this.ldwhcaDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyLDWHCAListeners(n2);
                    break;
                }
                this.notifyLDWHCAListeners(0);
                break;
            }
            case 425: {
                this.paDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyPAListeners(n2);
                    break;
                }
                this.notifyPAListeners(0);
                break;
            }
            case 365: {
                this.mkeDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyMKEListeners(n2);
                    break;
                }
                this.notifyMKEListeners(0);
                break;
            }
            case 340: {
                this.tsdDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyTSDListeners(n2);
                    break;
                }
                this.notifyTSDListeners(0);
                break;
            }
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
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

