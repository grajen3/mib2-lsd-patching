/*
 * Decompiled with CFR 0.152.
 */
package de.eso.vcard.d;

import de.eso.a.d.b;
import de.eso.vcard.d.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;

public class a {
    public static final String a;
    protected static SimpleDateFormat b;
    protected File c;
    protected AdbEntry d;
    private Writer e = null;

    public a(AdbEntry adbEntry, File file) {
        this.d = adbEntry;
        this.c = file;
    }

    public void a() {
        if (this.d == null) {
            throw new c("adbEntry for VCardWriter is null. Skipping file.");
        }
        if (this.c == null) {
            de.eso.a.d.b.d("destFile for VCardWriter is null. Skipping file.");
            throw new IOException();
        }
        try {
            int n;
            this.e = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), "UTF-8"));
            this.b("BEGIN:VCARD");
            this.b();
            this.b("VERSION:3.0");
            this.b();
            this.a(this.d.personalData);
            if (this.d.addressData != null) {
                for (n = 0; n < this.d.addressData.length; ++n) {
                    this.a(this.d.addressData[n], n);
                }
            }
            if (this.d.emailData != null) {
                for (n = 0; n < this.d.emailData.length; ++n) {
                    this.a(this.d.emailData[n]);
                }
            }
            if (this.d.phoneData != null) {
                for (n = 0; n < this.d.phoneData.length; ++n) {
                    boolean bl = n == this.d.preferredNumberIdx;
                    this.a(this.d.phoneData[n], bl);
                }
            }
            if (this.d.urlData != null) {
                for (n = 0; n < this.d.urlData.length; ++n) {
                    this.a(this.d.urlData[n]);
                }
            }
            if (this.d.personalData != null && this.d.personalData.contactPicture != null && this.d.personalData.contactPicture.url != null) {
                File file = new File(this.d.personalData.contactPicture.url);
                this.a(file);
            }
            this.b("END:VCARD");
            this.b();
            this.e.flush();
            this.e.close();
            this.e = null;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw unsupportedEncodingException;
        }
        catch (FileNotFoundException fileNotFoundException) {
            throw fileNotFoundException;
        }
        catch (IOException iOException) {
            throw iOException;
        }
        finally {
            if (this.e != null) {
                try {
                    this.e.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    protected void a(String string) {
        if (string == null || string.length() < 1) {
            return;
        }
        this.b(new StringBuffer().append("URL:").append(string).toString());
        this.b();
    }

    protected void a(PhoneData phoneData, boolean bl) {
        if (phoneData == null || phoneData.number == null || phoneData.number.length() < 1) {
            return;
        }
        this.b("TEL");
        int n = phoneData.numberType;
        if (this.a(n, 256)) {
            this.b(";TYPE=bbs");
        }
        if (this.a(n, 2)) {
            this.b(";TYPE=work");
        }
        if (this.a(n, 1024)) {
            this.b(";TYPE=car");
        }
        if (this.a(n, 16)) {
            this.b(";TYPE=fax");
        }
        if (this.a(n, 2048)) {
            this.b(";TYPE=isdn");
        }
        if (this.a(n, 64)) {
            this.b(";TYPE=cell");
        }
        if (this.a(n, 512)) {
            this.b(";TYPE=modem");
        }
        if (this.a(n, 32)) {
            this.b(";TYPE=msg");
        }
        if (this.a(n, 128)) {
            this.b(";TYPE=pager");
        }
        if (this.a(n, 4)) {
            this.b(";TYPE=home");
        }
        if (this.a(n, 4096)) {
            this.b(";TYPE=video");
        }
        if (this.a(n, 8)) {
            this.b(";TYPE=voice");
        }
        if (bl) {
            this.b(";TYPE=pref");
        }
        this.b(":");
        this.c(phoneData.number);
        this.b();
    }

    protected boolean a(AddressData addressData) {
        if (addressData == null) {
            return true;
        }
        if (addressData.country != null && addressData.country.length() > 0) {
            return false;
        }
        if (addressData.geoPosition != null && addressData.geoPosition.length() > 0) {
            return false;
        }
        if (addressData.locality != null && addressData.locality.length() > 0) {
            return false;
        }
        if (addressData.navLocation != null && addressData.navLocation.length > 0) {
            return false;
        }
        if (!this.a(addressData.navPicture)) {
            return false;
        }
        if (addressData.postalCode != null && addressData.postalCode.length() > 0) {
            return false;
        }
        if (addressData.region != null && addressData.region.length() > 0) {
            return false;
        }
        return addressData.street == null || addressData.street.length() <= 0;
    }

    protected boolean a(ResourceLocator resourceLocator) {
        return resourceLocator == null || resourceLocator.url == null || resourceLocator.url.length() <= 0;
    }

    protected boolean a(int n, int n2) {
        return (n & n2) == n2;
    }

    protected void a(EmailData emailData) {
        if (emailData == null || emailData.emailAddr == null || emailData.emailAddr.length() < 1) {
            return;
        }
        this.b("EMAIL");
        if (emailData.emailType == 1) {
            this.b(";TYPE=internet");
        }
        this.b(":");
        this.c(emailData.emailAddr);
        this.b();
    }

    protected void a(AddressData addressData, int n) {
        if (addressData == null) {
            return;
        }
        if (this.a(addressData)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (addressData.addressType == 1) {
            stringBuffer.append("WORK");
            stringBuffer.append(n);
            stringBuffer.append('.');
        } else if (addressData.addressType == 2) {
            stringBuffer.append("HOME");
            stringBuffer.append(n);
            stringBuffer.append('.');
        }
        String string = stringBuffer.toString();
        this.b(string);
        this.b("ADR;CHARSET=UTF-8");
        if (addressData.addressType == 1) {
            this.b(";type=work");
        } else if (addressData.addressType == 2) {
            this.b(";type=home");
        }
        this.b(":");
        this.b(";");
        this.b(";");
        this.c(addressData.street);
        this.b(";");
        this.c(addressData.locality);
        this.b(";");
        this.c(addressData.region);
        this.b(";");
        this.c(addressData.postalCode);
        this.b(";");
        this.c(addressData.country);
        this.b();
        this.a(addressData, string);
        this.b(addressData, string);
    }

    protected void a(AddressData addressData, String string) {
        if (addressData == null || addressData.geoPosition == null || addressData.geoPosition.length() < 1) {
            return;
        }
        this.b(string);
        this.b(new StringBuffer().append("GEO:").append(addressData.geoPosition).toString());
        this.b();
    }

    protected void b(AddressData addressData, String string) {
        if (addressData == null || addressData.navLocation == null || addressData.navLocation.length < 1) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append("X-MIB_HIGH_NAV_LOCATION");
        if (addressData.addressType == 1) {
            stringBuffer.append(";type=work");
        } else if (addressData.addressType == 2) {
            stringBuffer.append(";type=home");
        }
        stringBuffer.append(";ENCODING=b:");
        this.b(stringBuffer.toString());
        de.eso.a.e.a a2 = new de.eso.a.e.a(this.e);
        a2.a(stringBuffer.length());
        a2.a(addressData.navLocation);
        a2.a();
        this.b();
    }

    protected void a(PersonalData personalData) {
        if (personalData == null) {
            return;
        }
        this.b("FN;CHARSET=UTF-8:");
        this.c(this.d.combinedName);
        this.b();
        this.b("N;CHARSET=UTF-8:");
        this.c(personalData.lastName);
        this.b(";");
        this.c(personalData.firstName);
        this.b(";;;");
        this.b();
        if (personalData.lastNameSound != null && personalData.lastNameSound.length() > 0 || personalData.firstNameSound != null && personalData.firstNameSound.length() > 0) {
            this.b("SOUND;X-IRMC-N;CHARSET=UTF-8:");
            this.c(personalData.lastNameSound);
            this.b(";");
            this.c(personalData.firstNameSound);
            this.b(";;;");
            this.b();
        }
        if (personalData.birthday != null) {
            long l = personalData.birthday.time;
            this.b("BDAY:");
            this.c(b.format(new Date(l)));
            this.b();
        }
        if (personalData.organization != null && personalData.organization.length() > 0) {
            this.b("ORG;CHARSET=UTF-8:");
            this.c(personalData.organization);
            this.b();
        }
        if (personalData.organizationSound != null && personalData.organizationSound.length() > 0) {
            this.b("SOUND;X-IRMC-ORG;CHARSET=UTF-8:");
            this.c(personalData.organizationSound);
            this.b();
        }
    }

    protected void a(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String string = "PHOTO;ENCODING=b;TYPE=JPEG:";
        this.b(string);
        de.eso.a.e.a a2 = new de.eso.a.e.a(this.e);
        a2.a(string.length());
        a2.a(file);
        a2.a();
        this.b();
    }

    protected void b(String string) {
        this.e.write(string);
    }

    protected void b() {
        this.e.write("\r\n");
    }

    protected void c(String string) {
        if (string == null) {
            return;
        }
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (c2 == ',' || c2 == ';' || c2 == '\\') {
                this.e.write(92);
            }
            this.e.write(c2);
        }
    }

    public static void a(String[] stringArray) {
        AdbEntry adbEntry = new AdbEntry();
        adbEntry.personalData = new PersonalData();
        adbEntry.personalData.birthday = new DateTime(386373600000L);
        File file = new File("test/testpic1.jpg");
        adbEntry.personalData.contactPicture = new ResourceLocator(file.getAbsolutePath());
        adbEntry.combinedName = "Hans M\u00fcller";
        adbEntry.personalData.firstName = "M\u00fcller";
        adbEntry.personalData.lastName = "Hans";
        adbEntry.personalData.organization = "e.solutions GmbH";
        adbEntry.addressData = new AddressData[3];
        adbEntry.addressData[0] = new AddressData();
        adbEntry.addressData[0].addressType = 1;
        adbEntry.addressData[0].country = "Germany";
        adbEntry.addressData[0].geoPosition = "48.782833,11.400271";
        adbEntry.addressData[0].locality = "Ingolstadt";
        adbEntry.addressData[0].navLocation = new byte[1024];
        adbEntry.addressData[0].postalCode = "85057";
        adbEntry.addressData[0].region = "Bavaria";
        adbEntry.addressData[0].street = "Pascalstr. 5";
        adbEntry.addressData[1] = new AddressData();
        adbEntry.addressData[1].addressType = 2;
        adbEntry.addressData[1].country = "Germany";
        adbEntry.addressData[1].geoPosition = "51.15178,10.41503";
        adbEntry.addressData[1].locality = "M\u00fcnchen";
        adbEntry.addressData[1].navLocation = new byte[512];
        adbEntry.addressData[1].postalCode = "85053";
        adbEntry.addressData[1].region = null;
        adbEntry.addressData[1].street = "Am \u00c4hrenfeld";
        adbEntry.addressData[2] = new AddressData();
        adbEntry.addressData[2].street = "";
        adbEntry.phoneData = new PhoneData[3];
        adbEntry.phoneData[0] = null;
        adbEntry.phoneData[1] = new PhoneData();
        adbEntry.phoneData[1].number = "+49 123456789 987654231";
        adbEntry.phoneData[1].numberType = 10;
        adbEntry.phoneData[2] = new PhoneData();
        adbEntry.preferredNumberIdx = 1;
        adbEntry.urlData = new String[]{"http://www.esolutions.de"};
        a a2 = new a(adbEntry, new File("testexport.vcf"));
        a2.a();
    }

    static {
        b = new SimpleDateFormat("yyyy-MM-dd");
    }
}

