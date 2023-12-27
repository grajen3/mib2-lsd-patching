/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;

public class ASLPersistenceFactory
extends ASLFactoryBase {
    private static ASLPersistenceAPI persistenceApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$persistence$ASLPersistenceAPI;

    public static ASLPersistenceAPI getPersistenceApi() {
        if (persistenceApiInstance == null) {
            persistenceApiInstance = (ASLPersistenceAPI)ASLPersistenceFactory.createServiceInstance(class$de$vw$mib$asl$framework$api$persistence$ASLPersistenceAPI == null ? (class$de$vw$mib$asl$framework$api$persistence$ASLPersistenceAPI = ASLPersistenceFactory.class$("de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI")) : class$de$vw$mib$asl$framework$api$persistence$ASLPersistenceAPI, "de.vw.mib.asl.framework.internal.persistence.api.impl.ASLPersistenceAPIImpl");
        }
        return persistenceApiInstance;
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

