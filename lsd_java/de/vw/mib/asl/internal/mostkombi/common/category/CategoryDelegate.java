/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.category;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceProvider;
import de.vw.mib.asl.internal.mostkombi.common.services.DsiServiceProvider;
import de.vw.mib.log4mib.Logger;

public interface CategoryDelegate
extends AslServiceProvider,
DsiServiceProvider {
    default public Category getCategory(Category category, int n) {
    }

    default public Logger getLogger() {
    }

    default public int getSubClassifier() {
    }
}

