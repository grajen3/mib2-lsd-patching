/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.controller;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.AdaptationAdapter;
import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManager;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.NavInfoAdapter;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.DisplayManagementAdapter;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.NavigationMapAdapter;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.ChangeDataRate;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.MostUnlockUseCase;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromABTToKombi;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromKombiToABT;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchToPermanentMap;

class StreamSinkCategoryManager
extends CategoryManager {
    public StreamSinkCategoryManager(CategoryManagerDelegate categoryManagerDelegate) {
        super(categoryManagerDelegate);
    }

    @Override
    protected AslServiceRegistry createService(Class clazz) {
        AslServiceRegistry aslServiceRegistry;
        if (clazz == DisplayManagementAdapter.getServiceClass()) {
            DisplayManagementAdapter displayManagementAdapter = new DisplayManagementAdapter();
            displayManagementAdapter.register();
            aslServiceRegistry = displayManagementAdapter;
        } else if (clazz == NavigationMapAdapter.getServiceClass()) {
            NavigationMapAdapter navigationMapAdapter = new NavigationMapAdapter();
            navigationMapAdapter.register();
            aslServiceRegistry = navigationMapAdapter;
        } else if (clazz == NavInfoAdapter.getServiceClass()) {
            NavInfoAdapter navInfoAdapter = new NavInfoAdapter();
            navInfoAdapter.register();
            aslServiceRegistry = navInfoAdapter;
        } else if (clazz == AdaptationAdapter.getServiceClass()) {
            AdaptationAdapter adaptationAdapter = new AdaptationAdapter();
            adaptationAdapter.register();
            aslServiceRegistry = adaptationAdapter;
        } else {
            aslServiceRegistry = super.createService(clazz);
        }
        return aslServiceRegistry;
    }

    @Override
    protected Category[] createCategories() {
        Category[] categoryArray = new Category[]{new ChangeDataRate(), new SwitchToPermanentMap(), new MostUnlockUseCase(), new SwitchMapFromABTToKombi(), new SwitchMapFromKombiToABT()};
        return categoryArray;
    }
}

