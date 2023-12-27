/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public abstract class AbstractOnlinePoiTarget
extends AbstractNavGatewayTarget
implements DSIServiceStateListener {
    protected static final String POI_VOICE_SEARCH_FILE_PATH;
    protected static final int MAX_RESULTS_PER_LIST;
    protected static final int POI_ONLINE_SEARCH_RADIUS_KM;
    protected DSIPoiOnlineSearch dsiPoiOnlineSearch;
    protected DSIListener dsiPoiOnlineSearchListener;
    protected DSIProxy proxy;
    protected DSINavigation dsiNavigation;
    DSIListener dsiNavigationListener;
    boolean wasServiceStateListenerRegistered = false;
    protected ILocationWrapper referenceLocation;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearchListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;

    public AbstractOnlinePoiTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public abstract void gotEvent(EventGeneric eventGeneric) {
    }

    public abstract void dsiPoiOnlineSearchPoiResult(int n, int n2, int n3) {
    }

    public abstract void dsiPoiOnlineSearchPoiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
    }

    public abstract void dsiPoiOnlineSearchAsyncException(int n, String string, int n2) {
    }

    @Override
    public abstract void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    protected void unregisterDSIPoiOnlineSearch() {
        if (this.dsiPoiOnlineSearch == null) {
            return;
        }
        if (this.dsiPoiOnlineSearchListener != null) {
            this.proxy.removeResponseListener(this, class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = AbstractOnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener, this.dsiPoiOnlineSearchListener);
            this.dsiPoiOnlineSearchListener = null;
        }
        this.dsiPoiOnlineSearch = null;
    }

    protected void registerDSINavigation() {
        this.dsiNavigation = (DSINavigation)this.proxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractOnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractOnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        this.proxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractOnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
    }

    protected void unregisterDSINavigation() {
        if (this.dsiNavigation == null) {
            return;
        }
        if (this.dsiNavigationListener != null) {
            this.proxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = AbstractOnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
        }
    }

    protected void registerDSIServiceStateListener() {
        this.proxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (!this.wasServiceStateListenerRegistered) {
            this.proxy.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = AbstractOnlinePoiTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
            this.proxy.addServiceStateListener(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = AbstractOnlinePoiTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, this);
            this.wasServiceStateListenerRegistered = true;
        }
    }

    protected int calculateDistanceToLocation(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        if (poiOnlineSearchValuelistElement == null) {
            this.error("calculateDistanceToLocation(): element was null");
            return 0;
        }
        if (this.referenceLocation == null) {
            this.error("calculateDistanceToLocation(): referenceLocation was null");
            return 0;
        }
        ILocationWrapper iLocationWrapper = this.referenceLocation;
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(poiOnlineSearchValuelistElement.getLongitude(), poiOnlineSearchValuelistElement.getLatitude(), iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude());
    }

    protected void caseCancelSearch() {
        this.dsiPoiOnlineSearch.poiStopSelection();
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

