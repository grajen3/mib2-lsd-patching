/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.scene.graph.visual.light.AmbientLight;

public interface ReflectiveLight
extends AmbientLight {
    default public Color4f getDiffuseColor() {
    }

    default public void setDiffuseColor(Color4f color4f) {
    }

    default public Color4f getSpecularColor() {
    }

    default public void setSpecularColor(Color4f color4f) {
    }
}

