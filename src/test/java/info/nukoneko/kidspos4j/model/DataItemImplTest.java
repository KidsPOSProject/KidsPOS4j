package info.nukoneko.kidspos4j.model;

import info.nukoneko.kidspos4j.CommonTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

import static info.nukoneko.kidspos4j.CommonTest.getModel;
import static org.junit.Assert.*;

/**
 * Created by atsumi on 2016/10/06.
 */
public class DataItemImplTest {

    @Before
    public void setUp() throws Exception {
        ItemFactory.getInstance().truncate();
    }

    @After
    public void tearDown() throws Exception {
        ItemFactory.getInstance().truncate();
    }

    @Test
    public void createNewItem() throws Exception {

        DataItemImpl model = ItemFactory.getInstance();
        ModelItem item = getModel("12345");
        ModelItem item1 = model.createNewItem(item.getName(), item.getStoreId(), item.getGenreId(), item.getPrice());
        assertNotNull(item1);

        assertNotSame(item.getId(), item1.getId());
        assertEquals(item.getName(), item1.getName());
        assertNotSame(item.getBarcode(), item1.getBarcode());
        assertEquals(item.getGenreId(), item1.getGenreId());
        assertEquals(item.getPrice(), item1.getPrice());
    }

    @Test
    public void findAllRx() throws Exception {
        DataBase<ModelItem> model = ItemFactory.getInstance();
        ModelItem item = CommonTest.getModel("12345");
        model.insert(item);
        ModelItem item2 = CommonTest.getModel("67891");
        model.insert(item2);

        Observable<List<ModelItem>> observable = model.findAllRx();
        assertNotNull(observable);
        List<ModelItem> list = observable.toBlocking().single();
        assert list.size() == 2;
//        assert list.indexOf(item) > -1;
//        assert list.indexOf(item2) > -1;
    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void findFirst() throws Exception {

    }

    @Test
    public void findFromBarcode() throws Exception {

    }

    @Test
    public void insert() throws Exception {

    }

}