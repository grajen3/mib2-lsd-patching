/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.model;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.ViewModelItem;

public class HouseNumber
extends ViewModelItem {
    private final int index;
    private INavigationListElement model;
    private ResultItemIdentifier slot;

    public HouseNumber(int n, INavigationListElement iNavigationListElement) {
        super(iNavigationListElement);
        this.model = iNavigationListElement;
        this.index = n;
    }

    public HouseNumber(int n, ResultItemIdentifier resultItemIdentifier) {
        super(resultItemIdentifier);
        this.slot = resultItemIdentifier;
        this.index = n;
    }

    public HouseNumber(int n, String string) {
        super(n, string);
        this.index = 0;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("HouseNumber");
        stringBuffer.append('{');
        stringBuffer.append("'INavigationListElement'");
        stringBuffer.append('(');
        if (this.model != null) {
            stringBuffer.append("id");
            stringBuffer.append('=');
            stringBuffer.append(this.model.getId());
            stringBuffer.append(',');
            stringBuffer.append("title");
            stringBuffer.append('=');
            stringBuffer.append('\"');
            stringBuffer.append(this.model.getTitle());
            stringBuffer.append('\"');
        }
        stringBuffer.append("), ");
        stringBuffer.append("'ResultItemIdentifier'");
        stringBuffer.append('(');
        if (this.slot != null) {
            stringBuffer.append("id");
            stringBuffer.append('=');
            stringBuffer.append(this.slot.getObjectId());
            stringBuffer.append(',');
            stringBuffer.append("recognizedString");
            stringBuffer.append('=');
            stringBuffer.append('\"');
            stringBuffer.append(this.slot.getRecognizedString());
            stringBuffer.append('\"');
            stringBuffer.append(',');
            stringBuffer.append("objectId");
            stringBuffer.append('=');
            stringBuffer.append(this.slot.getObjectId());
            stringBuffer.append(',');
            stringBuffer.append("index");
            stringBuffer.append('=');
            stringBuffer.append(this.slot.getObjectIndex());
            stringBuffer.append(',');
            stringBuffer.append("objectStringId");
            stringBuffer.append('=');
            stringBuffer.append('\"');
            stringBuffer.append(this.slot.getObjectStringId());
            stringBuffer.append('\"');
        }
        stringBuffer.append(')');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

