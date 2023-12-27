/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultItemRowNumberHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListController;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListControllerBase$1;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;

public abstract class ResultListControllerBase
implements ResultListController {
    private final ResultItemRowNumberHandler handler;
    final DataService service;
    private final ASLListManager aslListManager;

    protected ResultListControllerBase(DataService dataService, ResultItemRowNumberHandler resultItemRowNumberHandler) {
        this.service = dataService;
        this.handler = resultItemRowNumberHandler;
        this.aslListManager = null;
    }

    protected ResultListControllerBase(DataService dataService, ResultItemRowNumberHandler resultItemRowNumberHandler, ASLListManager aSLListManager) {
        this.service = dataService;
        this.handler = resultItemRowNumberHandler;
        this.aslListManager = aSLListManager;
    }

    final GenericASLList getASLList(int n) {
        if (this.aslListManager != null) {
            return this.aslListManager.getGenericASLList(n);
        }
        return ListManager.getGenericASLList(n);
    }

    @Override
    public void onRequestItems() {
        this.resetViewModel();
        this.service.getDataRequest(new ResultListControllerBase$1(this));
    }

    @Override
    public void onSelectItem(int n) {
        Object[] objectArray = this.getASLList(this.getListIdTopLevel()).getDSIObjects();
        if (n >= 0 && n < objectArray.length) {
            this.getASLList(this.getListIdSelectedItem()).updateList(new Object[]{objectArray[n]});
            this.notifyItemSelected();
        }
    }

    @Override
    public void onRecognizeRowNumber() {
        int n = this.handler.getRowNumber();
        this.notifyRowNumberRecognized(n);
    }

    private void resetViewModel() {
        this.getASLList(this.getListIdTopLevel()).clear();
        this.getASLList(this.getListIdSelectedItem()).clear();
    }
}

