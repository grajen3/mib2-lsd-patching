/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.diagnosis.ReadCodingAll$1;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;

public class ReadCodingAll {
    private Logger logger;

    public ReadCodingAll(ASLDiagnosisAPI aSLDiagnosisAPI, Logger logger) {
        Preconditions.checkNotNull(aSLDiagnosisAPI, "Diagnosis API must not be null!");
        Preconditions.checkNotNull(logger, "Logger must not be null!");
        this.logger = logger;
        this.requestCodingAll(aSLDiagnosisAPI);
    }

    private void requestCodingAll(ASLDiagnosisAPI aSLDiagnosisAPI) {
        aSLDiagnosisAPI.getAdaptionApi().requestCoding(this.createCodingAllAdaptationResponse());
    }

    protected void setCarTypeVw511(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(10898, bl);
    }

    private AdaptionResponse createCodingAllAdaptationResponse() {
        return new ReadCodingAll$1(this);
    }

    static /* synthetic */ Logger access$000(ReadCodingAll readCodingAll) {
        return readCodingAll.logger;
    }
}

