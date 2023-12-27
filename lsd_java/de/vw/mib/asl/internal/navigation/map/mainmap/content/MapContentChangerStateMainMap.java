/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapContentChangerStateMainMap
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateMainMap]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateMainMap(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
        super(mapContentChangerTargetHSM.getHsm(), string, hsmState);
        this.target = mapContentChangerTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742382: {
                return this.handleSetContent(eventGeneric);
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(", params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setMapInMainScreen(false);
        this.target.datapool.setZoomLevelMainMapBackup(this.target.datapool.getMainMapZoomLevel());
        this.target.datapool.setZoomLevelOverviewMapBackup(this.target.datapool.getMainMapZoomCurrentLevel());
        this.target.notifierDSI.setMobilityHorizonVisibility(false);
    }

    private HsmState handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n != 0) {
            return this.myParent;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content=").append(n).append(")").log();
        }
        this.target.datapool.setMainMapContent(n);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139) && this.target.datapool.isMapLocatedInKombi() && !this.target.datapool.isMapFPKSwitchRunning()) {
            this.logger.trace("SetContent will be ignored because map is in FPK");
            return null;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        int n5 = eventGeneric.getInt(4);
        Integer n6 = new Integer(n);
        Rect rect = new Rect(n2, n3, n5, n4);
        this.target.datapool.getStoredZoomAreas().put(n6, rect);
        this.target.datapool.setZoomArea(rect);
        Point point = MapViewerUtils.calculateHotPointByZoomArea(rect);
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setZoomArea(rect);
        this.target.notifierDSI.setHotPoint(point);
        if (this.target.datapool.isPerspectiveFinalDestinationZoom()) {
            this.target.notifierDSI.setLocation(1, (short)0);
        }
        this.target.notifierDSI.viewFreeze(false);
        return null;
    }

    private void handleStart() {
        boolean bl;
        this.logger.trace("handleStart()");
        this.target.datapool.setMapInMainScreen(true);
        this.target.datapool.setChMapInputDetailViewZoomSet(false);
        this.target.datapool.getStoredZoomAreas().clear();
        Rect rect = this.target.datapool.getZoomArea();
        boolean bl2 = bl = ServiceManager.configManagerDiag.isFeatureFlagSet(369) && this.target.datapool.isMapLocatedInKombi();
        if (!this.target.isPerspectiveOverviewType() && !bl) {
            MapViewerUtils.updateMainMapPersistedZoomLevel(this.target.datapool.getZoomLevelMainMapBackup());
        }
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setZoomArea(rect);
        if (this.target.datapool.isNightView()) {
            this.target.notifierDSI.setNightMode();
        }
        this.target.notifierDSI.viewFreeze(false);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(408)) {
            this.target.notifierDSI.resetLayers();
        }
        this.target.notifierDSI.setRouteVisibility(this.target.datapool.isPnavRouteVisibility());
        this.target.sendEventContentReadyMainSetup();
        this.target.notifierDSI.viewSetVisible(true);
    }
}

