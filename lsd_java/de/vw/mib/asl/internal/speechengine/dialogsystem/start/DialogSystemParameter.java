/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.start;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemCallback;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.log4mib.Logger;

public interface DialogSystemParameter {
    default public Logger getLogger() {
    }

    default public Services getAslServices() {
    }

    default public DialogSystemPublisher getDialogSystemPublisher() {
    }

    default public ApplicationStateRouter getApplicationStateRouter() {
    }

    default public DialogSystemCallback getSpeechEngineStarter() {
    }

    default public AudioConnectionProvider getAudioConnectionProvider() {
    }
}

