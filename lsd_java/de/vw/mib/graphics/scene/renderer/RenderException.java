/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.renderer;

import de.vw.mib.graphics.GraphicsException;

public class RenderException
extends GraphicsException {
    private static final long serialVersionUID;

    public RenderException() {
    }

    public RenderException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public RenderException(String string) {
        super(string);
    }

    public RenderException(Throwable throwable) {
        super(throwable);
    }
}

