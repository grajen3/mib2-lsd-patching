/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.config.SpeechConfigurator;
import de.vw.mib.asl.api.speechengine.config.voice.VoiceService;
import de.vw.mib.asl.framework.internal.lsc.AslTargetLscTNGBullhorn;
import de.vw.mib.asl.framework.internal.lsc.OsgiServices$ServiceConsumer;
import de.vw.mib.asl.framework.internal.lsc.VoiceTypeSynchronizer;

class AslTargetLscTNGBullhorn$2
implements OsgiServices$ServiceConsumer {
    private final /* synthetic */ AslTargetLscTNGBullhorn this$0;

    AslTargetLscTNGBullhorn$2(AslTargetLscTNGBullhorn aslTargetLscTNGBullhorn) {
        this.this$0 = aslTargetLscTNGBullhorn;
    }

    @Override
    public void onServiceAvailable(Object object) {
        SpeechEngine speechEngine = (SpeechEngine)object;
        SpeechConfigurator speechConfigurator = speechEngine.getSpeechConfigurator(18);
        VoiceService voiceService = speechConfigurator.getVoiceService();
        VoiceTypeSynchronizer.bindVoiceServiceAndModel(voiceService, AslTargetLscTNGBullhorn.access$000(this.this$0));
    }
}

