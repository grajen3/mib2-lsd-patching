/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.conference.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.call.conference.transformer.AbstractPhoneCallConferenceConferenceCallInformationsTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class PhoneCallConferenceConferenceCallInformationsTransformer
extends AbstractPhoneCallConferenceConferenceCallInformationsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        switch (n) {
            case 8: {
                return phoneCallInformationCollector.callInformation.telRemEntryId != 0L;
            }
            case 9: {
                return (Util.isBitSet(16, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || phoneCallInformationCollector.mobileEquipment.getTelMode() != 3) && !ASLPhoneData.getInstance().isConferenceOnHold;
            }
            case 10: {
                return (Util.isBitSet(16, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || phoneCallInformationCollector.mobileEquipment.getTelMode() != 3) && ASLPhoneData.getInstance().isMultiPartySplitAvailable && !ASLPhoneData.getInstance().isConferenceOnHold;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        switch (n) {
            case 7: {
                return PhoneUtil.convertCallTypeDSI2ASL(phoneCallInformationCollector.callInformation);
            }
            case 0: {
                return phoneCallInformationCollector.callInformation.getTelCallID();
            }
            case 1: {
                return phoneCallInformationCollector.callDuration.getTelElapsedTime();
            }
            case 4: {
                return phoneCallInformationCollector.callInformation.getTelRemNumberType();
            }
            case 6: {
                return phoneCallInformationCollector.callInformation.getTelCallStartingTime();
            }
            case 11: {
                return phoneCallInformationCollector.disconnectReason;
            }
            case 12: {
                return PhoneUtil.convertCallStateDSI2ASL(phoneCallInformationCollector);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        switch (n) {
            case 2: {
                return phoneCallInformationCollector.callInformation.getTelRemName();
            }
            case 3: {
                return phoneCallInformationCollector.callInformation.getTelRemNumber();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        PhoneCallInformationCollector phoneCallInformationCollector = (PhoneCallInformationCollector)object;
        switch (n) {
            case 5: {
                return phoneCallInformationCollector.callInformation.getTelRemPictureId();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

