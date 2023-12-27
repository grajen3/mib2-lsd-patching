/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.spellerx.model;

import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandler;
import de.vw.mib.asl.api.navigation.map.AbstractDualListViewHandlerUpdateListener;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.spellerx.model.ModelListHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

class ModelListHandler$1
extends AbstractDualListViewHandler {
    private final /* synthetic */ ModelListHandler this$0;

    ModelListHandler$1(ModelListHandler modelListHandler, AbstractDualListViewHandlerUpdateListener abstractDualListViewHandlerUpdateListener) {
        this.this$0 = modelListHandler;
        super(abstractDualListViewHandlerUpdateListener);
    }

    @Override
    public NavLocation navLocationFromListItem(Object object) {
        int n = ((LIValueListElement)object).getLatitude();
        int n2 = ((LIValueListElement)object).getLongitude();
        return ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
    }
}

