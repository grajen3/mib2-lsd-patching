/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.flowlistmenu;

import de.vw.mib.asl.api.flowlistmenu.ASLFlowListMenuAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLFlowListMenuFactory
extends ASLFactoryBase {
    private static ASLFlowListMenuAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$flowlistmenu$ASLFlowListMenuFactory;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLFlowListMenuAPI getFlowListMenuApi() {
        Class clazz = class$de$vw$mib$asl$api$flowlistmenu$ASLFlowListMenuFactory == null ? (class$de$vw$mib$asl$api$flowlistmenu$ASLFlowListMenuFactory = ASLFlowListMenuFactory.class$("de.vw.mib.asl.api.flowlistmenu.ASLFlowListMenuFactory")) : class$de$vw$mib$asl$api$flowlistmenu$ASLFlowListMenuFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                // empty if block
            }
            return apiInstance;
        }
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

