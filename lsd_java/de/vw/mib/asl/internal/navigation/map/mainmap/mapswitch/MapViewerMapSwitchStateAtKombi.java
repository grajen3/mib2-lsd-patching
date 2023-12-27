/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerMapSwitchStateAtKombi
extends AbstractHsmState
implements TargetForResetNavigation,
ReloadPersistedDataListener {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchStateAtKombi]");
    private MapViewerMapSwitchTargetHSM target;
    private MapViewerDatapoolShared datapoolShared;
    private FactoryResetParticipantWithCallback navigationResetParticipant;

    public MapViewerMapSwitchStateAtKombi(MapViewerMapSwitchTargetHSM mapViewerMapSwitchTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerMapSwitchTargetHSM;
        this.datapoolShared = MapViewerDatapoolShared.getInstance();
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
            case 1074841846: {
                this.handleMapKombiSetInvisible();
                break;
            }
            case 1074841845: {
                this.handleMapKombiSetVisible();
                break;
            }
            case 1073742385: {
                this.handleASLNavigationMapSetupPerspectiveSet(eventGeneric);
                break;
            }
            case 3499028: {
                this.handleASLNavigationMapMainActivateFinalDestinationZoom();
                break;
            }
            case 3499029: {
                this.handleASLNavigationMapMainActivateDestinationZoom();
                break;
            }
            case 1073742416: {
                this.handleASLNavigationMapViewToggleOverviewZoom();
                break;
            }
            case 1073742406: {
                this.handleASLNavigationMapViewActivateDestinationZoom();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapViewActivateDestinationZoom() {
        this.logger.trace("handleASLNavigationMapViewActivateDestinationZoom()");
        int n = this.datapoolShared.getMapViewer3Resolution();
        this.target.notifierDSI.viewFreeze(true);
        if (2 == n) {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DESTINATION_FPK_ENTRY);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
        } else {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
        }
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleASLNavigationMapViewToggleOverviewZoom() {
        this.logger.trace("handleASLNavigationMapViewToggleOverviewZoom()");
        this.target.notifierDSI.viewFreeze(true);
        int n = this.datapoolShared.getMapViewer3Resolution();
        if (2 == n) {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_OVERVIEW_FPK_ENTRY);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OVERVIEW_FPK_ENTRY);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OVERVIEW_FPK_ENTRY);
        } else {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_OVERVIEW);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
        }
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleASLNavigationMapMainActivateDestinationZoom() {
        this.logger.trace("handleASLNavigationMapMainActivateDestinationZoom()");
        int n = this.datapoolShared.getMapViewer3Resolution();
        this.target.notifierDSI.viewFreeze(true);
        if (2 == n) {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DESTINATION_FPK_ENTRY);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
        } else {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
        }
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleASLNavigationMapMainActivateFinalDestinationZoom() {
        this.logger.trace("handleASLNavigationMapMainActivateFinalDestinationZoom()");
        int n = this.datapoolShared.getMapViewer3Resolution();
        this.target.notifierDSI.viewFreeze(true);
        if (2 == n) {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DESTINATION_FPK_ENTRY);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
        } else {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
        }
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleASLNavigationMapSetupPerspectiveSet(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet()");
        int n = eventGeneric.getInt(0);
        this.setPerspective(n);
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
        this.target.datapool.setMapFPKSwitchRunning(true);
        this.target.notifierDSI.viewFreeze(true);
        if (2 == this.datapoolShared.getMapViewer3Resolution()) {
            this.target.notifierDSI.setScreenViewport(ASLNavigationMapConfiguration.SCREEN_VIEW_PORT_MAP_KOMBI_FPK_ENTRY_HIGH);
        }
        if (this.target.datapool.isPerspectiveOverviewZoom()) {
            this.setOverviewMapConfig();
        } else if (this.target.datapool.isPerspectiveDestinationZoom()) {
            this.handleASLNavigationMapMainActivateDestinationZoom();
        } else {
            this.setPerspective(this.target.datapool.getMainMapPerspective());
        }
        this.setMapMode();
        this.centerMapIfMapWasMovedAndSetZoomLevel();
        this.target.notifierDSI.viewFreeze(false);
    }

    private void setPerspective(int n) {
        int n2 = this.datapoolShared.getMapViewer3Resolution();
        switch (n) {
            case 0: {
                this.target.notifierDSI.setViewType(0);
                this.target.notifierDSI.setOrientation(2);
                if (2 == n2) {
                    this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_2D3D_FPK_ENTRY);
                    this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
                    this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
                    break;
                }
                this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
                this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
                this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
                break;
            }
            case 1: {
                this.target.notifierDSI.setViewType(0);
                this.target.notifierDSI.setOrientation(0);
                if (2 == n2) {
                    this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_2D3D_FPK_ENTRY);
                    this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_3D_HEADING_FPK_ENTRY);
                    this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_3D_HEADING_FPK_ENTRY);
                    break;
                }
                this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
                this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_3D_AND_2D_HEADING);
                this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_3D_AND_2D_HEADING);
                break;
            }
            case 2: 
            case 4: {
                this.target.notifierDSI.setViewType(1);
                this.target.notifierDSI.setOrientation(0);
                if (2 == n2) {
                    this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_2D3D_FPK_ENTRY);
                    this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_3D_HEADING_FPK_ENTRY);
                    this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_3D_HEADING_FPK_ENTRY);
                    break;
                }
                this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
                this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_3D_AND_2D_HEADING);
                this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_3D_AND_2D_HEADING);
                break;
            }
            default: {
                this.target.notifierDSI.setViewType(0);
                this.target.notifierDSI.setOrientation(2);
                if (2 == n2) {
                    this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_2D3D_FPK_ENTRY);
                    this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
                    this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_2D_NORTH_FPK_ENTRY);
                    break;
                }
                this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
                this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
                this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            }
        }
    }

    private void centerMapIfMapWasMovedAndSetZoomLevel() {
        if (this.target.datapool.isMapMoved()) {
            this.logger.trace("center map as it was mpved before switch");
            this.target.notifierModel.notifyMapMovedFalse();
            this.target.datapool.setMapMoved(false);
            if (this.target.datapool.isAutozoomDeactivatedWhileDrag()) {
                this.target.notifierModel.notifyAutoZoomEnabled();
                this.target.datapool.setAutoZoomMainMap(true);
                this.target.notifierDSI.setZoomLevel(this.target.datapool.getAutoZoomRecommendedZoomLast());
                this.target.notifierModel.notifyZoomLevelChanged(this.target.datapool.getAutoZoomRecommendedZoomLast());
                return;
            }
            this.target.notifierDSI.setZoomLevel(this.target.datapool.getMainMapZoomLevel());
        }
    }

    private void setMapMode() {
        this.logger.trace("setMapMode()");
        if (this.target.datapool.isPerspectiveDestinationZoom() || this.target.datapool.isPerspectiveFinalDestinationZoom()) {
            this.target.notifierDSI.setMapModeDestinationMap();
        } else if (this.target.datapool.isPerspectiveOverviewZoom()) {
            this.target.notifierDSI.setMapModeOverviewMap();
        } else {
            this.target.notifierDSI.setMapModePositionMap();
        }
    }

    private void setOverviewMapConfig() {
        this.logger.trace("setOverviewMapConfig()");
        this.target.notifierDSI.setViewType(0);
        this.target.notifierDSI.setOrientation(2);
        int n = this.datapoolShared.getMapViewer3Resolution();
        if (2 == n) {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_OVERVIEW_FPK_ENTRY);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OVERVIEW_FPK_ENTRY);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OVERVIEW_FPK_ENTRY);
        } else {
            this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_OVERVIEW);
            this.target.notifierDSI.setHotPoint(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
            this.target.notifierDSI.setCarPosition(ASLNavigationMapConfiguration.HOT_POINT_OTHERS);
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
        this.target.notifierModel.notifyKombiMapInvisible();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleMapKombiSetVisible() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleMapKombiSetVisible()").log();
        }
        this.target.notifierModel.notifyKombiMapVisible();
        this.target.notifierDSI.viewSetVisible();
        this.target.datapool.setViewVisible(true);
    }

    private void handleMapKombiSetInvisible() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleMapKombiSetInvisible()").log();
        }
        this.target.notifierModel.notifyKombiMapInvisible();
        this.target.notifierDSI.viewSetInvisible();
        this.target.datapool.setViewVisible(false);
    }

    @Override
    public void handleNavigationSettingsReset() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleNavigationSettingsReset() - Switching to ABT").log();
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToABT();
        this.navigationResetParticipant.notifyResetDone();
    }

    @Override
    public void reloadPersistedData() {
        this.setPerspective(this.target.datapool.getMainMapPerspective());
    }
}

