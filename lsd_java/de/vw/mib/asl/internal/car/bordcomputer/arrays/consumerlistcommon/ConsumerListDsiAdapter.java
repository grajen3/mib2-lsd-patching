/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

public abstract class ConsumerListDsiAdapter {
    private ConsumerListContext _context;
    private int _totalNumberOfElements;
    private ASGArrayList _consumerArrayList;

    public ConsumerListDsiAdapter(ConsumerListContext consumerListContext, ASGArrayList aSGArrayList) {
        this._context = consumerListContext;
        this._consumerArrayList = aSGArrayList;
    }

    protected ASGArrayList getConsumerArrayList() {
        return this._consumerArrayList;
    }

    protected ConsumerListContext getContext() {
        return this._context;
    }

    protected CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    protected void setTotalNumberOfElements(int n) {
        this._totalNumberOfElements = n;
    }

    protected int getTotalNumberOfElements() {
        return this._totalNumberOfElements;
    }

    protected BAPStatusArray convertStatusArrayUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(bCmEListUpdateInfo.getStartElement(), bCmEListUpdateInfo.getNumOfElements(), bCmEListUpdateInfo.getArrayContent(), bCmEListUpdateInfo.getRecordContent(), bCmEListUpdateInfo.getTransactionID(), bCmEListUpdateInfo.getAsgID(), this.getTotalNumberOfElements());
    }

    protected void updateGenericBCmEConsumerListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo) {
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(bCmEListUpdateInfo.startElement, bCmEListUpdateInfo.getNumOfElements(), bCmEListUpdateInfo.getArrayContent(), bCmEListUpdateInfo.getRecordContent(), false);
        this.getConsumerArrayList().changedArray(bAPChangedArray);
    }

    protected void responseGenericBCmEConsumerListRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ConsumerListElementAdapter consumerListElementAdapter = new ConsumerListElementAdapter(bAPStatusArray.getArrayHeader());
            consumerListElementAdapter.setPos(nArray[i2]);
            bAPStatusArray.getArrayData().add(consumerListElementAdapter);
        }
        this.getConsumerArrayList().statusArray(bAPStatusArray);
    }

    public static BCmEListUpdateInfo toUpdateInfo(BAPGetArray bAPGetArray) {
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        return new BCmEListUpdateInfo(n, arrayHeader.start, arrayHeader.elements, bAPGetArray.getTransactionId(), arrayHeader.getRecordAddress(), bAPGetArray.getAsgId());
    }
}

