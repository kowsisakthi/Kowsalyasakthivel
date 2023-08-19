package edu.disease.asn1;
import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExposureTest {

    @Test
    public void testExposureConstructorAndGetters() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 8, 19, 10, 0);
        String exposureType = "D";

        Exposure exposure = new Exposure(dateTime, exposureType);

        assertEquals(dateTime, exposure.getDateTime());
        assertEquals(exposureType, exposure.getExposureType());
    }

    @Test
    public void testSetExposureTypeValid() {
        Exposure exposure = new Exposure();
        exposure.setExposureType("D");

        assertEquals("D", exposure.getExposureType());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExposureTypeInvalid() {
        Exposure exposure = new Exposure();
        exposure.setExposureType("InvalidType");
    }

    @Test
    public void testEqualsAndHashCode() {
        UUID patientId = UUID.randomUUID();
        LocalDateTime dateTime = LocalDateTime.of(2023, 8, 19, 10, 0);
        String exposureType = "D";

        Exposure exposure1 = new Exposure(dateTime, exposureType);
        exposure1.patientId = patientId;

        Exposure exposure2 = new Exposure(dateTime, exposureType);
        exposure2.patientId = patientId;

        assertEquals(exposure1, exposure2);
        assertEquals(exposure1.hashCode(), exposure2.hashCode());
    }

    @Test
    public void testToString() {
        LocalDateTime dateTime = LocalDateTime.of(2023, 8, 19, 10, 0);
        String exposureType = "I";

        Exposure exposure = new Exposure(dateTime, exposureType);
        exposure.patientId = UUID.randomUUID();

        String expected = "patientId=" + exposure.patientId + " " + "dateTime=" + dateTime + " " + "exposureType=" + exposureType;
        assertEquals(expected, exposure.toString());
    }
}
