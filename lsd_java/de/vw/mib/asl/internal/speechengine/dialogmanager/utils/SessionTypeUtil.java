/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.utils;

import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.AbstractMappingUtil;

public final class SessionTypeUtil {
    private static AbstractMappingUtil mapping = new AbstractMappingUtil(class$de$vw$mib$asl$api$speechengine$features$SessionType == null ? (class$de$vw$mib$asl$api$speechengine$features$SessionType = SessionTypeUtil.class$("de.vw.mib.asl.api.speechengine.features.SessionType")) : class$de$vw$mib$asl$api$speechengine$features$SessionType);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$features$SessionType;

    private SessionTypeUtil() {
    }

    public static String toString(int n) {
        return mapping.toString(n);
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

