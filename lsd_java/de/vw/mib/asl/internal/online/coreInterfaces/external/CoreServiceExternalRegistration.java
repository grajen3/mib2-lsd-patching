/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.external;

import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;

public interface CoreServiceExternalRegistration {
    default public void registerExternal(CoreServiceExternal coreServiceExternal) {
    }

    default public void unregisterExternal(CoreServiceExternal coreServiceExternal) {
    }

    default public CoreServiceExternal[] getRegisteredExternals() {
    }

    default public CoreServiceExternal[] getExternalsWithSupportedFunction(int n) {
    }
}

