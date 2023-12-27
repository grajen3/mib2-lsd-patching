/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;

public interface AmbientLight
extends LightEntity {
    default public Color4f getAmbientColor() {
    }

    default public void setAmbientColor(Color4f color4f) {
    }
}

