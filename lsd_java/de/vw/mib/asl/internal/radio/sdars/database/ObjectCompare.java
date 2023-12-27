/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.database;

import de.vw.mib.asl.internal.radio.sdars.helper.ImageDb;
import de.vw.mib.collections.HashCodeBuilder;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.RadioSATCurrentChannelInfoCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationInfo;

public final class ObjectCompare {
    public static long calcHash(ImageDb imageDb, StationInfo stationInfo) {
        if (stationInfo == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        ObjectCompare.calcHash(imageDb, hashCodeBuilder, stationInfo);
        return hashCodeBuilder.longHashCode();
    }

    public static void calcHash(ImageDb imageDb, HashCodeBuilder hashCodeBuilder, StationInfo stationInfo) {
        if (stationInfo != null) {
            hashCodeBuilder.append(stationInfo.getCategoryNumber());
            hashCodeBuilder.append(stationInfo.getFullLabel());
            hashCodeBuilder.append(stationInfo.getShortLabel());
            hashCodeBuilder.append(stationInfo.getSID());
            hashCodeBuilder.append(stationInfo.getStationNumber());
            hashCodeBuilder.append(stationInfo.getSubscription());
            if (imageDb != null) {
                ObjectCompare.calcHash(hashCodeBuilder, imageDb.getImage(stationInfo.sID));
            } else {
                ObjectCompare.calcHash(hashCodeBuilder, (ResourceLocator)null);
            }
        }
    }

    public static long calcHash(ImageDb imageDb, StationInfo[] stationInfoArray) {
        if (stationInfoArray == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
            ObjectCompare.calcHash(imageDb, hashCodeBuilder, stationInfoArray[i2]);
        }
        return hashCodeBuilder.longHashCode();
    }

    public static long calcHash(CategoryInfo categoryInfo) {
        if (categoryInfo == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        ObjectCompare.calcHash(hashCodeBuilder, categoryInfo);
        return hashCodeBuilder.longHashCode();
    }

    public static void calcHash(HashCodeBuilder hashCodeBuilder, CategoryInfo categoryInfo) {
        if (categoryInfo != null) {
            hashCodeBuilder.append(categoryInfo.getCategoryNumber());
            hashCodeBuilder.append(categoryInfo.getFullLabel());
            hashCodeBuilder.append(categoryInfo.getShortLabel());
        }
    }

    public static long calcHash(RadioText radioText) {
        if (radioText == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        ObjectCompare.calcHash(hashCodeBuilder, radioText);
        return hashCodeBuilder.longHashCode();
    }

    public static void calcHash(HashCodeBuilder hashCodeBuilder, RadioText radioText) {
        if (radioText != null) {
            hashCodeBuilder.append(radioText.getArtistID());
            hashCodeBuilder.append(radioText.getComposer());
            hashCodeBuilder.append(radioText.getITunesID());
            hashCodeBuilder.append(radioText.getLongArtistName());
            hashCodeBuilder.append(radioText.getLongProgramTitle());
            hashCodeBuilder.append(radioText.getProgramID());
            hashCodeBuilder.append(radioText.getShortArtistName());
            hashCodeBuilder.append(radioText.getShortProgramTitle());
            hashCodeBuilder.append(radioText.getSID());
        }
    }

    public static void calcHash(HashCodeBuilder hashCodeBuilder, ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            hashCodeBuilder.append(resourceLocator.getId());
            hashCodeBuilder.append(resourceLocator.getUrl());
        }
    }

    public static long calcHash(ResourceLocator resourceLocator) {
        if (resourceLocator == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        ObjectCompare.calcHash(hashCodeBuilder, resourceLocator);
        return hashCodeBuilder.longHashCode();
    }

    public static long calcHash(RadioSATCurrentChannelInfoCollector[] radioSATCurrentChannelInfoCollectorArray) {
        if (radioSATCurrentChannelInfoCollectorArray == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        for (int i2 = 0; i2 < radioSATCurrentChannelInfoCollectorArray.length; ++i2) {
            if (radioSATCurrentChannelInfoCollectorArray[i2] == null) continue;
            hashCodeBuilder.append(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__channel000information);
            hashCodeBuilder.append(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__name);
            hashCodeBuilder.append(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__number);
            hashCodeBuilder.append(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__short_name);
            hashCodeBuilder.append(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__status);
            long l = ObjectCompare.calcHash(radioSATCurrentChannelInfoCollectorArray[i2].radio_sat_current_channel_info__logo);
            hashCodeBuilder.append(l);
        }
        return hashCodeBuilder.longHashCode();
    }

    public static long calcHash(CategoryInfo[] categoryInfoArray) {
        if (categoryInfoArray == null) {
            return 0L;
        }
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        for (int i2 = 0; i2 < categoryInfoArray.length; ++i2) {
            if (categoryInfoArray[i2] == null) continue;
            hashCodeBuilder.append(categoryInfoArray[i2].getCategoryNumber());
            hashCodeBuilder.append(categoryInfoArray[i2].getFullLabel());
            hashCodeBuilder.append(categoryInfoArray[i2].getShortLabel());
        }
        return hashCodeBuilder.longHashCode();
    }

    public static int calcHash(String string) {
        return string == null ? 0 : string.hashCode();
    }
}

