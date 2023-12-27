/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import org.dsi.ifc.base.ServiceAdmin;

public interface DSIProxyAPI {
    default public DSIProxy getDSIProxy() {
    }

    default public ServiceAdmin getServiceAdmin() {
    }
}

