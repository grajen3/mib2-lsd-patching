/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultListHandler;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestController;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase$1;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase$2;
import de.vw.mib.asl.api.speechengine.result.handling.ResultListNBestControllerBase$3;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;

public abstract class ResultListNBestControllerBase
implements ResultListNBestController {
    private final ResultListHandler handler;
    final AdditionalDataService service;
    private final ASLListManager aslListManager;

    protected ResultListNBestControllerBase(AdditionalDataService additionalDataService, ResultListHandler resultListHandler) {
        this.service = additionalDataService;
        this.handler = resultListHandler;
        this.aslListManager = null;
    }

    protected ResultListNBestControllerBase(AdditionalDataService additionalDataService, ResultListHandler resultListHandler, ASLListManager aSLListManager) {
        this.service = additionalDataService;
        this.handler = resultListHandler;
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
        this.resetViewModels();
        ResultItem[] resultItemArray = this.handler.getTopLevelItems();
        this.service.getDataRequest(new ResultListNBestControllerBase$1(this, resultItemArray), resultItemArray);
    }

    @Override
    public void onSelectItem() {
        ResultItem resultItem = this.handler.selectByName();
        if (resultItem.isGroup()) {
            this.selectGroup(resultItem);
        } else {
            this.selectItem(resultItem);
        }
    }

    @Override
    public void onSelectItem(int n) {
        ResultItem resultItem = this.handler.selectByIndex(n);
        if (resultItem.isGroup()) {
            this.selectGroup(resultItem);
        } else {
            this.selectItemByIndex(this.getListIdTopLevel(), n);
        }
    }

    @Override
    public void onSelectSubItem(int n) {
        this.selectItemByIndex(this.getListIdDetailLevel(), n);
    }

    @Override
    public void onRecognizeRowNumber() {
        int n = this.handler.getRowNumber();
        this.notifyRowNumberRecognized(n);
    }

    private void selectItemByIndex(int n, int n2) {
        Object[] objectArray = this.getASLList(n).getDSIObjects();
        if (n2 >= 0 && n2 < objectArray.length) {
            this.updateViewModel(this.getListIdSelectedItem(), objectArray[n2]);
            this.notifyItemSelected();
        }
    }

    private void selectGroup(ResultItem resultItem) {
        ResultItem[] resultItemArray = this.handler.getDetailLevelItems(resultItem);
        this.service.getDataRequest(new ResultListNBestControllerBase$2(this, resultItem), resultItemArray);
    }

    private void selectItem(ResultItem resultItem) {
        Object[] objectArray = this.getASLList(!resultItem.hasGroup() ? this.getListIdTopLevel() : this.getListIdDetailLevel()).getDSIObjects();
        if (objectArray.length == 0) {
            this.service.getDataRequest(new ResultListNBestControllerBase$3(this), new ResultItem[]{resultItem});
        } else {
            int n = resultItem.getItemIndex();
            if (n >= 0 && n < objectArray.length) {
                this.updateViewModel(this.getListIdSelectedItem(), objectArray[resultItem.getItemIndex()]);
                this.notifyItemSelected();
            }
        }
    }

    private void resetViewModels() {
        this.getASLList(this.getListIdTopLevel()).clear();
        this.getASLList(this.getListIdDetailLevel()).clear();
        this.getASLList(this.getListIdSelectedItem()).clear();
    }

    void updateViewModel(int n, Object[] objectArray) {
        this.getASLList(n).updateList(objectArray);
    }

    void updateViewModel(int n, Object object) {
        this.getASLList(n).updateList(new Object[]{object});
    }
}

