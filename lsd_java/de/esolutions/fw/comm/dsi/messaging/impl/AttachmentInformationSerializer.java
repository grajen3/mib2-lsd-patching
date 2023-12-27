/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.messaging.AttachmentInformation;

public class AttachmentInformationSerializer {
    public static void putOptionalAttachmentInformation(ISerializer iSerializer, AttachmentInformation attachmentInformation) {
        boolean bl = attachmentInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = attachmentInformation.getAttachmentID();
            iSerializer.putInt32(n);
            String string = attachmentInformation.getName();
            iSerializer.putOptionalString(string);
            String string2 = attachmentInformation.getMimeType();
            iSerializer.putOptionalString(string2);
            int n2 = attachmentInformation.getSize();
            iSerializer.putInt32(n2);
            int n3 = attachmentInformation.getEntryID();
            iSerializer.putInt32(n3);
            ResourceLocator resourceLocator = attachmentInformation.getAttachmentPath();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalAttachmentInformationVarArray(ISerializer iSerializer, AttachmentInformation[] attachmentInformationArray) {
        boolean bl = attachmentInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(attachmentInformationArray.length);
            for (int i2 = 0; i2 < attachmentInformationArray.length; ++i2) {
                AttachmentInformationSerializer.putOptionalAttachmentInformation(iSerializer, attachmentInformationArray[i2]);
            }
        }
    }

    public static AttachmentInformation getOptionalAttachmentInformation(IDeserializer iDeserializer) {
        AttachmentInformation attachmentInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            int n;
            int n2;
            String string;
            String string2;
            int n3;
            attachmentInformation = new AttachmentInformation();
            attachmentInformation.attachmentID = n3 = iDeserializer.getInt32();
            attachmentInformation.name = string2 = iDeserializer.getOptionalString();
            attachmentInformation.mimeType = string = iDeserializer.getOptionalString();
            attachmentInformation.size = n2 = iDeserializer.getInt32();
            attachmentInformation.entryID = n = iDeserializer.getInt32();
            attachmentInformation.attachmentPath = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return attachmentInformation;
    }

    public static AttachmentInformation[] getOptionalAttachmentInformationVarArray(IDeserializer iDeserializer) {
        AttachmentInformation[] attachmentInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            attachmentInformationArray = new AttachmentInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                attachmentInformationArray[i2] = AttachmentInformationSerializer.getOptionalAttachmentInformation(iDeserializer);
            }
        }
        return attachmentInformationArray;
    }
}

