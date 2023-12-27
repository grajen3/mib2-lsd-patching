/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.begin;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClientAdapter;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.DialogAudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.messenger.DialogSystemPublisher;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.log4mib.Logger;

public class RequestAudio
extends DefaultDialogTask
implements AudioConnectionClientAdapter {
    private static final int TRACE_CLASSIFIER;
    private static final String TRACE_PREFIX;
    private final DialogAudioConnectionClient audioClient;
    private final IntOptHashSet requiredConnections;
    private IntArrayList grantedAudioConnections;
    private final DialogSystemPublisher dialogSystemPublisher;

    public RequestAudio(Logger logger, DialogAudioConnectionClient dialogAudioConnectionClient, IntOptHashSet intOptHashSet, DialogSystemPublisher dialogSystemPublisher) {
        super(logger);
        this.audioClient = dialogAudioConnectionClient;
        this.requiredConnections = intOptHashSet;
        this.grantedAudioConnections = new IntArrayList(0);
        this.dialogSystemPublisher = dialogSystemPublisher;
    }

    @Override
    public void execute() {
        this.dialogSystemPublisher.onDialogStepStarted(0);
        if (this.requiredConnections.isEmpty()) {
            this.taskLogger.info(2048, "[RequestAudio] Starting task-execution without any audio-connections needed?!");
            this.notifyFinishedSuccessful();
        } else {
            this.audioClient.addClientAdapter(this);
            this.audioClient.requestConnections(this.requiredConnections.toArray());
        }
    }

    @Override
    public void terminate() {
        this.dialogSystemPublisher.onDialogStepFinished(0);
        this.audioClient.removeClientAdapter(this);
    }

    @Override
    public void abort() {
    }

    @Override
    protected int getMask() {
        return 16;
    }

    @Override
    public void onAudioConnectionReleased(int n) {
    }

    @Override
    public void onAudioConnectionReserved(int n) {
        this.taskLogger.trace(2048, new StringBuffer().append("[RequestAudio] Connection granted: ").append(n).toString());
        this.grantedAudioConnections.add(n);
        if (this.grantedAudioConnections.containsAll(this.requiredConnections)) {
            this.taskLogger.info(2048, "[RequestAudio] all audio-connections granted.");
            this.notifyFinishedSuccessful();
        } else {
            this.taskLogger.trace(2048, "[RequestAudio] Not all connections granted yet - postpone task-execution.");
        }
    }

    @Override
    public void onAudioConnectionLost(int n) {
        if (this.requiredConnections.contains(n)) {
            this.taskLogger.info(2048, new StringBuffer().append("[RequestAudio] connection rejected: ").append(n).toString());
            this.requiredConnections.remove(n);
            if (!this.requiredConnections.isEmpty()) {
                this.audioClient.releaseConnections(this.requiredConnections.toArray());
            }
            this.notifyFinishedFlawed();
        }
    }
}

