/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui.dispatcher.internal.cio;

import de.vw.mib.appui.cio.CioIdServiceUser;
import de.vw.mib.appui.cio.CioVisualizationRegister;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import de.vw.mib.cio.framework.CioVisualizationService;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import java.util.Iterator;

public class CioVisualizationServiceDispatcher
implements CioVisualizationService,
CioVisualizationRegister,
CioIdServiceUser {
    private static final String HEADER;
    private final Logger logger;
    private final ObjectObjectMap relayServices;
    private CioIdService cachedCioIdService;

    public CioVisualizationServiceDispatcher(LoggerFactory loggerFactory) {
        Preconditions.checkNotNull(loggerFactory, "loggerFactory");
        this.logger = loggerFactory.getLogger(3);
        this.relayServices = new ObjectObjectOptHashMap();
    }

    @Override
    public void registerRelayService(String string, String string2, CioVisualizationService cioVisualizationService) {
        Preconditions.checkNotNull(string, "appName");
        Preconditions.checkArgument(string.length() > 0, "expect not empty appName");
        Preconditions.checkNotNull(string2, "appInstanceName");
        Preconditions.checkNotNull(cioVisualizationService, "relayService");
        String string3 = CioVisualizationServiceDispatcher.getRegisterKey(string, string2);
        Preconditions.checkArgument(!this.relayServices.containsKey(string3), new StringBuffer().append("Relay service for app '").append(string).append("' instance '").append(string2).append("' already registered.").toString());
        this.relayServices.put(string3, cioVisualizationService);
        if (this.cachedCioIdService != null) {
            cioVisualizationService.load(this.cachedCioIdService);
        }
    }

    @Override
    public void unregisterRelayService(String string, String string2) {
        Preconditions.checkNotNull(string, "appName");
        Preconditions.checkArgument(string.length() > 0, "expect not empty appName");
        Preconditions.checkNotNull(string2, "appInstanceName");
        String string3 = CioVisualizationServiceDispatcher.getRegisterKey(string, string2);
        Preconditions.checkArgument(this.relayServices.containsKey(string3), new StringBuffer().append("Relay service for app '").append(string).append("' instance '").append(string2).append("' not registered.").toString());
        this.relayServices.remove(string3);
    }

    private static String getRegisterKey(String string, String string2) {
        return new StringBuffer().append(string).append(":").append(string2).toString();
    }

    @Override
    public CioIntentVisualization getVisualization(long l) {
        Iterator iterator = this.relayServices.valueIterator();
        while (iterator.hasNext()) {
            CioVisualizationService cioVisualizationService = (CioVisualizationService)iterator.next();
            CioIntentVisualization cioIntentVisualization = cioVisualizationService.getVisualization(l);
            if (cioIntentVisualization == CioIntentVisualizationImpl.NOT_AVAILABLE) continue;
            return cioIntentVisualization;
        }
        this.logger.warn(1).append("[CIO Visualization] ").append("Unknown ID for visualization: ").append(l).log();
        return CioIntentVisualizationImpl.DEFAULT;
    }

    @Override
    public void load(CioIdService cioIdService) {
        Preconditions.checkNotNull(cioIdService, "cioIdService");
        this.cachedCioIdService = cioIdService;
        if (this.relayServices.isEmpty()) {
            String string = "CioVisualizationServiceDispatcher wants to load, but no apps registered yet. ";
            this.logger.info(4).append("[CIO Visualization] ").append("CioVisualizationServiceDispatcher wants to load, but no apps registered yet. ").log();
        } else {
            this.relayLoad();
        }
    }

    private void relayLoad() {
        Iterator iterator = this.relayServices.valueIterator();
        while (iterator.hasNext()) {
            CioVisualizationService cioVisualizationService = (CioVisualizationService)iterator.next();
            cioVisualizationService.load(this.cachedCioIdService);
        }
    }

    @Override
    public void loadDone() {
    }

    @Override
    public void setCioIdService(CioIdService cioIdService) {
        this.load(cioIdService);
    }
}

