/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer;

import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer.ConsumerDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumer.ConsumerDsiListener;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListContext;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListController;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListDsiAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListElementAdapter;
import de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon.ConsumerListModelUpdater;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public class ConsumerController
extends ConsumerListController {
    private ConsumerDsiListener _consumerListDsiAdapter;
    private ASGArrayList _consumerArrayList;
    private static final int MAX_ELEMENTS_TO_REQUEST;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;

    public ConsumerController(ConsumerListContext consumerListContext) {
        super(consumerListContext);
    }

    @Override
    protected ASGArrayList getConsumerArrayList() {
        if (this._consumerArrayList == null) {
            this._consumerArrayList = new ArrayListFactory().createCompleteArrayList(this, new ConsumerListModelUpdater(this.getContext()), this, 1, 0, true, 4, 0);
        }
        return this._consumerArrayList;
    }

    public ConsumerDsiListener getConsumerListDsiListener() {
        if (this._consumerListDsiAdapter == null) {
            this._consumerListDsiAdapter = new ConsumerDsiAdapter(this.getContext(), this.getConsumerArrayList());
        }
        return this._consumerListDsiAdapter;
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        return new ConsumerListElementAdapter((ConsumerListElementAdapter)bAPArrayElement);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.getContext().getDsiCarEco().requestBCmEConsumerList(ConsumerListDsiAdapter.toUpdateInfo(bAPGetArray));
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

