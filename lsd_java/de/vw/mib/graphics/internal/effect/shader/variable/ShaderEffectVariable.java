/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.variable;

import de.vw.mib.graphics.shader.ShaderVariable;

public interface ShaderEffectVariable {
    default public int getType() {
    }

    default public String getName() {
    }

    default public int getDataType() {
    }

    default public int getCount() {
    }

    default public ShaderVariable getShaderVariable() {
    }

    default public boolean isCompatible() {
    }
}

