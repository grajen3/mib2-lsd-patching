/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.webradio.WebRadioServiceManager;
import de.vw.mib.asl.internal.webradio.main.TargetMainWebRadio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateTopMain
extends AbstractHsmState {
    private boolean powerOnAlreadyReceived = false;

    public StateTopMain(Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        if (ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.trace(2).append("StateTopMain : Event ID = ").append(this.getEventName(eventGeneric.getReceiverEventId())).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.powerOnAlreadyReceived) break;
                this.powerOnAlreadyReceived = true;
                TargetMainWebRadio targetMainWebRadio = WebRadioServiceManager.getServiceManager().getTargetMain();
                if (null == targetMainWebRadio) {
                    ServiceManager.logger2.error(2).append("StateTopMain - handle() - null == targetMainWebRadio").log();
                    break;
                }
                WebRadioServiceManager.getServiceManager().getTargetMain().registerObservers();
                break;
            }
        }
        return null;
    }

    private String getEventName(int n) {
        switch (n) {
            case 2: {
                return "IdEventGeneric.HSM_ENTRY";
            }
            case 3: {
                return "IdEventGeneric.HSM_START";
            }
            case 4: {
                return "IdEventGeneric.HSM_EXIT";
            }
        }
        return String.valueOf(n);
    }
}

