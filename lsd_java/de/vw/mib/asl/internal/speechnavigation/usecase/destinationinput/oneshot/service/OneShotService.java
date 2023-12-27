/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class OneShotService
implements AdditionalDataService {
    private final ApplicationVariant variantService;

    public OneShotService() {
        this.variantService = new ApplicationVariantImpl();
    }

    public OneShotService(ApplicationVariant applicationVariant) {
        this.variantService = applicationVariant;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            OneShotModel oneShotModel;
            ResultItem resultItem = resultItemArray[i2];
            if (!this.variantService.isJPNVariant()) {
                if (resultItem.isGroup()) {
                    oneShotModel = new OneShotModel(i2, resultItem.getSize(), resultItem.getText());
                } else {
                    oneShotModel = new OneShotModel(i2);
                    IntObjectOptHashMap intObjectOptHashMap = this.getDestinationInputParts(resultItem);
                    ResultItemIdentifier resultItemIdentifier = (ResultItemIdentifier)intObjectOptHashMap.get(20);
                    ResultItemIdentifier resultItemIdentifier2 = (ResultItemIdentifier)intObjectOptHashMap.get(24);
                    ResultItemIdentifier resultItemIdentifier3 = (ResultItemIdentifier)intObjectOptHashMap.get(22);
                    if (resultItemIdentifier != null) {
                        oneShotModel.city = new ViewModelItem(resultItemIdentifier);
                    }
                    if (resultItemIdentifier2 != null) {
                        oneShotModel.street = new ViewModelItem(resultItemIdentifier2);
                    }
                    if (resultItemIdentifier != null) {
                        oneShotModel.houseNumber = new HouseNumber(i2, resultItemIdentifier3);
                    }
                }
            } else {
                throw new RuntimeException("JPN is not implemented");
            }
            objectArrayList.add(oneShotModel);
        }
        asyncCallback.onResponse(objectArrayList.toArray());
    }

    public IntObjectOptHashMap getDestinationInputParts(ResultItem resultItem) {
        ResultItemIdentifier resultItemIdentifier;
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(5);
        int n = 0;
        while (!this.isNull(resultItem.getIdentifier(n)) && (resultItemIdentifier = resultItem.getIdentifier(n)) != null) {
            intObjectOptHashMap.put(resultItemIdentifier.getId(), resultItemIdentifier);
            ++n;
        }
        return intObjectOptHashMap;
    }

    private boolean isNull(ResultItemIdentifier resultItemIdentifier) {
        return resultItemIdentifier.getId() == -1 && resultItemIdentifier.getRecognizedString().length() == 0 && resultItemIdentifier.getObjectId() == 0L && resultItemIdentifier.getObjectIndex() == -1 && resultItemIdentifier.getObjectStringId() == null;
    }
}

