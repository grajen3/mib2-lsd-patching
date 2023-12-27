/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.StationInfo;

final class SatMainStateActivateStep0Precondition
extends AbstractMainState {
    private StationInfo mLSM;
    private boolean entertainmentManagerCancelInTune = false;
    private boolean isDefaultChannelTunedAlready = false;

    SatMainStateActivateStep0Precondition(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateActivate0", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                this.entertainmentManagerCancelInTune = false;
                RadioCurrentWaveband.set(3);
                break;
            }
            case 3: {
                int n = this.mPool.getInt(78);
                if (n > 0) {
                    this.mTarget.transActivate1();
                    break;
                }
                int n2 = this.mTarget.getTargetId();
                this.mPool.addListener(147, n2, -1299840768, true);
                break;
            }
            case 4: {
                int n = this.mTarget.getTargetId();
                this.mPool.removeListener(147, n, -1299840768);
                if (!this.entertainmentManagerCancelInTune) break;
                EventGeneric eventGeneric2 = this.mDb.newEvent();
                eventGeneric2.setBoolean(1652701952, true);
                eventGeneric2.setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                this.mTarget.triggerObserver(1635924736, eventGeneric2);
                break;
            }
            case 100018: {
                IAslPoolRecord iAslPoolRecord = (IAslPoolRecord)eventGeneric.getObject(0);
                int n = iAslPoolRecord.getInt();
                switch (n) {
                    case 1: 
                    case 3: 
                    case 4: {
                        this.mLSM = this.mDb.getTuneHandler().getLSM();
                        int n3 = this.mTarget.getTargetId();
                        this.getTuneHandler().tuneChannel(9, this.mLSM, false, n3, -1434058496);
                        break block0;
                    }
                }
                break;
            }
            case 100010: {
                int n = eventGeneric.getInt(2);
                if (this.entertainmentManagerCancelInTune) {
                    if (ServiceManager.logger2.isTraceEnabled(4)) {
                        ServiceManager.logger2.trace(4).append("Radio SDARS PrepareTuning: Tune failure!").log();
                    }
                    this.mTarget.transStateInactive();
                    break;
                }
                int n4 = this.mTarget.getTargetId();
                if (n == 3) {
                    this.mTarget.setTuned(true);
                    this.mTarget.transActivate2();
                    break;
                }
                if (n == 5 && this.mLSM.getStationNumber() != 1 && !this.isDefaultChannelTunedAlready) {
                    ServiceManager.logger.info(512).append("SatMainStateActivateStep0Precondition - handle() - Subscription:").append(n).log();
                    this.isDefaultChannelTunedAlready = true;
                    this.mLSM = SatConfig.DEFAULT_CHANNEL;
                    this.getTuneHandler().tuneChannel(3, this.mLSM, false, n4, -1434058496);
                    break;
                }
                this.mTarget.transActivate2();
                break;
            }
            case 1400006: {
                this.entertainmentManagerCancelInTune = true;
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

