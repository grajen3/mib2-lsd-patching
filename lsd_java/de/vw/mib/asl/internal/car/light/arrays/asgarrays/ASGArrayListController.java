/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.light.arrays.asgarrays;

import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListContext;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListElementAdapterFactory;
import de.vw.mib.asl.internal.car.light.arrays.asgarrays.ASGArrayListUpdateInfo;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;

public abstract class ASGArrayListController
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private final int maxElementsPerRequest;
    private final int nRetry;
    private final long tRetry;
    private ASGArrayList asgArrayList;
    private int totalNumberOfElements;
    private final int asgId;
    private final String loggingArrayName;

    protected ASGArrayListController(String string, int n, int n2, long l, int n3) {
        this.loggingArrayName = string;
        this.maxElementsPerRequest = n;
        this.nRetry = n2;
        this.tRetry = l;
        this.asgId = n3;
    }

    protected abstract ASGArrayListChangeNotifier getASGArrayListChangeNotifier() {
    }

    protected abstract ASGArrayListContext getContext() {
    }

    protected abstract ASGArrayListElementAdapterFactory getASGArrayListElementAdapterFactory() {
    }

    protected void setTotalNumberOfElements(int n) {
        this.totalNumberOfElements = n;
    }

    private int getTotalNumberOfElements() {
        return this.totalNumberOfElements;
    }

    private BAPStatusArray convertStatusArrayUpdateInfo(ASGArrayListUpdateInfo aSGArrayListUpdateInfo) {
        return BapArrayFactory.getInstance().getBAPArrayConverter().convertStatusArrayResponse(aSGArrayListUpdateInfo.getStartElement(), aSGArrayListUpdateInfo.getNumOfElements(), aSGArrayListUpdateInfo.getArrayContent(), aSGArrayListUpdateInfo.getRecordContent(), aSGArrayListUpdateInfo.getTransactionID(), aSGArrayListUpdateInfo.getAsgID(), this.getTotalNumberOfElements());
    }

    protected void responseASGArrayList(ASGArrayListUpdateInfo aSGArrayListUpdateInfo, ASGArrayListElementAdapterFactory aSGArrayListElementAdapterFactory) {
        BAPStatusArray bAPStatusArray = this.convertStatusArrayUpdateInfo(aSGArrayListUpdateInfo);
        int n = aSGArrayListElementAdapterFactory.getSize();
        for (int i2 = 0; i2 < n; ++i2) {
            BAPArrayElement bAPArrayElement = aSGArrayListElementAdapterFactory.createNewElementAdapter(i2);
            bAPArrayElement.setArrayHeader(bAPStatusArray.getArrayHeader());
            bAPStatusArray.getArrayData().add(bAPArrayElement);
        }
        this.getASGArrayList().statusArray(bAPStatusArray);
    }

    protected void updateASGArrayListUpdateInfo(ASGArrayListUpdateInfo aSGArrayListUpdateInfo, boolean bl) {
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().getBAPArrayConverter().convertChangedArrayUpdateInfo(aSGArrayListUpdateInfo.getStartElement(), aSGArrayListUpdateInfo.getNumOfElements(), aSGArrayListUpdateInfo.getArrayContent(), aSGArrayListUpdateInfo.getRecordContent(), bl);
        this.getASGArrayList().changedArray(bAPChangedArray);
    }

    private ASGArrayList getASGArrayList() {
        if (this.asgArrayList == null) {
            this.asgArrayList = new ArrayListFactory().createCompleteArrayList(this, this.getASGArrayListChangeNotifier(), this, this.asgId, 0, true, this.nRetry, this.tRetry);
        }
        return this.asgArrayList;
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        this.getContext().requestGetArray(n, arrayHeader, bAPGetArray.getTransactionId());
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return null;
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return this.getASGArrayListElementAdapterFactory().createNewElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        return this.getASGArrayListElementAdapterFactory().createNewElementAdapter(bAPArrayElement);
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.log(aSGArrayList, 2, "Request array time out");
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return this.maxElementsPerRequest;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append(this.loggingArrayName).append(": ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContext().fatal(string2);
                break;
            }
            case 2: {
                this.getContext().error(string2);
                break;
            }
            case 4: {
                this.getContext().warn(string2);
                break;
            }
            case 8: {
                this.getContext().info(string2);
                break;
            }
            case 12: {
                this.getContext().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContext().isTraceEnabled()) break;
                this.getContext().trace(string2);
                break;
            }
            default: {
                this.getContext().error("Unknown log message called");
            }
        }
    }
}

