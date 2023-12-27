/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.utils;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.CommonContact;
import de.vw.mib.asl.api.phone.services.callstack.CallstackDateTime;
import java.util.GregorianCalendar;
import org.dsi.ifc.messaging.MatchedAddress;
import org.dsi.ifc.messaging.MessageDetails;

public final class CommonUtils {
    private CommonUtils() {
    }

    public static boolean isContactInformationAvailable(CommonContact commonContact) {
        return commonContact != null && commonContact.getCombinedName() != null && commonContact.getCombinedName().length() > 0 && commonContact.getContactId() > 0L;
    }

    public static int mapLocType(PhoneNumber phoneNumber) {
        if (phoneNumber != null) {
            int n = phoneNumber.getDeviceType();
            int n2 = phoneNumber.getLocation();
            if (!CommonUtils.isContactInformationAvailable(phoneNumber.getCommonContact())) {
                return 0;
            }
            switch (n) {
                case 1: {
                    return 1;
                }
                case 3: {
                    switch (n2) {
                        case 2: {
                            return 4;
                        }
                        case 1: {
                            return 5;
                        }
                    }
                    return 6;
                }
            }
            switch (n2) {
                case 2: {
                    return 2;
                }
                case 1: {
                    return 3;
                }
            }
            return 0;
        }
        return 0;
    }

    public static boolean isDateTimeAvailable(CallstackDateTime callstackDateTime) {
        if (callstackDateTime != null) {
            int n = callstackDateTime.getYear() + callstackDateTime.getMonth() + callstackDateTime.getDay() + callstackDateTime.getHour() + callstackDateTime.getMinute() + callstackDateTime.getSecond();
            return n > 0;
        }
        return false;
    }

    public static MessageDetails createMessageDetails(String string, int n, MatchedAddress matchedAddress, double d2, String string2) {
        MessageDetails messageDetails = new MessageDetails();
        messageDetails.messagingAccountID = 0;
        messageDetails.messageID = string;
        messageDetails.type = n;
        messageDetails.sender = matchedAddress;
        messageDetails.dateTime = (long)d2;
        messageDetails.messageStatus = 4;
        messageDetails.body = string2;
        messageDetails.priority = 2;
        messageDetails.storageLocation = 0;
        return messageDetails;
    }

    public static GregorianCalendar getCalendar(double d2) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis((long)d2);
        return gregorianCalendar;
    }
}

