/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.accessor;

import de.vw.mib.asl.internal.media.controller.MediaController;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.helper.MediaModelController;

public final class MediaObjectAccessor {
    public static MediaAudioManager soundHandler;
    private static MediaPersistence persistence;
    private static MediaModelController modelController;
    public static MediaController mMediaController;

    private MediaObjectAccessor() {
    }

    public static void reset() {
        persistence = null;
    }

    public static MediaPersistence getPersistence() {
        if (persistence == null) {
            persistence = new MediaPersistence();
        }
        return persistence;
    }

    public static MediaAudioManager getAudioManager() {
        return soundHandler;
    }

    public static MediaModelController getModelController() {
        if (modelController == null) {
            modelController = new MediaModelController();
        }
        return modelController;
    }

    static {
        mMediaController = null;
    }
}

