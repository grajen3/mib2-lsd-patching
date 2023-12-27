/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.GuidanceUtils;
import de.vw.mib.asl.internal.navigation.waypointmode.Events;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDataPool;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDsiNotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmModelNotifier;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateInit
extends AbstractHsmState {
    private final HsmTargetWayPointMode target;
    private boolean wasServiceStateListenerRegistered = false;
    private int hmiOffTime = -1;

    public StateInit(HsmTargetWayPointMode hsmTargetWayPointMode, String string, HsmState hsmState) {
        super(hsmTargetWayPointMode.getHsm(), string, hsmState);
        this.target = hsmTargetWayPointMode;
        this.initializeWpmTarget();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                Events.registerASLServices(this.target);
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                break;
            }
            case 101003: {
                this.target.traceState(this, "NAVI_TARGET_PREPARE_ON");
                ASLNavigationUtilFactory.getNavigationUtilApi().getDebugFlags().setAPIDebugFlag(-219213824, true);
                if (this.wasServiceStateListenerRegistered) break;
                ServiceManager.dsiServiceLocator.addServiceStateListener(this.target.getDsiNotifier());
                this.wasServiceStateListenerRegistered = true;
                break;
            }
            case 101001: {
                this.target.traceState(this, "NAVI_TARGET_GO_ON");
                Events.addObservers(this.target);
                break;
            }
            case 4300052: {
                this.target.traceState(this, "VALID_TIME_DATE_AVAILABLE");
                this.checkHmiOffTime();
                this.restoreExecutionMode();
                this.trans(this.target.stateDefault);
                break;
            }
            default: {
                return this.myParent;
            }
        }
        return null;
    }

    private void checkHmiOffTime() {
        long l = ASLSystemFactory.getSystemApi().getCurrentTimestamp();
        if (GuidanceUtils.isSystemTimestampValid(l)) {
            long l2 = PersistedGuidanceSetup.getInstance().getLastTimeStampBeforeHmiOff();
            if (GuidanceUtils.isNaviTimestampValid(l2)) {
                this.hmiOffTime = GuidanceUtils.calculateHmiOffTimeMinutes(l, l2);
                this.target.traceState(this, new StringBuffer("hmiOffTime: ").append(this.hmiOffTime).append(" min").toString());
            } else {
                this.target.traceState(this, "No valid timestamp has been set before shutdown");
            }
        } else {
            this.target.traceState(this, "CurrentTimestamp is not set");
        }
    }

    private void initializeWpmTarget() {
        this.target.setDataPool(new WpmDataPool());
        this.target.setDsiNotifier(new WpmDsiNotifier(this.target));
        this.target.setModelNotifier(new WpmModelNotifier());
        this.target.setInternalAPINotifier(new WpmInternalAPINotifier());
        this.target.requestMediaIndicationService();
        WpmDataPool wpmDataPool = this.target.getDataPool();
        WpmModelNotifier wpmModelNotifier = this.target.getModelNotifier();
        wpmModelNotifier.setSplitScreenContentDefaultMode(wpmDataPool.getSplitScreenCurrentContentDefault());
        wpmModelNotifier.setSplitScreenContentDriveRecordMode(wpmDataPool.getSplitScreenCurrentContentDriveRecord());
        wpmModelNotifier.setSplitScreenActive(wpmDataPool.getSplitScreenActive());
    }

    void restoreExecutionMode() {
        if (this.hmiOffTime < 0 || this.hmiOffTime > 120) {
            this.target.traceState(this, "0 > Clamp15OffTime > 120 -> reset execution mode");
            this.target.changeExecutionMode(0);
        } else {
            this.target.traceState(this, "Clamp15OffTime <= 120 -> restore execution mode");
            this.target.changeExecutionMode(this.target.getDataPool().getExecutionMode());
        }
    }
}

