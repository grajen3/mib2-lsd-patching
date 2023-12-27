/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.picturehandling;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIPictureHandling
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETPICTURECONFIG;
    public static final int RT_REQUESTPICTURES;
    public static final int RT_CANCELPICTURE;
    public static final int RT_FREEPICTURE;
    public static final int RP_FINISHPICTUREREQUEST;
    public static final int IN_INDICATEPICTURE;
    public static final int PICTURECONFIGUSECASE_DEFAULT;
    public static final int PICTURECONFIGUSECASE_COVERART;
    public static final int PICTURECONFIGUSECASE_PICTUREVIEWER;
    public static final int PICTURECONFIGUSECASE_THUMBNAILICONS;
    public static final int PICTURECONFIGUSECASE_ADDRESSBOOK;
    public static final int PICTURECONFIGUSECASE_TUNERPRESETSTATIONS;
    public static final int PICTURECONFIGUSECASE_TUNERSLIDESHOW;
    public static final int PICTURECONFIGUSECASE_NAVICONS;
    public static final int PICTURELOADINGRESULT_SUCCESS;
    public static final int PICTURELOADINGRESULT_FAILED;

    default public void setPictureConfig(int n, int n2, int n3) {
    }

    default public void requestPictures(int n, ResourceLocator[] resourceLocatorArray, int n2) {
    }

    default public void cancelPicture(int n) {
    }

    default public void freePicture(ResourceLocator resourceLocator) {
    }
}

