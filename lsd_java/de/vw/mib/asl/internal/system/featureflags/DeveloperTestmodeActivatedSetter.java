/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.featureflags;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public class DeveloperTestmodeActivatedSetter {
    public static final String LOGGING_DELIM;
    private final ASLPropertyManager propertyManager;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final Logger logger;
    private final int subClassifier;
    private boolean isStartupDone = false;

    public DeveloperTestmodeActivatedSetter(ASLPropertyManager aSLPropertyManager, ConfigurationManagerDiag configurationManagerDiag, Logger logger, int n) {
        this.propertyManager = aSLPropertyManager;
        this.configurationManagerDiag = configurationManagerDiag;
        this.logger = logger;
        this.subClassifier = n;
    }

    public void processDiagAdaptationData(Adaptation adaptation) {
        boolean bl = adaptation.getBoolean(121);
        if (this.isTraceEnabled()) {
            this.trace().append("[DeveloperTestmodeActivatedSetter] ").append("processDiagAdaptation").log();
            this.trace().append("[DeveloperTestmodeActivatedSetter] ").append("testmodeIsAllowedByDiagnosis: ").append(bl).log();
        }
        this.installFeatureFlagTestmodeAvailable(bl);
        if (this.isStartupDone) {
            this.installHMITestmodeAvailability();
        }
    }

    public void processStartupIsDone() {
        this.isStartupDone = true;
        this.installHMITestmodeAvailability();
    }

    private void installFeatureFlagTestmodeAvailable(boolean bl) {
        this.configurationManagerDiag.setFeatureFlagValue("ASL.System.IsTestmodeAvailable", bl);
    }

    private boolean retrieveFeatureFlagTestmodeActivated() {
        return this.configurationManagerDiag.isFeatureFlagSet(400);
    }

    private void installHMITestmodeAvailability() {
        boolean bl = this.retrieveFeatureFlagTestmodeActivated();
        this.propertyManager.valueChangedBoolean(1701, bl);
        this.propertyManager.valueChangedBoolean(1617, bl);
        this.info().append("Setting testmode available to: ").append(String.valueOf(bl)).log();
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(this.subClassifier);
    }

    private LogMessage trace() {
        return this.logger.trace(this.subClassifier);
    }

    private LogMessage info() {
        return this.logger.info(this.subClassifier);
    }
}

