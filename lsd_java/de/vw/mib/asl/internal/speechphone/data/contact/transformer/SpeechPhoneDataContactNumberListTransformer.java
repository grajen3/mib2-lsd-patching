/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.internal.speechphone.utils.CommonUtils;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactNumberListTransformer;

public class SpeechPhoneDataContactNumberListTransformer
extends AbstractSpeechPhoneDataContactNumberListTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhoneNumber phoneNumber = (PhoneNumber)object;
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return CommonUtils.mapLocType(phoneNumber);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneNumber phoneNumber = (PhoneNumber)object;
        switch (n) {
            case 2: {
                return phoneNumber.getNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        switch (n) {
            case 3: {
                return 0L;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

