/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.entertainmentmanager;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerUpdates;

public interface EntertainmentManagerService {
    default public void addListener(EntertainmentManagerUpdates entertainmentManagerUpdates) {
    }

    default public void requestContext(int n) {
    }

    default public void requestBand(int n) {
    }
}

