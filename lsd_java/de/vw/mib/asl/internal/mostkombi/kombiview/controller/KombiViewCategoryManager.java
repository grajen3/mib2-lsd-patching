/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.kombiview.controller;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManager;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.NavInfoAdapter;

class KombiViewCategoryManager
extends CategoryManager {
    public KombiViewCategoryManager(CategoryManagerDelegate categoryManagerDelegate) {
        super(categoryManagerDelegate);
    }

    @Override
    protected AslServiceRegistry createService(Class clazz) {
        AslServiceRegistry aslServiceRegistry = clazz == NavInfoAdapter.getServiceClass() ? new NavInfoAdapter() : super.createService(clazz);
        return aslServiceRegistry;
    }

    @Override
    protected Category[] createCategories() {
        Category[] categoryArray = new Category[]{};
        return categoryArray;
    }
}

