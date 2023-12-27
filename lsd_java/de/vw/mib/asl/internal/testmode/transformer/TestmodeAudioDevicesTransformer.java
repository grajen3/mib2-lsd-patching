/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.testmode.transformer;

import generated.de.vw.mib.asl.internal.testmode.transformer.AbstractTestmodeAudioDevicesTransformer;

public class TestmodeAudioDevicesTransformer
extends AbstractTestmodeAudioDevicesTransformer {
    @Override
    public String getString(int n, Object object) {
        if (!(object instanceof String)) {
            throw new IllegalArgumentException();
        }
        return (String)object;
    }
}

