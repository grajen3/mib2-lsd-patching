/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKorea;
import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentManagerResponder;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.exboxm.util.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class PersistableExBoxOptions {
    private ExboxKorea persistence;
    private final EntertainmentManagerResponder entertainmentManagerResponder;
    private final Logger logger;

    public PersistableExBoxOptions(Logger logger, ExboxKorea exboxKorea, EntertainmentManagerResponder entertainmentManagerResponder) {
        Preconditions.checkArgumentNotNull(logger, "The Logger must not be null.");
        Preconditions.checkArgumentNotNull(exboxKorea, "The ExboxKorea persistence must not be null.");
        Preconditions.checkArgumentNotNull(entertainmentManagerResponder, "The EntertainmentManagerResponder must not be null.");
        this.logger = logger;
        this.persistence = exboxKorea;
        this.entertainmentManagerResponder = entertainmentManagerResponder;
        this.writePersistenceValuesToModel();
        this.setLastEntertainmentManagerSubContext();
    }

    public void factoryReset() {
        this.persistence.resetToDefaults();
    }

    public boolean isNavAnnouncementDuringPhoneCallEnabled() {
        return this.persistence.isNavigationAnnouncementDuringPhoneCallEnabled();
    }

    public void toggleMuteNavAnnouncementDuringPhone() {
        boolean bl = !this.persistence.isNavigationAnnouncementDuringPhoneCallEnabled();
        this.persistence.setNavigationAnnouncementDuringPhoneCallEnabled(bl);
        if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX: Persisting value for NavAnnouncementsDuringPhone: ").append(bl).log();
        }
        this.writePersistenceValuesToModel();
    }

    private LogMessage traceEx() {
        return this.logger.trace(8);
    }

    private LogMessage errorEx() {
        return this.logger.error(8);
    }

    private boolean isTraceEnabledEx() {
        return this.logger.isTraceEnabled(8);
    }

    public void writePersistenceValuesToModel() {
        boolean bl = this.persistence.isNavigationAnnouncementDuringPhoneCallEnabled();
        if (this.isTraceEnabledEx()) {
            this.traceEx().append("EX: Pushing persisted value for NavAnnouncementsDuringPhone: ").append(bl).log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(1510, !bl);
    }

    void changePersistence(ExboxKorea exboxKorea) {
        Preconditions.checkArgumentNotNull(exboxKorea, "Persistence must not be null.");
        this.persistence = exboxKorea;
        this.writePersistenceValuesToModel();
        this.setLastEntertainmentManagerSubContext();
    }

    private void setLastEntertainmentManagerSubContext() {
    }
}

