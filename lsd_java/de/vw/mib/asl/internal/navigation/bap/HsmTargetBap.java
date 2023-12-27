/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navbap.IBapTurnToInfoNavBap;
import de.vw.mib.asl.api.navbap.ILDListElementNavBap;
import de.vw.mib.asl.api.navbap.INavLaneGuidanceDataNavBap;
import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.ASLGuidanceInfo;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceAPI;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedGuidanceSetup;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.GenericCollector;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.bap.FavoriteDestinationsAdbListFetcher;
import de.vw.mib.asl.internal.navigation.bap.HsmBapListTarget;
import de.vw.mib.asl.internal.navigation.bap.LoggerDelegate;
import de.vw.mib.asl.internal.navigation.bap.api.impl.IBapTurnToInfoNavBapImpl;
import de.vw.mib.asl.internal.navigation.bap.api.impl.ILDListElementNavBapImpl;
import de.vw.mib.asl.internal.navigation.bap.api.impl.ILocationAccessorNavBapImpl;
import de.vw.mib.asl.internal.navigation.bap.api.impl.INavLaneGuidanceDataNavBapImpl;
import de.vw.mib.asl.internal.navigation.bap.api.impl.IRouteNavBapImpl;
import de.vw.mib.asl.internal.navigation.gateway.AbstractResettableNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;
import java.util.Vector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.DSINavigation;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.NavLaneGuidanceData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.RouteHelper;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DSIAdbEdit;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.tmc.DSITmc;

