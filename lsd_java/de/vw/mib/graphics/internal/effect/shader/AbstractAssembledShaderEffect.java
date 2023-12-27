/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.effect.shader.AbstractShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.variable.BooleanShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float2ArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float2ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float3ArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float3ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float4ArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float4ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.IntegerShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix2ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix3ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Matrix4ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.SamplerCubeShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ShaderEffectVariable;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderException;
import de.vw.mib.graphics.shader.ShaderLinkException;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderProgram;
import de.vw.mib.graphics.shader.ShaderVariable;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractAssembledShaderEffect
extends AbstractShaderEffect {
    private static final String SHADER_PROLOGUE_GLES;
    private static final String SHADER_PROLOGUE_GL;
    private ShaderProgram shaderProgram;
    private final Map shaderEffectVariablesMap = new HashMap();

    public AbstractAssembledShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        if (this.shaderProgram != null) {
            this.shaderProgram.dispose();
            this.shaderProgram = null;
        }
        this.shaderEffectVariablesMap.clear();
        super.dispose();
    }

    @Override
    public final void initialize() {
        this.createShaderProgram();
        this.registerShaderEffectVariables();
    }

    private void createShaderProgram() {
        Graphics3D graphics3D = this.getGraphics3D();
        ShaderManager shaderManager = graphics3D.getShaderManager();
        Shader shader = null;
        Shader shader2 = null;
        try {
            int n = 5;
            ArrayList arrayList = new ArrayList(5);
            ArrayList arrayList2 = new ArrayList(5);
            this.getVertexShaderDefines(arrayList);
            this.getVertexShaderFilenames(arrayList2);
            shader = AbstractAssembledShaderEffect.assembleAndCompileShader(shaderManager, 0, arrayList, arrayList2);
            arrayList.clear();
            arrayList2.clear();
            this.getFragmentShaderDefines(arrayList);
            this.getFragmentShaderFilenames(arrayList2);
            shader2 = AbstractAssembledShaderEffect.assembleAndCompileShader(shaderManager, 1, arrayList, arrayList2);
            this.shaderProgram = shaderManager.createShaderProgram();
            this.shaderProgram.attachShader(shader);
            this.shaderProgram.attachShader(shader2);
            VertexFormat vertexFormat = new VertexFormat();
            this.getVertexFormat(vertexFormat);
            VertexAttributeBinding vertexAttributeBinding = new VertexAttributeBinding(vertexFormat);
            this.getVertexAttributeBinding(vertexAttributeBinding);
            this.shaderProgram.setVertexAttributeBinding(vertexAttributeBinding);
            this.shaderProgram.link();
        }
        catch (ShaderLinkException shaderLinkException) {
            this.shaderProgram.dispose();
            this.shaderProgram = null;
            throw shaderLinkException;
        }
    }

    protected void getVertexShaderDefines(List list) {
    }

    protected abstract void getVertexShaderFilenames(List list) {
    }

    protected void getFragmentShaderDefines(List list) {
    }

    protected abstract void getFragmentShaderFilenames(List list) {
    }

    protected abstract void getVertexFormat(VertexFormat vertexFormat) {
    }

    protected abstract void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
    }

    private static Shader assembleAndCompileShader(ShaderManager shaderManager, int n, List list, List list2) {
        int n2 = shaderManager.getShadingLanguage();
        boolean bl = n2 == 0;
        try {
            ArrayList arrayList = new ArrayList(1 + list.size() + list2.size());
            arrayList.add(shaderManager.loadShaderSourceFromFile(AbstractAssembledShaderEffect.buildShaderSourceFilename(n, bl ? "Define_Prologue_GLES" : "Define_Prologue_GL")));
            arrayList.addAll(list);
            for (int i2 = 0; i2 < list2.size(); ++i2) {
                arrayList.add(shaderManager.loadShaderSourceFromFile(AbstractAssembledShaderEffect.buildShaderSourceFilename(n, (String)list2.get(i2))));
            }
            Shader shader = shaderManager.getShader(n, n2, arrayList);
            return shader;
        }
        catch (IOException iOException) {
            throw new ShaderException(iOException.getLocalizedMessage());
        }
    }

    protected abstract void registerShaderEffectVariables() {
    }

    private void registerShaderEffectVariable(String string, ShaderEffectVariable shaderEffectVariable) {
        this.validateShaderEffectVariable(shaderEffectVariable);
        if (this.shaderEffectVariablesMap.put(string, shaderEffectVariable) != null) {
            LogMessage logMessage = this.getLogger().error(256);
            logMessage.append(super.getClass().getName());
            logMessage.append(": Shader effect variable '").append(string).append("' already registered");
            logMessage.log();
        }
    }

    private void validateShaderEffectVariable(ShaderEffectVariable shaderEffectVariable) {
        Logger logger = this.getLogger();
        LogMessage logMessage = null;
        ShaderVariable shaderVariable = shaderEffectVariable.getShaderVariable();
        if (shaderVariable == null) {
            if (logger.isTraceEnabled(256)) {
                logMessage = logger.trace(256);
                logMessage.append(super.getClass().getName());
                logMessage.append(": Shader effect variable '").append(shaderEffectVariable.getName()).append("' unused or undefined").log();
            }
        } else {
            if (shaderVariable.getDataType() != shaderEffectVariable.getDataType()) {
                logMessage = logger.error(256);
                logMessage.append(super.getClass().getName());
                logMessage.append(": Shader effect variable '").append(shaderEffectVariable.getName()).append("' element datatype mismatch").log();
            }
            if (shaderVariable.getCount() != shaderEffectVariable.getCount()) {
                logMessage = logger.error(256);
                logMessage.append(super.getClass().getName());
                logMessage.append(": Shader effect variable '").append(shaderEffectVariable.getName()).append("' element count mismatch").log();
            }
        }
    }

    protected final BooleanShaderEffectVariable addBooleanShaderEffectVariable(String string) {
        BooleanShaderEffectVariable booleanShaderEffectVariable = new BooleanShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, booleanShaderEffectVariable);
        return booleanShaderEffectVariable;
    }

    protected final ColorShaderEffectVariable addColorShaderEffectVariable(int n, String string) {
        ColorShaderEffectVariable colorShaderEffectVariable = new ColorShaderEffectVariable(this.shaderProgram, n, string);
        this.registerShaderEffectVariable(string, colorShaderEffectVariable);
        return colorShaderEffectVariable;
    }

    protected final ColorShaderEffectVariable addColorShaderEffectVariable(String string) {
        ColorShaderEffectVariable colorShaderEffectVariable = new ColorShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, colorShaderEffectVariable);
        return colorShaderEffectVariable;
    }

    protected final ColorArrayShaderEffectVariable addColorArrayShaderEffectVariable(String string, int n) {
        ColorArrayShaderEffectVariable colorArrayShaderEffectVariable = new ColorArrayShaderEffectVariable(this.shaderProgram, string, n);
        this.registerShaderEffectVariable(string, colorArrayShaderEffectVariable);
        return colorArrayShaderEffectVariable;
    }

    protected final FloatShaderEffectVariable addFloatShaderEffectVariable(String string) {
        FloatShaderEffectVariable floatShaderEffectVariable = new FloatShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, floatShaderEffectVariable);
        return floatShaderEffectVariable;
    }

    protected final FloatArrayShaderEffectVariable addFloatArrayShaderEffectVariable(String string, int n) {
        FloatArrayShaderEffectVariable floatArrayShaderEffectVariable = new FloatArrayShaderEffectVariable(this.shaderProgram, string, n);
        this.registerShaderEffectVariable(string, floatArrayShaderEffectVariable);
        return floatArrayShaderEffectVariable;
    }

    protected final IntegerShaderEffectVariable addIntegerShaderEffectVariable(String string) {
        IntegerShaderEffectVariable integerShaderEffectVariable = new IntegerShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, integerShaderEffectVariable);
        return integerShaderEffectVariable;
    }

    protected final Matrix2ShaderEffectVariable addMatrix2ShaderEffectVariable(String string) {
        Matrix2ShaderEffectVariable matrix2ShaderEffectVariable = new Matrix2ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, matrix2ShaderEffectVariable);
        return matrix2ShaderEffectVariable;
    }

    protected final Matrix3ShaderEffectVariable addMatrix3ShaderEffectVariable(String string) {
        Matrix3ShaderEffectVariable matrix3ShaderEffectVariable = new Matrix3ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, matrix3ShaderEffectVariable);
        return matrix3ShaderEffectVariable;
    }

    protected final Matrix4ShaderEffectVariable addMatrix4ShaderEffectVariable(String string) {
        Matrix4ShaderEffectVariable matrix4ShaderEffectVariable = new Matrix4ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, matrix4ShaderEffectVariable);
        return matrix4ShaderEffectVariable;
    }

    protected final Sampler2DShaderEffectVariable addSampler2DShaderEffectVariable(String string) {
        Sampler2DShaderEffectVariable sampler2DShaderEffectVariable = new Sampler2DShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, sampler2DShaderEffectVariable);
        return sampler2DShaderEffectVariable;
    }

    protected final SamplerCubeShaderEffectVariable addSamplerCubeShaderEffectVariable(String string) {
        SamplerCubeShaderEffectVariable samplerCubeShaderEffectVariable = new SamplerCubeShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, samplerCubeShaderEffectVariable);
        return samplerCubeShaderEffectVariable;
    }

    protected final Float2ShaderEffectVariable addFloat2ShaderEffectVariable(String string) {
        Float2ShaderEffectVariable float2ShaderEffectVariable = new Float2ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, float2ShaderEffectVariable);
        return float2ShaderEffectVariable;
    }

    protected final Float2ArrayShaderEffectVariable addFloat2ArrayShaderEffectVariable(String string, int n) {
        Float2ArrayShaderEffectVariable float2ArrayShaderEffectVariable = new Float2ArrayShaderEffectVariable(this.shaderProgram, string, n);
        this.registerShaderEffectVariable(string, float2ArrayShaderEffectVariable);
        return float2ArrayShaderEffectVariable;
    }

    protected final Float3ShaderEffectVariable addFloat3ShaderEffectVariable(String string) {
        Float3ShaderEffectVariable float3ShaderEffectVariable = new Float3ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, float3ShaderEffectVariable);
        return float3ShaderEffectVariable;
    }

    protected final Float3ArrayShaderEffectVariable addFloat3ArrayShaderEffectVariable(String string, int n) {
        Float3ArrayShaderEffectVariable float3ArrayShaderEffectVariable = new Float3ArrayShaderEffectVariable(this.shaderProgram, string, n);
        this.registerShaderEffectVariable(string, float3ArrayShaderEffectVariable);
        return float3ArrayShaderEffectVariable;
    }

    protected final Float4ShaderEffectVariable addFloat4ShaderEffectVariable(String string) {
        Float4ShaderEffectVariable float4ShaderEffectVariable = new Float4ShaderEffectVariable(this.shaderProgram, string);
        this.registerShaderEffectVariable(string, float4ShaderEffectVariable);
        return float4ShaderEffectVariable;
    }

    protected final Float4ArrayShaderEffectVariable addFloat4ArrayShaderEffectVariable(String string, int n) {
        Float4ArrayShaderEffectVariable float4ArrayShaderEffectVariable = new Float4ArrayShaderEffectVariable(this.shaderProgram, string, n);
        this.registerShaderEffectVariable(string, float4ArrayShaderEffectVariable);
        return float4ArrayShaderEffectVariable;
    }

    @Override
    public final ShaderProgram getShaderProgram() {
        return this.shaderProgram;
    }
}

