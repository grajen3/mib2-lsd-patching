/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

import de.vw.mib.genericevents.Target;
import de.vw.mib.genericevents.hsm.Hsm;
import org.dsi.ifc.base.DSIListener;

public interface DSIProxyAdapterFactory {
    default public DSIListener createDSIListenerMethodAdapter(Target target, Class clazz) {
    }

    default public DSIListener createDSIListenerMethodAdapter(Hsm hsm, Class clazz) {
    }
}

