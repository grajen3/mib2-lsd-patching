/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.internal.media.browser.bap.MediaBapBrowser;
import de.vw.mib.asl.internal.media.browser.bap.MediaHasBrowser;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.recorder.MediaRecorder;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import de.vw.mib.util.Util;

public class MediaComponents {
    private ISources mSources = null;
    private MediaPlayer mPlayer = null;
    private MediaRecorder mRecorder = null;
    private MediaMainBrowser mBrowser_MainView = null;
    private MediaCoverBrowser mBrowser_Cover = null;
    private MediaRecorderBrowser mBrowser_Recorder = null;
    private MediaBapBrowser mBrowser_Kombi = null;
    private MediaHasBrowser mBrowser_Has = null;
    private MediaSpeechBrowser mBrowser_Speech = null;
    private MediaAudioManager mSound = null;
    private MediaSettings mSettings = null;
    public static final int SOURCES;
    public static final int PLAYER;
    public static final int SOUND;
    public static final int RECORDER;
    public static final int SETTINGS;
    public static final int BROWSER_MAINVIEW;
    public static final int BROWSER_COVER;
    public static final int BROWSER_SPEECH;
    public static final int BROWSER_KOMBI;
    public static final int BROWSER_HAS;
    public static final int BROWSER_RECORDER;
    public static final int ALL_BUT_BROWSER;
    public static final int ALL;

    public ISources getSources() {
        return this.mSources;
    }

    void setSources(ISources iSources) {
        this.mSources = iSources;
    }

    public MediaPlayer getPlayer() {
        return this.mPlayer;
    }

    void setPlayer(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public MediaRecorder getRecorder() {
        return this.mRecorder;
    }

    void setRecorder(MediaRecorder mediaRecorder) {
        this.mRecorder = mediaRecorder;
    }

    public MediaMainBrowser getBrowser_MainView() {
        return this.mBrowser_MainView;
    }

    void setBrowser_MainView(MediaMainBrowser mediaMainBrowser) {
        this.mBrowser_MainView = mediaMainBrowser;
    }

    public MediaCoverBrowser getBrowser_Cover() {
        return this.mBrowser_Cover;
    }

    void setBrowser_Cover(MediaCoverBrowser mediaCoverBrowser) {
        this.mBrowser_Cover = mediaCoverBrowser;
    }

    public MediaRecorderBrowser getBrowser_Recorder() {
        return this.mBrowser_Recorder;
    }

    void setBrowser_Recorder(MediaRecorderBrowser mediaRecorderBrowser) {
        this.mBrowser_Recorder = mediaRecorderBrowser;
    }

    public MediaBapBrowser getBrowser_Kombi() {
        return this.mBrowser_Kombi;
    }

    void setBrowser_Kombi(MediaBapBrowser mediaBapBrowser) {
        this.mBrowser_Kombi = mediaBapBrowser;
    }

    public MediaHasBrowser getBrowser_Has() {
        return this.mBrowser_Has;
    }

    void setBrowser_Has(MediaHasBrowser mediaHasBrowser) {
        this.mBrowser_Has = mediaHasBrowser;
    }

    public MediaSpeechBrowser getBrowser_Speech() {
        return this.mBrowser_Speech;
    }

    void setBrowser_Speech(MediaSpeechBrowser mediaSpeechBrowser) {
        this.mBrowser_Speech = mediaSpeechBrowser;
    }

    public MediaAudioManager getSound() {
        return this.mSound;
    }

    void setSound(MediaAudioManager mediaAudioManager) {
        this.mSound = mediaAudioManager;
    }

    public MediaSettings getSettings() {
        return this.mSettings;
    }

    void setSettings(MediaSettings mediaSettings) {
        this.mSettings = mediaSettings;
    }

    public static String getComponentsStr(int n) {
        String string = "";
        if (n == -1) {
            return "ALL";
        }
        if (Util.isBitSet(1, n)) {
            string = new StringBuffer().append(string).append("|SOURCES").toString();
        }
        if (Util.isBitSet(2, n)) {
            string = new StringBuffer().append(string).append("|PLAYER").toString();
        }
        if (Util.isBitSet(4, n)) {
            string = new StringBuffer().append(string).append("|SOUND").toString();
        }
        if (Util.isBitSet(8, n)) {
            string = new StringBuffer().append(string).append("|RECORDER").toString();
        }
        if (Util.isBitSet(16, n)) {
            string = new StringBuffer().append(string).append("|SETTINGS").toString();
        }
        if (Util.isBitSet(32, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_MAINVIEW").toString();
        }
        if (Util.isBitSet(64, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_COVER").toString();
        }
        if (Util.isBitSet(1024, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_RECORDER").toString();
        }
        if (Util.isBitSet(256, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_KOMBI").toString();
        }
        if (Util.isBitSet(512, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_HAS").toString();
        }
        if (Util.isBitSet(128, n)) {
            string = new StringBuffer().append(string).append("|BROWSER_SPEECH").toString();
        }
        if (string.trim().length() == 0) {
            return "NONE";
        }
        return string.substring(1);
    }
}

