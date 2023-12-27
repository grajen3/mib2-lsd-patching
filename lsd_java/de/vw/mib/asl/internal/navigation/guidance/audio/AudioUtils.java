/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.audio.HsmTargetAudio;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.log4mib.LogMessage;

public class AudioUtils {
    public static void handleASLSoundAudioConnectionReleased(HsmTargetAudio hsmTargetAudio, AbstractHsmState abstractHsmState, EventGeneric eventGeneric, AbstractHsmState abstractHsmState2) {
        hsmTargetAudio.traceState(abstractHsmState, "handleASLSoundAudioConnectionReleased()");
        int n = eventGeneric.getInt(0);
        if (n == 116 || n == 117) {
            hsmTargetAudio.traceState(abstractHsmState, "Audio connection released!");
            hsmTargetAudio.getHsm().trans(abstractHsmState2);
        }
    }

    public static void releaseAudioConnection(HsmTargetAudio hsmTargetAudio, AbstractHsmState abstractHsmState) {
        hsmTargetAudio.traceState(abstractHsmState, "releaseAudioConnection()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
        if (hsmTargetAudio.connection != 0) {
            eventGeneric.setInt(0, hsmTargetAudio.connection);
        } else {
            eventGeneric.setInt(0, 116);
            HsmTargetAudio.getLogger().error("Navi Audio wants to release a audio connection, but the conection CL was not set.");
        }
        if (HsmTargetAudio.getLogger().isTraceEnabled()) {
            LogMessage logMessage = HsmTargetAudio.getLogger().makeTrace();
            logMessage.append("Navi Audio: Releasing connection with CL: ").append(eventGeneric.getInt(0));
            logMessage.log();
        }
        hsmTargetAudio.send(eventGeneric);
    }
}

