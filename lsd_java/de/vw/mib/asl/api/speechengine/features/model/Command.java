/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.features.model;

public interface Command {
    default public int getClientId() {
    }

    default public int getSdsId() {
    }

    default public int getEventId() {
    }

    default public int getMode() {
    }

    default public boolean isPublic() {
    }

    default public boolean isSpellingGrammar() {
    }

    default public boolean isNLU() {
    }
}

