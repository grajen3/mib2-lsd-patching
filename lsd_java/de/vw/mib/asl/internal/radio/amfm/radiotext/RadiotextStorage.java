/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.radiotext;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.main.HsmTarget;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextData;
import de.vw.mib.asl.internal.radio.amfm.radiotext.RadiotextTarget;
import org.dsi.ifc.radio.AMFMRadioText;

final class RadiotextStorage {
    private static final char SPACE;
    private static final char LINE_FEED;
    private static final char END_OF_HEADLINE;
    private static final char CARRIAGE_RETURN;
    private static final char WORD_BREAK;
    private static final int NONE;
    private static final int RADIOTEXT;
    private static final int RADIOTEXTPLUS;
    private static final int COMPLETE;
    private final RadiotextTarget mTarget;
    private boolean mTimer;
    private int mCollect;
    private RadiotextData mRadiotextRead;
    private RadiotextData mRadiotextWrite;

    RadiotextStorage(RadiotextTarget radiotextTarget) {
        this.mTarget = radiotextTarget;
        this.mTimer = false;
        this.mCollect = 0;
        this.mRadiotextRead = new RadiotextData();
        this.mRadiotextWrite = new RadiotextData();
    }

    private void startTimer() {
        if (!this.mTimer) {
            this.mTimer = true;
            this.mTarget.startTimer(-1517944576, (long)0, false);
        }
    }

    private void stopTimer() {
        if (this.mTimer) {
            this.mTimer = false;
            this.mTarget.stopTimer(-1517944576);
        }
    }

    private void swap() {
        this.mCollect = 0;
        this.mRadiotextRead = this.mRadiotextWrite;
        this.mRadiotextWrite = new RadiotextData(this.mRadiotextWrite);
        this.mTarget.triggerMe(ServiceManager.mGenericEventFactory.newEvent(), -1501167360);
    }

    void timeout() {
        this.mTimer = false;
        this.swap();
    }

    private void update(int n) {
        this.mCollect |= n;
        if (this.mCollect < 3) {
            this.startTimer();
        } else {
            this.stopTimer();
            this.swap();
        }
    }

    private String cleanUp(String string) {
        char[] cArray;
        int n;
        String string2 = "";
        if (string != null && (n = (cArray = string.toCharArray()).length) > 0) {
            char[] cArray2 = new char[n];
            int n2 = 0;
            int n3 = 0;
            int n4 = cArray[n2++];
            while (n2 < n && n4 == 32) {
                n4 = cArray[n2++];
            }
            block5: while (n2 < n) {
                int n5 = cArray[n2++];
                switch (n5) {
                    case 10: 
                    case 11: 
                    case 32: {
                        if (n4 != 32) {
                            cArray2[n3++] = n4;
                        }
                        n4 = 32;
                        continue block5;
                    }
                    case 13: 
                    case 31: {
                        continue block5;
                    }
                }
                cArray2[n3++] = n4;
                n4 = n5;
            }
            if (n4 != 32) {
                cArray2[n3++] = n4;
            }
            string2 = new String(cArray2, 0, n3);
        }
        return string2;
    }

    void updateRadiotext(AMFMRadioText aMFMRadioText) {
        if (HsmTarget.waitingForStatusRunning) {
            return;
        }
        String string = "";
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentStation();
        if (!(aMFMRadioText == null || amFmStation == null || RadioCodingAdapter.isPiActivated() && aMFMRadioText.getPi() != amFmStation.getPi())) {
            string = aMFMRadioText.getText();
            string = this.cleanUp(string);
        }
        this.mRadiotextWrite.setText(string);
        this.update(1);
    }

    void updateRadiotextPlus(int[] nArray, String[] stringArray) {
        if (HsmTarget.waitingForStatusRunning) {
            return;
        }
        String string = "";
        String string2 = "";
        if (nArray != null && stringArray != null && nArray.length > 0 && nArray.length == stringArray.length) {
            block4: for (int i2 = 0; i2 < nArray.length; ++i2) {
                switch (nArray[i2]) {
                    case 4: {
                        if (stringArray[i2] == null) continue block4;
                        string = this.cleanUp(stringArray[i2]);
                        continue block4;
                    }
                    case 1: {
                        if (stringArray[i2] == null) continue block4;
                        string2 = this.cleanUp(stringArray[i2]);
                        continue block4;
                    }
                }
            }
        }
        this.mRadiotextWrite.setArtistAndTitle(string, string2);
        this.update(2);
    }

    void clear() {
        this.stopTimer();
        this.mCollect = 0;
        this.mRadiotextRead = new RadiotextData();
        this.mRadiotextWrite = new RadiotextData();
    }

    String getText() {
        return this.mRadiotextRead.getText();
    }

    String getArtist() {
        return this.mRadiotextRead.getArtist();
    }

    String getTitle() {
        return this.mRadiotextRead.getTitle();
    }

    boolean isPlus() {
        return this.mRadiotextRead.isPlus();
    }

    boolean isDirty() {
        return this.mRadiotextRead.isDirty();
    }
}

