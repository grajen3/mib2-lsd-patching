/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.category;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

public interface CategoryManagerDelegate {
    default public Category findCategory(int n) {
    }

    default public Target getTarget() {
    }

    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }
}

