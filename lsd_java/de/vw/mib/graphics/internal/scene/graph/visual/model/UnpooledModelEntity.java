/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.model;

import de.vw.mib.graphics.internal.scene.graph.visual.model.AbstractModelEntity;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.util.StringBuilder;

public class UnpooledModelEntity
extends AbstractModelEntity {
    private static final long serialVersionUID;
    private static final boolean BOUNDING_VOLUME_AAB;
    private Model model;

    @Override
    public Object clone() {
        UnpooledModelEntity unpooledModelEntity = (UnpooledModelEntity)super.clone();
        return unpooledModelEntity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",model=").append(this.model);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected final BoundingVolume createBoundingVolume() {
        return new AxisAlignedBox();
    }

    @Override
    protected final void updateBoundingVolume(BoundingVolume boundingVolume) {
        Mesh mesh;
        BoundingVolume boundingVolume2;
        if (this.model != null && (boundingVolume2 = (mesh = this.model.getMesh()).getBoundingVolume()) != null) {
            boundingVolume.set(boundingVolume2);
        }
        super.updateBoundingVolume(boundingVolume);
    }

    @Override
    public final Model getModel() {
        return this.model;
    }

    @Override
    public final void setModel(Model model) {
        this.model = model;
        this.invalidateBoundingVolume();
    }
}

