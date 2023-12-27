/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine;

public final class Settings {
    public static int getTtsPromptMode() {
        return 2;
    }

    public static int getPauseTimerDuration() {
        return 10000;
    }

    public static int getDefaultVoice() {
        return 0;
    }

    public static int getDefaultUnambiguousResultRange() {
        return 1500;
    }

    public static int getDefaultFirstLevelSize() {
        return 5;
    }

    public static int getDefaultUnambiguousResultThreshold() {
        return 5800;
    }

    public static int getDefaultMaxSlotNBestListSize() {
        return 20;
    }

    public static boolean isCommandDisambiguouationEnabled() {
        return false;
    }

    public static int getDefaultMaxCommandNBestListSize() {
        return 1;
    }
}

