/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.particle;

import de.vw.mib.graphics.drawable.particle.ParticleHeightMapDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.DrawableRenderer;

public interface ParticleHeightMapDrawableRenderer
extends DrawableRenderer {
    default public ParticleHeightMapDrawable createAnimatedParticleHeightMapDrawable() {
    }
}

