/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.ugdo;

import de.vw.mib.asl.api.car.ugdo.ASLCarUGDOAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLCarUGDOFactory
extends ASLFactoryBase {
    private static ASLCarUGDOAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ugdo$ASLCarUGDOAPI;

    public static ASLCarUGDOAPI getCarUGDOApi() {
        if (apiInstance == null) {
            apiInstance = (ASLCarUGDOAPI)ASLCarUGDOFactory.createServiceInstance(class$de$vw$mib$asl$api$car$ugdo$ASLCarUGDOAPI == null ? (class$de$vw$mib$asl$api$car$ugdo$ASLCarUGDOAPI = ASLCarUGDOFactory.class$("de.vw.mib.asl.api.car.ugdo.ASLCarUGDOAPI")) : class$de$vw$mib$asl$api$car$ugdo$ASLCarUGDOAPI, "de.vw.mib.asl.internal.car.ugdo.api.impl.ASLCarUGDOAPIImpl");
        }
        return apiInstance;
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

