package comento.financial_it;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@RequiredArgsConstructor
public class JpaMain {
    private final EntityManager em;
    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

//        EntityManager em = emf.createEntityManager();

//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
//
//            List<TestDto> resultList = em.createQuery("select new comento.finance_it.TestDto(A.code, A.thema_name) from stock_info A" +
//                            "join stock_price B on A.code = B.code" +
//                            "where B.code_name = :name", TestDto.class)
//                    .setParameter("name", "삼성전자")
//                    .getResultList();
//            for (TestDto testDto : resultList) {
//                System.out.println(testDto.getCode());
//                System.out.println(testDto.getThema_name());
//            }
//
//            em.clear();
//        tx.commit();
//        }catch (Exception e){
//            tx.rollback();
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }


    }
}
