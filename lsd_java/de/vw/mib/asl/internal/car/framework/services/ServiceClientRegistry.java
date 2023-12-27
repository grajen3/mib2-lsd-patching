/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.services;

public interface ServiceClientRegistry {
    default public void registerServiceClient(Class clazz, Object object) {
    }

    default public void unregisterServiceClient(Class clazz, Object object) {
    }

    default public Object getServiceProvider(Class clazz) {
    }
}

