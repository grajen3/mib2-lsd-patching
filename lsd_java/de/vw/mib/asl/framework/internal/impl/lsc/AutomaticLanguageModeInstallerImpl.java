/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.lsc.AutomaticLanguageModeInstaller;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.Logger;

public class AutomaticLanguageModeInstallerImpl
implements AutomaticLanguageModeInstaller {
    private final IPersistableEarlyData persistableData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
    private boolean pqLscAutomaticModeAktive = false;
    private int lastUpdatedLanguageforPqCase = -1;
    private final Services services;
    private final Logger logger;

    public AutomaticLanguageModeInstallerImpl(Services services, Logger logger) {
        this.services = services;
        this.logger = logger;
    }

    @Override
    public void activateAutomaticLanguageMode(boolean bl) {
        this.logger.info(64).append("LSC Automatic mode ").append(bl ? "ACTIVATED" : "DEACTIVATED").log();
        this.setPqLscAutomaticModeAktive(bl);
        this.persistableData.setPqLscAutomaticModeActive(bl);
        this.services.getASLPropertyManager().valueChangedBoolean(892477440, bl);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.logger.trace(64).append("RECONNECT");
            }
            if (this.lastUpdatedLanguageforPqCase != -1) {
                if (this.isTraceEnabled()) {
                    this.logger.trace(64).append("[AslTargetLscTNGBullhorn]").append("setting language for PQ case").log();
                }
                try {
                    EventGeneric eventGeneric = this.services.getEventFactory().newEvent(23730176);
                    eventGeneric.setInt(0, this.lastUpdatedLanguageforPqCase);
                    this.services.getGenericEvents().getEventDispatcher().send(eventGeneric);
                }
                catch (GenericEventException genericEventException) {
                    this.logger.error(64).attachThrowable(genericEventException).log();
                }
            } else if (this.isTraceEnabled()) {
                this.logger.trace(64).append("no new language received in mean time");
            }
        } else if (this.isTraceEnabled()) {
            this.logger.trace(64).append("DISCONNECT");
        }
    }

    @Override
    public boolean isPqLscAutomaticModeAktive() {
        return this.pqLscAutomaticModeAktive;
    }

    @Override
    public void setPqLscAutomaticModeAktive(boolean bl) {
        this.pqLscAutomaticModeAktive = bl;
    }

    @Override
    public int getLastUpdatedLanguageforPqCase() {
        return this.lastUpdatedLanguageforPqCase;
    }

    @Override
    public void setLastUpdatedLanguageforPqCase(int n) {
        this.lastUpdatedLanguageforPqCase = n;
    }

    @Override
    public IPersistableEarlyData getPersistableData() {
        return this.persistableData;
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(64);
    }
}

