/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.EmailData;

public class EmailDataSerializer {
    public static void putOptionalEmailData(ISerializer iSerializer, EmailData emailData) {
        boolean bl = emailData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = emailData.isPreferred();
            iSerializer.putBool(bl2);
            int n = emailData.getEmailType();
            iSerializer.putInt32(n);
            String string = emailData.getEmailAddr();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalEmailDataVarArray(ISerializer iSerializer, EmailData[] emailDataArray) {
        boolean bl = emailDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(emailDataArray.length);
            for (int i2 = 0; i2 < emailDataArray.length; ++i2) {
                EmailDataSerializer.putOptionalEmailData(iSerializer, emailDataArray[i2]);
            }
        }
    }

    public static EmailData getOptionalEmailData(IDeserializer iDeserializer) {
        EmailData emailData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            boolean bl2;
            emailData = new EmailData();
            emailData.preferred = bl2 = iDeserializer.getBool();
            emailData.emailType = n = iDeserializer.getInt32();
            emailData.emailAddr = string = iDeserializer.getOptionalString();
        }
        return emailData;
    }

    public static EmailData[] getOptionalEmailDataVarArray(IDeserializer iDeserializer) {
        EmailData[] emailDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            emailDataArray = new EmailData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                emailDataArray[i2] = EmailDataSerializer.getOptionalEmailData(iDeserializer);
            }
        }
        return emailDataArray;
    }
}

