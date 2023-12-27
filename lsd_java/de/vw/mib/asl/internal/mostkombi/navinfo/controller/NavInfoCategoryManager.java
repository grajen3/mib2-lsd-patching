/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.controller;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManager;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryManagerDelegate;
import de.vw.mib.asl.internal.mostkombi.common.services.AslServiceRegistry;
import de.vw.mib.asl.internal.mostkombi.navinfo.api.navi.NavInfoAdapter;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.Capabilities;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.CityName;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.CurrentStreet;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.DistanceToDestination;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.DistanceToNextManeuver;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.EstimatedRemainingTripTime;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.EstimatedTimeArrival;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.RouteGuidanceMode;
import de.vw.mib.asl.internal.mostkombi.navinfo.functions.TurnToStreet;

class NavInfoCategoryManager
extends CategoryManager {
    public NavInfoCategoryManager(CategoryManagerDelegate categoryManagerDelegate) {
        super(categoryManagerDelegate);
    }

    @Override
    protected AslServiceRegistry createService(Class clazz) {
        AslServiceRegistry aslServiceRegistry;
        if (clazz == NavInfoAdapter.getServiceClass()) {
            NavInfoAdapter navInfoAdapter = new NavInfoAdapter();
            navInfoAdapter.register();
            aslServiceRegistry = navInfoAdapter;
        } else {
            aslServiceRegistry = super.createService(clazz);
        }
        return aslServiceRegistry;
    }

    @Override
    protected Category[] createCategories() {
        Category[] categoryArray = new Category[]{new Capabilities(), new CityName(), new CurrentStreet(), new DistanceToDestination(), new DistanceToNextManeuver(), new EstimatedRemainingTripTime(), new EstimatedTimeArrival(), new RouteGuidanceMode(), new TurnToStreet()};
        return categoryArray;
    }
}

