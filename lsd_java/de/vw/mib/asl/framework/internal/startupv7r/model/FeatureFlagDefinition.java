/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.model;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.lang.reflect.Field;

public class FeatureFlagDefinition {
    static /* synthetic */ Class class$de$vw$mib$configuration$internal$generated$ConfigurationManagerGenerated;

    public IntObjectMap getDeclaredFeatureFlags() {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        try {
            Field[] fieldArray = (class$de$vw$mib$configuration$internal$generated$ConfigurationManagerGenerated == null ? (class$de$vw$mib$configuration$internal$generated$ConfigurationManagerGenerated = FeatureFlagDefinition.class$("de.vw.mib.configuration.internal.generated.ConfigurationManagerGenerated")) : class$de$vw$mib$configuration$internal$generated$ConfigurationManagerGenerated).getDeclaredFields();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                Field field = fieldArray[i2];
                try {
                    String string = field.getName();
                    if (!string.startsWith("FEAT_")) continue;
                    intObjectOptHashMap.put(field.getInt(null), string);
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return intObjectOptHashMap;
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

