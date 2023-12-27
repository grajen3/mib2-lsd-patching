/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;

public class PPoiDatapool {
    private static final PPoiDatapool INSTANCE = new PPoiDatapool();
    private int openedCategoryGroupUid = -1;
    private ILocationWrapper referenceLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper();
    private int selectItem = -1;
    private int directionAngle;

    public static PPoiDatapool getInstance() {
        return INSTANCE;
    }

    public int getSelectItem() {
        return this.selectItem;
    }

    public void setSelectItem(int n) {
        this.selectItem = n;
    }

    public int getOpenedCategoryGroupUid() {
        return this.openedCategoryGroupUid;
    }

    public void setOpenedCategoryGroupUid(int n) {
        this.openedCategoryGroupUid = n;
    }

    public ILocationWrapper getReferenceLocation() {
        return this.referenceLocation;
    }

    public void setReferenceLocation(ILocationWrapper iLocationWrapper) {
        this.referenceLocation = iLocationWrapper;
    }

    public void setReferenceDirection(int n) {
        this.directionAngle = n;
    }

    public int getReferenceDirection() {
        return this.directionAngle;
    }
}

