/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.displaymanagement.factoryreset.TvAndVideoDisplayableFactoryResetPersistanceWriter;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public class TvTunerFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    private static final String LOGGING_DELIM;
    private final ConfigurationManagerDiag configurationManager;
    private final Logger logger;
    private final TvAndVideoDisplayableFactoryResetPersistanceWriter writer;

    public TvTunerFactoryResetParticipant(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        this.checkConstructorArguments(displayManagementServices, dSIDisplayManagement);
        this.writer = new TvAndVideoDisplayableFactoryResetPersistanceWriter(displayManagementServices, dSIDisplayManagement);
        this.logger = displayManagementServices.getLogger();
        this.configurationManager = displayManagementServices.getConfigurationManager();
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.revertTvSettings();
        factoryResetCallback.notifyResetDone();
    }

    private void checkConstructorArguments(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        if (displayManagementServices == null) {
            throw new IllegalArgumentException("Display management services must not be null.");
        }
        if (dSIDisplayManagement == null) {
            throw new IllegalArgumentException("DSI display management must not be null");
        }
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(4096);
    }

    private void revertTvSettings() {
        if (this.configurationManager.isFeatureFlagSet(425)) {
            if (this.isTraceEnabled()) {
                this.trace("revertTvSettings");
            }
            this.writer.applyDefaultVideoOrTvDisplayableData(26);
            this.writer.applyDefaultVideoOrTvDisplayableData(29);
        }
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[TvTunerFactoryResetParticipant] ").append(string).toString());
    }
}

