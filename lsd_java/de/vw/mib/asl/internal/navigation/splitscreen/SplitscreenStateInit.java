/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.splitscreen.Events;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitScreenTargetHSM;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenInternalAPINotifier;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class SplitscreenStateInit
extends AbstractHsmState {
    private static final DSIProxy DSI_PROXY = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[SplitscreenStateInit]");
    private final SplitScreenTargetHSM target;

    public SplitscreenStateInit(SplitScreenTargetHSM splitScreenTargetHSM, String string, HsmState hsmState) {
        super(splitScreenTargetHSM.getHsm(), string, hsmState);
        this.target = splitScreenTargetHSM;
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): receiverEventId: ").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
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
        ServiceManager.dsiServiceLocator.addServiceStateListener(this.target);
        this.initASL();
        this.initModel();
        this.target.setInternalAPINotifier(new SplitscreenInternalAPINotifier());
        this.target.transStateWork();
    }

    void initModel() {
        this.logger.trace("initModel()");
        this.target.notifierModel.notifySplitScreenGuidanceChanged(this.target.datapool.isSplitScreenGuidance());
        this.target.notifierModel.notifySplitScreenContentChanged(this.target.datapool.getSplitScreenContentGuidance());
        this.target.notifierModel.notifySplitscreenNoGuidanceChanged(this.target.datapool.isSplitScreenNoGuidance());
        this.target.notifierModel.notifySplitscreenNoGuidanceContentChanged(this.target.datapool.getSplitScreenContentNoGuidance());
    }

    private void initASL() {
        this.logger.trace("initASL()");
        Events.addObservers(this.target);
        Events.registerASLServices(this.target);
    }
}

