/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.graphics.performance.PerformanceMetrics;
import de.vw.mib.util.StringBuilder;

public final class ShaderPerformanceMetrics
implements PerformanceMetrics {
    public int allocatedVertexShaders;
    public int allocatedFragmentShaders;
    public int allocatedGeometryShaders;
    public int allocatedTesselationControlShaders;
    public int allocatedTesselationEvaluationShaders;
    public int allocatedShaderPrograms;
    public int shaderProgramBinds;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[allocatedVertexShaders=").append(this.allocatedVertexShaders);
        stringBuilder.append(",allocatedFragmentShaders=").append(this.allocatedFragmentShaders);
        stringBuilder.append(",allocatedGeometryShaders=").append(this.allocatedGeometryShaders);
        stringBuilder.append(",allocatedTesselationControlShaders=").append(this.allocatedTesselationControlShaders);
        stringBuilder.append(",allocatedTesselationEvaluationShaders=").append(this.allocatedTesselationEvaluationShaders);
        stringBuilder.append(",allocatedShaderPrograms=").append(this.allocatedShaderPrograms);
        stringBuilder.append(",shaderProgramBinds=").append(this.shaderProgramBinds);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void clear() {
        this.shaderProgramBinds = 0;
    }
}

