/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.flowlistmenu;

import de.vw.mib.asl.api.background.ASLBackgroundFactory;
import de.vw.mib.asl.api.background.services.ParticleBackgroundService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.flowlistmenu.FlowListMenuServices;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public class FlowListMenuServicesImpl
implements FlowListMenuServices {
    private final Logger logger;
    private final GenericEvents genericEvents;
    private final ServiceRegister serviceRegister;
    private final ParticleBackgroundService particleBackgroundService;

    public FlowListMenuServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.genericEvents = aSLFrameworkAPI.getServices().getGenericEvents();
        this.serviceRegister = this.genericEvents.getServiceRegister();
        this.particleBackgroundService = ASLBackgroundFactory.getBackgroundApi().getParticleBackgroundService();
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public ParticleBackgroundService getParticleBackgroundService() {
        return this.particleBackgroundService;
    }
}

