/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.stages;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.datapool.ASLDatapoolObserver;
import de.vw.mib.list.DynamicListDataListener;
import generated.de.vw.mib.asl.internal.ListManager;

public class BAPStageObserver
implements DynamicListDataListener,
ASLDatapoolObserver {
    private BAPStage bapStage;
    private int logicalControlUnitID;
    private int updateId;
    private int[] propertyIDs;
    private int[] listItemControlIDs;

    public BAPStageObserver(BAPStage bAPStage, int n, int n2) {
        this.bapStage = bAPStage;
        this.logicalControlUnitID = n;
        this.updateId = n2;
        this.propertyIDs = null;
        this.listItemControlIDs = null;
    }

    public void registerProperties(int[] nArray) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ServiceManager.serviceManager.dataPool.registerObserver(nArray[i2], this);
        }
        this.propertyIDs = nArray;
    }

    public void registerListItemControls(int[] nArray) {
        int n = nArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            ListManager.getASLList(nArray[i2]).addDynamicListDataListener(this);
        }
        this.listItemControlIDs = nArray;
    }

    public void unregister() {
        int n;
        int n2;
        if (this.propertyIDs != null) {
            n2 = this.propertyIDs.length;
            for (n = 0; n < n2; ++n) {
                ServiceManager.serviceManager.dataPool.unregisterObserver(this.propertyIDs[n], this);
            }
        }
        if (this.listItemControlIDs != null) {
            n2 = this.listItemControlIDs.length;
            for (n = 0; n < n2; ++n) {
                ListManager.getASLList(this.listItemControlIDs[n]).removeDynamicListDataListener(this);
            }
        }
    }

    @Override
    public void datapoolValueChanged(int n) {
        this.inputDataChange();
    }

    @Override
    public void activatedIndexChanged(int n) {
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.inputDataChangeCheckThreadChange();
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        this.inputDataChangeCheckThreadChange();
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        this.inputDataChangeCheckThreadChange();
    }

    @Override
    public void listChanged(int n) {
        this.inputDataChangeCheckThreadChange();
    }

    @Override
    public void listContentChanged() {
        this.inputDataChangeCheckThreadChange();
    }

    @Override
    public void stringIndexChanged() {
    }

    private void inputDataChangeCheckThreadChange() {
        if (ServiceManager.serviceManager.threadSwitchingTarget == null || ServiceManager.serviceManager.threadSwitchingTarget.isThreadChangeNecessary()) {
            ServiceManager.serviceManager.bapDispatcher.processDatapoolChangeWithThreadChange(this.logicalControlUnitID, this.bapStage.getFunctionId(), this.updateId);
        } else {
            this.inputDataChange();
        }
    }

    private void inputDataChange() {
        ServiceManager.serviceManager.bapDispatcher.processDatapoolChange(this.logicalControlUnitID, this.bapStage.getFunctionId(), this.updateId);
    }
}

