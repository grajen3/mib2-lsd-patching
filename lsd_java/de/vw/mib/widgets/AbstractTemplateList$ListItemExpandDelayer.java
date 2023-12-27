/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractTemplateList;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.list.ListItemChangedListener;
import de.vw.mib.widgets.models.ListItemModel;

public final class AbstractTemplateList$ListItemExpandDelayer
implements ListItemChangedListener,
Runnable {
    private static final String DELAY_TIMER_NAME;
    private static final int DELAY_TIMEOUT;
    private final AbstractTemplateList templateList;
    private Timer delayTimer;
    private ListItemModel mainItemExpansionPending;
    private ListItemModel subItemExpansionPending;
    private int lastExpandedIndex;
    private final /* synthetic */ AbstractTemplateList this$0;

    public AbstractTemplateList$ListItemExpandDelayer(AbstractTemplateList abstractTemplateList, AbstractTemplateList abstractTemplateList2) {
        this.this$0 = abstractTemplateList;
        this.templateList = abstractTemplateList2;
        this.lastExpandedIndex = -1;
    }

    public void requestExpansion(ListItemModel listItemModel) {
        int n;
        this.resetExpansion();
        int n2 = listItemModel.get_activatedIndex();
        boolean bl = n2 == -1;
        this.lastExpandedIndex = bl ? this.lastExpandedIndex : n2;
        this.mainItemExpansionPending = listItemModel;
        if (listItemModel.hasSubItem()) {
            ListItemModel[] listItemModelArray = listItemModel.get_subItemRefs();
            for (n = 0; n < listItemModelArray.length && this.subItemExpansionPending == null; ++n) {
                this.subItemExpansionPending = listItemModelArray[n].isDynamic() ? listItemModelArray[n] : null;
            }
        }
        int n3 = n = this.subItemExpansionPending != null && this.subItemExpansionPending.isDynamic() && !bl ? 1 : 0;
        if (n != 0) {
            this.this$0.stopInternalAnimations();
            this.subItemExpansionPending.setListItemChangedListener(this);
            this.getDelayTimer().start();
        } else {
            this.executeExpansion();
        }
    }

    private Timer getDelayTimer() {
        if (this.delayTimer == null) {
            this.delayTimer = ServiceManager.timerManager.createTimer("AbstractTemplateList.ListItemExpandDelayer.DelayTimer", 0, false, this, ServiceManager.eventDispatcher);
        }
        return this.delayTimer;
    }

    private void executeExpansion() {
        this.resetExpansion();
        this.templateList.manageListExpansion(this.mainItemExpansionPending);
    }

    public boolean isSubItemExpandCollapsePending() {
        return this.subItemExpansionPending != null;
    }

    private void resetExpansion() {
        if (this.getDelayTimer().isStarted()) {
            this.getDelayTimer().stop();
        }
        if (this.subItemExpansionPending != null) {
            this.subItemExpansionPending.setListItemChangedListener(this.templateList.listItemChangedHandler);
        }
        this.subItemExpansionPending = null;
    }

    @Override
    public void listItemChanged(ListItemModel listItemModel, int n, int n2, int n3) {
        if (n == 0 && this.subItemExpansionPending.getItemCount() > 0) {
            this.executeExpansion();
        }
    }

    @Override
    public void run() {
        this.executeExpansion();
    }
}