public class HsmTargetBap
extends AbstractResettableNavGatewayTarget
implements DSIServiceStateListener,
LoggerDelegate {
    private DSINavigation dsiNavigation = null;
    private DSITmc dsiTmc = null;
    private DSIAdbList dsiAdbList = null;
    private DSIAdbEdit dsiAdbEdit = null;
    private DSICarKombi dsiCarKombi = null;
    private DSIListener internalAdbListListener;
    private DSIListener dsiNavigationListener;
    private DSIListener dsiTmcListener;
    private DSIListener adbEditListener;
    private AddressData currentNavAddress;
    private ASLNavigationGuidanceAPI aslNavigationGuidanceAPI;
    private FavoriteDestinationsAdbListFetcher favoriteDestFetcher;
    private boolean isCalculationStarted;
    private IExtLogger LOGGER;
    final IPersistedGuidanceSetup guidanceSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getGuidanceSetup();
    private static final int[] OBSERVERS = new int[]{-922681280, -905904064, 761017600, 794572032, 777794816, 828126464};
    private DSIListener dsiCardKombiListener;
    private HsmBapListTarget hsmBapListTarget;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEdit;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbList;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbEditListener;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    @Override
    public int getSubClassifier() {
        return 0x800000;
    }

    private void registerObservers() {
        this.addObservers(OBSERVERS);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerObservers();
                this.send(1749750784, 106, 0);
                break;
            }
            case 107: {
                break;
            }
            case 8: {
                Object object;
                this.aslNavigationGuidanceAPI = ASLNavigationGuidanceFactory.getNavigationGuidanceApi();
                this.isCalculationStarted = false;
                this.fillBapDefaults();
                this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(0x800000, "[HsmTargetBap]");
                if (this.LOGGER.isTraceEnabled()) {
                    object = this.LOGGER.makeTrace();
                    object.append("NOTIFY_TARGET_REGISTERED");
                    object.log();
                }
                object = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
                object.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this);
                object.addServiceStateListener(class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc, this);
                object.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3, this);
                object.addServiceStateListener(class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3, this);
                object.addServiceStateListener(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi, 0, this);
                break;
            }
            case 1073742281: {
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("START_BAP_ROUTE_GUIDANCE");
                    logMessage.log();
                }
                this.startRouteGuidance(eventGeneric);
                break;
            }
            case 1073742282: {
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("STOP_BAP_ROUTE_GUIDANCE");
                    logMessage.log();
                }
                this.stopRouteGuidance(eventGeneric);
                break;
            }
            case 100100: {
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("EV_ASL_INT_WPM_OFFROAD_DIRECTION");
                    logMessage.log();
                }
                if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive() || !ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmClusterShowmaneuver()) break;
                int n = eventGeneric.getInt(0);
                BapManeuverDescriptor bapManeuverDescriptor = new BapManeuverDescriptor(6, n, 0, null);
                this.updateManeuverDescriptor(new BapManeuverDescriptor[]{bapManeuverDescriptor});
                break;
            }
            case 3497005: {
                ASLCalculationState[] aSLCalculationStateArray = (ASLCalculationState[])eventGeneric.getObject(0);
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_CALCULATION_STATE:");
                    for (int i2 = 0; i2 < aSLCalculationStateArray.length; ++i2) {
                        logMessage.append(" calculationState: ");
                        logMessage.append(aSLCalculationStateArray[i2].getCalculationState());
                        logMessage.append(" progress: ");
                        logMessage.append(aSLCalculationStateArray[i2].getProgress());
                    }
                    logMessage.log();
                }
                if (aSLCalculationStateArray.length > 0) {
                    if (aSLCalculationStateArray[0].getCalculationState() == 1) {
                        if (this.isCalculationStarted) break;
                        this.isCalculationStarted = true;
                        this.sendHMIEvent(76);
                        ServiceManager.aslPropertyManager.valueChangedInteger(732, 2);
                        break;
                    }
                    this.isCalculationStarted = false;
                    if (aSLCalculationStateArray[0].getCalculationState() != 0) break;
                    this.sendHMIEvent(75);
                    break;
                }
                this.isCalculationStarted = false;
                break;
            }
            case 3497006: {
                int n = eventGeneric.getInt(0);
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_GUIDANCE_STATE: ");
                    logMessage.append(n);
                    logMessage.log();
                }
                switch (n) {
                    case 1: {
                        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive()) {
                            if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmClusterShowmaneuver()) {
                                ServiceManager.aslPropertyManager.valueChangedInteger(732, 1);
                                break block0;
                            }
                            ServiceManager.aslPropertyManager.valueChangedInteger(732, 0);
                            break block0;
                        }
                        ServiceManager.aslPropertyManager.valueChangedInteger(732, 1);
                        break block0;
                    }
                    case 0: {
                        ServiceManager.aslPropertyManager.valueChangedInteger(732, 0);
                        break block0;
                    }
                }
                break;
            }
            case 3497007: {
                int n = eventGeneric.getInt(0);
                if (this.LOGGER.isTraceEnabled()) {
                    LogMessage logMessage = this.LOGGER.makeTrace();
                    logMessage.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_ERROR_STATE: ");
                    logMessage.append(n);
                    logMessage.log();
                }
                this.sendHMIEvent(75);
                break;
            }
            case 3497009: {
                ASLGuidanceInfo[] aSLGuidanceInfoArray;
                if (this.LOGGER.isTraceEnabled()) {
                    aSLGuidanceInfoArray = this.LOGGER.makeTrace();
                    aSLGuidanceInfoArray.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_GUIDANCE_INFO");
                    aSLGuidanceInfoArray.log();
                }
                if ((aSLGuidanceInfoArray = (ASLGuidanceInfo[])eventGeneric.getObject(0)) != null && aSLGuidanceInfoArray.length > 0) {
                    if (this.guidanceSetup.isStatusLineInfo() && aSLGuidanceInfoArray[0] != null) {
                        if (this.LOGGER.isTraceEnabled()) {
                            LogMessage logMessage = this.LOGGER.makeTrace();
                            logMessage.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_GUIDANCE_INFO: Stop over -> RTT: ");
                            logMessage.append(aSLGuidanceInfoArray[0].getRttMilliseconds());
                            logMessage.append(" DTM: ");
                            logMessage.append(aSLGuidanceInfoArray[0].getDistance());
                            logMessage.log();
                        }
                        this.updateDistanceTime(aSLGuidanceInfoArray[0]);
                        break;
                    }
                    if (aSLGuidanceInfoArray.length > 1 && aSLGuidanceInfoArray[1] != null) {
                        if (this.LOGGER.isTraceEnabled()) {
                            LogMessage logMessage = this.LOGGER.makeTrace();
                            logMessage.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_GUIDANCE_INFO: Final destination -> RTT: ");
                            logMessage.append(aSLGuidanceInfoArray[aSLGuidanceInfoArray.length - 1].getRttMilliseconds());
                            logMessage.append(" DTM: ");
                            logMessage.append(aSLGuidanceInfoArray[aSLGuidanceInfoArray.length - 1].getDistance());
                            logMessage.log();
                        }
                        this.updateDistanceTime(aSLGuidanceInfoArray[aSLGuidanceInfoArray.length - 1]);
                        break;
                    }
                    this.updateDistanceTime(new ASLGuidanceInfo());
                    break;
                }
                this.updateDistanceTime(new ASLGuidanceInfo());
                break;
            }
        }
    }

    private void updateDistanceTime(ASLGuidanceInfo aSLGuidanceInfo) {
        int n = aSLGuidanceInfo.getRttHours();
        int n2 = aSLGuidanceInfo.getRttMinutes();
        int n3 = this.aslNavigationGuidanceAPI.getTimeFormat();
        if (n < 0 && n2 < 0) {
            ASLNavBAPFactory.getNavBAPApi().updateBapTimeToDestination2(-1, -1, n3);
        } else {
            ASLNavBAPFactory.getNavBAPApi().updateBapTimeToDestination2(n, n2, n3);
        }
        ASLNavBAPFactory.getNavBAPApi().updateBapDistanceToDestination((int)aSLGuidanceInfo.getDistance(), 255, aSLGuidanceInfo.getDestinationType() == 0);
    }

    public void dsiNavigationUpdateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        try {
            ILDListElementNavBap[] iLDListElementNavBapArray = null;
            if (lDListElementArray != null) {
                iLDListElementNavBapArray = new ILDListElementNavBap[lDListElementArray.length];
                for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
                    iLDListElementNavBapArray[i2] = new ILDListElementNavBapImpl(lDListElementArray[i2]);
                }
            }
            ASLNavBAPFactory.getNavBAPApi().lastDestListUpdate(iLDListElementNavBapArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private static char[] bytesToCharacters(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = (char)(byArray[i2] & 0xFF);
        }
        return cArray;
    }

    public void dsiNavigationUpdateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray, int n) {
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive()) {
            this.updateManeuverDescriptor(bapManeuverDescriptorArray);
        }
    }

    private void updateManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
        Object object;
        BapManeuverDescriptor[] bapManeuverDescriptorArray2 = bapManeuverDescriptorArray;
        if (bapManeuverDescriptorArray2 == null || bapManeuverDescriptorArray2.length == 0) {
            bapManeuverDescriptorArray2 = new BapManeuverDescriptor[]{new BapManeuverDescriptor(0, 0, 0, new byte[0])};
        }
        if (this.isTraceEnabled()) {
            object = this.trace();
            object.append(super.getClass().getName());
            for (int i2 = 0; i2 < bapManeuverDescriptorArray2.length; ++i2) {
                object.append(bapManeuverDescriptorArray2[i2].toString());
                object.append("]");
            }
            object.log();
        }
        object = new Vector();
        GenericCollector[] genericCollectorArray = new GenericCollector[bapManeuverDescriptorArray2.length];
        for (int i3 = 0; i3 < bapManeuverDescriptorArray2.length; ++i3) {
            GenericCollector genericCollector = new GenericCollector();
            genericCollector.setIntItem(0, bapManeuverDescriptorArray2[i3].getMainElement());
            genericCollector.setIntItem(1, bapManeuverDescriptorArray2[i3].getDirection());
            genericCollector.setIntItem(2, bapManeuverDescriptorArray2[i3].getZLevelGuidance());
            String string = "";
            byte[] byArray = bapManeuverDescriptorArray2[i3].getSideStreets();
            if (byArray != null) {
                string = new String(HsmTargetBap.bytesToCharacters(byArray));
            }
            genericCollector.setStringItem(3, string);
            ((Vector)object).add(genericCollector);
            genericCollectorArray[i3] = genericCollector;
        }
        this.updateMultiLineList(ListManager.getGenericASLList(751), genericCollectorArray);
        this.updateMultiLineList(ListManager.getGenericASLList(838), genericCollectorArray);
    }

    public void dsiNavigationUpdateDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver, int n) {
        DistanceToNextManeuver distanceToNextManeuver2 = distanceToNextManeuver;
        ASLNavBAPFactory.getNavBAPApi().updateBapDistanceToNextManeuver(distanceToNextManeuver2.distance, 0, distanceToNextManeuver2.isShowBargraph(), (int)((float)distanceToNextManeuver2.bargraph * 51266 / 32579));
    }

    public void dsiNavigationUpdateRgLaneGuidance(NavLaneGuidanceData[] navLaneGuidanceDataArray, boolean bl, int n) {
        INavLaneGuidanceDataNavBap[] iNavLaneGuidanceDataNavBapArray = null;
        if (navLaneGuidanceDataArray != null) {
            iNavLaneGuidanceDataNavBapArray = new INavLaneGuidanceDataNavBap[navLaneGuidanceDataArray.length];
            for (int i2 = 0; i2 < navLaneGuidanceDataArray.length; ++i2) {
                iNavLaneGuidanceDataNavBapArray[i2] = new INavLaneGuidanceDataNavBapImpl(navLaneGuidanceDataArray[i2]);
            }
        }
        ASLNavBAPFactory.getNavBAPApi().updateBapLaneGuidance(iNavLaneGuidanceDataNavBapArray, bl);
    }

    public void dsiNavigationUpdateBapTurnToInfo(BapTurnToInfo[] bapTurnToInfoArray, int n) {
        BapTurnToInfo[] bapTurnToInfoArray2 = bapTurnToInfoArray;
        if (bapTurnToInfoArray2 != null && bapTurnToInfoArray2.length > 0 && bapTurnToInfoArray2[0] != null) {
            IBapTurnToInfoNavBap[] iBapTurnToInfoNavBapArray = new IBapTurnToInfoNavBap[bapTurnToInfoArray2.length];
            for (int i2 = 0; i2 < bapTurnToInfoArray2.length; ++i2) {
                iBapTurnToInfoNavBapArray[i2] = new IBapTurnToInfoNavBapImpl(bapTurnToInfoArray2[i2]);
            }
            ASLNavBAPFactory.getNavBAPApi().updateBapTurnToInfo(iBapTurnToInfoNavBapArray);
        } else {
            ASLNavBAPFactory.getNavBAPApi().updateBapTurnToInfo("", "");
        }
    }

    public void dsiNavigationUpdateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        if (n == 1 && navLocation.street != null) {
            ServiceManager.aslPropertyManager.valueChangedString(738, navLocation.street);
        } else {
            ServiceManager.aslPropertyManager.valueChangedString(738, "");
        }
    }

    public void dsiNavigationDmLastDestinationsGetResult(long l, NavLocation navLocation) {
        if (l == 0L && navLocation != null && navLocation.isPositionValid()) {
            this.startRouteGuidanceToLocation(navLocation);
        } else {
            this.sendHMIEvent(75);
        }
    }

    public void dsiAdbListInvalidData(int n) {
        this.favoriteDestFetcher.dsiAdbListInvalidData(n);
    }

    public void dsiAdbListUpdateViewSize(AdbViewSize adbViewSize, int n) {
        this.favoriteDestFetcher.dsiAdbListUpdateViewSize(adbViewSize, n);
    }

    public void dsiAdbListGetViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        this.favoriteDestFetcher.dsiAdbListGetViewWindowResult(n, dataSetArray, n2);
    }

    public void dsiAdbEditGetEntriesResult(int n, AdbEntry[] adbEntryArray) {
        if (n == 0) {
            AddressData addressData = ASLPhoneFactory.getPhoneApi().ripADBAddressData(adbEntryArray[0].getAddressData())[0];
            if (addressData.getNavLocation() != null) {
                this.currentNavAddress = addressData;
                this.dsiNavigation.streamToLocation(addressData.getNavLocation());
            } else {
                this.sendHMIEvent(75);
            }
        } else {
            this.sendHMIEvent(75);
        }
    }

    public void dsiNavigationStreamToLocationResult(boolean bl, NavLocation navLocation) {
        if (bl) {
            if (navLocation != null && navLocation.isPositionValid()) {
                this.startRouteGuidanceToLocation(navLocation);
            } else {
                this.sendHMIEvent(75);
            }
        } else if (this.currentNavAddress != null) {
            AddressData addressData = this.currentNavAddress;
            TryBestMatchData tryBestMatchData = new TryBestMatchData();
            tryBestMatchData.country = addressData.getCountry() != null ? addressData.getCountry() : "";
            tryBestMatchData.postalCode = addressData.getPostalCode() != null ? addressData.getPostalCode() : "";
            tryBestMatchData.locality = addressData.getLocality() != null ? addressData.getLocality() : "";
            tryBestMatchData.region = addressData.getRegion() != null ? addressData.getRegion() : "";
            tryBestMatchData.streedAndOrHouseNumber = addressData.getStreet() != null ? addressData.getStreet() : "";
            tryBestMatchData.unstructured = addressData.getGeoPosition();
            new CmdTryBestMatch(this, tryBestMatchData).execute();
            this.sendHMIEvent(76);
        } else {
            this.sendHMIEvent(75);
        }
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
        TryBestMatchResultData tryBestMatchResultData;
        NavLocation navLocation = cmdTryBestMatch != null && cmdTryBestMatch.liTryBestMatchResult_result != null && cmdTryBestMatch.liTryBestMatchResult_result.length > 0 ? ((tryBestMatchResultData = cmdTryBestMatch.liTryBestMatchResult_result[0]) != null && tryBestMatchResultData.getLocation() != null ? tryBestMatchResultData.getLocation() : null) : null;
        if (navLocation != null) {
            try {
                this.startRouteGuidanceToLocation(navLocation);
            }
            catch (GenericEventException genericEventException) {
                this.error("During starting the route guidance over BAP");
                this.sendHMIEvent(75);
            }
        } else {
            this.sendHMIEvent(75);
        }
    }

    public HsmTargetBap(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.hsmBapListTarget = new HsmBapListTarget(this.getMainObject(), 1749750784, string);
    }

    private void fillBapDefaults() {
        this.updateSingleLineList(ListManager.getGenericASLList(838), new GenericCollector());
    }

    private void updateSingleLineList(GenericASLList genericASLList, GenericCollector genericCollector) {
        genericASLList.updateList(new GenericCollector[]{genericCollector});
    }

    private void updateMultiLineList(GenericASLList genericASLList, GenericCollector[] genericCollectorArray) {
        genericASLList.updateList(genericCollectorArray);
    }

    protected void startRouteGuidance(EventGeneric eventGeneric) {
        Object object;
        if (this.LOGGER.isTraceEnabled()) {
            object = this.LOGGER.makeTrace();
            object.append("startRouteGuidance()");
            object.log();
        }
        switch (eventGeneric.getInt(0)) {
            case 0: {
                if (this.LOGGER.isTraceEnabled()) {
                    object = this.LOGGER.makeTrace();
                    object.append("START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C0_HOME_ADDRESS");
                    object.log();
                }
                if ((object = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation()) != null && ((NavLocation)object).isPositionValid()) {
                    this.startRouteGuidanceToLocation((NavLocation)object);
                    break;
                }
                this.sendHMIEvent(74);
                break;
            }
            case 2: {
                if (this.LOGGER.isTraceEnabled()) {
                    object = this.LOGGER.makeTrace();
                    object.append("START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C2_LAST_DESTINATIONS_LIST_INDEX");
                    object.log();
                }
                long l = eventGeneric.getLong(1);
                this.dsiNavigation.dmLastDestinationsGet(l);
                break;
            }
            case 1: 
            case 3: {
                if (this.LOGGER.isTraceEnabled()) {
                    object = this.LOGGER.makeTrace();
                    object.append("START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C1_ORGANIZER_ENTRY_ID/START_BAP_ROUTE_GUIDANCE__TYPEOFROUTEGUIDANCEDATA__C3_FAVORITE_DEST_LIST_INDEX");
                    object.log();
                }
                long l = eventGeneric.getLong(1);
                this.dsiAdbEdit.getEntries(new long[]{l}, 14, 0);
                break;
            }
            default: {
                this.sendHMIEvent(75);
            }
        }
    }

    protected void startRouteGuidanceToLocation(NavLocation navLocation) {
        if (navLocation != null && navLocation.isPositionValid()) {
            Route route = new Route();
            RouteDestination routeDestination = new RouteDestination();
            routeDestination.setRouteLocation(navLocation);
            RouteHelper.addDestinationAtPosition(route, routeDestination, 0);
            this.aslNavigationGuidanceAPI.calculateRoute(route, false);
            this.sendHMIEvent(76);
        }
    }

    protected void stopRouteGuidance(EventGeneric eventGeneric) {
        this.aslNavigationGuidanceAPI.stopGuidance();
    }

    public void dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        boolean bl;
        if (this.LOGGER.isTraceEnabled()) {
            LogMessage logMessage = this.LOGGER.makeTrace();
            logMessage.append("dsiNavigationUpdateSoPosPosition()");
            logMessage.log();
        }
        switch (posPosition.state) {
            case 0: 
            case 1: 
            case 2: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(734, bl);
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateHeadingValue(posPosition.directionAngle, 11.25);
        ASLNavBAPFactory.getNavBAPApi().updateBapCompassInfo(n2, 0);
        this.updateCollectorAltitude(posPosition);
    }

    public void dsiTmcUpdateActiveTrafficSources(int[] nArray, int n) {
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] == 2 || nArray[i2] == 1) {
                bl = true;
                continue;
            }
            if (nArray[i2] != 6) continue;
            bl2 = true;
        }
        HsmTargetBap.writeBooleanToDatapool(2388, bl);
        HsmTargetBap.writeBooleanToDatapool(2389, bl2 && bl);
    }

    @Override
    public void registered(String string, int n) {
        if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiNavigation();
            }
        } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
            if (!this.isFirstStartupDone) {
                this.initDsiTmc();
            }
        } else if (string.compareTo((class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName()) == 0) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbEdit();
            }
        } else if (string.compareTo((class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName()) == 0) {
            if (!this.isFirstStartupDone) {
                this.initDsiAdbList();
            }
        } else if (string.compareTo((class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName()) == 0 && !this.isFirstStartupDone) {
            this.initDsiCarKombi();
        }
        if (this.dsiNavigation != null && this.dsiTmc != null && this.dsiAdbEdit != null && this.dsiAdbList != null && this.dsiCarKombi != null) {
            this.isFirstStartupDone = true;
        }
    }

    public void initDsiCarKombi() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiCarKombi = (DSICarKombi)dSIProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.dsiCardKombiListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        this.dsiCarKombi.setNotification(42, this.dsiCardKombiListener);
    }

    public void initDsiAdbList() {
        DSIListener dSIListener;
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbList = (DSIAdbList)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList, 3);
        this.internalAdbListListener = dSIListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener);
        this.favoriteDestFetcher = new FavoriteDestinationsAdbListFetcher(this.dsiAdbList, 15);
        this.favoriteDestFetcher.setLogger(this);
        this.dsiAdbList.setNotification(1, this.internalAdbListListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 3, dSIListener);
    }

    public void initDsiAdbEdit() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiAdbEdit = (DSIAdbEdit)dSIProxy.getService(this, class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit, 3);
        this.adbEditListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 3, this.adbEditListener);
    }

    public void initDsiTmc() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiTmc = (DSITmc)dSIProxy.getService(this, class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc);
        this.dsiTmcListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener);
        this.dsiTmc.setNotification(new int[]{11}, this.dsiTmcListener);
    }

    public void initDsiNavigation() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        this.dsiNavigationListener = dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener);
        dSIProxy.addResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
        this.dsiNavigation.setNotification(new int[]{8, 57, 64, 23, 76, 85, 54, 29, 28, 13}, this.dsiNavigationListener);
    }

    @Override
    public void unregistered(String string, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetBap tries to unregister from ").append(string).append("...").log();
        }
        try {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            if (dSIProxy == null) {
                this.trace().append("DSIProxy was null!");
                return;
            }
            if (string.intern() == (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName().intern()) {
                this.unregisterDSINavigation(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName().intern()) {
                this.unregisterDSITmc(string);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName().intern()) {
                this.unregisterDSIAdbEdit(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName().intern()) {
                this.unregisterDSIAdbList(string, dSIProxy);
            } else if (string.intern() == (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName().intern()) {
                this.unregisterDSICarKombi(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleDsiError(exception);
        }
    }

    private void unregisterDSICarKombi(String string) {
        this.dsiCardKombiListener = null;
        this.traceUnregisterDone(string);
    }

    private void unregisterDSIAdbList(String string, DSIProxy dSIProxy) {
        if (this.adbEditListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener, 3, this.internalAdbListListener);
            if (this.dsiAdbList == null) {
                this.trace().append("dsiAdbList was null!");
            } else {
                this.favoriteDestFetcher = null;
                this.internalAdbListListener = null;
                this.traceUnregisterDone(string);
            }
        }
    }

    private void unregisterDSIAdbEdit(String string, DSIProxy dSIProxy) {
        if (this.adbEditListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$organizer$DSIAdbEditListener == null ? (class$org$dsi$ifc$organizer$DSIAdbEditListener = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEditListener")) : class$org$dsi$ifc$organizer$DSIAdbEditListener, 3, this.adbEditListener);
            this.adbEditListener = null;
        }
        this.traceUnregisterDone(string);
    }

    private void unregisterDSITmc(String string) {
        if (this.dsiTmcListener != null) {
            if (this.dsiTmc == null) {
                this.trace().append("dsiTmc was null!");
            } else {
                this.dsiTmcListener = null;
                this.traceUnregisterDone(string);
            }
        }
    }

    private void unregisterDSINavigation(String string, DSIProxy dSIProxy) {
        this.dsiNavigation = (DSINavigation)dSIProxy.getService(this, class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation);
        if (this.dsiNavigationListener != null) {
            dSIProxy.removeResponseListener(this, class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener, this.dsiNavigationListener);
            this.dsiNavigationListener = null;
            this.traceUnregisterDone(string);
        }
    }

    private void traceUnregisterDone(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("HsmTargetBap unregistered from ").append(string).log();
        }
    }

    public void dsiCarKombiUpdateCompassInfo(int n, int n2, int n3) {
        ASLNavBAPFactory.getNavBAPApi().updateBapCompassInfo(n2, n);
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        if (route != null && route.routelist != null && route.routelist.length > 0) {
            IRouteNavBapImpl iRouteNavBapImpl = new IRouteNavBapImpl(route);
            NavLocation navLocation = route.routelist[route.routelist.length - 1].routeLocation;
            ILocationAccessor iLocationAccessor = ServiceManager.dsiServiceLocator.getLocationAccessorFactory().fromLocation(navLocation);
            ILocationAccessorNavBapImpl iLocationAccessorNavBapImpl = new ILocationAccessorNavBapImpl(iLocationAccessor);
            ASLNavBAPFactory.getNavBAPApi().updateRgCurrentRoute(iRouteNavBapImpl, iLocationAccessorNavBapImpl);
        }
    }

    private void updateCollectorAltitude(PosPosition posPosition) {
        if (this.LOGGER.isTraceEnabled()) {
            LogMessage logMessage = this.LOGGER.makeTrace();
            logMessage.append("updateCollectorAltitude()");
            logMessage.log();
        }
        ASLNavBAPFactory.getNavBAPApi().updateBapAltitudeCollector(posPosition.height, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAltitudeValueChanged(posPosition.height);
    }

    @Override
    public void reset(HashMap hashMap) {
        this.hsmBapListTarget.reset(hashMap);
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = HsmTargetBap.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (class$org$dsi$ifc$organizer$DSIAdbEdit = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : class$org$dsi$ifc$organizer$DSIAdbEdit).getName(), 3);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$organizer$DSIAdbList == null ? (class$org$dsi$ifc$organizer$DSIAdbList = HsmTargetBap.class$("org.dsi.ifc.organizer.DSIAdbList")) : class$org$dsi$ifc$organizer$DSIAdbList).getName(), 3);
        boolean bl4 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetBap.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).getName(), 0);
        boolean bl5 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = HsmTargetBap.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0);
        if (bl2 || bl3 || bl4 || bl || bl5) {
            if (this.isTraceEnabled()) {
                this.trace("HsmTargetBap: resetting values after DSI restart");
            }
            this.initLocalVariables();
            if (bl2) {
                this.initDsiAdbEdit();
            }
            if (bl3) {
                this.initDsiAdbList();
            }
            if (bl4) {
                this.initDsiCarKombi();
            }
            if (bl) {
                this.initDsiNavigation();
            }
            if (bl5) {
                this.initDsiTmc();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("HsmTargetBap: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.isCalculationStarted = false;
        this.fillBapDefaults();
        this.currentNavAddress = null;
        this.updateDistanceTime(new ASLGuidanceInfo());
        ServiceManager.aslPropertyManager.valueChangedInteger(732, 0);
        ServiceManager.aslPropertyManager.valueChangedString(738, "");
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

