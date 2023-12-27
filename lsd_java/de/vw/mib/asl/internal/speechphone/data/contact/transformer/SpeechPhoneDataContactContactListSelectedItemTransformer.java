/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactContactListSelectedItemTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechPhoneDataContactContactListSelectedItemTransformer
extends AbstractSpeechPhoneDataContactContactListSelectedItemTransformer {
    @Override
    public int getInt(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 1: {
                return contactNameModel.getNumberOfSubitems();
            }
            case 4: {
                return contactNameModel.getCountOfNumbers();
            }
            case 6: {
                return contactNameModel.getFirstCombinedLocType();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 0: {
                return contactNameModel.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 5: {
                return contactNameModel.getImage();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 2: {
                return contactNameModel.getName();
            }
            case 3: {
                return contactNameModel.getFirstPhoneNumberString();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

