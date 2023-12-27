/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph;

import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.scene.graph.SceneElement;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractSceneElement
implements SceneElement {
    private static final long serialVersionUID;
    private String name;
    private SceneNode parent;
    private BoundingVolume boundingVolume = this.createBoundingVolume();
    private boolean boundingVolumeValid = false;

    @Override
    public Object clone() {
        try {
            AbstractSceneElement abstractSceneElement = (AbstractSceneElement)super.clone();
            abstractSceneElement.parent = null;
            return abstractSceneElement;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[name=").append(this.name);
        stringBuilder.append(",parent=").append(this.parent);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.name = null;
        this.parent = null;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final void setName(String string) {
        this.name = string;
    }

    @Override
    public final String getQualifiedName() {
        StringBuilder stringBuilder = new StringBuilder();
        SceneElement sceneElement = this;
        do {
            stringBuilder.insert(0, sceneElement.getName());
            sceneElement = sceneElement.getParent();
            if (sceneElement == null) continue;
            stringBuilder.insert(0, '.');
        } while (sceneElement != null);
        return stringBuilder.toString();
    }

    @Override
    public final SceneNode getParent() {
        return this.parent;
    }

    @Override
    public final void setParent(SceneNode sceneNode) {
        SceneNode sceneNode2 = this.parent;
        if (sceneNode2 == null || !sceneNode2.equals(sceneNode)) {
            this.parent = sceneNode;
            this.parentChanged(sceneNode2, sceneNode);
        }
    }

    protected abstract void parentChanged(SceneNode sceneNode, SceneNode sceneNode2) {
    }

    protected final void invalidateBoundingVolume() {
        this.boundingVolumeValid = false;
        AbstractSceneElement abstractSceneElement = (AbstractSceneElement)((Object)this.parent);
        if (abstractSceneElement != null && abstractSceneElement.boundingVolumeValid) {
            abstractSceneElement.invalidateBoundingVolume();
        }
    }

    protected abstract BoundingVolume createBoundingVolume() {
    }

    @Override
    public final BoundingVolume getBoundingVolume() {
        if (!this.boundingVolumeValid) {
            this.updateBoundingVolume(this.boundingVolume);
            this.boundingVolumeValid = true;
        }
        return this.boundingVolume;
    }

    protected final void setBoundingVolume(BoundingVolume boundingVolume) {
        this.boundingVolume.set(boundingVolume);
        this.boundingVolumeValid = true;
    }

    protected abstract void updateBoundingVolume(BoundingVolume boundingVolume) {
    }
}

