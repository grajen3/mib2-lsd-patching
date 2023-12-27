/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.gateway.AbstractNavGatewayHsmState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.asl.internal.navigation.map.setup.MapFavoriteDescriptor;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.navigation.map.clickinmap.transformer.NavigationMapClickInMapClickInMapDataCollector;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public class MapViewerTouchgesturesStateOneFingerClickInMapNew
extends AbstractNavGatewayHsmState
implements CacheClient {
    private NavigationMapClickInMapClickInMapDataCollector collector;
    private int[] eInfoTypePriorities = new int[]{15, 4, 3, 2, 1, 8, 5, 16, 0, 7};
    private String infoTxt;
    private PosInfo lastPosInfo;
    private PosInfo[] posInfos;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateOneFingerClickInMapNew]");
    private MapFavoriteDescriptor selectedFavoriteDesc;
    private final MapViewerTouchgesturesTargetHSM target;
    private boolean countryRequested;
    private boolean additionalPositionInfoRequest;
    private boolean additonalDetailsInfoRequest;

    public MapViewerTouchgesturesStateOneFingerClickInMapNew(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTouchgesturesTargetHSM;
        this.lastPosInfo = null;
        this.selectedFavoriteDesc = null;
        this.collector = null;
    }

    private void clickInMapHomeOrFavourite(PosInfo posInfo) {
        this.logger.trace("clickInMapHomeOrFavourite()");
        this.collector = new NavigationMapClickInMapClickInMapDataCollector();
        long l = posInfo.getObjectId();
        if (l == this.target.datapool.getHomeFlagId()) {
            this.logger.trace("clickInMapHomeOrFavourite() Home menu");
            this.collector.navigation_map_clickinmap_click_in_map_element_type = 4;
            NavLocation navLocation = this.target.datapool.getHomeLocation();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(navLocation);
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            this.lastPosInfo.tLocation = navLocation;
        } else {
            this.collector.navigation_map_clickinmap_click_in_map_element_type = 5;
            ArrayList arrayList = this.target.datapool.getFavoritesList();
            if (arrayList != null) {
                boolean bl = false;
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    MapFavoriteDescriptor mapFavoriteDescriptor = (MapFavoriteDescriptor)iterator.next();
                    if (this.logger.isTraceEnabled()) {
                        this.logger.makeTrace().append("clickInMapHomeOrFavourite(), FavName=").append(mapFavoriteDescriptor.getName()).log();
                    }
                    if (mapFavoriteDescriptor.getManagedFlagId() != l) continue;
                    this.collector.navigation_map_clickinmap_click_in_map_element_name = mapFavoriteDescriptor.getName();
                    NavLocation navLocation = posInfo.getTLocation();
                    navLocation = this.prepareNavLocation(navLocation, mapFavoriteDescriptor);
                    ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(navLocation);
                    ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
                    this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
                    this.lastPosInfo.tLocation = navLocation;
                    this.selectedFavoriteDesc = mapFavoriteDescriptor;
                    bl = true;
                    break;
                }
                if (!bl) {
                    this.logger.error("Favourite not found!");
                    this.collector.navigation_map_clickinmap_click_in_map_element_name = "";
                }
            } else {
                this.logger.error("Favorite list is empty!");
                this.collector.navigation_map_clickinmap_click_in_map_element_name = "";
            }
        }
        this.collector.navigation_map_clickinmap_click_in_map_element_icon = this.getDefaultIcon();
        this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = this.target.datapool.isStreetViewAvailable();
        this.activateClickInMapMenu(this.collector);
    }

    private NavLocation prepareNavLocation(NavLocation navLocation, MapFavoriteDescriptor mapFavoriteDescriptor) {
        if (navLocation == null || mapFavoriteDescriptor == null) {
            return navLocation;
        }
        if ((navLocation.getProprietaryData() == null || navLocation.getProprietaryData().length < 1) && this.posInfos != null) {
            for (int i2 = 0; i2 < this.posInfos.length; ++i2) {
                PosInfo posInfo = this.posInfos[i2];
                if (posInfo.getTLocation().getProprietaryData() == null || posInfo.getTLocation().getProprietaryData().length <= 0) continue;
                navLocation = posInfo.getTLocation();
                break;
            }
        }
        navLocation.latitude = mapFavoriteDescriptor.getLatitude();
        navLocation.longitude = mapFavoriteDescriptor.getLongitude();
        navLocation.country = mapFavoriteDescriptor.getCountry();
        navLocation.town = mapFavoriteDescriptor.getCity();
        navLocation.street = mapFavoriteDescriptor.getStreet();
        return navLocation;
    }

    private void clickInMapLocationPopUp(PosInfo posInfo) {
        this.logger.trace("clickInMapLocationPopUp()");
        ILocationWrapper iLocationWrapper = this.getLocationFromPosInfo(posInfo);
        if (iLocationWrapper == null) {
            return;
        }
        this.collector = new NavigationMapClickInMapClickInMapDataCollector();
        this.collector.navigation_map_clickinmap_click_in_map_element_type = posInfo.eInfoType == 15 ? 6 : 0;
        this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.collector.navigation_map_clickinmap_click_in_map_element_icon = this.getDefaultIcon();
        this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = this.target.datapool.isStreetViewAvailable();
        this.activateClickInMapMenu(this.collector);
    }

    private void activateClickInMapMenu(NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector) {
        ILocationWrapper iLocationWrapper = this.getLocationFromPosInfo(this.lastPosInfo);
        NavLocationWgs84 navLocationWgs84 = new NavLocationWgs84(iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude());
        ASLNavigationMapFactory.getNavigationMapApi().sendMapMainSetStreetViewPosition(navLocationWgs84);
        MapViewerDatapoolShared.getInstance().setClickInMapMenuActive(true);
        MapViewerDatapoolShared.getInstance().setFocusCCPZoom(false);
        this.target.datapool.setMapMoved(true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapMovedByUser();
        this.target.notifierDSI.setModeFreeMap();
        this.target.notifierModel.notifyMapMovedTrue();
        this.target.notifierModel.updateClickInMapPopUp(navigationMapClickInMapClickInMapDataCollector);
        this.target.notifierModel.notifyClickInMapMenuReady();
        this.target.backupZoomLevel();
    }

    private boolean isCountryContained(NavLocation navLocation) {
        return navLocation != null && navLocation.country != null && !"".equals(navLocation.country);
    }

    private void clickInMapPoiPopUp(PosInfo posInfo) {
        this.logger.trace(new StringBuffer().append("clickInMapPoiPopUp()").append(posInfo).toString());
        if (!this.isCountryContained(posInfo.getTLocation()) && !this.countryRequested) {
            this.countryRequested = true;
            this.additionalPositionInfoRequest = true;
            new CmdGetLocationDescriptionTransform(this, posInfo.getTLocation()).execute();
            return;
        }
        this.countryRequested = false;
        ILocationWrapper iLocationWrapper = this.getLocationFromPosInfo(posInfo);
        if (iLocationWrapper == null) {
            return;
        }
        this.collector = new NavigationMapClickInMapClickInMapDataCollector();
        this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        if (GoogleEarthUtils.isGoogleEarthActive() && posInfo.eInfoType == 8) {
            this.collector.navigation_map_clickinmap_click_in_map_element_name = posInfo.getInfoTxt() != null ? posInfo.getInfoTxt() : "";
            this.collector.navigation_map_clickinmap_click_in_map_element_type = 3;
            this.collector.navigation_map_clickinmap_click_in_map_element_icon = this.getDefaultIcon();
        } else if (posInfo.eInfoType == 3) {
            this.collector.navigation_map_clickinmap_click_in_map_element_name = iLocationWrapper.getPoiName();
            this.collector.navigation_map_clickinmap_click_in_map_element_type = 2;
            this.collector.navigation_map_clickinmap_click_in_map_element_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, this.collector);
        } else {
            this.collector.navigation_map_clickinmap_click_in_map_element_name = iLocationWrapper.getPoiName();
            this.collector.navigation_map_clickinmap_click_in_map_element_type = 1;
            this.collector.navigation_map_clickinmap_click_in_map_element_icon = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForPOIIcon(iLocationWrapper.getIconIndex(), iLocationWrapper.getSubIconIndex(), 0, this, this.collector);
        }
        this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = this.target.datapool.isStreetViewAvailable();
        this.activateClickInMapMenu(this.collector);
    }

    private void clickInMapPoiStackPopUp(PosInfo posInfo) {
        this.logger.trace("clickInMapPoiStackPopUp()");
        if (!this.isCountryContained(posInfo.getTLocation()) && !this.countryRequested) {
            this.countryRequested = true;
            this.additionalPositionInfoRequest = true;
            new CmdGetLocationDescriptionTransform(this, posInfo.getTLocation()).execute();
            return;
        }
        this.countryRequested = false;
        ILocationWrapper iLocationWrapper = this.getLocationFromPosInfo(posInfo);
        if (iLocationWrapper == null) {
            return;
        }
        this.collector = new NavigationMapClickInMapClickInMapDataCollector();
        this.collector.navigation_map_clickinmap_click_in_map_element_type = 2;
        this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.collector.navigation_map_clickinmap_click_in_map_element_icon = this.getDefaultIcon();
        this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = this.target.datapool.isStreetViewAvailable();
        this.activateClickInMapMenu(this.collector);
    }

    private void handleASLNavigationMapEvMapMainGoogleStreetviewAvailable(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapEvMapMainGoogleStreetviewAvailable(lat= ").append(n).append(", long=").append(n2).append(", avail=").append(bl).append(")").log();
        }
        if (this.collector != null) {
            this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = bl;
            this.target.notifierModel.updateClickInMapPopUp(this.collector);
        }
    }

    private PosInfo findPosInfoByPriorityList(PosInfo[] posInfoArray) {
        for (int i2 = 0; i2 < this.eInfoTypePriorities.length; ++i2) {
            int n = this.eInfoTypePriorities[i2];
            PosInfo posInfo = this.findPosInfoWithEInfoType(posInfoArray, n);
            if (posInfo == null) continue;
            return posInfo;
        }
        return null;
    }

    private PosInfo findPosInfoWithEInfoType(PosInfo[] posInfoArray, int n) {
        for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
            PosInfo posInfo = posInfoArray[i2];
            int n2 = posInfo.eInfoType;
            if (n2 != n) continue;
            return posInfo;
        }
        return null;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        this.logger.trace("getDefaultIcon()");
        return new ResourceLocator();
    }

    private ILocationWrapper getLocationFromPosInfo(PosInfo posInfo) {
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.logger.error("No valid nav location found in PosInfo");
            return null;
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setClickInMapLocation(navLocation);
        return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
                break;
            }
            case 1074841933: {
                this.handleASLNavigationMapSelectClickInMapMenuElement();
                break;
            }
            case 3499062: {
                this.handleASLNavigationMapEvMapMainGoogleStreetviewAvailable(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapSelectClickInMapMenuElement() {
        this.logger.trace("handleASLNavigationMapSelectClickInMapMenuElement()");
        if (this.lastPosInfo == null) {
            return;
        }
        int n = this.lastPosInfo.eInfoType;
        switch (n) {
            case 1: 
            case 2: 
            case 16: {
                this.showPoi(this.lastPosInfo);
                break;
            }
            case 3: {
                this.showPoiContainer(this.lastPosInfo);
                break;
            }
            case 5: {
                this.showFavorite(this.lastPosInfo);
                break;
            }
            case 8: {
                this.showXtRepresentation(this.lastPosInfo);
                break;
            }
            default: {
                if (!this.logger.isTraceEnabled()) break;
                this.logger.makeWarn().append("Unhandled eInfoType=").append(n).log();
            }
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
        this.logger.trace("handleCommandCmdGetLocationDescriptionTransform()");
        if (this.additionalPositionInfoRequest) {
            this.additionalPositionInfoRequest = false;
            if (this.lastPosInfo.eInfoType == 0) {
                if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation == null) {
                    this.logger.warn("handleCommandCmdGetLocationDescriptionTransform() - the NavLocation ist null, execution stopped");
                    return;
                }
                this.lastPosInfo.tLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
                this.clickInMapLocationPopUp(this.lastPosInfo);
            } else if (this.lastPosInfo.eInfoType == 1 || this.lastPosInfo.eInfoType == 8) {
                if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation == null) {
                    this.logger.warn("handleCommandCmdGetLocationDescriptionTransform() - the NavLocation ist null, execution stopped");
                    return;
                }
                if (GoogleEarthUtils.isGoogleEarthActive() && this.lastPosInfo.eInfoType == 8) {
                    this.lastPosInfo.tLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
                } else {
                    this.fillLackingLocationInformation(this.lastPosInfo.tLocation, cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
                }
                this.clickInMapPoiPopUp(this.lastPosInfo);
            } else if (this.lastPosInfo.eInfoType == 3) {
                if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation == null) {
                    this.logger.warn("handleCommandCmdGetLocationDescriptionTransform() - the NavLocation ist null, execution stopped");
                    return;
                }
                this.lastPosInfo.tLocation = cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation;
                this.clickInMapPoiPopUp(this.lastPosInfo);
            }
        } else if (this.additonalDetailsInfoRequest) {
            this.additonalDetailsInfoRequest = false;
            if (cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation == null) {
                this.logger.warn("handleCommandCmdGetLocationDescriptionTransform() - the NavLocation ist null, execution stopped");
                this.target.notifierModel.notifyClickInMapBrowserFooterEnabled();
                return;
            }
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(cmdGetLocationDescriptionTransform.liGetLocationDescriptionTransformResult_NavLocation);
            iLocationWrapper.setMmiInternalDataValue(3, this.infoTxt);
            this.infoTxt = "";
            this.target.datapool.setMapInputLocation(iLocationWrapper.getLocation());
            this.target.notifierModel.notifyClickInMapBrowserFooterEnabled();
        } else {
            this.logger.warn("Request type for CmdGetLocationDescriptionTransform not recognized, execution will not continue");
            return;
        }
    }

    private void fillLackingLocationInformation(NavLocation navLocation, NavLocation navLocation2) {
        if (navLocation2.positionValid) {
            if (navLocation.country == null || navLocation.country.equals("")) {
                navLocation.country = navLocation2.country;
            }
            if (navLocation.countryAbbreviation == null || navLocation.countryAbbreviation.equals("")) {
                navLocation.countryAbbreviation = navLocation2.countryAbbreviation;
            }
            if (navLocation.street == null || navLocation.street.equals("")) {
                navLocation.street = navLocation2.street;
            }
            if (navLocation.streetRefinement == null || navLocation.street.equals("")) {
                navLocation.streetRefinement = navLocation2.streetRefinement;
            }
            if (navLocation.town == null || navLocation.town.equals("")) {
                navLocation.town = navLocation2.town;
            }
            if (navLocation.townRefinement == null || navLocation.townRefinement.equals("")) {
                navLocation.townRefinement = navLocation2.townRefinement;
            }
            if (navLocation.towncenter == null || navLocation.towncenter.equals("")) {
                navLocation.towncenter = navLocation2.towncenter;
            }
            if (navLocation.zipCode == null || navLocation.zipCode.equals("")) {
                navLocation.zipCode = navLocation2.zipCode;
            }
            if (navLocation.junction == null || navLocation.junction.equals("")) {
                navLocation.junction = navLocation2.junction;
            }
            if (navLocation.housenumber == null || navLocation.housenumber.equals("")) {
                navLocation.housenumber = navLocation2.housenumber;
            }
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): rcvrEventId=").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        MapViewerDatapoolShared.getInstance().setClickInMapMenuActive(false);
        this.target.notifierModel.notifyClickInMapMenuNotReady();
        this.collector = null;
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        if (posInfoArray == null || posInfoArray.length == 0) {
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            this.logger.warn("no valid posInfo!");
            return;
        }
        this.posInfos = posInfoArray;
        this.lastPosInfo = this.findPosInfoByPriorityList(posInfoArray);
        if (this.lastPosInfo == null) {
            this.logger.trace("No valid eInfoType found in posInfoList");
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            this.target.notifierModel.notifyClickedStatusNothingFound();
            return;
        }
        int n = this.lastPosInfo.eInfoType;
        if (n == 8 && (this.lastPosInfo.url == null || this.lastPosInfo.url.length() == 0)) {
            this.logger.warn("WORKAROUND: Mapping XT_Representation -> Location till getInfoForPosition() will return correct location type!");
            this.lastPosInfo.eInfoType = 0;
            this.additionalPositionInfoRequest = true;
            new CmdGetLocationDescriptionTransform(this, this.lastPosInfo.getTLocation()).execute();
            return;
        }
        switch (n) {
            case 0: 
            case 7: 
            case 15: {
                this.clickInMapLocationPopUp(this.lastPosInfo);
                break;
            }
            case 1: 
            case 8: {
                this.clickInMapPoiPopUp(this.lastPosInfo);
                break;
            }
            case 16: {
                this.clickInMapLandmarkPopUp(this.lastPosInfo);
                break;
            }
            case 3: {
                this.clickInMapPoiStackPopUp(this.lastPosInfo);
                break;
            }
            case 4: {
                this.showTmcMessage(this.lastPosInfo);
                break;
            }
            case 5: {
                this.clickInMapHomeOrFavourite(this.lastPosInfo);
                break;
            }
            default: {
                if (!this.logger.isTraceEnabled()) break;
                this.logger.makeTrace().append("handleGetInfoForScreenPositionResult(), unhandled eInfoType=").append(n).log();
            }
        }
    }

    private void clickInMapLandmarkPopUp(PosInfo posInfo) {
        this.logger.trace("clickInMapLandmarkPopUp()");
        ILocationWrapper iLocationWrapper = this.getLocationFromPosInfo(posInfo);
        if (iLocationWrapper == null) {
            return;
        }
        this.collector = new NavigationMapClickInMapClickInMapDataCollector();
        this.collector.navigation_map_clickinmap_click_in_map_address_info_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
        this.collector.navigation_map_clickinmap_click_in_map_element_name = iLocationWrapper.getPoiName();
        this.collector.navigation_map_clickinmap_click_in_map_element_type = 8;
        this.collector.navigation_map_clickinmap_click_in_map_element_icon = this.getDefaultIcon();
        this.collector.navigation_map_clickinmap_click_in_map_is_street_view_available = this.target.datapool.isStreetViewAvailable();
        this.activateClickInMapMenu(this.collector);
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResultAsyncExcetion()");
        this.lastPosInfo = null;
        this.selectedFavoriteDesc = null;
        this.collector = null;
        this.target.notifierModel.notifyClickInMapMenuNotReady();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.logger.trace("handleIconCacheUpdate()");
        if (object != null) {
            NavigationMapClickInMapClickInMapDataCollector navigationMapClickInMapClickInMapDataCollector = (NavigationMapClickInMapClickInMapDataCollector)object;
            navigationMapClickInMapClickInMapDataCollector.navigation_map_clickinmap_click_in_map_element_icon = resourceLocator;
            this.target.notifierModel.updateClickInMapPopUp(navigationMapClickInMapClickInMapDataCollector);
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.lastPosInfo = null;
        this.selectedFavoriteDesc = null;
        this.collector = null;
        this.target.backupLocationType();
        this.target.notifierDSI.getInfoForScreenPosition(this.target, new Point(this.target.datapool.getOneFingerClickX(), this.target.datapool.getOneFingerClickY()));
    }

    private void showFavorite(PosInfo posInfo) {
        this.logger.trace("showFavorite()");
        if (this.selectedFavoriteDesc != null) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), -1890905088, 1541485312);
            eventGeneric.setLong(0, this.selectedFavoriteDesc.getOrganizerId());
            this.target.send(eventGeneric);
        } else {
            this.logger.warn("showFavorite() - favorite NOT found!");
        }
    }

    private boolean showPoi(PosInfo posInfo) {
        this.logger.trace("showPoi()");
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.logger.warn("posInfoList.tLocation == null, execution stopped");
            return false;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1155609344);
        eventGeneric.setObject(0, navLocation);
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showPoiContainer(PosInfo posInfo) {
        this.logger.trace("showPoiContainer()");
        NavLocation navLocation = posInfo.getTLocation();
        if (navLocation == null) {
            this.logger.warn("posInfoList.tLocation == null, execution stopped");
            return false;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1122054912);
        eventGeneric.setObject(0, navLocation);
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showTmcMessage(PosInfo posInfo) {
        this.logger.trace("showTmcMessage()");
        this.target.notifierModel.notifyClickInMapMenuNotReady();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1883968512, 1138832128);
        eventGeneric.setLong(0, posInfo.getObjectId());
        this.target.send(eventGeneric);
        return true;
    }

    private boolean showXtRepresentation(PosInfo posInfo) {
        Object object;
        this.logger.trace("showXtRepresentation()");
        if (posInfo.url == null) {
            this.logger.trace("No URL set for the XTRepresentation eInfoType - Google POI not found");
            return false;
        }
        this.target.notifierModel.notifyClickInMapBrowserFooterDisabled();
        NavLocation navLocation = posInfo.tLocation;
        if (navLocation != null) {
            object = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
            this.infoTxt = posInfo.infoTxt;
            object.setMmiInternalDataValue(3, this.infoTxt);
            this.target.datapool.setMapInputLocation(object.getLocation());
            this.additonalDetailsInfoRequest = true;
            new CmdGetLocationDescriptionTransform(this, object.getLocation()).execute();
        }
        object = posInfo.getInfoTxt();
        this.target.notifierModel.notifyBrowserSetInfoText((String)object);
        String string = posInfo.getUrl();
        this.target.notifierModel.notifyBrowserSetURL(string);
        this.target.notifierModel.notifyClickenObjectTMCFalse();
        this.target.notifierModel.notifyObjectTypeOnMapXTRepresentation();
        this.target.sendHMIEventNaviClickedIcon();
        return true;
    }
}

