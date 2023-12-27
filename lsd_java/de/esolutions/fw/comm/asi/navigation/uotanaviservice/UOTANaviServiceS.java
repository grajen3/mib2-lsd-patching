/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;

public interface UOTANaviServiceS {
    default public void registerClient(int n, UOTANaviServiceReply uOTANaviServiceReply) {
    }

    default public void respondVersionInfo(short s, ComponentInfo[] componentInfoArray, int n, UOTANaviServiceReply uOTANaviServiceReply) {
    }
}

