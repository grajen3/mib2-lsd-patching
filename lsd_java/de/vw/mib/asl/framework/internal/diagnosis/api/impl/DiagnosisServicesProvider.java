/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.api.impl;

import de.vw.mib.asl.framework.internal.diagnosis.api.impl.DiagnosisServicesImpl;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.DiagnosisServices;

public final class DiagnosisServicesProvider {
    private static DiagnosisServices services;

    private DiagnosisServicesProvider() {
    }

    public static DiagnosisServices getServices() {
        if (services == null) {
            services = DiagnosisServicesProvider.createServices();
        }
        return services;
    }

    public static void setServices(DiagnosisServices diagnosisServices) {
        services = diagnosisServices;
    }

    private static DiagnosisServices createServices() {
        return new DiagnosisServicesImpl();
    }
}

