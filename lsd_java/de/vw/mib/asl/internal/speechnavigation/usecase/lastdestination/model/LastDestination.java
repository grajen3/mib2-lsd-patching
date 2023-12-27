/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.model;

import de.vw.mib.asl.api.navigation.INavigationListElement;

public class LastDestination {
    public int size;
    public long objectId;
    public String title;

    public LastDestination(INavigationListElement iNavigationListElement) {
        this.size = 0;
        this.objectId = iNavigationListElement.getId();
        this.title = iNavigationListElement.getTitle();
    }

    public LastDestination(int n, String string) {
        this.size = n;
        this.objectId = -1L;
        this.title = string;
    }

    public LastDestination(LastDestination lastDestination) {
        this.size = lastDestination.size;
        this.objectId = lastDestination.objectId;
        this.title = lastDestination.title;
    }
}

