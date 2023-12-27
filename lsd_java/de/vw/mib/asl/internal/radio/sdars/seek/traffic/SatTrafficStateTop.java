/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.AbstractSatTrafficState;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.sdars.SeekAlert;

final class SatTrafficStateTop
extends AbstractSatTrafficState {
    SatTrafficStateTop(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "Top", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateTop is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                break;
            }
            case 3: {
                this.trans(this.mTarget.mStateNotChoosed);
                break;
            }
            case 8: {
                this.mTarget.addObserver(1476657216);
                this.mTarget.addObserver(1644429376);
                this.mTarget.addObserver(1493434432);
                this.mTarget.addObserver(60761152);
                break;
            }
            case 9: {
                this.mTarget.removeObserver(1476657216);
                this.mTarget.removeObserver(1644429376);
                this.mTarget.removeObserver(1493434432);
                this.mTarget.addObserver(60761152);
                break;
            }
            case 1073742937: {
                this.trans(this.mTarget.mStateNormal);
                break;
            }
            case 1073742946: {
                int n = eventGeneric.getInt(0);
                this.mTarget.setCurrent(n);
                break;
            }
            case 100002: {
                SeekAlert seekAlert = (SeekAlert)eventGeneric.getObject(0);
                this.mTarget.setAlert(seekAlert);
                break;
            }
            case 100001: {
                SeekAlert seekAlert = (SeekAlert)eventGeneric.getObject(0);
                this.mTarget.setAlert(seekAlert);
                this.trans(this.mTarget.mStateJumped);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

