/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.services;

public interface ServiceProviderRegistry {
    default public void registerServiceProvider(Class clazz, Object object) {
    }

    default public void unregisterServiceProvider(Class clazz, Object object) {
    }

    default public Object getServiceListener(Class clazz) {
    }
}

