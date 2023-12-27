/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.internal.exboxm.AbstractExBoxM;
import de.vw.mib.asl.internal.exboxm.ExBoxMAudioEntertainmentEvents;
import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;

class ExBoxMAudioEntertainment
extends AbstractExBoxM {
    private final ExBoxMAudioEntertainmentEvents exBoxMevents;
    private final TargetASLExBoxM target;
    private final ExboxLogger exboxLogger;
    public static final int ENTERTAINMENT_SOURCE_DMB_INDEX;
    private boolean audioManagerAvailable = false;
    private boolean isExBoxMOpstateNormal = false;
    private final ASLPropertyManager propertyManager;

    void restoreEntertainmentAudioConnection() {
        this.exboxLogger.trace("sending WEAK REQUEST(DMB) to entmgr");
        this.target.sendSafe(this.exBoxMevents.createEntWeakRequest(1));
    }

    private boolean isAudioManagerAvailable() {
        return this.audioManagerAvailable;
    }

    final void setAudioManagerAvailable(boolean bl) {
        this.audioManagerAvailable = bl;
    }

    private boolean isValidExboxEntertainmentAudioSource(int n) {
        return n == 214 || n == 9;
    }

    void handleSoundEntConnectionAnswer(int n, boolean bl) {
        this.exboxLogger.trace(new Object[]{" got dsiAudioSource ", new Integer(n), bl ? " succeeded" : " failed"});
        if (this.isValidExboxEntertainmentAudioSource(n)) {
            this.exboxLogger.trace("sending ACTIVATED to entmgr");
            this.target.sendSafe(this.exBoxMevents.createEntActivated());
        } else {
            this.errorEx().append(new StringBuffer().append("EX:ASL>ASL AudioManager unknown Entertainment Connection was established: ").append(n).toString()).log();
        }
    }

    void handleEntManagerActivate(int n, int n2) {
        this.exboxLogger.trace(new Object[]{"Entertainment Manager ACTIVATE context ", new Integer(n), " Subcontext: ", new Integer(n2)});
        if (n == 4) {
            int n3 = this.calculateCurrentAudioSoundSource();
            if (this.isAudioManagerAvailable()) {
                this.exboxLogger.trace(new Object[]{"sending ASL_SOUND_SET_CONNECTION, source ", n3 == 214 ? "DMB" : (n3 == 9 ? "SUPPRESSION" : Integer.toString(n3))});
                this.target.sendSafe(this.exBoxMevents.createSoundSetConnection(n3, n3 == 9, true, -1601830656));
            }
        } else {
            this.exboxLogger.error(new StringBuffer().append("Entertainment Manager Activate unknown context: ").append(n).toString());
        }
    }

    void handleEntManagerActivateStartup(int n, int n2) {
        this.exboxLogger.trace(new Object[]{"Entertainment Manager ACTIVATE_STARTUP LSM event received - Context:", new Integer(n), " Subcontext: ", new Integer(n2)});
        this.handleEntManagerActivate(n, n2);
    }

    void handleEntManagerCancel() {
        this.exboxLogger.trace("Entertainment Manager CANCEL ignored");
    }

    void handleEntManagerDeactivate() {
        this.exboxLogger.trace("sending DEACTIVATED to entmgr");
        this.target.sendSafe(this.exBoxMevents.createEntDeactivated());
    }

    private int calculateCurrentAudioSoundSource() {
        return this.isExBoxMOpstateNormal ? 214 : 9;
    }

    void switchDsiDMBEntertainmentSource() {
        this.exboxLogger.trace("switch to dsi DMB entertainment source");
        this.sendDMBEntertainmentContextToHmi();
        this.exboxLogger.trace("sending EXBOX_REQUESTED to entmgr");
        this.target.sendSafe(this.exBoxMevents.createEntRequest(1));
    }

    void operationStateChanged(boolean bl) {
        if (this.isExBoxMOpstateNormal != bl) {
            this.isExBoxMOpstateNormal = bl;
            this.exboxLogger.trace("sending WEAK_REQUEST to entmgr");
            this.target.sendSafe(this.exBoxMevents.createEntWeakRequest(1));
        }
    }

    private void sendDMBEntertainmentContextToHmi() {
        this.exboxLogger.trace("set DMB subcontext in HMI");
        this.propertyManager.valueChangedInteger(3960, 1);
    }

    public ExBoxMAudioEntertainment(TargetASLExBoxM targetASLExBoxM, ExBoxMAudioEntertainmentEvents exBoxMAudioEntertainmentEvents, ASLPropertyManager aSLPropertyManager) {
        super(targetASLExBoxM);
        this.target = targetASLExBoxM;
        this.exBoxMevents = exBoxMAudioEntertainmentEvents;
        this.propertyManager = aSLPropertyManager;
        this.exboxLogger = new ExboxLogger(ExboxServicesProvider.getExBoxServices().getLogger(), super.getClass());
        this.exboxLogger.trace("sending REGISTER_TARGET to entmgr");
        this.target.sendSafe(this.exBoxMevents.createEntRegisterTarget());
    }
}

