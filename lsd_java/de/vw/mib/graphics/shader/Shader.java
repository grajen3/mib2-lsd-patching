/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.shader;

import de.vw.mib.cache.Cacheable;
import de.vw.mib.graphics.Resource;
import java.util.List;

public interface Shader
extends Resource,
Cacheable {
    public static final int SHADER_TYPE_VERTEX;
    public static final int SHADER_TYPE_FRAGMENT;
    public static final int SHADER_TYPE_GEOMETRY;
    public static final int SHADER_TYPE_TESSELATION_CONTROL;
    public static final int SHADER_TYPE_TESSELATION_EVALUATION;
    public static final int SHADING_LANGUAGE_GLSL_ES_1_00;
    public static final int SHADING_LANGUAGE_GLSL_1_10_59;

    default public int getType() {
    }

    default public int getLanguage() {
    }

    default public List getSource() {
    }

    default public void setSource(List list) {
    }

    default public void appendSource(String string) {
    }

    default public void appendSource(List list) {
    }

    default public boolean isCompiled() {
    }

    default public boolean isLinked() {
    }

    default public void compile() {
    }
}

