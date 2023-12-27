/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.displaymanagement;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.displaymanagement.DisplayContext;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIDisplayManagement
extends DSIBase {
    public static final String VERSION;
    public static final int RT_DECLARECONTEXTS;
    public static final int RT_SWITCHCONTEXT;
    public static final int RT_SETOPACITY;
    public static final int RT_FADETOOPACITY;
    public static final int RT_SETPOSITION;
    public static final int RT_GETEXTENTS;
    public static final int RT_TAKESCREENSHOT;
    public static final int RT_LOCKDISPLAY;
    public static final int RT_UNLOCKDISPLAY;
    public static final int RT_SWITCHDISPLAYPOWER;
    public static final int RT_GETDISPLAYPOWER;
    public static final int RT_SETDISPLAYBRIGHTNESS;
    public static final int RT_SETBRIGHTNESS;
    public static final int RT_GETBRIGHTNESS;
    public static final int RT_SETCONTRAST;
    public static final int RT_GETCONTRAST;
    public static final int RT_SETCOLOR;
    public static final int RT_GETCOLOR;
    public static final int RT_SETTINT;
    public static final int RT_GETTINT;
    public static final int RT_GETDISPLAYBRIGHTNESS;
    public static final int RT_SETCROPPING;
    public static final int RT_GETDISPLAYABLEINFO;
    public static final int RT_SETDIMENSION;
    public static final int RT_SETSCALEMODE;
    public static final int RT_TAKESCREENSHOTONEXTERNALSTORAGE;
    public static final int RT_SETDISPLAYTYPE;
    public static final int RT_GETDISPLAYTYPE;
    public static final int RT_SETUPDATERATE;
    public static final int RT_GETUPDATERATE;
    public static final int RT_STARTCOMPONENT;
    public static final int RT_STOPCOMPONENT;
    public static final int RT_CREATEIMAGEDISPLAYABLE;
    public static final int RT_REQUESTUPDATEIMAGEDISPLAYABLE;
    public static final int RT_DESTROYIMAGEDISPLAYABLE;
    public static final int RT_INITANNOTATIONS;
    public static final int RT_SETANNOTATIONDATA;
    public static final int RP_GETEXTENTS;
    public static final int RP_ACTIVECONTEXT;
    public static final int RP_FADESTARTED;
    public static final int RP_FADECOMPLETE;
    public static final int RP_GETDISPLAYPOWER;
    public static final int RP_GETBRIGHTNESS;
    public static final int RP_GETCONTRAST;
    public static final int RP_GETCOLOR;
    public static final int RP_GETTINT;
    public static final int RP_LOCKDISPLAYRESULT;
    public static final int RP_UNLOCKDISPLAYRESULT;
    public static final int RP_GETDISPLAYBRIGHTNESS;
    public static final int RP_SETCROPPINGRESULT;
    public static final int RP_GETDISPLAYABLEINFO;
    public static final int RP_TAKESCREENSHOTONEXTERNALSTORAGERESULT;
    public static final int RP_SETDISPLAYTYPERESULT;
    public static final int RP_GETDISPLAYTYPERESULT;
    public static final int RP_SETUPDATERATERESULT;
    public static final int RP_GETUPDATERATERESULT;
    public static final int RP_STARTCOMPONENTRESULT;
    public static final int RP_STOPCOMPONENTRESULT;
    public static final int RP_SETANNOTATIONDATARESPONSE;
    public static final int RP_INITANNOTATIONSRESPONSE;
    public static final int RP_DESTROYIMAGEDISPLAYABLERESPONSE;
    public static final int RP_REQUESTUPDATEIMAGEDISPLAYABLERESPONSE;
    public static final int RP_CREATEIMAGEDISPLAYABLERESPONSE;

    default public void declareContexts(DisplayContext[] displayContextArray) {
    }

    default public void switchContext(int n, int n2, int n3) {
    }

    default public void setOpacity(int n, int n2, int n3) {
    }

    default public void fadeToOpacity(int n, int n2, int n3, int n4) {
    }

    default public void setPosition(int n, int n2, int n3, int n4) {
    }

    default public void getExtents(int n) {
    }

    default public void takeScreenshot(int n, String string) {
    }

    default public void lockDisplay(int n) {
    }

    default public void unlockDisplay(int n) {
    }

    default public void switchDisplayPower(int n, int n2) {
    }

    default public void getDisplayPower(int n) {
    }

    default public void setDisplayBrightness(int n, int n2) {
    }

    default public void getDisplayBrightness(int n) {
    }

    default public void setBrightness(int n, int n2) {
    }

    default public void getBrightness(int n) {
    }

    default public void setContrast(int n, int n2) {
    }

    default public void getContrast(int n) {
    }

    default public void setColor(int n, int n2) {
    }

    default public void getColor(int n) {
    }

    default public void setTint(int n, int n2) {
    }

    default public void getTint(int n) {
    }

    default public void setCropping(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
    }

    default public void getDisplayableInfo(int n, int n2) {
    }

    default public void setDimension(int n, int n2, int n3, int n4) {
    }

    default public void setScaleMode(int n, int n2, int n3) {
    }

    default public void takeScreenshotOnExternalStorage(int n, String string) {
    }

    default public void setDisplayType(int n, int n2) {
    }

    default public void getDisplayType(int n) {
    }

    default public void setUpdateRate(int n, int n2) {
    }

    default public void getUpdateRate(int n) {
    }

    default public void startComponent(int n, int n2, int n3) {
    }

    default public void stopComponent(int n, int n2, int n3) {
    }

    default public void createImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    default public void requestUpdateImageDisplayable(ResourceLocator resourceLocator, int n) {
    }

    default public void destroyImageDisplayable(int n) {
    }

    default public void initAnnotations(int n) {
    }

    default public void setAnnotationData(int n, int n2, String string) {
    }
}

