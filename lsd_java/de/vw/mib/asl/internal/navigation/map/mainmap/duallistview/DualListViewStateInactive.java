/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class DualListViewStateInactive
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewStateInactive]");
    final DualListViewHsmTarget target;

    public DualListViewStateInactive(DualListViewHsmTarget dualListViewHsmTarget, String string, HsmState hsmState) {
        super(dualListViewHsmTarget.getHsm(), string, hsmState);
        this.target = dualListViewHsmTarget;
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
                this.handleSetContent(eventGeneric);
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

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 31) {
            this.logger.trace("handleSetContent( content = 31 )");
            this.target.datapool.setContent(n);
            this.target.transStateActive();
        } else if (n == 30) {
            this.logger.trace("handleSetContent( content = 30 )");
            this.target.datapool.setContent(n);
            this.target.transStateActive();
        } else if (n == 35) {
            this.logger.trace("handleSetContent( content = 35 )");
            this.target.datapool.setContent(n);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1608594176);
            eventGeneric2.setBoolean(0, true);
            this.target.send(eventGeneric2);
            this.target.transStateActive();
        } else if (n == 36) {
            this.logger.trace("handleSetContent( content = 36 )");
            this.target.datapool.setContent(n);
            this.target.transStateActive();
        } else if (n == 38) {
            this.logger.trace("handleSetContent( content = 39 )");
            this.target.datapool.setContent(n);
            this.target.transStateActive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierDSI.setEnableSoftJump(true);
        this.target.datapool.setFlagLocations(null);
        if (this.target.datapool.isShowTmcMessageWasActive()) {
            this.target.datapool.setShowTmcMessageWasActive(false);
            this.target.notifierDSI.setTMCVisibility(true);
        }
        if (this.target.datapool.isGeneralPOIVisibilityWasActive()) {
            this.target.datapool.setGeneralPOIVisibilityWasActive(false);
            this.target.notifierDSI.setGeneralPoiVisibility(true);
        }
    }
}

