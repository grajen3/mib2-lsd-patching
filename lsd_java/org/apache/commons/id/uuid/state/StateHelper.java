/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.discovery.tools.DiscoverClass
 */
package org.apache.commons.id.uuid.state;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;
import org.apache.commons.discovery.tools.DiscoverClass;
import org.apache.commons.id.DecoderException;
import org.apache.commons.id.DigestUtils;
import org.apache.commons.id.Hex;
import org.apache.commons.id.uuid.Bytes;
import org.apache.commons.id.uuid.Constants;
import org.apache.commons.id.uuid.clock.Clock;
import org.apache.commons.id.uuid.clock.OverClockedException;
import org.apache.commons.id.uuid.state.State;

public final class StateHelper
implements Constants {
    public static final String UUID_CLOCK_IMPL_PROPERTY_KEY = (class$org$apache$commons$id$uuid$clock$Clock == null ? (class$org$apache$commons$id$uuid$clock$Clock = StateHelper.class$("org.apache.commons.id.uuid.clock.Clock")) : class$org$apache$commons$id$uuid$clock$Clock).getName();
    public static final String UUID_STATE_IMPL_PROPERTY_KEY = (class$org$apache$commons$id$uuid$state$State == null ? (class$org$apache$commons$id$uuid$state$State = StateHelper.class$("org.apache.commons.id.uuid.state.State")) : class$org$apache$commons$id$uuid$state$State).getName();
    public static final int NODE_ID_BYTE_LENGTH;
    public static final short BYTES_IN_SHORT;
    public static final short SHIFT_BY_BYTE;
    public static final short HOSTNAME_MAX_CHAR_LEN;
    private static final int MULTICAST_BIT_SET;
    private static final short LONG_CHAR_LEN;
    private static final int BUF_PAGE_SZ;
    protected static final String XML_DOC_START;
    protected static final String XML_DOC_START_END;
    protected static final String XML_NODE_TAG_START;
    protected static final String XML_NODE_TAG_AFTER_ID;
    protected static final String XML_NODE_TAG_AFTER_CSEQ;
    protected static final String XML_NODE_TAG_END;
    protected static final String XML_DOC_END;
    private static final short MAC_ADDRESS_TOKEN_COUNT;
    private static final short MAC_ADDRESS_CHAR_LENGTH;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$clock$Clock;
    static /* synthetic */ Class class$org$apache$commons$id$uuid$state$State;

    private StateHelper() {
    }

    public static byte[] randomNodeIdentifier() {
        Object object;
        byte[] byArray = new byte[16];
        int n = 2341;
        StringBuffer stringBuffer = new StringBuffer(n);
        long l = 0L;
        try {
            l = StateHelper.getClockImpl().getUUIDTime();
        }
        catch (OverClockedException overClockedException) {
            l = System.currentTimeMillis();
        }
        stringBuffer.append(l);
        try {
            object = InetAddress.getLocalHost();
            stringBuffer.append(((InetAddress)object).getHostName());
        }
        catch (UnknownHostException unknownHostException) {
            stringBuffer.append("Host Unknown");
        }
        stringBuffer.append(new Object().hashCode());
        object = System.getProperties().values();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next());
        }
        byArray = DigestUtils.md5(stringBuffer.toString());
        byte[] byArray2 = new byte[6];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, 6);
        byArray2[0] = (byte)(byArray2[0] | 0x80);
        return byArray2;
    }

    public static short newClockSequence() {
        Random random = new Random();
        byte[] byArray = new byte[2];
        random.nextBytes(byArray);
        return (short)(Bytes.toShort(byArray) & 0x3FFF);
    }

    public static Clock getClockImpl() {
        Clock clock = null;
        try {
            DiscoverClass discoverClass = new DiscoverClass();
            clock = (Clock)discoverClass.newInstance(class$org$apache$commons$id$uuid$clock$Clock == null ? (class$org$apache$commons$id$uuid$clock$Clock = StateHelper.class$("org.apache.commons.id.uuid.clock.Clock")) : class$org$apache$commons$id$uuid$clock$Clock, "org.apache.commons.id.uuid.clock.SystemClockImpl");
        }
        catch (Exception exception) {
            // empty catch block
        }
        return clock;
    }

    public static State getStateImpl() {
        State state = null;
        try {
            DiscoverClass discoverClass = new DiscoverClass();
            state = (State)discoverClass.newInstance(class$org$apache$commons$id$uuid$state$State == null ? (class$org$apache$commons$id$uuid$state$State = StateHelper.class$("org.apache.commons.id.uuid.state.State")) : class$org$apache$commons$id$uuid$state$State, "org.apache.commons.id.uuid.state.ReadOnlyResourceStateImpl");
        }
        catch (Exception exception) {
            // empty catch block
        }
        return state;
    }

    public static byte[] decodeMACAddress(String string) {
        StringBuffer stringBuffer = new StringBuffer(12);
        StringTokenizer stringTokenizer = new StringTokenizer(string, "-");
        if (stringTokenizer.countTokens() != 6) {
            return null;
        }
        for (int i2 = 0; i2 < 6; ++i2) {
            stringBuffer.append(stringTokenizer.nextToken());
        }
        try {
            char[] cArray = stringBuffer.toString().toCharArray();
            return Hex.decodeHex(cArray);
        }
        catch (DecoderException decoderException) {
            decoderException.printStackTrace();
            return null;
        }
    }

    public static String encodeMACAddress(byte[] byArray) {
        char[] cArray = Hex.encodeHex(byArray);
        StringBuffer stringBuffer = new StringBuffer(17);
        for (int i2 = 0; i2 < cArray.length; ++i2) {
            stringBuffer.append(cArray[i2]);
            if (i2 == cArray.length - 1 || i2 % 2 == 0) continue;
            stringBuffer.append("-");
        }
        return stringBuffer.toString().toUpperCase();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError(classNotFoundException.getMessage());
        }
    }
}

