/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaContext;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public final class AutoplayDetector
extends DeviceChangeListener {
    private final MediaContext mediaContext;

    public AutoplayDetector(DeviceFilter deviceFilter, MediaContext mediaContext) {
        super(deviceFilter);
        this.mediaContext = mediaContext;
    }

    private void sourceRemoved(Device device) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AutoplayDetector.sourceRemoved(): ").append(device).log();
        }
        DeviceCollector deviceCollector = DeviceCollector.get(device);
        if (device.isOptical() && deviceCollector.isDeviceActive()) {
            SourceHandlingPersistence.getInstance().setOpticalContentType(1);
            SourceIconController.getInstance().reSubmit();
        }
        if (deviceCollector.isDeviceActive()) {
            if (!device.getCurrentState().isPlayable()) {
                this.mediaContext.setDisconnectedState();
            } else {
                this.playFirstPlayablePartition(device);
            }
        }
        if (device.getMainMedium().getPreviousState().isDVDVideoAudio()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(152, false);
        }
    }

    private void sourceAdded(MediaCollector mediaCollector) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("AutoplayDetector.sourceAdded()").log();
        }
        mediaCollector.makeMainPartition();
        MediaObjectAccessor.mMediaController.insertActivateSourceCmd(mediaCollector, true);
    }

    @Override
    public void onChange(Device device) {
        if (device.getPreviousState().isListed()) {
            this.checkForRemovedSource(device);
            AutoplayDetector.determineMainPartition(device);
            this.checkForValidInsertedMedia(device);
        } else {
            ServiceManager.logger.warn(128).append("No previous entry in source list for: ").append(device).log();
        }
        Medium medium = device.getMedium(0);
        if (medium.isTypeEntered(12)) {
            MediaObjectAccessor.getModelController().reportMediumLoading(device);
            DeviceCollector.get(device).reset();
        }
        if (medium.isTypeExitted(12)) {
            MediaObjectAccessor.getModelController().reportMediumLoadingFinished(device);
            this.removePlaySelection(device);
        }
        if (device.getPreviousState().isAnyLoading() && !device.getCurrentState().isAnyLoading()) {
            MediaObjectAccessor.getModelController().reportMediumError(device.getMainMedium());
        }
    }

    private void removePlaySelection(Device device) {
        for (int i2 = 0; i2 < device.getMediumCount(); ++i2) {
            Medium medium = device.getMedium(i2);
            if (device.isDisconnectable()) continue;
            MediaObjectAccessor.getPersistence().removePlaySelection(MediaCollector.get(medium).getObjectId());
        }
    }

    private static void determineMainPartition(Device device) {
        DeviceCollector deviceCollector;
        MediaCollector mediaCollector;
        if (device.getPreviousState().isAnyLoading() && (mediaCollector = (deviceCollector = DeviceCollector.get(device)).firstPlayable()) != null && !deviceCollector.getMainPartition().isMediaPlayable() && deviceCollector.getMainPartition() != mediaCollector && mediaCollector.isMediaPlayable()) {
            mediaCollector.makeMainPartition();
        }
    }

    private void checkForValidInsertedMedia(Device device) {
        MediaCollector mediaCollector = DeviceCollector.get(device).getMainPartition();
        if (mediaCollector.getMedium().isJustLoaded() && DeviceCollector.get(device).isDeviceActive() && this.mediaContext.isMedia()) {
            this.sourceAdded(mediaCollector);
        }
    }

    private void playFirstPlayablePartition(Device device) {
        MediaCollector mediaCollector = DeviceCollector.get(device).firstPlayable();
        if (mediaCollector == null) {
            mediaCollector = MediaCollector.get(device.getMedium(0));
            ServiceManager.logger.warn(128).append("AutoplayDetector.playFirstPlayablePartition() has no playable partition! ").append(device).log();
        }
        int n = mediaCollector.getMedium().getCurrentState().getErrorType();
        if (!device.getCurrentState().isPlayable() && !device.getCurrentState().isAnyLoading()) {
            MediaObjectAccessor.getModelController().reportMediumError(device, n);
        } else {
            MediaObjectAccessor.getModelController().reportMediumError(device, 0);
        }
        if (n == 0) {
            if (ServiceManager.logger.isTraceEnabled(128)) {
                ServiceManager.logger.trace(128).append("Playable media source inserted: ").append(mediaCollector).log();
            }
            this.sourceAdded(mediaCollector);
        }
    }

    private void checkForRemovedSource(Device device) {
        Medium medium = DeviceCollector.get(device).getMainPartition().getMedium();
        if (medium.isFlagEntered(4096) || medium.isFlagEntered(16)) {
            if (DeviceCollector.get(device).getMainPartition().isOpticalMediaPlaybackToBeBlocked()) {
                MediaObjectAccessor.getModelController().reportMediumImportActive(device);
            }
            return;
        }
        if (DeviceCollector.get(device).getMainPartition().getMedium().getCurrentState().isOpticalRom() && medium.isFlagChanged(16) && !medium.isFlagEntered(16)) {
            MediaObjectAccessor.getModelController().reportMediumError(medium);
        }
        if (medium.isJustFullyRemoved()) {
            this.sourceRemoved(device);
        }
    }
}

