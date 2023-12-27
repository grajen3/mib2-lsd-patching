/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.avdc.audio.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import generated.de.vw.mib.asl.internal.avdc.audio.transformer.AbstractAVDCAudioAvailableImportSourcesTransformer;

public class AVDCAudioAvailableImportSourcesTransformer
extends AbstractAVDCAudioAvailableImportSourcesTransformer {
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
            case 4: {
                return deviceCollector.isSeveralAvailablePartitionsAvailable();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    @Override
    public int getInt(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 0: {
                return this.importIdFromAslDeviceId(deviceCollector.getModelDeviceId());
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }

    private int importIdFromAslDeviceId(int n) {
        switch (n) {
            case 1: 
            case 4: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 8: {
                return 3;
            }
            case 10: {
                return 5;
            }
            case 11: {
                return 4;
            }
            case 13: {
                return 6;
            }
            case 15: {
                return 8;
            }
            case 16: {
                return 9;
            }
            case 17: {
                return 10;
            }
            case 18: {
                return 11;
            }
        }
        return 1;
    }

    @Override
    public long getLong(int n, Object object) {
        DeviceCollector deviceCollector = DeviceCollector.get((Device)object);
        switch (n) {
            case 3: {
                return deviceCollector.getObjectId();
            }
        }
        throw new IllegalArgumentException("The given columnID is not handled");
    }
}

