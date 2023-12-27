/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption;

import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption.ConsumerListConsuptionDsiListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEListUpdateInfo;

class ConsumerListConsumptionDsiAdapter
extends ConsumerListDsiAdapter
implements ConsumerListConsuptionDsiListener {
    public ConsumerListConsumptionDsiAdapter(ConsumerListContext consumerListContext, ASGArrayList aSGArrayList) {
        super(consumerListContext, aSGArrayList);
    }

    private ConsumerListController getConsumerListController() {
        return this.getContext().getConsumerListController(1);
    }

    @Override
    public void updateBCmEConsumerListConsumptionUpdateInfo(BCmEListUpdateInfo bCmEListUpdateInfo, int n) {
        if (this.getConsumerListController().isListAvailable()) {
            this.updateGenericBCmEConsumerListUpdateInfo(bCmEListUpdateInfo);
        } else {
            this.getContextLoger().warn("Consumer List Consumption: updateBCmEConsumerListConsumptionUpdateInfo ignored because list is not available");
        }
    }

    @Override
    public void updateBCmEConsumerListConsumptionTotalNumberOfElements(int n, int n2) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(n);
        } else {
            this.getContextLoger().warn("Consumer List Consumption: updateBCmEConsumerListConsumptionTotalNumberOfElements ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRA0(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(bCmEConsumerListConsumptionRA0Array.length);
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListConsumptionRA0Array.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListConsumptionRA0Array[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List Consumption: responseBCmEConsumerListConsumptionRA0 ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRA1(BCmEListUpdateInfo bCmEListUpdateInfo, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
        if (this.getConsumerListController().isListAvailable()) {
            this.setTotalNumberOfElements(bCmEConsumerListConsumptionRA1Array.length);
            BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(bCmEListUpdateInfo);
            int n = bCmEConsumerListConsumptionRA1Array.length;
            for (int i2 = 0; i2 < n; ++i2) {
                bAPStatusArray.getArrayData().add(new ConsumerListElementAdapter(bCmEConsumerListConsumptionRA1Array[i2], bAPStatusArray.getArrayHeader()));
            }
            this.getConsumerArrayList().statusArray(bAPStatusArray);
        } else {
            this.getContextLoger().warn("Consumer List Consumption: responseBCmEConsumerListConsumptionRA1 ignored because list is not available");
        }
    }

    @Override
    public void responseBCmEConsumerListConsumptionRAF(BCmEListUpdateInfo bCmEListUpdateInfo, int[] nArray) {
        if (this.getConsumerListController().isListAvailable()) {
            this.responseGenericBCmEConsumerListRAF(bCmEListUpdateInfo, nArray);
        } else {
            this.getContextLoger().warn("Consumer List Consumption: responseBCmEConsumerListConsumptionRAF ignored because list is not available");
        }
    }
}

