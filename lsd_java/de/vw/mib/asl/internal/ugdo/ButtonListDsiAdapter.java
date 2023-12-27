/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.ugdo.ButtonListArrayElementAdapter;
import de.vw.mib.asl.internal.ugdo.ButtonListContext;
import de.vw.mib.asl.internal.ugdo.ButtonListDsiListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

public class ButtonListDsiAdapter
implements ButtonListDsiListener {
    private ButtonListContext _context;
    private int _totalNumberOfElements;
    private ASGArrayList _buttonListArrayList;

    public ButtonListDsiAdapter(ButtonListContext buttonListContext, ASGArrayList aSGArrayList) {
        this._context = buttonListContext;
        this._buttonListArrayList = aSGArrayList;
    }

    private ButtonListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    private void setTotalNumberOfElements(int n) {
        this._totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this._totalNumberOfElements;
    }

    private ASGArrayList getButtonArrayList() {
        return this._buttonListArrayList;
    }

    private BAPStatusArray convertToStatusArrayHeader(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertStatusArrayResponse(uGDOButtonListUpdateInfo.getStartElement(), uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListUpdateInfo.getArrayContent(), uGDOButtonListUpdateInfo.getRecordContent(), uGDOButtonListUpdateInfo.getTransactionID(), uGDOButtonListUpdateInfo.getAsgID(), this.getTotalNumberOfElements());
    }

    @Override
    public void dsiCarComfortUpdateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        BAPChangedArray bAPChangedArray = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().convertChangedArrayUpdateInfo(uGDOButtonListUpdateInfo.startElement, uGDOButtonListUpdateInfo.getNumOfElements(), uGDOButtonListUpdateInfo.getArrayContent(), uGDOButtonListUpdateInfo.getRecordContent(), false);
        this.getButtonArrayList().changedArray(bAPChangedArray);
    }

    @Override
    public void dsiCarComfortUpdateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        this.setTotalNumberOfElements(n);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA0 uGDOButtonListRA0 : uGDOButtonListRA0Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA0));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA1 uGDOButtonListRA1 : uGDOButtonListRA1Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA1));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA2 uGDOButtonListRA2 : uGDOButtonListRA2Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA2));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA3 uGDOButtonListRA3 : uGDOButtonListRA3Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA3));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA4 uGDOButtonListRA4 : uGDOButtonListRA4Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA4));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        for (UGDOButtonListRA5 uGDOButtonListRA5 : uGDOButtonListRA5Array) {
            bAPStatusArray.getArrayData().add(new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader(), uGDOButtonListRA5));
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }

    @Override
    public void dsiCarComfortResponseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        BAPStatusArray bAPStatusArray = this.convertToStatusArrayHeader(uGDOButtonListUpdateInfo);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ButtonListArrayElementAdapter buttonListArrayElementAdapter = new ButtonListArrayElementAdapter(bAPStatusArray.getArrayHeader());
            buttonListArrayElementAdapter.setPos(nArray[i2]);
            bAPStatusArray.getArrayData().add(buttonListArrayElementAdapter);
        }
        this.getButtonArrayList().statusArray(bAPStatusArray);
    }
}

