/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class MediaDiagnosticHelper {
    private MediaDiagnosticHelper() {
    }

    public static int getASLDeviceIdForDSIDiagnoseSystemId(int n) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("MediaSourceController.switchSourceViaDiagnostic()").log();
        }
        switch (n) {
            case 16: {
                return 1;
            }
            case 15: {
                return 5;
            }
            case 7: {
                return 2;
            }
            case 21: {
                return 10;
            }
            case 18: {
                return 8;
            }
            case 22: {
                return 13;
            }
            case 4: 
            case 8: {
                return 4;
            }
            case 6: 
            case 19: {
                return 3;
            }
            case 5: {
                return 3;
            }
            case 9: {
                return 6;
            }
            case 11: {
                return 11;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unsupported source id: ").append(n).toString());
    }
}

