/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.AbstractListState;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatListStateSortingCategory
extends AbstractListState {
    private final SatDb mSatDb;

    SatListStateSortingCategory(SatDb satDb, SatListTarget satListTarget, HsmState hsmState) {
        super(satDb, satListTarget, satListTarget.getHsm(), "SortingCategory", hsmState);
        this.mSatDb = satDb;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(40, this.getName());
                this.mSatDb.setChannelSorting(true);
                this.mSatDb.getSatPrepareChannelList().showCurrentChannel();
                this.mPool.incInt(185);
                break;
            }
            case 1073743017: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().showCurrentChannel();
                this.mPool.incInt(185);
                break;
            }
            case 1073742938: {
                this.mSatDb.setChannelSorting(false);
                int n = eventGeneric.getInt(0);
                this.mSatDb.getSatPrepareChannelList().updateOpenCategory(n);
                this.mSatDb.getSatPrepareChannelList().updateChannelList();
                break;
            }
            case 1073742939: {
                this.mSatDb.setChannelSorting(false);
                short s = (short)eventGeneric.getLong(0);
                this.mSatDb.getSatPrepareChannelList().updateOpenCategoryByID(s);
                this.mSatDb.getSatPrepareChannelList().updateChannelList();
                break;
            }
            case 100202: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().showCurrentChannel();
                break;
            }
            case 100200: 
            case 100203: 
            case 100205: 
            case 100206: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().completeUpdate();
                break;
            }
            case 100201: {
                this.mSatDb.setChannelSorting(false);
                this.mSatDb.getSatPrepareChannelList().showCurrentChannel();
                break;
            }
            case 1073742955: {
                this.mPool.setInt(150, 1);
                this.mTarget.transStateSortingName();
                break;
            }
            case 1073742956: {
                this.mPool.setInt(150, 2);
                this.mTarget.transStateSortingNumber();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

