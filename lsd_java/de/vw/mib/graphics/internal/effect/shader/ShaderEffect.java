/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.shader.ShaderProgram;

public interface ShaderEffect
extends Effect {
    default public void initialize() {
    }

    default public ShaderProgram getShaderProgram() {
    }
}

