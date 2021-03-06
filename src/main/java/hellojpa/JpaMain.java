package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);

//            Member findMember = em.find(Member.class,1L);
//            findMember.setName("helloJPA");

//            List<Member> resultList = em.createQuery("select m from Member  as m where m.name Like 'hello%'",Member.class )
//                    .setFirstResult(1)    페이징 기능 구현 및 쿼리 가능
//                    .setMaxResults(10)
            List<Member> resultList = em.createQuery("select m from Member  as m",Member.class )
                    .getResultList();

            for (Member member : resultList) {
                System.out.println("member.name =" + member.getName() );
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
         emf.close();
    }
}
