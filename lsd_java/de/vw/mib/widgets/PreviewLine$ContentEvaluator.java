/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.PreviewLine;
import de.vw.mib.widgets.controller.PreviewLineController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class PreviewLine$ContentEvaluator
implements Runnable {
    private static final String DELAY_TIMER_NAME;
    private static final int DELAY_TIMEOUT;
    private Timer delayTimer;
    private boolean evaluationPending;
    private final /* synthetic */ PreviewLine this$0;

    public PreviewLine$ContentEvaluator(PreviewLine previewLine) {
        this.this$0 = previewLine;
    }

    public void evaluate() {
        if (!this.evaluationPending) {
            if (this.delayTimer == null) {
                this.delayTimer = ServiceManager.timerManager.createTimer("PreviewLine.ContentEvaluator.DelayTimer", 0, false, this, ServiceManager.eventDispatcher);
            }
            this.delayTimer.start();
            this.evaluationPending = true;
        }
    }

    public void evaluteImmediately() {
        PreviewLineController previewLineController = (PreviewLineController)this.this$0.getController();
        InputFieldModel inputFieldModel = this.this$0.get_inputFieldRef();
        if (previewLineController != null) {
            if (inputFieldModel != null && inputFieldModel.get_spellerRef() != null && inputFieldModel.get_spellerRef().getEnteredText() != null && inputFieldModel.get_spellerRef().getEnteredText().length() > 0) {
                if (this.this$0.is_hideAutomatically() && this.this$0.previewList != null && this.this$0.previewList.get_itemCount() == 0) {
                    previewLineController.fire_hideAll();
                } else {
                    WidgetModel widgetModel = this.this$0.getContentWidget(2);
                    if (!widgetModel.is_visible() || this.this$0.resultList == null || this.this$0.resultList.get_itemCount() == 0) {
                        previewLineController.fire_showPreview();
                    }
                }
            } else if (this.this$0.is_hideAutomatically() && this.this$0.historyList != null && this.this$0.historyList.get_itemCount() == 0) {
                previewLineController.fire_hideAll();
            } else {
                previewLineController.fire_showHistory();
            }
        }
        this.evaluationPending = false;
    }

    @Override
    public void run() {
        this.evaluteImmediately();
    }
}

