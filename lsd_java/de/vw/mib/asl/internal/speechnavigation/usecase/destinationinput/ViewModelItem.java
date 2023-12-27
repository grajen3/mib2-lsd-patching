/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.speechengine.result.model.ResultItemIdentifier;

public class ViewModelItem {
    public int size = -1;
    public String objectId = "";
    public String recognizedString = "";

    public ViewModelItem(int n, String string) {
        this.size = n;
        this.recognizedString = string;
    }

    public ViewModelItem(INavigationListElement iNavigationListElement) {
        this(Long.toString(iNavigationListElement.getId()), iNavigationListElement.getTitle());
    }

    public ViewModelItem(String string, String string2) {
        this.objectId = string;
        this.recognizedString = string2;
    }

    public ViewModelItem(ResultItemIdentifier resultItemIdentifier) {
        if (resultItemIdentifier != null) {
            this.objectId = resultItemIdentifier.getObjectStringId();
            this.recognizedString = resultItemIdentifier.getRecognizedString();
        }
    }

    public boolean isObjectIdValid() {
        return this.objectId != null && this.objectId.trim().length() > 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("ViewModelItem");
        stringBuffer.append('(');
        stringBuffer.append("objectStringId");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.objectId);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("recognizedString");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.recognizedString);
        stringBuffer.append('\"');
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}

