/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaSourcesAudio;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public class StartupRestorer
implements MediaListObserver,
Loggable {
    private final MediaDevices mediaDevices;
    private final MediaSourcesAudio audioSource;
    private boolean restoringActive = false;
    private int objectId = 0;
    private boolean wasLastEntertainmentContextMedia;
    private int activationCount = 0;

    public StartupRestorer(MediaDevices mediaDevices, MediaSourcesAudio mediaSourcesAudio) {
        this.mediaDevices = mediaDevices;
        this.audioSource = mediaSourcesAudio;
    }

    public void setLastEntertainmentContextMedia(boolean bl) {
        this.wasLastEntertainmentContextMedia = bl;
        this.activationCount = 0;
    }

    public boolean checkRestart(int n) {
        if (this.isStartup()) {
            this.objectId = n;
            this.restoringActive = true;
            return true;
        }
        return false;
    }

    public boolean isStartup() {
        return this.activationCount <= 1 && this.wasLastEntertainmentContextMedia;
    }

    public void cancel() {
        this.restoringActive = false;
    }

    @Override
    public void onUpdate(Devices devices) {
        this.restoreActive();
    }

    private void restoreActive() {
        MediaCollector mediaCollector;
        if (this.restoringActive && (mediaCollector = this.mediaDevices.mediaCollectorFromObjectId(this.objectId)) != MediaCollector.EMPTY && !mediaCollector.isMediaActive()) {
            ServiceManager.logger.info(128).append("StartupRestorer.restoreActive(): active media ").append(mediaCollector).append(" was not active before.").log();
            this.audioSource.updateActiveMedia(mediaCollector.getMedium());
            this.restoringActive = false;
        }
    }

    public void activation() {
        ++this.activationCount;
        if (this.activationCount > 1 || !this.wasLastEntertainmentContextMedia) {
            this.cancel();
        }
    }

    @Override
    public void toString(LogMessage logMessage) {
        int n = this.activationCount % 10;
        if (this.activationCount % 100 / 10 == 1) {
            n = 0;
        }
        logMessage.append("  That's the ").append(this.activationCount);
        switch (n) {
            case 1: {
                logMessage.append("st");
                break;
            }
            case 2: {
                logMessage.append("nd");
                break;
            }
            case 3: {
                logMessage.append("rd");
                break;
            }
            default: {
                logMessage.append("th");
            }
        }
        logMessage.append(" activation from Entertainment Manager");
    }
}

