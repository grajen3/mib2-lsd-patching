/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.shader;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.shader.Shader;
import de.vw.mib.graphics.shader.ShaderManager;
import de.vw.mib.graphics.shader.ShaderPerformanceMetrics;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractShader
extends AbstractResource
implements Shader {
    private static final int SHADER_SOURCE_LIST_INITIAL_CAPACITY;
    private final ShaderManager shaderManager;
    private final int type;
    private final int shadingLanguage;
    private boolean compiled;
    private boolean linked;
    private List source;

    public AbstractShader(Graphics3D graphics3D, Logger logger, ShaderManager shaderManager, int n, int n2) {
        super(graphics3D, logger);
        this.shaderManager = shaderManager;
        this.type = n;
        this.shadingLanguage = n2;
        this.compiled = false;
        this.linked = false;
        this.source = new ArrayList(10);
        this.updateAllocationStatistics(this.shaderManager.getPerformanceMetrics(), true);
    }

    @Override
    public void dispose() {
        this.updateAllocationStatistics(this.shaderManager.getPerformanceMetrics(), false);
        super.dispose();
    }

    protected final void updateAllocationStatistics(ShaderPerformanceMetrics shaderPerformanceMetrics, boolean bl) {
        switch (this.type) {
            case 0: {
                shaderPerformanceMetrics.allocatedVertexShaders = shaderPerformanceMetrics.allocatedVertexShaders + (bl ? 1 : -1);
                break;
            }
            case 1: {
                shaderPerformanceMetrics.allocatedFragmentShaders = shaderPerformanceMetrics.allocatedFragmentShaders + (bl ? 1 : -1);
                break;
            }
            case 2: {
                shaderPerformanceMetrics.allocatedGeometryShaders = shaderPerformanceMetrics.allocatedGeometryShaders + (bl ? 1 : -1);
                break;
            }
            case 3: {
                shaderPerformanceMetrics.allocatedTesselationControlShaders = shaderPerformanceMetrics.allocatedTesselationControlShaders + (bl ? 1 : -1);
                break;
            }
            case 4: {
                shaderPerformanceMetrics.allocatedTesselationEvaluationShaders = shaderPerformanceMetrics.allocatedTesselationEvaluationShaders + (bl ? 1 : -1);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid shader type");
            }
        }
    }

    @Override
    public int getByteSize() {
        return 0;
    }

    protected final ShaderManager getShaderManager() {
        return this.shaderManager;
    }

    @Override
    public final int getType() {
        return this.type;
    }

    @Override
    public final int getLanguage() {
        return this.shadingLanguage;
    }

    @Override
    public final List getSource() {
        return this.source;
    }

    @Override
    public final void setSource(List list) {
        this.source.clear();
        this.source.addAll(list);
    }

    @Override
    public final void appendSource(String string) {
        this.source.add(string);
    }

    @Override
    public final void appendSource(List list) {
        this.source.addAll(list);
    }

    @Override
    public final boolean isCompiled() {
        return this.compiled;
    }

    protected final void setCompiled(boolean bl) {
        this.compiled = bl;
    }

    @Override
    public abstract void compile() {
    }

    @Override
    public final boolean isLinked() {
        return this.linked;
    }

    public final void setLinked(boolean bl) {
        this.linked = bl;
    }

    protected static final List splitByWholeSeparatorPreserveAllTokens(String string, String string2) {
        return AbstractShader.splitByWholeSeparator(string, string2, -1, true);
    }

    protected static final List splitByWholeSeparator(String string, String string2, int n, boolean bl) {
        if (string == null) {
            return null;
        }
        int n2 = 100;
        ArrayList arrayList = new ArrayList(100);
        int n3 = string.length();
        if (n3 > 0) {
            int n4 = string2.length();
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            while (n7 < n3) {
                n7 = string.indexOf(string2, n6);
                if (n7 > -1) {
                    if (n7 > n6) {
                        if (++n5 == n) {
                            n7 = n3;
                            arrayList.add(string.substring(n6));
                            continue;
                        }
                        arrayList.add(string.substring(n6, n7));
                        n6 = n7 + n4;
                        continue;
                    }
                    if (bl) {
                        if (++n5 == n) {
                            n7 = n3;
                            arrayList.add(string.substring(n6));
                        } else {
                            arrayList.add("");
                        }
                    }
                    n6 = n7 + n4;
                    continue;
                }
                arrayList.add(string.substring(n6));
                n7 = n3;
            }
        }
        return arrayList;
    }
}

