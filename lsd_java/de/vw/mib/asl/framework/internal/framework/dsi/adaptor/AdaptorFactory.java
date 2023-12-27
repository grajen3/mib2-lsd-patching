/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.adaptor;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.Hsm;
import org.dsi.ifc.base.DSIListener;

public final class AdaptorFactory {
    public static DSIListener createDSIListenerMethodAdapter(Target target, Class clazz) {
        return DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory().createDSIListenerMethodAdapter(target, clazz);
    }

    public static DSIListener createDSIListenerMethodAdapter(Hsm hsm, Class clazz) {
        return DSIProxyFactory.getDSIProxyAPI().getDSIProxy().getAdapterFactory().createDSIListenerMethodAdapter(hsm, clazz);
    }

    private AdaptorFactory() {
    }
}

