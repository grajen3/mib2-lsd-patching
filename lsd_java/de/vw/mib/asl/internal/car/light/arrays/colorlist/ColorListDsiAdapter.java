/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.colorlist;

import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListContext;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListDsiListener;
import de.vw.mib.asl.internal.car.light.arrays.colorlist.ColorListElementAdapter;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carlight.IntLightRGBColorListRA0;
import org.dsi.ifc.carlight.IntLightRGBColorListUpdateInfo;

final class ColorListDsiAdapter
implements ColorListDsiListener {
    private int totalNumberOfElements;
    private ASGArrayList asgArrayList;

    public ColorListDsiAdapter(ColorListContext colorListContext, ASGArrayList aSGArrayList) {
        this.asgArrayList = aSGArrayList;
    }

    ASGArrayList getAsgArrayList() {
        return this.asgArrayList;
    }

    private void setTotalNumberOfElements(int n) {
        this.totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this.totalNumberOfElements;
    }

    protected BAPStatusArray convertStatusArrayUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(intLightRGBColorListUpdateInfo.getStartElement(), intLightRGBColorListUpdateInfo.getNumOfElements(), intLightRGBColorListUpdateInfo.getArrayContent(), intLightRGBColorListUpdateInfo.getRecordContent(), intLightRGBColorListUpdateInfo.getTransactionID(), 1, this.getTotalNumberOfElements());
    }

    @Override
    public void updateIntLightRGBColorListUpdateInfo(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int n) {
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(intLightRGBColorListUpdateInfo.startElement, intLightRGBColorListUpdateInfo.getNumOfElements(), intLightRGBColorListUpdateInfo.getArrayContent(), intLightRGBColorListUpdateInfo.getRecordContent(), false);
        this.getAsgArrayList().changedArray(bAPChangedArray);
    }

    @Override
    public void updateIntLightRGBColorListTotalNumberOfElements(int n, int n2) {
        this.setTotalNumberOfElements(n);
    }

    @Override
    public void responseIntLightRGBColorListRA0(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, IntLightRGBColorListRA0[] intLightRGBColorListRA0Array) {
        BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(intLightRGBColorListUpdateInfo);
        int n = intLightRGBColorListRA0Array.length;
        for (int i2 = 0; i2 < n; ++i2) {
            bAPStatusArray.getArrayData().add(new ColorListElementAdapter(intLightRGBColorListRA0Array[i2], bAPStatusArray.getArrayHeader()));
        }
        this.getAsgArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void responseIntLightRGBColorListRAF(IntLightRGBColorListUpdateInfo intLightRGBColorListUpdateInfo, int[] nArray) {
        BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(intLightRGBColorListUpdateInfo);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ColorListElementAdapter colorListElementAdapter = new ColorListElementAdapter(bAPStatusArray.getArrayHeader(), nArray[i2]);
            bAPStatusArray.getArrayData().add(colorListElementAdapter);
        }
        this.getAsgArrayList().statusArray(bAPStatusArray);
    }
}

