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
import de.esolutions.fw.comm.dsi.androidauto2.impl.PlaybackInfoSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TelephonyStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto2.impl.TrackDataSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.vw.mib.bap.mqbab2.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbab2.navsd.functions.DistanceToNextManeuver;
import de.vw.mib.bap.mqbab2.navsd.functions.ManeuverDescriptor;
import de.vw.mib.bap.mqbab2.navsd.functions.RGStatus;
import de.vw.mib.bap.mqbab2.navsd.functions.TurnToInfo;
import de.vw.mib.util.StringBuilder;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

            public void runFinished() {
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
                        scanFiles();
                        if (!runInALoop) {
                            return;
                        }
                        Thread.sleep(500);
                    }
                }
            } catch (Exception e) {
                System.out.println("TracesSDScanner failed while running scan: " + e);
            }
        }

        public TreeSet getFilesToScan() {
            File[] filesInRootLogDir = esotrace_dir.listFiles();
            TreeSet logFiles = new TreeSet();
            latestLogDir = null;
            for (int i = 0; i < filesInRootLogDir.length; i++) {
                File fileInRootDir = filesInRootLogDir[i];
                if (fileInRootDir.isDirectory()) {
                    File[] filesInLogDir = fileInRootDir.listFiles();

                    if (latestLogDir == null || latestLogDir.compareTo(fileInRootDir.getPath()) <= 0) {
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
                                if (lastScannedFile == null || lastScannedFile.compareTo(filePath) < 0) {
                                    logFiles.add(filePath);
                                }
                            }
                        }
                        latestLogDir = fileInRootDir.getPath();
                    }
                }
            }
            return logFiles;
        }

        String latestLogDir = null;

        private boolean hasAnythingToFlush = false;

        public void maybeFlushUpdates() {
            if (!hasAnythingToFlush) {
                return;
            }

            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                Event event = (Event) entry.getValue();

                if (lastEventHandler != null) {
                    lastEventHandler.handleEvent((String) entry.getKey(), event);
                } else {
                    System.out
                            .println("TracesSDScanner(default event handler) Last event of type " + entry.getKey() + "="
                                    + event);
                }
            }

            if (lastEventHandler != null) {
                lastEventHandler.runFinished();
            }

            hasAnythingToFlush = false;
        }

        private void scanFiles() {
            try {
                TreeSet logFiles = getFilesToScan();

                Iterator logFilesIterator = logFiles.iterator();
                while (logFilesIterator.hasNext()) {
                    String logFilePath = (String) logFilesIterator.next();
                    this.scanFile(logFilePath, !logFilesIterator.hasNext());
                }

                maybeFlushUpdates();
            } catch (Exception e) {
                System.out.println("TracesSDScanner failed while running scanFiles: ");
                e.printStackTrace();
            }
        }

        class NoMoreBytesException extends Exception {

        }

        class UTFExtractor {
            RandomAccessFile stream;
            boolean isLastFile;

            public UTFExtractor(RandomAccessFile stream, boolean isLastFile) {
                this.stream = stream;
                this.isLastFile = isLastFile;
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

            private byte read() throws Exception, IOException {
                while (true) {
                    if (bytesBuferPos >= bytesBUfferLen) {
                        // try to fill buffer
                        int len = stream.read(bytesBuffer);

                        if (len <= 0) {
                            boolean thisFileIsFinished = true;
                            if (this.isLastFile && runInALoop) {
                                maybeFlushUpdates();
                                Thread.sleep(500);
                                // check if there are any new files
                                TreeSet logFiles = getFilesToScan();
                                if (logFiles.size() == 0) {
                                    // if there is nothing new - let's see if anything was appended

                                    // when new stuff is appended
                                    // consumed EOF byte is replaced with actual content
                                    // so we need to "rewind" 1 byte to be able to read new content
                                    // otherwise we would lose 1 byte and potentially break event mid write
                                    stream.seek(stream.getFilePointer() - 1);
                                    thisFileIsFinished = false;
                                }
                            }

                            if (thisFileIsFinished) {
                                throw new NoMoreBytesException();
                            }
                        } else {
                            bytesBuferPos = 0;
                            bytesBUfferLen = len;
                        }
                    }

                    byte b = bytesBuffer[bytesBuferPos++];
                    // we skip EOF byte
                    if (b != 10) {
                        return b;
                    }
                }
            }

            private String getNext() {
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

                            String s = new String(builderbytes, 0, bytesC);
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

        private void scanFile(String path, boolean isLastFile) {
            int lineNumber = 0;
            int offset = 0;
            String line = "";
            RandomAccessFile fis = null;
            try {
                System.out.println("TracesSDScanner running scanFile \"" + path + "\"");

                fis = new RandomAccessFile(path, "r");
                UTFExtractor ext = new UTFExtractor(fis, isLastFile);

                lastScannedFile = path;

                while ((line = ext.getNext()) != null) {
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
                        hasAnythingToFlush = true;
                    } else {
                        System.out.println("Skipped " + metaType + " / " + metaValues);
                    }
                }

                if (isLastFile) {
                    System.out.println("TracesSDScanner collected " + eventCount + " events");
                    System.out.println("TracesSDScanner collected fields:");
                    printCollected();
                }
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
                    TracesSDScanner.NavigationNextTurnEvent nextTurn = null;
                    TracesSDScanner.NavigationNextTurnDistance nextTurnDistance = null;
                    TracesSDScanner.NowPlayingData nowPlaying = null;

                    boolean navChanged = false;
                    boolean nowPlayingChanged = false;

                    public void handleEvent(String type, DSIAndroidAuto2ReplyService.TracesSDScanner.Event event) {
                        if (event instanceof TracesSDScanner.NavigationNextTurnEvent) {
                            TracesSDScanner.NavigationNextTurnEvent newNextTurn = (TracesSDScanner.NavigationNextTurnEvent) event;
                            if (nextTurn == null || !newNextTurn.toString().equals(nextTurn.toString())) {
                                nextTurn = newNextTurn;
                                navChanged = true;
                            }
                        } else if (event instanceof TracesSDScanner.NavigationNextTurnDistance) {
                            TracesSDScanner.NavigationNextTurnDistance newNextTurnDistance = (TracesSDScanner.NavigationNextTurnDistance) event;
                            if (nextTurnDistance == null
                                    || !newNextTurnDistance.toString().equals(nextTurnDistance.toString())) {
                                nextTurnDistance = newNextTurnDistance;
                                navChanged = true;
                            }

                        } else if (event instanceof TracesSDScanner.NowPlayingData) {
                            TracesSDScanner.NowPlayingData nextNowPlaying = (TracesSDScanner.NowPlayingData) event;
                            if (nowPlaying == null
                                    || !nextNowPlaying.toString().equals(nowPlaying.toString())) {
                                nowPlaying = nextNowPlaying;
                                nowPlayingChanged = true;
                            }

                        }
                    }

                    public void runFinished() {
                        if (nowPlayingChanged) {
                            if (!CurrentStationInfo.AndroidAutoTitle.equals(nowPlaying.title)
                                    || !CurrentStationInfo.AndroidAutoArtist.equals(nowPlaying.artist)
                                    || !CurrentStationInfo.AndroidAutoAlbum.equals(nowPlaying.album)) {
                                CurrentStationInfo.AndroidAutoTitle = nowPlaying.title;
                                CurrentStationInfo.AndroidAutoArtist = nowPlaying.artist;
                                CurrentStationInfo.AndroidAutoAlbum = nowPlaying.album;
                                CurrentStationInfo.refresh();
                            }
                            nowPlayingChanged = false;
                        }

                        if (navChanged) {
                            boolean shouldBeActive = false;
                            String nextRoad = "";
                            int nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_NO_SYMBOL;
                            int nextDirection = 0;
                            int nextDistance = -1;

                            if (nextTurn != null && !nextTurn.event.equals("UNKNOWN")) {
                                shouldBeActive = true;
                                nextRoad = nextTurn.road != null ? nextTurn.road : "";

                                if (nextTurnDistance != null) {
                                    nextDistance = nextTurnDistance.distanceMeters;
                                }

                                // if event is estimated is more than 3 minutes into future and we are further
                                // than 1km - we are just following along
                                // to not distract with turns just yet.
                                // - on highways 3 minutes will still be quite far away
                                // - in city areas with potentially heavy traffic we also check for distance as
                                // 1km might in jam might take longer than estimated
                                // 3 minutes, but we should probably be getting ready to get on proper lane etc
                                if (nextTurnDistance != null && nextTurnDistance.timeSeconds > 180
                                        && nextTurnDistance.distanceMeters > 2500) {
                                    nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_FOLLOW_STREET;
                                    nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                } else if (nextTurn.event.equals("TURN")) {
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    }
                                } else if (nextTurn.event.equals("SLIGHT_TURN")) {
                                    // nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT_SLIGHT;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT_SLIGHT;
                                    }
                                } else if (nextTurn.event.equals("SHARP_TURN")) {
                                    // nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT_SHARP;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT_SHARP;
                                    }
                                } else if (nextTurn.event.equals("ON_RAMP")
                                        || nextTurn.event.equals("OFF_RAMP") || nextTurn.event.equals("MERGE")) {
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_CHANGE_LANE;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_CHANGE_LANE;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    } else {
                                        // this is for UNSPECIFIED turnSide - I get "MERGE" events with no turnSide
                                        // using TURN with straight direction because it does show road name in gauge
                                        // (FOLLOW_STREET shows "current streetname" to follow)
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                    }
                                } else if (nextTurn.event.equals("STRAIGHT") || nextTurn.event.equals("NAME_CHANGE")
                                        || nextTurn.event.equals("DEPART")) {
                                    nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_TURN;
                                    nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                    if (nextTurn.event.equals("DEPART")) {
                                        nextDistance = -1;
                                    }
                                } else if (nextTurn.event.equals("FORK")) {
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_FORK_2;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_FORK_2;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    } else {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_FORK_3;
                                        nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                    }
                                } else if (nextTurn.event.equals("U_TURN")) {
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_UTURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_UTURN;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    }
                                } else if (nextTurn.event.equals("ROUNDABOUT_ENTER")) {
                                    nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_PREPARE_ROUNDABOUT;
                                    nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                } else if (nextTurn.event.equals("ROUNDABOUT_EXIT")) {
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_LEFT;
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else {
                                        nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_EXIT_ROUNDABOUT_TRS_RIGHT;
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    }
                                } else if (nextTurn.event.equals("ROUNDABOUT_ENTER_AND_EXIT")) {
                                    nextMainElement = nextTurn.turnSide.equals("LEFT")
                                            ? ManeuverDescriptor.MAIN_ELEMENT_ROUNDABOUT_TRS_LEFT
                                            : ManeuverDescriptor.MAIN_ELEMENT_ROUNDABOUT_TRS_RIGHT;
                                    // Android "right" through roundabout is 90 maps to VW 192
                                    // Android "straight" through roundabout is 180 maps to VW 0
                                    // Android "left" through roundabout is 270 maps to VW 64
                                    // Android "uturn" through roundabout is 360 maps to VW 128

                                    // Android range from 0-360, VW range from 0-256
                                    // Seems like VW supports increments of 16 (0, 16, 32, 48, 64, and so on)
                                    // possibly more, but that's detailed enough.

                                    nextDirection = ((((180 + (360 / (16 * 2)) + nextTurn.turnAngle) % 360) * 16) / 360)
                                            * 16;
                                } else if (nextTurn.event.equals("DESTINATION")) {
                                    nextMainElement = ManeuverDescriptor.MAIN_ELEMENT_NEAR_DESTINATION;
                                    nextDirection = ManeuverDescriptor.DIRECTION_STRAIGHT;
                                    if (nextTurn.turnSide.equals("LEFT")) {
                                        nextDirection = ManeuverDescriptor.DIRECTION_LEFT;
                                    } else if (nextTurn.turnSide.equals("RIGHT")) {
                                        nextDirection = ManeuverDescriptor.DIRECTION_RIGHT;
                                    }
                                }
                            }

                            boolean statusChanged = false;
                            if (shouldBeActive != RGStatus.AndroidAutoRouteGuidanceActive) {
                                RGStatus.AndroidAutoRouteGuidanceActive = shouldBeActive;
                                statusChanged = true;
                                RGStatus.refresh();
                            }

                            if (statusChanged || !nextRoad.equals(TurnToInfo.AndroidAutoRoad)) {
                                TurnToInfo.AndroidAutoRoad = nextRoad;
                                TurnToInfo.refresh();
                            }

                            if (statusChanged || ManeuverDescriptor.AndroidAutoManeuverMainELement != nextMainElement
                                    || ManeuverDescriptor.AndroidAutoManeuverDirection != nextDirection) {
                                ManeuverDescriptor.AndroidAutoManeuverMainELement = nextMainElement;
                                ManeuverDescriptor.AndroidAutoManeuverDirection = nextDirection;
                                ManeuverDescriptor.refresh();
                            }

                            if (statusChanged
                                    || nextDistance != DistanceToNextManeuver.AndroidAutoDistanceToNextManeuver) {
                                DistanceToNextManeuver.AndroidAutoDistanceToNextManeuver = nextDistance;
                                DistanceToNextManeuver.refresh();
                            }

                            navChanged = false;
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
