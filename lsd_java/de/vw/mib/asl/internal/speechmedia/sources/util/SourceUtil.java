/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.util;

import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.media.services.sources.medialist.Source;
import de.vw.mib.asl.internal.speechmedia.sources.model.SourceModel;
import java.util.ArrayList;
import java.util.List;

public final class SourceUtil {
    public static final int JUKEBOX;
    public static final int SD;
    public static final int USB;
    public static final int DVD;
    public static final int CD;
    public static final int AUX;
    public static final int WLAN;
    public static final int BT;

    private SourceUtil() {
    }

    public static SourceModel[] fromSourceStates(List list) {
        if (list == null) {
            return new SourceModel[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Source source = (Source)list.get(i2);
            int n = SourceUtil.idFromSourceIdentity(source.getSourceId());
            if (n == -1) continue;
            SourceModel sourceModel = new SourceModel();
            sourceModel.id = n;
            sourceModel.available = source.isUserVisible();
            arrayList.add(sourceModel);
        }
        Object[] objectArray = new SourceModel[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public static int idFromSourceIdentity(SourceId sourceId) {
        int n = sourceId.getSlot();
        int n2 = sourceId.getDeviceType();
        switch (n2) {
            case 0: {
                return 0;
            }
            case 4: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 1: {
                if (n < 0 || n >= 2) {
                    return -1;
                }
                return 3 + n;
            }
            case 2: {
                if (n < 0 || n >= 4) {
                    return -1;
                }
                return 5 + n;
            }
            case 10: {
                return 9;
            }
            case 8: {
                return 10;
            }
            case 9: {
                return 11;
            }
        }
        return -1;
    }

    public static boolean containsSource(List list, int n) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Source source = (Source)list.get(i2);
            if (source.getSourceId().getDeviceType() != n) continue;
            return true;
        }
        return false;
    }

    public static Source getSourceState(List list, int n) {
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Source source = (Source)list.get(i2);
            if (SourceUtil.idFromSourceIdentity(source.getSourceId()) != n) continue;
            return source;
        }
        return null;
    }

    public static boolean isOptical(SourceId sourceId) {
        return sourceId.getDeviceType() == 4 || sourceId.getDeviceType() == 3;
    }
}

