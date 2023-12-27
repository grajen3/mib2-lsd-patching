/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.end;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClientAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogAudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class ReleaseAudio
extends DefaultDialogTask
implements AudioConnectionClientAdapter {
    private static final int TRACE_CLASSIFIER;
    private static final String TRACE_PREFIX;
    private final DialogAudioConnectionClient audioClient;
    private final IntOptHashSet requiredConnections;
    private final DialogSystemPublisher dialogSystemPublisher;

    public ReleaseAudio(Logger logger, DialogAudioConnectionClient dialogAudioConnectionClient, IntOptHashSet intOptHashSet, DialogSystemPublisher dialogSystemPublisher) {
        super(logger);
        this.audioClient = dialogAudioConnectionClient;
        this.requiredConnections = intOptHashSet;
        this.dialogSystemPublisher = dialogSystemPublisher;
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(6);
        if (this.requiredConnections.isEmpty()) {
            this.taskLogger.warn(2048, "[ReleaseAudio] There are no audio-connections to release?! ");
            this.notifyFinishedSuccessful();
        } else {
            this.audioClient.addClientAdapter(this);
            this.audioClient.releaseConnections(this.requiredConnections.toArray());
        }
    }

    @Override
    public void terminate() {
        this.audioClient.removeClientAdapter(this);
        this.dialogSystemPublisher.onDialogStepFinished(6);
    }

    @Override
    public void abort() {
    }

    @Override
    protected int getMask() {
        return 8;
    }

    @Override
    public void onAudioConnectionReleased(int n) {
        if (this.taskLogger.isTraceEnabled(2048)) {
            LogMessage logMessage = this.taskLogger.trace(2048);
            logMessage.append("[ReleaseAudio] ");
            logMessage.append("onAudioConnectionReleased( connectionId=");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.onConnectionInactive(n);
    }

    @Override
    public void onAudioConnectionReserved(int n) {
        this.onAudioConnectionReleased(n);
    }

    @Override
    public void onAudioConnectionLost(int n) {
        if (this.taskLogger.isTraceEnabled(2048)) {
            LogMessage logMessage = this.taskLogger.trace(2048);
            logMessage.append("[ReleaseAudio] ");
            logMessage.append("onAudioConnectionLost( connectionId=");
            logMessage.append(n);
            logMessage.append(" )");
            logMessage.log();
        }
        this.onConnectionInactive(n);
    }

    private void onConnectionInactive(int n) {
        this.requiredConnections.remove(n);
        if (this.requiredConnections.isEmpty()) {
            this.taskLogger.info(2048, "[ReleaseAudio] all audio-connections released.");
            this.notifyFinishedSuccessful();
        }
    }
}

