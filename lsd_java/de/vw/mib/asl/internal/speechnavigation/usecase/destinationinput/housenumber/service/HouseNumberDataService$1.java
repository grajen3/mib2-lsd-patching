/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener$HouseNumberListInfo;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService;

class HouseNumberDataService$1
implements GetValuePartMatchesListener {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final /* synthetic */ AsyncCallback val$caller;
    private final /* synthetic */ HouseNumberDataService this$0;

    HouseNumberDataService$1(HouseNumberDataService houseNumberDataService, AsyncCallback asyncCallback) {
        this.this$0 = houseNumberDataService;
        this.val$caller = asyncCallback;
    }

    @Override
    public void getValuePartMatchesResponse(int n, GetValuePartMatchesListener$HouseNumberListInfo getValuePartMatchesListener$HouseNumberListInfo) {
        if (!$assertionsDisabled && getValuePartMatchesListener$HouseNumberListInfo == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && getValuePartMatchesListener$HouseNumberListInfo.getFlags() == null) {
            throw new AssertionError();
        }
        this.this$0.hnListAndInfos = getValuePartMatchesListener$HouseNumberListInfo;
        AppLogger.trace(this, new StringBuffer().append(".getValuePartMatchesResponse( hnListInfo = ").append(getValuePartMatchesListener$HouseNumberListInfo.toString()).append(" )").toString());
        int n2 = getValuePartMatchesListener$HouseNumberListInfo.getItems() == null ? 0 : getValuePartMatchesListener$HouseNumberListInfo.getItems().length;
        Object[] objectArray = new HouseNumber[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            objectArray[i2] = new HouseNumber(i2, getValuePartMatchesListener$HouseNumberListInfo.getItems()[i2]);
            AppLogger.trace(this, ((HouseNumber)objectArray[i2]).toString());
        }
        this.val$caller.onResponse(objectArray);
    }

    static {
        $assertionsDisabled = !(HouseNumberDataService.class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$housenumber$service$HouseNumberDataService == null ? (HouseNumberDataService.class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$housenumber$service$HouseNumberDataService = HouseNumberDataService.class$("de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService")) : HouseNumberDataService.class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$housenumber$service$HouseNumberDataService).desiredAssertionStatus();
    }
}

