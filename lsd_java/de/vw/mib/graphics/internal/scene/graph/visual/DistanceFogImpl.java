/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual;

import de.vw.mib.graphics.Fog;
import de.vw.mib.graphics.internal.scene.graph.AbstractSceneEntity;
import de.vw.mib.graphics.scene.graph.visual.VisualEntity;

public final class DistanceFogImpl
extends AbstractSceneEntity
implements VisualEntity {
    private static final long serialVersionUID;
    private Fog fog;

    @Override
    public Object clone() {
        DistanceFogImpl distanceFogImpl = (DistanceFogImpl)super.clone();
        distanceFogImpl.fog = (Fog)this.fog.clone();
        return distanceFogImpl;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    public Fog getFog() {
        return this.fog;
    }

    public void setFog(Fog fog) {
        this.fog = fog;
    }
}

