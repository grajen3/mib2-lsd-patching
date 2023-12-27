/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model.CountryStateModel;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class CountryStateService
implements AdditionalDataService {
    private final ApplicationVariant variantService;

    public CountryStateService() {
        this.variantService = new ApplicationVariantImpl();
    }

    public CountryStateService(ApplicationVariant applicationVariant) {
        this.variantService = applicationVariant;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            CountryStateModel countryStateModel;
            ResultItem resultItem = resultItemArray[i2];
            if (!this.variantService.isJPNVariant()) {
                if (resultItem.isGroup()) {
                    countryStateModel = new CountryStateModel(i2, resultItem.getSize(), resultItem.getText());
                } else {
                    countryStateModel = new CountryStateModel(i2);
                    IntObjectOptHashMap intObjectOptHashMap = this.getDestinationInputParts(resultItem);
                    ResultItemIdentifier resultItemIdentifier = (ResultItemIdentifier)intObjectOptHashMap.get(27);
                    ResultItemIdentifier resultItemIdentifier2 = (ResultItemIdentifier)intObjectOptHashMap.get(28);
                    if (resultItemIdentifier != null) {
                        countryStateModel.country = new ViewModelItem(resultItemIdentifier);
                    }
                    if (resultItemIdentifier2 != null) {
                        countryStateModel.state = new ViewModelItem(resultItemIdentifier2);
                    }
                }
            } else {
                throw new RuntimeException("JPN is not implemented");
            }
            objectArrayList.add(countryStateModel);
        }
        asyncCallback.onResponse(objectArrayList.toArray());
    }

    private IntObjectOptHashMap getDestinationInputParts(ResultItem resultItem) {
        ResultItemIdentifier resultItemIdentifier;
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(4);
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

