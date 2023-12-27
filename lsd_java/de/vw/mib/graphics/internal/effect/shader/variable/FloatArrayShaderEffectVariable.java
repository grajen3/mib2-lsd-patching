/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class FloatArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private float[] value;

    public FloatArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 0, n);
        this.value = new float[n];
        Arrays.fill(this.value, (float)49279);
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

    public float[] getValue() {
        return this.value;
    }

    public void setValue(float[] fArray) {
        if (this.setAlways || !Arrays.equals(this.value, fArray)) {
            this.setShaderParameter(fArray);
            System.arraycopy((Object)fArray, 0, (Object)this.value, 0, this.value.length);
        }
    }
}

