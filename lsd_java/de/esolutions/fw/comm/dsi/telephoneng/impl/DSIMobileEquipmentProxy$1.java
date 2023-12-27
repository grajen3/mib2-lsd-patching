/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;

class DSIMobileEquipmentProxy$1
implements ISerializable {
    private final /* synthetic */ String val$telNumber;
    private final /* synthetic */ long val$telDBEntryId;
    private final /* synthetic */ String val$telDBName;
    private final /* synthetic */ short val$telPhoneType;
    private final /* synthetic */ short val$telEntryType;
    private final /* synthetic */ ResourceLocator val$telDBPicture;
    private final /* synthetic */ int val$telDBPhoneNumberIndex;
    private final /* synthetic */ int val$adbPhoneDataCount;
    private final /* synthetic */ DSIMobileEquipmentProxy this$0;

    DSIMobileEquipmentProxy$1(DSIMobileEquipmentProxy dSIMobileEquipmentProxy, String string, long l, String string2, short s, short s2, ResourceLocator resourceLocator, int n, int n2) {
        this.this$0 = dSIMobileEquipmentProxy;
        this.val$telNumber = string;
        this.val$telDBEntryId = l;
        this.val$telDBName = string2;
        this.val$telPhoneType = s;
        this.val$telEntryType = s2;
        this.val$telDBPicture = resourceLocator;
        this.val$telDBPhoneNumberIndex = n;
        this.val$adbPhoneDataCount = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$telNumber);
        iSerializer.putInt64(this.val$telDBEntryId);
        iSerializer.putOptionalString(this.val$telDBName);
        iSerializer.putInt16(this.val$telPhoneType);
        iSerializer.putInt16(this.val$telEntryType);
        ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, this.val$telDBPicture);
        iSerializer.putInt32(this.val$telDBPhoneNumberIndex);
        iSerializer.putInt32(this.val$adbPhoneDataCount);
    }
}

