/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import java.util.EventListener;

public interface SceneNodeListener
extends EventListener {
    default public void parentChanged(SceneNode sceneNode, SceneNode sceneNode2) {
    }

    default public void childAdded(SceneNode sceneNode, SceneNode sceneNode2) {
    }

    default public void childRemoved(SceneNode sceneNode, SceneNode sceneNode2) {
    }

    default public void entityAdded(SceneNode sceneNode, SceneEntity sceneEntity) {
    }

    default public void entityRemoved(SceneNode sceneNode, SceneEntity sceneEntity) {
    }
}

