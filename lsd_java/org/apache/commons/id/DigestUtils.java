/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.id.Hex;

public class DigestUtils {
    static MessageDigest getDigest(String string) {
        try {
            return MessageDigest.getInstance(string);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException.getMessage());
        }
    }

    private static MessageDigest getMd5Digest() {
        return DigestUtils.getDigest("MD5");
    }

    private static MessageDigest getShaDigest() {
        return DigestUtils.getDigest("SHA");
    }

    public static byte[] md5(byte[] byArray) {
        return DigestUtils.getMd5Digest().digest(byArray);
    }

    public static byte[] md5(String string) {
        return DigestUtils.md5(string.getBytes());
    }

    public static String md5Hex(byte[] byArray) {
        return new String(Hex.encodeHex(DigestUtils.md5(byArray)));
    }

    public static String md5Hex(String string) {
        return new String(Hex.encodeHex(DigestUtils.md5(string)));
    }

    public static byte[] sha(byte[] byArray) {
        return DigestUtils.getShaDigest().digest(byArray);
    }

    public static byte[] sha(String string) {
        return DigestUtils.sha(string.getBytes());
    }

    public static String shaHex(byte[] byArray) {
        return new String(Hex.encodeHex(DigestUtils.sha(byArray)));
    }

    public static String shaHex(String string) {
        return new String(Hex.encodeHex(DigestUtils.sha(string)));
    }
}

