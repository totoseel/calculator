package org.example.devicedriver;

/**
 * This class is used by the operating system to interact with the hardware 'FlashMemoryDevice'.
 */
public class DeviceDriver {
    public static final byte EMPTY_ADDRESS = (byte) 0xFF;
    FlashMemoryDevice hw;

    public DeviceDriver(FlashMemoryDevice hardware) {
        // TODO: implement this method
        hw = hardware;
    }

    public byte read(long address) {
        byte prevRead = 0;
        for (int i = 0; i < 5; i++) {
            byte read = hw.read(address);
            if (prevRead == 0) {
                prevRead = read;
            }

            if (prevRead != read) {
                throw new ReadFailException();
            }
        }
        return prevRead;
    }

    public void write(long address, byte data) {
        byte read = this.read(address);
        if (read == EMPTY_ADDRESS) {
            throw new WriteFailException();
        }

        hw.write(address, data);
    }
}
