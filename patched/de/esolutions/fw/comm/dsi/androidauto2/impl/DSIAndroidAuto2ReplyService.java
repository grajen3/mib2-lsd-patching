/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto2.DSIAndroidAuto2Reply;
import de.esolutions.fw.comm.dsi.androidauto2.impl.CallStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TelephonyStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.util.StringBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAndroidAuto2ReplyService
        extends AbstractReplyService {

    // --- START COPY
    public static TracesSDScanner.NavigationNextTurnEvent lastNavigationNextTurnEvent;
    public static TracesSDScanner.NavigationNextTurnDistance lastNavigationNextTurnDistance;
    public static TracesSDScanner.PlayPosition lastPlayPosition;
    public static TracesSDScanner.CoverArtUrl lastCoverArtUrl;
    public static TracesSDScanner.NowPlayingData lastNowPlayingData;
    public static TracesSDScanner.PlaybackState lastPlaybackState;
    public static TracesSDScanner.TelephonyState lastTelephonyState;

    private static TracesSDScanner _instance = null;
    private static int eventCount = 0;

    public class TracesSDScanner extends Thread {
        public TracesSDScanner.LastEventHandler lastEventHandler;
        public boolean runInALoop = true;

        public class Event {
            public Event() {
                eventCount++;
            }

            private Map fields = new HashMap();

            public void addField(String key, String value) {
                fields.put(key, value);
            }

            // this checks wether to accumulate values for given key
            // for dev/debug purposes
            public boolean shouldCollect(String key) {
                return true;
            }

            public String toStringWithPrefix(String prefix) {
                String s = _toString();
                if (s.length() > 0) {
                    return prefix + s;
                }
                return "";
            }

            private String _toString() {
                if (fields.size() == 0) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("UnmanagedFields:[");
                Iterator fieldIterator = fields.entrySet().iterator();
                boolean isFirst = true;
                while (fieldIterator.hasNext()) {
                    Map.Entry fieldEntry = (Map.Entry) fieldIterator.next();
                    if (!isFirst) {
                        sb.append(", ");
                    } else {
                        isFirst = false;
                    }
                    sb.append(fieldEntry.getKey()).append("=").append(fieldEntry.getValue());
                }
                sb.append("]");

                return sb.toString();
            }

            public String toString() {
                return _toString();
            }
        }

        public class NavigationNextTurnEvent extends Event {
            public String road;
            public String turnSide;
            public String event;
            public int turnAngle;
            public int turnNumber;

            public boolean shouldCollect(String key) {
                return key.equals("turnSide") || key.equals("event") || super.shouldCollect(key);
            }

            public void addField(String key, String value) {
                if (key.equals("road")) {
                    this.road = value;
                } else if (key.equals("turnSide")) {
                    this.turnSide = value;
                } else if (key.equals("event")) {
                    this.event = value;
                } else if (key.equals("turnAngle")) {
                    this.turnAngle = Integer.parseInt(value);
                } else if (key.equals("turnNumber")) {
                    this.turnNumber = Integer.parseInt(value);
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                return "NavigationNextTurnEvent:"
                        + " road: " + road
                        + " turnSide: " + turnSide
                        + " event: " + event
                        + " turnAngle: " + turnAngle
                        + " turnNumber: " + turnNumber
                        + toStringWithPrefix(" ");
            }
        }

        public class NavigationNextTurnDistance extends Event {
            public int distanceMeters;
            public int timeSeconds;

            public boolean shouldCollect(String key) {
                return false;
            }

            public void addField(String key, String value) {
                if (key.equals("distanceMeters")) {
                    this.distanceMeters = Integer.parseInt(value);
                } else if (key.equals("timeSeconds")) {
                    this.timeSeconds = Integer.parseInt(value);
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                return "NavigationNextTurnDistance:"
                        + " distanceMeters: " + distanceMeters
                        + " timeSeconds: " + timeSeconds
                        + toStringWithPrefix(" ");
            }
        }

        public class NowPlayingData extends Event {
            public String title;
            public String artist;
            public String album;
            public int duration;

            public void addField(String key, String value) {
                if (key.equals("title")) {
                    this.title = value;
                } else if (key.equals("artist")) {
                    this.artist = value;
                } else if (key.equals("album")) {
                    this.album = value;
                } else if (key.equals("duration")) {
                    this.duration = Integer.parseInt(value);
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                // if (!CurrentStationInfo.AndroidAutoTitle.equals(this.title)
                // || !CurrentStationInfo.AndroidAutoArtist.equals(this.artist)
                // || !CurrentStationInfo.AndroidAutoAlbum.equals(this.album)
                // ) {
                // CurrentStationInfo.AndroidAutoTitle = this.title;
                // CurrentStationInfo.AndroidAutoArtist = this.artist;
                // CurrentStationInfo.AndroidAutoAlbum = this.album;
                // if (CurrentStationInfo.instance != null) {
                // // hack to trigger an update
                // CurrentStationInfo.instance.languageChanged();
                // }
                // }
                return "NowPlayingData:"
                        + " title: " + title
                        + " artist: " + artist
                        + " album: " + album
                        + " duration: " + duration
                        + toStringWithPrefix(" ");
            }
        }

        public class CoverArtUrl extends Event {
            public String url;

            public void addField(String key, String value) {
                if (key.equals("url")) {
                    this.url = value;
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                return "CoverArt:"
                        + " url: " + url
                        + toStringWithPrefix(" ");
            }
        }

        public class PlayPosition extends Event {
            public int timePosition;

            public boolean shouldCollect(String key) {
                return false;
            }

            public void addField(String key, String value) {
                if (key.equals("timePosition")) {
                    this.timePosition = Integer.parseInt(value);
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);

                }
            }

            public String toString() {
                return "PlayPosition:"
                        + " timePosition: " + timePosition
                        + toStringWithPrefix(" ");
            }
        }

        public class PlaybackState extends Event {
            public String status;
            public String shuffleMode;
            public String repeatMode;
            public String playbackApp;

            public boolean shouldCollect(String key) {
                return key.equals("status") || key.equals("shuffleMode") ||
                        key.equals("repeatMode") || super.shouldCollect(key);
            }

            public void addField(String key, String value) {
                if (key.equals("status")) {
                    this.status = value;
                } else if (key.equals("shuffleMode")) {
                    this.shuffleMode = value;
                } else if (key.equals("repeatMode")) {
                    this.repeatMode = value;
                } else if (key.equals("playbackApp")) {
                    this.playbackApp = value;
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                return "PlaybackState:"
                        + " status: " + status
                        + " shuffleMode: " + shuffleMode
                        + " repeatMode: " + repeatMode
                        + " playbackApp: " + playbackApp
                        + toStringWithPrefix(" ");
            }
        }

        public class NotImplementedEvent extends Event {
            private String type;

            public NotImplementedEvent(String type) {
                this.type = type;
            }

            public String toString() {
                return this.type + ":" + super.toString();
            }
        }

        public class TelephonyState extends Event {
            public int signalStrength;

            public void addField(String key, String value) {
                if (key.equals("signalStrength")) {
                    this.signalStrength = Integer.parseInt(value);
                }

                else if (!key.equals("valid")) {
                    super.addField(key, value);
                }
            }

            public String toString() {
                return "TelephonyState:"
                        + " signalStrength: " + signalStrength
                        + toStringWithPrefix(" ");
            }
        }

        private Event createEventOfType(String type) {
            if (type.equals("NavigationNextTurnEvent")) {
                return DSIAndroidAuto2ReplyService.lastNavigationNextTurnEvent = new NavigationNextTurnEvent();
            } else if (type.equals("NavigationNextTurnDistance")) {
                return DSIAndroidAuto2ReplyService.lastNavigationNextTurnDistance = new NavigationNextTurnDistance();
            } else if (type.equals("PlayPosition")) {
                return DSIAndroidAuto2ReplyService.lastPlayPosition = new PlayPosition();
            } else if (type.equals("CoverArtUrl")) {
                return DSIAndroidAuto2ReplyService.lastCoverArtUrl = new CoverArtUrl();
            } else if (type.equals("NowPlayingData")) {
                return DSIAndroidAuto2ReplyService.lastNowPlayingData = new NowPlayingData();
            } else if (type.equals("PlaybackState")) {
                return DSIAndroidAuto2ReplyService.lastPlaybackState = new PlaybackState();
            } else if (type.equals("TelephonyState")) {
                return DSIAndroidAuto2ReplyService.lastTelephonyState = new TelephonyState();
            }

            return new NotImplementedEvent(type);
        }

        private Event createEvent(String type, String values) {
            Event event = createEventOfType(type);
            if (event == null) {
                return null;
            }

            int offset = 0;
            char current = ' ';

            StringBuilder keyBuilder = new StringBuilder();
            StringBuilder valueBuilder = new StringBuilder();

            while (offset < values.length()) {

                // first find keyname
                current = values.charAt(offset);
                while (offset < values.length() && (current >= 'a' && current <= 'z')
                        || (current >= 'A' && current <= 'Z')) {
                    keyBuilder.append(current);
                    offset++;
                    if (offset < values.length()) {
                        current = values.charAt(offset);
                    }
                }

                if (keyBuilder.length() == 0 || current != '=') {
                    keyBuilder.setLength(0);
                    offset++;
                    continue;
                }

                offset++;
                if (offset < values.length()) {
                    current = values.charAt(offset);
                } else {
                    keyBuilder.setLength(0);
                    continue;
                }

                boolean isInSingleQuote = false;
                if (current == '\'') {
                    isInSingleQuote = true;
                    offset++;
                    if (offset < values.length()) {
                        current = values.charAt(offset);
                    }
                } else if (current == '[') {
                    keyBuilder.setLength(0);
                    offset++;
                    if (offset < values.length()) {
                        current = values.charAt(offset);
                    }
                    continue;
                }

                while (offset < values.length()) {
                    if ((current == ']' || current == ',') && !isInSingleQuote) {
                        break;
                    } else if (current == '\'' && isInSingleQuote && values.charAt(offset - 1) != '\\') {
                        break;
                    } else {
                        valueBuilder.append(current);
                    }

                    offset++;
                    if (offset < values.length()) {
                        current = values.charAt(offset);
                    }
                }

                if (valueBuilder.length() == 0) {
                    keyBuilder.setLength(0);
                    offset++;
                    continue;
                }

                String key = keyBuilder.toString();
                String val = valueBuilder.toString();
                event.addField(key, val);

                if (event.shouldCollect(key)) {
                    HashMap collectedFieldsForType = (HashMap) collected.get(type);
                    if (collectedFieldsForType == null) {
                        collectedFieldsForType = new HashMap();
                        collected.put(type, collectedFieldsForType);
                    }

                    TreeSet collectedValues = (TreeSet) collectedFieldsForType.get(key);
                    if (collectedValues == null) {
                        collectedValues = new TreeSet();
                        collectedFieldsForType.put(key, collectedValues);
                    }

                    collectedValues.add(val);
                }

                valueBuilder.setLength(0);
                keyBuilder.setLength(0);
            }

            return event;
        }

        private Map collected = new HashMap();

        private void printCollected() {
            Iterator typeIterator = collected.entrySet().iterator();
            while (typeIterator.hasNext()) {
                Map.Entry typeEntry = (Map.Entry) typeIterator.next();

                System.out.println("  Type: " + typeEntry.getKey());
                HashMap collectedFields = (HashMap) typeEntry.getValue();

                Iterator fieldIterator = collectedFields.entrySet().iterator();
                while (fieldIterator.hasNext()) {
                    Map.Entry fieldEntry = (Map.Entry) fieldIterator.next();

                    System.out.println("   Field: " + fieldEntry.getKey());
                    TreeSet collectedValues = (TreeSet) fieldEntry.getValue();

                    Iterator valueIterator = collectedValues.iterator();
                    while (valueIterator.hasNext()) {
                        String valueEntry = (String) valueIterator.next();
                        System.out.println("      \"" + valueEntry + "\"");
                    }
                }
            }
        }

        public abstract class LastEventHandler {
            public void handleEvent(String type, Event event) {
            }
        }

        Map map = new HashMap();
        String lastScannedFile = null;
        File esotrace_dir = null;

        public void run() {
            System.out.println("TracesSDScanner is now running");
            try {
                esotrace_dir = new File(dirToScan);
                if (esotrace_dir.exists()) {
                    int i = 0;
                    while (true) {
                        long start = System.currentTimeMillis();
                        scanFiles();
                        long timeDiff = System.currentTimeMillis() - start;
                        System.out.println("TracesSDScanner run #" + i++ + " duration " + timeDiff +
                                "ms");
                        if (!runInALoop) {
                            return;
                        }
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e) {
                System.out.println("TracesSDScanner failed while running scan: " + e);
            }
        }

        private void scanFiles() {
            try {
                File[] filesInRootLogDir = esotrace_dir.listFiles();
                TreeSet logFiles = new TreeSet();
                String latestLogDir = null;
                for (int i = 0; i < filesInRootLogDir.length; i++) {
                    File fileInRootDir = filesInRootLogDir[i];
                    if (fileInRootDir.isDirectory()) {
                        File[] filesInLogDir = fileInRootDir.listFiles();

                        if (latestLogDir == null || latestLogDir.compareTo(fileInRootDir.getPath()) < 0) {
                            boolean didClear = false;

                            for (int j = 0; j < filesInLogDir.length; j++) {
                                String filePath = filesInLogDir[j].getPath();
                                String extension = "";

                                int iext = filePath.lastIndexOf('.');
                                if (iext > 0) {
                                    extension = filePath.substring(iext + 1);
                                }

                                if (extension.equals("esotrace")) {
                                    if (!didClear) {
                                        logFiles.clear();
                                        didClear = true;
                                    }
                                    logFiles.add(filePath);
                                }
                            }
                            latestLogDir = fileInRootDir.getPath();
                        }
                    }
                }

                Iterator logFilesIterator = logFiles.iterator();
                while (logFilesIterator.hasNext()) {
                    String logFilePath = (String) logFilesIterator.next();

                    if (lastScannedFile == null || lastScannedFile.compareTo(logFilePath) <= 0) {
                        this.scanFile(logFilePath);

                    }
                }

                System.out.println("TracesSDScanner collected " + eventCount + " events");
                System.out.println("TracesSDScanner collected fields:");
                printCollected();

                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    Event event = (Event) entry.getValue();

                    if (lastEventHandler != null) {
                        lastEventHandler.handleEvent((String) entry.getKey(), event);
                    } else {
                        System.out
                                .println("TracesSDScanner(default event handler) Last event of type " + entry.getKey()
                                        + "=" + event);
                    }
                }
            } catch (Exception e) {
                System.out.println("TracesSDScanner failed while running scanFiles: ");
                e.printStackTrace();
            }
        }

        class NoMoreBytesException extends Exception {

        }

        class UTFExtractor {
            FileInputStream stream;

            public UTFExtractor(FileInputStream stream) {
                this.stream = stream;
            }

            private int matched = 0;
            // bytes for "[DSIAndroidAuto2Impl] onJob_update"
            private byte[] pre = {
                    0x5b, 0x44, 0x53, 0x49, 0x41, 0x6e, 0x64, 0x72, 0x6f, 0x69, 0x64, 0x41, 0x75, 0x74, 0x6f, 0x32,
                    0x49, 0x6d,
                    0x70, 0x6c, 0x5d, 0x20, 0x6f, 0x6e, 0x4a, 0x6f, 0x62, 0x5f, 0x75, 0x70, 0x64, 0x61, 0x74, 0x65
            };

            private byte[] bytesBuffer = new byte[8192];
            private byte[] builderbytes = new byte[8192];
            private int bytesBuferPos = 0;
            private int bytesBUfferLen = 0;
            private byte b = 0;

            public long _timeReading = 0;
            public long _timeReadingAndParsing = 0;
            public long _timeCreatingStringsFromBytes = 0;

            public long getTimeParsingBytesIntoStrings() {
                return _timeReadingAndParsing - _timeReading;
            }

            private byte read() throws Exception, IOException {
                if (bytesBuferPos >= bytesBUfferLen) {
                    // try to fill buffer
                    long start = System.currentTimeMillis();
                    int len = stream.read(bytesBuffer);
                    _timeReading += System.currentTimeMillis() - start;

                    if (len <= 0) {
                        throw new NoMoreBytesException();
                    }

                    bytesBuferPos = 0;
                    bytesBUfferLen = len;
                }

                return bytesBuffer[bytesBuferPos++];
            }

            public String getNext() {
                long start = System.currentTimeMillis();
                String ret = getNextWithoutTiming();
                _timeReadingAndParsing += System.currentTimeMillis() - start;
                return ret;
            }

            private String getNextWithoutTiming() {
                try {
                    matched = 0;

                    while (true) {

                        while (matched < pre.length && (b = (byte) read()) == pre[matched]) {
                            matched++;
                        }

                        if (matched != pre.length) {
                            matched = 0;
                            continue;
                        }
                        matched = 0;

                        try {
                            int bytesC = 0;
                            while ((b = (byte) read()) != 0) {
                                builderbytes[bytesC++] = b;
                            }

                            long start = System.currentTimeMillis();
                            String s = new String(builderbytes, 0, bytesC);
                            _timeCreatingStringsFromBytes += System.currentTimeMillis() - start;
                            return s;
                        } catch (Exception e) {
                            System.out.println("www" + e);
                            e.printStackTrace();
                        }

                    }

                } catch (NoMoreBytesException e) {
                    return null;
                } catch (Exception e) {
                    System.out.println("fail " + e);
                    e.printStackTrace();
                }

                return null;
            }
        }

        private void scanFile(String path) {
            int lineNumber = 0;
            int offset = 0;
            String line = "";
            FileInputStream fis = null;
            try {
                System.out.println("TracesSDScanner running scanFile \"" + path + "\"");

                fis = new FileInputStream(new File(path));
                UTFExtractor ext = new UTFExtractor(fis);

                long _timeParsingStringsIntoEvents = 0;
                long startTotal = System.currentTimeMillis();

                while ((line = ext.getNext()) != null) {
                    long start = System.currentTimeMillis();
                    char c;
                    offset = 0;
                    StringBuilder metaTypeBuilder = new StringBuilder();
                    StringBuilder metaValueBuilder = new StringBuilder();
                    while (offset < line.length() && (c = line.charAt(offset)) != ' ') {
                        metaTypeBuilder.append(c);
                        offset++;
                    }

                    if (offset + 3 >= line.length()
                            || (line.charAt(offset) != ' ' || line.charAt(offset + 1) != ':'
                                    || line.charAt(offset + 2) != ' ')) {
                        continue;
                    }

                    offset += 3;

                    while (offset < line.length() && (c = line.charAt(offset)) != '\u0000') {
                        metaValueBuilder.append(c);
                        offset++;
                    }

                    String metaType = metaTypeBuilder.toString();
                    String metaValues = metaValueBuilder.toString();

                    Event event = null;
                    try {
                        event = createEvent(metaType, metaValues);
                    } catch (Exception e) {
                        System.out.println(
                                "TracesSDScanner failed to create event from \"" + metaType + " : " + metaValues +
                                        "\": " + e);
                    }

                    if (event != null) {
                        // System.out.println("created for " + metaType + " " + event);
                        map.put(metaType, event);
                    } else {
                        System.out.println("Skipped " + metaType + " / " + metaValues);
                    }
                    _timeParsingStringsIntoEvents += System.currentTimeMillis() - start;
                }

                long totalScanFile = System.currentTimeMillis() - startTotal;

                System.out.println("TracesSDScanner.scanFile \"" + path + "\" timings:\n - total: " + totalScanFile
                        + "ms\n - stream reading bytes: " + ext._timeReading + "ms\n" + //
                        " - trying to parse bytes into strings: " + ext.getTimeParsingBytesIntoStrings()
                        + "ms\n - creating strings from selected bytes: " + ext._timeCreatingStringsFromBytes
                        + "ms\n - parsing strings into events: " + _timeParsingStringsIntoEvents + "ms");

                lastScannedFile = path;
            } catch (Exception e) {
                System.out.println("TracesSDScanner failed while running scanFile \"" + path
                        + "\": ");
                System.out.println("l" + lineNumber + " / o" + offset + " / ll" + line);
                e.printStackTrace();
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {

                }
            }
        }
    }

    // --- END COPY

    // above is something I copy from my local test runner - below is configuring it
    // to run in MIB + handling events in MIB
    private static String dirToScan = "/fs/sda0/esotrace_SD";

    public TracesSDScanner getTracesSDScannerInstance() {
        try {
            if (_instance == null) {
                TracesSDScanner scanner = new TracesSDScanner();
                scanner.lastEventHandler = scanner.new LastEventHandler() {
                    public void handleEvent(String type, DSIAndroidAuto2ReplyService.TracesSDScanner.Event event) {
                        System.out.println("TracesSDScanner! Last event of type " + type + "=" + event);
                        if (event instanceof TracesSDScanner.NowPlayingData) {
                            TracesSDScanner.NowPlayingData nowPlaying = (TracesSDScanner.NowPlayingData) event;
                            if (!CurrentStationInfo.AndroidAutoTitle.equals(nowPlaying.title)
                                    || !CurrentStationInfo.AndroidAutoArtist.equals(nowPlaying.artist)
                                    || !CurrentStationInfo.AndroidAutoAlbum.equals(nowPlaying.album)) {
                                CurrentStationInfo.AndroidAutoTitle = nowPlaying.title;
                                CurrentStationInfo.AndroidAutoArtist = nowPlaying.artist;
                                CurrentStationInfo.AndroidAutoAlbum = nowPlaying.album;
                                if (CurrentStationInfo.instance != null) {
                                    // hack to trigger an update
                                    CurrentStationInfo.instance.languageChanged();
                                }
                            }
                        }
                    }
                };
                scanner.start();
                _instance = scanner;
            }

            return _instance;
        } catch (Exception e) {
            System.out.println("Failed to get/start TracesSDScanner instance " + e);
        }
        return null;
    };

    // end scanning

    private static /* final */ CallContext context = CallContext.getContext("STUB.dsi.androidauto2.DSIAndroidAuto2");
    private static int dynamicHandle = 0;
    private DSIAndroidAuto2Reply p_DSIAndroidAuto2Reply;

    public DSIAndroidAuto2ReplyService(DSIAndroidAuto2Reply dSIAndroidAuto2Reply) {
        super(new ServiceInstanceID("1109a8e3-3caa-5724-b33f-de936bc4e076",
                DSIAndroidAuto2ReplyService.nextDynamicHandle(), "3c1002ff-1bb7-599d-83c3-6670b394036e",
                "dsi.androidauto2.DSIAndroidAuto2"));
        this.p_DSIAndroidAuto2Reply = dSIAndroidAuto2Reply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    // @Override
    public CallContext getCallContext() {
        return context;
    }

    // @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.videoFocusRequestNotification(n, n2);
                    break;
                }
                case 31: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.videoAvailable(bl, n);
                    // this is initing scanner if it wasn't initted already
                    // it is only initiated when android auto sends some events
                    getTracesSDScannerInstance();
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.audioFocusRequestNotification(n, n3);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.audioAvailable(n, bl, n4);
                    // this is initing scanner if it wasn't initted already
                    // it is only initiated when android auto sends some events
                    getTracesSDScannerInstance();
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.voiceSessionNotification(n, n5);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.microphoneRequestNotification(n, n6);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.navFocusRequestNotification(n, n7);
                    break;
                }
                case 23: {
                    CallState[] callStateArray = CallStateSerializer.getOptionalCallStateVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateCallState(callStateArray, n);
                    break;
                }
                case 30: {
                    TelephonyState telephonyState = TelephonyStateSerializer.getOptionalTelephonyState(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateTelephonyState(telephonyState, n);
                    break;
                }
                case 27: {
                    TrackData trackData = TrackDataSerializer.getOptionalTrackData(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNowPlayingData(trackData, n);
                    break;
                }
                case 28: {
                    PlaybackInfo playbackInfo = PlaybackInfoSerializer.getOptionalPlaybackInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updatePlaybackState(playbackInfo, n);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updatePlayposition(n, n8);
                    break;
                }
                case 24: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer
                            .getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateCoverArtUrl(resourceLocator, n);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNavigationNextTurnEvent(string, n, n9, n10, n11, n12);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.updateNavigationNextTurnDistance(n, n13, n14);
                    break;
                }
                case 17: {
                    double d2 = iDeserializer.getDouble();
                    double d3 = iDeserializer.getDouble();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.setExternalDestination(d2, d3, string, string2, n);
                    break;
                }
                case 5: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.bluetoothPairingRequest(string, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIAndroidAuto2Reply.asyncException(n, string, n15);
                    break;
                }
                case 35: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIAndroidAuto2Reply.yyIndication(string, string3);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        } catch (Exception serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s)
                    .append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}
