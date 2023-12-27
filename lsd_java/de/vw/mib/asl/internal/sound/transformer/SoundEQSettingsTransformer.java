/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound.transformer;

import generated.de.vw.mib.asl.internal.sound.transformer.AbstractSoundEQSettingsTransformer;

public class SoundEQSettingsTransformer
extends AbstractSoundEQSettingsTransformer {
    @Override
    public int getInt(int n, Object object) {
        switch (n) {
            case 0: {
                return (Integer)object;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

