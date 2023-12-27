/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model;

import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import org.dsi.ifc.global.ResourceLocator;

public class OnlinePOI {
    private IOnlinePoiListElement internalPOIElement;
    private int index;

    public OnlinePOI(IOnlinePoiListElement iOnlinePoiListElement, int n) {
        this.internalPOIElement = iOnlinePoiListElement;
        this.index = n;
    }

    public int getId() {
        return this.index;
    }

    public ResourceLocator getIcon() {
        return new ResourceLocator(this.internalPOIElement.getImageUrl());
    }

    public String getName() {
        return this.internalPOIElement.getPoiName();
    }

    public int getDistance() {
        return this.internalPOIElement.getDistance();
    }

    public int getDirectionArrowIndex() {
        return this.internalPOIElement.getDirectionIndex();
    }

    public IOnlinePoiListElement getOnlinePOIListElement() {
        return this.internalPOIElement;
    }
}

