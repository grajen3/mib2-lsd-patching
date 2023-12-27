/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.contacts.transformer;

import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.AbstractPhoneContactsSelectedContactEMailAddressTransformer;
import org.dsi.ifc.organizer.EmailData;

public class PhoneContactsSelectedContactEMailAddressTransformer
extends AbstractPhoneContactsSelectedContactEMailAddressTransformer {
    @Override
    public String getString(int n, Object object) {
        EmailData emailData = (EmailData)object;
        switch (n) {
            case 0: {
                return PhoneUtil.replaceNullByEmptyString(emailData.getEmailAddr());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

