/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual;

import de.vw.mib.graphics.model.Model;
import de.vw.mib.graphics.scene.graph.visual.VisualEntity;

public interface ModelEntity
extends VisualEntity {
    default public Model getModel() {
    }

    default public void setModel(Model model) {
    }
}

