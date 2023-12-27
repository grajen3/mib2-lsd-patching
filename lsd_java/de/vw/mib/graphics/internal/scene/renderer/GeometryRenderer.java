/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import java.util.List;

public interface GeometryRenderer {
    default public void render(Mesh mesh, Primitives primitives, Effect effect, Material material, Transform transform, Matrix4f matrix4f, List list, boolean bl) {
    }
}

