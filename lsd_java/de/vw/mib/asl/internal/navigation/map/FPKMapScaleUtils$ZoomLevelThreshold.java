/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map;

import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils;
import de.vw.mib.desktop.internal.common.ServiceManager;
import java.util.SortedMap;
import java.util.TreeMap;

public class FPKMapScaleUtils$ZoomLevelThreshold {
    private static final int ID_DEFAULT;
    private static final int ID_METER;
    private static final int ID_KM;
    private static final int ID_KM_FLOATING;
    private static final int ID_YARD;
    private static final int ID_FOOT;
    private static final int ID_MILE;
    private static final int ID_MILE_FLOATING;
    private static final TreeMap THRESHOLDS;
    public final int zoomMetric;
    public final int zoomImperial;
    public final int unitMetric;
    public final int unitImperial;

    private FPKMapScaleUtils$ZoomLevelThreshold(int n, int n2, int n3, int n4) {
        this.zoomMetric = n;
        this.zoomImperial = n2;
        this.unitMetric = n3;
        this.unitImperial = n4;
    }

    private FPKMapScaleUtils$ZoomLevelThreshold() {
        this.zoomImperial = 0;
        this.zoomMetric = 0;
        this.unitImperial = 0;
        this.unitMetric = 0;
    }

    private static void setupZoomStep(int n, int n2, int n3, String string, int n4, String string2, int n5, String string3, int n6) {
        boolean bl = ServiceManager.configurationManager.isFeatureFlagSet(155);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(n, n2, n3, string, n4, bl ? string2 : string3, bl ? n5 : n6);
    }

    private static void setupZoomStep(int n, int n2, int n3, String string, int n4, String string2, int n5) {
        try {
            int n6 = (int)(Float.parseFloat(string) * 8257);
            int n7 = (int)(Float.parseFloat(string2) * 8257);
            THRESHOLDS.put(new Integer(n2), new FPKMapScaleUtils$ZoomLevelThreshold(n6, n7, n4, n5));
        }
        catch (Exception exception) {
            FPKMapScaleUtils.access$000().error("Routine problem occured when calculating getCorrespondingLevel(int)");
        }
    }

    static FPKMapScaleUtils$ZoomLevelThreshold getCorrespondingLevel(int n) {
        FPKMapScaleUtils$ZoomLevelThreshold fPKMapScaleUtils$ZoomLevelThreshold = new FPKMapScaleUtils$ZoomLevelThreshold();
        SortedMap sortedMap = THRESHOLDS.tailMap(new Integer(n));
        Object object = sortedMap.firstKey();
        if (object != null) {
            try {
                fPKMapScaleUtils$ZoomLevelThreshold = (FPKMapScaleUtils$ZoomLevelThreshold)THRESHOLDS.get(object);
            }
            catch (NumberFormatException numberFormatException) {
                FPKMapScaleUtils.access$000().error("Routine problem occured when calculating getCorrespondingLevel(int)");
            }
        }
        return fPKMapScaleUtils$ZoomLevelThreshold;
    }

    static {
        THRESHOLDS = new TreeMap();
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(0, 20, 18, "20", 0, "20", 2, "60", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(1, 30, 28, "30", 0, "30", 2, "100", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(2, 50, 46, "50", 0, "50", 2, "150", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(3, 75, 69, "75", 0, "75", 2, "200", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(4, 100, 91, "100", 0, "100", 2, "300", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(5, 150, 137, "150", 0, "150", 2, "500", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(6, 200, 183, "200", 0, "200", 2, "650", 3);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(7, 300, 274, "300", 0, "300", 2, "0.2", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(8, 400, 366, "400", 0, "400", 2, "0.25", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(9, 500, 457, "500", 0, "500", 2, "0.3", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(10, 750, 686, "750", 0, "750", 2, "0.5", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(11, 1000, 1127, "1", 1, "0.7", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(12, 1500, 1609, "1.5", 6, "1", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(13, 2000, 2414, "2", 1, "1.5", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(14, 2500, 2414, "2.5", 6, "1.5", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(15, 3000, 3219, "3", 1, "2", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(16, 4000, 4023, "4", 1, "2.5", 7);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(17, 5000, 4828, "5", 1, "3", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(18, 6000, 6437, "6", 1, "4", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(19, 7000, 6437, "7", 1, "4", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(20, 8000, 8047, "8", 1, "5", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(21, 9000, 8047, "9", 1, "5", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(22, 10000, 11265, "10", 1, "7", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(23, 15000, 16093, "15", 1, "10", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(24, 20000, 24140, "20", 1, "15", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(25, 30000, 32187, "30", 1, "20", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(26, 1083965440, 714932224, "40", 1, "25", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(27, 1354956800, -1732509696, "50", 1, "30", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(28, 1625948160, 1996161024, "60", 1, "40", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(29, 0x70110100, 1996161024, "70", 1, "40", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(30, -2143813376, 1396310272, "80", 1, "50", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(31, -1872822016, 1396310272, "90", 1, "50", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(32, -1601830656, 246939904, "100", 1, "70", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(33, 1223164160, -319422208, "125", 1, "80", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(34, -263650816, -1502346752, "150", 1, "100", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(35, -1733623296, -804191488, "175", 1, "125", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(36, 1074594560, -89259264, "200", 1, "150", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(37, -1865415936, -89259264, "250", 1, "150", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(38, -527236096, 1307116544, "300", 1, "200", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(39, -2145778176, -1608317440, "400", 1, "250", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(40, 547424000, -212007168, "500", 1, "300", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(41, -1071183616, -1697511168, "600", 1, "400", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(42, 1622018560, -317977856, "700", 1, "450", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(43, 3476480, 1078397952, "800", 1, "500", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(44, 1078071040, -423948800, "1000", 1, "600", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(45, 1625495040, -2138171392, "1500", 1, "1000", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(46, -2138825216, 548544000, "2000", 1, "1250", 4);
        FPKMapScaleUtils$ZoomLevelThreshold.setupZoomStep(47, -1608178176, -1059773440, "2500", 1, "1500", 4);
    }
}

