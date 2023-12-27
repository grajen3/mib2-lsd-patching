/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.commons.StringConverter;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.filetransfer.DefaultFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferListener;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferManager;
import de.esolutions.fw.util.tracing.filetransfer.file.IFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.file.MemoryTransferFile;
import de.esolutions.fw.util.tracing.filetransfer.file.RealFileFactory;
import de.esolutions.fw.util.tracing.filetransfer.file.RealTransferFile;
import de.esolutions.fw.util.tracing.filetransfer.util.FileTransferUtils;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CommandShellBackend
extends AbstractTraceBackend
implements Runnable {
    private ITraceMessageFormatter formatter;
    private ITraceEntityResolver resolver;
    private IFileTransferManager fileTransferManager;
    private IFileTransferListener fileTransferListener;
    private IFileFactory fileFactory;
    private boolean doRun;
    private Thread thread;
    private Map keyMap;
    private Map logFileMap;
    private boolean doStatistics;
    private long minDelta;
    private long maxDelta;
    private long sumDelta;
    private long lastReceiveTime;
    private long minRateDelta;
    private long maxRateDelta;
    private long sumRateDelta;
    private int numMessages;
    private boolean muted;
    private String waitForName;
    private short waitForType;
    private TraceEntityURI waitForEntity;
    private final Object waitForLock = new Object();
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager;

    public CommandShellBackend() {
        super("Terminal");
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        this.keyMap = new HashMap();
        this.logFileMap = new HashMap();
        this.doStatistics = false;
        String string = null;
        if (traceConfigBackend != null) {
            string = traceConfigBackend.getQuery().getStringValue("formatter");
        }
        this.formatter = iTraceBackendListener.createFormatter(string, true);
        this.resolver = iTraceBackendListener.getEntityResolver();
        this.fileTransferManager = (IFileTransferManager)iTraceBackendListener.getComponent((class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager == null ? (class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager = CommandShellBackend.class$("de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager")) : class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager).getName());
        if (this.fileTransferManager != null) {
            this.fileFactory = new RealFileFactory();
            this.fileTransferListener = new DefaultFileTransferListener();
            this.fileTransferManager.setFileFactory(this.fileFactory);
            this.fileTransferManager.registerListener(this.fileTransferListener);
        }
        this.doRun = true;
        this.thread = new Thread(this, "TraceTerminal");
        this.thread.setDaemon(true);
        this.thread.start();
    }

    @Override
    public void exit() {
        this.doRun = false;
        this.thread.interrupt();
        try {
            this.thread.join(0);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    private void resetStatistics() {
        this.minDelta = Long.MAX_VALUE;
        this.maxDelta = 0L;
        this.sumDelta = 0L;
        this.minRateDelta = Long.MAX_VALUE;
        this.maxRateDelta = 0L;
        this.sumRateDelta = 0L;
        this.numMessages = 0;
        this.lastReceiveTime = -1L;
    }

    private void printStatistics() {
        if (this.numMessages == 0) {
            System.out.println("No Messages recorded.");
            return;
        }
        System.out.println("Message Transport Delta Time (ms)");
        System.out.println(new StringBuffer().append("  Min:   ").append(this.minDelta).toString());
        System.out.println(new StringBuffer().append("  Max:   ").append(this.maxDelta).toString());
        System.out.println(new StringBuffer().append("  Avg:   ").append(this.sumDelta / (long)this.numMessages).toString());
        System.out.println("Message Delivery Rate Interval (ms)");
        System.out.println(new StringBuffer().append("  Min:   ").append(this.minRateDelta).toString());
        System.out.println(new StringBuffer().append("  Max:   ").append(this.maxRateDelta).toString());
        System.out.println(new StringBuffer().append("  Avg:   ").append(this.sumRateDelta / (long)this.numMessages).toString());
        System.out.println("Number of Messages:");
        System.out.println(new StringBuffer().append("  Total: ").append(this.numMessages).toString());
    }

    private void doStatistics(long l, long l2) {
        long l3 = l2 - l;
        if (l3 < this.minDelta) {
            this.minDelta = l3;
        }
        if (l3 > this.maxDelta) {
            this.maxDelta = l3;
        }
        this.sumDelta += l3;
        if (this.lastReceiveTime != -1L) {
            l3 = l2 - this.lastReceiveTime;
            if (l3 < this.minRateDelta) {
                this.minRateDelta = l3;
            }
            if (l3 > this.maxRateDelta) {
                this.maxRateDelta = l3;
            }
            this.sumRateDelta += l3;
        }
        this.lastReceiveTime = l2;
        ++this.numMessages;
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        String[] stringArray = this.formatter.formatMessage(iTraceMessage, this.resolver);
        if (this.doStatistics) {
            long l = System.currentTimeMillis();
            long l2 = iTraceMessage.getTimeStamp();
            this.doStatistics(l2, l);
        }
        if (!this.muted) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                System.out.println(stringArray[i2]);
            }
            System.out.flush();
        }
        if (!this.logFileMap.isEmpty()) {
            Iterator iterator = this.logFileMap.values().iterator();
            while (iterator.hasNext()) {
                FileWriter fileWriter = (FileWriter)iterator.next();
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    try {
                        fileWriter.write(new StringBuffer().append(stringArray[i3]).append("\n").toString());
                        continue;
                    }
                    catch (IOException iOException) {
                        System.out.println(new StringBuffer().append("Write log error: ").append(iOException).toString());
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean droppedMessages(int n) {
        System.out.println(new StringBuffer().append("DROPPED ").append(n).append(" MESSAGES").toString());
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void signalEntity(ITraceEntity iTraceEntity) {
        Object object = this.waitForLock;
        synchronized (object) {
            short s;
            if (this.waitForName != null && iTraceEntity.getName().equals(this.waitForName) && iTraceEntity.getURI().getType() == this.waitForType && (s = iTraceEntity.getCoreFilterLevel()) < 6) {
                this.waitForEntity = iTraceEntity.getURI();
                this.waitForLock.notify();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean createEntity(ITraceEntity iTraceEntity) {
        Map map = this.keyMap;
        synchronized (map) {
            this.keyMap.put(iTraceEntity.getURI(), iTraceEntity);
        }
        this.signalEntity(iTraceEntity);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean changeFilterLevel(TraceEntityURI traceEntityURI) {
        String string = this.formatEntry(traceEntityURI);
        System.out.println(string);
        TraceEntity traceEntity = null;
        Map map = this.keyMap;
        synchronized (map) {
            traceEntity = (TraceEntity)this.keyMap.get(traceEntityURI);
        }
        if (traceEntity != null) {
            this.signalEntity(traceEntity);
        }
        return true;
    }

    @Override
    public void run() {
        InputStream inputStream = System.in;
        boolean bl = false;
        System.out.println("Welcome to the e.solutions Trace Terminal");
        System.out.println("Enter 'q' or 'quit' to quit the application (only if allowed).");
        System.out.println("Enter 'help' for a short command summary.");
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            System.out.println(new StringBuffer().append("Error creating InputStreamReader: ").append(unsupportedEncodingException).toString());
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (this.doRun) {
            try {
                String string = bufferedReader.readLine();
                if (string == null) {
                    System.out.println("EOF detected.");
                    this.quitCommand();
                    this.doRun = false;
                } else if (string.length() == 0) {
                    boolean bl2 = bl = !bl;
                    if (bl) {
                        this.listener.disconnected(this.bid);
                    } else {
                        this.listener.connected(this.bid, true);
                    }
                } else {
                    String[] stringArray = StringUtils.splitString(string, ' ');
                    if (stringArray != null) {
                        this.handleCommand(stringArray);
                    }
                }
                if (!bl) continue;
                System.out.print("> ");
                System.out.flush();
            }
            catch (IOException iOException) {
                System.out.println(new StringBuffer().append("Input Error: ").append(iOException).toString());
            }
        }
        System.out.println("Bye!");
    }

    private void handleCommand(String[] stringArray) {
        String string = stringArray[0];
        if (string.equals("ls") || string.equals("l")) {
            this.listCommand();
        } else if (string.equals("channel") || string.equals("ch") || string.equals("c")) {
            this.traceLevelCommand((short)3, stringArray);
        } else if (string.equals("thread") || string.equals("th") || string.equals("t")) {
            this.traceLevelCommand((short)2, stringArray);
        } else if (string.equals("call")) {
            this.callCommand(stringArray);
        } else if (string.equals("start")) {
            this.startCommand(stringArray);
        } else if (string.equals("stop")) {
            this.stopCommand(stringArray);
        } else if (string.equals("stat")) {
            this.statCommand(stringArray);
        } else if (string.equals("quit") || string.equals("q")) {
            this.quitCommand();
        } else if (string.equals("help") || string.equals("?")) {
            this.usage();
        } else if (string.equals("wait")) {
            this.waitCommand(stringArray);
        } else if (string.equals("mute")) {
            this.muted = true;
        } else if (string.equals("unmute")) {
            this.muted = false;
        } else if (string.equals("get")) {
            this.fileTransferCommandGet(stringArray);
        } else if (string.equals("fstat")) {
            this.fileTransferCommandStat(stringArray);
        } else if (string.equals("put")) {
            this.fileTransferCommandPut(stringArray);
        } else {
            System.out.println(new StringBuffer().append("Unknown command: '").append(stringArray[0]).append("' - Call 'help' for usage info").toString());
        }
    }

    private void usage() {
        int n;
        System.out.println("ls                              show all entities");
        System.out.println("channel|ch|c <name|id> [level]  query or change a channel filter level");
        System.out.println("thread|th|t  <name|id> [level]  query or change a thread filter level");
        System.out.println("wait <type> <name|id> [timeout] wait for an enabled entity (timeout in ms)");
        System.out.println("call <name|id> [argument]       call a callback method");
        System.out.println("start <filename>                start logging to file name");
        System.out.println("stop [filename]                 stop logging to file name or stop all logs");
        System.out.println("stat start|stop                 take some tracing statistics");
        System.out.println("mute                            do not display messages");
        System.out.println("unmute                          do display messages");
        System.out.println("get <filename>                  send a file download request ");
        System.out.println("fstat <filename>                send a file status request ");
        System.out.println("put <filename>                  upload a file");
        System.out.print("levels: ");
        for (n = 0; n < TraceLevels.levelNames.length; ++n) {
            System.out.print(new StringBuffer().append(TraceLevels.levelNames[n]).append(" ").toString());
        }
        System.out.println();
        System.out.print("types:  ");
        for (n = 0; n < TraceEntityType.names.length; ++n) {
            System.out.print(new StringBuffer().append(TraceEntityType.names[n]).append(" ").toString());
        }
        System.out.println();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String formatEntry(TraceEntityURI traceEntityURI) {
        TraceEntity traceEntity = null;
        Object object = this.keyMap;
        synchronized (object) {
            traceEntity = (TraceEntity)this.keyMap.get(traceEntityURI);
        }
        object = traceEntity.getPath(false);
        String string = StringUtils.padString(TraceEntityType.names[traceEntityURI.getType()], 10, 4);
        String string2 = StringUtils.padString(Integer.toString(traceEntityURI.getId()), 6, 4);
        short s = this.listener.queryFilterLevel(traceEntityURI);
        String string3 = StringUtils.padString(TraceLevels.levelNames[s], 5, 4);
        return new StringBuffer().append(string).append("  ").append(string2).append("  ").append(string3).append("  ").append((String)object).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void listCommand() {
        Object object;
        System.out.println("Entity List:");
        ArrayList arrayList = new ArrayList();
        Object object2 = this.keyMap;
        synchronized (object2) {
            object = this.keyMap.keySet().iterator();
            while (object.hasNext()) {
                TraceEntityURI traceEntityURI = (TraceEntityURI)object.next();
                String string = this.formatEntry(traceEntityURI);
                arrayList.add(string);
            }
        }
        Collections.sort(arrayList);
        object2 = arrayList.listIterator();
        while (object2.hasNext()) {
            object = (String)object2.next();
            System.out.println((String)object);
        }
        System.out.println(new StringBuffer().append(arrayList.size()).append(" total entities").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TraceEntityURI parseName(short s, String string) {
        Map map = this.keyMap;
        synchronized (map) {
            Iterator iterator = this.keyMap.keySet().iterator();
            while (iterator.hasNext()) {
                TraceEntityURI traceEntityURI = (TraceEntityURI)iterator.next();
                TraceEntity traceEntity = (TraceEntity)this.keyMap.get(traceEntityURI);
                String string2 = traceEntity.getPath(false);
                if (!string.equals(string2) || s != traceEntityURI.getType()) continue;
                return traceEntityURI;
            }
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private TraceEntityURI parseNameOrId(short s, String string) {
        try {
            Map map = this.keyMap;
            synchronized (map) {
                int n = Integer.parseInt(string);
                Iterator iterator = this.keyMap.keySet().iterator();
                while (iterator.hasNext()) {
                    TraceEntityURI traceEntityURI = (TraceEntityURI)iterator.next();
                    if (traceEntityURI.getType() != s || n != traceEntityURI.getId()) continue;
                    return traceEntityURI;
                }
            }
            return null;
        }
        catch (NumberFormatException numberFormatException) {
            return this.parseName(s, string);
        }
    }

    private Short parseTraceLevel(String string) {
        String string2 = string.toLowerCase();
        for (short s = 0; s < TraceLevels.levelNames.length; s = (short)(s + 1)) {
            if (!string2.equals(TraceLevels.levelNames[s].toLowerCase())) continue;
            return new Short(s);
        }
        return null;
    }

    private Short parseEntityType(String string) {
        String string2 = string.toLowerCase();
        for (short s = 0; s < TraceEntityType.names.length; s = (short)(s + 1)) {
            if (!string2.equals(TraceEntityType.names[s].toLowerCase())) continue;
            return new Short(s);
        }
        return null;
    }

    private void traceLevelCommand(short s, String[] stringArray) {
        if (stringArray.length == 2) {
            TraceEntityURI traceEntityURI = this.parseNameOrId(s, stringArray[1]);
            if (traceEntityURI == null) {
                System.out.println(new StringBuffer().append("Unkown name or id in query: ").append(stringArray[1]).toString());
            } else {
                String string = this.formatEntry(traceEntityURI);
                System.out.println(string);
            }
        } else if (stringArray.length == 3) {
            TraceEntityURI traceEntityURI = this.parseNameOrId(s, stringArray[1]);
            if (traceEntityURI == null) {
                System.out.println(new StringBuffer().append("Unkown name or id in set: ").append(stringArray[1]).toString());
            } else {
                Short s2 = this.parseTraceLevel(stringArray[2]);
                if (s2 != null) {
                    short s3 = s2;
                    this.listener.triggerRequestFilterLevel(traceEntityURI, s3);
                } else {
                    System.out.println(new StringBuffer().append("Unknown filter level: ").append(stringArray[2]).toString());
                }
            }
        } else {
            System.out.println(new StringBuffer().append("Usage: ").append(TraceEntityType.names[s]).append(" <name|id> [level]").toString());
        }
    }

    private void callCommand(String[] stringArray) {
        if (stringArray.length > 1) {
            TraceEntityURI traceEntityURI = this.parseNameOrId((short)4, stringArray[1]);
            if (traceEntityURI != null) {
                byte[] byArray = null;
                if (stringArray.length > 2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 2; i2 < stringArray.length; ++i2) {
                        stringBuffer.append(stringArray[i2]);
                        if (i2 >= stringArray.length - 1) continue;
                        stringBuffer.append(' ');
                    }
                    String string = stringBuffer.toString();
                    try {
                        byArray = StringConverter.UTF8.getBytes(string);
                    }
                    catch (UnsupportedEncodingException unsupportedEncodingException) {
                        System.out.println(new StringBuffer().append("calling ").append(traceEntityURI).append(" with ").append(string).append(" failed, ").append(unsupportedEncodingException.getMessage()).toString());
                        return;
                    }
                    System.out.println(new StringBuffer().append("calling ").append(traceEntityURI).append(" with ").append(string).toString());
                } else {
                    System.out.println(new StringBuffer().append("calling ").append(traceEntityURI).toString());
                }
                this.listener.triggerExecuteCallback(traceEntityURI.getId(), byArray);
            } else {
                System.out.println(new StringBuffer().append("Unknown callback: ").append(stringArray[1]).toString());
            }
        } else {
            System.out.println("Usage: <callback name|id> [parameters]");
        }
    }

    private void fileTransferCommandGet(String[] stringArray) {
        if (this.fileTransferManager != null) {
            if (stringArray.length == 2) {
                String string = this.fileTransferManager.getDownloadDirectory();
                String string2 = new StringBuffer().append("incomplete_").append(FileTransferUtils.getFileNameFromPath(stringArray[1])).toString();
                RealTransferFile realTransferFile = new RealTransferFile(new StringBuffer().append(string).append(string2).toString());
                this.fileTransferManager.requestFileDownload(stringArray[1], realTransferFile);
            } else {
                System.out.println("Usage: <remotefilepath> ");
            }
        } else {
            System.out.println("Could not found FileTransferManager, commando skipped.");
        }
    }

    private void fileTransferCommandStat(String[] stringArray) {
        if (this.fileTransferManager != null) {
            if (stringArray.length == 2) {
                MemoryTransferFile memoryTransferFile = new MemoryTransferFile("temp");
                this.fileTransferManager.requestFileStatus(stringArray[1], memoryTransferFile);
            } else {
                System.out.println("Usage: <filepath>");
            }
        } else {
            System.out.println("Could not found FileTransferManager, commando skipped.");
        }
    }

    private void fileTransferCommandPut(String[] stringArray) {
        if (this.fileTransferManager != null) {
            if (stringArray.length == 2) {
                try {
                    String string = stringArray[1];
                    RealTransferFile realTransferFile = new RealTransferFile(string);
                    this.fileTransferManager.uploadFile(realTransferFile);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                System.out.println("Usage: <filepath>");
            }
        } else {
            System.out.println("Could not found FileTransferManager, commando skipped.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void waitCommand(String[] stringArray) {
        if (stringArray.length > 2) {
            TraceEntityURI traceEntityURI;
            String string = stringArray[1];
            Short s = this.parseEntityType(string);
            if (s == null) {
                System.out.println(new StringBuffer().append("Invalid type: ").append(string).toString());
                return;
            }
            short s2 = s;
            String string2 = stringArray[2];
            int n = 5000;
            if (stringArray.length > 3) {
                n = Integer.parseInt(stringArray[3]);
            }
            System.out.println(new StringBuffer().append("looking for ").append(string).append(" '").append(string2).append("' with timeout: ").append(n).append("ms").toString());
            Object object = this.waitForLock;
            synchronized (object) {
                traceEntityURI = this.parseNameOrId(s2, string2);
                if (traceEntityURI == null) {
                    this.waitForEntity = null;
                    this.waitForName = string2;
                    this.waitForType = s2;
                    for (int i2 = 0; i2 < n; i2 += 100) {
                        try {
                            this.waitForLock.wait(0);
                            continue;
                        }
                        catch (InterruptedException interruptedException) {
                            break;
                        }
                    }
                    if (this.waitForEntity != null) {
                        traceEntityURI = this.waitForEntity;
                        this.waitForEntity = null;
                        this.waitForName = null;
                    }
                }
            }
            if (traceEntityURI != null) {
                System.out.println(new StringBuffer().append("found: ").append(traceEntityURI).toString());
            } else {
                System.out.println(new StringBuffer().append("not found: ").append(string2).toString());
            }
        } else {
            System.out.println("Usage: <type> <name|id> [timeout]");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startCommand(String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[1];
            Writer writer = null;
            try {
                writer = new OutputStreamWriter(new FileOutputStream(string), "UTF-8");
                this.logFileMap.put(string, writer);
            }
            catch (IOException iOException) {
                System.out.println(new StringBuffer().append("Error opening log file '").append(string).append("': ").append(iOException).toString());
            }
            finally {
                if (writer != null) {
                    try {
                        writer.close();
                    }
                    catch (IOException iOException) {}
                }
            }
        } else {
            System.out.println("Usage: <filename>");
        }
    }

    private void stopCommand(String[] stringArray) {
        if (stringArray.length == 1) {
            Iterator iterator = this.logFileMap.keySet().iterator();
            while (iterator.hasNext()) {
                String string = (String)iterator.next();
                FileWriter fileWriter = (FileWriter)this.logFileMap.get(string);
                try {
                    fileWriter.close();
                    System.out.println(new StringBuffer().append(string).append(" closed").toString());
                }
                catch (IOException iOException) {}
            }
            this.logFileMap.clear();
        } else if (stringArray.length == 2) {
            String string = stringArray[1];
            FileWriter fileWriter = (FileWriter)this.logFileMap.get(string);
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                    System.out.println(new StringBuffer().append(string).append(" closed").toString());
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                this.logFileMap.remove(string);
            } else {
                System.out.println(new StringBuffer().append("Log file '").append(string).append("' not found!").toString());
            }
        } else {
            System.out.println("Usage: [filename]");
        }
    }

    private void quitCommand() {
        System.out.println("Request quit.");
        this.listener.requestQuit();
    }

    private void statCommand(String[] stringArray) {
        if (stringArray.length == 2) {
            String string = stringArray[1];
            if (string.equals("start")) {
                this.doStatistics = true;
                this.resetStatistics();
            } else if (string.equals("stop")) {
                this.doStatistics = false;
                this.printStatistics();
            }
        } else {
            System.out.println("Usage: start|stop");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

