/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.locationinput.IHnrFlags;
import java.util.ArrayList;

public class GetValuePartMatchesListener$HouseNumberListInfo {
    private final IHnrFlags flags;
    private final int total;
    private final ArrayList houseNumbers;

    public GetValuePartMatchesListener$HouseNumberListInfo(INavigationListElement[] iNavigationListElementArray, int n, IHnrFlags iHnrFlags) {
        this.total = n;
        this.flags = iHnrFlags;
        this.houseNumbers = new ArrayList(iNavigationListElementArray.length);
        this.addItems(iNavigationListElementArray);
    }

    public IHnrFlags getFlags() {
        return this.flags;
    }

    public INavigationListElement[] getItems() {
        return (INavigationListElement[])this.houseNumbers.toArray(new INavigationListElement[this.houseNumbers.size()]);
    }

    public void addItems(INavigationListElement[] iNavigationListElementArray) {
        for (int i2 = 0; i2 < iNavigationListElementArray.length; ++i2) {
            this.houseNumbers.add(iNavigationListElementArray[i2]);
        }
    }

    public int getTotal() {
        return this.total;
    }

    public int getRetrieved() {
        return this.houseNumbers.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("( ");
        stringBuffer.append("housenumberNone = ");
        stringBuffer.append(this.flags.isHousenumberNone());
        stringBuffer.append(", housenumberUnique = ");
        stringBuffer.append(this.flags.isHousenumberUnique());
        stringBuffer.append(", housenumberMatchesFound = ");
        stringBuffer.append(this.flags.isHousenumberMatchesFound());
        stringBuffer.append(", housenumberAlternatives = ");
        stringBuffer.append(this.flags.isHousenumberAlternatives());
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }
}

