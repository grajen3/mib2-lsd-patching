/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.contexts;

import de.vw.mib.asl.api.speechengine.contexts.SpeechContext;

public class SpeechContextEmpty
implements SpeechContext {
    @Override
    public int getSpeechContextId() {
        return -1;
    }

    @Override
    public void enterMainView() {
    }
}

