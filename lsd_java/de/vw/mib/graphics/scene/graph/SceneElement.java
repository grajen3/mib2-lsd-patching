/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.graph.spatial.Spatial;
import java.io.Serializable;

public interface SceneElement
extends Cloneable,
Serializable,
Disposable,
Spatial {
    default public Object clone() {
    }

    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public String getQualifiedName() {
    }

    default public SceneNode getParent() {
    }

    default public void setParent(SceneNode sceneNode) {
    }
}

