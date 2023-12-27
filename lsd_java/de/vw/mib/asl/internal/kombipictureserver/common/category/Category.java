/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.category;

import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryDelegate;

public interface Category {
    default public void initialize() {
    }

    default public void setDelegate(CategoryDelegate categoryDelegate) {
    }

    default public int getIdentifier() {
    }
}

