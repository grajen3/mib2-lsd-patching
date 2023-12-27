/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.maneuverview;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.internal.navinfotile.maneuverview.DefaultNavInfoTileManeuverViewThreeItemsCollector;
import de.vw.mib.asl.internal.navinfotile.maneuverview.NavInfoTileManeuverViewThreeItemsCollector;
import generated.de.vw.mib.asl.internal.ListManager;

public class NavInfoTileManeuverViewNotifierModel {
    public void updateListManeuverView(IManeuverViewElement[] iManeuverViewElementArray) {
        Object[] objectArray = new NavInfoTileManeuverViewThreeItemsCollector[]{new DefaultNavInfoTileManeuverViewThreeItemsCollector(), new DefaultNavInfoTileManeuverViewThreeItemsCollector()};
        if (iManeuverViewElementArray != null) {
            ListManager.getGenericASLList(3037696).updateList(iManeuverViewElementArray);
            if (iManeuverViewElementArray.length >= 1) {
                objectArray[0] = new NavInfoTileManeuverViewThreeItemsCollector(iManeuverViewElementArray[0]);
            }
            if (iManeuverViewElementArray.length >= 2) {
                objectArray[1] = new NavInfoTileManeuverViewThreeItemsCollector(iManeuverViewElementArray[1]);
            }
        }
        ListManager.getGenericASLList(690903552).updateList(objectArray);
    }

    public void setManeuverViewDefaults() {
        this.updateListManeuverView(new IManeuverViewElement[0]);
    }
}

