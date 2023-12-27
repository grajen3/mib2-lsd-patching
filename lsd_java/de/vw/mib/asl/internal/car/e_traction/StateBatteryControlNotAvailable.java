/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.internal.car.e_traction.HsmTargetBatteryManager;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class StateBatteryControlNotAvailable
extends StateBatteryControlBase {
    private boolean initialized;

    public StateBatteryControlNotAvailable(HsmTargetBatteryManager hsmTargetBatteryManager, Hsm hsm, String string, HsmState hsmState) {
        super(hsmTargetBatteryManager, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("BatteryContorl: HSM_ENTRY in state ").append(this.getName()).log();
                }
                if (this.initialized) break;
                this.myTarget.init();
                this.myTarget.registerOnAmPm();
                this.myTarget.registerOnCarHybridViewOptions();
                this.myTarget.addObservers(new int[]{-452198336, -468975552});
                this.initialized = true;
                this.myTarget.getBatterManagerMainController().initValues();
                break;
            }
            case 3: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("BatteryContorl: HSM_START in state ").append(this.getName()).log();
                }
                this.myTarget.getBatterManagerMainController().setBatteryMangerBecomesNotAvailable();
                break;
            }
            case 4: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("BatteryContorl: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiCarHybridUpdateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.myTarget.getBatterManagerMainController().dsiCarHybridUpdateBatteryControlViewOptions(batteryControlViewOptions, n);
        if (this.myTarget.getBatterManagerMainController().isBatteryManagerAvailable()) {
            this.trans(this.myTarget.getStateBatteryControlAvailable());
            this.myTarget.info().append("[INFO] CarHybrid: Battery Manager change to StateBatteryControlAvailable").log();
        } else {
            this.myTarget.error("[ERROR] CarHybrid: FSG does not exists!!! Still in StateBatteryControlNotAvailable");
        }
    }
}

