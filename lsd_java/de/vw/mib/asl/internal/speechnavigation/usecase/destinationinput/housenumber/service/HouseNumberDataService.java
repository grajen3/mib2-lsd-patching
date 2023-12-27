/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service;

import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.DestinationInputService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.GetValuePartMatchesListener$HouseNumberListInfo;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model.HouseNumber;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.service.HouseNumberDataService$1;

public class HouseNumberDataService
implements DataService {
    private final DestinationInputService destinationInputService;
    protected GetValuePartMatchesListener$HouseNumberListInfo hnListAndInfos;
    protected HouseNumber recognizedHn = null;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechnavigation$usecase$destinationinput$housenumber$service$HouseNumberDataService;

    public HouseNumberDataService(DestinationInputService destinationInputService) {
        this.destinationInputService = destinationInputService;
    }

    public HouseNumberDataService() {
        this.destinationInputService = NavigationDestinationInputServiceAdapter.getService();
    }

    public void setHouseNumberLike(HouseNumber houseNumber) {
        this.recognizedHn = houseNumber;
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        this.destinationInputService.setHouseNumberLike(new HouseNumberDataService$1(this, asyncCallback), this.recognizedHn.recognizedString);
    }

    public boolean isHousenumberAlternatives() {
        return this.hnListAndInfos.getFlags().isHousenumberAlternatives();
    }

    public boolean isHousenumberMatchesFound() {
        return this.hnListAndInfos.getFlags().isHousenumberMatchesFound();
    }

    public boolean isHousenumberUnique() {
        return this.hnListAndInfos.getFlags().isHousenumberUnique();
    }

    public boolean isHousenumberNone() {
        return this.hnListAndInfos.getFlags().isHousenumberNone();
    }

    public int getAvailableItemsCount() {
        return this.hnListAndInfos.getTotal();
    }

    public HouseNumber getExactMatchFromList(Object[] objectArray) {
        if (objectArray != null && objectArray.length > 0) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                HouseNumber houseNumber = (HouseNumber)objectArray[i2];
                if (houseNumber.recognizedString == null || this.recognizedHn.recognizedString == null || !houseNumber.recognizedString.equals(this.recognizedHn.recognizedString)) continue;
                return houseNumber;
            }
        }
        return null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

