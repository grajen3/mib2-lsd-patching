/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.math.geometry.Plane3f;

public interface ClippingEffect
extends Effect {
    default public Plane3f getClipPlane(int n) {
    }

    default public void setClipPlane(int n, Plane3f plane3f) {
    }
}

