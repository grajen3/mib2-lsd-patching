/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMobilityHorizonVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonDatapool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonTarget;
import de.vw.mib.genericevents.AbstractTarget;

public class DSIMobilityHorizonVWFactory {
    public static DSIMobilityHorizonVWFactory INSTANCE;
    private final DSIMobilityHorizonDatapool dataPoolMainMap = new DSIMobilityHorizonDatapool();
    private final DSIMobilityHorizonDatapool dataPoolMapInMap = new DSIMobilityHorizonDatapool();
    private DSIMobilityHorizonTarget targetMainMap;
    private DSIMobilityHorizonTarget targetMapInMap;

    public static DSIMobilityHorizonVW createMobilityHorizonMainMap(AbstractTarget abstractTarget, int[] nArray) {
        return DSIMobilityHorizonVWFactory.INSTANCE.targetMainMap.createMobilityHorizon(abstractTarget, nArray);
    }

    public static DSIMobilityHorizonVW createMobilityHorizonMapInMap(AbstractTarget abstractTarget, int[] nArray) {
        return DSIMobilityHorizonVWFactory.INSTANCE.targetMapInMap.createMobilityHorizon(abstractTarget, nArray);
    }

    public static DSIMobilityHorizonDatapool getDataPoolMainMap() {
        return DSIMobilityHorizonVWFactory.INSTANCE.dataPoolMainMap;
    }

    public static DSIMobilityHorizonDatapool getDataPoolMapInMap() {
        return DSIMobilityHorizonVWFactory.INSTANCE.dataPoolMapInMap;
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSIMobilityHorizonVWFactory();
    }

    private DSIMobilityHorizonVWFactory() {
        try {
            this.targetMainMap = new DSIMobilityHorizonTarget(this.dataPoolMainMap, ServiceManager.eventMain, -666168320, "hsmtask");
            this.targetMapInMap = new DSIMobilityHorizonTarget(this.dataPoolMapInMap, ServiceManager.eventMain, -649391104, "hsmtask");
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, this.targetMainMap);
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, this.targetMapInMap);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

