/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkDeviceListCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.AbstractMirrorlinkDeviceListTransformer;

public class MirrorlinkDeviceListTransformer
extends AbstractMirrorlinkDeviceListTransformer {
    @Override
    public String getString(int n, Object object) {
        MirrorLinkDeviceListCollector mirrorLinkDeviceListCollector = (MirrorLinkDeviceListCollector)object;
        if (mirrorLinkDeviceListCollector != null && n == 0) {
            String string = mirrorLinkDeviceListCollector.getDeviceName();
            switch (mirrorLinkDeviceListCollector.getConnectionMedium()) {
                case 1: {
                    string = new StringBuffer().append(string).append(" (USB)").toString();
                    break;
                }
                case 2: {
                    string = new StringBuffer().append(string).append(" (WLAN)").toString();
                    break;
                }
                case 0: {
                    string = new StringBuffer().append(string).append(" (OTHER)").toString();
                    break;
                }
            }
            return string;
        }
        return "";
    }
}

