/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.GraphicsException;

public class EffectException
extends GraphicsException {
    private static final long serialVersionUID;

    public EffectException() {
    }

    public EffectException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public EffectException(String string) {
        super(string);
    }

    public EffectException(Throwable throwable) {
        super(throwable);
    }
}

