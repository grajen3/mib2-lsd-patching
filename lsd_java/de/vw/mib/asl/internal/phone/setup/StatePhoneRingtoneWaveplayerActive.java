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

public class StatePhoneRingtoneWaveplayerActive
extends AbstractHsmState {
    private final HsmPhoneRingtoneHandling target;
    protected short selectedRingtone;

    public StatePhoneRingtoneWaveplayerActive(HsmPhoneRingtoneHandling hsmPhoneRingtoneHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneRingtoneHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (this.target.ringtoneMenuConnectionSet) {
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(50937088);
                    eventGeneric2.setInt(0, 87);
                    this.target.send(eventGeneric2);
                    break;
                }
                if (ASLPhoneData.getInstance().activePhoneAudioConnection != 98) break;
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(50937088);
                eventGeneric3.setInt(0, 98);
                this.target.send(eventGeneric3);
                break;
            }
            case 1073742889: {
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 3600006: {
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 4000023: {
                this.target.ringtoneMenuConnectionSet = false;
                this.trans(this.target.stateWaveplayerAborting);
                break;
            }
            case 4000015: {
                int n = eventGeneric.getInt(0);
                if (n != 87 || ASLPhoneData.getInstance().activePhoneAudioConnection == 98) break;
                this.target.ringtoneMenuConnectionSet = false;
                this.trans(this.target.stateWaveplayerAborting);
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
            case 1: {
                if (this.target.ringtoneMenuConnectionSet) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
                    eventGeneric.setInt(0, 87);
                    this.target.ringtoneMenuConnectionSet = false;
                    this.target.send(eventGeneric);
                }
                this.trans(this.target.stateWaveplayerIdle);
                break;
            }
            default: {
                this.target.warn(new StringBuffer().append("PhoneRingtoneHandlingActive: Unexpected player state ").append(n).append("!").toString());
            }
        }
    }
}

