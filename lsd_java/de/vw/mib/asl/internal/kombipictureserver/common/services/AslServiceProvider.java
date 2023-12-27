/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.services;

public interface AslServiceProvider {
    default public Object getService(Object object, Class clazz) {
    }

    default public void registerServiceListener(Object object, Class clazz, int[] nArray) {
    }

    default public void removeServiceListener(Object object, Class clazz, int[] nArray) {
    }

    default public void updateAllServiceListeners(Class clazz) {
    }
}

