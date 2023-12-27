/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sdars.helper.AbstractChannelWalker;
import de.vw.mib.asl.internal.radio.sdars.helper.ChannelFilter;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import java.util.List;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;

public final class ChannelWalker
extends AbstractChannelWalker {
    private static final int NEXT_CATEGORY_STEPWIDTH;

    public ChannelWalker(SatDb satDb, String string, boolean bl) {
        super(satDb, string, bl);
    }

    public ChannelWalker(SatDb satDb, String string, ChannelFilter[] channelFilterArray, boolean bl) {
        super(satDb, string, channelFilterArray, bl);
    }

    private int calculateStartIndex(int n, boolean bl) {
        int n2;
        ChannelWalker channelWalker = new ChannelWalker(this.mDb, "temp", false);
        channelWalker.setSorting(this.mComparator);
        channelWalker.fill();
        int n3 = channelWalker.size();
        if (n3 > 0 && (n2 = channelWalker.getIndexByNumber(n)) >= 0) {
            int n4 = n2;
            do {
                StationInfo stationInfo;
                short s;
                int n5;
                if (!bl) {
                    if (++n4 >= n3) {
                        n4 = 0;
                    }
                } else if (--n4 < 0) {
                    n4 = n3 - 1;
                }
                if (n4 == n2 || (n5 = this.getIndexByNumber(s = (stationInfo = channelWalker.getChannelByIndex(n4)).getStationNumber())) < 0) continue;
                return n5;
            } while (n4 != n2);
        }
        return -1;
    }

    @Override
    public StationInfo step(int n) {
        int n2;
        int n3 = this.isBrowsing() ? this.getChannelNumber() : this.getLastNonZeroChannelNumber();
        int n4 = this.getIndexByNumber(n3);
        if (n4 < 0) {
            n4 = this.calculateStartIndex(n3, n > 0);
        }
        int n5 = this.mPool.getInt(150);
        if (this.mDb.isScanStartedWithFilteredChannel() && n5 == 0 && (n2 = SatDb.getInstance().getFilterListApi().isChannelSelected((short)n3)) == 0) {
            n4 = this.mArray.length;
        }
        if (this.mArray.length == 1 && n4 <= 0) {
            return this.mArray[0];
        }
        if (this.mArray.length > 0 && n != 0 && (this.mArray.length != 1 || n4 != 0)) {
            n2 = n4;
            int n6 = Math.abs(n);
            do {
                int n7;
                if (n > 0) {
                    for (n7 = 0; n7 < n6; ++n7) {
                        if (++n4 < this.mArray.length) continue;
                        n4 = 0;
                    }
                }
                if (n < 0) {
                    for (n7 = 0; n7 < n6; ++n7) {
                        if (--n4 >= 0) continue;
                        n4 = this.mArray.length - 1;
                    }
                }
                if (n4 == n2) continue;
                StationInfo stationInfo = this.getChannelByIndex(n4);
                if (!this.mDb.getChannels().check(stationInfo, this.getFilter())) continue;
                return stationInfo;
            } while (n4 != n2);
        }
        return null;
    }

    public StationInfo stepFirstChar(boolean bl) {
        int n = this.getIndexByNumber(this.getChannelNumber());
        if (n < 0) {
            n = this.calculateStartIndex(this.getChannelNumber(), bl);
        }
        if (this.mArray.length > 0 && (this.mArray.length != 1 || n != 0)) {
            int n2 = n;
            StationInfo stationInfo = this.getChannelByIndex(n);
            char c2 = '\u0000';
            if (null != stationInfo) {
                c2 = stationInfo.getFullLabel().charAt(0);
            }
            do {
                StationInfo stationInfo2;
                if (bl) {
                    if (++n >= this.mArray.length) {
                        n = 0;
                    }
                } else if (--n < 0) {
                    n = this.mArray.length - 1;
                }
                if ((stationInfo2 = this.getChannelByIndex(n)) == null) {
                    return null;
                }
                if (n == n2) {
                    return null;
                }
                char c3 = stationInfo2.getFullLabel().charAt(0);
                if (Character.toLowerCase(c2) == Character.toLowerCase(c3) || !this.mDb.getChannels().check(stationInfo2, this.getFilter())) continue;
                return stationInfo2;
            } while (n != n2);
        }
        return null;
    }

    public StationInfo stepCategory(boolean bl) {
        int n = this.getIndexByNumber(this.getChannelNumber());
        if (n < 0) {
            n = this.calculateStartIndex(this.getChannelNumber(), bl);
        }
        if (this.mArray.length > 0 && (this.mArray.length != 1 || n != 0)) {
            int n2 = n;
            StationInfo stationInfo = this.getChannelByIndex(n);
            short s = stationInfo.getCategoryNumber();
            do {
                StationInfo stationInfo2;
                if (bl) {
                    if (++n >= this.mArray.length) {
                        n = 0;
                    }
                } else if (--n < 0) {
                    n = this.mArray.length - 1;
                }
                if ((stationInfo2 = this.getChannelByIndex(n)) == null) {
                    return null;
                }
                if (n == n2) {
                    return null;
                }
                short s2 = stationInfo2.getCategoryNumber();
                if (s == s2 || !this.mDb.getChannels().check(stationInfo2, this.getFilter())) continue;
                return stationInfo2;
            } while (n != n2);
        }
        return null;
    }

    @Override
    public void addSimilarChannels(List list) {
        StationDescription stationDescription;
        StationInfo stationInfo = this.mPool.getChannel(23);
        if (stationInfo != null && (stationDescription = this.mDb.getStationDescriptionHandler().getDescriptionBySID(stationInfo.getSID())) != null && stationDescription.relatedStationArray != null) {
            for (int i2 = 0; i2 < stationDescription.relatedStationArray.length; ++i2) {
                StationInfo stationInfo2 = this.mDb.getChannels().getChannelBySID(stationDescription.relatedStationArray[i2]);
                if (stationInfo2 == null) continue;
                list.add(stationInfo2);
            }
        }
    }

    @Override
    public StationInfo stepNextCategory(int n) {
        StationInfo stationInfo = null;
        int n2 = this.getIndexByNumber(this.getChannelNumber());
        if (n2 < 0) {
            n2 = this.calculateStartIndex(this.getChannelNumber(), false);
        }
        if (this.mArray.length > 0 && (this.mArray.length != 1 || n2 != 0)) {
            switch (n) {
                case 0: {
                    stationInfo = this.stepCategory(true);
                    break;
                }
                case 1: {
                    stationInfo = this.stepFirstChar(true);
                    break;
                }
                case 2: {
                    stationInfo = this.step(10);
                    break;
                }
            }
        }
        return stationInfo;
    }

    @Override
    public StationInfo stepPreviousCategory(int n) {
        StationInfo stationInfo = null;
        int n2 = this.getIndexByNumber(this.getChannelNumber());
        if (n2 < 0) {
            n2 = this.calculateStartIndex(this.getChannelNumber(), false);
        }
        if (this.mArray.length > 0 && (this.mArray.length != 1 || n2 != 0)) {
            switch (n) {
                case 0: {
                    stationInfo = this.stepCategory(false);
                    break;
                }
                case 1: {
                    stationInfo = this.stepFirstChar(false);
                    break;
                }
                case 2: {
                    stationInfo = this.step(-10);
                    break;
                }
            }
        }
        return stationInfo;
    }
}

