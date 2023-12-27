/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.api.speechengine.result.service.AdditionalDataService;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.service.ContactAdditionalDataService;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.service.OneShotService;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.service.OnboardPOICategoryAdditionalData;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.model.SUIModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUIService$1;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;

public class SUIService
implements AdditionalDataService {
    private final ContactAdditionalDataService contactsService;
    private final OneShotService addressService;
    private final ApplicationVariant applicationVariant;
    final ObjectArrayList suiItems = new ObjectArrayList();

    public SUIService() {
        this.applicationVariant = new ApplicationVariantImpl();
        this.contactsService = new ContactAdditionalDataService();
        this.addressService = new OneShotService(new ApplicationVariantImpl());
    }

    public SUIService(OnboardPOICategoryAdditionalData onboardPOICategoryAdditionalData, ContactAdditionalDataService contactAdditionalDataService, OneShotService oneShotService) {
        this.applicationVariant = new ApplicationVariantImpl();
        this.contactsService = contactAdditionalDataService;
        this.addressService = oneShotService;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback, ResultItem[] resultItemArray) {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap(10);
        LongIntOptHashMap longIntOptHashMap = new LongIntOptHashMap(10);
        this.suiItems.clear();
        for (int i2 = 0; i2 < resultItemArray.length; ++i2) {
            ResultItemIdentifier resultItemIdentifier;
            ResultItemIdentifier resultItemIdentifier2;
            ResultItemIdentifier resultItemIdentifier3;
            IntObjectOptHashMap intObjectOptHashMap2;
            Object object;
            ResultItem resultItem = resultItemArray[i2];
            if (resultItem.isGroup()) {
                if (resultItem.getGroupId() == 76) {
                    object = new OnboardPOICategory(resultItem.getSize(), resultItem.getText());
                    this.suiItems.add(i2, new SUIModel(i2, resultItem.getSize(), (OnboardPOICategory)object));
                    continue;
                }
                if (resultItem.getGroupId() == 75) {
                    object = new Contact(resultItem);
                    this.suiItems.add(i2, new SUIModel(i2, resultItem.getSize(), (Contact)object));
                    continue;
                }
                object = new OneShotModel(i2, resultItem.getSize(), resultItem.getText());
                this.suiItems.add(i2, new SUIModel(i2, resultItem.getSize(), (OneShotModel)object));
                continue;
            }
            if (resultItem.getIdentifier().getId() == 76) {
                this.suiItems.add(i2, new SUIModel(i2, new OnboardPOICategory(resultItem.getIdentifier())));
                continue;
            }
            if (resultItem.getIdentifier().getId() == 75) {
                intObjectOptHashMap.put(i2, resultItem);
                longIntOptHashMap.put(resultItem.getIdentifier().getObjectId(), i2);
                this.suiItems.add(i2, new SUIModel(i2, new Contact()));
                continue;
            }
            if (resultItem.isGroup()) {
                this.suiItems.add(i2, new SUIModel(resultItem.getSize(), resultItem.getText()));
                continue;
            }
            if (this.applicationVariant.isJPNVariant()) {
                object = new OneShotJpnModel(i2);
                intObjectOptHashMap2 = this.addressService.getDestinationInputParts(resultItem);
                resultItemIdentifier3 = (ResultItemIdentifier)intObjectOptHashMap2.get(70);
                resultItemIdentifier2 = (ResultItemIdentifier)intObjectOptHashMap2.get(71);
                resultItemIdentifier = (ResultItemIdentifier)intObjectOptHashMap2.get(72);
                ResultItemIdentifier resultItemIdentifier4 = (ResultItemIdentifier)intObjectOptHashMap2.get(73);
                ResultItemIdentifier resultItemIdentifier5 = (ResultItemIdentifier)intObjectOptHashMap2.get(74);
                if (resultItemIdentifier3 != null) {
                    ((OneShotJpnModel)object).prefecture = new ViewModelItem(resultItemIdentifier3);
                }
                if (resultItemIdentifier2 != null) {
                    ((OneShotJpnModel)object).municipality = new ViewModelItem(resultItemIdentifier2);
                }
                if (resultItemIdentifier != null) {
                    ((OneShotJpnModel)object).place = new ViewModelItem(resultItemIdentifier);
                }
                if (resultItemIdentifier4 != null) {
                    ((OneShotJpnModel)object).chome = new ViewModelItem(resultItemIdentifier4);
                }
                if (resultItemIdentifier3 != null) {
                    ((OneShotJpnModel)object).houseNumber = new HouseNumber(i2, resultItemIdentifier5);
                }
                this.suiItems.add(i2, new SUIModel(i2, (OneShotModel)object));
                continue;
            }
            object = new OneShotModel(i2);
            intObjectOptHashMap2 = this.addressService.getDestinationInputParts(resultItem);
            resultItemIdentifier3 = (ResultItemIdentifier)intObjectOptHashMap2.get(71);
            resultItemIdentifier2 = (ResultItemIdentifier)intObjectOptHashMap2.get(73);
            resultItemIdentifier = (ResultItemIdentifier)intObjectOptHashMap2.get(74);
            if (resultItemIdentifier3 != null) {
                ((OneShotModel)object).city = new ViewModelItem(resultItemIdentifier3);
            }
            if (resultItemIdentifier2 != null) {
                ((OneShotModel)object).street = new ViewModelItem(resultItemIdentifier2);
            }
            if (resultItemIdentifier3 != null) {
                ((OneShotModel)object).houseNumber = new HouseNumber(i2, resultItemIdentifier);
            }
            this.suiItems.add(i2, new SUIModel(i2, (OneShotModel)object));
        }
        if (!intObjectOptHashMap.isEmpty()) {
            this.contactsService.getDataRequest(new SUIService$1(this, longIntOptHashMap, asyncCallback), (ResultItem[])intObjectOptHashMap.valuesToArray(new ResultItem[intObjectOptHashMap.size()]));
        } else {
            asyncCallback.onResponse(this.suiItems.toArray());
        }
    }
}

