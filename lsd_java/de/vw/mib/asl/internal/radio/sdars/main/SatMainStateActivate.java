/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioCurrentWaveband;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.asl.internal.radio.tile.list.TileStationList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatMainStateActivate
extends AbstractMainState {
    SatMainStateActivate(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateActivate", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                this.mPool.setEvent(44, null);
                this.mPool.setString(45, "start booting SDARS");
                break;
            }
            case 3: {
                this.mPool.incInt(78);
                this.mTarget.transActivate1();
                break;
            }
            case 4: {
                EventGeneric eventGeneric2 = this.mPool.getEvent(44);
                EventGeneric eventGeneric3 = this.mPool.getEvent(43);
                if (eventGeneric3 != null) {
                    eventGeneric3.setBlocked(false);
                    eventGeneric3.setResult(eventGeneric2 == null ? 0 : 11);
                    this.mTarget.sendBack(eventGeneric3);
                    this.mPool.setEvent(43, null);
                }
                if (eventGeneric2 == null) break;
                eventGeneric2.setBlocked(false);
                eventGeneric2.setResult(0);
                this.mTarget.sendBack(eventGeneric2);
                this.mPool.setEvent(44, null);
                break;
            }
            case 4000021: {
                int n = eventGeneric.getInt(0);
                if (n == 2) {
                    this.mTarget.restartActivation();
                    this.getAudioManager().setAudioAvailable(true);
                    break;
                }
                if (n == 0 || n != 1) break;
                break;
            }
            case 100240: {
                eventGeneric.setBlocked(true);
                this.mPool.setEvent(44, eventGeneric);
                break;
            }
            case 100241: {
                eventGeneric.setBlocked(true);
                GuiApiTunerCommon.updateCurrentBand(RadioCurrentWaveband.get());
                this.mPool.setEvent(43, eventGeneric);
                EventGeneric eventGeneric4 = this.mDb.newEvent();
                eventGeneric4.setBoolean(1652701952, true);
                eventGeneric4.setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                this.mTarget.triggerObserver(1635924736, eventGeneric4);
                try {
                    TileStationList tileStationList;
                    if (!RadioCodingAdapter.isRadioTileFeatureActivated() || null == (tileStationList = RadioServiceManager.getServiceManager().getTileStationList())) break;
                    tileStationList.initTiles();
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

