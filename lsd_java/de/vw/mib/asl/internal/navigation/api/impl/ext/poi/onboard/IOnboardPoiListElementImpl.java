/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext.poi.onboard;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.LIValueListElement;

public class IOnboardPoiListElementImpl
implements IOnboardPoiListElement {
    LIValueListElement element;
    ResourceLocator image = null;
    int distance;
    int directionIndex;

    public String toString() {
        return this.element.toString();
    }

    public IOnboardPoiListElementImpl(LIValueListElement lIValueListElement, int n, int n2) {
        this.element = lIValueListElement;
        this.distance = n;
        this.directionIndex = n2;
    }

    @Override
    public String getPoiName() {
        return this.element.data;
    }

    @Override
    public int getIndex() {
        return this.element.listIndex;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getDirectionIndex() {
        return this.directionIndex;
    }

    @Override
    public ResourceLocator getImage() {
        return this.image;
    }
}

