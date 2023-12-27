/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.Logger;

public class SpecialMethodReadCoding
extends AbstractStartupTask {
    private final ASLDiagnosisAPI diagnosisAPI;
    private final Logger logger;

    public SpecialMethodReadCoding(ASLDiagnosisAPI aSLDiagnosisAPI, Logger logger) {
        super(logger);
        this.assertArgumentsAreValid(aSLDiagnosisAPI, logger);
        this.diagnosisAPI = aSLDiagnosisAPI;
        this.logger = logger;
    }

    @Override
    public void runTask() {
        AdaptionApi adaptionApi = this.diagnosisAPI.getAdaptionApi();
        if (adaptionApi != null) {
            this.requestCoding(adaptionApi);
        }
        this.finish();
    }

    private void requestCoding(AdaptionApi adaptionApi) {
        int n = 0;
        int n2 = 0;
        try {
            adaptionApi.requestConfigManagerPersCoding(n, n2);
        }
        catch (GenericEventException genericEventException) {
            this.logger.error(1).append("Error while requesting the coding").attachThrowable(genericEventException);
        }
    }

    private void assertArgumentsAreValid(ASLDiagnosisAPI aSLDiagnosisAPI, Logger logger) {
        if (aSLDiagnosisAPI == null) {
            throw new IllegalArgumentException("Diagnosis API must not be null.");
        }
        if (logger == null) {
            throw new IllegalArgumentException("Logger must not be null.");
        }
    }
}

