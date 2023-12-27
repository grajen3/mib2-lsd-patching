/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.filebrowser.transformer.AbstractFileBrowserAvailableSourcev2Transformer;

public class FileBrowserAvailableSourcev2Transformer
extends AbstractFileBrowserAvailableSourcev2Transformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        if (n == 1) {
            Device device = (Device)object;
            return device.getCurrentState().countPictureViewerAvailable() > 0;
        }
        return false;
    }

    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            Device device = (Device)object;
            switch (device.getCurrentState().getInfo().deviceType) {
                case 3: 
                case 4: {
                    return 1;
                }
                case 1: {
                    return this.sdCard(device);
                }
                case 2: {
                    switch (device.getSlot()) {
                        case 0: {
                            return 3;
                        }
                        case 1: {
                            return 9;
                        }
                        case 2: {
                            return 12;
                        }
                        case 3: {
                            return 13;
                        }
                    }
                    ServiceManager.logger2.error(256).append("unknown USB slot ").append(device.getSlot()).log();
                    return 3;
                }
                case 0: {
                    return 8;
                }
                case 10: {
                    return 5;
                }
            }
        }
        return 0;
    }

    private int sdCard(Device device) {
        if (device.getSlot() == 0) {
            if (device.getMedium(0).getCurrentInfo().getMediaType() != 19) {
                return 2;
            }
            return 10;
        }
        if (device.getMedium(0).getCurrentInfo().getMediaType() != 19) {
            return 6;
        }
        return 11;
    }
}

