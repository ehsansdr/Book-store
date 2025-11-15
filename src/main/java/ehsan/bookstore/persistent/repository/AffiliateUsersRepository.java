package ehsan.bookstore.persistent.repository;

import ehsan.bookstore.persistent.domain.AffiliateUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliateUsersRepository extends JpaRepository<AffiliateUsers, Long> {

}