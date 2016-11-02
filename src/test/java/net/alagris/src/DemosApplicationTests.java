package net.alagris.src;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemosApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(DemosApplicationTests.class);

	// @Autowired
	// HashPassword hashPassword;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
//		for(int i=1;i<3000;i++){
//			jdbcTemplate.update("INSERT INTO test_table (v) VALUES ('"+(Math.random()*10000)+"')") ;
//		}
//		for(Map<String, Object> rows:l){
//			log.info(rows.toString());
//		}
	}

	// public void testHash() {
	// byte[] salt = hashPassword.getSalt();
	// byte[] hash = null;
	// try {
	// hash = hashPassword.generateStrongPasswordHash("hello", salt);
	// } catch (InvalidKeySpecException e) {
	// e.printStackTrace();
	// }
	// log.info(salt.length + " should be equal " +
	// hashPassword.getSaltLength());
	// log.info(hash.length + " should be equal " +
	// hashPassword.getHashLength());
	//
	// byte[] salt1 = hashPassword.getSalt();
	// byte[] hash1 = null;
	// try {
	// hash1 = hashPassword.generateStrongPasswordHash("hello", salt1);
	// } catch (InvalidKeySpecException e) {
	// e.printStackTrace();
	// }
	// log.info("true--> pass1==pass2");
	// log.info((salt1 == salt) + "--> salt1==salt2 ");
	// log.info((hash == hash1) + "--> hash1==hash2");
	//
	// }
}
