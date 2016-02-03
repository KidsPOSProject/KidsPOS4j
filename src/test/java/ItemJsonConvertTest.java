import info.nukoneko.kidspos4j.model.JSONConvertor;
import info.nukoneko.kidspos4j.model.ModelItem;
import junit.framework.TestCase;

/**
 * Created by atsumi on 2016/02/03.
 */
public class ItemJsonConvertTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testConvert(){
        ModelItem item = new ModelItem();
        item.setId(0);
        item.setName("Tanaka");
        item.setBarcode("12345");
        item.setGenre("Store");
        item.setPrice(500);
        item.setShop(100);

        String json = JSONConvertor.toJSON(item);
        assertNotNull(json);

        ModelItem item2 = JSONConvertor.parse(json, ModelItem.class);
        assertNotNull(item2);

        assertEquals(item.getId(), item2.getId());
        assertEquals(item.getName(), item2.getName());
        assertEquals(item.getBarcode(), item2.getBarcode());
        assertEquals(item.getGenre(), item2.getGenre());
        assertEquals(item.getPrice(), item2.getPrice());
        assertEquals(item.getShop(), item2.getShop());

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
