/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHSceneQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import de.vw.mib.graphics.scene.query.IntersectionQuery;

public abstract class AbstractBVHIntersectionQuery
extends BVHSceneQuery
implements IntersectionQuery {
    public AbstractBVHIntersectionQuery(BVHScene bVHScene) {
        super(bVHScene);
    }

    public AbstractBVHIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public AbstractBVHIntersectionQuery(BVHScene bVHScene, int n, int n2) {
        super(bVHScene, n, n2);
    }

    @Override
    protected final int visit(SceneNode sceneNode) {
        int n = this.intersects(sceneNode.getBoundingVolume());
        switch (n) {
            case 2: {
                return 1;
            }
            case 0: {
                return 2;
            }
            case 1: {
                return 0;
            }
        }
        throw new IllegalArgumentException("Invalid intersection");
    }

    @Override
    protected final boolean visit(SceneEntity sceneEntity) {
        return this.intersects(sceneEntity.getBoundingVolume()) != 2;
    }

    protected abstract int intersects(BoundingVolume boundingVolume) {
    }
}

