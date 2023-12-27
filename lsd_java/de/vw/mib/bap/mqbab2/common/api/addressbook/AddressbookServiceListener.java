/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook;

import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;

public interface AddressbookServiceListener
extends HMIEventListener {
    public static final int ADDRESSBOOK_SERVICE__NAV_BOOK_ENTRY_COUNT;
    public static final int ADDRESSBOOK_SERVICE__PHONE_BOOK_ENTRY_COUNT;
    public static final int ADDRESSBOOK_SERVICE__NAV_BOOK_SPELLER_RESULT;
    public static final int ADDRESSBOOK_SERVICE__PHONE_BOOK_SPELLER_RESULT;
    public static final int ADDRESSBOOK_SERVICE__ADDRESSBOOK;
    public static final int ADDRESSBOOK_SERVICE__NAV_BOOK;
    public static final int ADDRESSBOOK_SERVICE__PHONE_BOOK;
    public static final int ADDRESSBOOK_SERVICE__PHONE_BOOK_CONTACT_DETAILS;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__PHONE_BOOK_SPELLER_FAILURE;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__PHONE_BOOK_SPELLER_RESULT_ACKNOWLEDGE;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__PHONE_BOOK_SPELLER_STOP_ACKNOWLEDGE;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__CONTACT_DETAIL_INFORMATION_RETURNED;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__ADDRESSLIST_DATA_FILLED;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__NAV_BOOK_SPELLER_FAILURE;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__NAV_BOOK_SPELLER_RESULT_ACKNOWLEDGE;
    public static final int ADDRESSBOOK_SERVICE__HMI_EVENT__NAV_BOOK_SPELLER_STOP_ACKNOWLEDGE;

    default public void updateAddressbookData(AddressbookService addressbookService, int n) {
    }
}

