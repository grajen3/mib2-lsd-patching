/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class Float2ArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple2f[] value;

    public Float2ArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 1, n);
        this.value = new Tuple2f[n];
        for (int i2 = 0; i2 < this.value.length; ++i2) {
            this.value[i2] = new Tuple2f();
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

    public Tuple2f[] getValue() {
        return this.value;
    }

    public void setValue(Tuple2f[] tuple2fArray) {
        if (this.setAlways || !Arrays.equals(this.value, tuple2fArray)) {
            this.setShaderParameter(tuple2fArray);
            for (int i2 = 0; i2 < this.value.length; ++i2) {
                this.value[i2].set(tuple2fArray[i2]);
            }
        }
    }
}

