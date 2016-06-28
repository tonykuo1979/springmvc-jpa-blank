package org.tonykuo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tonykuo.persistence.entity.HanksMasterUser;
import org.tonykuo.persistence.entity.HanksMasterUserId;

@Repository
public interface HanksMasterUserRepository extends JpaRepository<HanksMasterUser, HanksMasterUserId> {

}