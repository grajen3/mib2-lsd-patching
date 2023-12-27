/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call.transformer;

import de.vw.mib.asl.internal.phone.call.CallHandling$MobileEquipmentListener;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;

public class PhoneCallInformationCollector {
    public CallInformation callInformation;
    public CallDuration callDuration;
    public int disconnectReason;
    public boolean joinPossible = false;
    public int conferenceCallState = -1;
    public boolean conferenceActiveOtherHold;
    public boolean replace = false;
    public CallHandling$MobileEquipmentListener mobileEquipment;
    public boolean firstButtonAvailable;
}

