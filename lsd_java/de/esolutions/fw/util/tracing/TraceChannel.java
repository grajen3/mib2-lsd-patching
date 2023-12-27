/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.commons.tracing.ITraceChannel;
import de.esolutions.fw.util.tracing.ITraceClient;
import de.esolutions.fw.util.tracing.TraceChannelList;
import de.esolutions.fw.util.tracing.TraceLevels;
import java.util.ArrayList;

public final class TraceChannel
implements ITraceChannel {
    private String path;
    private String name;
    private ITraceClient client;
    private short filterLevel;
    private short createFilterLevel;
    private int cid;
    private ArrayList children;
    private TraceChannel parent;
    private int flags;
    public static final int FLAG_INTERNAL;
    public static final int FLAG_REGISTER;
    public static final int FLAG_NO_REGISTER;
    public static final int FLAG_RUNTIME;
    public static final int FLAG_DEFAULT_CHANNEL;
    private static final String chn;

    public TraceChannel(String string) {
        this.init(string, (short)7, null);
    }

    public TraceChannel(String string, short s) {
        this.init(string, s, null);
    }

    public TraceChannel(String string, short s, TraceChannel traceChannel) {
        this.name = string;
        this.filterLevel = s;
        this.cid = -1;
        this.parent = traceChannel;
        this.createFilterLevel = s;
    }

    private void init(String string, short s, TraceChannel traceChannel) {
        this.path = string;
        this.filterLevel = s;
        this.cid = -1;
        this.parent = traceChannel;
        this.createFilterLevel = s;
        TraceMe.msg(TraceMe.DEBUG, "Channel", "creating channel path='%1' level='%2'", string, TraceLevels.levelNames[this.filterLevel]);
        TraceChannelList.getInstance().registerChannel(this);
    }

    public void shutdown() {
        TraceMe.msg(TraceMe.DEBUG, "Channel", "shutdown channel path='%1' level='%2'", this.path, TraceLevels.levelNames[this.filterLevel]);
        TraceChannelList.getInstance().unregisterChannel(this);
    }

    public boolean hasChildren() {
        return this.children != null;
    }

    public int getNumChildren() {
        if (this.children == null) {
            return 0;
        }
        return this.children.size();
    }

    public void addChild(TraceChannel traceChannel) {
        if (this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(traceChannel);
    }

    public void removeChild(TraceChannel traceChannel) {
        if (this.children == null) {
            return;
        }
        this.children.remove(traceChannel);
        if (this.children.isEmpty()) {
            this.children = null;
        }
    }

    public void detachParentAndChildren() {
        this.parent = null;
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                TraceChannel traceChannel = (TraceChannel)this.children.get(i2);
                traceChannel.detachParentAndChildren();
            }
            this.children = null;
        }
    }

    public ArrayList getAllChildren() {
        return this.children;
    }

    public TraceChannel findChild(String string) {
        if (this.children == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.children.size(); ++i2) {
            TraceChannel traceChannel = (TraceChannel)this.children.get(i2);
            if (!traceChannel.getName().equals(string)) continue;
            return traceChannel;
        }
        return null;
    }

    private void fillPathString(Buffer buffer) {
        if (this.parent != null && this.parent.parent != null) {
            this.parent.fillPathString(buffer);
            buffer.append(".");
        }
        buffer.append(this.name);
    }

    public void determinePathString() {
        Buffer buffer = new Buffer();
        this.fillPathString(buffer);
        this.path = buffer.toString();
    }

    public void bind(ITraceClient iTraceClient, int n, short s) {
        this.client = iTraceClient;
        this.cid = n;
        this.filterLevel = s;
        TraceMe.msg(TraceMe.DEBUG, "Channel", "bind channel '%1' level='%2'", this.path, TraceLevels.levelNames[s]);
    }

    public void unbind() {
        this.client = null;
        this.cid = -1;
        this.filterLevel = this.createFilterLevel;
        TraceMe.msg(TraceMe.DEBUG, "Channel", "unbind channel '%1' level='%2'", this.path, TraceLevels.levelNames[this.filterLevel]);
    }

    public boolean isBound() {
        return this.client != null && this.cid != -1;
    }

    public int getChannelId() {
        return this.cid;
    }

    public TraceChannel findByChannelId(int n) {
        if (this.cid == n) {
            return this;
        }
        if (this.children != null) {
            for (int i2 = 0; i2 < this.children.size(); ++i2) {
                TraceChannel traceChannel = (TraceChannel)this.children.get(i2);
                TraceChannel traceChannel2 = traceChannel.findByChannelId(n);
                if (traceChannel2 == null) continue;
                return traceChannel2;
            }
        }
        return null;
    }

    public void setFilterLevel(short s) {
        TraceMe.msg(TraceMe.DEBUG, "Channel", "  channel: <%1>%2 from level=%3 to level=%4", TraceLevels.levelNames[this.filterLevel], TraceLevels.levelNames[s], this.path, new Integer(this.cid), TraceLevels.levelNames[this.filterLevel]);
        this.filterLevel = s;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public String getPath() {
        return this.path;
    }

    public short getFilterLevel() {
        return this.filterLevel;
    }

    public TraceChannel getParent() {
        return this.parent;
    }

    public void setParent(TraceChannel traceChannel) {
        this.parent = traceChannel;
    }

    public ITraceClient getClient() {
        return this.client;
    }

    public short getValidFilterLevelAlongPath() {
        for (TraceChannel traceChannel = this; traceChannel != null; traceChannel = traceChannel.getParent()) {
            short s = traceChannel.getFilterLevel();
            if (s == 7) continue;
            return s;
        }
        return 7;
    }

    public boolean disable() {
        if (this.client != null) {
            return this.client.disableChannel(this);
        }
        return false;
    }

    public boolean enable() {
        if (this.client != null) {
            return this.client.enableChannel(this);
        }
        return false;
    }

    public boolean changeFilterLevel(short s) {
        if (this.client != null) {
            return this.client.changeChannelFilterLevel(this, s);
        }
        return false;
    }

    public boolean hasFlags(int n) {
        return (this.flags & n) == n;
    }

    public void addFlags(int n) {
        this.flags |= n;
    }

    public void clrFlags(int n) {
        this.flags &= ~n;
    }

    @Override
    public boolean log(short s, short s2, short s3, byte[] byArray) {
        if (this.filterLevel <= s) {
            return this.client.logMessage(this, s, s2, s3, byArray);
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, byte[] byArray) {
        if (this.filterLevel <= s) {
            return this.client.logMessage(this, s, (short)0, s2, byArray);
        }
        return false;
    }

    @Override
    public boolean log(short s, String string) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, null);
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12, object13});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12, object13, object14});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object object13, Object object14, Object object15) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11, object12, object13, object14, object15});
        }
        return false;
    }

    @Override
    public boolean log(short s, String string, Object[] objectArray) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, string, objectArray);
        }
        return false;
    }

    protected boolean logMessage(short s, String string, Object[] objectArray) {
        if (this.client != null) {
            return this.client.logMessage(this, s, (short)0, string, objectArray);
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, null);
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5, object6});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5, object6, object7});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10});
        }
        return false;
    }

    @Override
    public boolean log(short s, short s2, String string, Object[] objectArray) {
        if (this.filterLevel <= s) {
            return this.logMessage(s, s2, string, objectArray);
        }
        return false;
    }

    protected boolean logMessage(short s, short s2, String string, Object[] objectArray) {
        if (this.client != null) {
            return this.client.logMessage(this, s, s2, string, objectArray);
        }
        return false;
    }
}

