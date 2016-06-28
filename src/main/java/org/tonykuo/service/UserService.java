package org.tonykuo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonykuo.persistence.entity.HanksMasterUser;
import org.tonykuo.persistence.entity.HanksMasterUserId;
import org.tonykuo.persistence.repo.HanksMasterUserRepository;

@Service
public class UserService {
    
    @Autowired
    private HanksMasterUserRepository hanksMasterUserRepository;
    
    public HanksMasterUser findOne(HanksMasterUserId hanksMasterUserId) {
        
        return hanksMasterUserRepository.findOne(hanksMasterUserId);
    }
    
    public List<HanksMasterUser> findAll() {
        
        return hanksMasterUserRepository.findAll();
    }
    
}
