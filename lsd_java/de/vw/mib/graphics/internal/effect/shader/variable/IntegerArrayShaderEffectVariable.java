/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class IntegerArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private int[] value;

    public IntegerArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 0, n);
        this.value = new int[n];
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

    public int[] getValue() {
        return this.value;
    }

    public void setValue(int[] nArray) {
        if (this.setAlways || !Arrays.equals(this.value, nArray)) {
            this.setShaderParameter(nArray);
            this.value = nArray;
        }
    }
}

