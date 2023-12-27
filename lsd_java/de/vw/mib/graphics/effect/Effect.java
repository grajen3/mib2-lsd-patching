/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.Resource;

public interface Effect
extends Resource {
    default public boolean isFixedFunction() {
    }

    default public void bind() {
    }
}

