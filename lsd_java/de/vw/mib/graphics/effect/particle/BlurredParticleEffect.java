/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.particle;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple4f;

public interface BlurredParticleEffect
extends ColorEffect {
    default public Color4f getTintColor() {
    }

    default public void setTintColor(Color4f color4f) {
    }

    default public Tuple4f[] getAttributeStartValues() {
    }

    default public void setAttributeStartValues(Tuple4f[] tuple4fArray) {
    }

    default public Tuple4f[] getAttributeEndValues() {
    }

    default public void setAttributeEndValues(Tuple4f[] tuple4fArray) {
    }

    default public Tuple4f[] getAttributeAnimationValues() {
    }

    default public void setAttributeAnimationValues(Tuple4f[] tuple4fArray) {
    }

    default public Tuple2f getGeometryCenter() {
    }

    default public void setGeometryCenter(Tuple2f tuple2f) {
    }
}

