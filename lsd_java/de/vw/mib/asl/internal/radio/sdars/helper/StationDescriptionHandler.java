/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sat.transformer.SimilarContentCollector;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.filterlist.SatFilterListApi;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.helper.StationDescriptionHandler$1;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.TreeSet;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;

public final class StationDescriptionHandler
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private final IntObjectMap mDescMap;
    private final int mPoolEntrySimContentBelongsTo;
    private SimilarContentCollector[] mNotifiedSimilarChannelList = null;
    private StationInfo mNotifiedChannel = null;

    public StationDescriptionHandler(SatDb satDb) {
        this.mPoolEntrySimContentBelongsTo = 23;
        this.mDb = satDb;
        this.mDescMap = new IntObjectOptHashMap(999);
        this.mPool = this.mDb.getPool();
        this.mPool.addListener(15, (IAslPoolListener)this);
        this.mPool.addListener(23, (IAslPoolListener)this);
        this.mPool.addListener(85, (IAslPoolListener)this);
        this.mPool.addListener(61, (IAslPoolListener)this);
        this.mPool.addListener(175, (IAslPoolListener)this);
        this.mPool.addListener(37, (IAslPoolListener)this);
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        if (stationDescriptionArray != null) {
            int n = -1;
            StationInfo stationInfo = this.mPool.getChannel(23);
            if (stationInfo != null) {
                n = stationInfo.getSID();
            }
            for (int i2 = 0; i2 < stationDescriptionArray.length; ++i2) {
                StationDescription stationDescription = stationDescriptionArray[i2];
                if (stationDescription == null) continue;
                int n2 = stationDescription.getSID();
                this.mDescMap.put(n2, stationDescription);
                if (n != n2) continue;
                this.mPool.setString(25, stationDescription.getShortStationDescription());
                this.mPool.setString(26, stationDescription.getLongStationDescription());
                this.updateSimilarChannelListToHmi(stationInfo);
                this.mDb.getHmiUpdater().prepareBapList();
            }
        }
    }

    public StationDescription getDescriptionBySID(int n) {
        return (StationDescription)this.mDescMap.get(n);
    }

    public void updateSimilarChannelListToHmi(StationInfo stationInfo) {
        StationDescription stationDescription;
        this.mNotifiedSimilarChannelList = null;
        boolean bl = this.mPool.getBoolean(61);
        if (!bl && stationInfo != null && (stationDescription = this.getDescriptionBySID(stationInfo.getSID())) != null && stationDescription.relatedStationArray != null) {
            TreeSet treeSet = new TreeSet(new StationDescriptionHandler$1(this));
            for (int i2 = 0; i2 < stationDescription.relatedStationArray.length; ++i2) {
                Object object;
                boolean bl2;
                boolean bl3;
                StationInfo stationInfo2 = this.mDb.getChannels().getChannelBySID(stationDescription.relatedStationArray[i2]);
                if (stationInfo2 == null || (bl3 = this.mPool.getBoolean(175)) && !(bl2 = ((SatFilterListApi)(object = this.mDb.getFilterListApi())).isChannelSelected(stationInfo2.getStationNumber()))) continue;
                object = this.mDb.getRadioTextHandler().get(stationInfo2.getSID());
                SimilarContentCollector similarContentCollector = new SimilarContentCollector(this.mDb, stationInfo2, (RadioText)object);
                treeSet.add(similarContentCollector);
            }
            this.mNotifiedSimilarChannelList = new SimilarContentCollector[treeSet.size()];
            this.mNotifiedSimilarChannelList = (SimilarContentCollector[])treeSet.toArray(this.mNotifiedSimilarChannelList);
            this.mNotifiedChannel = stationInfo;
        }
        if (this.mNotifiedSimilarChannelList == null) {
            this.mNotifiedSimilarChannelList = new SimilarContentCollector[0];
        }
        this.mPool.setObjectArray(181, this.mNotifiedSimilarChannelList);
        this.mPool.setBoolean(179, this.mNotifiedSimilarChannelList.length > 0);
    }

    public void selectIndex(int n) {
        SimilarContentCollector[] similarContentCollectorArray = (SimilarContentCollector[])this.mPool.getObjectArray(181);
        if (similarContentCollectorArray == null || n < 0 || n >= similarContentCollectorArray.length) {
            return;
        }
        StationInfo stationInfo = similarContentCollectorArray[n].mChannel;
        if (stationInfo != null) {
            this.mDb.getTuneHandler().tuneChannel(8, stationInfo, false);
        }
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        block0 : switch (n) {
            case 15: {
                String string = "";
                String string2 = "";
                StationInfo stationInfo = iAslPoolRecord.getChannel();
                if (stationInfo != null) {
                    int n2 = stationInfo.getSID();
                    if (n2 == 0) {
                        string2 = this.mPool.getString(47);
                    } else {
                        StationDescription stationDescription = this.getDescriptionBySID(n2);
                        if (stationDescription != null) {
                            string = stationDescription.getLongStationDescription();
                            string2 = stationDescription.getShortStationDescription();
                        }
                    }
                }
                this.mPool.setString(25, string2);
                this.mPool.setString(26, string);
                break;
            }
            case 23: {
                this.updateSimilarChannelListToHmi(iAslPoolRecord.getChannel());
                break;
            }
            case 85: {
                RadioText radioText = iAslPoolRecord.getRadioText();
                if (radioText == null) break;
                short s = radioText.getSID();
                if (this.mNotifiedSimilarChannelList == null || this.mNotifiedChannel == null) break;
                for (int i2 = 0; i2 < this.mNotifiedSimilarChannelList.length; ++i2) {
                    if (this.mNotifiedSimilarChannelList[i2] == null || this.mNotifiedSimilarChannelList[i2].mChannel == null || this.mNotifiedSimilarChannelList[i2].mChannel.stationNumber != s) continue;
                    this.updateSimilarChannelListToHmi(this.mNotifiedChannel);
                    break block0;
                }
                break;
            }
            case 37: 
            case 61: 
            case 175: {
                StationInfo stationInfo = this.mPool.getChannel(23);
                this.updateSimilarChannelListToHmi(stationInfo);
                break;
            }
        }
    }
}

