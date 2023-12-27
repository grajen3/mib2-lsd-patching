/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.common;

import de.vw.mib.desktop.internal.common.ServiceManager;
import java.util.ArrayList;
import java.util.List;

public class DiagViewList {
    private static int previousCount = 0;
    private static int count = 0;
    private static int mark = 0;
    private static boolean contentChanged = false;
    private static ArrayList diagViewnameList = new ArrayList(8);
    private static ArrayList diagVisibleViewnameList = new ArrayList(8);
    private static ArrayList diagViewVisibility = new ArrayList(8);
    private static ArrayList diagViewnameAndVisibilityList = new ArrayList(8);
    private static ArrayList guideViewNameList = new ArrayList(8);
    private static ArrayList visibleGuideViewNameList = new ArrayList(8);

    public static void clear() {
        count = 0;
        contentChanged = false;
    }

    public static void clearToMark() {
        count = mark;
        contentChanged = false;
    }

    public static void mark() {
        mark = count;
    }

    public static void addViewAndVisibility(String string, String string2, boolean bl) {
        if (count < diagViewnameList.size()) {
            String string3 = (String)diagViewnameList.set(count, string2);
            guideViewNameList.set(count, string);
            contentChanged = contentChanged || !string3.equals(string2);
            Boolean bl2 = (Boolean)diagViewVisibility.set(count, bl);
            contentChanged = contentChanged || bl2 != bl;
        } else {
            diagViewnameList.add(string2);
            guideViewNameList.add(string);
            diagViewVisibility.add(bl);
            contentChanged = true;
        }
        ++count;
    }

    public static List getVisibleGuideViewNameList() {
        return visibleGuideViewNameList;
    }

    public static boolean sendIfNeeded(boolean bl) {
        if (count != previousCount || contentChanged) {
            diagViewnameAndVisibilityList.clear();
            diagVisibleViewnameList.clear();
            visibleGuideViewNameList.clear();
            for (int i2 = 0; i2 < count; ++i2) {
                if (((Boolean)diagViewVisibility.get(i2)).booleanValue()) {
                    diagViewnameAndVisibilityList.add(new StringBuffer().append("+").append(diagViewnameList.get(i2)).toString());
                    diagVisibleViewnameList.add(diagViewnameList.get(i2));
                    visibleGuideViewNameList.add(guideViewNameList.get(i2));
                    continue;
                }
                diagViewnameAndVisibilityList.add(new StringBuffer().append("-").append(diagViewnameList.get(i2)).toString());
            }
            previousCount = count;
            ServiceManager.diagViewListListener.notifyVisibleViewsChange(diagViewnameAndVisibilityList);
            return true;
        }
        return false;
    }
}

