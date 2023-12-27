/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech$1;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class ASLSpeech {
    public static SpeechEngineMaster speechEngineMaster;
    public static final int PERFORMING_BAP_ACTION__AUDIO_SWITCH_SOURCE;
    public static final int PERFORMING_BAP_ACTION__AUDIO_RADIO_PREV_NEXT_SEEK;
    public static final int PERFORMING_BAP_ACTION__AUDIO_MEDIA_PREV_NEXT_SEEK;
    public static final int PERFORMING_BAP_ACTION__NAVIGATION_RG_STARTED_STOPPED;
    public static final int PERFORMING_BAP_ACTION__PHONE_CHANGED_CALL_STATE;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;

    private ASLSpeech() {
    }

    public static void init() {
        ServiceTracker serviceTracker = new ServiceTracker(ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext(), (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = ASLSpeech.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), (ServiceTrackerCustomizer)new ASLSpeech$1());
        serviceTracker.open();
    }

    public static void performingBAPAction(int n) {
        if (speechEngineMaster != null) {
            speechEngineMaster.getDialogManager(15).endSession(true);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

