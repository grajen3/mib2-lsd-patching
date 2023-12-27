/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.AbstractListState;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatListStateActive
extends AbstractListState {
    SatListStateActive(SatDb satDb, SatListTarget satListTarget, HsmState hsmState) {
        super(satDb, satListTarget, satListTarget.getHsm(), "Active", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(40, this.getName());
                this.mPool.setBoolean(31, true);
                this.mDb.getPool().setChannel(22, null);
                break;
            }
            case 3: {
                int n = this.mPool.getInt(150);
                switch (n) {
                    case 0: {
                        this.mTarget.transStateSortingCategory();
                        break block0;
                    }
                    case 1: {
                        this.mTarget.transStateSortingName();
                        break block0;
                    }
                }
                this.mTarget.transStateSortingNumber();
                break;
            }
            case 4: {
                this.mPool.setBoolean(31, false);
                break;
            }
            case 7: {
                this.mTarget.transStateInactive();
                break;
            }
            case 1073743009: {
                this.mTarget.transStateInactive();
                break;
            }
            case 1073743017: {
                break;
            }
            case 100204: {
                int n = eventGeneric.getInt(0);
                this.mPool.setInt(154, n);
                break;
            }
            case 0x4000044C: 
            case 0x40000450: 
            case 1073742931: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(554);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

