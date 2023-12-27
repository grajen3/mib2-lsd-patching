/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.factoryreset;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public class SystemFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    private static final String LOGGING_DELIM;
    private final ConfigurationManagerDiag configurationManager;
    private final DSIDisplayManagement dsiDisplayManagement;
    private final Logger logger;
    private final ASLSystemAPI systemApi;

    public SystemFactoryResetParticipant(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        this.checkConstructorArguments(displayManagementServices, dSIDisplayManagement);
        this.dsiDisplayManagement = dSIDisplayManagement;
        this.systemApi = displayManagementServices.getAslSystemApi();
        this.logger = displayManagementServices.getLogger();
        this.configurationManager = displayManagementServices.getConfigurationManager();
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.revertDisplaySettings();
        factoryResetCallback.notifyResetDone();
    }

    private void checkConstructorArguments(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        if (displayManagementServices == null) {
            throw new IllegalArgumentException("Display managment services must not be null.");
        }
        if (dSIDisplayManagement == null) {
            throw new IllegalArgumentException("DSI display management must not be null.");
        }
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void revertDisplaySettings() {
        if (this.isTraceEnabled()) {
            this.trace("Revert display management settings for system component.");
        }
        int n = this.systemApi.mapValue(this.configurationManager.getSystemDisplayBrightnessDefault(), 0, 4, 100, 0);
        this.dsiDisplayManagement.setDisplayBrightness(0, n);
        this.dsiDisplayManagement.getDisplayBrightness(0);
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[SystemFactoryResetParticipant] ").append(string).toString());
    }
}

