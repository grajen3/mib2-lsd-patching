/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import de.vw.mib.asl.internal.testmode.model.Profile;
import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodePersistedProfileTransformer;

public class TestmodePersistedProfileTransformer
extends AbstractTestmodePersistedProfileTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        Profile profile = (Profile)object;
        if (n == 1) {
            return profile.isActive();
        }
        return false;
    }

    @Override
    public String getString(int n, Object object) {
        Profile profile = (Profile)object;
        if (n == 0) {
            return profile.getName();
        }
        return null;
    }
}

