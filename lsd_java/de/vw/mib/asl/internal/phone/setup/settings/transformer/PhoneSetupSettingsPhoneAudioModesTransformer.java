/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.settings.transformer;

import generated.de.vw.mib.asl.internal.phone.setup.settings.transformer.AbstractPhoneSetupSettingsPhoneAudioModesTransformer;

public class PhoneSetupSettingsPhoneAudioModesTransformer
extends AbstractPhoneSetupSettingsPhoneAudioModesTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 1: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

