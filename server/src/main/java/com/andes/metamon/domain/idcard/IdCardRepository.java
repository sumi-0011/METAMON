package com.andes.metamon.domain.idcard;

import com.andes.metamon.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdCardRepository extends JpaRepository<IdCard, Long> {
    @Query(value = "select i from IdCard i join fetch i.userId where i.userId.id = :userId")
    Optional<List<IdCard>> findAllByUserId(@Param("userId") Long userId);

//    @Query(value = "select count(i) from IdCard i where i.user_id = :userId and i.platform = :platform")
//    boolean existsIdCardByUserIdAndPlatform(@Param("userId") Long userId, @Param("platform") String platform);
    boolean existsIdCardByUserIdAndPlatform(User userId, Platform platform);
}
