/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.memory;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.osgi.framework.ServiceRegistration;

public class TargetASLNaviContactsNBestListAdditionalDataHandling
extends AbstractASLTarget {
    private static final int EV_ASL_INT_RESP_GET_ENTRIES_RESULT;
    EventGeneric pendingEvent;
    private int iterations = 0;
    private ServiceRegistration serviceRegistration;

    public TargetASLNaviContactsNBestListAdditionalDataHandling(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    public int getSubClassifier() {
        return 4;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 101001: {
                break;
            }
            case 101000: {
                this.serviceRegistration.unregister();
                break;
            }
            case 100100: {
                AdbEntry[] adbEntryArray = (AdbEntry[])eventGeneric.getObject(3);
                if (this.isTraceEnabled()) {
                    this.trace().append("Received nBestListData for ").append(adbEntryArray.length).append(" objects.").log();
                }
                for (int i2 = 0; adbEntryArray != null && i2 < adbEntryArray.length; ++i2) {
                    String[] stringArray = new String[2];
                    stringArray[0] = adbEntryArray[i2].getCombinedName();
                    AddressData[] addressDataArray = ASLPhoneFactory.getPhoneApi().ripADBAddressData(adbEntryArray[i2].getAddressData());
                    String string = "";
                    if (addressDataArray != null && addressDataArray.length > 0) {
                        int n = ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
                        string = ServiceManager.fixFormat4Asl.fmtRulesetBasedString(10 + n, ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(addressDataArray[0], null, null));
                    }
                    stringArray[1] = string != null ? string : "";
                }
                --this.iterations;
                if (this.isTraceEnabled()) {
                    this.trace().append("Responses left for nBestListData: ").append(this.iterations).log();
                }
                if (this.iterations != 0 || !this.isTraceEnabled()) break;
                this.trace().append("Send Back event to additionalnBestListDataHandling-Target").log();
                break;
            }
        }
    }
}

