/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.mainmenu;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContextEmpty;
import de.vw.mib.asl.internal.speechgeneral.events.commands.RecognitionConsumer;

public class SpeechContextGeneral
extends SpeechContextEmpty {
    private RecognitionConsumer cmdUseCaseTeleprompter;

    public SpeechContextGeneral(RecognitionConsumer recognitionConsumer) {
        this.cmdUseCaseTeleprompter = recognitionConsumer;
    }

    @Override
    public int getSpeechContextId() {
        return 1;
    }

    @Override
    public void enterMainView() {
        this.cmdUseCaseTeleprompter.onRecognizedEvent(30683200);
    }
}

