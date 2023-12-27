/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.animation.skin;

import de.vw.mib.graphics.scene.animation.skin.Bone;
import java.util.List;

public interface Skeleton {
    default public String getName() {
    }

    default public void setName(String string) {
    }

    default public Bone getRootBone() {
    }

    default public int getBoneCount() {
    }

    default public Bone getBone(int n) {
    }

    default public List getBones() {
    }
}

