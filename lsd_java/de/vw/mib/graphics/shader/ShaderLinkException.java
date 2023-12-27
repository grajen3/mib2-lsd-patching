/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.graphics.shader.ShaderException;

public class ShaderLinkException
extends ShaderException {
    private static final long serialVersionUID;

    public ShaderLinkException(String string) {
        super(new StringBuffer().append("Unable to link shader program: ").append(string).toString());
    }
}

