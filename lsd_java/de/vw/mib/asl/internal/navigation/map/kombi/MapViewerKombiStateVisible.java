/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateMain;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateVisible
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateVisible]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateVisible(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateViewVisible(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewVisible(visible=").append(bl).append(")").log();
        }
        if (bl) {
            this.target.notifierModel.notifyKombiMapVisible();
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
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
            case 1073744564: {
                int n = eventGeneric.getInt(0);
                if (!ServiceManager.configManagerDiag.isFeatureFlagSet(70)) break;
                switch (n) {
                    case -128: {
                        this.target.datapool.setAutozoomActive(false);
                        this.target.transStateMapScaleContinuousOut();
                        break block0;
                    }
                    case 127: {
                        this.target.datapool.setAutozoomActive(false);
                        this.target.transStateMapScaleContinuousIn();
                        break block0;
                    }
                    case 0: {
                        if (this.target.datapool.isAutozoomActive()) {
                            this.target.datapool.setAutozoomActive(false);
                            MapViewerKombiStateMain.updateMapScaleInBAP(this.target.datapool.getZoomLevel() / 100, false);
                            break block0;
                        }
                        this.target.datapool.setAutozoomActive(true);
                        int n2 = this.target.datapool.getAutoZoomRecommendedZoomLast();
                        MapViewerKombiStateMain.updateMapScaleInBAP(n2 / 100, true);
                        this.target.notifierDSI.setZoomLevel(n2);
                        break block0;
                    }
                    case -1: 
                    case 1: {
                        this.handleSetZoom(n);
                        break block0;
                    }
                }
                this.logger.warn("MapViewerKombiStateMapScaleContinuous got map scale events with step value out of handled.");
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
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.target.datapool.isAutozoomActive()) {
            int n = this.target.datapool.getAutoZoomRecommendedZoomLast();
            this.logger.trace(new StringBuffer().append("Map in FPK visible again. Restoring last recommended zoom ").append(n).toString());
            this.target.datapool.setZoomLevel(n);
            this.target.datapool.setRecommendedZoom(n);
        } else {
            this.target.datapool.setRecommendedZoom(MapViewerUtils.checkZoomLevelIsInRange(this.target.datapool.getZoomLevel()));
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        int n = this.target.datapool.getZoomLevel();
        this.target.notifierDSI.setZoomLevel(n);
        MapViewerKombiStateMain.updateMapScaleInBAP(n / 100, this.target.datapool.isAutozoomActive());
        this.target.notifierDSI.viewSetVisible();
    }

    void handleSetZoom(int n) {
        this.logger.trace("handleSetZoom()");
        this.target.datapool.setAutozoomActive(false);
        int n2 = MapViewerUtils.calculateZoomListIndexForKombiNew(n);
        int n3 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetZoom: set zoom level in FPK to new value ").append(n3).log();
        }
        int n4 = n3 / 100;
        MapViewerKombiStateMain.updateMapScaleInBAP(n4, false);
        this.target.notifierDSI.setZoomLevel(n3);
        this.target.datapool.setZoomLevel(n3);
    }
}

