/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navtraffictiles;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavServiceStateListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmc;

public class NavTrafficTileSTarget
extends AbstractASLTarget
implements DSIServiceStateListener,
INavServiceStateListener {
    private static final int[] OBSERVER = new int[]{-2134743232};
    private static final DSIProxy DSI_PROXY = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private static final int WINDOW_ID_ONE;
    private static final int WINDOW_SIZE;
    private static final int OFFSET;
    private static final int[] ANCHOR_ID;
    private DSITmc dsiTmc;
    private DSIListener dsiTmcListener;
    private boolean isServiceStateListenerAdded = false;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;

    public NavTrafficTileSTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        ASLNavigationFactory.getNavigationApi().registerNavServiceStateListener(this);
    }

    @Override
    public void registered(String string, int n) {
        String string2;
        if (this.isTraceEnabled()) {
            this.trace().append("Electronic Toll Collect Target tries to register").log();
        }
        if ((string2 = string.intern()) == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
            this.dsiTmc = (DSITmc)DSI_PROXY.getService(this, class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc);
            this.dsiTmcListener = DSI_PROXY.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener);
            DSI_PROXY.addResponseListener(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener, this.dsiTmcListener);
            this.dsiTmc.setNotification(this.dsiTmcListener);
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("ASLNavTrafficTileS tries to unregister from ").append(string).append("...").log();
        }
        try {
            if (DSI_PROXY == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            String string2 = string.intern();
            if (string2 == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
                this.unregisterDsiTmc(string, DSI_PROXY);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiTmc(String string, DSIProxy dSIProxy) {
        if (this.dsiTmcListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener, this.dsiTmcListener);
            if (this.dsiTmcListener != null) {
                this.dsiTmcListener = null;
            }
            if (this.isTraceEnabled()) {
                this.trace().append("ASLNavTrafficTileS unregistered from ").append(string).log();
            }
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (this.isTraceEnabled()) {
                    this.trace("ASLNavTrafficTileSTarget: POWER_ON");
                }
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = NavTrafficTileSTarget.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc, this);
                }
                this.addObservers(OBSERVER);
                this.init();
                break;
            }
            case 107: {
                if (!this.isTraceEnabled()) break;
                this.trace("ASLNavTrafficTileSTarget: POWER_OFF");
                break;
            }
            case 1080541824: {
                this.handlePollTMC();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace("EtcTarget: default event");
            }
        }
    }

    private void handlePollTMC() {
        if (this.isTraceEnabled()) {
            this.trace("ASLNavTrafficTileSTarget: PollTMC");
        }
        this.dsiTmc.requestTmcWindow(0, 0, 0, ANCHOR_ID, -3);
    }

    private void init() {
        ServiceManager.aslPropertyManager.valueChangedInteger(-1846974720, 0);
        ServiceManager.aslPropertyManager.valueChangedInteger(-1830197504, 0);
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1813420288, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1813420288, false);
        }
    }

    public void dsiTmcUpdateEventsOnRoute(long l, int n) {
        if (n == 1) {
            if (l >= 0L) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1830197504, (int)l);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1830197504, 0);
            }
        }
    }

    public void dsiTmcUpdateEventsTotal(int n, long l, long l2, int n2) {
        if (n2 == 1) {
            if (l >= 0L) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846974720, (int)l);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846974720, 0);
            }
        }
    }

    @Override
    public void navServiceStateChanged() {
        this.trace("NavService state changed");
        if (ASLNavigationFactory.getNavigationApi().getNavigationServiceState() == 100) {
            this.trace("Navigation state fully operable");
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1813420288, true);
        } else {
            this.trace("Navigation not operable");
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1813420288, false);
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

    static {
        ANCHOR_ID = new int[]{-1};
    }
}

