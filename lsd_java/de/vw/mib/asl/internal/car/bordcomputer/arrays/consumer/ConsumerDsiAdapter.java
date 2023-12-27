/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer;

import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer.ConsumerDsiListener;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

class ConsumerDsiAdapter
extends ConsumerListDsiAdapter
implements ConsumerDsiListener {
    public ConsumerDsiAdapter(ConsumerListContext consumerListContext, ASGArrayList aSGArrayList) {
        super(consumerListContext, aSGArrayList);
    }

    private ConsumerListController getConsumerListController() {
        return this.getContext().getConsumerListController(0);
    }

    @Override
    public void updateBCmEListUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        if (this.getConsumerListController().isListAvailable()) {
            this.updateGenericBCmEConsumerListUpdateInfo(bCmEListUpdateInfo);
        } else {
            this.getContextLoger().warn("Consumer List: updateBCmEListUpdateInfo ignored because list is not available");
        }
    }

    @Override
    public void updateBCmEConsumerListTotalNumberOfElements(int n, int n2) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(n);
        } else {
            this.getContextLoger().warn("Consumer List: updateBCmEConsumerListTotalNumberOfElements ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerList[] bCmEConsumerListArray) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(bCmEConsumerListArray.length);
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListArray.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListArray[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List: responseBCmEConsumerList ignored because list is not available");
        }
    }
}

