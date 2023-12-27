/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.list;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.list.AbstractListState;
import de.vw.mib.asl.internal.radio.sdars.list.SatListTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatListStateTop
extends AbstractListState {
    SatListStateTop(SatDb satDb, SatListTarget satListTarget, HsmState hsmState) {
        super(satDb, satListTarget, satListTarget.getHsm(), "Top", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(40, this.getName());
                break;
            }
            case 3: {
                this.mTarget.transStateInactive();
                break;
            }
            case 8: {
                this.mTarget.addObserver(-1459355584);
                this.mTarget.addObserver(-1593573312);
                this.mTarget.addObserver(1510211648);
                this.mTarget.addObserver(1526988864);
                this.mTarget.addObserver(1778647104);
                this.mTarget.addObserver(1795424320);
                this.mTarget.addObserver(1812201536);
                this.mTarget.addObserver(1392771136);
                this.mTarget.addObserver(0x50040040);
                this.mTarget.addObserver(0x4C040040);
                int n = this.mTarget.getTargetId();
                this.mPool.addListener(15, n, 1787232512);
                this.mPool.addListener(54, n, 1753678080);
                this.mPool.addListener(65, n, 1804009728);
                this.mPool.addListener(37, n, 1837564160);
                this.mPool.addListener(69, n, 1854341376);
                break;
            }
            case 9: {
                this.mTarget.removeObserver(-1459355584);
                this.mTarget.removeObserver(-1593573312);
                this.mTarget.removeObserver(1510211648);
                this.mTarget.removeObserver(1526988864);
                this.mTarget.removeObserver(1778647104);
                this.mTarget.removeObserver(1795424320);
                this.mTarget.removeObserver(1812201536);
                this.mTarget.removeObserver(1392771136);
                this.mTarget.removeObserver(0x50040040);
                this.mTarget.removeObserver(0x4C040040);
                int n = this.mTarget.getTargetId();
                this.mPool.removeListener(15, n, 1787232512);
                this.mPool.removeListener(54, n, 1753678080);
                this.mPool.removeListener(65, n, 1804009728);
                this.mPool.removeListener(37, n, 1837564160);
                this.mPool.removeListener(69, n, 1854341376);
                break;
            }
            default: {
                SatDb.logEvent("-List", eventGeneric);
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

