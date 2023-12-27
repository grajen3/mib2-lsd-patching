/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneEntityListener;
import de.vw.mib.graphics.scene.graph.SceneNode;
import edu.emory.mathcs.backport.java.util.concurrent.CopyOnWriteArrayList;

final class AbstractScene$CameraAttachmentListener
implements SceneEntityListener {
    private final CopyOnWriteArrayList cameras;

    public AbstractScene$CameraAttachmentListener(CopyOnWriteArrayList copyOnWriteArrayList) {
        this.cameras = copyOnWriteArrayList;
    }

    @Override
    public void entityAttached(SceneEntity sceneEntity, SceneNode sceneNode) {
        this.cameras.addIfAbsent(sceneEntity);
    }

    @Override
    public void entityDetached(SceneEntity sceneEntity, SceneNode sceneNode) {
        this.cameras.remove(sceneEntity);
    }
}

