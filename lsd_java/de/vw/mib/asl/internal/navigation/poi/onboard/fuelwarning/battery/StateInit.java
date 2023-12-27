/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.Events;
import de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery.HsmTargetBattery;
import de.vw.mib.asl.internal.navigation.poi.setup.PersistedPoiSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateInit
extends AbstractHsmState {
    private HsmTargetBattery target;
    public static final int EV_ASL_INT_CHECK_INIT_STATE;
    public static final int EV_ASL_INT_CHECK_INIT_STATE_INTERVAL_MS;

    StateInit(HsmTargetBattery hsmTargetBattery, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetBattery;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.initPersistence();
                Events.addObservers(this.target);
                this.target.initDSI();
                this.target.triggerMe(75956480);
                this.target.startTimer(75956480, (long)0, true);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                this.target.stopTimer(75956480);
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_CHECK_INIT_STATE");
                if (!this.target.services.isDsiRegistered()) break;
                if (!this.target.isRemainingRangeValid()) {
                    this.trans(this.target.stateRemainingRangeNotValid);
                    break;
                }
                if (this.target.isRgActive) {
                    this.trans(this.target.stateIdleRgActive);
                    break;
                }
                this.trans(this.target.stateIdleRgNotActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void initPersistence() {
        this.target.traceState(this, "initPersistence()");
        this.target.isDestinationWarning = PersistedPoiSetup.getInstance().getFuelOptionsDestinationRangeWarning();
        this.target.isHomeWarning = PersistedPoiSetup.getInstance().getFuelOptionsDestinationHomeWarning();
        this.target.preventValueInconsistence(this);
    }
}

