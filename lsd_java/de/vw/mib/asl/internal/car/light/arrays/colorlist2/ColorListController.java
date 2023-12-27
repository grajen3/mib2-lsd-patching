/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist2;

import de.vw.mib.asl.internal.car.light.ASLCarLightHsmTarget;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListContext;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListController;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListElementAdapterFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListController$1;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListDsiListener;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListElementAdapterFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist2.ColorListUpdateInfo;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;

public final class ColorListController
extends ASGArrayListController
implements ColorListDsiListener {
    private ASLCarLightHsmTarget context;
    private ColorListElementAdapterFactory newElementAdapterFactory = new ColorListElementAdapterFactory();
    public static final int COLOR_LIST_MAX_ELEMENTS_PER_REQUEST;
    public static final int COLOR_LIST_HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    public static final long COLOR_LIST_HIGH_LEVEL_RETRY_RETRY_TIME;
    private static final String LOGGING_TITLE_FOR_ARRAY;
    private ASGArrayListChangeNotifier clientsUpdater;
    private static final int COLORLIST_ASLAPI_CONSTANT;
    private static final int COLORLIST_LOADING_STATUS_ASLAPI_CONSTANT;

    public ColorListController(ASLCarLightHsmTarget aSLCarLightHsmTarget) {
        super("RGBColorList", 10, 5, 0, 1);
        this.context = aSLCarLightHsmTarget;
    }

    @Override
    protected ASGArrayListContext getContext() {
        return null;
    }

    @Override
    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        this.updateASGArrayListUpdateInfo(new ColorListUpdateInfo(intLightRGBColorListUpdateInfo), false);
    }

    @Override
    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        this.setTotalNumberOfElements(n);
    }

    @Override
    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        this.responseASGArrayList(new ColorListUpdateInfo(intLightRGBColorListUpdateInfo), new ColorListElementAdapterFactory(intLightRGBColorListRA0Array));
    }

    @Override
    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        this.responseASGArrayList(new ColorListUpdateInfo(intLightRGBColorListUpdateInfo), new ColorListElementAdapterFactory(nArray));
    }

    @Override
    protected ASGArrayListElementAdapterFactory getASGArrayListElementAdapterFactory() {
        return this.newElementAdapterFactory;
    }

    @Override
    protected ASGArrayListChangeNotifier getASGArrayListChangeNotifier() {
        if (this.clientsUpdater == null) {
            return new ColorListController$1(this, "RGBColorList", this.getContext(), -1, -1);
        }
        return this.clientsUpdater;
    }
}

