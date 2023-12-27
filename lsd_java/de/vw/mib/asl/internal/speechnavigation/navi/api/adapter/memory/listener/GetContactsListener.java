/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener;

import de.vw.mib.asl.api.navigation.memory.INavigationContact;

public interface GetContactsListener {
    default public void getContactsResponse(int n, INavigationContact[] iNavigationContactArray) {
    }
}

