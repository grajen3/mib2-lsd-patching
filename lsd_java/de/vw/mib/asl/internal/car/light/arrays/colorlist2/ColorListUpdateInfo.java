/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist2;

import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListUpdateInfo;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;

public class ColorListUpdateInfo
extends IntLightRGBColorListUpdateInfo
implements ASGArrayListUpdateInfo {
    public static final int COLORLIST_UPDATEINFO_ASGID;

    public ColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        super(intLightRGBColorListUpdateInfo.arrayContent, intLightRGBColorListUpdateInfo.recordContent, intLightRGBColorListUpdateInfo.startElement, intLightRGBColorListUpdateInfo.numOfElements, intLightRGBColorListUpdateInfo.transactionID);
    }

    @Override
    public int getAsgID() {
        return 1;
    }
}

