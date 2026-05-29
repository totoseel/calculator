package org.example.devicedriver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.AtLeast;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.example.devicedriver.DeviceDriver.EMPTY_ADDRESS;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceDriverTest {

    @Mock
    private FlashMemoryDevice flashMemoryDevice;
    @InjectMocks
//    private DeviceDriver deviceDriver = new DeviceDriver(flashMemoryDevice);
    private DeviceDriver deviceDriver;

//    private FlashMemoryDevice flashMemoryDevice;
//    private DeviceDriver deviceDriver;

    private static final int ADDRESS = 0xFF + 99;
    private static final byte RETURN_ADDRESS = (byte) ADDRESS;

    private static final byte WRITE_DATA = (byte) 1;

    @BeforeEach
    void setUp() {
//        TestableFlashMemoryDevice testableFlashMemoryDevice = new TestableFlashMemoryDevice();
//        deviceDriver = new DeviceDriver(testableFlashMemoryDevice);
    }


    @Test
    void test_5회_read_성공() {
        doReturn(RETURN_ADDRESS).when(flashMemoryDevice).read(ADDRESS);
        assertThat(deviceDriver.read(ADDRESS)).isEqualTo(RETURN_ADDRESS);
    }

    @Test
    void test_5회_read_실패() {
        when(flashMemoryDevice.read(ADDRESS))
                .thenReturn(
                        (byte) (RETURN_ADDRESS + 1),
                        RETURN_ADDRESS,
                        RETURN_ADDRESS,
                        RETURN_ADDRESS,
                        RETURN_ADDRESS
                );

        assertThatThrownBy(() -> {
            deviceDriver.read(ADDRESS);
        }).isInstanceOf(ReadFailException.class);
    }

    @Test
    void test_write_이미_값이_있는지_확인() {
        doReturn(RETURN_ADDRESS).when(flashMemoryDevice).read(ADDRESS);
        deviceDriver.write(ADDRESS, WRITE_DATA);
        verify(flashMemoryDevice, times(5)).read(ADDRESS);
        verify(flashMemoryDevice, new AtLeast(1)).read(ADDRESS);
    }

    @Test
    void test_write_값_읽었을때_0xFF이면_write_하지_않는다() {
        doReturn(EMPTY_ADDRESS).when(flashMemoryDevice).read(ADDRESS);
        assertThatThrownBy(() -> deviceDriver.write(ADDRESS, WRITE_DATA)).isInstanceOf(WriteFailException.class);
        verify(flashMemoryDevice, times(0)).write(ADDRESS, WRITE_DATA);
    }

    @Test
    void test_write_값_읽었을때_0xFF아니면_write_한다() {
        doReturn(RETURN_ADDRESS).when(flashMemoryDevice).read(ADDRESS);
        deviceDriver.write(ADDRESS, WRITE_DATA);
        verify(flashMemoryDevice, times(1)).write(ADDRESS, WRITE_DATA);
    }
}
