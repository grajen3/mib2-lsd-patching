/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.carlife;

import de.vw.mib.asl.api.carlife.ASLCarLifeAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLCarLifeFactory
extends ASLFactoryBase {
    private static ASLCarLifeAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$carlife$ASLCarLifeFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$carlife$ASLCarLifeAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLCarLifeAPI getCarLifeApi() {
        Class clazz = class$de$vw$mib$asl$api$carlife$ASLCarLifeFactory == null ? (class$de$vw$mib$asl$api$carlife$ASLCarLifeFactory = ASLCarLifeFactory.class$("de.vw.mib.asl.api.carlife.ASLCarLifeFactory")) : class$de$vw$mib$asl$api$carlife$ASLCarLifeFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLCarLifeAPI)ASLCarLifeFactory.createServiceInstance(class$de$vw$mib$asl$api$carlife$ASLCarLifeAPI == null ? (class$de$vw$mib$asl$api$carlife$ASLCarLifeAPI = ASLCarLifeFactory.class$("de.vw.mib.asl.api.carlife.ASLCarLifeAPI")) : class$de$vw$mib$asl$api$carlife$ASLCarLifeAPI, "de.vw.mib.asl.internal.carlife.api.impl.ASLCarLifeAPIImpl");
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

