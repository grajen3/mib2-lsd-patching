/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;

public interface EsoPosProviderFullReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateState(boolean bl, sConfig sConfig2, int n) {
    }

    default public void updatePosition(String[] stringArray, sMapPosition sMapPosition2, sPosition[] sPositionArray) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }
}

