/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.guidance.congestion.Events;
import de.vw.mib.asl.internal.navigation.guidance.congestion.HsmTargetCongestionAhead;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.BlockElement;

public class StateWork
extends AbstractHsmState {
    private HsmTargetCongestionAhead target;

    StateWork(HsmTargetCongestionAhead hsmTargetCongestionAhead, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetCongestionAhead;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 101001: {
                this.target.traceState(this, "NAVI_TARGET_GO_ON");
                Events.addObservers(this.target);
                this.target.initDSI();
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
            case 1073744096: {
                this.target.traceState(this, "SET_CONGESTION_AHEAD_LENGTH_VALUES");
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                this.target.modelNotifier.notifyCongestionAheadLength(n);
                if (n2 == 1) {
                    n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().milesToKm(n);
                }
                this.target.modelNotifier.notifyCongestionAheadLengthKmValue(n);
                this.target.blockingLength = n;
                this.target.trace(new StringBuffer("Congestion length: ").append(n).toString());
                this.target.trace(new StringBuffer("Congestion unit: ").append(n2).toString());
                break;
            }
            case 1073742345: {
                this.target.trace("HsmTargetCongestionAhead: ASL_NAVIGATION_GUIDANCE_CONFIRM_CONGESTION");
                this.target.dsiNotifier.blockRouteBasedOnLength(this.getBlockingOffset(), this.getBlockingLength());
                break;
            }
            case 100101: 
            case 1073742347: {
                this.target.trace("HsmTargetCongestionAhead: ASL_NAVIGATION_GUIDANCE_DELETE_CONGESTION");
                this.target.deleteCongestionEvent = eventGeneric;
                this.target.deleteCongestionEvent.setBlocked(true);
                this.target.dsiNotifier.deleteBlock(new long[]{this.target.blockingId});
                this.target.modelNotifier.notifyCongestionAheadLength(0);
                this.target.modelNotifier.notifyCongestionAheadLengthKmValue(0);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public int getBlockingLength() {
        return this.target.blockingLength;
    }

    int getBlockingOffset() {
        INavGateway iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
        return (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistanceFromCCPToFinalDest(iNavGateway.getRgInfoForNextDestination(), iNavGateway.getRgCurrentRoute(), iNavGateway.getRgDestinationInfo());
    }

    public void dsiBlockingBlockRouteBasedOnLengthResult(long l, int n) {
        this.target.trace("HsmTargetCongestionAhead:  received dsiBlockingBlockRouteBasedOnLengthResult");
        if (n == 0) {
            this.target.blockingId = l;
            this.target.modelNotifier.notifyCongestionDefined(true);
        } else {
            this.target.blockingId = -1L;
            this.target.modelNotifier.notifyCongestionDefined(false);
        }
    }

    public void dsiBlockingUpdateListOfBlocks(BlockElement[] blockElementArray, int n) {
        if (blockElementArray != null && blockElementArray.length > 0) {
            this.target.blockingId = blockElementArray[0].uid;
            this.target.modelNotifier.notifyCongestionDefined(true);
        } else {
            this.target.modelNotifier.notifyCongestionDefined(false);
            this.target.modelNotifier.notifyCongestionAheadLength(0);
            this.target.blockingId = -1L;
        }
    }

    public void dsiBlockingDeleteBlockResult(long[] lArray, int n) {
        if (n == 0 && lArray != null && lArray.length > 0 && lArray[0] == this.target.blockingId) {
            this.target.modelNotifier.notifyCongestionDefined(false);
            this.target.blockingId = -1L;
            if (this.target.deleteCongestionEvent != null) {
                this.target.deleteCongestionEvent.setAnswer(true);
                this.target.sendBack(this.target.deleteCongestionEvent);
            }
        }
    }

    public void dsiBlockingUpdateNaviCoreAvailableToSetBlocks(int n, int n2) {
        this.target.trace("HsmTargetCongestionAhead:  received dsiBlockingUpdateNaviCoreAvailableToSetBlocks");
        if (n == 0) {
            this.target.isNaviCoreAvailableToSetBlocks = true;
            this.target.modelNotifier.notifyNaviCoreReadyForBlock(true);
        } else {
            this.target.isNaviCoreAvailableToSetBlocks = false;
            this.target.modelNotifier.notifyNaviCoreReadyForBlock(false);
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.trace("HsmTargetCongestionAhead:  received dsiNavigationUpdateRgActive");
        if (!bl) {
            this.target.modelNotifier.notifyCongestionDefined(false);
            this.target.modelNotifier.notifyCongestionAheadLength(0);
            this.target.blockingId = -1L;
        }
    }
}

