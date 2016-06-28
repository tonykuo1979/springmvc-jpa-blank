package org.tonykuo.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tonykuo.config.JpaConfig;
import org.tonykuo.persistence.entity.HanksMasterUser;
import org.tonykuo.persistence.entity.HanksMasterUserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class, BaseTestConfigService.class})
@ActiveProfiles("h2")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindOneUser() {
	    
	    // 2016061500001   0910360200
	    HanksMasterUserId hanksMasterUserId = new HanksMasterUserId();
	    hanksMasterUserId.setMasterUserId("2016061500001");
	    hanksMasterUserId.setMsisdn("0910360200");
	    
	    HanksMasterUser hanksMasterUser = userService.findOne(hanksMasterUserId);
		Assert.assertNotNull(hanksMasterUser);
		Assert.assertEquals("091231313", hanksMasterUser.getId().getMsisdn());
	}
	
	@Test
    public void testFindAll() {
        List<HanksMasterUser> userList = userService.findAll();
        Assert.assertFalse(userList.isEmpty());
    }
	
}
