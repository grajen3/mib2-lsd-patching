/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio.main;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.asl.internal.webradio.WebRadioServiceManager;
import de.vw.mib.asl.internal.webradio.main.StateTopMain;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.connectedradio.DSIOnlineRadio;

public final class TargetMainWebRadio
extends AbstractASLHsmTarget
implements DSIServiceStateListener {
    final HsmState stateTopMain;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIOnlineRadio;
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener;

    public TargetMainWebRadio(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.hsm.verbose = false;
        WebRadioServiceManager.getServiceManager().setTargetMain(this);
        this.stateTopMain = new StateTopMain(this.hsm, "stateTopMain", this.getWorkStateParent());
        WebRadioServiceManager.getServiceManager().setStateTopMain(this.stateTopMain);
    }

    @Override
    public int getDefaultTargetId() {
        return -1553916928;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateTopMain;
    }

    @Override
    public void registered(String string, int n) {
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        super.gotEvent(eventGeneric);
    }

    public void registerObservers() {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("TargetMainWebRadio - registerObservers()").log();
        }
        WebRadioServiceManager.getServiceManager().setDsiOnlineRadio((DSIOnlineRadio)ServiceManager.dsiServiceLocator.getService(this, class$org$dsi$ifc$connectedradio$DSIOnlineRadio == null ? (class$org$dsi$ifc$connectedradio$DSIOnlineRadio = TargetMainWebRadio.class$("org.dsi.ifc.connectedradio.DSIOnlineRadio")) : class$org$dsi$ifc$connectedradio$DSIOnlineRadio));
        DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener == null ? (class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener = TargetMainWebRadio.class$("org.dsi.ifc.connectedradio.DSIOnlineRadioListener")) : class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener);
        ServiceManager.dsiServiceLocator.addResponseListener(this, class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener == null ? (class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener = TargetMainWebRadio.class$("org.dsi.ifc.connectedradio.DSIOnlineRadioListener")) : class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener, dSIListener);
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

