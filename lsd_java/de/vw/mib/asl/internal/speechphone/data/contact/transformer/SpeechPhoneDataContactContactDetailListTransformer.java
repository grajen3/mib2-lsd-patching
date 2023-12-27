/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.speechphone.data.internal.ContactNameModel;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactContactDetailListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechPhoneDataContactContactDetailListTransformer
extends AbstractSpeechPhoneDataContactContactDetailListTransformer {
    @Override
    public int getInt(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 3: {
                return contactNameModel.getCountOfNumbers();
            }
            case 5: {
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
            case 4: {
                return contactNameModel.getImage();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        ContactNameModel contactNameModel = (ContactNameModel)object;
        switch (n) {
            case 1: {
                return contactNameModel.getName();
            }
            case 2: {
                return contactNameModel.getFirstPhoneNumberString();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

