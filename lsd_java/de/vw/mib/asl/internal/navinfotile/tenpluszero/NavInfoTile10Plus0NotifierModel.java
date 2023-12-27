/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.tenpluszero;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer.DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector;
import de.vw.mib.asl.internal.navinfotile.tenpluszero.transformer.NavInfoTileManeuverViewTenItemsManeuverViewDataCollector;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navinfotile.transformer.NavInfoTileManeuverExitViewDataCollector;
import java.util.LinkedList;

public class NavInfoTile10Plus0NotifierModel {
    private final NavInfoTileManeuverExitViewDataCollector[] maneuverExitViewDataCollector = new NavInfoTileManeuverExitViewDataCollector[]{new NavInfoTileManeuverExitViewDataCollector()};
    private NavInfoTileManeuverViewTenItemsManeuverViewDataCollector[] maneuverViewTenItemsDataCollector = new NavInfoTileManeuverViewTenItemsManeuverViewDataCollector[]{new DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector()};

    public void updateManeuverExitViewData() {
    }

    public void updateListManeuverExitViewData() {
    }

    public void updateManeuverViewTenItemsData(IManeuverViewElement[] iManeuverViewElementArray) {
        IManeuverViewElement[] iManeuverViewElementArray2 = this.removePois(iManeuverViewElementArray);
        this.maneuverViewTenItemsDataCollector = new NavInfoTileManeuverViewTenItemsManeuverViewDataCollector[iManeuverViewElementArray2.length];
        for (int i2 = 0; i2 < this.maneuverViewTenItemsDataCollector.length; ++i2) {
            this.maneuverViewTenItemsDataCollector[i2] = new NavInfoTileManeuverViewTenItemsManeuverViewDataCollector(iManeuverViewElementArray2[i2]);
        }
        this.updateListManeuverViewTenItemsData();
    }

    private IManeuverViewElement[] removePois(IManeuverViewElement[] iManeuverViewElementArray) {
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < iManeuverViewElementArray.length; ++i2) {
            if (!this.isNotPoi(iManeuverViewElementArray[i2])) continue;
            linkedList.add(iManeuverViewElementArray[i2]);
        }
        return (IManeuverViewElement[])linkedList.toArray(new IManeuverViewElement[0]);
    }

    private boolean isNotPoi(IManeuverViewElement iManeuverViewElement) {
        return iManeuverViewElement.getType() != 11 && iManeuverViewElement.getType() != 12;
    }

    private void updateListManeuverViewTenItemsData() {
        ServiceManager.aslPropertyManager.valueChangedInteger(70146560, this.maneuverViewTenItemsDataCollector.length);
        ListManager.getGenericASLList(86923776).updateList(this.maneuverViewTenItemsDataCollector);
        Object[] objectArray = new NavInfoTileManeuverViewTenItemsManeuverViewDataCollector[]{new DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector(), new DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector()};
        if (this.maneuverViewTenItemsDataCollector.length >= 1) {
            objectArray[0] = this.maneuverViewTenItemsDataCollector[0];
        }
        if (this.maneuverViewTenItemsDataCollector.length >= 2) {
            objectArray[1] = this.maneuverViewTenItemsDataCollector[1];
        }
        ListManager.getGenericASLList(707680768).updateList(objectArray);
    }

    public void setManeuverExitViewDataDefaults() {
        this.maneuverExitViewDataCollector[0].navinfotile_maneuver_exit_view_data_dtm = 0;
        this.maneuverExitViewDataCollector[0].navinfotile_maneuver_exit_view_data_street = "";
        this.maneuverExitViewDataCollector[0].navinfotile_maneuver_exit_view_data_street_sign_post = "";
        this.updateListManeuverExitViewData();
    }

    public void setManeuverViewTenItemsDefaults() {
        ServiceManager.aslPropertyManager.valueChangedInteger(70146560, 0);
        this.maneuverViewTenItemsDataCollector = new NavInfoTileManeuverViewTenItemsManeuverViewDataCollector[]{new DefaultNavInfoTileManeuverViewTenItemsManeuverViewDataCollector()};
        this.updateListManeuverViewTenItemsData();
    }
}

