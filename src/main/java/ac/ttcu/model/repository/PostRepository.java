package ac.ttcu.model.repository;

import ac.ttcu.common.enumerations.Majors;
import ac.ttcu.common.enumerations.PostTypes;
import ac.ttcu.common.enumerations.Universities;
import ac.ttcu.model.entity.table.Post;
import ac.ttcu.model.entity.table.UniMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select p from Post p where p.postType in ?1 and p.uniMajor.uni in ?2 and p.uniMajor.major in ?3")
    public List<Post> findByTypeAndUniMajor(List<PostTypes> postTypes, List<Universities> uni, List<Majors> major);


    @Query(value = "select p from Post p where p.username=?1")
    public List<Post> findByUsername(String username);

    @Modifying
    @Query(value = "update Post  p set p.postType=?1,p.title=?2,p.description=?3,p.contact=?4,p.uniMajor=?5 where p.id=?6")
    public void updatePost(PostTypes postType, String title, String desc, String contact, UniMajor uniMajor);


}
