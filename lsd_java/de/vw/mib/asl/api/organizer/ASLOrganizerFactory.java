/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.organizer;

import de.vw.mib.asl.api.organizer.ASLOrganizerAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLOrganizerFactory
extends ASLFactoryBase {
    private static ASLOrganizerAPI organizerApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$organizer$ASLOrganizerAPI;

    public static ASLOrganizerAPI getOrganizerApi() {
        if (organizerApiInstance == null) {
            organizerApiInstance = (ASLOrganizerAPI)ASLOrganizerFactory.createServiceInstance(class$de$vw$mib$asl$api$organizer$ASLOrganizerAPI == null ? (class$de$vw$mib$asl$api$organizer$ASLOrganizerAPI = ASLOrganizerFactory.class$("de.vw.mib.asl.api.organizer.ASLOrganizerAPI")) : class$de$vw$mib$asl$api$organizer$ASLOrganizerAPI, "de.vw.mib.asl.internal.organizer.api.impl.ASLOrganizerAPIImpl");
        }
        return organizerApiInstance;
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

