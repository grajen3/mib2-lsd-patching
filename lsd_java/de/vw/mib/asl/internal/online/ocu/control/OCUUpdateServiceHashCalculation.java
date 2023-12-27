/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.crypto.Digest
 *  org.bouncycastle.crypto.PBEParametersGenerator
 *  org.bouncycastle.crypto.digests.SHA512Digest
 *  org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator
 *  org.bouncycastle.crypto.params.KeyParameter
 *  org.bouncycastle.jce.provider.BouncyCastleProvider
 *  org.bouncycastle.util.encoders.Hex
 */
package de.vw.mib.asl.internal.online.ocu.control;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.ocu.util.OCUUpdateServiceByteBuffer;
import de.vw.mib.util.Util;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

public class OCUUpdateServiceHashCalculation {
    private static final boolean ENCODE_PASSWORD_WITH_UTF8;

    public static void init() {
        Security.addProvider((Provider)new BouncyCastleProvider());
    }

    public static String hashSecurityPin(String string, String string2) {
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append("OCUUpdateServiceHashCalculation").append(new StringBuffer().append(".hashSecurityPin(Userchallenge = ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append("SecurityPin = ").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(")").toString()).log();
        }
        object = Hex.decode((byte[])string.getBytes());
        byte[] byArray = OCUUpdateServiceHashCalculation.calcPBKDF2WithHmacSHA512BouncyCastleCustom(string2.toCharArray(), (byte[])object, -1601830656, 512);
        return Hex.toHexString((byte[])byArray);
    }

    public static String hashSecurityPinForTransmission(String string, String string2) {
        byte[] byArray;
        Object object;
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            object = ServiceManager.logger2.trace(16384);
            object.append("OCUUpdateServiceHashCalculation").append(new StringBuffer().append(".hashSecurityPinForTransmission(securityPinHash = ").append(Util.isNullOrEmpty(string) ? "NULL" : string).append("Challenge = ").append(Util.isNullOrEmpty(string2) ? "NULL" : string2).append(")").toString()).log();
        }
        object = Hex.decode((byte[])string.getBytes());
        byte[] byArray2 = Hex.decode((byte[])string2.getBytes());
        OCUUpdateServiceByteBuffer oCUUpdateServiceByteBuffer = new OCUUpdateServiceByteBuffer(((Object)object).length + byArray2.length);
        oCUUpdateServiceByteBuffer.put((byte[])object);
        oCUUpdateServiceByteBuffer.put(byArray2);
        try {
            byArray = MessageDigest.getInstance("SHA-512", "BC").digest(oCUUpdateServiceByteBuffer.array());
        }
        catch (NoSuchProviderException noSuchProviderException) {
            OCUUpdateServiceHashCalculation.init();
            byArray = MessageDigest.getInstance("SHA-512", "BC").digest(oCUUpdateServiceByteBuffer.array());
        }
        return Hex.toHexString((byte[])byArray);
    }

    static byte[] calcPBKDF2WithHmacSHA512BouncyCastleCustom(char[] cArray, byte[] byArray, int n, int n2) {
        SHA512Digest sHA512Digest = new SHA512Digest();
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator((Digest)sHA512Digest);
        pKCS5S2ParametersGenerator.init(PBEParametersGenerator.PKCS5PasswordToBytes((char[])cArray), byArray, n);
        KeyParameter keyParameter = (KeyParameter)pKCS5S2ParametersGenerator.generateDerivedParameters(n2);
        return keyParameter.getKey();
    }
}

