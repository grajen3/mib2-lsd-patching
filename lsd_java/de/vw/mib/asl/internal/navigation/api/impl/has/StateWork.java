/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INaviHelper;
import de.vw.mib.asl.internal.navigation.api.impl.has.Events;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.util.StringBuilder;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ImportGPXDataContainer;
import generated.de.vw.mib.has.containers.ImportGPXResultContainer;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryBestMatchResultData;

public class StateWork
extends AbstractHsmState {
    private final HsmTargetHas target;

    StateWork(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetHas;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 101003: {
                this.target.traceState(this, "NAVI_TARGET_PREPARE_ON");
                this.target.initHAS();
                break;
            }
            case 101001: {
                this.target.traceState(this, "NAVI_TARGET_GO_ON");
                Events.addObservers(this.target);
                this.target.initDSI();
                this.trans(this.target.stateNoGuidance);
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                Events.removeObservers(this.target);
                break;
            }
            case 3497007: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_ERROR_STATE");
                break;
            }
            case 100102: {
                this.target.traceState(this, "EV_ASL_INT_HAS_RESOLVE_ADDRESS");
                this.target.resolveAddressCallId = eventGeneric.getInt(0);
                AddressContainer addressContainer = (AddressContainer)eventGeneric.getObject(1);
                TryBestMatchData tryBestMatchData = new TryBestMatchData();
                tryBestMatchData.country = addressContainer.getCountry();
                tryBestMatchData.locality = addressContainer.getCity();
                tryBestMatchData.postalCode = addressContainer.getZip();
                tryBestMatchData.region = addressContainer.getState();
                tryBestMatchData.streedAndOrHouseNumber = new StringBuilder(addressContainer.getStreet()).append(" ").append(addressContainer.getHousenumber()).toString().trim();
                this.target.services.getNavigation().liTryBestMatch(tryBestMatchData);
                break;
            }
            case 100103: {
                this.target.traceState(this, "EV_ASL_INT_HAS_RESOLVE_LAST_DESTINATION");
                this.target.resolveLastDestId = eventGeneric.getInt(0);
                LastDestinationContainer lastDestinationContainer = (LastDestinationContainer)eventGeneric.getObject(1);
                if (lastDestinationContainer != null) {
                    this.target.services.getNavigation().dmLastDestinationsGet(lastDestinationContainer.getId());
                    break;
                }
                this.target.traceState(this, "LastDestinationContainer is null!");
                break;
            }
            case 100101: {
                this.target.traceState(this, "EV_ASL_INT_HAS_STOP_GUIDANCE");
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().stopGuidance();
                this.target.hasResults.stopGuidanceResult(eventGeneric.getInt(0), 0);
                break;
            }
            case 100104: {
                this.target.traceState(this, "EV_ASL_INT_HAS_IMPORT_GPX");
                this.target.importGPXCallid = eventGeneric.getInt(0);
                ImportGPXDataContainer importGPXDataContainer = (ImportGPXDataContainer)eventGeneric.getObject(1);
                this.target.services.getNavigation().importRouteFromGpxFile(importGPXDataContainer.getResource().getUrl());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        this.target.traceState(this, "dsiNavigationUpdateSoPosPosition");
        if (n == 1 && posPosition != null) {
            this.target.currentVehiclePos.setLongitude(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(posPosition.getLongitude()));
            this.target.currentVehiclePos.setLatitude(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(posPosition.getLatitude()));
            this.target.currentVehiclePos.setAltitude(posPosition.getHeight());
            this.target.hasProperties.updateLocation(this.target.currentVehiclePos);
            this.target.hasProperties.updateHeading(posPosition.getDirectionAngle());
        }
    }

    public void dsiNavigationUpdateSoPosPositionDescription(NavLocation navLocation, boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateSoPosPositionDescription");
        if (n == 1 && navLocation != null) {
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            this.target.currentVehiclePos.setCity(iLocationWrapper.getCity());
            this.target.currentVehiclePos.setCountry(iLocationWrapper.getCountry());
            this.target.currentVehiclePos.setHousenumber(iLocationWrapper.getHousenumber());
            this.target.currentVehiclePos.setState(iLocationWrapper.getState());
            this.target.currentVehiclePos.setStreet(iLocationWrapper.getStreet());
            this.target.currentVehiclePos.setZip(iLocationWrapper.getPostalCode());
            this.target.currentVehiclePos.setFormattedString("");
        }
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCurrentRoute");
        if (n == 1 && route != null && route.getRoutelist() != null && route.getRoutelist().length > 0) {
            NavLocation navLocation = route.getRoutelist()[route.getRoutelist().length - 1].getRouteLocation();
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            AddressContainer addressContainer = this.buildAddressContainer(iLocationWrapper);
            this.target.hasProperties.updateGuidanceDestination(addressContainer);
        } else {
            AddressContainer addressContainer = (AddressContainer)this.target.factory.createContainer(1);
            this.target.hasProperties.updateGuidanceDestination(addressContainer);
        }
    }

    public void dsiNavigationLiTryBestMatchResult(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.target.traceState(this, "dsiNavigationLiTryBestMatchResult");
        ILocationWrapper iLocationWrapper = null;
        int n = 1;
        if (tryBestMatchResultDataArray != null && tryBestMatchResultDataArray.length > 0 && tryBestMatchResultDataArray[0].getLocation() != null && (iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(tryBestMatchResultDataArray[0].getLocation())).isNavigable()) {
            n = 0;
        }
        this.target.hasResults.resolveAddressResult(this.target.resolveAddressCallId, n, this.buildAddressContainer(iLocationWrapper));
    }

    public void dsiNavigationDmLastDestinationsGetResult(long l, NavLocation navLocation) {
        this.target.traceState(this, "dsiNavigationDmLastDestinationsGetResult");
        ILocationWrapper iLocationWrapper = null;
        int n = 1;
        if (l == 0L && (iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation)).isNavigable()) {
            n = 0;
        }
        this.target.hasResults.resolveLastDestinationResult(this.target.resolveLastDestId, n, this.buildAddressContainer(iLocationWrapper));
    }

    public void dsiNavigationUpdateDmLastDestinationsList(LDListElement[] lDListElementArray, int n) {
        this.target.traceState(this, "dsiNavigationUpdateDmLastDestinationsList");
        if (n == 1) {
            this.target.hasProperties.updateLastDestinations(this.buildLastDestinationsContainer(lDListElementArray));
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination");
        if (n == 1 && rgInfoForNextDestination.getDistanceToNextDest() > 0L || rgInfoForNextDestination.getTimeToNextDest() > 0L) {
            INaviHelper iNaviHelper = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper();
            INavGateway iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
            this.target.guidanceRemaining.setTimeToDestination((int)iNaviHelper.getLastDestinationRtt(rgInfoForNextDestination, iNavGateway.getRgDestinationInfo(), iNavGateway.getRgCurrentRoute()) / 1000);
            this.target.guidanceRemaining.setDistanceToDestination((int)iNaviHelper.getLastDestinationDistance(rgInfoForNextDestination, iNavGateway.getRgDestinationInfo(), iNavGateway.getRgCurrentRoute()));
        } else {
            this.target.guidanceRemaining.unsetDistanceToDestination();
            this.target.guidanceRemaining.unsetTimeToDestination();
        }
        this.target.hasProperties.updateGuidanceRemaining(this.target.guidanceRemaining);
    }

    public void dsiNavigationImportRouteFromGpxFileResult(NavLocation navLocation) {
        this.target.traceState(this, "dsiNavigationImportRouteFromGpxFileResult");
        boolean bl = true;
        ImportGPXResultContainer importGPXResultContainer = (ImportGPXResultContainer)this.target.factory.createContainer(60);
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        importGPXResultContainer.setName(iLocationWrapper.getGpxName());
        if (iLocationWrapper.isNavigable()) {
            importGPXResultContainer.setResult(0);
        }
        this.target.hasResults.importGPXResult(this.target.importGPXCallid, 1, importGPXResultContainer);
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(159842560);
        eventGeneric.setObject(0, navLocation);
        ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric);
    }

    private AddressContainer buildAddressContainer(ILocationWrapper iLocationWrapper) {
        AddressContainer addressContainer = (AddressContainer)this.target.factory.createContainer(1);
        if (iLocationWrapper != null && iLocationWrapper.getLocation() != null) {
            addressContainer.setCity(iLocationWrapper.getCity());
            addressContainer.setCountry(iLocationWrapper.getCountry());
            addressContainer.setHousenumber(iLocationWrapper.getHousenumber());
            addressContainer.setState(iLocationWrapper.getState());
            addressContainer.setStreet(iLocationWrapper.getStreet());
            addressContainer.setZip(iLocationWrapper.getPostalCode());
            addressContainer.setAltitude(0.0);
            addressContainer.setFormattedString("");
            addressContainer.setLatitude(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLatitude()));
            addressContainer.setLongitude(ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().dsiToDecimal(iLocationWrapper.getLongitude()));
        }
        return addressContainer;
    }

    private LastDestinationsContainer buildLastDestinationsContainer(LDListElement[] lDListElementArray) {
        LastDestinationsContainer lastDestinationsContainer = (LastDestinationsContainer)this.target.factory.createContainer(37);
        LastDestinationContainer[] lastDestinationContainerArray = new LastDestinationContainer[lDListElementArray.length];
        for (int i2 = 0; i2 < lDListElementArray.length; ++i2) {
            LastDestinationContainer lastDestinationContainer = (LastDestinationContainer)this.target.factory.createContainer(36);
            lastDestinationContainer.setDescriptor(this.formatStringForFileSystem(lDListElementArray[i2].getTitle()));
            lastDestinationContainer.setId((int)lDListElementArray[i2].getId());
            lastDestinationContainerArray[i2] = lastDestinationContainer;
            this.target.traceState(this, new StringBuffer().append("adding new lastDestinationContainer: ").append(lastDestinationContainer.getDescriptor()).toString());
        }
        if (lastDestinationContainerArray.length == 0) {
            lastDestinationsContainer.unsetDestinations();
        } else {
            lastDestinationsContainer.setDestinations(lastDestinationContainerArray);
        }
        return lastDestinationsContainer;
    }

    private String formatStringForFileSystem(String string) {
        this.target.traceState(this, "formatStringForFileSystem()");
        if (string != null) {
            char[] cArray = string.toCharArray();
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                if (cArray[i2] <= '\uf80000') continue;
                this.target.traceState(this, "Format character");
                cArray[i2] = (char)(cArray[i2] - 0xF80000);
            }
            return new String(cArray);
        }
        return null;
    }
}

