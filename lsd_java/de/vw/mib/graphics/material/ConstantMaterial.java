/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.material;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureCubeMap;

public interface ConstantMaterial {
    default public Color4f getEmissiveColor() {
    }

    default public void setEmissiveColor(Color4f color4f) {
    }

    default public Texture2D getEmissiveMap() {
    }

    default public void setEmissiveMap(Texture2D texture2D) {
    }

    default public Texture2D getNormalMap() {
    }

    default public void setNormalMap(Texture2D texture2D) {
    }

    default public Color4f getReflectiveColor() {
    }

    default public void setReflectiveColor(Color4f color4f) {
    }

    default public TextureCubeMap getReflectionMap() {
    }

    default public void setReflectionMap(TextureCubeMap textureCubeMap) {
    }

    default public float getReflectivity() {
    }

    default public void setReflectivity(float f2) {
    }

    default public Color4f getTransparentColor() {
    }

    default public void setTransparentColor(Color4f color4f) {
    }

    default public Texture2D getTransparentMap() {
    }

    default public void setTransparentMap(Texture2D texture2D) {
    }

    default public float getTransparency() {
    }

    default public void setTransparency(float f2) {
    }

    default public float getRefractionIndex() {
    }

    default public void setRefractionIndex(float f2) {
    }
}

