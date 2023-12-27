/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.codec.CheckSumBuilder;
import de.vw.mib.debugmanager.internal.LegacyBinaryMessageHeaderCodec$LegacyCodecListener;

final class LegacyBinaryMessageHeaderCodec {
    private static final int HEADER_LENGTH;
    private static final int DATACHANNEL_VERSION;
    private static final int DATACHANNEL_VERSION_IDX;
    private static final int DATACHANNEL_TYPE_IDX;
    private static final int HASH_CODE_1;
    private static final int HASH_CODE_2;
    private static final int HASH_CODE_3;
    private static final int HASH_CODE_4;
    static final int MAX_MESSAGE_LENGTH;
    static final int MAX_BODY_LENGTH;
    static final int PART_ID;
    private byte[] composedMessage;
    private int composedMessageHashCode;
    private int firstIndexOfNextPart;
    private boolean recomposing = false;
    private final LegacyBinaryMessageHeaderCodec$LegacyCodecListener listener;

    LegacyBinaryMessageHeaderCodec(LegacyBinaryMessageHeaderCodec$LegacyCodecListener legacyBinaryMessageHeaderCodec$LegacyCodecListener) {
        this.listener = legacyBinaryMessageHeaderCodec$LegacyCodecListener;
    }

    void readBinaryMessage(short s, byte[] byArray, int n, int n2) {
        if (n2 < 5) {
            this.listener.corruptedDataReceived(s, new StringBuffer().append("the message content is smaller than the minimum length - content.length=").append(byArray.length).append(",  startIndex=").append(n).append(", lengthToRead=").append(n2).toString());
            return;
        }
        if (byArray.length < n + n2) {
            this.listener.corruptedDataReceived(s, new StringBuffer().append("the message content is smaller than expected - content.length=").append(byArray.length).append(",  startIndex=").append(n).append(", lengthToRead=").append(n2).toString());
            return;
        }
        byte by = byArray[n + 0];
        int n3 = this.getHashCodeFromHeader(byArray, n);
        if (this.recomposing) {
            if (this.composedMessageHashCode != n3 && n3 != 0) {
                this.listener.corruptedDataReceived(s, new StringBuffer().append("hash code of this message part doesn't match to hash code of first message part! - content.length=").append(byArray.length).append(",  header+start=").append(5 + n).append(", maxbodylength=").append(995).append(", partId=").append(by).toString());
                this.recomposing = false;
                return;
            }
            if (by > 0) {
                if (byArray.length < 5 + n + 995) {
                    this.listener.corruptedDataReceived(s, new StringBuffer().append("the message content is smaller than expected - content.length=").append(byArray.length).append(",  header+start=").append(5 + n).append(", maxbodylength=").append(995).append(", partId=").append(by).toString());
                    this.recomposing = false;
                    return;
                }
                if (this.composedMessage.length < this.firstIndexOfNextPart + 995) {
                    this.listener.corruptedDataReceived(s, new StringBuffer().append("the length of the composed message is greater than expected (more message parts received than expected or wrong message part order) - partId=").append(by).toString());
                    this.recomposing = false;
                    return;
                }
                System.arraycopy((Object)byArray, 5 + n, (Object)this.composedMessage, this.firstIndexOfNextPart, 995);
                this.firstIndexOfNextPart += 995;
            } else {
                this.recomposing = false;
                if (byArray.length < 5 + n + 995) {
                    this.listener.corruptedDataReceived(s, new StringBuffer().append("the message content is smaller than expected - content.length=").append(byArray.length).append(",  header+start=").append(5 + n).append(", maxbodylength=").append(995).append(", partId=").append(by).toString());
                    return;
                }
                if (this.composedMessage.length < this.firstIndexOfNextPart + 995) {
                    this.listener.corruptedDataReceived(s, new StringBuffer().append("the length of the composed message is greater than expected (more message parts received than expected or wrong message part order) - partId=").append(by).toString());
                    this.recomposing = false;
                    return;
                }
                System.arraycopy((Object)byArray, 5 + n, (Object)this.composedMessage, this.firstIndexOfNextPart, 995);
                int n4 = this.calcHash(this.composedMessage, 5, this.composedMessage.length - 5);
                if (n4 != n3 && n3 != 0) {
                    this.listener.corruptedDataReceived(s, new StringBuffer().append("the calculated hash code of this composed message doesn't match to hash code read from the message header! - content.length=").append(byArray.length).append(",  header+start=").append(5 + n).append(", maxbodylength=").append(995).append(", partId=").append(by).toString());
                    return;
                }
                this.onMessageDecoded(s, this.composedMessage, 5, this.composedMessage.length - 5);
            }
        } else if (by > 0) {
            int n5 = n2 + by * 995;
            this.composedMessage = new byte[n5];
            this.firstIndexOfNextPart = n2;
            this.composedMessageHashCode = n3;
            System.arraycopy((Object)byArray, n, (Object)this.composedMessage, 0, n2);
            this.recomposing = true;
        } else {
            int n6 = this.calcHash(byArray, 5 + n, n2 - 5);
            if (n3 != n6 && n3 != 0) {
                this.listener.corruptedDataReceived(s, new StringBuffer().append("content of single part message doesn't match to hash code read from the message header! - content.length=").append(byArray.length).append(",  header+start=").append(5 + n).append(", maxbodylength=").append(995).append(", partId=").append(by).toString());
                return;
            }
            this.onMessageDecoded(s, byArray, 5 + n, n2 - 5);
        }
    }

