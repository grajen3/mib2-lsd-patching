/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class Float4ArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple4f[] value;

    public Float4ArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 3, n);
        this.value = new Tuple4f[n];
        for (int i2 = 0; i2 < this.value.length; ++i2) {
            this.value[i2] = new Tuple4f();
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

    public Tuple4f[] getValue() {
        return this.value;
    }

    public void setValue(Tuple4f[] tuple4fArray) {
        if (this.setAlways || !Arrays.equals(this.value, tuple4fArray)) {
            this.setShaderParameter(tuple4fArray);
            for (int i2 = 0; i2 < this.value.length; ++i2) {
                this.value[i2].set(tuple4fArray[i2]);
            }
        }
    }
}

