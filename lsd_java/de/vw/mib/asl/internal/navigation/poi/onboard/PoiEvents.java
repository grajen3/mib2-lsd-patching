/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.genericevents.AbstractTarget;

public final class PoiEvents {
    public static final int EV_TRANSITION;
    public static final int EV_NAVI_POI_ASL_STARTPOISPELLER;
    public static final int EV_NAVI_POI_PREVIEW_LIST_END_REACHED;
    private static final int[] ASL_OBSERVER;

    private PoiEvents() {
    }

    static void addObserver(AbstractTarget abstractTarget) {
        abstractTarget.registerServices(new int[]{1155609344, 1122054912, 1189163776, 1608594176}, false);
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObserver(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }

    static {
        ASL_OBSERVER = new int[]{-1224605632, -1342046144, -1509818304, -1493041088, -1476263872, 1355354176, 1372131392, -1392377792, -1425932224, -1409155008, -1308491712, -1325268928, -1291714496, -1543372736, -137883584, -121106368, -104329152, -87551936, -1627258816, -1123942336, -1375600576, -1107165120, -1174273984, -1442709440, -1358823360, -1241382848, 1678311488, -1459486656, 319422528, -1106771904, 1762263104, 1930035264, -486014912, -452460480, -385351616, -418906048, -402128832, -502792128, -519569344, 29954112, 264835136, 281612352, 298389568, 365498432, 633933888, 1137250368, 650711104, 667488320, 734597184, 885592128, -1157496768, 1155609344, 1122054912, 37303552, 87635200, 1189163776, 1523126336, 1608594176};
    }
}

