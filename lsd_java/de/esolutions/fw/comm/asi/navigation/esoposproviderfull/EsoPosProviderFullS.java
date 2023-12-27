/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;

public interface EsoPosProviderFullS {
    default public void setActive(boolean bl, EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void setConfig(sConfig sConfig2, EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void setNotification(EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void setNotification(long l, EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void setNotification(long[] lArray, EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void clearNotification(EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void clearNotification(long l, EsoPosProviderFullReply esoPosProviderFullReply) {
    }

    default public void clearNotification(long[] lArray, EsoPosProviderFullReply esoPosProviderFullReply) {
    }
}

