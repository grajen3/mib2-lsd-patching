/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.background.api.impl;

import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.internal.background.api.impl.ASLBackgroundAPIImpl;

public class ServiceInstaller {
    private final ASLBackgroundAPIImpl api;

    public ServiceInstaller(ASLBackgroundAPIImpl aSLBackgroundAPIImpl) {
        this.api = aSLBackgroundAPIImpl;
    }

    public void installParticleBackgroundService(ParticleBackgroundService particleBackgroundService) {
        this.api.setParticleBackgroundService(particleBackgroundService);
    }
}

