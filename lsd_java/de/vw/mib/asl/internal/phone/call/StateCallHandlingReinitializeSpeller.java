/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling;
import de.vw.mib.asl.internal.phone.call.SpellerBlockItem;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateCallHandlingReinitializeSpeller
extends AbstractHsmState {
    private final HsmPhoneCallHandling target;

    public StateCallHandlingReinitializeSpeller(HsmPhoneCallHandling hsmPhoneCallHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneCallHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.target.isMatchingAvailableLastSetByModel) break;
                this.restartSpeller();
                break;
            }
        }
        return this.myParent;
    }

    public void dsiAdbListStopSpellerResult(int n, int n2) {
        this.restartSpeller();
    }

    public void dsiAdbListAsyncException(int n, String string, int n2) {
        if (n2 == 1001) {
            this.dsiAdbListStopSpellerResult(1, -1);
        }
    }

    private void restartSpeller() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5254, 5254, -1542848448);
        String string = "";
        for (int i2 = 0; i2 < this.target.spellerBlocks.size(); ++i2) {
            string = new StringBuffer().append(string).append(((SpellerBlockItem)this.target.spellerBlocks.get((int)i2)).text).toString();
        }
        eventGeneric.setString(0, string);
        eventGeneric.setBoolean(1, this.target.isMatchingAvailableLastSetByModel);
        this.target.send(eventGeneric);
        this.trans(this.target.stateCallHandling);
    }
}

