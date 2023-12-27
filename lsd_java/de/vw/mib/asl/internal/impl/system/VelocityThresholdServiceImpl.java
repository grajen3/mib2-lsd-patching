/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.api.system.VelocityThresholdListener;
import de.vw.mib.asl.api.system.VelocityThresholdService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl$1;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl$2;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl$3;
import de.vw.mib.asl.internal.system.util.AsyncServiceListeners;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public final class VelocityThresholdServiceImpl
implements VelocityThresholdService {
    private final DSIProxy dsiProxy;
    private final Logger logger;
    private final AsyncServiceListeners listeners;
    private boolean isThresholdExceeded;
    private VehicleStatesListenerAdapter dsiListener;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;

    public VelocityThresholdServiceImpl(DSIProxy dSIProxy, AsyncServiceFactory asyncServiceFactory, Logger logger) {
        this.dsiProxy = dSIProxy;
        this.logger = logger;
        VelocityThresholdServiceImpl.checkArgumenNotNull(dSIProxy, "dsiProxy");
        VelocityThresholdServiceImpl.checkArgumenNotNull(asyncServiceFactory, "serviceFactory");
        VelocityThresholdServiceImpl.checkArgumenNotNull(logger, "log");
        this.listeners = new AsyncServiceListeners(asyncServiceFactory, logger);
        this.connectToDsi();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = VelocityThresholdServiceImpl.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this.createDsiServiceStateAdapter());
    }

    @Override
    public void addListener(VelocityThresholdListener velocityThresholdListener) {
        this.listeners.addListener(velocityThresholdListener);
    }

    @Override
    public void removeListener(VelocityThresholdListener velocityThresholdListener) {
        this.listeners.removeListener(velocityThresholdListener);
    }

    @Override
    public boolean isThresholdExceeded() {
        return this.isThresholdExceeded;
    }

    void setThreadholdExceeded(boolean bl) {
        this.isThresholdExceeded = bl;
    }

    void fireVelocityExceedanceChanged(boolean bl) {
        this.listeners.notifyListeners(new VelocityThresholdServiceImpl$1(this, bl));
    }

    void connectToDsi() {
        try {
            if (this.dsiListener == null) {
                this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)this.dsiProxy.getService(null, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = VelocityThresholdServiceImpl.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                this.dsiListener = this.createDsiListener();
            }
            this.dsiGeneralVehicleStates.setNotification(19, (DSIListener)this.dsiListener);
        }
        catch (Throwable throwable) {
            this.logger.info(2048, "Could not connect to DSIGeneralVehicleStates");
        }
    }

    private DSIServiceStateListenerAdapter createDsiServiceStateAdapter() {
        return new VelocityThresholdServiceImpl$2(this);
    }

    private VehicleStatesListenerAdapter createDsiListener() {
        return new VelocityThresholdServiceImpl$3(this);
    }

    private static void checkArgumenNotNull(Object object, String string) {
        if (object == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Argument >").append(string).append("< must not be null!").toString());
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

