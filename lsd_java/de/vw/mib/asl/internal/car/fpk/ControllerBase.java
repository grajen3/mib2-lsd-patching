/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;

public abstract class ControllerBase
extends AbstractTarget {
    protected final DSICarKombi dsiCarKombi = (DSICarKombi)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = ControllerBase.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
    protected final DSICarKombiListener dsiCarKombiListener = (DSICarKombiListener)DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ControllerBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
    private int targetId;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    public ControllerBase() {
        this(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents());
    }

    public ControllerBase(GenericEvents genericEvents) {
        super.setEventContext(genericEvents);
        super.getEventDispatcher().registerTarget(this);
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
                AppLogger.warn(this, new StringBuffer().append(".onModelEvent( event = ").append(eventGeneric.toString()).append(" ) unhandle event").toString());
            }
        }
    }

    protected void onUpdate(int n) {
    }

    protected void listenOnEvents(int[] nArray) {
        this.addObservers(nArray);
    }

    protected void listenOnDSIUpdates(int[] nArray) {
        this.dsiCarKombi.setNotification(nArray, (DSIListener)this.dsiCarKombiListener);
    }

    protected void listenOnDSIResponses(Target target) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        dSIProxy.addResponseListener(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ControllerBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener, dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(target, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = ControllerBase.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener));
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

