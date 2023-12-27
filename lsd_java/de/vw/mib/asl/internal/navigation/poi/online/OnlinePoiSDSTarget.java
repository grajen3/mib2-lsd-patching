/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.poi.IPoiOnlineSearchResultListener;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.poi.online.AbstractOnlinePoiTarget;
import de.vw.mib.asl.internal.navigation.poi.online.OnlinePoiEvents;
import de.vw.mib.asl.internal.navigation.poi.onlineservices.transformer.ResultListCollector;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.Iterator;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlinePoiSDSTarget
extends AbstractOnlinePoiTarget {
    private static final INavigationDP NAVIGATION_DP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private static boolean registered;
    static WeakIdentityHashSet listeners;
    private IOnlinePoiListElement selectedEntry;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearchListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public static boolean isOnlinePoiReady() {
        return registered;
    }

    public OnlinePoiSDSTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    public static void registerPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
        listeners.add(iPoiOnlineSearchResultListener);
    }

    public static void unregisterPoiOnlineSearchResultListener(IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener) {
        listeners.remove(iPoiOnlineSearchResultListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101003: {
                if (!this.isTraceEnabled()) break;
                this.trace("OnlinePoiSDSTarget: NAVI_TARGET_PREPARE_ON");
                break;
            }
            case 101001: {
                if (this.isTraceEnabled()) {
                    this.trace("OnlinePoiSDSTarget: NAVI_TARGET_GO_ON");
                }
                this.registerDSIServiceStateListener();
                break;
            }
            case 101002: {
                if (!this.isTraceEnabled()) break;
                this.trace("OnlinePoiSDSTarget: NAVI_TARGET_PREPARE_OFF");
                break;
            }
            case 101000: {
                if (!this.isTraceEnabled()) break;
                this.trace("OnlinePoiSDSTarget: NAVI_TARGET_GO_OFF");
                break;
            }
            case 3492001: {
                if (this.isTraceEnabled()) {
                    this.trace("OnlinePoiSDSTarget: START_ONLINE_POI_VOICE_SEARCH");
                }
                this.caseStartVoiceSearch();
                break;
            }
            case 3492003: {
                if (this.isTraceEnabled()) {
                    this.trace("OnlinePoiSDSTarget entered SEARCH_STOP");
                }
                this.caseCancelSearch();
                break;
            }
            case 3492002: {
                if (this.isTraceEnabled()) {
                    this.trace("OnlinePoiSDSTarget entered REQUEST_NEXT_PAGE");
                }
                this.caseGetValueListBlock(eventGeneric);
                break;
            }
            case 3492004: {
                if (this.isTraceEnabled()) {
                    this.trace("OnlinePoiSDSTarget entered RESULT_SELECT_DETAILS");
                }
                this.caseResultSelectPoiDetails(eventGeneric);
                break;
            }
            default: {
                this.trace("OnlinePoiSDSTarget: Default event with id: ", eventGeneric.getReceiverEventId());
            }
        }
    }

    private void caseStartVoiceSearch() {
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        if (posPosition != null) {
            this.referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition);
            this.dsiPoiOnlineSearch.poiVoiceSearchActive();
            this.dsiPoiOnlineSearch.poiStartVoiceSelection(posPosition.getLongitude(), posPosition.getLatitude(), 500, 0, true, 10);
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("OnlinePoiSDSTarget.caseStartVoiceSearch: CCP location is not available.");
        }
    }

    private void caseGetValueListBlock(EventGeneric eventGeneric) {
        if (this.referenceLocation != null) {
            int n = eventGeneric.getInt(0);
            this.dsiPoiOnlineSearch.poiRequestValueList(n, 10);
        }
    }

    private void caseResultSelectPoiDetails(EventGeneric eventGeneric) {
        this.selectedEntry = (IOnlinePoiListElement)eventGeneric.getObject(0);
        this.calculateNavLocationForSelectedPoi(this.selectedEntry);
    }

    private void handlePoiResult(int n, int n2) {
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener = (IPoiOnlineSearchResultListener)iterator.next();
            try {
                iPoiOnlineSearchResultListener.onlinePoiSearchResult(n, n2);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    private IOnlinePoiListElement[] createResultList(PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n) {
        IOnlinePoiListElement[] iOnlinePoiListElementArray = new ResultListCollector[poiOnlineSearchValuelist.getList().length];
        for (int i2 = 0; i2 < iOnlinePoiListElementArray.length; ++i2) {
            PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = poiOnlineSearchValuelist.getList()[i2];
            int n2 = this.calculateDistanceToLocation(poiOnlineSearchValuelistElement);
            int n3 = this.calculateDirectionArrowToLocation(poiOnlineSearchValuelistElement);
            if (this.isTraceEnabled() && !StringUtil.isEmpty(poiOnlineSearchValuelistElement.getImageUrl())) {
                this.trace("OnlinePoiSDSTarget: Requesting brand icon url: ", poiOnlineSearchValuelistElement.getImageUrl());
            }
            String string = ASLOnlineFactory.getOnlineCoreServices().getServiceIDWithNumericServiceID(4);
            ResultListCollector resultListCollector = new ResultListCollector(poiOnlineSearchValuelistElement, i2 + n, n3, n2, true, string);
            iOnlinePoiListElementArray[i2] = resultListCollector;
        }
        return iOnlinePoiListElementArray;
    }

    private void calculateNavLocationForSelectedPoi(Object object) {
        if (object != null) {
            int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(((IOnlinePoiListElement)object).getLatitudeDouble());
            int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(((IOnlinePoiListElement)object).getLongitudeDouble());
            new CmdGetLocationDescriptionTransform(this, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation()).execute();
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNaviContext("OnlinePoiTarget.calculateNavLocationForSelectedPoi: No list item available for the selected index!");
        }
    }

    private void registerDSIPoiOnlineSearch() {
        this.dsiPoiOnlineSearch = (DSIPoiOnlineSearch)this.proxy.getService(this, class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiSDSTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch);
        this.dsiPoiOnlineSearchListener = this.proxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = OnlinePoiSDSTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener);
        this.proxy.addResponseListener(this, class$org$dsi$ifc$online$DSIPoiOnlineSearchListener == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearchListener = OnlinePoiSDSTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearchListener")) : class$org$dsi$ifc$online$DSIPoiOnlineSearchListener, this.dsiPoiOnlineSearchListener);
    }

    @Override
    public void dsiPoiOnlineSearchPoiResult(int n, int n2, int n3) {
        if (this.isTraceEnabled()) {
            this.trace("OnlinePoiSDSTarget: poiResult() with returnCode: ", n3);
        }
        switch (n3) {
            case 10: {
                if (n2 == 1) {
                    this.dsiPoiOnlineSearch.poiRawVoiceDataAvailable("/tmp/speech-online.pcm", 2);
                }
                this.handlePoiResult(n2, n3);
                break;
            }
            default: {
                this.handlePoiResult(n2, n3);
            }
        }
    }

    @Override
    public void dsiPoiOnlineSearchPoiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        Iterator iterator = listeners.iterator();
        IOnlinePoiListElement[] iOnlinePoiListElementArray = this.createResultList(poiOnlineSearchValuelist, n3);
        while (iterator.hasNext()) {
            IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener = (IPoiOnlineSearchResultListener)iterator.next();
            try {
                iPoiOnlineSearchResultListener.valueListBlock(iOnlinePoiListElementArray, n4);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void dsiPoiOnlineSearchAsyncException(int n, String string, int n2) {
        this.handlePoiResult(n2, n);
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
        iLocationWrapper.setMmiInternalDataValue(3, this.selectedEntry != null ? this.selectedEntry.getPoiName() : "");
        iLocationWrapper.setMmiInternalDataValue(4, this.selectedEntry != null ? this.selectedEntry.getPhone() : "");
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IPoiOnlineSearchResultListener iPoiOnlineSearchResultListener = (IPoiOnlineSearchResultListener)iterator.next();
            try {
                iPoiOnlineSearchResultListener.resolveEntryResult(iLocationWrapper.getLocation());
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OnlinePoiSDSTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) && this.dsiNavigation == null) {
            this.registerDSINavigation();
        } else if (string.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiSDSTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName()) && this.dsiPoiOnlineSearch == null) {
            this.registerDSIPoiOnlineSearch();
        }
        if (this.dsiNavigation != null && this.dsiPoiOnlineSearch != null && !registered) {
            if (this.isTraceEnabled()) {
                this.trace("AbstractOnlinePoiTarget: Registering observers for ASL/Model events");
            }
            OnlinePoiEvents.addObservers(this);
            registered = true;
        }
    }

    @Override
    public void unregistered(String string, int n) {
        try {
            if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = OnlinePoiSDSTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
                this.unregisterDSINavigation();
            } else if (string.equals((class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = OnlinePoiSDSTarget.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName())) {
                this.unregisterDSIPoiOnlineSearch();
            }
            if ((this.dsiNavigation == null || this.dsiPoiOnlineSearch == null) && registered) {
                if (this.isTraceEnabled()) {
                    this.trace("AbstractOnlinePoiTarget: Unregistering observers for ASL/Model events");
                }
                OnlinePoiEvents.removeObservers(this);
                registered = false;
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    protected int calculateDirectionArrowToLocation(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement) {
        if (poiOnlineSearchValuelistElement == null) {
            this.error("calculateDirectionArrowToLocation(): element was null");
            return 0;
        }
        if (this.referenceLocation == null) {
            this.error("calculateDirectionArrowToLocation(): referenceLocation was null");
            return 0;
        }
        int n = 0;
        if (NAVIGATION_DP.getPoiSearchArea() == 1) {
            n = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getDirectionAngle();
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndex(this.referenceLocation.getLongitude(), this.referenceLocation.getLatitude(), poiOnlineSearchValuelistElement.getLongitude(), poiOnlineSearchValuelistElement.getLatitude(), n);
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
        listeners = new WeakIdentityHashSet();
    }
}

