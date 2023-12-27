/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.diagnosis.config.CarFuncAdap;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.fpk.ServiceBase$1;
import de.vw.mib.asl.internal.car.fpk.api.CarFPKSetupAPI;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceState;
import de.vw.mib.asl.internal.car.fpk.usecases.ServiceStateListener;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.DCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.global.CarViewOption;

public abstract class ServiceBase
extends AbstractTarget
implements ServiceState {
    private static final String HSM_TASK_ID;
    protected final DSICarKombi dsiCarKombi;
    protected final DSICarKombiListener dsiCarKombiListener;
    private int targetId;
    private CarFPKSetupAPI carFPKSetupAPI;
    private DCViewOptions viewOptions;
    AdaptionResponse funcAdapResponse = new ServiceBase$1(this);
    private boolean codingDCavailable = false;
    private final CowArray serviceStateListeners = new CowArray();
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    public ServiceBase(CarFPKSetupAPI carFPKSetupAPI) {
        this.carFPKSetupAPI = carFPKSetupAPI;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarKombi = (DSICarKombi)dSIProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCarKombiListener = (DSICarKombiListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        this.listenOnDSIUpdates(new int[]{82});
        ServiceManager.adaptionApi.requestCarFuncAdap(this.funcAdapResponse);
        this.registerTarget();
    }

    private void registerTarget() {
        GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
        int n = genericEvents.getEventDispatcher().getNextTargetId();
        this.register(genericEvents, n, "hsmtask");
    }

    @Override
    public int getDefaultTargetId() {
        return this.targetId;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 8: {
                this.targetId = eventGeneric.getReceiverTargetId();
                break;
            }
            default: {
                AppLogger.warn(this, new StringBuffer().append(".gotEvent( event = ").append(eventGeneric.toString()).append(" ) unhandle event").toString());
            }
        }
    }

    public CarFPKSetupAPI getCarFPKSetupAPI() {
        return this.carFPKSetupAPI;
    }

    public void dsiCarKombiUpdateDCViewOptions(DCViewOptions dCViewOptions, int n) {
        AppLogger.trace(this, new StringBuffer().append(".dsiCarKombiUpdateDCViewOptions( viewOptions = ").append(dCViewOptions).append(", validFlag = ").append(n).append(" )").toString());
        this.updateServiceState(dCViewOptions);
    }

    @Override
    public DCViewOptions getServiceViewOptions() {
        return this.viewOptions;
    }

    @Override
    public boolean isServiceAvailable(CarViewOption carViewOption) {
        if (carViewOption == null) {
            return false;
        }
        boolean bl = carViewOption.getState() == 2;
        boolean bl2 = carViewOption.getReason() == 0;
        return bl && bl2 && this.codingDCavailable;
    }

    public AdaptionResponse getCarFuncAdapResponse() {
        return this.funcAdapResponse;
    }

    @Override
    public boolean isServiceAvailable() {
        if (this.viewOptions == null) {
            return false;
        }
        return this.isServiceAvailable(this.viewOptions.getDisplay1Setup()) && this.isServiceAvailable(this.viewOptions.getDisplay2Setup()) && this.isServiceAvailable(this.viewOptions.getElementContentSelectionList());
    }

    @Override
    public void subscribeServiceState(ServiceStateListener serviceStateListener) {
        this.serviceStateListeners.addIfNotAlreadyIn(serviceStateListener);
        serviceStateListener.updateServiceState(this);
    }

    @Override
    public void unsubscribeServiceState(ServiceStateListener serviceStateListener) {
        this.serviceStateListeners.remove(serviceStateListener);
    }

    protected void updateServiceState(DCViewOptions dCViewOptions) {
        if (this.viewOptions != dCViewOptions) {
            this.viewOptions = dCViewOptions;
            Object[] objectArray = this.serviceStateListeners.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ((ServiceStateListener)objectArray[i2]).updateServiceState(this);
            }
        }
    }

    protected void listenOnDSIUpdates(int[] nArray) {
        this.dsiCarKombi.setNotification(nArray, (DSIListener)this.dsiCarKombiListener);
    }

    protected void listenOnDSIResponses(Target target) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addResponseListener(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener, dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener));
    }

    protected void unlistenOnDSIUpdates(int[] nArray) {
        this.dsiCarKombi.clearNotification(nArray, (DSIListener)this.dsiCarKombiListener);
    }

    protected void unlistenOnDSIResponses(Target target) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.removeResponseListener(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener, dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ServiceBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener));
    }

    protected void listenOnModelEvents(int[] nArray) {
        this.addObservers(nArray);
    }

    protected void unlistenOnModelEvents(int[] nArray) {
        this.removeObservers(nArray);
    }

    protected ASLPropertyManager getAslPropertyManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLPropertyManager();
    }

    protected ASLListManager getAslListManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLListManager();
    }

    protected void onSuccess_funcAdap(Access access) {
        CarFuncAdap carFuncAdap = (CarFuncAdap)access;
        boolean bl = carFuncAdap.getBoolean(1202);
        if (bl != this.codingDCavailable) {
            this.codingDCavailable = bl;
            Object[] objectArray = this.serviceStateListeners.getArray();
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ((ServiceStateListener)objectArray[i2]).updateServiceState(this);
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

