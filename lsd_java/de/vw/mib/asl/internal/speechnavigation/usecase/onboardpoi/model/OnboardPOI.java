/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model;

import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.util.StringUtil;
import org.dsi.ifc.global.ResourceLocator;

public class OnboardPOI {
    private final int internalIndex;
    private final IOnboardPoiListElement model;

    public OnboardPOI(int n, IOnboardPoiListElement iOnboardPoiListElement) {
        this.internalIndex = n;
        this.model = iOnboardPoiListElement;
    }

    public ResourceLocator getIcon() {
        return this.model.getImage();
    }

    public String getName() {
        String[] stringArray = StringUtil.split(this.model.getPoiName(), ",");
        if (stringArray != null && stringArray.length >= 1) {
            return stringArray[0];
        }
        return this.model.getPoiName();
    }

    public int getDistance() {
        return this.model.getDistance();
    }

    public int getArrowIndex() {
        return this.model.getDirectionIndex();
    }

    public int getIndex() {
        return this.model.getIndex();
    }

    public int getInternalIndex() {
        return this.internalIndex;
    }

    public IOnboardPoiListElement getModel() {
        return this.model;
    }
}

