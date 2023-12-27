/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import java.util.EventListener;

public interface SceneEntityListener
extends EventListener {
    default public void entityAttached(SceneEntity sceneEntity, SceneNode sceneNode) {
    }

    default public void entityDetached(SceneEntity sceneEntity, SceneNode sceneNode) {
    }
}

