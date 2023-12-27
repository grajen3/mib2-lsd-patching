/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.scene.graph.visual.VisualEntity;

public interface LightEntity
extends VisualEntity {
    public static final int LIGHT_TYPE_DIRECTIONAL;
    public static final int LIGHT_TYPE_POINT;
    public static final int LIGHT_TYPE_SPOT;

    default public int getType() {
    }
}

