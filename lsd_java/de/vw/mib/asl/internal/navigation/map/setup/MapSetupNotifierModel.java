/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;

public class MapSetupNotifierModel {
    private static final int LIST_DUALSCREEN_NUMBEROFVIEWS;
    private final GenericASLList listDualScreenMapVisibilities;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapSetupNotifierModel]");

    public MapSetupNotifierModel() {
        this.listDualScreenMapVisibilities = ListManager.getGenericASLList(762);
    }

    public void notifyAutoZoomChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyAutoZoomChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(841, bl);
    }

    public void notifyAutoZoomMapInMapChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyAutoZoomMapInMapChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(857, bl);
    }

    public void notifyCurrentMapTypeOnboard() {
        this.logger.trace("notifyCurrentMapTypeOnboard()");
        ServiceManager.aslPropertyManager.valueChangedInteger(3715, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapTypeChanged(0);
    }

    public void notifyLaneGuidanceChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyLaneGuidanceChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(842, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(731, bl);
    }

    public void notifyLastMapTypeChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyLastMapTypeChanged(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(3716, n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapLastTypeChanged(n);
    }

    public void notifyMapReady() {
        this.logger.trace("notifyMapReady()");
        ServiceManager.aslPropertyManager.valueChangedBoolean(759, true);
    }

    public void notifyPerspectiveChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyPerspectiveChanged(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(840, n);
    }

    public void notifyPOICategoriesAvailable() {
        this.logger.trace("notifyPOICategoriesAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1861226496, true);
    }

    public void notifyShowFavoritesChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyShowFavoritesChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(844, bl);
    }

    public void notifyShowPOIBrandMarkerChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyShowPOIBrandMarkerChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(839, bl);
    }

    public void notifyShowPOIsChanged(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyShowPOIsChanged(").append(bl).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(845, bl);
    }

    public void updateListDualScreenMapVisibilities(int[] nArray) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateListDualScreenMapVisibilities( visibileViews.length=").append(nArray == null ? 0 : nArray.length).append(")").log();
        }
        if (nArray == null || nArray.length == 0) {
            return;
        }
        Object[] objectArray = new Integer[14];
        for (int i2 = 0; i2 < 14; ++i2) {
            objectArray[i2] = new Integer(nArray[i2]);
        }
        this.listDualScreenMapVisibilities.updateList(objectArray);
    }

    public void notifyDayNightModeChanged(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyDayNightModeChanged(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1259335680, n);
    }

    public void updateCurrentDayNightMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateCurrentDayNightMode(").append(n).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-1242558464, n);
    }
}

