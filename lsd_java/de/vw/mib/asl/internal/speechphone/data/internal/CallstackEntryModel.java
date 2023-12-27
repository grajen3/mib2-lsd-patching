/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.internal;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.callstack.CallstackDateTime;
import de.vw.mib.asl.api.phone.services.callstack.CallstackEntry;
import de.vw.mib.asl.internal.speechphone.data.internal.AbstractNBestModel;
import de.vw.mib.asl.internal.speechphone.utils.CommonUtils;
import org.dsi.ifc.global.ResourceLocator;

public class CallstackEntryModel
extends AbstractNBestModel {
    private CallstackEntry callstackEntry;
    private boolean showContactPicture;

    public CallstackEntryModel(String string, int n) {
        super(string, n);
    }

    public CallstackEntryModel(String string, int n, boolean bl) {
        super(string, n);
        this.showContactPicture = bl;
    }

    public CallstackEntryModel(CallstackEntry callstackEntry) {
        this.callstackEntry = callstackEntry;
        this.name = this.isContactInformationAvailable() ? callstackEntry.getCombinedName() : "";
    }

    public boolean isShowContactPicture() {
        return this.showContactPicture;
    }

    public int getCallstackType() {
        return this.callstackEntry.getCallstackType();
    }

    public CallstackDateTime getDateTime() {
        return this.callstackEntry.getDateTime();
    }

    @Override
    public long getObjectID() {
        return this.callstackEntry.getCallstackId();
    }

    public boolean isKnownNumber() {
        return this.callstackEntry.getPhoneNumber() != null && this.callstackEntry.getPhoneNumber().getNumber() != null && this.callstackEntry.getPhoneNumber().getNumber().length() > 0 && !this.callstackEntry.getPhoneNumber().getNumber().equals("Unknown");
    }

    public boolean isContactInformationAvailable() {
        return CommonUtils.isContactInformationAvailable(this.callstackEntry);
    }

    public ResourceLocator getImage() {
        return this.callstackEntry.getImage();
    }

    public int getEntryType() {
        return this.callstackEntry.getCallstackType();
    }

    public int getCombinedLocType() {
        return CommonUtils.mapLocType(this.callstackEntry.getPhoneNumber());
    }

    public String getNumber() {
        if (this.isKnownNumber()) {
            return this.callstackEntry.getPhoneNumber().getNumber();
        }
        return "";
    }

    public PhoneNumber getPhoneNumber() {
        return this.callstackEntry.getPhoneNumber();
    }

    public int getCountOfNumbers() {
        if (this.isContactInformationAvailable()) {
            return this.callstackEntry.getNumberCount();
        }
        return 0;
    }
}

