package course.link.db.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query(value = "from Link u where u.shortUrl = :shortUrl")
    Optional<Link> findByShortURL(
            @Param(value = "shortUrl") String shortUrl);

    @Query(value = "from Link u where u.originalUrl = :originalUrl")
    Optional<Link> findByOriginalUrl(
            @Param(value = "originalUrl") String originalUrl);

    @Query(value = "from Link u order by  u.counter desc")
    List<Link> getListOfSortedUrls();
}

