/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.config.voice.VoiceService;
import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.asl.framework.internal.lsc.LscServices;
import de.vw.mib.asl.framework.internal.lsc.VoiceTypeSynchronizer$1;
import de.vw.mib.asl.framework.internal.lsc.VoiceTypeSynchronizer$VoiceTypeToggleListener;
import de.vw.mib.genericevents.GenericEvents;

public class VoiceTypeSynchronizer {
    private final ASLPropertyManager datapool;
    private final VoiceService voiceService;

    public static void bindVoiceServiceAndModel(VoiceService voiceService, LscServices lscServices) {
        Preconditions.checkArgumentNotNull(voiceService, "Argument >voiceService< must not be null!");
        Preconditions.checkArgumentNotNull(lscServices, "Argument >services< must not be null!");
        VoiceTypeSynchronizer voiceTypeSynchronizer = new VoiceTypeSynchronizer(lscServices.getPropertyManager(), voiceService);
        voiceTypeSynchronizer.registerVoiceChangesListener();
        voiceTypeSynchronizer.registerVoiceTypeToggleListener(lscServices.getGenericEvents());
        voiceTypeSynchronizer.updateVoiceAvailability(voiceService.getAvailableVoices());
        voiceTypeSynchronizer.updateCurrentVoice(voiceService.getVoice());
    }

    private VoiceTypeSynchronizer(ASLPropertyManager aSLPropertyManager, VoiceService voiceService) {
        this.datapool = aSLPropertyManager;
        this.voiceService = voiceService;
    }

    void onModelVoiceToggled() {
        if (this.voiceService.isVoiceChangeActive()) {
            return;
        }
        int n = this.voiceService.getVoice();
        int n2 = VoiceTypeSynchronizer.toggleVoice(n);
        this.voiceService.setVoice(n2);
    }

    private void registerVoiceTypeToggleListener(GenericEvents genericEvents) {
        new VoiceTypeSynchronizer$VoiceTypeToggleListener(this, genericEvents);
    }

    private void registerVoiceChangesListener() {
        this.voiceService.addListener(new VoiceTypeSynchronizer$1(this));
    }

    void updateVoiceAvailability(int[] nArray) {
        boolean bl = VoiceTypeSynchronizer.isMoreThanOneVoiceAvailable(nArray);
        this.datapool.valueChangedBoolean(1715, bl);
    }

    void updateCurrentVoice(int n) {
        this.datapool.valueChangedInteger(1513234432, n);
    }

    private static boolean isMoreThanOneVoiceAvailable(int[] nArray) {
        if (nArray == null) {
            return false;
        }
        return nArray.length > 1;
    }

    private static int toggleVoice(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 1: {
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter >voice< must be either 'VoiceType.VOICE_MALE' or 'VoiceType.VOICE_FEMALE'! Got:").append(n).toString());
    }
}

