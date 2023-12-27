/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.startup.HsmTargetAslEventPrinter;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTargetAslEventPrinter$1
extends AbstractHsmState {
    private final /* synthetic */ HsmTargetAslEventPrinter this$0;

    HsmTargetAslEventPrinter$1(HsmTargetAslEventPrinter hsmTargetAslEventPrinter, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTargetAslEventPrinter;
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.registerObservers();
                this.this$0.startTimer(75956480, (long)0, true);
                break;
            }
            case 100100: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(758, true);
                ServiceManager.aslPropertyManager.valueChangedInteger(735, 1);
                break;
            }
            default: {
                this.this$0.printEvent(eventGeneric);
            }
        }
        return null;
    }
}

