/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.query.AbstractSceneQuery;
import de.vw.mib.graphics.scene.graph.SceneEntity;
import de.vw.mib.graphics.scene.graph.SceneNode;
import java.util.HashSet;
import java.util.Set;

public class BVHSceneQuery
extends AbstractSceneQuery {
    protected static final int TRAVERSAL_CONTINUE;
    protected static final int TRAVERSAL_PRUNE;
    protected static final int TRAVERSAL_ALL;
    private final BVHScene scene;

    public BVHSceneQuery(BVHScene bVHScene) {
        this(bVHScene, 0, 0);
    }

    public BVHSceneQuery(BVHScene bVHScene, int n) {
        this(bVHScene, n, 0);
    }

    public BVHSceneQuery(BVHScene bVHScene, int n, int n2) {
        super(n, n2);
        this.scene = bVHScene;
    }

    protected final BVHScene getScene() {
        return this.scene;
    }

    @Override
    public final Set execute() {
        SceneNode sceneNode = this.scene.getRootNode();
        HashSet hashSet = new HashSet();
        this.traverse(sceneNode, hashSet, 0);
        return hashSet;
    }

    private void traverse(SceneNode sceneNode, Set set, int n) {
        if (n != 2) {
            n = this.visit(sceneNode);
        }
        if (n != 1) {
            int n2;
            int n3 = sceneNode.getEntityCount();
            for (n2 = 0; n2 < n3; ++n2) {
                SceneEntity sceneEntity = sceneNode.getEntity(n2);
                if (n != 2 && !this.visit(sceneEntity)) continue;
                set.add(sceneEntity);
            }
            n2 = sceneNode.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                SceneNode sceneNode2 = sceneNode.getChild(i2);
                this.traverse(sceneNode2, set, n);
            }
        }
    }

    protected int visit(SceneNode sceneNode) {
        return 2;
    }

    protected boolean visit(SceneEntity sceneEntity) {
        return true;
    }
}

