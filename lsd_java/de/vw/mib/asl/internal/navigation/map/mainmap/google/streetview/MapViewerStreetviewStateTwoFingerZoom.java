/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerStreetviewStateTwoFingerZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewStateTwoFingerZoom]");
    private final MapViewerStreetviewTargetHSM target;

    public MapViewerStreetviewStateTwoFingerZoom(MapViewerStreetviewTargetHSM mapViewerStreetviewTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerStreetviewTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1074841896: {
                this.handleTwoFingerZoom(eventGeneric);
                break;
            }
            case 0x40000AAA: {
                this.handleSetClickInStreetView(eventGeneric);
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
            this.logger.makeTrace().append("handleDefault(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleSetClickInStreetView(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        this.handleSetClickInStreetViewReleased();
    }

    private void handleSetClickInStreetViewReleased() {
        this.target.transStateStreetView();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleTwoFingerZoom(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleTwoFingerZoom(x=").append(n).append(", y=").append(n2).append(", zDelta=").append(n3).append(", zDistance=").append(n4).append(")").log();
        }
        int n5 = this.target.datapool.getTwoFingerZDistance();
        float f2 = this.target.datapool.getZoomLevel();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("zoomLevelCurrent= ").append(f2).append(", zDistanceCurrent=").append(n5).log();
        }
        float f3 = (float)n5 / (float)n4;
        float f4 = f2 / f3;
        float[] fArray = this.target.datapool.getZoomList();
        int n6 = this.target.datapool.getZoomListIndexMin();
        int n7 = this.target.datapool.getZoomListIndexMax();
        if (f4 > fArray[n6]) {
            f4 = fArray[n6];
        } else if (f4 < fArray[n7]) {
            f4 = fArray[n7];
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("zoomLevelNew = ").append(f4).log();
        }
        this.target.notifierDSI.streetViewSetZoomLevel(f4);
        this.updateZoomListIndex(f4, f2);
        this.target.datapool.setZoomLevel(f4);
        this.target.datapool.setTwoFingerZDistance(n4);
    }

    private void updateZoomListIndex(float f2, float f3) {
        int n = 0;
        if (f2 == f3) {
            return;
        }
        if (f2 > f3) {
            if (f2 < 2.0f) {
                n = 0;
            } else if (f2 >= 2.0f && f2 < 16448) {
                n = 1;
            } else if (f2 >= 16448 && f2 < 32832) {
                n = 2;
            } else if (f2 == 32832) {
                n = 3;
            }
        } else if (f2 < f3) {
            if (f2 <= 1.0f) {
                n = 0;
            } else if (f2 > 1.0f && f2 <= 2.0f) {
                n = 1;
            } else if (f2 > 2.0f && f2 <= 16448) {
                n = 2;
            } else if (f2 > 16448) {
                n = 3;
            }
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("The zoomListIndex '").append(n).append("' was found for zoomLevel '").append(f2).append("'.").log();
        }
        this.target.datapool.setZoomListIndex(n);
        this.target.presetZoomLevelAndIndexStreetView();
    }
}

