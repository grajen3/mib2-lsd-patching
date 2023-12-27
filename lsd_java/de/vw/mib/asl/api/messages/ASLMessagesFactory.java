/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.messages;

import de.vw.mib.asl.api.messages.ASLMessagesAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLMessagesFactory
extends ASLFactoryBase {
    private static ASLMessagesAPI messagesApiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$messages$ASLMessagesAPI;

    public static ASLMessagesAPI getMessagesApi() {
        if (messagesApiInstance == null) {
            messagesApiInstance = (ASLMessagesAPI)ASLMessagesFactory.createServiceInstance(class$de$vw$mib$asl$api$messages$ASLMessagesAPI == null ? (class$de$vw$mib$asl$api$messages$ASLMessagesAPI = ASLMessagesFactory.class$("de.vw.mib.asl.api.messages.ASLMessagesAPI")) : class$de$vw$mib$asl$api$messages$ASLMessagesAPI, "de.vw.mib.asl.internal.messages.api.impl.ASLMessagesAPIImpl");
        }
        return messagesApiInstance;
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

