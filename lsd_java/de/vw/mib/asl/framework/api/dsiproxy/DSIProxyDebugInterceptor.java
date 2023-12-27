/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

public interface DSIProxyDebugInterceptor {
    default public void invokeService(int n, int n2, int n3, int n4, Object[] objectArray) {
    }

    default public void invokeResponseListener(int n, int n2, int n3, Object[] objectArray) {
    }

    default public void invokeNotificationListener(int n, int n2, int n3, Object[] objectArray) {
    }

    default public void invokeListenerMethodAdapter(String string, int n, Object[] objectArray) {
    }
}

