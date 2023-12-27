/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.utils;

import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.AbstractMappingUtil;

public final class DialogBackstackStateUtil {
    private static AbstractMappingUtil mapping = new AbstractMappingUtil(class$de$vw$mib$asl$api$speechengine$dialogmanager$DialogBackstackState == null ? (class$de$vw$mib$asl$api$speechengine$dialogmanager$DialogBackstackState = DialogBackstackStateUtil.class$("de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackState")) : class$de$vw$mib$asl$api$speechengine$dialogmanager$DialogBackstackState);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$dialogmanager$DialogBackstackState;

    private DialogBackstackStateUtil() {
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

