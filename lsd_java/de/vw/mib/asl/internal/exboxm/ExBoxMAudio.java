/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.exboxm.AbstractExBoxM;
import de.vw.mib.asl.internal.exboxm.IntIntMiniMap;
import de.vw.mib.asl.internal.exboxm.TargetASLExBoxM;
import de.vw.mib.asl.internal.exboxm.services.ExboxServices;
import de.vw.mib.asl.internal.exboxm.services.ExboxServicesProvider;
import de.vw.mib.asl.internal.exboxm.speech.SpeechConnectionStatusListener;
import de.vw.mib.asl.internal.exboxm.util.ExboxLogger;
import de.vw.mib.genericevents.EventGeneric;

public class ExBoxMAudio
extends AbstractExBoxM {
    private ExboxServices exboxServices;
    private final ExboxLogger exboxLogger;
    public static final int AUDIO_NO_CONNECTION;
    public static final int AUDIO_REQUEST_CONNECTION;
    public static final int AUDIO_ESTABLISHED_CONNECTION;
    public static final int AUDIO_CONNECTION_UNDEFINED;
    public static final int AUDIO_CONNECTION_NAV_INDEX;
    public static final int AUDIO_CONNECTION_NAV_TEL_INDEX;
    public static final int AUDIO_CONNECTION_SDS_INDEX;
    public static final int AUDIO_CONNECTION_EA_INDEX;
    public static final int AUDIO_CONNECTION_MAX_INDEX;
    private final int[] audioConnectionStatus = new int[5];
    private SpeechConnectionStatusListener speechConnectionStatusListener;
    private static final IntIntMiniMap AUDIOCONTEXT_INDEX2DSI;
    private static final IntIntMiniMap AUDIOCONTEXT_DSI2INDEX;
    private boolean audioManagerAvailable = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$exboxm$ExBoxMAudio;

    protected void resetInternalData() {
        this.exboxLogger.trace("resetInternalData called!");
        this.releaseAllAuxAudioConnections();
        this.releaseAllVdaAudioConnections();
    }

    public static String getAudioConnectionStateString(int n) {
        String string = "AUDIO_NO_CONNECTION";
        String string2 = "AUDIO_REQUEST_CONNECTION";
        String string3 = "AUDIO_ESTABLISHED_CONNECTION";
        String string4 = "UNKNOWN_AUDIO_CONNECTION_STATE";
        switch (n) {
            case 0: {
                return "AUDIO_NO_CONNECTION";
            }
            case 1: {
                return "AUDIO_REQUEST_CONNECTION";
            }
            case 2: {
                return "AUDIO_ESTABLISHED_CONNECTION";
            }
        }
        return "UNKNOWN_AUDIO_CONNECTION_STATE";
    }

    public ExBoxMAudio(TargetASLExBoxM targetASLExBoxM) {
        super(targetASLExBoxM);
        this.exboxServices = ExboxServicesProvider.getExBoxServices();
        this.exboxLogger = new ExboxLogger(this.exboxServices.getLogger(), class$de$vw$mib$asl$internal$exboxm$ExBoxMAudio == null ? (class$de$vw$mib$asl$internal$exboxm$ExBoxMAudio = ExBoxMAudio.class$("de.vw.mib.asl.internal.exboxm.ExBoxMAudio")) : class$de$vw$mib$asl$internal$exboxm$ExBoxMAudio);
    }

    protected void releaseAllAuxAudioConnections() {
        this.exboxLogger.trace("releaseAllAuxAudioConnections called!");
        this.releaseAudioConnectionSpeech();
    }

    protected void releaseAllVdaAudioConnections() {
        this.exboxLogger.trace("releaseAllVdaAudioConnections called!");
        this.releaseAudioConnectionNav();
        this.releaseAudioConnectionEmergencyAnnouncement();
    }

    protected void restoreAudioConnections() {
        this.exboxLogger.trace("restoreAudioConnections called!");
        if (this.isExBoxOperationStateNormal()) {
            this.exboxLogger.trace("Operation state is normal. Restoring audio connections now.");
            for (int i2 = 0; i2 < 5; ++i2) {
                if (this.audioConnectionStatus[i2] == 0) continue;
                this.exboxLogger.trace(new Object[]{"Restore audio connection: ", AUDIOCONTEXT_INDEX2DSI.getName(i2)});
                this.requestIndicationAudioConnection(i2);
            }
        } else {
            this.exboxLogger.trace("Restoring audio connections interrupted, because Exbox operation state is not normal.");
        }
    }

    void requestGenericAudioConnection(int n, boolean bl, int n2) {
        this.exboxLogger.trace("requestGenericAudioConnection called!");
        if (this.isAudioManagerAvailable()) {
            this.exboxLogger.trace(new Object[]{"Audio manager is available. Send ASL_SOUND_SET_CONNECTION event for audio connection ", new Integer(n), "."});
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(1, bl);
            eventGeneric.setBoolean(2, true);
            eventGeneric.setSenderEventId(n2);
            this.sendSafe(eventGeneric);
        } else {
            this.exboxLogger.trace("Audio manager is not available. No event sent.");
        }
    }

    private void requestIndicationAudioConnection(int n) {
        this.exboxLogger.trace("requestIndicationAudioConnection called!");
        if (AUDIOCONTEXT_INDEX2DSI.containsKey(n)) {
            this.requestGenericAudioConnection(AUDIOCONTEXT_INDEX2DSI.get(n), false, -1551499008);
            this.updateAudioConnectionStatus(n, 1);
        } else {
            this.exboxLogger.error(new StringBuffer().append("requestIndicationAudioConnection failed! Unknown audio index ").append(n).append(".").toString());
        }
    }

    private void releaseIndicationAudioConnection(int n) {
        this.exboxLogger.trace("releaseIndicationAudioConnection called!");
        if (AUDIOCONTEXT_INDEX2DSI.containsKey(n)) {
            String string = AUDIOCONTEXT_INDEX2DSI.getName(n);
            if (this.audioConnectionStatus[n] != 0) {
                if (this.isAudioManagerAvailable()) {
                    this.exboxLogger.trace(new Object[]{"Audio manager available. Release audio connection ", string, "."});
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
                    eventGeneric.setInt(0, AUDIOCONTEXT_INDEX2DSI.get(n));
                    this.sendSafe(eventGeneric);
                } else {
                    this.exboxLogger.trace("Audio manager not available. No release of audio connection triggered.");
                }
                this.updateAudioConnectionStatus(n, 0);
            } else {
                this.exboxLogger.trace(new Object[]{"Audio connection ", string, " is already released!"});
            }
        } else {
            this.exboxLogger.error(new StringBuffer().append("releaseIndicationAudioConnection failed! Unknown audio index ").append(n).append(".").toString());
        }
    }

    protected void markDsiAudioConnectionAsEstablished(int n) {
        if (AUDIOCONTEXT_DSI2INDEX.containsKey(n)) {
            this.markIndexAudioConnectionAsEstablished(AUDIOCONTEXT_DSI2INDEX.get(n));
        } else {
            this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager unknown Audio Connection was established: ", new Integer(n), "."});
        }
    }

    private void markIndexAudioConnectionAsEstablished(int n) {
        if (AUDIOCONTEXT_INDEX2DSI.containsKey(n)) {
            this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager indication source connection response:", AUDIOCONTEXT_INDEX2DSI.getName(n)});
            this.updateAudioConnectionStatus(n, 2);
        } else {
            this.exboxLogger.error(new StringBuffer().append("ASL>ASL AudioManager unknown index for Audio Connection was entablished: ").append(n).toString());
        }
    }

    private void updateAudioConnectionStatus(int n, int n2) {
        this.audioConnectionStatus[n] = n2;
        if (n == 3 && this.speechConnectionStatusListener != null) {
            this.speechConnectionStatusListener.onSpeechConnectionStatusChange(n2);
        }
    }

    protected void markDsiAudioConnectionAsNotConnected(int n) {
        if (AUDIOCONTEXT_DSI2INDEX.containsKey(n)) {
            this.markIndexAudioConnectionAsNoConnected(AUDIOCONTEXT_DSI2INDEX.get(n));
        } else {
            this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager unknown audio connection was released: ", new Integer(n), "."});
        }
    }

    protected void markIndexAudioConnectionAsNoConnected(int n) {
        if (AUDIOCONTEXT_INDEX2DSI.containsKey(n)) {
            if (this.audioConnectionStatus[n] != 0) {
                this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager cancelled source connection: ", AUDIOCONTEXT_INDEX2DSI.getName(n)});
                this.updateAudioConnectionStatus(n, 0);
            } else {
                this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager source connection: ", AUDIOCONTEXT_INDEX2DSI.getName(n), " is already cancelled."});
            }
        } else {
            this.exboxLogger.trace(new Object[]{"ASL>ASL AudioManager unknown index for audio connection was released: ", new Integer(n)});
        }
    }

    boolean isAudioManagerAvailable() {
        return this.audioManagerAvailable;
    }

    protected void setAudioManagerAvailable(boolean bl) {
        this.audioManagerAvailable = bl;
    }

    protected void requestAudioConnectionNav(boolean bl) {
        if (this.audioConnectionStatus[1] == 0 && this.audioConnectionStatus[0] == 0) {
            if (this.audioConnectionStatus[4] != 0) {
                this.errorEx().append("EX:DSI>ASL nav or nav/tel request during open emergency announcement audio connection - nav connections will be released.").log();
                this.releaseAudioConnectionEmergencyAnnouncement();
            }
            if (bl) {
                this.exboxLogger.trace("Requesting nav_tel audio connection.");
                this.requestIndicationAudioConnection(1);
            } else {
                this.exboxLogger.trace("Requesting nav audio connection.");
                this.requestIndicationAudioConnection(0);
            }
        }
    }

    private void releaseAudioConnectionNav() {
        this.exboxLogger.trace("releaseAudioConnectionNav called!");
        this.releaseIndicationAudioConnection(0);
        this.releaseIndicationAudioConnection(1);
    }

    protected boolean isNavRequestedOrConnected() {
        return this.audioConnectionStatus[0] != 0 || this.audioConnectionStatus[1] != 0;
    }

    protected void requestAudioConnectionEmergencyAnnouncement() {
        this.exboxLogger.trace("requestAudioConnectionEmergencyAnnouncement called!");
        if (this.audioConnectionStatus[0] != 0 || this.audioConnectionStatus[1] != 0) {
            this.errorEx().append("EX:DSI>ASL emergency announcement audio request during open nav or nav/tel connection - nav connections will be released.").log();
            this.releaseAudioConnectionNav();
        }
        this.requestIndicationAudioConnection(4);
    }

    private void releaseAudioConnectionEmergencyAnnouncement() {
        this.exboxLogger.trace("releaseAudioConnectionEmergencyAnnouncement called!");
        this.releaseIndicationAudioConnection(4);
    }

    public void requestAudioConnectionSpeech() {
        this.exboxLogger.trace("requestAudioConnectionSpeech called!");
        if (this.audioConnectionStatus[3] == 0) {
            this.requestIndicationAudioConnection(3);
        }
    }

    public void releaseAudioConnectionSpeech() {
        this.exboxLogger.trace("releaseAudioConnectionSpeech called!");
        this.releaseIndicationAudioConnection(3);
    }

    public void setSpeechConnectionStatusListener(SpeechConnectionStatusListener speechConnectionStatusListener) {
        this.speechConnectionStatusListener = speechConnectionStatusListener;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        AUDIOCONTEXT_INDEX2DSI = new IntIntMiniMap(0, "Nav|Nav_Tel|SDS|EA", new int[]{0, 221, 1, 220, 3, 219, 4, 222});
        AUDIOCONTEXT_DSI2INDEX = new IntIntMiniMap(-1, "Nav|Nav_Tel|SDS|EA", new int[]{221, 0, 220, 1, 219, 3, 222, 4});
    }
}

