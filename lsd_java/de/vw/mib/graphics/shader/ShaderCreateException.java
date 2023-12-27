/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.graphics.shader.ShaderException;

public class ShaderCreateException
extends ShaderException {
    private static final long serialVersionUID;

    public ShaderCreateException(String string) {
        super(new StringBuffer().append("Unable to create shader: ").append(string).toString());
    }
}

