/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

public interface AsyncServiceFactory {
    public static final String OSGI_PROPERTY_MIB_THREAD_ID;

    default public Object create(Object object) {
    }

    default public Object create(Object object, Class[] classArray) {
    }

    default public Object createNarrow(Object object, Class[] classArray) {
    }
}

