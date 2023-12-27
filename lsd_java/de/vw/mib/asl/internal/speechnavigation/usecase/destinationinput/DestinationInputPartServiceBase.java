/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.collections.ObjectArrayList;

public class DestinationInputPartServiceBase
implements AdditionalDataService {
    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                objectArrayList.add(new ViewModelItem(resultItem.getSize(), resultItem.getText()));
                continue;
            }
            objectArrayList.add(new ViewModelItem(resultItem.getIdentifier().getObjectStringId(), resultItem.getIdentifier().getRecognizedString()));
        }
        asyncCallback.onResponse(objectArrayList.toArray());
    }
}

