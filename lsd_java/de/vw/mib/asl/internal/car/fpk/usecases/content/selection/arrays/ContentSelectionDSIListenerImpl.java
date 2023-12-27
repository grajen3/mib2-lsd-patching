/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionDSIListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;

public class ContentSelectionDSIListenerImpl
implements ContentSelectionDSIListener {
    private boolean isBapListAvailable;
    private int bapListElementsCount;
    private final ASGArrayList bapList;

    public ContentSelectionDSIListenerImpl(ASGArrayList aSGArrayList) {
        this.bapList = aSGArrayList;
    }

    public ASGArrayList getList() {
        return this.bapList;
    }

    @Override
    public void onServiceStateChanged(boolean bl) {
        if (this.isBapListAvailable != bl) {
            this.isBapListAvailable = bl;
            if (!bl) {
                this.bapList.clearList();
            }
        }
    }

    @Override
    public void dsiCarKombiUpdateDCElementContentSelectionListUpdateInfo(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray, int n) {
        this.dsiCarKombiResponseDCElementContentSelectionListRAF(dCElementContentSelectionListUpdateInfo, nArray);
    }

    @Override
    public void dsiCarKombiUpdateDCElementContentSelectionListTotalNumberOfElements(int n, int n2) {
        this.bapListElementsCount = n;
    }

    @Override
    public void dsiCarKombiResponseDCElementContentSelectionListRA1(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        BAPStatusArray bAPStatusArray = this.toStatusArrayHeader(dCElementContentSelectionListUpdateInfo);
        for (DCElementContentSelectionListRA1 dCElementContentSelectionListRA1 : dCElementContentSelectionListRA1Array) {
            bAPStatusArray.getArrayData().add(new ContentSelectionBAPElement(bAPStatusArray.getArrayHeader(), dCElementContentSelectionListRA1));
        }
        this.bapList.statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarKombiResponseDCElementContentSelectionListRA2(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        BAPStatusArray bAPStatusArray = this.toStatusArrayHeader(dCElementContentSelectionListUpdateInfo);
        for (DCElementContentSelectionListRA2 dCElementContentSelectionListRA2 : dCElementContentSelectionListRA2Array) {
            bAPStatusArray.getArrayData().add(new ContentSelectionBAPElement(bAPStatusArray.getArrayHeader(), dCElementContentSelectionListRA2));
        }
        this.bapList.statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarKombiResponseDCElementContentSelectionListRAF(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo, int[] nArray) {
        int n = nArray != null ? nArray.length : 0;
        BAPChangedArray bAPChangedArray = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertChangedArrayUpdateInfo(dCElementContentSelectionListUpdateInfo.getStartElement(), dCElementContentSelectionListUpdateInfo.getNumOfElements(), dCElementContentSelectionListUpdateInfo.getArrayContent(), dCElementContentSelectionListUpdateInfo.getRecordContent(), n > 0);
        if (nArray != null) {
            int n2 = nArray.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                ContentSelectionBAPElement contentSelectionBAPElement = new ContentSelectionBAPElement(bAPChangedArray.getArrayHeader(), nArray[i2]);
                bAPChangedArray.getArrayData().add(contentSelectionBAPElement);
            }
        }
        this.bapList.changedArray(bAPChangedArray);
    }

    private BAPStatusArray toStatusArrayHeader(DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo) {
        BAPStatusArray bAPStatusArray = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertStatusArrayResponse(dCElementContentSelectionListUpdateInfo.getStartElement(), dCElementContentSelectionListUpdateInfo.getNumOfElements(), dCElementContentSelectionListUpdateInfo.getArrayContent(), dCElementContentSelectionListUpdateInfo.getRecordContent(), dCElementContentSelectionListUpdateInfo.getTransactionID(), dCElementContentSelectionListUpdateInfo.getAsgID(), this.bapListElementsCount);
        return bAPStatusArray;
    }
}

