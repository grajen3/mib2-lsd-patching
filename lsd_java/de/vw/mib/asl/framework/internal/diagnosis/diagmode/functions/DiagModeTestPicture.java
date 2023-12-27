/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions;

import de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions.DiagModeFunction;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class DiagModeTestPicture
extends DiagModeFunction {
    public DiagModeTestPicture(AbstractASLHsmTarget abstractASLHsmTarget) {
        super(abstractASLHsmTarget);
    }

    public void updateTestPictureDisplay(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(391);
                n2 = -1;
                break;
            }
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 6;
                break;
            }
            case 5: {
                n2 = 4;
                break;
            }
            case 6: {
                n2 = 5;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 8: {
                n2 = 8;
                break;
            }
            case 9: {
                n2 = 1;
                break;
            }
            default: {
                n2 = -1;
                ServiceManager.logger.error(16384).append("DIAGNOSTIC DiagModeTestPicture Test Picture = ").append(n).log();
            }
        }
        if (n2 != -1) {
            AbstractASLTarget.writeIntegerToDatapool(1604, n2);
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(392);
        }
    }
}

