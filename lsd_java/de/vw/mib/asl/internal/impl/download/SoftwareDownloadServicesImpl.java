/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.download;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.download.SoftwareDownloadServices;
import de.vw.mib.asl.internal.impl.download.DownloadStateServiceImpl;
import de.vw.mib.asl.internal.impl.download.PropagatingDownloadStateService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class SoftwareDownloadServicesImpl
implements SoftwareDownloadServices {
    private final PropagatingDownloadStateService downloadStateService;
    private final DSIProxy dsiProxy;
    private final ConfigurationManagerDiag configManagerDiag;
    private final ASLPropertyManager aslPropertyManager;
    private final Logger logger;
    private GenericEvents genericEvents;

    public SoftwareDownloadServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.aslPropertyManager = services.getASLPropertyManager();
        this.configManagerDiag = services.getConfigurationManagerDiag();
        this.genericEvents = services.getGenericEvents();
        this.downloadStateService = new DownloadStateServiceImpl();
    }

    @Override
    public PropagatingDownloadStateService getDownloadStateService() {
        return this.downloadStateService;
    }

    @Override
    public DSIProxy getDsiProxy() {
        return this.dsiProxy;
    }

    @Override
    public ConfigurationManagerDiag getConfigManagerDiag() {
        return this.configManagerDiag;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public ASLPropertyManager getPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }
}

