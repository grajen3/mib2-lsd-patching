/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.utils;

import de.vw.mib.asl.internal.speechengine.dialogmanager.utils.AbstractMappingUtil;

public final class FeatureIdsUtil {
    private static AbstractMappingUtil mapping = new AbstractMappingUtil(class$de$vw$mib$asl$api$speechengine$features$FeatureIds == null ? (class$de$vw$mib$asl$api$speechengine$features$FeatureIds = FeatureIdsUtil.class$("de.vw.mib.asl.api.speechengine.features.FeatureIds")) : class$de$vw$mib$asl$api$speechengine$features$FeatureIds);
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$features$FeatureIds;

    private FeatureIdsUtil() {
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

