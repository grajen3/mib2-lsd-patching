/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.lighting;

import de.vw.mib.graphics.effect.NormalTransformationEffect;
import de.vw.mib.graphics.effect.TransformationEffect;
import java.util.List;

public interface LightingEffect
extends TransformationEffect,
NormalTransformationEffect {
    default public List getLights() {
    }

    default public void setLights(List list) {
    }
}

