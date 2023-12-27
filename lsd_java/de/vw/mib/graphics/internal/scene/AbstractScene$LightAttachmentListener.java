/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneEntityListener;
import de.vw.mib.graphics.scene.graph.SceneNode;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;

final class AbstractScene$LightAttachmentListener
implements SceneEntityListener {
    private final CopyOnWriteArrayList lights;

    public AbstractScene$LightAttachmentListener(CopyOnWriteArrayList copyOnWriteArrayList) {
        this.lights = copyOnWriteArrayList;
    }

    @Override
    public void entityAttached(SceneEntity sceneEntity, SceneNode sceneNode) {
        this.lights.addIfAbsent(sceneEntity);
    }

    @Override
    public void entityDetached(SceneEntity sceneEntity, SceneNode sceneNode) {
        this.lights.remove(sceneEntity);
    }
}

