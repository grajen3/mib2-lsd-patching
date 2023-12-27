/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class ColorArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Color4f[] value;

    public ColorArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 3, n);
        this.value = new Color4f[n];
        for (int i2 = 0; i2 < this.value.length; ++i2) {
            this.value[i2] = new Color4f(Color4f.BLACK_TRANSPARENT);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",value=").append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Color4f[] getValue() {
        return this.value;
    }

    public void setValue(Color4f[] color4fArray) {
        if (this.setAlways || !Arrays.equals(this.value, color4fArray)) {
            this.setShaderParameter(color4fArray);
            for (int i2 = 0; i2 < this.value.length; ++i2) {
                this.value[i2].set(color4fArray[i2]);
            }
        }
    }
}

