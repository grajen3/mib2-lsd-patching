/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.api.impl;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.internal.diagnosis.api.impl.DiagnosisServicesProvider;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;

public class ASLDiagnosisAPIImpl
implements ASLDiagnosisAPI {
    @Override
    public AdaptionApi getAdaptionApi() {
        return DiagnosisServicesProvider.getServices().getAdaptionApi();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 7303, -2125524480);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7303, -2108747264);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7303, -2091970048);
        PreRegisteredIds.addServiceOrObserverToArray(0, 7300, -2075192832);
    }
}

