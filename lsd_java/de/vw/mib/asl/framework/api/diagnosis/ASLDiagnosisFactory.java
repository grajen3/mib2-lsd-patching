/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLDiagnosisFactory
extends ASLFactoryBase {
    private static ASLDiagnosisAPI diagnosisApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI;

    public static ASLDiagnosisAPI getDiagnosisApi() {
        if (diagnosisApiInstance == null) {
            diagnosisApiInstance = (ASLDiagnosisAPI)ASLDiagnosisFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI == null ? (class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI = ASLDiagnosisFactory.class$("de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI")) : class$de$vw$mib$asl$framework$api$diagnosis$ASLDiagnosisAPI, "de.vw.mib.asl.framework.internal.diagnosis.api.impl.ASLDiagnosisAPIImpl");
        }
        return diagnosisApiInstance;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

