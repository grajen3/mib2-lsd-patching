/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.transformer;

import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineLicense;
import java.util.Calendar;
import java.util.Date;

public class CoreServiceModelLicenseTransformer {
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    public String getString(int n, Object object) {
        return "";
    }

    public int getInt(int n, Object object) {
        OnlineLicense onlineLicense = (OnlineLicense)object;
        switch (n) {
            case 0: {
                return CoreServiceModelMap.getServiceIDInteger(onlineLicense.getServiceID());
            }
            case 1: {
                if (onlineLicense != null) {
                    return CoreServiceModelMap.getModelLicenseState(onlineLicense.getLicenseState());
                }
                return 0;
            }
            case 3: {
                if (onlineLicense != null && onlineLicense.getExpiryDate() != null && onlineLicense.getExpiryDate().getTime() > 0L) {
                    Date date = onlineLicense.getExpiryDate();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int n2 = calendar.get(5);
                    return n2;
                }
                return 0;
            }
            case 4: {
                if (onlineLicense != null && onlineLicense.getExpiryDate() != null && onlineLicense.getExpiryDate().getTime() > 0L) {
                    Date date = onlineLicense.getExpiryDate();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int n3 = calendar.get(2) + 1;
                    return n3;
                }
                return 0;
            }
            case 5: {
                if (onlineLicense != null && onlineLicense.getExpiryDate() != null && onlineLicense.getExpiryDate().getTime() > 0L) {
                    Date date = onlineLicense.getExpiryDate();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(date);
                    int n4 = calendar.get(1);
                    return n4;
                }
                return 0;
            }
        }
        throw new IllegalArgumentException();
    }
}

