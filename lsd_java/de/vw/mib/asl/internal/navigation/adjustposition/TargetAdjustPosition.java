/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.adjustposition;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;

public class TargetAdjustPosition
extends AbstractResettableTarget
implements DSIServiceStateListener {
    private boolean reroutingSuccessful = false;
    protected DSINavigation dsiNavigation;
    protected DSIListener navigationListener;
    private boolean wasServiceStateListenerRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public boolean isReroutingSuccessful() {
        return this.reroutingSuccessful;
    }

    public TargetAdjustPosition(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    protected void registerObservers() {
        if (!this.wasServiceStateListenerRegistered) {
            ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            this.wasServiceStateListenerRegistered = true;
        }
        this.addObserver(-855048128);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerObservers();
                break;
            }
            case 1073744333: {
                try {
                    this.dsiNavigation.rgSwitchToNextPossibleRoad();
                }
                catch (Exception exception) {
                    ServiceManager.logger.error(this.getSubClassifier(), "Error while adjusting current car position");
                }
                break;
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public void dsiNavigationRgSwitchToNextPossibleRoadResult(boolean bl) {
        ServiceManager.logger.info(this.getSubClassifier()).append("TargetAdjustPosition.dsiNavigationRgSwitchToNextPossibleRoadResult(").append(bl).append(")").log();
        ServiceManager.aslPropertyManager.valueChangedBoolean(3511, bl);
        ServiceManager.aslPropertyManager.valueChangedInteger(3019, 0);
        this.reroutingSuccessful = bl;
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern() && !this.isFirstStartupDone) {
            this.isFirstStartupDone = true;
            this.initDsiNavigation();
        }
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (this.isTraceEnabled()) {
                this.trace().append("TargetAdjustPosition tries to unregister from ").append(string).append("...").log();
            }
            try {
                DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                if (dSIProxy == null) {
                    this.trace().append("DSIProxy was null!");
                    return;
                }
                if (this.navigationListener != null) {
                    dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
                }
                if (this.isTraceEnabled()) {
                    this.trace().append("TargetAdjustPosition unregistered from ").append(string).log();
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleDsiError(exception);
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetAdjustPosition.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetAdjustPosition: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetAdjustPosition: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.reroutingSuccessful = false;
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

