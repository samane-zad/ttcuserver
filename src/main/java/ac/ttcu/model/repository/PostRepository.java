package ac.ttcu.model.repository;

import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.model.entity.table.Post;
import ac.ttcu.model.entity.table.UniMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p from Post p where p.postType=?1 and p.uniMajor=?2")
    public List<Post> findByTypeAndUniMajor(PostTypes postTypes, UniMajor uniMajor);

    @Query(value = "select p from Post p where p.postType=?1")
    public List<Post> findByType(PostTypes postTypes);

    @Query(value = "select p from Post p where p.uniMajor=?1")
    public List<Post> findByUniMajor(UniMajor uniMajor);

    @Query(value = "select p from Post p where p.username=?1")
    public List<Post> findByUsername(String username);
}
