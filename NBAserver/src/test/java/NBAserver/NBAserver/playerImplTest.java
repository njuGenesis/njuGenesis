package NBAserver.NBAserver;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import data.impl.PlayerDataImpl;
import data.po.PlayerDataPO;

public class playerImplTest {

	PlayerDataImpl p;
	public playerImplTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		p = new PlayerDataImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJudge() throws RemoteException{
		
			boolean res = p.judge();
			assertEquals(res,false);
		
	}

	@Test
	public void testGetInfo() throws RemoteException {
		PlayerDataPO res = p.getInfo("Aaron Brooks");
		assertEquals(res.getGP(),71);
	}

	@Test
	public void testGetAllInfo() throws RemoteException{
		PlayerDataPO[] res = p.getAllInfo();
		assertEquals(res.length,448);
		//fail("Not yet implemented");
	}

}
