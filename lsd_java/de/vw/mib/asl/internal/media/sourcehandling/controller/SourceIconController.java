/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.controller;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public final class SourceIconController {
    private static SourceIconController instance;
    private DeviceCollector nextSourceChangerIndex = null;
    private MediaDevices mediaDevices;
    private DeviceCollector first;
    private int previousAudioSource = -1;

    private SourceIconController() {
    }

    public static SourceIconController getInstance() {
        if (instance == null) {
            instance = new SourceIconController();
        }
        return instance;
    }

    public void setMediaDevices(MediaDevices mediaDevices) {
        this.mediaDevices = mediaDevices;
    }

    public void linkCircular(Device[] deviceArray) {
        if (deviceArray.length >= 1) {
            DeviceCollector deviceCollector = DeviceCollector.get(deviceArray[deviceArray.length - 1]);
            for (int i2 = 0; i2 < deviceArray.length; ++i2) {
                DeviceCollector deviceCollector2;
                if (deviceCollector == null) {
                    ServiceManager.logger.error(128, "linkCircular: DeviceCollector is null. Must not happen");
                    return;
                }
                deviceCollector.nextAvailable = deviceCollector2 = DeviceCollector.get(deviceArray[i2]);
                deviceCollector = deviceCollector2;
            }
            this.first = DeviceCollector.get(deviceArray[0]);
        }
    }

    public MediaCollector skipAvailableMediaSources(int n) {
        int n2 = this.mediaDevices.getPlayableSourceCount();
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("SourceIconController.getNextAvailableMediaSource(), nextCount = ").append(n).append(" ;  numberOfPlayableSources = ").append(n2).log();
        }
        if (this.nextSourceChangerIndex == null || this.nextSourceChangerIndex == DeviceCollector.EMPTY) {
            this.nextSourceChangerIndex = this.first;
        }
        if (n2 > 0) {
            if ((n %= n2) < 0) {
                n += n2;
            }
            DeviceCollector deviceCollector = this.nextSourceChangerIndex;
            while (!(n <= 0 && deviceCollector.isDevicePlayable() || (deviceCollector = deviceCollector.nextAvailable) == this.nextSourceChangerIndex)) {
                if (!deviceCollector.isDevicePlayable()) continue;
                --n;
            }
            this.nextSourceChangerIndex = deviceCollector;
            this.setCurrentAudioSource(deviceCollector.getMainPartition());
        }
        return this.nextSourceChangerIndex.getMainPartition();
    }

    public MediaCollector getFirstAvailable() {
        this.nextSourceChangerIndex = this.first;
        return this.skipAvailableMediaSources(0);
    }

    public void setCurrentAudioSource(int n) {
        if ((n & 0xFFFF0000) == 0) {
            Exception exception = new Exception("just the trace, no exception at all!");
            ServiceManager.logger.error(128).append("setCurrentAudioSource( ").append(this.previousAudioSource & 0xFFFF0000).append(" -> ").append(n & 0xFFFF0000).append(" ) ").attachThrowable(exception).log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(8, this.convertAvailable2CurrentAudioSource(n & 0xFFFF0000));
        if (this.previousAudioSource != n) {
            this.previousAudioSource = n;
        } else if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("setCurrentAudioSource called but aslDeviceID is the same as before: ").append(n).log();
        }
        this.initializeCurrentAudioSource();
    }

    public void initializeCurrentAudioSource() {
        if (this.getDeviceCollector() == null && this.previousAudioSource >= 0 && this.mediaDevices.mediaCollectorFromObjectId(this.previousAudioSource) != null) {
            this.nextSourceChangerIndex = this.mediaDevices.mediaCollectorFromObjectId(this.previousAudioSource).getParentDevice();
            int n = this.getDeviceCollector().getMainPartition().getMedium().getCurrentState().getErrorType();
            CurrentAudioSourceState.set(CurrentAudioSourceState.audioSourceStateFromMediumState(n));
        }
    }

    public void reSubmit() {
        ServiceManager.aslPropertyManager.valueChangedInteger(8, this.convertAvailable2CurrentAudioSource(this.previousAudioSource & 0xFFFF0000));
    }

    public void setCurrentAudioSource(MediaCollector mediaCollector) {
        this.nextSourceChangerIndex = mediaCollector.getParentDevice();
        this.setCurrentAudioSource(mediaCollector.getAslDeviceID());
    }

    private int convertAvailable2CurrentAudioSource(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 6;
            }
            case 8: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 10: {
                return 10;
            }
            case 11: {
                return 11;
            }
            case 13: {
                return 13;
            }
            case 17: {
                return 17;
            }
            case 18: {
                return 18;
            }
        }
        ServiceManager.logger.warn(128).append("Invalid current audio source! ").append(n).attachThrowable(new IllegalArgumentException()).log();
        return 0;
    }

    public DeviceCollector getDeviceCollector() {
        return this.nextSourceChangerIndex;
    }
}

