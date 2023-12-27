/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.factoryreset;

import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.factoryreset.FactoryResetParticipantFullFactoryReset;
import de.vw.mib.asl.internal.navigation.util.factoryreset.FactoryResetParticipantNavigation;

public class ResetParticipantFactory {
    private static ResetParticipantFactory instance;
    private final int ROOT;
    private final int NAVIGATION;

    public ResetParticipantFactory() {
        this.ROOT = 0;
        this.NAVIGATION = 1;
    }

    public static ResetParticipantFactory getInstance() {
        if (instance == null) {
            instance = new ResetParticipantFactory();
        }
        return instance;
    }

    public FactoryResetParticipantWithCallback createFactoryResetParticipantForFullFactoryResetAndAddToService(TargetForFullFactoryReset targetForFullFactoryReset) {
        FactoryResetParticipantFullFactoryReset factoryResetParticipantFullFactoryReset = null;
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        if (factoryResetService == null) {
            ServiceManager.errorHandler.handleError(new NullPointerException("factoryResetService was null"));
        } else {
            factoryResetParticipantFullFactoryReset = new FactoryResetParticipantFullFactoryReset(targetForFullFactoryReset);
            factoryResetService.addParticipant(factoryResetParticipantFullFactoryReset, FactoryResetComponents.FULL);
        }
        return factoryResetParticipantFullFactoryReset;
    }

    public FactoryResetParticipantWithCallback createFactoryResetParticipantForNavigationDomainAndAddToService(TargetForResetNavigation targetForResetNavigation) {
        FactoryResetParticipantNavigation factoryResetParticipantNavigation = null;
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        if (factoryResetService == null) {
            ServiceManager.errorHandler.handleError(new NullPointerException("factoryResetService was null"));
        } else {
            factoryResetParticipantNavigation = new FactoryResetParticipantNavigation(targetForResetNavigation);
            factoryResetService.addParticipant(factoryResetParticipantNavigation, FactoryResetComponents.NAVIGATION);
        }
        return factoryResetParticipantNavigation;
    }

    public void removeFullFactoryResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
        this.removeFactoryResetParticipantFromComponent(factoryResetParticipantWithCallback, 0);
    }

    private void removeFactoryResetParticipantFromComponent(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback, int n) {
        FactoryResetService factoryResetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
        if (factoryResetService == null) {
            ServiceManager.errorHandler.handleError(new NullPointerException("factoryResetService was null"));
        } else if (factoryResetParticipantWithCallback != null) {
            switch (n) {
                case 0: {
                    factoryResetService.removeParticipant((FactoryResetParticipant)((Object)factoryResetParticipantWithCallback), FactoryResetComponents.FULL);
                    break;
                }
                case 1: {
                    factoryResetService.removeParticipant((FactoryResetParticipant)((Object)factoryResetParticipantWithCallback), FactoryResetComponents.NAVIGATION);
                    break;
                }
            }
        }
    }

    public void removeNavigationResetParticipantFromService(FactoryResetParticipantWithCallback factoryResetParticipantWithCallback) {
        this.removeFactoryResetParticipantFromComponent(factoryResetParticipantWithCallback, 1);
    }
}

