/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class Float3ArrayShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple3f[] value;

    public Float3ArrayShaderEffectVariable(ShaderProgram shaderProgram, String string, int n) {
        super(shaderProgram, 1, string, 2, n);
        this.value = new Tuple3f[n];
        for (int i2 = 0; i2 < this.value.length; ++i2) {
            this.value[i2] = new Tuple3f();
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

    public Tuple3f[] getValue() {
        return this.value;
    }

    public void setValue(Tuple3f[] tuple3fArray) {
        if (this.setAlways || !Arrays.equals(this.value, tuple3fArray)) {
            this.setShaderParameter(tuple3fArray);
            for (int i2 = 0; i2 < this.value.length; ++i2) {
                this.value[i2].set(tuple3fArray[i2]);
            }
        }
    }
}

