import info.nukoneko.kidspos4j.util.config.BarcodeCreator;
import junit.framework.TestCase;

/**
 * Created by atsumi on 2016/02/04.
 */
public class BarcodeCreatorTest extends TestCase {
    public void testCreate(){
        String barcode = BarcodeCreator.create(BarcodeCreator.BARCODE_PREFIX.ITEM, 1, 3);
        assertNotNull(barcode);
        assertEquals(barcode, "1001010003");
    }
}
