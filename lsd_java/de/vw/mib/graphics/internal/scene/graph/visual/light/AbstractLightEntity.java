/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.light;

import de.vw.mib.graphics.internal.scene.graph.AbstractSceneEntity;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;

public abstract class AbstractLightEntity
extends AbstractSceneEntity
implements LightEntity {
    private static final long serialVersionUID;

    @Override
    public Object clone() {
        AbstractLightEntity abstractLightEntity = (AbstractLightEntity)super.clone();
        return abstractLightEntity;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public abstract int getType() {
    }
}

