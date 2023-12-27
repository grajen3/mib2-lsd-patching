/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.EffectException;
import de.vw.mib.graphics.internal.effect.AbstractEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.shader.ShaderException;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractShaderEffect
extends AbstractEffect
implements ShaderEffect {
    private static final String SHADER_DIRECTORY;
    private static final String VERTEX_SHADER_DIRECTORY;
    private static final String VERTEX_SHADER_EXTENSION;
    private static final String FRAGMENT_SHADER_DIRECTORY;
    private static final String FRAGMENT_SHADER_EXTENSION;

    public AbstractShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager.getGraphics3D(), shaderEffectManager.getLogger(), shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    protected final ShaderEffectManager getShaderEffectManager() {
        return (ShaderEffectManager)this.getEffectManager();
    }

    @Override
    public final boolean isFixedFunction() {
        return false;
    }

    @Override
    public final void bind() {
        Graphics3D graphics3D = this.getGraphics3D();
        try {
            ShaderProgram shaderProgram = this.getShaderProgram();
            graphics3D.setShaderProgram(shaderProgram);
        }
        catch (ShaderException shaderException) {
            throw new EffectException(shaderException);
        }
        super.bind();
    }

    @Override
    public abstract void initialize() {
    }

    @Override
    public abstract ShaderProgram getShaderProgram() {
    }

    protected static final String buildShaderSourceFilename(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        if ("".length() > 0) {
            stringBuilder.append("");
            stringBuilder.append('/');
        }
        switch (n) {
            case 0: {
                stringBuilder.append("vertex");
                break;
            }
            case 1: {
                stringBuilder.append("fragment");
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid shader type");
            }
        }
        stringBuilder.append('/');
        stringBuilder.append(string);
        switch (n) {
            case 0: {
                stringBuilder.append(".glslv");
                break;
            }
            case 1: {
                stringBuilder.append(".glslf");
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid shader type");
            }
        }
        return stringBuilder.toString();
    }

    protected static final String createDefine(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#define ").append(string).append("\n");
        return stringBuilder.toString();
    }

    protected static final String createDefine(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#define ").append(string).append(" ").append(n).append("\n");
        return stringBuilder.toString();
    }

    protected static final String buildStructUniformName(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string).append(".").append(string2);
        return stringBuilder.toString();
    }

    protected static final String buildArrayUniformName(String string) {
        return AbstractShaderEffect.buildStructArrayUniformName(string, null, 0);
    }

    protected static final String buildArrayUniformName(String string, int n) {
        return AbstractShaderEffect.buildStructArrayUniformName(string, null, n);
    }

    protected static final String buildStructArrayUniformName(String string, String string2, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string).append("[").append(n).append("]");
        if (string2 != null) {
            stringBuilder.append(".");
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

