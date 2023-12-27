/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.settings.transformer;

import generated.de.vw.mib.asl.internal.phone.setup.settings.transformer.AbstractPhoneSetupSettingsInternalRingtonesTransformer;

public class PhoneSetupSettingsInternalRingtonesTransformer
extends AbstractPhoneSetupSettingsInternalRingtonesTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        Boolean bl = (Boolean)object;
        switch (n) {
            case 0: {
                return bl;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

