/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.contact.transformer;

import de.vw.mib.asl.internal.speechphone.data.internal.CallstackEntryModel;
import de.vw.mib.asl.internal.speechphone.utils.CommonUtils;
import generated.de.vw.mib.asl.internal.speechphone.data.contact.transformer.AbstractSpeechPhoneDataContactCallstackListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class SpeechPhoneDataContactCallstackListTransformer
extends AbstractSpeechPhoneDataContactCallstackListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 5: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return CommonUtils.isDateTimeAvailable(callstackEntryModel.getDateTime());
                }
                return false;
            }
            case 6: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.isKnownNumber();
                }
                return true;
            }
            case 7: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.isContactInformationAvailable();
                }
                return false;
            }
            case 15: {
                return callstackEntryModel.isShowContactPicture();
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
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getEntryType();
                }
                return 1;
            }
            case 8: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getDateTime().getHour();
                }
                return 0;
            }
            case 9: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getDateTime().getMinute();
                }
                return 0;
            }
            case 12: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getDateTime().getDay();
                }
                return 0;
            }
            case 11: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getDateTime().getMonth();
                }
                return 0;
            }
            case 10: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getDateTime().getYear();
                }
                return 0;
            }
            case 14: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getCombinedLocType();
                }
                return 0;
            }
            case 17: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getCountOfNumbers();
                }
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 0: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getObjectID();
                }
                return 0L;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 13: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getImage();
                }
                return null;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public String getString(int n, Object object) {
        CallstackEntryModel callstackEntryModel = (CallstackEntryModel)object;
        switch (n) {
            case 2: {
                if (callstackEntryModel.getNumberOfSubitems() > 0 || callstackEntryModel.isContactInformationAvailable()) {
                    return callstackEntryModel.getName();
                }
                return callstackEntryModel.getNumber();
            }
            case 4: {
                if (callstackEntryModel.getNumberOfSubitems() == 0) {
                    return callstackEntryModel.getNumber();
                }
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

