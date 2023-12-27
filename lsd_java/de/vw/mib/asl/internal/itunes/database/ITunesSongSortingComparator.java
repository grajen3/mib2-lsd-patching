/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.database;

import de.vw.mib.asl.internal.itunes.common.ITunesTagInformation;
import java.util.Comparator;

final class ITunesSongSortingComparator
implements Comparator {
    public static final ITunesSongSortingComparator INSTANCE = new ITunesSongSortingComparator();

    private ITunesSongSortingComparator() {
    }

    @Override
    public int compare(Object object, Object object2) {
        ITunesTagInformation iTunesTagInformation = (ITunesTagInformation)object;
        ITunesTagInformation iTunesTagInformation2 = (ITunesTagInformation)object2;
        int n = iTunesTagInformation.getArtist().compareTo(iTunesTagInformation2.getArtist());
        if (n != 0) {
            return n;
        }
        return iTunesTagInformation.getTitle().compareTo(iTunesTagInformation2.getTitle());
    }
}

