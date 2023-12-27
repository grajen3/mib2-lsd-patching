/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.internal.ServiceManager;

public final class SkinHelper {
    private static final String[] LUT_WIDGET_FOLDERNAMES = new String[]{"OPS", "Climate", "CarStatus", "CarImages", "EnergyFlow", "GenericCarAdjuster", "PureAir"};
    public static final int WIDGET_ID_OPS;
    public static final int WIDGET_ID_CLIMATE;
    public static final int WIDGET_ID_CAR_STATUS;
    public static final int WIDGET_ID_CAR_IMAGE;
    public static final int WIDGET_ID_ENERGY_FLOW;
    public static final int WIDGET_ID_GENERIC_CAR_ADJUSTER;
    public static final int WIDGET_ID_PURE_AIR;

    protected SkinHelper() {
    }

    public static void preloadCarSpecificImageFromCommonSkin(String string, int n) {
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder(256);
            stringBuilder.append(SkinHelper.getRelativeEncodedVehicleWidgetPath(n)).append(string);
            ServiceManager.imageManager.preloadImageFromCommonSkin(stringBuilder.toString());
        }
    }

    public static BufferImage getCarSpecificImageFromCommonSkin(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(ServiceManager.configurationManager.getEncodedVehicleTypeForSkin0());
        stringBuilder.append("/");
        stringBuilder.append(LUT_WIDGET_FOLDERNAMES[n]);
        stringBuilder.append("/");
        stringBuilder.append(string);
        return ServiceManager.imageManager.getImageFromCommonSkin(stringBuilder.toString());
    }

    public static String getDataPath(int n) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(ServiceManager.configurationManager.getCommonDataPath());
        stringBuilder.append("/");
        stringBuilder.append(SkinHelper.getRelativeEncodedVehicleWidgetPath(n));
        return stringBuilder.toString();
    }

    private static String getRelativeEncodedVehicleWidgetPath(int n) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(ServiceManager.configurationManager.getEncodedVehicleTypeForSkin0());
        stringBuilder.append("/");
        stringBuilder.append(LUT_WIDGET_FOLDERNAMES[n]);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}

