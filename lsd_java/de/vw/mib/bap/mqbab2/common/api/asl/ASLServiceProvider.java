/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.asl;

public interface ASLServiceProvider {
    default public Object getService(Object object, Class clazz) {
    }

    default public void registerServiceListener(Object object, Class clazz, int[] nArray) {
    }

    default public void removeServiceListener(Object object, Class clazz, int[] nArray) {
    }
}

