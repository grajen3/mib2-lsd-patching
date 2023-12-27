/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkDeviceListCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.AbstractMirrorlinkDeviceListsTransformer;

public class MirrorlinkDeviceListsTransformer
extends AbstractMirrorlinkDeviceListsTransformer {
    @Override
    public String getString(int n, Object object) {
        MirrorLinkDeviceListCollector mirrorLinkDeviceListCollector = (MirrorLinkDeviceListCollector)object;
        if (mirrorLinkDeviceListCollector != null && n == 0) {
            String string = mirrorLinkDeviceListCollector.getDeviceName();
            return string;
        }
        return "";
    }

    @Override
    public int getInt(int n, Object object) {
        MirrorLinkDeviceListCollector mirrorLinkDeviceListCollector = (MirrorLinkDeviceListCollector)object;
        if (mirrorLinkDeviceListCollector != null && n == 2) {
            int n2 = 0;
            switch (mirrorLinkDeviceListCollector.getConnectionMedium()) {
                case 1: {
                    n2 = 1;
                    break;
                }
                case 2: {
                    n2 = 2;
                    break;
                }
                case 0: {
                    n2 = 0;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
            return n2;
        }
        return 0;
    }
}

