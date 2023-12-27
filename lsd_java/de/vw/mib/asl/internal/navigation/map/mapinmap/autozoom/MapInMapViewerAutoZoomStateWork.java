/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerAutoZoomStateWork
extends AbstractHsmState {
    private IExtLogger logger;
    private MapInMapViewerAutoZoomTargetHsm target;

    public MapInMapViewerAutoZoomStateWork(MapInMapViewerAutoZoomTargetHsm mapInMapViewerAutoZoomTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerAutoZoomTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerAutoZoomTargetHsm;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerAutoZoomStateWork]");
    }

    public HsmState dsiMapViewerZoomEngineUpdateRecommendedZoom(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerZoomEngineUpdateRecommendedZoom( recommendedZoom=").append(f2).append(" )").log();
        }
        if (this.isAutoZoomPossible()) {
            int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(f2);
            int n3 = (int)(MapViewerUtils.calculateZoomLevelByZoomIndex(n2) / 51266);
            this.target.notifierDSI.setZoomLevel(f2);
            this.target.notifierModel.notifyZoomLevelChanged(n3);
        }
        return null;
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
            case 0x40000244: {
                this.handleToggleMapAutoZoom();
                break;
            }
            case 3499059: {
                this.handlePerspectiveChanged();
                break;
            }
            case 3499060: {
                this.handleZoomLevelChanged();
                break;
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
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(", Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handlePerspectiveChanged() {
        this.logger.trace("handlePerspectiveChanged()");
        if (!this.isAutoZoomPossible()) {
            return;
        }
        this.handleToggleMapAutoZoom();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleToggleMapAutoZoom() {
        this.target.datapool.setAutoZoomMapInMap(!this.target.datapool.isAutoZoomMapInMap());
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("toogleAutoZoomMapInMap(").append(this.target.datapool.isAutoZoomMapInMap()).append(") ").log();
        }
        if (!this.target.datapool.isAutoZoomMapInMap()) {
            this.target.notifierModel.notifyMapAutoZoomInactive();
            return;
        }
        this.target.notifierModel.notifyMapAutoZoomActive();
        if (this.isAutoZoomPossible()) {
            this.logger.trace("toogleAutoZoomMapInMap() AutoZoom=ON");
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("toogleAutoZoomMapInMap set recommendedZoom=").append(this.target.datapool.getAutoZoomRecommendedZoomLast()).log();
            }
            float f2 = this.target.datapool.getAutoZoomRecommendedZoomLast();
            this.target.notifierDSI.setZoomLevel(f2);
            int n = MapViewerUtils.calculateZoomLevelNormalized(f2);
            this.target.notifierModel.notifyZoomLevelChanged(n);
        } else {
            this.logger.warn("autozoom level not set because the carsor is not infocus");
        }
    }

    private void handleZoomLevelChanged() {
        this.logger.trace("handleZoomLevelChanged(()");
        this.target.datapool.setAutoZoomMapInMap(false);
        this.target.notifierModel.notifyMapAutoZoomInactive();
    }

    private boolean isAutoZoomPerspectiveActive() {
        if (this.target.datapool.isPerspective2DNorthUpActive()) {
            return true;
        }
        if (this.target.datapool.isPerspective2DCarUpActive()) {
            return true;
        }
        return this.target.datapool.isPerspective3DCarUpActive();
    }

    private boolean isAutoZoomPossible() {
        if (!this.target.datapool.isAutoZoomMapInMap()) {
            return false;
        }
        return this.isAutoZoomPerspectiveActive();
    }
}

