/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.amfm.dsi.AmFmDsiApi;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateAmFmActiveTargetSeek
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private int mSeekMode;
    public static final int TARGET_SEEK_INVALID;
    public static final int TARGET_SEEK_ACTIVE;
    public static final int TARGET_SEEK_STOP_NEXT_STATION;
    public static final int TARGET_SEEK_FINISHED;
    private static int targetSeekStatus;

    StateAmFmActiveTargetSeek(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateAmFmActiveTargetSeek is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                StateAmFmActiveTargetSeek.setTargetSeekStatus(1);
                GuiApiTunerCommon.updateSeekActive(true);
                this.mSeekMode = this.mTarget.mSeekMode;
                this.seek(this.mSeekMode);
                break;
            }
            case 4: {
                GuiApiTunerCommon.updateSeekActive(false);
                this.mTarget.mSeekMode = 0;
                break;
            }
            case 100002: {
                targetSeekStatus = 0;
                this.trans(this.mTarget.stateAmFmActiveIdle);
                break;
            }
            case 1073742987: 
            case 1073742991: 
            case 1073743002: 
            case 1073743014: 
            case 1073743037: 
            case 0x400004CC: 
            case 1073743053: {
                this.abort();
                return this.myParent;
            }
            case 1073743057: {
                this.abort();
                break;
            }
            case 1073743059: {
                AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), true);
                break;
            }
            case 1073743067: {
                targetSeekStatus = 2;
                this.mSeekMode = this.mSeekMode == 5 ? 1 : 2;
                AmFmDsiApi.stopAutoSeek(this.mTarget.getTargetId(), false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void seek(int n) {
        AmFmDsiApi.doAutoSeek(this.mTarget.getTargetId(), -1568276224, n);
    }

    private void abort() {
        AmFmDsiApi.abortAutoSeek(this.mTarget.getTargetId());
    }

    public static int getTargetSeekStatus() {
        return targetSeekStatus;
    }

    public static void setTargetSeekStatus(int n) {
        targetSeekStatus = n;
    }

    public static boolean isTargetSeekActive() {
        return targetSeekStatus == 1 || targetSeekStatus == 2;
    }

    static {
        targetSeekStatus = 0;
    }
}

