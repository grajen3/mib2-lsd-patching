/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistrange;

import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistrange.ConsumerListRangeDsiListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

class ConsumerListRangeDsiAdapter
extends ConsumerListDsiAdapter
implements ConsumerListRangeDsiListener {
    public ConsumerListRangeDsiAdapter(ConsumerListContext consumerListContext, ASGArrayList aSGArrayList) {
        super(consumerListContext, aSGArrayList);
    }

    private ConsumerListController getConsumerListController() {
        return this.getContext().getConsumerListController(2);
    }

    @Override
    public void updateBCmEConsumerListRangeUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        if (this.getConsumerListController().isListAvailable()) {
            this.updateGenericBCmEConsumerListUpdateInfo(bCmEListUpdateInfo);
        } else {
            this.getContextLoger().warn("Consumer List Range: updateBCmEConsumerListRangeUpdateInfo ignored because list is not available");
        }
    }

    @Override
    public void updateBCmEConsumerListRangeTotalNumberOfElements(int n, int n2) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(n);
        } else {
            this.getContextLoger().warn("Consumer List Range: updateBCmEConsumerListRangeTotalNumberOfElements ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(bCmEConsumerListRangeRA0Array.length);
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListRangeRA0Array.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListRangeRA0Array[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List Range: responseBCmEConsumerListRangeRA0 ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(bCmEConsumerListRangeRA1Array.length);
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListRangeRA1Array.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListRangeRA1Array[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List Range: responseBCmEConsumerListRangeRA1 ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRA2(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        if (this.getConsumerListController().isListAvailable()) {
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListRangeRA2Array.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListRangeRA2Array[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List Range: responseBCmEConsumerListRangeRA2 ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListRangeRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        if (this.getConsumerListController().isListAvailable()) {
            this.responseGenericBCmEConsumerListRAF(bCmEListUpdateInfo, nArray);
        } else {
            this.getContextLoger().warn("Consumer List Range: responseBCmEConsumerListRangeRAF ignored because list is not available");
        }
    }
}

