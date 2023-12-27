/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractTemplateList;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ListItemModel;

public final class AbstractTemplateList$ListViewObserver
implements Runnable {
    private static final String DELAY_TIMER_NAME;
    private static final int COUNT_ADJUSTING;
    private Timer delayTimer;
    private final AbstractTemplateList templateList;
    private boolean timerRunning;
    private boolean updatePending;
    private final /* synthetic */ AbstractTemplateList this$0;

    public AbstractTemplateList$ListViewObserver(AbstractTemplateList abstractTemplateList, AbstractTemplateList abstractTemplateList2) {
        this.this$0 = abstractTemplateList;
        this.templateList = abstractTemplateList2;
    }

    public void updateListView() {
        this.updatePending = true;
        if (!this.timerRunning) {
            this.notifyListView();
            if (this.delayTimer == null) {
                this.delayTimer = ServiceManager.timerManager.createTimer("AbstractTemplateList.ListViewObserver.DelayTimer", this.templateList.get_listViewObserverDelay(), false, this, ServiceManager.eventDispatcher);
            }
            this.delayTimer.start();
            this.timerRunning = true;
        }
    }

    @Override
    public void run() {
        if (this.updatePending) {
            this.notifyListView();
        }
        this.timerRunning = false;
    }

    void notifyListView() {
        boolean bl;
        ListItemModel[] listItemModelArray = this.templateList.getListItems();
        int n = this.templateList.getFirstMostlyVisibleIndex();
        int n2 = this.templateList.getLastMostlyVisibleIndex();
        boolean bl2 = bl = this.this$0.getDragDataStorage().dragActive || this.this$0.isAdjusting();
        if (listItemModelArray != null) {
            for (int i2 = 0; i2 < listItemModelArray.length; ++i2) {
                ListItemModel listItemModel = listItemModelArray[i2];
                int n3 = -1;
                int n4 = -1;
                int n5 = 0;
                for (int i3 = n; i3 <= n2; ++i3) {
                    ListItemModel listItemModel2 = this.templateList.getItem(i3);
                    if (listItemModel2 == null || listItemModel2.get_targetId() != listItemModel.get_targetId()) continue;
                    if (n3 == -1) {
                        n3 = this.templateList.getItemIndex(i3);
                    }
                    n4 = this.templateList.getItemIndex(i3);
                }
                n5 = n3 < 0 || n4 < 0 ? 0 : n4 - n3 + 1;
                listItemModel.updateListView(bl ? -1 : n3, n5);
                this.updatePending = false;
            }
            this.this$0.notifyPageChanged();
        }
    }
}

