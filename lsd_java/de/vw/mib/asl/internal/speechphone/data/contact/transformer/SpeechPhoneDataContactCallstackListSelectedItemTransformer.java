/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.CommonUtils;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactCallstackListSelectedItemTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechPhoneDataContactCallstackListSelectedItemTransformer
extends AbstractSpeechPhoneDataContactCallstackListSelectedItemTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 5: {
                return CommonUtils.isDateTimeAvailable(callstackEntryModel.getDateTime());
            }
            case 6: {
                return callstackEntryModel.isKnownNumber();
            }
            case 7: {
                return callstackEntryModel.isContactInformationAvailable();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public int getInt(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 1: {
                return callstackEntryModel.getNumberOfSubitems();
            }
            case 3: {
                return callstackEntryModel.getEntryType();
            }
            case 8: {
                return callstackEntryModel.getDateTime().getHour();
            }
            case 9: {
                return callstackEntryModel.getDateTime().getMinute();
            }
            case 12: {
                return callstackEntryModel.getDateTime().getDay();
            }
            case 11: {
                return callstackEntryModel.getDateTime().getMonth();
            }
            case 10: {
                return callstackEntryModel.getDateTime().getYear();
            }
            case 14: {
                return callstackEntryModel.getCombinedLocType();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 0: {
                return callstackEntryModel.getObjectID();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 13: {
                return callstackEntryModel.getImage();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 2: {
                if (callstackEntryModel.getNumberOfSubitems() > 1) {
                    return callstackEntryModel.getName();
                }
                if (callstackEntryModel.isContactInformationAvailable()) {
                    return callstackEntryModel.getName();
                }
                return callstackEntryModel.getNumber();
            }
            case 4: {
                return callstackEntryModel.getNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

