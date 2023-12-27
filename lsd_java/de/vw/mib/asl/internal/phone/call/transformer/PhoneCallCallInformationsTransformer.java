/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.call.transformer.AbstractPhoneCallCallInformationsTransformer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;

public class PhoneCallCallInformationsTransformer
extends AbstractPhoneCallCallInformationsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        CallInformation callInformation = phoneCallInformationCollector.callInformation;
        switch (n) {
            case 14: {
                return callInformation.telRemEntryId != 0L && (phoneCallInformationCollector.mobileEquipment == null || phoneCallInformationCollector.mobileEquipment.getRole() == 0);
            }
            case 16: {
                return callInformation.telRemPictureId != null && (callInformation.telRemPictureId.isIntResource() || !Util.isNullOrEmpty(callInformation.telRemPictureId.url));
            }
            case 15: {
                return phoneCallInformationCollector.firstButtonAvailable;
            }
            case 17: {
                return PhoneUtil.isCallBoxSecondButtonAvailable(phoneCallInformationCollector);
            }
            case 22: {
                return PhoneUtil.isCallBoxHangupButtonAvailable(phoneCallInformationCollector);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        int n2;
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        CallInformation callInformation = phoneCallInformationCollector.callInformation;
        CallDuration callDuration = phoneCallInformationCollector.callDuration;
        switch (n) {
            case 19: {
                n2 = PhoneUtil.getCallBoxFirstButtonState(phoneCallInformationCollector);
                break;
            }
            case 20: {
                n2 = PhoneUtil.getCallBoxSecondButtonState(phoneCallInformationCollector);
                break;
            }
            case 2: {
                n2 = phoneCallInformationCollector.disconnectReason;
                break;
            }
            case 11: {
                n2 = PhoneUtil.convertCallStateDSI2ASL(phoneCallInformationCollector);
                break;
            }
            case 23: {
                n2 = PhoneUtil.convertCallTypeDSI2ASL(callInformation);
                break;
            }
            case 0: {
                n2 = callInformation.getTelCallID();
                break;
            }
            case 12: {
                n2 = callInformation.getTelCallStartingTime();
                break;
            }
            case 8: {
                n2 = callInformation.getTelRemNumberType();
                break;
            }
            case 3: {
                n2 = callDuration != null ? callDuration.getTelElapsedTime() : 0;
                break;
            }
            case 18: {
                n2 = PhoneUtil.convertPhoneTypeDSI2ASLCombined(callInformation.getTelRemNumberType());
                break;
            }
            case 21: {
                n2 = phoneCallInformationCollector.mobileEquipment != null && phoneCallInformationCollector.mobileEquipment.getRole() == 1 ? 1 : 0;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return n2;
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        CallInformation callInformation = phoneCallInformationCollector.callInformation;
        switch (n) {
            case 6: {
                if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().mailboxNumber) && phoneCallInformationCollector.callInformation.getTelRemNumber() != null && phoneCallInformationCollector.callInformation.getTelRemEntryId() == 0L && phoneCallInformationCollector.callInformation.getTelRemNumber().equals(ASLPhoneData.getInstance().mailboxNumber)) {
                    return ASLPhoneData.getInstance().localizedMailboxCall;
                }
                return callInformation.telRemName;
            }
            case 7: {
                return callInformation.telRemNumber;
            }
            case 4: {
                return "";
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        CallInformation callInformation = phoneCallInformationCollector.callInformation;
        switch (n) {
            case 9: {
                return callInformation.telRemPictureId;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

