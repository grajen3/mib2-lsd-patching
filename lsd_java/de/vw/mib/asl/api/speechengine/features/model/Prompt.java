/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.PromptReference;

public interface Prompt {
    default public int getPromptId() {
    }

    default public String[] getReferences() {
    }

    default public PromptReference[] getPromptReferences() {
    }
}

