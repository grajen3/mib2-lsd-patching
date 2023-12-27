/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.tourmode;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IOnlineTourImportListener;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslTarget;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.util.WeakIdentityHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.TourImportStatus;

public class TargetTourMemory
extends AbstractResettableAslTarget
implements DSIServiceStateListener {
    public static final int EV_SETUP_DELETE_LAST_TOUR;
    public static final int EV_IMPORT_TOURS_FROM_GPX;
    public static final int EV_ONLINE_IMPORT_MEM_FULL;
    public static final int EV_ONLINE_TOUR_IMPORT_AVAILABLE;
    public static final int EV_IMPORT_TOURS_FROM_GPX_PO_INT;
    public static final String ZERO_TOURS_PENDING;
    private static final int[] OBSERVER;
    private static final int RMID;
    private DSINavigation dsiNavigation;
    private NavRmRouteListData[] tourMemList = new NavRmRouteListData[0];
    private boolean isServiceStateListenerAdded = false;
    private DSIListener navigationListener;
    private boolean importRunning;
    private boolean isAborted = false;
    private boolean isMemoryFullAfterIndication = false;
    static WeakIdentityHashSet listeners;
    private Integer calculatedTourMemoryCapacity;
    private INavigationDP navigationDp = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    public TargetTourMemory(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                if (!this.isServiceStateListenerAdded) {
                    this.isServiceStateListenerAdded = true;
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                }
                this.addObservers(OBSERVER);
                break;
            }
            case 107: {
                this.removeObservers(OBSERVER);
                break;
            }
            case 100101: {
                this.handleImportToursFromGpxFile(eventGeneric);
                break;
            }
            case 1073742599: {
                this.handleStartTourFromTourMemList(eventGeneric);
                break;
            }
            case 1073742578: {
                this.handleDeleteTourFromTourMemList(eventGeneric);
                break;
            }
            case 1073742586: {
                this.handelLoadTourMemList();
                break;
            }
            case 1073742585: {
                this.handleLoadTourList(eventGeneric);
                break;
            }
            case 1074841943: {
                this.handleStartTourDownload();
                break;
            }
            case 1074841944: {
                this.handleAbortTourInstallAndDownload();
                break;
            }
            case 1110024: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetTourmMemory: NAVI_TOURMODE_ONLINE_IMPORT_FINISHED received");
                break;
            }
            case 100102: {
                this.handleOnlineImportMemFull();
                break;
            }
            case 1074841962: {
                this.handleOnlineImportCancel();
                break;
            }
            case 100103: {
                this.handleOnlineTourImportAvailable();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace("TargetTourMemory: default event");
            }
        }
    }

    protected void handleStartTourFromTourMemList(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourMemory: ASL_NAVIGATION_TOURMODE_START_TOUR_FROM_TOUR_MEM_LIST");
        }
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("Starting tour guidance for tour index: ").append(n).log();
        }
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-2075454464, -2092231680, 75956480);
        if (n < this.tourMemList.length) {
            eventGeneric2.setLong(0, this.tourMemList[n].getRouteId());
            this.send(eventGeneric2);
        } else {
            this.warn("selected TourMemList item with an invalid list index");
            this.quitModelWaitState();
        }
    }

    protected void handleDeleteTourFromTourMemList(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourMemory: ASL_NAVIGATION_TOURMODE_DELETE_TOUR_FROM_TOUR_MEM_LIST");
        }
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("Deleting tour with index: ").append(n).log();
        }
        this.dsiNavigation.rmRouteDelete(1, this.tourMemList[n].getRouteId());
    }

    protected void handelLoadTourMemList() {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourMemory: ASL_NAVIGATION_TOURMODE_LOAD_TOUR_MEM_LIST");
        }
        if (this.tourMemList == null) {
            ListManager.getGenericASLList(1000).updateList(new NavRouteListData[0]);
        }
        this.quitModelWaitState();
    }

    protected void handleLoadTourList(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("TargetTourMemory: ASL_NAVIGATION_TOURMODE_LOAD_TOUR_LIST");
        }
        int n = eventGeneric.getInt(0);
        if (this.isTraceEnabled()) {
            this.trace().append("Loading tour with index: ").append(n).log();
        }
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-2075454464, -2092231680, 75956480);
        if (n < this.tourMemList.length) {
            eventGeneric2.setLong(0, this.tourMemList[n].getRouteId());
            this.send(eventGeneric2);
        } else {
            this.warn("selected TourMemList item with an invalid list index");
            this.quitModelWaitState();
        }
    }

    protected void handleAbortTourInstallAndDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append("Abort importing tours: ");
        }
        this.isAborted = true;
        if (this.importRunning) {
            this.dsiNavigation.rmAbortImportToursFromGpxFile();
        } else {
            this.handleImportAbort();
        }
    }

    protected void handleStartTourDownload() {
        if (this.isTraceEnabled()) {
            this.trace().append(new StringBuffer().append("Start importing tours - toursAvailable = ").append(this.navigationDp.getOnlineToursAvailable()).append(", tourMemoryCapacity = ").append(this.calculatedTourMemoryCapacity).toString());
        }
        this.isAborted = false;
        if (this.navigationDp.getOnlineToursAvailable() > 0) {
            if ((this.calculatedTourMemoryCapacity == null ? this.getTourMemoryCapacity() : this.calculatedTourMemoryCapacity.intValue()) > 0) {
                AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 1);
                this.quitModelWaitState();
                this.handleImportStart();
            } else {
                AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 3);
                this.quitModelWaitState();
            }
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 2);
            this.quitModelWaitState();
        }
    }

    protected void handleImportToursFromGpxFile(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace("handleImportToursFromGpxFile()");
        }
        String string = eventGeneric.getString(0);
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("handleImportToursFromGpxFile() - FilePath = ").append(string).append(", numberOfToursPending = ").append(this.navigationDp.getOnlineToursAvailable()).append(", isAborted = ").append(this.isAborted).toString());
        }
        if ((string == null || string.length() == 0 || string.equals("ZERO_TOURS_PENDING")) && this.navigationDp.getOnlineToursAvailable() <= 0) {
            this.showNoToursPendingPopUp();
        } else if (string == null || string.length() == 0 || string.equals("ZERO_TOURS_PENDING")) {
            this.indicateErrorDuringDownload();
        } else {
            this.startImportFromGpxFile(string);
        }
    }

    protected void indicateErrorDuringDownload() {
        if (this.isTraceEnabled()) {
            this.trace("indicateErrorDuringDownload()");
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 3);
        this.sendHMIEvent(149950464);
        this.informListenersAboutRmToursFromGpxFileImportResult(2);
    }

    protected void showNoToursPendingPopUp() {
        if (this.isTraceEnabled()) {
            this.trace("showNoToursPendingPopUp()");
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 4);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 3);
        this.sendHMIEvent(149950464);
        this.informListenersAboutRmToursFromGpxFileImportResult(2);
    }

    protected void startImportFromGpxFile(String string) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("startImportFromGpxFile() - filePath = ").append(string).toString());
        }
        if (!this.isAborted) {
            this.importRunning = true;
            this.storeTourMemoryCapacityToCalculatedCapacity();
            this.dsiNavigation.rmImportToursFromGpxFile(1, string);
        } else {
            this.isAborted = false;
        }
    }

    private int getTourMemoryCapacity() {
        NavRmRouteListArrayData navRmRouteListArrayData = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getNavRmRouteList();
        if (navRmRouteListArrayData != null && navRmRouteListArrayData.routeList != null) {
            int n = navRmRouteListArrayData.totalSlots - navRmRouteListArrayData.routeList.length;
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("tourMemoryCapacity = ").append(n).toString());
            }
            return n;
        }
        this.warn("getTourMemoryCapacity() - routeList was null");
        return 0;
    }

    private void handleImportAbort() {
        if (this.isTraceEnabled()) {
            this.trace("handleImportAbort()");
        }
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IOnlineTourImportListener iOnlineTourImportListener = (IOnlineTourImportListener)iterator.next();
            try {
                iOnlineTourImportListener.abortTourDownload();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    private void handleImportStart() {
        if (this.isTraceEnabled()) {
            this.trace("handleImportStart()");
        }
        Iterator iterator = listeners.iterator();
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("Number of registered  IOnlineTourImportListener = ").append(listeners.size()).toString());
        }
        while (iterator.hasNext()) {
            IOnlineTourImportListener iOnlineTourImportListener = (IOnlineTourImportListener)iterator.next();
            try {
                iOnlineTourImportListener.onTourDownload();
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    private void handleOnlineTourImportAvailable() {
        if (this.isTraceEnabled()) {
            this.trace("handleOnlineTourImportAvailable()");
        }
        this.sendHMIEvent(166727680);
    }

    private void handleOnlineImportMemFull() {
        if (this.isTraceEnabled()) {
            this.trace("handleOnlineImportMemFull()");
        }
        this.isMemoryFullAfterIndication = true;
        this.informListenersAboutRmToursFromGpxFileImportResult(3);
        this.sendHMIEvent(183504896);
    }

    private void handleOnlineImportCancel() {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("handleOnlineImportCancel() - isMemoryFullAfterIndication = ").append(this.isMemoryFullAfterIndication).toString());
        }
        if (!this.isMemoryFullAfterIndication) {
            this.informListenersAboutRmToursFromGpxFileImportResult(3);
        } else {
            this.isMemoryFullAfterIndication = false;
        }
    }

    public void dsiNavigationRmImportToursFromGpxFileResult(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("dsiNavigationRmImportToursFromGpxFileResult() - resultCode (NAVRESULTCODE_OK == 0) = ").append(n).toString());
        }
        if (n != 0) {
            this.importRunning = false;
            this.informListenersAboutRmToursFromGpxFileImportResult(2);
            AbstractASLHsmTarget.writeIntegerToDatapool(-1611657216, 0);
            AbstractASLHsmTarget.writeIntegerToDatapool(-1628434432, this.navigationDp.getOnlineToursAvailable());
            AbstractASLHsmTarget.writeIntegerToDatapool(-1594880000, this.navigationDp.getOnlineToursAvailable());
            AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 3);
            this.sendHMIEvent(149950464);
        }
    }

    private void informListenersAboutRmToursFromGpxFileImportResult(int n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("informListenersAboutRmToursFromGpxFileImportResult( int resultCode = ").append(n).append(")").toString());
        }
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IOnlineTourImportListener iOnlineTourImportListener = (IOnlineTourImportListener)iterator.next();
            try {
                iOnlineTourImportListener.importToursFromGpxResult(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    private void informListenersAboutNewTourMemoryCapacity(Integer n) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("informListenersAboutNewTourMemoryCapacity( Integer calculatedCapacity = ").append(n).append(")").toString());
        }
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) {
            IOnlineTourImportListener iOnlineTourImportListener = (IOnlineTourImportListener)iterator.next();
            try {
                if (n == null) {
                    iOnlineTourImportListener.updateTourMemoryCapacity();
                    continue;
                }
                iOnlineTourImportListener.updateTourMemoryCapacityManually(n);
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void dsiNavigationUpdateRmImportToursFromGpxFileStatus(TourImportStatus tourImportStatus, int n) {
        if (n != 1) {
            this.warn("updateRmImportToursFromGpxFileStatus was not successful");
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1611657216, this.workAroundEsoIndexPlusOneFix(tourImportStatus.currentIndex));
            AbstractASLHsmTarget.writeIntegerToDatapool(-1628434432, this.workAroundEsoIndexPlusOneFix(tourImportStatus.lastIndex));
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("dsiNavMemoryUpdateRmImportToursFromGpxFileStatus - numberOfPendingTours = ").append(this.navigationDp.getOnlineToursAvailable()).toString());
            }
            AbstractASLHsmTarget.writeIntegerToDatapool(-1594880000, this.navigationDp.getOnlineToursAvailable());
            switch (tourImportStatus.status) {
                case 1: {
                    break;
                }
                case 3: {
                    this.handleFileImportStatusFailed(tourImportStatus);
                    break;
                }
                case 4: {
                    this.handleFileImportStatusAbort(tourImportStatus);
                    break;
                }
                case 2: {
                    this.handleFileImportStatusSuccess(tourImportStatus);
                    break;
                }
                case 0: {
                    this.handleFileImportStatusIdle();
                    break;
                }
                default: {
                    this.handleFileImportStatusDefault();
                }
            }
        }
    }

    private int workAroundEsoIndexPlusOneFix(int n) {
        return n;
    }

    protected void handleFileImportStatusDefault() {
        if (this.isTraceEnabled()) {
            this.trace("handleFileImportStatusDefault()");
        }
        this.importRunning = false;
        AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 0);
    }

    protected void handleFileImportStatusIdle() {
        if (this.isTraceEnabled()) {
            this.trace("handleFileImportStatusIdle()");
        }
        AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 0);
    }

    protected void handleFileImportStatusFailed(TourImportStatus tourImportStatus) {
        if (this.isTraceEnabled()) {
            this.trace("handleFileImportStatusFailed()");
        }
        this.importRunning = false;
        this.navigationDp.setOnlineToursAvailable(this.workAroundEsoIndexPlusOneFix(tourImportStatus.lastIndex) - this.workAroundEsoIndexPlusOneFix(tourImportStatus.currentIndex));
        AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 3);
        this.calculateTourMemoryCapacityAndInformListeners(tourImportStatus);
        this.sendHMIEvent(149950464);
        this.informListenersAboutRmToursFromGpxFileImportResult(2);
    }

    protected void handleFileImportStatusAbort(TourImportStatus tourImportStatus) {
        if (this.isTraceEnabled()) {
            this.trace("handleFileImportStatusAbort()");
        }
        this.importRunning = false;
        this.navigationDp.setOnlineToursAvailable(this.workAroundEsoIndexPlusOneFix(tourImportStatus.lastIndex) - this.workAroundEsoIndexPlusOneFix(tourImportStatus.currentIndex));
        AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 0);
        this.calculateTourMemoryCapacityAndInformListeners(tourImportStatus);
        this.sendHMIEvent(149950464);
        this.handleImportAbort();
    }

    protected void handleFileImportStatusSuccess(TourImportStatus tourImportStatus) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("handleFileImportStatusSuccess() - numberOfPendingTours = ").append(this.navigationDp.getOnlineToursAvailable()).toString());
        }
        this.importRunning = false;
        this.navigationDp.setOnlineToursAvailable(this.workAroundEsoIndexPlusOneFix(tourImportStatus.lastIndex) - this.workAroundEsoIndexPlusOneFix(tourImportStatus.currentIndex));
        this.calculateTourMemoryCapacityAndInformListeners(tourImportStatus);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1645211648, 0);
        AbstractASLHsmTarget.writeIntegerToDatapool(-1661988864, 0);
        this.sendHMIEvent(149950464);
        this.informListenersAboutRmToursFromGpxFileImportResult(1);
    }

    protected void calculateTourMemoryCapacityAndInformListeners(TourImportStatus tourImportStatus) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("calculateTourMemoryCapacityAndInformListeners( TourImportStatus tourMemoryCapacity = ").append(this.calculatedTourMemoryCapacity).append("; tourImportStatus = ").append(tourImportStatus).append(")").toString());
        }
        if (this.calculatedTourMemoryCapacity != null) {
            this.calculatedTourMemoryCapacity = new Integer(this.calculatedTourMemoryCapacity - this.workAroundEsoIndexPlusOneFix(tourImportStatus.currentIndex));
        }
        this.informListenersAboutNewTourMemoryCapacity(this.calculatedTourMemoryCapacity);
    }

    public void storeTourMemoryCapacityToCalculatedCapacity() {
        if (this.isTraceEnabled()) {
            this.trace("storeTourMemoryCapacity() - setting the new value for calculatedTourMemoryCapacity");
        }
        this.calculatedTourMemoryCapacity = new Integer(this.getTourMemoryCapacity());
    }

    public void dsiNavigationUpdateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray, int n) {
        this.tourMemList = new NavRmRouteListData[0];
        GenericASLList genericASLList = ListManager.getGenericASLList(1000);
        if (navRmRouteListArrayDataArray != null) {
            for (int i2 = 0; i2 < navRmRouteListArrayDataArray.length; ++i2) {
                if (navRmRouteListArrayDataArray[i2].getRmId() != 1) continue;
                ASLNavGuidanceDP.getInstance().setRmRouteList(navRmRouteListArrayDataArray[i2]);
                if (navRmRouteListArrayDataArray[i2].getRouteList() != null) {
                    this.tourMemList = navRmRouteListArrayDataArray[i2].getRouteList();
                    if (this.isTraceEnabled()) {
                        for (int i3 = 0; i3 < this.tourMemList.length; ++i3) {
                            this.trace().append("updated tour: index=").append(i3).append(" id=").append(this.tourMemList[i3].getRouteId()).append(" name=").append(this.tourMemList[i3].getName()).log();
                        }
                    }
                }
                Iterator iterator = listeners.iterator();
                while (iterator.hasNext()) {
                    IOnlineTourImportListener iOnlineTourImportListener = (IOnlineTourImportListener)iterator.next();
                    try {
                        iOnlineTourImportListener.updateTourList(navRmRouteListArrayDataArray[i2]);
                    }
                    catch (Exception exception) {
                        ServiceManager.errorHandler.handleError(exception);
                    }
                }
                break;
            }
        }
        genericASLList.updateList(this.tourMemList);
        this.informListenersAboutNewTourMemoryCapacity(null);
        this.calculatedTourMemoryCapacity = null;
    }

    public void dsiNavigationRmRouteDeleteResult(int n) {
        if (n != 0) {
            this.warn("rmRouteDelete was not successful");
        } else {
            if (this.isTraceEnabled()) {
                this.trace("rmRouteDelete successful");
            }
            this.informListenersAboutNewTourMemoryCapacity(null);
        }
        this.quitModelWaitState();
    }

    private void quitModelWaitState() {
        ServiceManager.aslPropertyManager.valueChangedInteger(3021, 0);
    }

    @Override
    public void registered(String string, int n) {
        if (this.isFirstStartupDone) {
            return;
        }
        if (string.intern() != (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            return;
        }
        this.initDsiNavigation();
        this.isFirstStartupDone = true;
    }

    private void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.navigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
        this.dsiNavigation.setNotification(48, this.navigationListener);
        this.dsiNavigation.setNotification(105, this.navigationListener);
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourMemory registered DSINavigation").log();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourMemory tries to unregister from ").append(string).log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDsiNavigation(string, dSIProxy);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiNavigation(String string, DSIProxy dSIProxy) {
        if (this.navigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.navigationListener);
            this.navigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("TargetTourMemory unregistered from ").append(string).log();
        }
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }

    public static void registerListener(IOnlineTourImportListener iOnlineTourImportListener) {
        listeners.add(iOnlineTourImportListener);
    }

    public static void unregisterListener(IOnlineTourImportListener iOnlineTourImportListener) {
        listeners.remove(iOnlineTourImportListener);
    }

    public Integer getCalculatedTourMemoryCapacity() {
        return this.calculatedTourMemoryCapacity;
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetTourMemory.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0)) {
            if (this.isTraceEnabled()) {
                this.trace("TargetTourMemory: resetting values after DSI restart");
            }
            this.initLocalVariables();
            this.initDsiNavigation();
        } else if (this.isTraceEnabled()) {
            this.trace("TargetTourMemory: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.tourMemList = new NavRmRouteListData[0];
        this.importRunning = false;
        this.isAborted = false;
        this.isMemoryFullAfterIndication = false;
        this.calculatedTourMemoryCapacity = null;
        ASLNavGuidanceDP.getInstance().setRmRouteList(null);
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
        OBSERVER = new int[]{117637184, -234749888, -268304320, -100532160, -117309376, 1472794688, 1489571904, 1791561792};
        listeners = new WeakIdentityHashSet();
    }
}

