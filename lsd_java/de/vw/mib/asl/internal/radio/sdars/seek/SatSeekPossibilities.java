/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolListener;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPoolRecord;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;

final class SatSeekPossibilities
implements IAslPoolListener {
    private final SatDb mDb;
    private final IAslPool mPool;
    private SeekPossibility mSeekPossibility;

    SatSeekPossibilities(SatDb satDb) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mSeekPossibility = new SeekPossibility();
        this.mPool.addListener(61, (IAslPoolListener)this);
    }

    String getPossible(int n, int n2) {
        if (this.mSeekPossibility != null && this.mSeekPossibility.seekInformation != null) {
            if (this.mSeekPossibility.getTypeOfContent() == 3) {
                if (n == 6) {
                    String string = "";
                    String string2 = "";
                    for (int i2 = 0; i2 < this.mSeekPossibility.seekInformation.length; ++i2) {
                        if (this.mSeekPossibility.seekInformation[i2].seekInfo == 6) {
                            string = this.mSeekPossibility.seekInformation[i2].seekText;
                        }
                        if (this.mSeekPossibility.seekInformation[i2].seekInfo != 10) continue;
                        string2 = this.mSeekPossibility.seekInformation[i2].seekText;
                    }
                    return new StringBuffer().append(string).append(" ").append(string2).toString();
                }
                if (n == 8) {
                    String string = "";
                    String string3 = "";
                    for (int i3 = 0; i3 < this.mSeekPossibility.seekInformation.length; ++i3) {
                        if (this.mSeekPossibility.seekInformation[i3].seekInfo == 8) {
                            string = this.mSeekPossibility.seekInformation[i3].seekText;
                        }
                        if (this.mSeekPossibility.seekInformation[i3].seekInfo != 13) continue;
                        string3 = this.mSeekPossibility.seekInformation[i3].seekText;
                    }
                    return new StringBuffer().append(string).append(" ").append(string3).toString();
                }
            } else {
                for (int i4 = 0; i4 < this.mSeekPossibility.seekInformation.length; ++i4) {
                    int n3 = this.mSeekPossibility.seekInformation[i4].seekInfo;
                    if (n3 != n && n3 != n2) continue;
                    return this.mSeekPossibility.seekInformation[i4].getSeekText();
                }
            }
        }
        return "";
    }

    void updateSeekPossibility(SeekPossibility seekPossibility) {
        this.mDb.getLogHandler().logSeekPossibilities(seekPossibility);
        boolean bl = this.mPool.getBoolean(61);
        this.mSeekPossibility = seekPossibility;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        String string = null;
        String string2 = null;
        boolean bl7 = false;
        boolean bl8 = false;
        boolean bl9 = false;
        if (this.mSeekPossibility != null && !bl) {
            SeekInformation[] seekInformationArray = seekPossibility.getSeekInformation();
            SeekState[] seekStateArray = seekPossibility.getSeekState();
            switch (seekPossibility.getTypeOfContent()) {
                case 1: {
                    if (seekInformationArray == null || null == seekStateArray) break;
                    block13: for (int i2 = 0; i2 < seekStateArray.length; ++i2) {
                        if (seekStateArray[i2] == null) continue;
                        switch (seekStateArray[i2].getSeekType()) {
                            case 2: {
                                if (seekStateArray[i2].state != 1) {
                                    bl2 = true;
                                    continue block13;
                                }
                                bl7 = true;
                                continue block13;
                            }
                            case 1: {
                                if (seekStateArray[i2].state != 1) {
                                    bl3 = true;
                                    continue block13;
                                }
                                bl8 = true;
                                continue block13;
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    bl4 = true;
                    if (seekStateArray == null) break;
                    block14: for (int i3 = 0; i3 < seekStateArray.length; ++i3) {
                        if (seekInformationArray[i3] == null || null == seekStateArray[i3]) continue;
                        switch (seekStateArray[i3].getSeekType()) {
                            case 4: {
                                int n;
                                bl4 = true;
                                if (seekStateArray[i3].state != 1) {
                                    bl5 = true;
                                }
                                for (n = 0; n < seekInformationArray.length; ++n) {
                                    if (seekInformationArray[n].getSeekInfo() != 11) continue;
                                    string = seekInformationArray[n].seekText;
                                }
                                continue block14;
                            }
                            case 5: {
                                int n;
                                bl4 = true;
                                if (seekStateArray[i3].state != 1) {
                                    bl6 = true;
                                }
                                for (n = 0; n < seekInformationArray.length; ++n) {
                                    if (seekInformationArray[n].getSeekInfo() != 14) continue;
                                    string2 = seekInformationArray[n].seekText;
                                }
                                continue block14;
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    break;
                }
            }
        }
        this.mPool.setBoolean(145, bl2);
        this.mPool.setBoolean(144, bl3);
        this.mPool.setBoolean(143, bl4);
        this.mPool.setBoolean(141, bl5);
        this.mPool.setBoolean(142, bl6);
        this.mPool.setBoolean(197, bl7);
        this.mPool.setBoolean(199, bl9);
        this.mPool.setBoolean(198, bl8);
        if (null != string) {
            this.mPool.setString(188, string);
        } else {
            this.mPool.setString(188, null);
        }
        if (null != string2) {
            this.mPool.setString(189, string2);
        } else {
            this.mPool.setString(189, null);
        }
        this.mDb.getRadioTextHandler().updatePDT();
    }

    @Override
    public void notifyUpdate(IAslPool iAslPool, int n, IAslPoolRecord iAslPoolRecord) {
        switch (n) {
            case 61: {
                this.updateSeekPossibility(this.mSeekPossibility);
                break;
            }
        }
    }
}

