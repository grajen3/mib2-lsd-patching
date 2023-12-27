/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;

public class MailboxDialingNumberSerializer {
    public static void putOptionalMailboxDialingNumber(ISerializer iSerializer, MailboxDialingNumber mailboxDialingNumber) {
        boolean bl = mailboxDialingNumber == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mailboxDialingNumber.getMailboxIdentifier();
            iSerializer.putInt32(n);
            String string = mailboxDialingNumber.getMailboxNumber();
            iSerializer.putOptionalString(string);
            boolean bl2 = mailboxDialingNumber.isTonNpiValid();
            iSerializer.putBool(bl2);
            int n2 = mailboxDialingNumber.getTonNpi();
            iSerializer.putInt32(n2);
            boolean bl3 = mailboxDialingNumber.isAlphaIdentifierValid();
            iSerializer.putBool(bl3);
            String string2 = mailboxDialingNumber.getAlphaIdentifier();
            iSerializer.putOptionalString(string2);
            boolean bl4 = mailboxDialingNumber.isExtConfCapValid();
            iSerializer.putBool(bl4);
            int n3 = mailboxDialingNumber.getExtConfCap();
            iSerializer.putInt32(n3);
            boolean bl5 = mailboxDialingNumber.isExtInfoValid();
            iSerializer.putBool(bl5);
            String string3 = mailboxDialingNumber.getExtInfo();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalMailboxDialingNumberVarArray(ISerializer iSerializer, MailboxDialingNumber[] mailboxDialingNumberArray) {
        boolean bl = mailboxDialingNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mailboxDialingNumberArray.length);
            for (int i2 = 0; i2 < mailboxDialingNumberArray.length; ++i2) {
                MailboxDialingNumberSerializer.putOptionalMailboxDialingNumber(iSerializer, mailboxDialingNumberArray[i2]);
            }
        }
    }

    public static MailboxDialingNumber getOptionalMailboxDialingNumber(IDeserializer iDeserializer) {
        MailboxDialingNumber mailboxDialingNumber = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            boolean bl2;
            int n;
            boolean bl3;
            String string2;
            boolean bl4;
            int n2;
            boolean bl5;
            String string3;
            int n3;
            mailboxDialingNumber = new MailboxDialingNumber();
            mailboxDialingNumber.mailboxIdentifier = n3 = iDeserializer.getInt32();
            mailboxDialingNumber.mailboxNumber = string3 = iDeserializer.getOptionalString();
            mailboxDialingNumber.tonNpiValid = bl5 = iDeserializer.getBool();
            mailboxDialingNumber.tonNpi = n2 = iDeserializer.getInt32();
            mailboxDialingNumber.alphaIdentifierValid = bl4 = iDeserializer.getBool();
            mailboxDialingNumber.alphaIdentifier = string2 = iDeserializer.getOptionalString();
            mailboxDialingNumber.extConfCapValid = bl3 = iDeserializer.getBool();
            mailboxDialingNumber.extConfCap = n = iDeserializer.getInt32();
            mailboxDialingNumber.extInfoValid = bl2 = iDeserializer.getBool();
            mailboxDialingNumber.extInfo = string = iDeserializer.getOptionalString();
        }
        return mailboxDialingNumber;
    }

    public static MailboxDialingNumber[] getOptionalMailboxDialingNumberVarArray(IDeserializer iDeserializer) {
        MailboxDialingNumber[] mailboxDialingNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mailboxDialingNumberArray = new MailboxDialingNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mailboxDialingNumberArray[i2] = MailboxDialingNumberSerializer.getOptionalMailboxDialingNumber(iDeserializer);
            }
        }
        return mailboxDialingNumberArray;
    }
}

