package springTPJSP;




import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Categorie;
import fr.treeptik.service.CategorieService;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class CategorieServiceTest {
	
	
	private Categorie c;
	
	@Autowired
	private CategorieService categorieServiceTest;
	
	@Before
	public void setUp() {
		
		c = new Categorie();
		c.setName("Fêtes");
		c.setUrl("www.myblog/fetes.fr");
		
		try {
			c=categorieServiceTest.save(c);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@After
	public void delete(){

		try {
			categorieServiceTest.remove(c.getId());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void findOneTest(){
	
		Categorie categorie = new Categorie();
		
		try {
			categorie= categorieServiceTest.findOne(c.getId());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(categorie,c);
	}

}
