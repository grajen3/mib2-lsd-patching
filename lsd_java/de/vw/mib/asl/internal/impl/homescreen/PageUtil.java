/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.homescreen.HomeScreenPages$Page;
import de.vw.mib.asl.internal.impl.homescreen.util.Preconditions;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;

public class PageUtil {
    private static final int PAGE2;
    private static final int PAGE1;

    private PageUtil() {
    }

    public static int getPropertyValue(HomeScreenPages$Page homeScreenPages$Page) {
        Preconditions.checkArgumentNotNull(homeScreenPages$Page, "Argument >page< must not be null!");
        if (homeScreenPages$Page == HomeScreenPages$Page.LEFT) {
            return 0;
        }
        if (homeScreenPages$Page == HomeScreenPages$Page.RIGHT) {
            return 1;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unsupported >page<! Got:").append(homeScreenPages$Page).toString());
    }

    public static HomeScreenPages$Page getPage(EventGeneric eventGeneric) {
        int n;
        Preconditions.checkArgumentNotNull(eventGeneric, "Argument >event< must not be null!");
        Preconditions.checkArgument(eventGeneric.getReceiverEventId() == -1547417024, new StringBuffer().append("The receiver-id of the given >event< must be ASLHomeScreenSetter.DISPLAY_PAGE ! Got: ").append(eventGeneric).toString());
        try {
            n = eventGeneric.getInt(0);
        }
        catch (GenericEventException genericEventException) {
            throw new RuntimeException(genericEventException);
        }
        switch (n) {
            case 0: {
                return HomeScreenPages$Page.LEFT;
            }
            case 1: {
                return HomeScreenPages$Page.RIGHT;
            }
            case 2: {
                return HomeScreenPages$Page.NON;
            }
        }
        throw new RuntimeException(new StringBuffer().append("Unable to extract the page-index, cause the page-index is not supported! Got page-index >").append(n).append("<").toString());
    }
}

