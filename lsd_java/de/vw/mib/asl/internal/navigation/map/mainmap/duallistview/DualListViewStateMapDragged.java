/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class DualListViewStateMapDragged
extends AbstractHsmState {
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewStateMapDragged]");
    private final DualListViewHsmTarget target;
    private final DualListViewDatapool datapool;

    public DualListViewStateMapDragged(DualListViewHsmTarget dualListViewHsmTarget, String string, HsmState hsmState) {
        super(dualListViewHsmTarget.getHsm(), string, hsmState);
        this.target = dualListViewHsmTarget;
        this.datapool = dualListViewHsmTarget.datapool;
    }

    public void dsiMapViewerControlAsyncException(int n, String string, int n2) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("dsiMapViewerControlAsyncException(), reqType=").append(n2).append(",errMsg=").append(string).log();
        }
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
            case 1074841837: {
                return this.handleSetClickInMap(eventGeneric);
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleDefault(), event=").append(eventGeneric.toString()).log();
        }
    }

    private void handleEntry() {
        this.LOGGER.trace("handleEntry()");
    }

    private void handleExit() {
        this.LOGGER.trace("handleExit()");
        this.datapool.setDragged(true);
    }

    private void handleStart() {
        this.LOGGER.trace("handleStart()");
    }

    private void handleSetClickInMainMapDragged(EventGeneric eventGeneric) {
        this.LOGGER.trace("handleSetClickInMainMapDragged()");
        this.target.updateDraggedXandY(eventGeneric);
        this.moveMapToDraggedCoordiantes();
    }

    private void handleSetClickInMainMapReleased(EventGeneric eventGeneric) {
        this.LOGGER.trace("handleSetClickInMainMapReleased()");
        this.target.updateDraggedXandY(eventGeneric);
        this.target.notifierDSI.stopScrollToDirection();
        this.target.transStateActive();
    }

    private HsmState handleSetClickInMap(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleSetClickInMap(), actionType=").append(n).log();
        }
        if (n == 1) {
            this.handleSetClickInMainMapDragged(eventGeneric);
        } else if (n == 2) {
            this.handleSetClickInMainMapReleased(eventGeneric);
        } else if (n == 4) {
            this.LOGGER.warn("handleSetClickInMap() - Selected while dragging is ignored, to prevent map-jumping, this must be fixed in the widgets");
        } else {
            return this.myParent;
        }
        return null;
    }

    private void moveMapToDraggedCoordiantes() {
        this.LOGGER.trace("moveMapToDraggedCoordiantes()");
        int n = this.datapool.getSelectedX();
        int n2 = this.datapool.getSelectedY();
        int n3 = this.datapool.getDraggedX();
        int n4 = this.datapool.getDraggedY();
        short s = (short)(n3 - n);
        short s2 = (short)(n4 - n2);
        this.datapool.setSelectedX(n3);
        this.datapool.setSelectedY(n4);
        this.target.notifierDSI.dragMap(s, s2);
    }
}

