/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.travellink;

import de.vw.mib.asl.api.travellink.ASLTravelLinkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLTravelLinkFactory
extends ASLFactoryBase {
    private static ASLTravelLinkAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$travellink$ASLTravelLinkAPI;

    public static ASLTravelLinkAPI getTravelLinkApi() {
        if (apiInstance == null) {
            apiInstance = (ASLTravelLinkAPI)ASLTravelLinkFactory.createServiceInstance(class$de$vw$mib$asl$api$travellink$ASLTravelLinkAPI == null ? (class$de$vw$mib$asl$api$travellink$ASLTravelLinkAPI = ASLTravelLinkFactory.class$("de.vw.mib.asl.api.travellink.ASLTravelLinkAPI")) : class$de$vw$mib$asl$api$travellink$ASLTravelLinkAPI, "de.vw.mib.asl.internal.travellink.api.impl.ASLTravelLinkAPIImpl");
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

