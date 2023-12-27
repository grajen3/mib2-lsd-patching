/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import generated.de.vw.mib.asl.internal.pictureviewer.transformer.AbstractPictureViewerAvailableBrowsingSourcesTransformer;

public class PictureViewerAvailableBrowsingSourcesTransformer
extends AbstractPictureViewerAvailableBrowsingSourcesTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        Device device = (Device)object;
        if (n == 2) {
            return device.getCurrentState().countPictureViewerAvailable() > 0;
        }
        if (n == 1) {
            return device.tags().containsKey(-1863904256);
        }
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            Device device = (Device)object;
            if (device.isInternalOptical()) {
                return 1;
            }
            switch (device.getCurrentInfo().getDeviceType()) {
                case 1: {
                    if (device.getSlot() == 0) {
                        if (device.getMedium(0).getCurrentInfo().getMediaType() == 19) {
                            return 8;
                        }
                        return 2;
                    }
                    if (device.getMedium(0).getCurrentInfo().getMediaType() == 19) {
                        return 9;
                    }
                    return 6;
                }
                case 2: {
                    if (device.getSlot() == 0) {
                        return 3;
                    }
                    return 7;
                }
            }
            return 1;
        }
        return 0;
    }

    @Override
    public String getString(int n, Object object) {
        Device device = (Device)object;
        if (n == 3) {
            return device.getMainMedium().getCurrentInfo().getName();
        }
        throw new IllegalArgumentException();
    }
}

