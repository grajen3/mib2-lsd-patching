# MIB2 High lsd.jxe patching

This project aims to make it easier to patch java classes / functions that are included in the lsd.jxe compiled library in Harman MIB2 units


## Usage

1. copy your lsd.jxe file into the folder and give it a suitable name.
1. update the JXE variable at the top of process.sh to match.
1. perform initial extraction: `bash ./process.sh`
1. browse the decompiled source in lsd_java folder, find class you want to modify, eg `de/vw/mib/asl/internal/androidauto/target/DSIHandler.java`
1. `cd patched; ./add_original.sh de.vw.mib.asl.internal.androidauto.target.DSIHandler`
1. Add `de/vw/mib/asl/internal/androidauto/target/DSIHandler.java` to the `FILES` list in patched/build.sh
1. Modify the java file as needed
1. Run `./build.sh`, it'll compile the listed classes into `NavActiveIgnore.jar`
1. Copy `NavActiveIgnore.jar` and `install_NavActiveIgnore_jar.sh` to SD card and insert into MIB unit (SD1 slot)
1. From mib mmx telnet/ssh prompt run: `. /fs/sda0/install_NavActiveIgnore_jar.sh`
1. Restart unit (hold down power button 10 seconds)
1. Once rebooted, the compiled classes should be used instead of the original jxe copies
