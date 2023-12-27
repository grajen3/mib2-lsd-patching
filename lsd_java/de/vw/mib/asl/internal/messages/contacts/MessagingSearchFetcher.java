/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.contacts;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.contacts.TargetASLMessagingContactsHandling;
import de.vw.mib.asl.internal.messages.contacts.transformer.MessagesContactsMessageContactsCollector;
import generated.de.vw.mib.asl.internal.ListManager;

public class MessagingSearchFetcher
implements ASLListElementFetcher {
    public static final int HANDLE_NOT_INITIALIZED;
    public static final int HANDLE_WAIT_FOR_RESPONSE_AFTER_START;
    public static final int HANDLE_HWR_RESULT;
    public static final int HANDLE_WAIT_FOR_RESPONSE_AFTER_STOP;
    public static int spellerHandle;
    public static int spelleredListSize;
    private final TargetASLMessagingContactsHandling fetcherTarget;

    public MessagingSearchFetcher(TargetASLMessagingContactsHandling targetASLMessagingContactsHandling) {
        this.fetcherTarget = targetASLMessagingContactsHandling;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (n == 0) {
            switch (spellerHandle) {
                case -2: 
                case -1: {
                    this.fetcherTarget.dsiAdbList.getViewWindow(0L, 4, 1, n2);
                    break;
                }
                case -3: {
                    Object[] objectArray = new MessagesContactsMessageContactsCollector[]{new MessagesContactsMessageContactsCollector(ASLMessagingData.hwrResult, false)};
                    ListManager.getGenericASLList(469).updateListItems(0, objectArray);
                    break;
                }
                default: {
                    this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, 0L, 4, 1, n2);
                    break;
                }
            }
        } else {
            switch (spellerHandle) {
                case -2: 
                case -1: {
                    this.fetcherTarget.dsiAdbList.getViewWindow(n, 6, 1, n2);
                    break;
                }
                case -3: {
                    Object[] objectArray = new MessagesContactsMessageContactsCollector[]{new MessagesContactsMessageContactsCollector(ASLMessagingData.hwrResult, false)};
                    ListManager.getGenericASLList(469).updateListItems(0, objectArray);
                    break;
                }
                default: {
                    this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, n, 6, 1, n2);
                }
            }
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (spellerHandle) {
            case -2: 
            case -1: {
                this.fetcherTarget.dsiAdbList.getViewWindow(messagesContactsMessageContactsCollector.dataSet.entryId, 1, 1, n2);
                break;
            }
            case -3: {
                Object[] objectArray = new MessagesContactsMessageContactsCollector[]{new MessagesContactsMessageContactsCollector(ASLMessagingData.hwrResult, false)};
                ListManager.getGenericASLList(469).updateListItems(0, objectArray);
                break;
            }
            default: {
                this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, messagesContactsMessageContactsCollector.dataSet.entryId, 1, 1, n2);
            }
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        MessagesContactsMessageContactsCollector messagesContactsMessageContactsCollector = (MessagesContactsMessageContactsCollector)object;
        switch (spellerHandle) {
            case -2: 
            case -1: {
                this.fetcherTarget.dsiAdbList.getViewWindow(messagesContactsMessageContactsCollector.dataSet.entryId, 2, 1, n2);
                break;
            }
            case -3: {
                Object[] objectArray = new MessagesContactsMessageContactsCollector[]{new MessagesContactsMessageContactsCollector(ASLMessagingData.hwrResult, false)};
                ListManager.getGenericASLList(469).updateListItems(0, objectArray);
                break;
            }
            default: {
                this.fetcherTarget.dsiAdbList.getSpellerViewWindow(spellerHandle, messagesContactsMessageContactsCollector.dataSet.entryId, 2, 1, n2);
            }
        }
    }

    static {
        spellerHandle = -1;
        spelleredListSize = 0;
    }
}

