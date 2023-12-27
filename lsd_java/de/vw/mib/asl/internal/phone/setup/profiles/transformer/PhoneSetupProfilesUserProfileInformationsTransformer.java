/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.profiles.transformer;

import de.vw.mib.asl.internal.phone.setup.profiles.transformer.PhoneSetupProfilesUserProfileInformationsCollector;
import generated.de.vw.mib.asl.internal.phone.setup.profiles.transformer.AbstractPhoneSetupProfilesUserProfileInformationsTransformer;

public class PhoneSetupProfilesUserProfileInformationsTransformer
extends AbstractPhoneSetupProfilesUserProfileInformationsTransformer {
    @Override
    public int getInt(int n, Object object) {
        PhoneSetupProfilesUserProfileInformationsCollector phoneSetupProfilesUserProfileInformationsCollector = (PhoneSetupProfilesUserProfileInformationsCollector)object;
        switch (n) {
            case 1: {
                return phoneSetupProfilesUserProfileInformationsCollector.downloaded;
            }
            case 2: {
                return phoneSetupProfilesUserProfileInformationsCollector.downloadMax;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        PhoneSetupProfilesUserProfileInformationsCollector phoneSetupProfilesUserProfileInformationsCollector = (PhoneSetupProfilesUserProfileInformationsCollector)object;
        switch (n) {
            case 0: {
                return phoneSetupProfilesUserProfileInformationsCollector.profileName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

