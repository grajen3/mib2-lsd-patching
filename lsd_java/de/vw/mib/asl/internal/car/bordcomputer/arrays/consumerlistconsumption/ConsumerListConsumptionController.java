/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption;

import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListModelUpdater;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption.ConsumerListConsumptionDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistconsumption.ConsumerListConsuptionDsiListener;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public class ConsumerListConsumptionController
extends ConsumerListController {
    private ConsumerListConsuptionDsiListener _consumerListDsiAdapter;
    private ASGArrayList _consumerArrayList;
    private static final int MAX_ELEMENTS_TO_REQUEST;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;

    public ConsumerListConsumptionController(ConsumerListContext consumerListContext) {
        super(consumerListContext);
    }

    @Override
    protected ASGArrayList getConsumerArrayList() {
        if (this._consumerArrayList == null) {
            this._consumerArrayList = new ArrayListFactory().createCompleteArrayList(this, new ConsumerListModelUpdater(this.getContext()), this, 1, 0, true, 4, 0);
        }
        return this._consumerArrayList;
    }

    public ConsumerListConsuptionDsiListener getConsumerListDsiListener() {
        if (this._consumerListDsiAdapter == null) {
            this._consumerListDsiAdapter = new ConsumerListConsumptionDsiAdapter(this.getContext(), this.getConsumerArrayList());
        }
        return this._consumerListDsiAdapter;
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ConsumerListElementAdapter consumerListElementAdapter = new ConsumerListElementAdapter((ConsumerListElementAdapter)bAPArrayElement);
        ConsumerListElementAdapter consumerListElementAdapter2 = (ConsumerListElementAdapter)bAPArrayElement2;
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                consumerListElementAdapter.rangeValue = consumerListElementAdapter2.rangeValue;
                break;
            }
            default: {
                this.getContextLoger().error("ConsumerListConsumption: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return consumerListElementAdapter;
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.getContext().getDsiCarEco().requestBCmEConsumerListConsumption(ConsumerListDsiAdapter.toUpdateInfo(bAPGetArray));
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 4;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }
}

