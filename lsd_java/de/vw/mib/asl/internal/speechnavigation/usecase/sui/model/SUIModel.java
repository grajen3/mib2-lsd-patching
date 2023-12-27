/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.model;

import de.vw.mib.asl.internal.speechnavigation.usecase.contacts.model.Contact;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.model.OnboardPOICategory;

public class SUIModel {
    public static final int ONESHOT;
    public static final int POI;
    public static final int CONTACT;
    private final int itemType;
    private final int itemIndex;
    private final int groupSize;
    private final String itemTitle;
    private OneShotModel address = new OneShotModel();
    private Contact contact = new Contact();
    private OnboardPOICategory poiCategory = new OnboardPOICategory();

    private SUIModel(int n, int n2, String string) {
        this.itemIndex = n;
        this.itemType = n2;
        this.itemTitle = string;
        this.groupSize = 0;
    }

    private SUIModel(int n, int n2, int n3, String string) {
        this.itemIndex = n;
        this.itemType = n2;
        this.itemTitle = string;
        this.groupSize = n3;
    }

    public SUIModel(int n, OnboardPOICategory onboardPOICategory) {
        this(n, 1, onboardPOICategory.title);
        this.poiCategory = onboardPOICategory;
    }

    public SUIModel(int n, int n2, OnboardPOICategory onboardPOICategory) {
        this(n, 1, n2, onboardPOICategory.title);
        this.poiCategory = onboardPOICategory;
    }

    public SUIModel(int n, Contact contact) {
        this(n, 2, contact.contactName);
        this.contact = contact;
    }

    public SUIModel(int n, int n2, Contact contact) {
        this(n, 2, n2, contact.contactName);
        this.contact = contact;
    }

    public SUIModel(int n, OneShotModel oneShotModel) {
        this(n, 0, oneShotModel.getTitle());
        this.address = oneShotModel;
    }

    public SUIModel(int n, int n2, OneShotModel oneShotModel) {
        this(n, 0, n2, oneShotModel.getTitle());
        this.address = oneShotModel;
    }

    public SUIModel(int n, String string) {
        this.itemIndex = -1;
        this.groupSize = n;
        this.itemTitle = string;
        this.itemType = -1;
    }

    public int getItemIndex() {
        return this.itemIndex;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }

    public int getItemType() {
        return this.itemType;
    }

    public int getGroupSize() {
        return this.groupSize;
    }

    public boolean isPOICategory() {
        return this.itemType == 1;
    }

    public boolean isContact() {
        return this.itemType == 2;
    }

    public boolean isAddress() {
        return this.itemType == 0;
    }

    public Contact getContact() {
        return this.contact;
    }

    public OnboardPOICategory getPOICategory() {
        return this.poiCategory;
    }

    public OneShotModel getAddress() {
        return this.address;
    }
}

