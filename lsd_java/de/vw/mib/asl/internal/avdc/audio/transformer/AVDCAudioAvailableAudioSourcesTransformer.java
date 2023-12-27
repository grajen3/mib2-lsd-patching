/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AbstractAVDCAudioAvailableAudioSourcesTransformer;

public class AVDCAudioAvailableAudioSourcesTransformer
extends AbstractAVDCAudioAvailableAudioSourcesTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 1: {
                return deviceCollector.isDeviceActive();
            }
            case 2: {
                return deviceCollector.isUserAvailable();
            }
            case 7: {
                return deviceCollector.isSeveralAvailablePartitionsAvailable();
            }
            case 9: {
                return deviceCollector.getMainPartition().supportsBrowsing();
            }
            case 8: {
                return deviceCollector.getMainPartition().getMediaCaps() != null && deviceCollector.getMainPartition().getMediaCaps().isVideoSupport();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 0: {
                return deviceCollector.getModelDeviceId();
            }
            case 4: {
                return deviceCollector.getMainPartition().getMediaType();
            }
            case 5: {
                return deviceCollector.getMainPartition().getFlags();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public String getString(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 3: {
                if (deviceCollector == null || deviceCollector.getMainPartition() == null || deviceCollector.getMainPartition().getName() == null || deviceCollector.getMainPartition().getName().startsWith("medium.")) {
                    return "";
                }
                return deviceCollector.getMainPartition().getName();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public long getLong(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 6: {
                return deviceCollector.getAudioSourceObjectId();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

