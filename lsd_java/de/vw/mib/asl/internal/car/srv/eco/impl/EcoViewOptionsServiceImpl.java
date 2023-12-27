/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.eco.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionListener;
import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionService;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.eco.impl.EAViewOptionsWrapper;
import de.vw.mib.asl.internal.car.srv.eco.impl.StartStopViewOptionsWrapper;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class EcoViewOptionsServiceImpl
extends AbstractTarget
implements EcoViewOptionService,
DeviceManagerListener {
    private static EcoViewOptionsServiceImpl instance;
    private DSICarEco dsiCarEco;
    private DSICarEcoListener dsiCarEcoListener;
    private ObjectArrayList listeners = new ObjectArrayList();
    public static final int ATTR_EAVIEWOPTIONS;
    public static final int ATTR_STARTSTOPVIEWOPTIONS;
    private EAViewOptionsWrapper eaVOWrapper;
    private StartStopViewOptionsWrapper startStopViewOptionsWrapper;
    private int eaDeviceReason;
    private int startStopDeviceReason;
    private final int[] reasons = new int[6];
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;

    private EcoViewOptionsServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    private void initDSI() {
        this.dsiCarEco = (DSICarEco)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = EcoViewOptionsServiceImpl.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        this.dsiCarEcoListener = (DSICarEcoListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = EcoViewOptionsServiceImpl.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
    }

    public void registerViewOption(int n) {
        this.dsiCarEco.setNotification(n, (DSIListener)this.dsiCarEcoListener);
    }

    public static EcoViewOptionsServiceImpl getInstance() {
        if (instance == null) {
            instance = new EcoViewOptionsServiceImpl();
        }
        return instance;
    }

    @Override
    public void addListener(EcoViewOptionListener ecoViewOptionListener) {
        this.listeners.add(ecoViewOptionListener);
    }

    @Override
    public void removeListener(EcoViewOptionListener ecoViewOptionListener) {
        this.listeners.removeValue(ecoViewOptionListener);
    }

    public void dsiCarEcoUpdateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        this.eaVOWrapper = new EAViewOptionsWrapper(eAViewOptions);
        if (this.eaDeviceReason == 0) {
            this.notifyEAListeners(0);
        }
    }

    private void notifyEAListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            EcoViewOptionListener ecoViewOptionListener = (EcoViewOptionListener)iterator.next();
            if (this.eaVOWrapper == null) {
                ecoViewOptionListener.updateEADevice(n);
                if (this.eaDeviceReason != 14) continue;
                this.eaDeviceReason = 0;
                continue;
            }
            if (this.eaDeviceReason == 14) {
                this.eaDeviceReason = 0;
                return;
            }
            ecoViewOptionListener.updateEAViewOptions(this.eaVOWrapper, n);
        }
    }

    public void dsiCarEcoUpdateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) {
        this.startStopViewOptionsWrapper = new StartStopViewOptionsWrapper(startStopViewOptions);
        int n2 = 0;
        int n3 = 0;
        if (startStopViewOptions.getStartStopProhibitReasonList().getState() == 0 || startStopViewOptions.getStartStopRestartProhibitReasonList().getState() == 0 || startStopViewOptions.getStartStopRestartReasonList().getState() == 0 || startStopViewOptions.getState().getState() == 0) {
            n2 = 0;
        } else {
            n2 = 1;
            if (startStopViewOptions.getStartStopProhibitReasonList().getState() == 2 && startStopViewOptions.getStartStopRestartProhibitReasonList().getState() == 2 && startStopViewOptions.getStartStopRestartReasonList().getState() == 2 && startStopViewOptions.getState().getState() == 2) {
                n2 = 2;
                n3 = 0;
            } else {
                if (startStopViewOptions.getStartStopProhibitReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopProhibitReasonList().getReason());
                }
                if (startStopViewOptions.getStartStopRestartProhibitReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopRestartProhibitReasonList().getReason());
                }
                if (startStopViewOptions.getStartStopRestartReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopRestartReasonList().getReason());
                }
                if (startStopViewOptions.getState().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getState().getReason());
                }
                n2 = 1;
                n3 = this.gettingHighestReason();
                this.clearReasons();
            }
        }
        this.startStopViewOptionsWrapper.setStartStop(new CarViewOption(n2, n3));
        if (this.startStopDeviceReason == 0) {
            this.notifyStartStopListeners(0);
        }
    }

    private void notifyStartStopListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            EcoViewOptionListener ecoViewOptionListener = (EcoViewOptionListener)iterator.next();
            if (this.startStopViewOptionsWrapper == null) {
                ecoViewOptionListener.updateStartStopDevice(n);
                if (this.startStopDeviceReason != 14) continue;
                this.startStopDeviceReason = 0;
                continue;
            }
            if (this.startStopDeviceReason == 14) {
                this.startStopDeviceReason = 0;
                return;
            }
            ecoViewOptionListener.updateStartStopViewOptions(this.startStopViewOptionsWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 465: {
                this.eaDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyEAListeners(n2);
                    break;
                }
                this.notifyEAListeners(0);
                break;
            }
            case 385: {
                this.startStopDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyStartStopListeners(n2);
                    break;
                }
                this.notifyStartStopListeners(0);
                break;
            }
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    private void collectingReason(int n) {
        switch (n) {
            case 2: {
                this.reasons[0] = 2;
                break;
            }
            case 3: {
                this.reasons[1] = 3;
                break;
            }
            case 4: {
                this.reasons[2] = 4;
                break;
            }
            case 8: {
                this.reasons[3] = 8;
                break;
            }
            case 1: {
                this.reasons[4] = 1;
                break;
            }
            default: {
                this.reasons[5] = 1;
            }
        }
    }

    private int gettingHighestReason() {
        int n = 0;
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            if (this.reasons[i2] == 0) continue;
            n = this.reasons[i2];
            break;
        }
        return n;
    }

    private void clearReasons() {
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            this.reasons[i2] = 0;
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

