/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.graphics.scene.graph.SceneElement;
import de.vw.mib.graphics.scene.graph.SceneEntityListener;

public interface SceneEntity
extends SceneElement {
    default public void addListener(SceneEntityListener sceneEntityListener) {
    }

    default public void removeListener(SceneEntityListener sceneEntityListener) {
    }
}

