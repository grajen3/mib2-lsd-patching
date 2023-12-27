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

final class SatMainStateInactive
extends AbstractMainState {
    SatMainStateInactive(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateInactive", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(39, this.getName());
                break;
            }
            case 4: {
                break;
            }
            case 100241: {
                Object object;
                GuiApiTunerCommon.updateCurrentBand(RadioCurrentWaveband.get());
                try {
                    if (RadioCodingAdapter.isRadioTileFeatureActivated() && null != (object = RadioServiceManager.getServiceManager().getTileStationList())) {
                        ((TileStationList)object).initTiles();
                    }
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
                eventGeneric.setBlocked(true);
                this.mPool.setEvent(43, eventGeneric);
                object = this.mDb.newEvent();
                ((EventGeneric)object).setBoolean(1652701952, true);
                ((EventGeneric)object).setInt(1669479168, RadioData.getAmfmDatabase().getSettingsPersistable().getWaveband());
                this.mTarget.triggerObserver(1635924736, (EventGeneric)object);
                this.mDb.getHmiUpdater().prepareBapList();
                this.mTarget.transActivate();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

