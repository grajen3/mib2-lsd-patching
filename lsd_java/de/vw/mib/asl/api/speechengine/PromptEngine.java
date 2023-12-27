/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine;

import de.vw.mib.asl.api.speechengine.speakonly.SpeakOnlyService;

public interface PromptEngine {
    default public SpeakOnlyService getSpeakOnlyService(int n) {
    }
}

