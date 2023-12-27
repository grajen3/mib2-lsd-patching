/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.addressbook;

import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.NavBookSpellerResult;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.PhoneBookSpellerResult;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import java.util.Iterator;

public interface AddressbookService {
    default public void addAddressbookServiceListener(AddressbookServiceListener addressbookServiceListener, int[] nArray) {
    }

    default public void removeAddressbookServiceListener(AddressbookServiceListener addressbookServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public Iterator getAddressBook() {
    }

    default public int getNumberOfElementsInNavBook() {
    }

    default public Iterator getNavBook() {
    }

    default public Iterator getWindowedNavBook(int[] nArray) {
    }

    default public Iterator getWindowedCachedNavBook(int[] nArray) {
    }

    default public int getNavBookNumberOfEntries() {
    }

    default public NavBookSpellerResult getNavBookSpellerResult() {
    }

    default public int getNumberOfElementsInPhoneBook() {
    }

    default public Iterator getPhoneBookContacts() {
    }

    default public Iterator getWindowedPhoneBookContacts(int[] nArray) {
    }

    default public Iterator getWindowedCachedPhoneBookContacts(int[] nArray) {
    }

    default public Iterator getPhoneBookContactDetails() {
    }

    default public int getPhoneBookNumberOEntries() {
    }

    default public PhoneBookSpellerResult getPhoneBookSpellerResult() {
    }

    default public void getDetailsForPhoneBookEntry(long l) {
    }

    default public void getAddressBookData(long[] lArray, int n) {
    }

    default public void startPhoneBookSpeller() {
    }

    default public void stopPhoneBookSpeller() {
    }

    default public void matchStringWithPhoneBookSpeller(String string) {
    }

    default public void startNavBookSpeller() {
    }

    default public void stopNavBookSpeller() {
    }

    default public void matchStringWithNavBookSpeller(String string) {
    }
}

