/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.bordcomputer.BordComputerServiceListenerAdapter;
import de.vw.mib.asl.internal.system.util.Preconditions;

public class AstaUpdater
extends BordComputerServiceListenerAdapter {
    private final ASLPropertyManager propertyManager;

    public AstaUpdater(ASLPropertyManager aSLPropertyManager) {
        Preconditions.checkArgumentNotNull(aSLPropertyManager, "Parameter >propertyManager< must not be null!");
        this.propertyManager = aSLPropertyManager;
    }

    @Override
    public void updateASTAServiceState(int n) {
        switch (n) {
            case 0: {
                this.reportAstaAvailability(0);
                break;
            }
            case 1: {
                this.reportAstaAvailability(1);
                break;
            }
            case 2: {
                this.reportAstaAvailability(2);
                break;
            }
            case 3: {
                this.reportAstaAvailability(3);
                break;
            }
        }
    }

    private void reportAstaAvailability(int n) {
        this.propertyManager.valueChangedInteger(1462902784, n);
    }
}

