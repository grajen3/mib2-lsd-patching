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

public class MediaFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    private static final String LOGGING_DELIM;
    private final ConfigurationManagerDiag configurationManager;
    private boolean flagAmiAvailable;
    private final Logger logger;
    private final TvAndVideoDisplayableFactoryResetPersistanceWriter writer;

    public MediaFactoryResetParticipant(DisplayManagementServices displayManagementServices, DSIDisplayManagement dSIDisplayManagement) {
        this.checkConstructorArguments(displayManagementServices, dSIDisplayManagement);
        this.writer = new TvAndVideoDisplayableFactoryResetPersistanceWriter(displayManagementServices, dSIDisplayManagement);
        this.configurationManager = displayManagementServices.getConfigurationManager();
        this.logger = displayManagementServices.getLogger();
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.revertVideoSettings();
        factoryResetCallback.notifyResetDone();
    }

    public void setFlagAmiAvailable(boolean bl) {
        this.flagAmiAvailable = bl;
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

    private void revertVideoSettings() {
        if (this.isTraceEnabled()) {
            this.trace("revertVideoSettings");
        }
        if (this.flagAmiAvailable) {
            this.writer.applyDefaultVideoOrTvDisplayableData(27);
        }
        if (this.configurationManager.isFeatureFlagSet(70)) {
            this.writer.applyDefaultVideoOrTvDisplayableData(43);
        }
    }

    private void trace(String string) {
        this.logger.trace(4096, new StringBuffer().append("[MediaFactoryResetParticipant] ").append(string).toString());
    }
}

