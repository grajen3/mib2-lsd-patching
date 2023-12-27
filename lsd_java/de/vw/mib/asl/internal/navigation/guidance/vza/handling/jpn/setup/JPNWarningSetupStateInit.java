/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupEvents;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class JPNWarningSetupStateInit
extends AbstractHsmState {
    private JPNWarningSetupHsmTarget target;

    public JPNWarningSetupStateInit(JPNWarningSetupHsmTarget jPNWarningSetupHsmTarget, String string, HsmState hsmState) {
        super(jPNWarningSetupHsmTarget.getHsm(), string, hsmState);
        this.target = jPNWarningSetupHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
    }

    private void handleExit() {
    }

    private void handleStart() {
        JPNWarningSetupEvents.addObservers(this.target);
        this.target.jpnWarningSignsSetupHandling.initWarningMenu();
        this.target.transStateWork();
    }

    private void handleEntry() {
    }
}

