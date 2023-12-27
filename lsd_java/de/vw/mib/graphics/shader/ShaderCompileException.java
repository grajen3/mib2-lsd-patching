/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.graphics.shader.ShaderException;

public class ShaderCompileException
extends ShaderException {
    private static final long serialVersionUID;

    public ShaderCompileException(String string) {
        super(new StringBuffer().append("Unable to compile shader: ").append(string).toString());
    }
}

