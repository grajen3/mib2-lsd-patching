/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.filebrowser.transformer;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import generated.de.vw.mib.asl.internal.filebrowser.transformer.AbstractFileBrowserAvailableSourcesTransformer;

public class FileBrowserAvailableSourcesTransformer
extends AbstractFileBrowserAvailableSourcesTransformer {
    static /* synthetic */ Class class$java$lang$Integer;

    @Override
    public int getInt(int n, Object object) {
        if (n == 0) {
            if (object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = FileBrowserAvailableSourcesTransformer.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                return (Integer)object;
            }
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

