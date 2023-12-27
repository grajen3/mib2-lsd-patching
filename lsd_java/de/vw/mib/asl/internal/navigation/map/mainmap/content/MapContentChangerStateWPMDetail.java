/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateWPMDetail
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateWPMDetail]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateWPMDetail(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
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
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (!this.target.datapool.isViewVisible()) {
            this.target.notifierDSI.viewSetVisible(true);
        }
        this.target.notifierDSI.setZoomArea(this.target.datapool.getZoomArea());
        this.target.notifierDSI.setHotPoint(this.target.datapool.getHotPoint());
    }
}

