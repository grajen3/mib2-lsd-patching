/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIAdbEditVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditTarget;
import de.vw.mib.genericevents.AbstractTarget;

public final class DSIAdbEditFactoryVW {
    public static DSIAdbEditFactoryVW INSTANCE;
    private DSIAdbEditTarget target;

    public static DSIAdbEditVW createAdbEdit(AbstractTarget abstractTarget, int[] nArray) {
        return DSIAdbEditFactoryVW.INSTANCE.target.createAdbEdit(abstractTarget, nArray);
    }

    public static DSIAdbEditTarget getDSIAdbEditFactoryVW() {
        return DSIAdbEditFactoryVW.INSTANCE.target;
    }

    protected DSIAdbEditFactoryVW() {
        try {
            this.target = new DSIAdbEditTarget(ServiceManager.eventMain, -699722752, "hsmtask");
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSIAdbEditFactoryVW();
    }
}

