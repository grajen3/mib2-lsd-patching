/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class DSIProxyFactory
extends ASLFactoryBase {
    private static DSIProxyAPI proxyApiInstance;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxyAPI;

    public static DSIProxyAPI getDSIProxyAPI() {
        if (proxyApiInstance == null) {
            proxyApiInstance = (DSIProxyAPI)DSIProxyFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxyAPI == null ? (class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxyAPI = DSIProxyFactory.class$("de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAPI")) : class$de$vw$mib$asl$framework$api$dsiproxy$DSIProxyAPI, "de.vw.mib.asl.framework.internal.dsiproxy.api.impl.DSIProxyAPIImpl");
        }
        return proxyApiInstance;
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

