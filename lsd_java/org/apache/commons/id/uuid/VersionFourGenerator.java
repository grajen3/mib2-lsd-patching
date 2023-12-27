/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;
import org.apache.commons.id.IdentifierGenerator;
import org.apache.commons.id.uuid.Constants;
import org.apache.commons.id.uuid.UUID;

public final class VersionFourGenerator
implements IdentifierGenerator,
Constants {
    private static final Random regularRandom = new Random();
    private static Random secureRandom;
    private static String usePRNG;
    private static String usePRNGPackage;
    private static VersionFourGenerator generator;

    public static VersionFourGenerator getInstance() {
        if (generator == null) {
            generator = new VersionFourGenerator();
        }
        return generator;
    }

    @Override
    public Object nextIdentifier() {
        return this.nextUUID(false);
    }

    public Object nextIdentifier(boolean bl) {
        return this.nextUUID(bl);
    }

    public UUID nextUUID() {
        return this.nextUUID(false);
    }

    private UUID nextUUID(boolean bl) {
        byte[] byArray = new byte[16];
        if (bl) {
            if (secureRandom == null) {
                try {
                    secureRandom = usePRNGPackage != null ? SecureRandom.getInstance(usePRNG, usePRNGPackage) : SecureRandom.getInstance(usePRNG);
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    bl = false;
                }
                catch (NoSuchProviderException noSuchProviderException) {
                    bl = false;
                }
            }
            if (secureRandom != null) {
                secureRandom.nextBytes(byArray);
            }
        } else {
            regularRandom.nextBytes(byArray);
        }
        byArray[6] = (byte)(byArray[6] & 0xF);
        byArray[6] = (byte)(byArray[6] | 0x40);
        byArray[8] = (byte)(byArray[8] & 0x3F);
        byArray[8] = (byte)(byArray[8] | 0x80);
        return new UUID(byArray);
    }

    public static void setPRNGProvider(String string, String string2) {
        usePRNG = string;
        usePRNGPackage = string2;
        secureRandom = null;
    }

    static {
        usePRNG = "SHA1PRNG";
        usePRNGPackage = "SUN";
    }
}

