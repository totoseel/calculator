package org.example.restaurantbooking;

import org.example.devicedriver.FlashMemoryDevice;

public class TestableFlashMemoryDevice implements FlashMemoryDevice {
    @Override
    public byte read(long address) {
        return 0;
    }

    @Override
    public void write(long address, byte data) {

    }
}
