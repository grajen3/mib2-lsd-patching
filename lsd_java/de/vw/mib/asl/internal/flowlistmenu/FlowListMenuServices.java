/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.flowlistmenu;

import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public interface FlowListMenuServices {
    default public Logger getLogger() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public ParticleBackgroundService getParticleBackgroundService() {
    }
}

