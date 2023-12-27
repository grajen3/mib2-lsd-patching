/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactContactListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechPhoneDataContactContactListTransformer
extends AbstractSpeechPhoneDataContactContactListTransformer {
    @Override
    public int getInt(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 1: {
                return contactNameModel.getNumberOfSubitems();
            }
            case 4: {
                if (contactNameModel.getNumberOfSubitems() == 0) {
                    return contactNameModel.getCountOfNumbers();
                }
                return 0;
            }
            case 6: {
                if (contactNameModel.getNumberOfSubitems() == 0) {
                    return contactNameModel.getFirstCombinedLocType();
                }
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 0: {
                if (contactNameModel.getNumberOfSubitems() == 0) {
                    return contactNameModel.getObjectID();
                }
                return 0L;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 5: {
                if (contactNameModel.getNumberOfSubitems() == 0) {
                    return contactNameModel.getImage();
                }
                return null;
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
                if (contactNameModel.getNumberOfSubitems() == 0) {
                    return contactNameModel.getFirstPhoneNumberString();
                }
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

