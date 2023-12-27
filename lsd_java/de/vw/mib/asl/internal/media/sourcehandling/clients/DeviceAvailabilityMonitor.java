/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.DeviceState;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.sourcehandling.Timer;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaContext;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaSourcesAudio;
import de.vw.mib.log4mib.LogMessage;

public final class DeviceAvailabilityMonitor
extends DeviceChangeListener {
    private final MediaContext mediaContext;
    private final MediaSourcesAudio mediaSourcesAudio;
    private final Timer timer;
    private Devices devices;
    private MediaCollector hdd = MediaCollector.EMPTY;
    private boolean standby = false;

    public DeviceAvailabilityMonitor(DeviceFilter deviceFilter, MediaContext mediaContext, MediaSourcesAudio mediaSourcesAudio, Timer timer) {
        super(deviceFilter);
        this.mediaContext = mediaContext;
        this.mediaSourcesAudio = mediaSourcesAudio;
        this.timer = timer;
    }

    private void reportInvalidDeviceStates() {
        if (!this.standby) {
            for (int i2 = 0; i2 < this.devices.count(); ++i2) {
                Device device = this.devices.get(i2);
                if (device.getCurrentState().isOperable()) continue;
                MediaObjectAccessor.getModelController().reportDeviceError(device);
            }
        }
    }

    @Override
    public void onChange(Device device) {
        MediaObjectAccessor.getModelController().reportDeviceState(device);
        this.logDeviceState(device);
        boolean bl = device.getCurrentState().isOperable();
        if (!bl) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Unavailable device: ").append(device).log();
            }
            if (this.mediaContext.isMedia() && DeviceCollector.get(device).isDeviceActive() && !this.timer.isActive()) {
                CurrentAudioSourceState.setIgnoreError(true);
                this.timer.start(20000);
            }
        }
    }

    @Override
    public void onUpdate(Devices devices) {
        Device device;
        this.devices = devices;
        if (this.hdd == MediaCollector.EMPTY && (device = this.devices.getByDeviceType(0, 0)) != null) {
            this.hdd = DeviceCollector.get(device).getMainPartition();
        }
        if (devices.isInitialized()) {
            this.reportDeviceAvailability();
            super.onUpdate(devices);
        }
    }

    private void reportDeviceAvailability() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1690, this.devices.getByDeviceType(1, 1) != null);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3016, this.devices.getByDeviceType(2, 0) != null);
        Device device = this.devices.getByDeviceType(2, 1);
        boolean bl = device != null && device.getCurrentState().isListed();
        ServiceManager.aslPropertyManager.valueChangedBoolean(3815, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3678, bl);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.AVDC.IsSecondUsbSocketAvailable", bl);
        boolean bl2 = this.devices.getByDeviceType(9, 0) != null;
        ServiceManager.aslPropertyManager.valueChangedBoolean(3928, bl2);
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.AVDC.IsMediaSourceWlanAvailable", bl2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(3840, this.devices.getByDeviceType(8, 0) != null);
        ServiceManager.aslPropertyManager.valueChangedBoolean(2856, this.devices.getByDeviceType(8, 0) != null);
    }

    private void logDeviceState(Device device) {
        int n;
        int n2 = device.getPreviousInfo().getFlags();
        if (n2 != (n = device.getCurrentInfo().getFlags())) {
            LogMessage logMessage = ServiceManager.logger.info(1024).append(device).append(" device flag changes. 0x").append(Integer.toHexString(n2)).append(" to 0x").append(Integer.toHexString(n));
            this.append(logMessage, " added ", n & ~n2);
            this.append(logMessage, " removed ", ~n & n2);
            logMessage.log();
        }
    }

    private void append(LogMessage logMessage, String string, int n) {
        if (n != 0) {
            logMessage.append(string).append(DeviceState.getDeviceFlagsStr(n));
        }
    }

    public Devices getDevices() {
        return this.devices;
    }

    public MediaCollector getHdd() {
        return this.hdd;
    }

    public void stopTimer() {
        this.timer.stop();
    }

    public void deviceTimedOut() {
        int n = MediaCollector.get(this.mediaSourcesAudio.getActiveSource()).getAslDeviceID();
        if (n != 0) {
            CurrentAudioSourceState.setIgnoreError(false);
            CurrentAudioSourceState.resubmit();
        }
        this.reportInvalidDeviceStates();
    }

    public void setStandby(boolean bl) {
        if (this.standby && !bl) {
            CurrentAudioSourceState.setIgnoreError(true);
            this.timer.start(20000);
        }
        this.standby = bl;
    }
}

