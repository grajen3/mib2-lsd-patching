/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.setup.HsmPhoneRingtoneHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StatePhoneRingtoneWaveplayerIdle
extends AbstractHsmState {
    private final HsmPhoneRingtoneHandling target;
    protected short selectedRingtone;
    private static final int EV_RESPONSE_MENU_RINGER_CONNECTION_SET;
    private boolean isTriggered = false;

    public StatePhoneRingtoneWaveplayerIdle(HsmPhoneRingtoneHandling hsmPhoneRingtoneHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneRingtoneHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742888: {
                break;
            }
            case 1073742879: {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                eventGeneric2.setInt(0, 87);
                eventGeneric2.setBoolean(1, true);
                eventGeneric2.setSenderEventId(-1803026176);
                this.target.send(eventGeneric2);
                int n = eventGeneric.getInt(0);
                this.target.dsiWavePlayer.setPlayTone(n);
                this.isTriggered = true;
                this.transTriggeringWhenValid();
                break;
            }
            case 3600005: {
                this.isTriggered = true;
                this.transTriggeringWhenValid();
                break;
            }
            case 4000022: {
                this.target.ringtoneMenuConnectionSet = true;
                this.isTriggered = true;
                this.transTriggeringWhenValid();
                break;
            }
            case 1073742887: {
                this.isTriggered = false;
                hsmState = this.myParent;
                break;
            }
            case 100500: {
                if (eventGeneric.getResult() != 0 || !this.isTriggered) break;
                this.target.ringtoneMenuConnectionSet = true;
                this.transTriggeringWhenValid();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiWavePlayerUpdateAudioRequest(int n, int n2) {
        switch (n) {
            default: 
        }
        this.target.warn(new StringBuffer().append("PhoneRingtoneHandlingIdle: Unexpected player state ").append(n).append("!").toString());
    }

    private void transTriggeringWhenValid() {
        if ((this.target.ringtoneMenuConnectionSet || ASLPhoneData.getInstance().activePhoneAudioConnection == 98) && this.isTriggered) {
            this.isTriggered = false;
            this.trans(this.target.stateWaveplayerTriggering);
        }
    }
}

