/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.internal.scene.graph.AbstractSceneElement;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneEntityListener;
import de.vw.mib.graphics.scene.graph.SceneNode;

public abstract class AbstractSceneEntity
extends AbstractSceneElement
implements SceneEntity {
    private static final long serialVersionUID;
    private transient CowList listeners = CowList.EMPTY;

    @Override
    public Object clone() {
        AbstractSceneEntity abstractSceneEntity = (AbstractSceneEntity)super.clone();
        abstractSceneEntity.listeners = CowList.EMPTY;
        return abstractSceneEntity;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void dispose() {
        this.listeners = CowList.EMPTY;
        super.dispose();
    }

    @Override
    protected BoundingVolume createBoundingVolume() {
        return new Sphere3f();
    }

    @Override
    protected void updateBoundingVolume(BoundingVolume boundingVolume) {
        boundingVolume.transform(this.getParent().getGlobalTransform());
    }

    @Override
    public final void addListener(SceneEntityListener sceneEntityListener) {
        this.listeners = this.listeners.addIfAbsent(sceneEntityListener);
    }

    @Override
    public final void removeListener(SceneEntityListener sceneEntityListener) {
        this.listeners = this.listeners.remove(sceneEntityListener);
    }

    @Override
    protected void parentChanged(SceneNode sceneNode, SceneNode sceneNode2) {
        if (sceneNode != null) {
            this.fireEntityDetached(sceneNode);
        }
        if (sceneNode2 != null) {
            this.fireEntityAttached(sceneNode2);
        }
    }

    private void fireEntityAttached(SceneNode sceneNode) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneEntityListener sceneEntityListener = (SceneEntityListener)cowList.head();
            sceneEntityListener.entityAttached(this, sceneNode);
        }
    }

    private void fireEntityDetached(SceneNode sceneNode) {
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SceneEntityListener sceneEntityListener = (SceneEntityListener)cowList.head();
            sceneEntityListener.entityDetached(this, sceneNode);
        }
    }
}

