/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.speller.handler;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.memory.SetHomeAddressToCcpCallback;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayTarget;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.speller.SpellerContext;
import de.vw.mib.asl.internal.navigation.speller.SpellerHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.homedestinput.transformer.NavigationHomeDestInputHomeDestinationDetailCollector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.util.ILocationAccessor;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public class HomeInputHandler
extends AbstractNavGatewayTarget
implements SpellerHandler {
    public static final int EV_SET_CCP_WITH_CALLBACK;
    public static final int EV_SET_CCP_WITH_CALLBACK_PO;
    public static final int EV_SET_CCP_WITH_UPDATER;
    public static final int EV_SET_HOME_ADDRESS_WITH_UPDATER;
    public static final int EV_SET_HOME_ADDRESS_WITH_UPDATER_PO_NAV_LOCATION;
    private SetHomeAddressToCcpCallback setHomeAddressToCcpCallback = null;
    private boolean makeExternalUpdateToSetHomeAddressToCcp = false;
    private boolean makeExternalUpdateToSetHomeAddress = false;

    public HomeInputHandler(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.addObserver(671219776);
                this.addObserver(755105856);
                this.fillDetailsGetter(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation());
                break;
            }
            case 1073742376: {
                NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation());
                ILocationAccessorFactory iLocationAccessorFactory = ServiceManager.dsiServiceLocator.getLocationAccessorFactory();
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("location: ").append(navLocation == null ? "null" : navLocation.toString()).toString());
                }
                if (navLocation != null && !navLocation.isPositionValid() && iLocationAccessorFactory != null) {
                    int n;
                    int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getLatitude();
                    ILocationAccessor iLocationAccessor = iLocationAccessorFactory.createLocationAccessorFromGeoPos(n2, n = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition().getLongitude());
                    navLocation = iLocationAccessorFactory.toLocation(iLocationAccessor);
                    if (navLocation == null) {
                        this.error("location accessor created null location");
                    } else {
                        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                        if (iLocationWrapper.getLatitude() != 0 || iLocationWrapper.getLongitude() != 0) {
                            navLocation.positionValid = true;
                            this.warn("corrected current location for home because current position was invalid");
                        }
                    }
                }
                if (navLocation == null || !navLocation.isPositionValid()) {
                    this.error("used default location for home because current position was invalid");
                    navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getDefaultLocation());
                }
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("location: ").append(navLocation == null ? "null" : navLocation.toString()).toString());
                }
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setHomeDest(navLocation, false);
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setDestInputLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setLastDest(navLocation);
                break;
            }
            case 1073742381: {
                this.handleHomeDestInputSetCCP();
                break;
            }
            case 100100: {
                this.setHomeAddressToCcpCallback = (SetHomeAddressToCcpCallback)eventGeneric.getObject(0);
                this.handleHomeDestInputSetCCP();
                break;
            }
            case 100101: {
                this.makeExternalUpdateToSetHomeAddressToCcp = true;
                this.handleHomeDestInputSetCCP();
                break;
            }
            case 100102: {
                NavLocation navLocation = (NavLocation)eventGeneric.getObject(0);
                this.makeExternalUpdateToSetHomeAddress = true;
                this.handleHomeDestInput(navLocation);
                break;
            }
        }
    }

    private void handleHomeDestInput(NavLocation navLocation) {
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("Set home address to: ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        new CmdGetLocationDescriptionTransform(this, navLocation).execute();
    }

    private void handleHomeDestInputSetCCP() {
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        int n = posPosition.getLatitude();
        int n2 = posPosition.getLongitude();
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("transform ccp as home location, ccp is: ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        new CmdGetLocationDescriptionTransform(this, navLocation).execute();
    }

    private void handleHomeDestInputSetMemory() {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getMemoryLocation());
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DemoInputHandler: Set memory location as home location: ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        this.setHomeLocation(navLocation);
    }

    @Override
    public void onActivated(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
        ServiceManager.aslPropertyManager.valueChangedInteger(3658, 0);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("HomeInputHandler: activating location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        spellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationDiscarded(SpellerContext spellerContext) {
        NavLocation navLocation = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().getHomeLocation();
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("HomeInputHandler: discarding with location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        spellerContext.setLocation(navLocation);
    }

    @Override
    public void onLocationSaved(SpellerContext spellerContext) {
        NavLocation navLocation = spellerContext.getLocation();
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation);
        if (this.isTraceEnabled()) {
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("HomeInputHandler: saving location ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation2);
            logMessage.log();
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setLastDest(navLocation2);
        this.setHomeLocation(navLocation2);
    }

    private void setHomeLocation(NavLocation navLocation) {
        this.fillDetailsGetter(navLocation);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup().setHomeDest(navLocation, true);
    }

    private void fillDetailsGetter(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper;
        if (navLocation != null) {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            ServiceManager.aslPropertyManager.valueChangedBoolean(836, true);
        } else {
            iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
            ServiceManager.aslPropertyManager.valueChangedBoolean(836, false);
        }
        String string = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().createDetailString(7, navLocation);
        ServiceManager.aslPropertyManager.valueChangedString(834, string);
        ServiceManager.aslPropertyManager.valueChangedString(835, string);
        NavigationHomeDestInputHomeDestinationDetailCollector navigationHomeDestInputHomeDestinationDetailCollector = (NavigationHomeDestInputHomeDestinationDetailCollector)ListManager.getGenericASLList(837).getRowItemCacheOnly(0);
        if (navigationHomeDestInputHomeDestinationDetailCollector != null) {
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city = iLocationWrapper.getCity();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_city_refinement = iLocationWrapper.getCityRefinement();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_country_code = iLocationWrapper.getCountryCode();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_cross = iLocationWrapper.getCrossing();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_hno = iLocationWrapper.getHousenumber();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_degree = iLocationWrapper.getLatitudeDegrees();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_current_dest_data_lat_minutes = iLocationWrapper.getLatitudeMinutes();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lat_seconds = iLocationWrapper.getLatitudeSeconds();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_degree = iLocationWrapper.getLatitudeDegrees();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_minutes = iLocationWrapper.getLongitudeMinutes();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_lon_seconds = iLocationWrapper.getLongitudeSeconds();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street = iLocationWrapper.getStreet();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_zip = iLocationWrapper.getPostalCode();
            navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_address_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            try {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_full_postal_code = iLocationWrapper.isFullPostalCode();
            }
            catch (Throwable throwable) {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_full_postal_code = false;
                ServiceManager.errorHandler.handleError(throwable);
            }
            try {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_postal_code_spelled = iLocationWrapper.isPostalCodeSpelled();
            }
            catch (Throwable throwable) {
                navigationHomeDestInputHomeDestinationDetailCollector.navigation_homedestinput_home_destination_detail_postal_code_spelled = false;
                ServiceManager.errorHandler.handleError(throwable);
            }
        }
    }

    @Override
    public void onContext(SpellerContext spellerContext) {
        Object object;
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(spellerContext.getLocation());
        if (navLocation != null && navLocation.isPositionValid()) {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setSpellerLocation(ASLNavigationUtilFactory.getNavigationUtilApi().cloneLocation(navLocation));
        }
        if (this.isTraceEnabled()) {
            object = ServiceManager.logger.trace(16384);
            object.append("HomeInputHandler.onContext(");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation((LogMessage)object, navLocation);
            object.append(")");
            object.log();
        }
        object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().createDetailString(7, navLocation);
        ServiceManager.aslPropertyManager.valueChangedString(766, (String)object);
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        NavLocation navLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append("handleCommandCmdGetLocationDescriptionTransform(").append(navLocation).append(")").toString());
            LogMessage logMessage = ServiceManager.logger.trace(16384);
            logMessage.append("DemoInputHandler: set transformed ccp as home location, transformed ccp is: ");
            ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendLocation(logMessage, navLocation);
            logMessage.log();
        }
        this.setHomeLocation(navLocation);
        ServiceManager.aslPropertyManager.valueChangedInteger(2933, 0);
        if (this.setHomeAddressToCcpCallback != null) {
            this.setHomeAddressToCcpCallback.notifySetHomeAddressToCcpDone(true);
            this.setHomeAddressToCcpCallback = null;
        }
        if (this.makeExternalUpdateToSetHomeAddressToCcp) {
            this.sendHomeAdressSetToCcpUpdateEventToNavExternService();
            this.makeExternalUpdateToSetHomeAddressToCcp = false;
        }
        if (this.makeExternalUpdateToSetHomeAddress) {
            this.sendHomeAdressSetUpdateEventToNavExternService();
            this.makeExternalUpdateToSetHomeAddress = false;
        }
    }

    private void sendHomeAdressSetUpdateEventToNavExternService() {
        ServiceManager.logger.trace(16384, "sendHomeAdressSetUpdateEventToNavExternService");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1247294720);
        eventGeneric.setBoolean(0, true);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    private void sendHomeAdressSetToCcpUpdateEventToNavExternService() {
        ServiceManager.logger.trace(16384, "sendHomeAdressSetToCcpUpdateEventToNavExternService");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1230517504);
        eventGeneric.setBoolean(0, true);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public int getSubClassifier() {
        return 16384;
    }
}

