/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.camera;

import de.vw.mib.graphics.Viewport;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.scene.graph.visual.VisualEntity;

public interface CameraEntity
extends VisualEntity {
    public static final int CAMERA_TYPE_FRUSTUM;
    public static final int CAMERA_TYPE_ORTHOGRAPHIC;
    public static final int CAMERA_TYPE_PERSPECTIVE;

    default public int getType() {
    }

    default public Matrix4f getProjection() {
    }

    default public void setViewport(Viewport viewport) {
    }
}

