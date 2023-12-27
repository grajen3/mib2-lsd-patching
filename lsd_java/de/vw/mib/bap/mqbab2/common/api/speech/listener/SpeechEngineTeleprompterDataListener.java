/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.speech.listener;

import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataConsumerDefault;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechASLDataAdapter;

public class SpeechEngineTeleprompterDataListener
extends TeleprompterDataConsumerDefault {
    private SpeechASLDataAdapter speechService;

    public SpeechEngineTeleprompterDataListener(SpeechASLDataAdapter speechASLDataAdapter) {
        this.speechService = speechASLDataAdapter;
    }

    @Override
    public void onTeleprompterDataChanged(TeleprompterData teleprompterData) {
        this.speechService.onTeleprompterDataChanged(teleprompterData);
    }
}

