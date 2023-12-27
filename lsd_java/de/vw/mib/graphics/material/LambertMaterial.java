/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.material;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.material.ConstantMaterial;
import de.vw.mib.graphics.texture.Texture2D;

public interface LambertMaterial
extends ConstantMaterial {
    default public Color4f getAmbientColor() {
    }

    default public void setAmbientColor(Color4f color4f) {
    }

    default public Texture2D getAmbientMap() {
    }

    default public void setAmbientMap(Texture2D texture2D) {
    }

    default public Color4f getDiffuseColor() {
    }

    default public void setDiffuseColor(Color4f color4f) {
    }

    default public Texture2D getDiffuseMap() {
    }

    default public void setDiffuseMap(Texture2D texture2D) {
    }
}

