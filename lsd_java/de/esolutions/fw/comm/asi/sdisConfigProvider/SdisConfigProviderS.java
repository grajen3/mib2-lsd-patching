/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;

public interface SdisConfigProviderS {
    default public void setNotification(SdisConfigProviderReply sdisConfigProviderReply) {
    }

    default public void setNotification(long l, SdisConfigProviderReply sdisConfigProviderReply) {
    }

    default public void setNotification(long[] lArray, SdisConfigProviderReply sdisConfigProviderReply) {
    }

    default public void clearNotification(SdisConfigProviderReply sdisConfigProviderReply) {
    }

    default public void clearNotification(long l, SdisConfigProviderReply sdisConfigProviderReply) {
    }

    default public void clearNotification(long[] lArray, SdisConfigProviderReply sdisConfigProviderReply) {
    }
}

