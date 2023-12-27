/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.data.internal;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.contact.ContactDetail;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.asl.internal.speechphone.controller.contact.LocTypeIndexHandler;
import de.vw.mib.asl.internal.speechphone.data.internal.AbstractNBestModel;
import de.vw.mib.asl.internal.speechphone.utils.CommonUtils;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;
import de.vw.mib.collections.ObjectArrayList;
import org.dsi.ifc.global.ResourceLocator;

public class ContactNameModel
extends AbstractNBestModel {
    private final SpeechPhoneLogger2 logger;
    private ContactDetail contactDetail;
    private int[] combinedLocTypes;
    private int[] combinedLocTypesHistogram;
    private static final int COUNT_OF_LOCTYPES;
    private static final int FIRST_INDEX;

    public ContactNameModel(ServiceFunctions serviceFunctions, ResultItem resultItem) {
        super(resultItem.getText(), resultItem.getSize());
        this.logger = serviceFunctions.createLogger("ContactNameModel");
        this.combinedLocTypes = null;
        this.combinedLocTypesHistogram = null;
    }

    public ContactNameModel(ServiceFunctions serviceFunctions, ContactDetail contactDetail) {
        this.logger = serviceFunctions.createLogger("ContactNameModel");
        this.contactDetail = contactDetail;
        this.name = contactDetail.getCombinedName();
        this.combinedLocTypes = null;
        this.combinedLocTypesHistogram = null;
    }

    private void mapPhoneNumbersOnDemand() {
        if (this.combinedLocTypes == null) {
            int n = this.getCountOfNumbers();
            this.combinedLocTypes = new int[n];
            this.combinedLocTypesHistogram = new int[7];
            PhoneNumber[] phoneNumberArray = this.contactDetail.getPhoneNumbers();
            for (int i2 = 0; i2 < n; ++i2) {
                this.combinedLocTypes[i2] = CommonUtils.mapLocType(phoneNumberArray[i2]);
                int n2 = this.combinedLocTypes[i2];
                this.combinedLocTypesHistogram[n2] = this.combinedLocTypesHistogram[n2] + 1;
            }
        }
    }

    public boolean hasNoNumber() {
        return this.contactDetail.getPhoneNumbers().length == 0;
    }

    public boolean hasMultipleNumbers() {
        return this.contactDetail.getPhoneNumbers().length > 1;
    }

    public boolean hasOneNumber() {
        return this.contactDetail.getPhoneNumbers().length == 1;
    }

    public int getCountOfNumbers() {
        return this.contactDetail.getPhoneNumbers().length;
    }

    public int getCountOfLocTypes(LocTypeIndexHandler locTypeIndexHandler) {
        return this.getCountOfLocTypes(locTypeIndexHandler.getLoctype());
    }

    public int getCountOfLocTypes(int n) {
        if (n == -1) {
            return -1;
        }
        this.mapPhoneNumbersOnDemand();
        return this.combinedLocTypesHistogram[n];
    }

    public int getIndexMatch(LocTypeIndexHandler locTypeIndexHandler) {
        int n = locTypeIndexHandler.getIndex();
        if (n == -1) {
            return -1;
        }
        this.mapPhoneNumbersOnDemand();
        if (n > this.combinedLocTypesHistogram[locTypeIndexHandler.getLoctype()]) {
            return 0;
        }
        return 1;
    }

    public String getFirstPhoneNumberString() {
        String string;
        if (this.contactDetail.getPhoneNumbers().length > 0 && (string = this.contactDetail.getPhoneNumbers()[0].getNumber()) != null) {
            return string;
        }
        return "";
    }

    public PhoneNumber getPhoneNumber(int n) {
        if (this.contactDetail.getPhoneNumbers().length > 0) {
            return this.contactDetail.getPhoneNumbers()[n];
        }
        return null;
    }

    public PhoneNumber getPhoneNumber(LocTypeIndexHandler locTypeIndexHandler) {
        return this.getPhoneNumber(locTypeIndexHandler.getLoctype(), locTypeIndexHandler.getIndex());
    }

    public PhoneNumber getFirstFoundPhoneNumber(LocTypeIndexHandler locTypeIndexHandler) {
        return this.getPhoneNumber(locTypeIndexHandler.getLoctype(), 1);
    }

    private PhoneNumber getPhoneNumber(int n, int n2) {
        if (this.contactDetail.getPhoneNumbers().length > 0 && n2 <= this.combinedLocTypesHistogram[n]) {
            int n3 = 0;
            for (int i2 = 0; i2 < this.contactDetail.getPhoneNumbers().length; ++i2) {
                if (this.combinedLocTypes[i2] != n || n2 != ++n3) continue;
                return this.contactDetail.getPhoneNumbers()[i2];
            }
        }
        return null;
    }

    public int getFirstCombinedLocType() {
        if (this.contactDetail.getPhoneNumbers().length > 0) {
            return CommonUtils.mapLocType(this.contactDetail.getPhoneNumbers()[0]);
        }
        return 0;
    }

    public int getCombinedLocType(int n) {
        if (this.contactDetail.getPhoneNumbers().length > 0) {
            this.mapPhoneNumbersOnDemand();
            return this.combinedLocTypes[n];
        }
        return 0;
    }

    public ObjectArrayList getSortedNumberList(int n) {
        int n2;
        int[] nArray = new int[]{1, 2, 3, 4, 5, 6, 0};
        if (n > 0) {
            for (n2 = 0; n2 < nArray.length && nArray[n2] != n; ++n2) {
            }
            for (int i2 = n2; i2 > 0; --i2) {
                nArray[i2] = nArray[i2 - 1];
            }
            nArray[0] = n;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Number sort order: ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[0]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[1]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[2]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[3]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[4]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[5]]).append(", ").append(LocTypeIndexHandler.LOCTYPESTRING[nArray[6]]).toString());
        }
        n2 = this.contactDetail.getPhoneNumbers().length;
        PhoneNumber[] phoneNumberArray = this.contactDetail.getPhoneNumbers();
        ObjectArrayList objectArrayList = new ObjectArrayList(n2);
        for (int i3 = 0; i3 < nArray.length; ++i3) {
            for (int i4 = 0; i4 < n2; ++i4) {
                if (this.combinedLocTypes[i4] != nArray[i3]) continue;
                objectArrayList.add(phoneNumberArray[i4]);
            }
        }
        return objectArrayList;
    }

    public ResourceLocator getImage() {
        return this.contactDetail.getImage();
    }

    @Override
    public long getObjectID() {
        return this.contactDetail.getContactId();
    }
}

