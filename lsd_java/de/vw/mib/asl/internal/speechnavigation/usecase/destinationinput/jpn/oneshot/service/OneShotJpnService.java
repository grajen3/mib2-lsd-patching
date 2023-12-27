/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.service.OneShotService;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class OneShotJpnService
extends OneShotService {
    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            OneShotJpnModel oneShotJpnModel;
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                oneShotJpnModel = new OneShotJpnModel(i2, resultItem.getSize(), resultItem.getText());
            } else {
                oneShotJpnModel = new OneShotJpnModel(i2);
                IntObjectOptHashMap intObjectOptHashMap = this.getDestinationInputParts(resultItem);
                ResultItemIdentifier resultItemIdentifier = (ResultItemIdentifier)intObjectOptHashMap.get(23);
                ResultItemIdentifier resultItemIdentifier2 = (ResultItemIdentifier)intObjectOptHashMap.get(20);
                ResultItemIdentifier resultItemIdentifier3 = (ResultItemIdentifier)intObjectOptHashMap.get(21);
                ResultItemIdentifier resultItemIdentifier4 = (ResultItemIdentifier)intObjectOptHashMap.get(24);
                ResultItemIdentifier resultItemIdentifier5 = (ResultItemIdentifier)intObjectOptHashMap.get(22);
                if (resultItemIdentifier != null) {
                    oneShotJpnModel.prefecture = new ViewModelItem(resultItemIdentifier);
                }
                if (resultItemIdentifier2 != null) {
                    oneShotJpnModel.municipality = new ViewModelItem(resultItemIdentifier2);
                }
                if (resultItemIdentifier3 != null) {
                    oneShotJpnModel.place = new ViewModelItem(resultItemIdentifier3);
                }
                if (resultItemIdentifier4 != null) {
                    oneShotJpnModel.chome = new ViewModelItem(resultItemIdentifier4);
                }
                if (resultItemIdentifier != null) {
                    oneShotJpnModel.houseNumber = new HouseNumber(i2, resultItemIdentifier5);
                }
            }
            objectArrayList.add(oneShotJpnModel);
        }
        asyncCallback.onResponse(objectArrayList.toArray());
    }
}

