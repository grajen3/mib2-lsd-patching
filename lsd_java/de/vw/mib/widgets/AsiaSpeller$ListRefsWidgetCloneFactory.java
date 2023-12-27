/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.list.ListItemControl;
import de.vw.mib.widgets.AsiaSpeller;
import de.vw.mib.widgets.AsiaSpeller$CandidateSelectedHandler;
import de.vw.mib.widgets.AsiaSpeller$PredictionListItemControl;
import de.vw.mib.widgets.AsiaSpeller$PredictionSelectedHandler;
import de.vw.mib.widgets.AsiaSpeller$PreviewLineListItemControl;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.models.ListItemModel;

final class AsiaSpeller$ListRefsWidgetCloneFactory
implements WidgetCloneFactory {
    private final WidgetCloneFactory cloneFactory;
    private OutEventListener candidateHandler;
    private OutEventListener predictionHandler;
    private final /* synthetic */ AsiaSpeller this$0;

    public AsiaSpeller$ListRefsWidgetCloneFactory(AsiaSpeller asiaSpeller, WidgetCloneFactory widgetCloneFactory) {
        this.this$0 = asiaSpeller;
        this.cloneFactory = widgetCloneFactory;
    }

    @Override
    public WidgetCloneable createWidgetCloneable(WidgetCloneable widgetCloneable) {
        WidgetCloneable widgetCloneable2 = this.cloneFactory.createWidgetCloneable(widgetCloneable);
        if (widgetCloneable instanceof ListItemModel) {
            ListItemControl listItemControl = ((ListItemModel)widgetCloneable).getListItemControl();
            if (listItemControl instanceof AsiaSpeller$PreviewLineListItemControl) {
                if (this.candidateHandler == null) {
                    this.candidateHandler = new AsiaSpeller$CandidateSelectedHandler(this.this$0, (AsiaSpeller$PreviewLineListItemControl)listItemControl);
                }
                this.registerOutEventHandler(this.candidateHandler, (ListItemModel)widgetCloneable2);
            } else if (listItemControl instanceof AsiaSpeller$PredictionListItemControl) {
                if (this.predictionHandler == null) {
                    this.predictionHandler = new AsiaSpeller$PredictionSelectedHandler(this.this$0, (AsiaSpeller$PredictionListItemControl)listItemControl);
                }
                this.registerOutEventHandler(this.predictionHandler, (ListItemModel)widgetCloneable2);
            }
        }
        return widgetCloneable2;
    }

    @Override
    public void destroyWidgetCloneable(WidgetCloneable widgetCloneable) {
        if (this.candidateHandler != null) {
            this.candidateHandler = null;
        }
        this.cloneFactory.destroyWidgetCloneable(widgetCloneable);
    }

    private void registerOutEventHandler(OutEventListener outEventListener, ListItemModel listItemModel) {
        WidgetController widgetController = listItemModel.getController();
        if (widgetController != null) {
            widgetController.addOutEventListener(outEventListener);
        }
    }
}

