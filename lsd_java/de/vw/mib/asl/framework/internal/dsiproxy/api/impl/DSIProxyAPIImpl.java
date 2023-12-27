/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.api.impl;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAPI;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.base.ServiceAdmin;

public class DSIProxyAPIImpl
implements DSIProxyAPI {
    @Override
    public DSIProxy getDSIProxy() {
        return ServiceManager.dsiServiceLocator;
    }

    @Override
    public ServiceAdmin getServiceAdmin() {
        return ServiceManager.dsiServiceAdmin;
    }
}

