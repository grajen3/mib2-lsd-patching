/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.target;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.scene.animation.target.AbstractAnimationTarget;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.scene.animation.target.MaterialAnimationTarget;
import de.vw.mib.util.StringBuilder;

public final class UnpooledMaterialAnimationTarget
extends AbstractAnimationTarget
implements MaterialAnimationTarget {
    private final Material material;

    public UnpooledMaterialAnimationTarget(int n, int n2, Material material) {
        super(2, n, n2);
        this.material = material;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",material=").append(this.material);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Object getTarget() {
        return this.material;
    }

    @Override
    public void setValue(float[] fArray) {
        int n = this.getAttribute();
        int n2 = this.getArrayIndex();
        switch (n) {
            case 2000: {
                Color4f color4f = this.material.getAmbientColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2001: {
                Color4f color4f = this.material.getDiffuseColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2002: {
                Color4f color4f = this.material.getSpecularColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2003: {
                float f2 = fArray[0];
                this.material.setShininess(f2);
                break;
            }
            case 2004: {
                Color4f color4f = this.material.getEmissiveColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2005: {
                Color4f color4f = this.material.getReflectiveColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2006: {
                float f3 = fArray[0];
                this.material.setReflectivity(f3);
                break;
            }
            case 2007: {
                Color4f color4f = this.material.getTransparentColor();
                UnpooledMaterialAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 2008: {
                float f4 = fArray[0];
                this.material.setTransparency(f4);
                break;
            }
            case 2009: {
                float f5 = fArray[0];
                this.material.setRefractionIndex(f5);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid material target attribute");
            }
        }
        throw new NotYetImplementedException();
    }
}

