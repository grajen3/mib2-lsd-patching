/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.internal.effect.shader.variable.AbstractShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public final class Float4ShaderEffectVariable
extends AbstractShaderEffectVariable {
    private Tuple4f value = new Tuple4f();

    public Float4ShaderEffectVariable(ShaderProgram shaderProgram, String string) {
        this(shaderProgram, 1, string);
    }

    public Float4ShaderEffectVariable(ShaderProgram shaderProgram, int n, String string) {
        super(shaderProgram, n, string, 3, 1);
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

    public Tuple4f getValue() {
        return this.value;
    }

    public void setValue(Tuple4f tuple4f) {
        if (this.setAlways || !this.value.equals(tuple4f)) {
            this.setShaderParameter(tuple4f);
            this.value.set(tuple4f);
        }
    }

    public void setValue(float f2, float f3, float f4, float f5) {
        if (!(!this.setAlways && Util.equalsEpsilon(this.value.x, f2) && Util.equalsEpsilon(this.value.y, f3) && Util.equalsEpsilon(this.value.z, f4) && Util.equalsEpsilon(this.value.w, f5))) {
            this.setShaderParameter(f2, f3, f4, f5);
            this.value.set(f2, f3, f4, f5);
        }
    }
}

