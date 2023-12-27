/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

public class SSLProtocol {
    public static final byte[] SSL_PROTOCOL_VERSION;
    public static final String SSL_PROTOCOL_NAME;
    public static final byte ALERT_LEVEL_WARNING;
    public static final byte ALERT_LEVEL_FATAL;
    public static final byte ALERT_CLOSE_NOTIFY;
    public static final byte ALERT_UNEXPECTED_MESSAGE;
    public static final byte ALERT_BAD_RECORD_MAC;
    public static final byte ALERT_DECOMPRESSION_FAILURE;
    public static final byte ALERT_HANDSHAKE_FAILURE;
    public static final byte ALERT_NO_CERTIFICATE;
    public static final byte ALERT_BAD_CERTIFICATE;
    public static final byte ALERT_UNSUPPORTED_CERTIFICATE;
    public static final byte ALERT_CERTIFICATE_REVOKED;
    public static final byte ALERT_CERTIFICATE_EXPIRED;
    public static final byte ALERT_CERTIFICATE_UNKNOWN;
    public static final byte ALERT_ILLEGAL_PARAMETER;
    public static final byte CONTENT_CHANGE_CIPHER_SPEC;
    public static final byte CONTENT_ALERT;
    public static final byte CONTENT_HANDSHAKE;
    public static final byte CONTENT_APPLICATION_DATA;
    private static String[] contentTypeNames;

    static {
        byte[] byArray = new byte[2];
        byArray[0] = 3;
        SSL_PROTOCOL_VERSION = byArray;
        contentTypeNames = new String[]{"CONTENT_CHANGE_CIPHER_SPEC", "CONTENT_ALERT", "CONTENT_HANDSHAKE", "CONTENT_APPLICATION_DATA"};
    }

    public static boolean isValidContentType(byte by) {
        return by >= 20 && by <= 23;
    }

    public static boolean isValidVersion(byte[] byArray) {
        return byArray[0] == 3 || byArray[0] == 2;
    }

    public static String getContentTypeName(byte by) {
        return contentTypeNames[by - 20];
    }

    public static String getAlertName(byte by) {
        switch (by) {
            case 0: {
                return "close_notify";
            }
            case 10: {
                return "unexpected_message";
            }
            case 20: {
                return "bad_record_mac";
            }
            case 30: {
                return "decompression_failure";
            }
            case 40: {
                return "handshake_failure";
            }
            case 41: {
                return "no_certificate";
            }
            case 42: {
                return "bad_certificate";
            }
            case 43: {
                return "unsupported_certificate";
            }
            case 44: {
                return "certificate_revoked";
            }
            case 45: {
                return "certificate_expired";
            }
            case 46: {
                return "certificate_unknown";
            }
            case 47: {
                return "illegal_parameter";
            }
        }
        return "message_unknown";
    }
}

