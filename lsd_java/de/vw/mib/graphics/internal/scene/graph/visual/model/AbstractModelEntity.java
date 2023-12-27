/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.model;

import de.vw.mib.graphics.internal.scene.graph.AbstractSceneEntity;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.graphics.scene.graph.visual.ModelEntity;

public abstract class AbstractModelEntity
extends AbstractSceneEntity
implements ModelEntity {
    private static final long serialVersionUID;

    @Override
    public Object clone() {
        AbstractModelEntity abstractModelEntity = (AbstractModelEntity)super.clone();
        return abstractModelEntity;
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
    public abstract Model getModel() {
    }

    @Override
    public abstract void setModel(Model model) {
    }
}

