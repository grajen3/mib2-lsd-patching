/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.kombi.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.HUDViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionListener;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionService;
import de.vw.mib.asl.api.car.vo.kombi.SIAViewOptionsData;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.kombi.impl.BCViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.kombi.impl.HUDViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.kombi.impl.SIAViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.SIAViewOptions;

public final class KombiViewOptionServiceImpl
extends CarEmptyTarget
implements KombiViewOptionService,
DeviceManagerListener {
    public static final int SIAVIEWOPTIONS;
    public static final int HUDVIEWOPTIONS;
    public static final int BCVIEWOPTIONS;
    private static KombiViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarKombi dsiCarTarget;
    private DSICarKombiListener dsiCarListener;
    private HUDViewOptionsData hudData;
    private BCViewOptionsData bcData;
    private SIAViewOptionsData siaData;
    private int deviceReasonHUD;
    private int deviceReasonBC;
    private int deviceReasonSIA;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    private KombiViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static KombiViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new KombiViewOptionServiceImpl();
        }
        return instance;
    }

    private void initDSI() {
        this.dsiCarTarget = (DSICarKombi)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = KombiViewOptionServiceImpl.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarListener = (DSICarKombiListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = KombiViewOptionServiceImpl.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarTarget.setNotification(n, (DSIListener)this.dsiCarListener);
    }

    @Override
    public void addListener(KombiViewOptionListener kombiViewOptionListener) {
        this.listeners.add(kombiViewOptionListener);
    }

    @Override
    public void removeListener(KombiViewOptionListener kombiViewOptionListener) {
        this.listeners.removeValue(kombiViewOptionListener);
    }

    public void dsiCarKombiUpdateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        this.hudData = new HUDViewOptionsWrapper(hUDViewOptions);
        if (this.deviceReasonHUD == 0) {
            this.notifyHUDListeners(0);
        }
    }

    public void dsiCarKombiUpdateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        this.siaData = new SIAViewOptionsWrapper(sIAViewOptions);
        if (this.deviceReasonSIA == 0) {
            this.notifySIAListeners(0);
        }
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        this.bcData = new BCViewOptionsWrapper(bCViewOptions);
        if (this.deviceReasonBC == 0) {
            this.notifyBCListeners(0);
        }
    }

    private void notifyHUDListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            KombiViewOptionListener kombiViewOptionListener = (KombiViewOptionListener)iterator.next();
            if (this.hudData == null) {
                kombiViewOptionListener.updateHUDDevice(n);
                if (this.deviceReasonHUD != 14) continue;
                this.deviceReasonHUD = 0;
                continue;
            }
            if (this.deviceReasonHUD == 14) {
                this.deviceReasonHUD = 0;
                return;
            }
            kombiViewOptionListener.updateHUDViewOptions(this.hudData, n);
        }
    }

    private void notifyBCListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            KombiViewOptionListener kombiViewOptionListener = (KombiViewOptionListener)iterator.next();
            if (this.bcData == null) {
                kombiViewOptionListener.updateBCDevice(n);
                if (this.deviceReasonBC != 14) continue;
                this.deviceReasonBC = 0;
                continue;
            }
            if (this.deviceReasonBC == 14) {
                this.deviceReasonBC = 0;
                return;
            }
            kombiViewOptionListener.updateBCViewOptions(this.bcData, n);
        }
    }

    private void notifySIAListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            KombiViewOptionListener kombiViewOptionListener = (KombiViewOptionListener)iterator.next();
            if (this.siaData == null) {
                kombiViewOptionListener.updateSIADevice(n);
                if (this.deviceReasonSIA != 14) continue;
                this.deviceReasonSIA = 0;
                continue;
            }
            if (this.deviceReasonSIA == 14) {
                this.deviceReasonSIA = 0;
                return;
            }
            kombiViewOptionListener.updateSIAViewOptions(this.siaData, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        if (n == 300) {
            this.deviceReasonHUD = n2;
            if (n2 != 0) {
                this.notifyHUDListeners(n2);
            } else {
                this.notifyHUDListeners(0);
            }
        }
        if (n == 240) {
            this.deviceReasonBC = n2;
            if (n2 != 0) {
                this.notifyBCListeners(n2);
            } else {
                this.notifyBCListeners(0);
            }
        }
        if (n == 255) {
            this.deviceReasonSIA = n2;
            if (n2 != 0) {
                this.notifySIAListeners(n2);
            } else {
                this.notifySIAListeners(0);
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

