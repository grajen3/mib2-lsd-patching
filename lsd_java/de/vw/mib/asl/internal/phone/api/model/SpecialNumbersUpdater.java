/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.callback.SpecialNumbersUpdate;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.ServiceNumbers;

public class SpecialNumbersUpdater {
    private final ArrayList listeners = new ArrayList();

    public void addListener(SpecialNumbersUpdate specialNumbersUpdate) {
        specialNumbersUpdate.onUpdate(ASLPhoneData.getInstance().specialNumbers);
        this.listeners.add(specialNumbersUpdate);
    }

    private void notifyObservers() {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            SpecialNumbersUpdate specialNumbersUpdate = (SpecialNumbersUpdate)iterator.next();
            specialNumbersUpdate.onUpdate(ASLPhoneData.getInstance().specialNumbers);
        }
    }

    public void updateServiceNumbers(ServiceNumbers serviceNumbers) {
        boolean bl = false;
        if (!ASLPhoneData.getInstance().roaming) {
            if (!StringUtil.equals(serviceNumbers.infonumber, ASLPhoneData.getInstance().specialNumbers.getInfo())) {
                bl = true;
                ASLPhoneData.getInstance().specialNumbers.setInfo(serviceNumbers.infonumber);
            }
            if (!StringUtil.equals(serviceNumbers.breakdownNumber, ASLPhoneData.getInstance().specialNumbers.getService())) {
                bl = true;
                ASLPhoneData.getInstance().specialNumbers.setService(serviceNumbers.breakdownNumber);
            }
        } else {
            if (!StringUtil.equals(serviceNumbers.infonumberRoaming, ASLPhoneData.getInstance().specialNumbers.getInfo())) {
                bl = true;
                ASLPhoneData.getInstance().specialNumbers.setInfo(serviceNumbers.infonumberRoaming);
            }
            if (!StringUtil.equals(serviceNumbers.breakdownNumberRoaming, ASLPhoneData.getInstance().specialNumbers.getService())) {
                bl = true;
                ASLPhoneData.getInstance().specialNumbers.setService(serviceNumbers.breakdownNumberRoaming);
            }
        }
        if (bl) {
            this.notifyObservers();
        }
    }

    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, boolean bl) {
        String string;
        String string2 = string = bl ? emergencyNumbers.mainEmergencyNumber : "";
        if (!StringUtil.equals(string, ASLPhoneData.getInstance().specialNumbers.getEmergency())) {
            ASLPhoneData.getInstance().specialNumbers.setEmergency(string);
            this.notifyObservers();
        }
    }

    public void updateMailboxNumbers(String string) {
        if (!StringUtil.equals(string, ASLPhoneData.getInstance().specialNumbers.getMailbox())) {
            ASLPhoneData.getInstance().specialNumbers.setMailbox(string);
            this.notifyObservers();
        }
    }
}

