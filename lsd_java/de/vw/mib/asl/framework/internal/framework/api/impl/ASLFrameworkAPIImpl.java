/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.api.impl;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.api.impl.ServicesImpl;
import de.vw.mib.log4mib.Logger;

public class ASLFrameworkAPIImpl
implements ASLFrameworkAPI {
    private static final ServicesImpl SERVICES_INSTANCE = new ServicesImpl();

    @Override
    public Logger getASLLogger() {
        return ServiceManager.logger;
    }

    @Override
    public Logger getASL2Logger() {
        return ServiceManager.logger2;
    }

    @Override
    public Services getServices() {
        return SERVICES_INSTANCE;
    }

    @Override
    public ASLComponentFactory getASLComponentFactory() {
        return ServiceManager.componentFactory;
    }
}

