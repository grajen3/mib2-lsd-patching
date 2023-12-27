/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.AbstractListState;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatListStateSortingNumber
extends AbstractListState {
    private final SatDb mSatDb;

    SatListStateSortingNumber(SatDb satDb, SatListTarget satListTarget, HsmState hsmState) {
        super(satDb, satListTarget, satListTarget.getHsm(), "SortingNumber", hsmState);
        this.mSatDb = satDb;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(40, this.getName());
                this.mSatDb.setChannelSorting(true);
                this.mSatDb.getSatPrepareChannelList().updateChannelListNo();
                this.mPool.incInt(185);
                break;
            }
            case 1073743017: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().updateChannelListNo();
                this.mPool.incInt(185);
                break;
            }
            case 100200: 
            case 100203: 
            case 100205: 
            case 100206: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().updateChannelListNo();
                break;
            }
            case 100202: {
                break;
            }
            case 1073742954: {
                this.mPool.setInt(150, 0);
                this.mTarget.transStateSortingCategory();
                break;
            }
            case 1073742955: {
                this.mPool.setInt(150, 1);
                this.mTarget.transStateSortingName();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

