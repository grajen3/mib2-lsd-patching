/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.material;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.material.LambertMaterial;
import de.vw.mib.graphics.texture.Texture2D;

public interface PhongMaterial
extends LambertMaterial {
    default public Color4f getSpecularColor() {
    }

    default public void setSpecularColor(Color4f color4f) {
    }

    default public Texture2D getSpecularMap() {
    }

    default public void setSpecularMap(Texture2D texture2D) {
    }

    default public float getShininess() {
    }

    default public void setShininess(float f2) {
    }
}

