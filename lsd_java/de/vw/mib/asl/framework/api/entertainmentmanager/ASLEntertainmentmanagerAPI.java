/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;

public interface ASLEntertainmentmanagerAPI {
    default public void register(Object object, Class clazz) {
    }

    default public void deregister(Object object, Class clazz) {
    }

    default public EntertainmentManagerResponder createEntertainmentManagerResponder(int n, int n2) {
    }

    default public int getCurrentContext() {
    }

    default public int getCurrentSubcontext() {
    }
}

