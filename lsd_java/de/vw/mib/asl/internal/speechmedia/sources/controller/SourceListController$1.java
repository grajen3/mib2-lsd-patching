/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.controller;

import de.vw.mib.asl.internal.speechmedia.controller.SourceListObserver;
import de.vw.mib.asl.internal.speechmedia.sources.controller.SourceListController;
import de.vw.mib.asl.internal.speechmedia.sources.model.SourceModel;

class SourceListController$1
implements SourceListObserver {
    private final /* synthetic */ SourceListController this$0;

    SourceListController$1(SourceListController sourceListController) {
        this.this$0 = sourceListController;
    }

    @Override
    public void onUpdateSourceList(SourceModel[] sourceModelArray) {
        this.this$0.msController.getSpeechMediaServiceManager().getAslListManager().getGenericASLList(this.this$0.getListIdTopLevel()).updateList(sourceModelArray);
    }
}