    void writeBinaryMessage(long l, short s, byte[] byArray, int n) {
        if (n < 5) {
            return;
        }
        if (n > 1000) {
            int n2 = (n - 5) / 995;
            int n3 = (n - 5) % 995 + 5;
            this.setHashCodeToHeader(byArray, this.calcHash(byArray, 5, n - 5));
            if (n3 > 5) {
                byArray[0] = (byte)n2;
                this.writeToDebugSpi(l, s, byArray, n3);
            }
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                byArray[0] = (byte)i2;
                int n4 = n3 + 995 * (n2 - i2 - 1);
                System.arraycopy((Object)byArray, n4, (Object)byArray, 5, 995);
                this.writeToDebugSpi(l, s, byArray, 1000);
            }
        } else {
            byArray[0] = 0;
            this.setHashCodeToHeader(byArray, this.calcHash(byArray, 5, n - 5));
            this.writeToDebugSpi(l, s, byArray, n);
        }
    }

    int calcHash(byte[] byArray, int n, int n2) {
        return CheckSumBuilder.checkSum(byArray, n, n2);
    }

    void setHashCodeToHeader(byte[] byArray, int n) {
        byArray[1] = (byte)(n >> 24);
        byArray[2] = (byte)(n >> 16);
        byArray[3] = (byte)(n >> 8);
        byArray[4] = (byte)n;
    }

    private int getHashCodeFromHeader(byte[] byArray, int n) {
        int n2 = byArray[n + 1] & 0xFF;
        int n3 = byArray[n + 2] & 0xFF;
        int n4 = byArray[n + 3] & 0xFF;
        int n5 = byArray[n + 4] & 0xFF;
        if ((n2 | n3 | n4 | n5) >= 0) {
            return (n2 << 24) + (n3 << 16) + (n4 << 8) + n5;
        }
        return 0;
    }

    private void onMessageDecoded(short s, byte[] byArray, int n, int n2) {
        if (s == 278 || s == 1) {
            byte by = byArray[5];
            if (-1 != by) {
                this.listener.corruptedDataReceived(s, "Wrong codec version for Datachannel.");
                return;
            }
            this.listener.messageDecoded(byArray[6], byArray, 7, n2 - 2);
        } else {
            this.listener.messageDecoded(s, byArray, 5, n2);
        }
    }

    private void writeToDebugSpi(long l, short s, byte[] byArray, int n) {
        this.listener.messageEncoded(s, byArray, n);
    }
}

