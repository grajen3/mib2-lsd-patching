/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import java.util.Set;

public interface SceneQuery {
    default public int getQueryMask() {
    }

    default public void setQueryMask(int n) {
    }

    default public int getQueryTypeMask() {
    }

    default public void setQueryTypeMask(int n) {
    }

    default public Set execute() {
    }
}

