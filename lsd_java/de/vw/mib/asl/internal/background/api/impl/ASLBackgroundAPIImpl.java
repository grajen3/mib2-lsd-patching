/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.background.api.impl;

import de.vw.mib.asl.api.background.ASLBackgroundAPI;
import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.internal.background.api.impl.ASLBackgroundAPIImpl$1;

public class ASLBackgroundAPIImpl
implements ASLBackgroundAPI {
    private ParticleBackgroundService particleBackgroundService = this.createEmptyParticleBackgroundService();

    @Override
    public ParticleBackgroundService getParticleBackgroundService() {
        return this.particleBackgroundService;
    }

    void setParticleBackgroundService(ParticleBackgroundService particleBackgroundService) {
        this.particleBackgroundService = particleBackgroundService;
    }

    private ParticleBackgroundService createEmptyParticleBackgroundService() {
        return new ASLBackgroundAPIImpl$1(this);
    }
}

