/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public final class RubberbandStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberbandStateMain]");
    private final RubberBandHsmTarget target;

    public RubberbandStateMain(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
        super(rubberBandHsmTarget.getHsm(), string, hsmState);
        this.target = rubberBandHsmTarget;
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
            case 1074841844: {
                this.handleCancelRouteAdjustment();
                break;
            }
            case 1074841843: {
                this.handleRestartRouteGuidance();
                break;
            }
            case 100100: {
                this.handleRemoveRubberbandMarker();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleRemoveRubberbandMarker() {
        this.logger.trace("handleRemoveRubberbandMarker()");
        if (this.target.datapool.getDrageRouteMarker() != 0) {
            this.target.notifierDSI.setDragRouteMarker(0);
        }
        this.target.sendInternalEvent(1380652032, 92733696);
    }

    private void handleCancelRouteAdjustment() {
        this.logger.trace("handleCancelRouteAdjustment()");
        this.target.transStateCancel();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleRestartRouteGuidance() {
        this.logger.trace("handleRestartRouteGuidance()");
        this.target.datapool.setNeedsRubberbandStart(true);
        CalculatedRouteListElement[] calculatedRouteListElementArray = this.target.datapool.getRgCalculatedRoutes();
        if (calculatedRouteListElementArray == null || calculatedRouteListElementArray.length == 0) {
            return;
        }
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvMapMainRubberbandManipulationStartCalculatedRoute(0);
        this.target.sendHMIEvent(-135327744);
        this.target.transStateRubberBandInactive();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }
}

