/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.ITraceClient;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.TraceChannelList;
import de.esolutions.fw.util.tracing.TraceClient$ChannelCompare;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.frontend.FrontendThreadEntityCreator;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.ParameterTraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessage;
import de.esolutions.fw.util.tracing.util.ThreadCache;
import de.esolutions.fw.util.tracing.util.ThreadCache$Info;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class TraceClient
implements ITraceFrontendListener,
ITraceClient {
    private static TraceClient theTraceClient;
    private static int startCount;
    private static Object globalLock;
    private static final String chn;
    private final TraceFrontend frontend;
    private final boolean keepMessagePrefix;
    private TraceChannel rootChannel = new TraceChannel("", 7, null);
    private ThreadCache threadCache;
    private Map callbacks;

    public static void init(String string) {
        TraceClient.init(string, "client", true);
    }

    public static void init(String string, String string2, boolean bl) {
        TraceMe.init();
        TraceClient.init(TraceFrontend.getDefaultConfig(string, string2, bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void init(TraceConfig traceConfig) {
        TraceMe.init();
        TraceMe.msg(TraceMe.INFO, "Client", "+ TraceClient init");
        Object object = globalLock;
        synchronized (object) {
            if (startCount == 0) {
                TraceFrontend.init(traceConfig);
                TraceFrontend traceFrontend = TraceFrontend.getTraceFrontend();
                if (traceFrontend != null) {
                    theTraceClient = new TraceClient(traceFrontend);
                    TraceChannelList traceChannelList = TraceChannelList.getInstance();
                    TraceChannel[] traceChannelArray = traceChannelList.getAllChannels();
                    theTraceClient.setupChannels(traceChannelArray);
                    traceChannelList.setClient(theTraceClient);
                    theTraceClient.start();
                } else {
                    TraceMe.msg(TraceMe.INFO, "Client", "TraceClient disabled");
                }
            }
            ++startCount;
        }
        TraceMe.msg(TraceMe.INFO, "Client", "- TraceClient init");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void exit() {
        TraceMe.msg(TraceMe.INFO, "Client", "+ TraceClient exit");
        Object object = globalLock;
        synchronized (object) {
            if (--startCount == 0) {
                if (theTraceClient != null) {
                    TraceChannelList.getInstance().setClient(null);
                    theTraceClient.stop();
                    theTraceClient = null;
                }
                TraceFrontend.exit();
            }
        }
        TraceMe.msg(TraceMe.INFO, "Client", "- TraceClient exit");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TraceClient getTraceClient() {
        Object object = globalLock;
        synchronized (object) {
            return theTraceClient;
        }
    }

    public static TraceFrontend getTraceFrontend() {
        return TraceFrontend.getTraceFrontend();
    }

    public static TraceConfig getTraceConfig() {
        return TraceFrontend.getTraceConfig();
    }

    public static TraceChannel createTraceChannel(String string) {
        return new TraceChannel(string);
    }

    public static TraceChannel createTraceChannel(String string, short s) {
        return new TraceChannel(string, s);
    }

    public static void disableTraceChannel(TraceChannel traceChannel) {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.disableChannel(traceChannel);
        }
    }

    public static void enableTraceChannel(TraceChannel traceChannel) {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.enableChannel(traceChannel);
        }
    }

    public static int registerTraceCallback(String string, ITraceCallback iTraceCallback) {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            return traceClient.registerCallback(string, iTraceCallback);
        }
        return -1;
    }

    public static void unregisterTraceCallback(int n) {
        TraceClient traceClient = TraceClient.getTraceClient();
        if (traceClient != null) {
            traceClient.unregisterCallback(n);
        }
    }

    public TraceClient(TraceFrontend traceFrontend) {
        this.frontend = traceFrontend;
        traceFrontend.registerListener(this);
        this.threadCache = new ThreadCache(new FrontendThreadEntityCreator(traceFrontend));
        this.callbacks = new HashMap();
        this.keepMessagePrefix = !traceFrontend.getConfig().getOmitMessagePrefix();
    }

    public ThreadCache getThreadCache() {
        return this.threadCache;
    }

    public void start() {
        this.frontend.start();
    }

    public boolean isRunning() {
        return this.frontend.isRunning();
    }

    public void stop() {
        this.frontend.stop();
        this.shutdown();
    }

    private void shutdown() {
        this.frontend.unregisterListener(this);
        this.detachEntityFromChannel(this.rootChannel, true);
        this.threadCache = null;
    }

    public TraceFrontend getFrontend() {
        return this.frontend;
    }

    public void setupChannels(TraceChannel[] traceChannelArray) {
        TraceMe.msg(TraceMe.TRACE, "Client", "  + setupChannels");
        Arrays.sort(traceChannelArray, new TraceClient$ChannelCompare(null));
        for (int i2 = 0; i2 < traceChannelArray.length; ++i2) {
            TraceChannel traceChannel = traceChannelArray[i2];
            TraceMe.msg(TraceMe.DEBUG, "Client", "  path=%1", traceChannel.getPath());
            String[] stringArray = this.splitPathName(traceChannel.getPath());
            if (stringArray == null) continue;
            TraceMe.msg(TraceMe.DEBUG, "Client", "    create missing nodes for '%1'", traceChannel.getPath());
            this.createMissingChannelNodes(this.rootChannel, stringArray, 0, traceChannel);
        }
        this.attachEntityToChannel(this.rootChannel, true);
        TraceMe.msg(TraceMe.TRACE, "Client", "  - setupChannels");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean registerChannel(TraceChannel traceChannel) {
        TraceChannel traceChannel2 = traceChannel;
        synchronized (traceChannel2) {
            String[] stringArray = this.splitPathName(traceChannel.getPath());
            if (stringArray == null) {
                return false;
            }
            traceChannel.addFlags(4);
            if (!this.createMissingChannelNodes(this.rootChannel, stringArray, 0, traceChannel)) {
                return false;
            }
            TraceChannel traceChannel3 = this.rootChannel;
            for (int i2 = 0; i2 <= stringArray.length && (traceChannel3.getChannelId() != -1 || this.attachEntityToChannel(traceChannel3, false)) && i2 != stringArray.length && (traceChannel3 = traceChannel3.findChild(stringArray[i2])) != null; ++i2) {
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean unregisterChannel(TraceChannel traceChannel) {
        TraceChannel traceChannel2 = traceChannel;
        synchronized (traceChannel2) {
            String[] stringArray = this.splitPathName(traceChannel.getPath());
            if (stringArray == null) {
                return false;
            }
            TraceChannel traceChannel3 = traceChannel;
            for (int i2 = stringArray.length; i2 >= 0; --i2) {
                TraceChannel traceChannel4 = traceChannel3.getParent();
                traceChannel4.removeChild(traceChannel3);
                this.detachEntityFromChannel(traceChannel3, false);
                if (traceChannel4.getNumChildren() > 0 || !traceChannel4.hasFlags(1)) break;
                traceChannel3 = traceChannel4;
            }
        }
        return true;
    }

    private boolean attachEntityToChannel(TraceChannel traceChannel, boolean bl) {
        ArrayList arrayList;
        int n;
        TraceEntityURIWithLevel traceEntityURIWithLevel;
        short s = traceChannel.getFilterLevel();
        TraceChannel traceChannel2 = traceChannel.getParent();
        if (traceChannel2 == null) {
            traceEntityURIWithLevel = this.frontend.getRootEntity((short)3);
        } else {
            n = traceChannel2 != null ? traceChannel2.getChannelId() : -1;
            TraceEntityURI traceEntityURI = new TraceEntityURI(3, n);
            traceEntityURIWithLevel = this.frontend.createEntity((short)3, traceChannel.getName(), s, n != -1 ? traceEntityURI : null);
        }
        if (traceEntityURIWithLevel == null) {
            return false;
        }
        n = traceEntityURIWithLevel.getId();
        short s2 = traceEntityURIWithLevel.getLevel();
        TraceMe.msg(TraceMe.DEBUG, "Client", "    attach channel to entity '%1' -> id=%2 level=%3 was initial level=%4", traceChannel.getPath(), new Integer(n), TraceLevels.levelNames[s2], TraceLevels.levelNames[s]);
        if (n == -1) {
            s2 = 6;
        }
        traceChannel.bind(this, n, s2);
        if (n != -1 && bl && (arrayList = traceChannel.getAllChildren()) != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                TraceChannel traceChannel3 = (TraceChannel)arrayList.get(i2);
                if (this.attachEntityToChannel(traceChannel3, true)) continue;
                return false;
            }
        }
        return n != -1;
    }

    private void detachEntityFromChannel(TraceChannel traceChannel, boolean bl) {
        int n;
        ArrayList arrayList;
        if (bl && (arrayList = traceChannel.getAllChildren()) != null) {
            for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                TraceChannel traceChannel2 = (TraceChannel)arrayList.get(i2);
                this.detachEntityFromChannel(traceChannel2, true);
            }
        }
        if ((n = traceChannel.getChannelId()) != -1) {
            TraceMe.msg(TraceMe.DEBUG, "Client", "    detach channel from entity '%1', id=%2 level=%3", traceChannel.getPath(), new Integer(n), TraceLevels.levelNames[traceChannel.getFilterLevel()]);
            this.frontend.disableChannel(n);
            traceChannel.detachParentAndChildren();
        }
        traceChannel.unbind();
    }

    private boolean createMissingChannelNodes(TraceChannel traceChannel, String[] stringArray, int n, TraceChannel traceChannel2) {
        String string = stringArray[n];
        TraceChannel traceChannel3 = traceChannel.findChild(string);
        if (stringArray.length - 1 == n) {
            ArrayList arrayList = null;
            if (traceChannel3 != null) {
                if (!traceChannel3.hasFlags(1) && traceChannel3 != traceChannel2) {
                    TraceMe.msg(TraceMe.WARN, "Client", "IGNORING DUPLICATE CHANNEL: %1", traceChannel3.getPath());
                    return false;
                }
                traceChannel.removeChild(traceChannel3);
                arrayList = traceChannel3.getAllChildren();
            }
            traceChannel.addChild(traceChannel2);
            traceChannel2.setParent(traceChannel);
            traceChannel2.setName(string);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    TraceChannel traceChannel4 = (TraceChannel)arrayList.get(i2);
                    traceChannel2.addChild(traceChannel4);
                    traceChannel4.setParent(traceChannel2);
                }
            }
            return true;
        }
        if (traceChannel3 == null) {
            traceChannel3 = new TraceChannel(string, 7, traceChannel);
            traceChannel3.addFlags(1);
            traceChannel.addChild(traceChannel3);
            traceChannel3.determinePathString();
            TraceMe.msg(TraceMe.DEBUG, "Client", "      created missing channel '%1'", traceChannel3.getPath());
        }
        return this.createMissingChannelNodes(traceChannel3, stringArray, n + 1, traceChannel2);
    }

    private String[] splitPathName(String string) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean disableChannel(TraceChannel traceChannel) {
        if (traceChannel == null) {
            return false;
        }
        TraceChannel traceChannel2 = traceChannel;
        synchronized (traceChannel2) {
            boolean bl = false;
            int n = traceChannel.getChannelId();
            if (n != -1) {
                bl = this.frontend.disableChannel(n);
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean enableChannel(TraceChannel traceChannel) {
        if (traceChannel == null) {
            return false;
        }
        TraceChannel traceChannel2 = traceChannel;
        synchronized (traceChannel2) {
            boolean bl = false;
            int n = traceChannel.getChannelId();
            if (n != -1) {
                bl = this.frontend.enableChannel(n);
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean changeChannelFilterLevel(TraceChannel traceChannel, short s) {
        if (traceChannel == null) {
            return false;
        }
        TraceChannel traceChannel2 = traceChannel;
        synchronized (traceChannel2) {
            traceChannel.setFilterLevel(s);
            boolean bl = false;
            int n = traceChannel.getChannelId();
            if (n != -1) {
                bl = this.frontend.changeFilterLevel(new TraceEntityURI(3, n), s);
            }
            return bl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int registerCallback(String string, ITraceCallback iTraceCallback) {
        int n = this.frontend.createCallback(string);
        if (n == -1) {
            return -1;
        }
        Map map = this.callbacks;
        synchronized (map) {
            this.callbacks.put(new Integer(n), iTraceCallback);
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean unregisterCallback(int n) {
        if (n == -1) {
            return false;
        }
        Map map = this.callbacks;
        synchronized (map) {
            this.callbacks.remove(new Integer(n));
        }
        this.frontend.disableCallback(n);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean logMessage(TraceChannel traceChannel, short s, short s2, String string, Object[] objectArray) {
        long l = System.currentTimeMillis();
        Thread thread = Thread.currentThread();
        ThreadCache$Info threadCache$Info = this.threadCache.getThreadInfo(thread);
        if (threadCache$Info == null) {
            return false;
        }
        int n = threadCache$Info.id;
        if (this.keepMessagePrefix && threadCache$Info.msgPrefix != null) {
            string = new StringBuffer().append(string).append(threadCache$Info.msgPrefix).toString();
        }
        int n2 = -1;
        Object object = traceChannel;
        synchronized (object) {
            n2 = traceChannel.getChannelId();
        }
        if (n == -1 || n2 == -1) {
            return false;
        }
        object = new ParameterTraceMessage(l, n2, n, s, s2, string, objectArray);
        return this.frontend.log((ITraceMessage)object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean logMessage(TraceChannel traceChannel, short s, short s2, short s3, byte[] byArray) {
        long l = System.currentTimeMillis();
        Thread thread = Thread.currentThread();
        ThreadCache$Info threadCache$Info = this.threadCache.getThreadInfo(thread);
        if (threadCache$Info == null) {
            return false;
        }
        int n = threadCache$Info.id;
        int n2 = -1;
        Object object = traceChannel;
        synchronized (object) {
            n2 = traceChannel.getChannelId();
        }
        if (n == -1 || n2 == -1) {
            return false;
        }
        object = new TraceMessage(l, n2, n, s, s2, s3, byArray);
        return this.frontend.log((ITraceMessage)object);
    }

    public void emergencyLog(String string) {
        this.frontend.emergencyLog(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void executeCallback(int n, byte[] byArray) {
        ITraceCallback iTraceCallback;
        Map map = this.callbacks;
        synchronized (map) {
            iTraceCallback = (ITraceCallback)this.callbacks.get(new Integer(n));
        }
        if (iTraceCallback != null) {
            TraceMe.msg(TraceMe.DEBUG, "Client", "  client: executing callback");
            iTraceCallback.executeTraceCallback(n, byArray);
        } else {
            TraceMe.msg(TraceMe.WARN, "Client", "  client: callback NOT FOUND: %1", new Integer(n));
        }
    }

    @Override
    public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
        TraceChannel traceChannel;
        if (traceEntityURI.getType() == 3 && (traceChannel = this.rootChannel.findByChannelId(traceEntityURI.getId())) != null) {
            TraceMe.msg(TraceMe.DEBUG, "Client", "  client: realize filter level request of %1 to level %2", traceChannel.getPath(), TraceLevels.levelNames[s]);
            this.changeChannelFilterLevel(traceChannel, s);
        }
    }

    @Override
    public void requestQuit() {
    }

    static {
        startCount = 0;
        globalLock = new Object();
    }
}

