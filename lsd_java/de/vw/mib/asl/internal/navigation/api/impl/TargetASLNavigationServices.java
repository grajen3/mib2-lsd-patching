/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.navigation.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationServicesListener;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.startup.NavStartupStatusListener;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.navigation.api.impl.ASLNavigationServices;
import de.vw.mib.asl.internal.navigation.api.impl.TargetASLNavigationServices$TransStreamArg;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayListener;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.NavPhoneData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.util.RouteHelper;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbInit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;

public class TargetASLNavigationServices
extends AbstractNavGatewayListener
implements Target,
DSIServiceStateListener,
NavStartupStatusListener {
    private static final int IMPORT_CONTACT_RESULT_DELAY;
    private static final int MAX_DEFAULT_PUBLIC_PROFILE_ENTRIES;
    private static final int MAX_ONLINE_DESTINATIONS;
    private static final Logger LOGGER;
    private static final int EV_SEND_DELAYED_IMPORT_CONTACT_RESPONSE;
    private static final int EV_SEND_DELAYED_IMPORT_CONTACT_RESPONSE_P0_RESULT;
    private static final int[] DSI_NAV_UPDATES;
    private static final int[] DSI_ADB_EDIT_UPDATES;
    private static final int[] DSI_ADB_LIST_UPDATES;
    private static final int[] EVENTS;
    private final Map serviceInstances = new HashMap();
    private final List importQueue = new LinkedList();
    private boolean serviceAvailable;
    private boolean lastServiceAvailable;
    private boolean newEntryAvailable;
    private DSINavigation dsiNavigation;
    private DSIAdbList dsiAdbList;
    private DSIAdbEdit dsiAdbEdit;
    private boolean isDsiAvailable;
    private boolean isNavDbAvailable;
    private boolean isNavigationRunning = false;
    private int lastReportedCapacity = -1;
    private int pendingResolveLocationRequests;
    private ASLNavigationServicesListener tempImportListener;
    private GenericEvents mEventContext;
    private int startGuidanceSource;
    private boolean oldRgActive;
    private int calculationState;
    private boolean rgActive;
    private int maxPublicProfileEntries = 500;
    private int currentPublicProfileEntriesCount = 0;
    private int currentOnlineDestinationsCount = 100;
    boolean calculatedRgActive;
    private boolean registeredForEvents;
    private String startGudiancePhoneNumber;
    private DSIListener navigationlistener;
    private DSIListener adbEditlistener;
    private DSIListener adbListlistener;
    private DSIListener adbInitListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInit;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInitListener;

    public TargetASLNavigationServices(GenericEvents genericEvents, String string) {
        this.trace("TargetASLNavigationSevices instantiated");
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 2, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 2, this);
        ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit, this);
        this.setEventContext(genericEvents);
        try {
            this.mEventContext.getEventDispatcher().registerTarget(this.getTargetId(), this, string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().registerNavStartupStatusListener(this);
    }

    private static boolean isOnlineDestinationFeatureAvailable() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(649);
    }

    private void setEventContext(GenericEvents genericEvents) {
        if (this.mEventContext == null) {
            this.mEventContext = genericEvents;
        }
    }

    de.vw.mib.asl.api.navigation.ASLNavigationServices createServiceInstance(ASLNavigationServicesListener aSLNavigationServicesListener) {
        this.trace("Request to create a new NavServices instance");
        de.vw.mib.asl.api.navigation.ASLNavigationServices aSLNavigationServices = null;
        if (aSLNavigationServicesListener != null && this.serviceInstances.containsKey(aSLNavigationServicesListener)) {
            aSLNavigationServices = (de.vw.mib.asl.api.navigation.ASLNavigationServices)this.serviceInstances.get(aSLNavigationServicesListener);
            this.trace("Listener was already registered, returning exsisting instance");
        } else {
            aSLNavigationServices = new ASLNavigationServices(aSLNavigationServicesListener, this);
            this.serviceInstances.put(aSLNavigationServicesListener, aSLNavigationServices);
            this.trace("Created new service instance");
        }
        this.updateSingleListener(aSLNavigationServicesListener);
        return aSLNavigationServices;
    }

    boolean isServiceAvailable() {
        return this.serviceAvailable;
    }

    int getContactCapacity() {
        if (TargetASLNavigationServices.isOnlineDestinationFeatureAvailable()) {
            return Math.max(100 - this.currentOnlineDestinationsCount, 0);
        }
        return Math.max(this.maxPublicProfileEntries - this.currentPublicProfileEntriesCount - this.currentOnlineDestinationsCount, 0);
    }

    void importContact(AdbEntry adbEntry, ASLNavigationServicesListener aSLNavigationServicesListener, int n, boolean bl) {
        this.trace("Received contact import request");
        this.trace(adbEntry.toString());
        boolean bl2 = n == 5 || !bl;
        this.notifyDestinationImportActive(!bl2);
        if (this.checkAdbEntryIntegrity(adbEntry)) {
            int[] nArray;
            if (TargetASLNavigationServices.isOnlineDestinationFeatureAvailable() && (n == 1 || n == 3)) {
                adbEntry.entryType = 5;
            }
            adbEntry.entryId = 0L;
            if (n == 5 && ((nArray = this.parseGeoPosition(adbEntry.getAddressData()[0].getGeoPosition()))[0] != 0 || nArray[1] != 0)) {
                new CmdTransformAndToStream(this, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(nArray[0], nArray[1]).getLocation(), new TargetASLNavigationServices$TransStreamArg(this, aSLNavigationServicesListener, adbEntry)).execute();
                return;
            }
            if (adbEntry.getEntryType() != 5 || TargetASLNavigationServices.isOnlineDestinationFeatureAvailable()) {
                this.importQueue.add(aSLNavigationServicesListener);
                this.dsiAdbEdit.insertEntry(adbEntry, 0);
            }
        } else {
            this.trace("Entry integrity could not be verified, aborting import");
            this.tempImportListener = aSLNavigationServicesListener;
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), this.getTargetId(), 207893760);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    void startGuidance(NavAddress[] navAddressArray, boolean bl, int n) {
        this.trace("startGuidance");
        for (int i2 = 0; i2 < navAddressArray.length && i2 <= 0; ++i2) {
            Object object;
            this.startGuidanceSource = n;
            NavAddress navAddress = navAddressArray[i2];
            String string = this.createAddressPartsStringFromNavAddress(navAddress);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setInvalidDestMemLocationAddressParts(string);
            int n2 = navAddress.getLatitude();
            int n3 = navAddress.getLongitude();
            double d2 = navAddress.getLatitudeDecimal();
            double d3 = navAddress.getLongitudeDecimal();
            String string2 = navAddress.getPhoneNumber();
            if (n2 != 0 || n3 != 0 || d2 != 0.0 || d3 != 0.0) {
                if (d2 != 0.0 || d3 != 0.0) {
                    n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(d2);
                    n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(d3);
                }
                object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n2, n3).getLocation();
                new CmdGetLocationDescriptionTransform(this, (NavLocation)object).execute();
            } else {
                object = new TryBestMatchData();
                ((TryBestMatchData)object).country = navAddress.getCountry() != null ? navAddress.getCountry() : "";
                ((TryBestMatchData)object).postalCode = navAddress.getZip() != null ? navAddress.getZip() : "";
                ((TryBestMatchData)object).locality = navAddress.getCity() != null ? navAddress.getCity() : "";
                ((TryBestMatchData)object).region = navAddress.getState() != null ? navAddress.getState() : "";
                String string3 = navAddress.getStreet() != null ? navAddress.getStreet() : "";
                ((TryBestMatchData)object).streedAndOrHouseNumber = string3.concat(navAddress.getHousenumber() != null ? " ".concat(navAddress.getHousenumber()) : "");
                ((TryBestMatchData)object).phoneNumbers = new NavPhoneData[]{new NavPhoneData(string2, 2)};
                new CmdTryBestMatch(this, (TryBestMatchData)object).execute();
            }
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("startGuidance - phoneNumber: ").append(navAddress.getPhoneNumber()).toString());
            }
            this.setStartGudiancePhoneNumber(navAddress.getPhoneNumber() != null ? navAddress.getPhoneNumber() : "");
            ++this.pendingResolveLocationRequests;
        }
    }

    private String createAddressPartsStringFromNavAddress(NavAddress navAddress) {
        String string = "";
        if (navAddress != null) {
            string = new StringBuffer().append(StringUtil.isEmpty(navAddress.getCountry()) ? "" : new StringBuffer().append(navAddress.getCountry()).append(" ").toString()).append(StringUtil.isEmpty(navAddress.getCity()) ? "" : new StringBuffer().append(navAddress.getCity()).append(" ").toString()).append(StringUtil.isEmpty(navAddress.getZip()) ? "" : new StringBuffer().append(navAddress.getZip()).append(" ").toString()).append(StringUtil.isEmpty(navAddress.getStreet()) ? "" : new StringBuffer().append(navAddress.getStreet()).append(" ").toString()).append(StringUtil.isEmpty(navAddress.getHousenumber()) ? "" : new StringBuffer().append(navAddress.getHousenumber()).append(" ").toString()).toString();
        }
        return string;
    }

    private void updateSingleListener(ASLNavigationServicesListener aSLNavigationServicesListener) {
        if (aSLNavigationServicesListener != null) {
            aSLNavigationServicesListener.updateServiceAvailable(this.serviceAvailable);
            if (this.serviceAvailable) {
                aSLNavigationServicesListener.updateGuidanceActive(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive());
                aSLNavigationServicesListener.updateContactCapacity(this.getContactCapacity());
                this.lastReportedCapacity = this.getContactCapacity();
            } else {
                aSLNavigationServicesListener.updateGuidanceActive(false);
                aSLNavigationServicesListener.updateContactCapacity(0);
                this.lastReportedCapacity = 0;
            }
        }
    }

    private void updateListenersServiceAvailable() {
        boolean bl = this.serviceAvailable = this.isDsiAvailable && this.isNavDbAvailable && this.isNavigationRunning;
        if (this.lastServiceAvailable != this.serviceAvailable) {
            this.lastServiceAvailable = this.serviceAvailable;
            Iterator iterator = this.serviceInstances.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                ASLNavigationServicesListener aSLNavigationServicesListener = (ASLNavigationServicesListener)map$Entry.getKey();
                if (aSLNavigationServicesListener == null) continue;
                aSLNavigationServicesListener.updateServiceAvailable(this.serviceAvailable);
            }
            this.updateListenersContactCapacity();
        }
    }

    private void updateListenersRgActive() {
        boolean bl = this.calculatedRgActive = this.rgActive || this.calculationState != 0;
        if (this.rgActive != this.oldRgActive) {
            this.oldRgActive = this.rgActive;
            if (this.isTraceEnabled()) {
                this.trace(new StringBuffer().append("updateGuidanceActive=").append(this.rgActive).toString());
            }
            this.notifyGuidanceActiveChanged(this.rgActive);
        }
    }

    private void notifyGuidanceActiveChanged(boolean bl) {
        Iterator iterator = this.serviceInstances.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            ASLNavigationServicesListener aSLNavigationServicesListener = (ASLNavigationServicesListener)map$Entry.getKey();
            if (aSLNavigationServicesListener == null) continue;
            try {
                aSLNavigationServicesListener.updateGuidanceActive(bl);
            }
            catch (Throwable throwable) {
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    private void updateListenersContactCapacity() {
        int n = this.getContactCapacity();
        if (n != this.lastReportedCapacity) {
            if (this.isTraceEnabled()) {
                LOGGER.trace(16384).append(new StringBuffer().append("TargetASLNavigationServices.updateListenersContactCapacity() : Sending newCapacity=").append(n).append(" to listeners").toString()).log();
            }
            this.lastReportedCapacity = n;
            Iterator iterator = this.serviceInstances.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                ASLNavigationServicesListener aSLNavigationServicesListener = (ASLNavigationServicesListener)map$Entry.getKey();
                if (aSLNavigationServicesListener == null) continue;
                aSLNavigationServicesListener.updateContactCapacity(n);
            }
        }
    }

    public void dsiNavigationUpdateRgRouteCalculationState(int n, int n2) {
        this.calculationState = n;
        this.updateListenersRgActive();
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.rgActive = bl;
        this.updateListenersRgActive();
    }

    public void dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        if (n2 == 1) {
            this.isNavDbAvailable = n == 5;
            this.updateListenersServiceAvailable();
        }
        if (!this.registeredForEvents) {
            ServiceManager.eventMain.getServiceRegister().addObserver(EVENTS, this.getTargetId());
            this.registeredForEvents = true;
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        --this.pendingResolveLocationRequests;
        NavLocation navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
        if (navLocation != null && navLocation.isPositionValid()) {
            this.sendStartGuidanceRequest(navLocation);
        } else {
            INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
            if (navLocation != null) {
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                iNavigationDP.setMemoryLocation(iLocationWrapper.getLocation());
            } else {
                iNavigationDP.setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-235991040);
            this.error("No matching address found for external startGuidance()");
        }
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
        --this.pendingResolveLocationRequests;
        if (cmdTryBestMatch.liTryBestMatchResult_result != null && cmdTryBestMatch.liTryBestMatchResult_result.length > 0 && cmdTryBestMatch.liTryBestMatchResult_result[0] != null && cmdTryBestMatch.liTryBestMatchResult_result[0].getLocation() != null && cmdTryBestMatch.liTryBestMatchResult_result[0].getLocation().isPositionValid()) {
            this.sendStartGuidanceRequest(cmdTryBestMatch.liTryBestMatchResult_result[0].getLocation());
        } else {
            INavigationDP iNavigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
            if (cmdTryBestMatch.liTryBestMatchResult_result != null && cmdTryBestMatch.liTryBestMatchResult_result.length > 0 && cmdTryBestMatch.liTryBestMatchResult_result[0] != null && cmdTryBestMatch.liTryBestMatchResult_result[0].getLocation() != null) {
                ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdTryBestMatch.liTryBestMatchResult_result[0].getLocation());
                iNavigationDP.setMemoryLocation(iLocationWrapper.getLocation());
            } else {
                iNavigationDP.setMemoryLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(902, true);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-235991040);
            this.error("No matching address found for external startGuidance()");
        }
    }

    @Override
    public void handleCommandCmdTransformAndToStream(CmdTransformAndToStream cmdTransformAndToStream) {
        TargetASLNavigationServices$TransStreamArg targetASLNavigationServices$TransStreamArg = (TargetASLNavigationServices$TransStreamArg)cmdTransformAndToStream.arg;
        if (cmdTransformAndToStream.stream != null && cmdTransformAndToStream.stream.length > 0) {
            if (targetASLNavigationServices$TransStreamArg != null && targetASLNavigationServices$TransStreamArg.getEntry() != null) {
                AdbEntry adbEntry = targetASLNavigationServices$TransStreamArg.getEntry();
                if (this.checkAdbEntryIntegrity(adbEntry)) {
                    adbEntry.getAddressData()[0].navLocation = cmdTransformAndToStream.stream;
                } else {
                    this.trace("Entry integrity could not be verified, aborting import");
                    this.tempImportListener = targetASLNavigationServices$TransStreamArg.getListener();
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), this.getTargetId(), 207893760);
                    ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
                }
                this.importQueue.add(targetASLNavigationServices$TransStreamArg.getListener());
                this.dsiAdbEdit.insertEntry(adbEntry, 0);
            }
        } else if (targetASLNavigationServices$TransStreamArg != null && targetASLNavigationServices$TransStreamArg.getEntry() != null) {
            this.importQueue.add(targetASLNavigationServices$TransStreamArg.getListener());
            this.dsiAdbEdit.insertEntry(targetASLNavigationServices$TransStreamArg.getEntry(), 0);
        }
    }

    public void dsiAdbEditUpdateNewPublicProfileEntryAvailable(boolean bl, int n) {
        this.setNewEntryAvailable(bl);
        this.updateListenersContactCapacity();
    }

    public void dsiAdbEditInsertEntryResult(int n, AdbEntry adbEntry) {
        if (this.importQueue.size() > 0) {
            int n2 = 1;
            if (n != 0) {
                n2 = 2;
            }
            if (n == 5 || n == 6) {
                this.currentPublicProfileEntriesCount = this.maxPublicProfileEntries;
                this.currentPublicProfileEntriesCount = 100;
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), this.getTargetId(), 1622606080);
            eventGeneric.setInt(0, n2);
            ServiceManager.eventMain.getTimerServer().sendTimedEvent(eventGeneric, 0, false);
        }
    }

    private void sendDelayedImportContactResponse(int n) {
        ASLNavigationServicesListener aSLNavigationServicesListener = (ASLNavigationServicesListener)this.importQueue.remove(0);
        if (aSLNavigationServicesListener != null) {
            aSLNavigationServicesListener.importContactResult(n);
        }
        this.updateListenersContactCapacity();
    }

    public void dsiAdbEditAsyncException(int n, String string, int n2) {
        if (n == 8304 && n2 == 1000) {
            this.currentPublicProfileEntriesCount = this.maxPublicProfileEntries;
            this.currentOnlineDestinationsCount = 100;
            ASLNavigationServicesListener aSLNavigationServicesListener = (ASLNavigationServicesListener)this.importQueue.remove(0);
            if (aSLNavigationServicesListener != null) {
                this.updateListenersContactCapacity();
                aSLNavigationServicesListener.importContactResult(2);
            }
        }
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        boolean bl = false;
        if (dataSetArray != null && dataSetArray.length > 0) {
            boolean bl2 = bl = dataSetArray[0].getEntryType() == 5;
        }
        if (bl) {
            this.currentOnlineDestinationsCount = n2;
        } else {
            this.currentPublicProfileEntriesCount = n2;
        }
        this.updateListenersContactCapacity();
    }

    public void dsiAdbListInvalidData(int n) {
        this.updateDsiPublicProfileSize();
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this.currentPublicProfileEntriesCount = adbViewSize.getPublicProfileEntries();
        this.currentOnlineDestinationsCount = adbViewSize.getOnlineDestination();
        this.updateListenersContactCapacity();
    }

    private void updateDsiPublicProfileSize() {
        this.dsiAdbList.getViewWindow(0L, 4, 6, 1);
        if (TargetASLNavigationServices.isOnlineDestinationFeatureAvailable()) {
            this.dsiAdbList.getViewWindow(0L, 4, 18, 1);
        }
    }

    public void dsiAdbInitUpdateMaxLocalEntries(int n, int n2) {
        if (1 == n2) {
            if (this.isTraceEnabled()) {
                LOGGER.trace(16384).append("TargetASLNavigationServices: Max local entries set to:").append(n).log();
            }
            this.maxPublicProfileEntries = n;
            this.updateListenersContactCapacity();
        }
    }

    @Override
    public void registered(String string, int n) {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
            this.navigationlistener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
            this.dsiNavigation.setNotification(DSI_NAV_UPDATES, this.navigationlistener);
        } else if (string.equals((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName()) && n == 2) {
            this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, n);
            this.adbEditlistener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.adbEditlistener);
            this.dsiAdbEdit.setNotification(DSI_ADB_EDIT_UPDATES, this.adbEditlistener);
        } else if (string.equals((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName()) && n == 2) {
            this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, n);
            this.adbListlistener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
            this.dsiAdbList.setNotification(DSI_ADB_LIST_UPDATES, this.adbListlistener);
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListlistener);
            this.updateDsiPublicProfileSize();
        } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit).getName().intern()) {
            DSIAdbInit dSIAdbInit = (DSIAdbInit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit);
            this.adbInitListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbInitListener == null ? (class$org$dsi$ifc$organizer$DSIAdbInitListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbInitListener")) : class$org$dsi$ifc$organizer$DSIAdbInitListener);
            dSIAdbInit.setNotification(2, this.adbInitListener);
        }
        this.isDsiAvailable = this.dsiNavigation != null && this.dsiAdbEdit != null && this.dsiAdbList != null;
        this.updateListenersServiceAvailable();
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            LOGGER.trace(16384).append("TargetASLNavigationServices tries to unregister from ").append(string).log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                LOGGER.trace(16384).append("DSIProxy was null!");
                return;
            }
            if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName())) {
                this.unregisterDsiNavigation(string);
            } else if (string.equals((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName()) && n == 2) {
                this.unregisterDsiAdbEdit(string, dSIProxy);
            } else if (string.equals((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName()) && n == 2) {
                this.unregisterDsiAdbList(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbInit == null ? (class$org$dsi$ifc$organizer$DSIAdbInit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbInit")) : class$org$dsi$ifc$organizer$DSIAdbInit).getName().intern()) {
                this.unregisterDsiAdbInit(string, dSIProxy);
            }
            if (string.equals((class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TargetASLNavigationServices.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName()) || string.equals((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName()) && n == 2 || string.equals((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName()) && n == 2) {
                this.isDsiAvailable = false;
                this.updateListenersServiceAvailable();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDsiAdbInit(String string, DSIProxy dSIProxy) {
        if (this.adbInitListener != null) {
            this.adbInitListener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiAdbList(String string, DSIProxy dSIProxy) {
        if (this.adbListlistener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 2, this.adbListlistener);
            this.adbListlistener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiAdbEdit(String string, DSIProxy dSIProxy) {
        if (this.adbEditlistener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = TargetASLNavigationServices.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 2, this.adbEditlistener);
            this.adbEditlistener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void unregisterDsiNavigation(String string) {
        if (this.navigationlistener != null) {
            this.navigationlistener = null;
        }
        this.traceUnregisteredDone(string);
    }

    private void traceUnregisteredDone(String string) {
        if (this.isTraceEnabled()) {
            LOGGER.trace(16384).append("TargetASLNavigationServices unregistered from ").append(string).log();
        }
    }

    private void sendStartGuidanceRequest(NavLocation navLocation) {
        Route route = new Route();
        RouteDestination routeDestination = new RouteDestination();
        routeDestination.setRouteLocation(navLocation);
        RouteHelper.addDestinationAtPosition(route, routeDestination, 0);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRouteWithConfirmation(route, this.getModelSourceContext());
    }

    @Override
    public void trace(String string) {
        if (this.isTraceEnabled()) {
            LOGGER.trace(16384).append("TargetASLNavigationServices: ").append(string).log();
        }
    }

    boolean isTraceEnabled() {
        return LOGGER != null && LOGGER.isTraceEnabled(16384);
    }

    boolean isCurrentlyResolvingLocations() {
        return this.pendingResolveLocationRequests > 0;
    }

    private int getModelSourceContext() {
        switch (this.startGuidanceSource) {
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 5: {
                return 5;
            }
        }
        return 0;
    }

    private boolean checkAdbEntryIntegrity(AdbEntry adbEntry) {
        if (adbEntry == null) {
            this.trace("CheckAbdEntryIntegrity failed because entry is null");
            return false;
        }
        if (adbEntry.getAddressData() != null && adbEntry.getAddressData().length > 0 && adbEntry.getAddressData()[0] != null) {
            AddressData addressData = adbEntry.getAddressData()[0];
            return !StringUtil.isEmpty(addressData.getGeoPosition()) || !StringUtil.isEmpty(addressData.getCountry()) && !StringUtil.isEmpty(addressData.getLocality());
        }
        this.trace("CheckAbdEntryIntegrity failed because of missing AddressData");
        return false;
    }

    private void triggerErrorResponse() {
        if (this.tempImportListener != null) {
            this.tempImportListener.importContactResult(2);
            this.tempImportListener = null;
        }
    }

    @Override
    public int getTargetId() {
        return 1464538112;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3499020: {
                this.triggerErrorResponse();
                break;
            }
            case 1074841864: {
                this.trace("SET_DESTINATION_IMPORT_STATUS");
                boolean bl = eventGeneric.getBoolean(0);
                this.notifyDestinationImportActive(bl);
                break;
            }
            case 4800003: {
                this.trace("ASL_ONLINE_DESTINATIONIMPORT_ACTIVE");
                boolean bl = eventGeneric.getBoolean(0);
                this.notifyDestinationImportActive(bl);
                break;
            }
            case 112480: {
                this.trace("EV_SEND_DELAYED_IMPORT_CONTACT_RESPONSE");
                int n = eventGeneric.getInt(0);
                this.sendDelayedImportContactResponse(n);
                break;
            }
        }
    }

    void notifyDestinationImportActive(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(82841600, bl);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), -1052044288, 895759616);
        eventGeneric.setBoolean(0, bl);
        try {
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    @Override
    public GenericEvents getMainObject() {
        return null;
    }

    @Override
    public void setTargetId(int n) {
    }

    int[] parseGeoPosition(String string) {
        int[] nArray = new int[2];
        try {
            String string2 = string.trim();
            string2 = this.removePrefix(string2);
            int n = this.findCoordinateSeparator(string2);
            String string3 = string2.substring(0, n).trim();
            if (this.isTraceEnabled()) {
                LOGGER.trace(16384).append("TargetNavMemLoadEntry.parseGeoPosition.Latitude String: ").append(string3).log();
            }
            double d2 = Double.valueOf((String)string3);
            String string4 = string2.substring(n + 1).trim();
            if (this.isTraceEnabled()) {
                LOGGER.trace(16384).append("TargetNavMemLoadEntry.parseGeoPosition.Longitude String: ").append(string4).log();
            }
            double d3 = Double.valueOf((String)string4);
            if (Math.abs(d2) > 90.0 || Math.abs(d3) > 180.0) {
                LOGGER.warn(16384).append("TargetNavMemLoadEntry.parseGeoPosition(): received coordinates in wrong format. Assuming micro degrees, converting to dregrees. lat: ").append(d2).append(" longitude: ").append(d3).log();
                d2 /= 1000000.0;
                d3 /= 1000000.0;
            }
            nArray[0] = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(d2);
            nArray[1] = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(d3);
            if (this.isTraceEnabled()) {
                LOGGER.trace(16384).append("TargetNavMemLoadEntry.parseGeoPosition(): ").append(string).append(" -> DSI: ").append(nArray[0]).append(";").append(nArray[1]).log();
            }
        }
        catch (Exception exception) {
            LOGGER.warn(16384).append("ASLNavigationServices.parseGeoPosition(): coordinates could not be parsed: ").append(string).log();
        }
        return nArray;
    }

    private int findCoordinateSeparator(String string) {
        if (string.indexOf(";") != -1) {
            return string.indexOf(";");
        }
        if (string.indexOf(",") != -1 && string.indexOf(",") != string.lastIndexOf(",")) {
            return string.indexOf(",");
        }
        return -1;
    }

    private String removePrefix(String string) {
        int n = string.lastIndexOf(":");
        if (n != -1 && string.length() > n + 1) {
            string = string.substring(n + 1);
        }
        return string;
    }

    void stopGuidance(int n) {
        this.trace("stopGuidance");
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().stopGuidance();
    }

    public boolean isNewEntryAvailable() {
        return this.newEntryAvailable;
    }

    public void setNewEntryAvailable(boolean bl) {
        this.newEntryAvailable = bl;
    }

    public String getStartGudiancePhoneNumber() {
        return this.startGudiancePhoneNumber;
    }

    public void setStartGudiancePhoneNumber(String string) {
        this.startGudiancePhoneNumber = string;
    }

    @Override
    public void navStartupStatusChanged() {
        this.isNavigationRunning = ASLNavigationStartupFactory.getNavigationStartupApi().isNaviRunning();
        if (this.isTraceEnabled()) {
            if (this.isNavigationRunning) {
                LOGGER.trace(16384).append("notify listeners that navi is running").log();
            } else {
                LOGGER.trace(16384).append("notify listeners that navi is not running").log();
            }
        }
        this.updateListenersServiceAvailable();
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
        LOGGER = ServiceManager.logger;
        DSI_NAV_UPDATES = new int[]{11, 52, 49};
        DSI_ADB_EDIT_UPDATES = new int[]{2};
        DSI_ADB_LIST_UPDATES = new int[]{1};
        EVENTS = new int[]{147394624, 54413568};
    }
}

