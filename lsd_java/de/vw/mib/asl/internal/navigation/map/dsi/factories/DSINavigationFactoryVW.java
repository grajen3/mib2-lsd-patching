/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationTarget;
import de.vw.mib.genericevents.AbstractTarget;

public final class DSINavigationFactoryVW {
    public static DSINavigationFactoryVW INSTANCE;
    private DSINavigationTarget target;

    public static DSINavigationVW createNavigation(AbstractTarget abstractTarget, int[] nArray) {
        return DSINavigationFactoryVW.INSTANCE.target.createNavigation(abstractTarget, nArray);
    }

    public static DSINavigationTarget getDSINavigationFactoryVW() {
        return DSINavigationFactoryVW.INSTANCE.target;
    }

    protected DSINavigationFactoryVW() {
        try {
            this.target = new DSINavigationTarget(ServiceManager.eventMain, -682945536, "hsmtask");
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSINavigationFactoryVW();
    }
}

