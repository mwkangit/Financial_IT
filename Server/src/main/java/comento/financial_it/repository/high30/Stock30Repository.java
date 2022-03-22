package comento.financial_it.repository.high30;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class Stock30Repository {

    private final EntityManager em;

    public List<Stock30Dto> market30Kosdaq(String market){

        List<Stock30Dto> kosdaq30 = em.createQuery("select distinct new comento.financial_it.repository.high30.Stock30Dto(A.code, B.code_name) " +
                        "from stock_finance A " +
                        "join fetch stock_kosdaq B on A.code=B.code " +
                        "where A.code in (select code from stock_info where stock_market= :market)", Stock30Dto.class)
                .setMaxResults(30)
                .setParameter("market", market)
                .getResultList();

        return kosdaq30;
    }

    public List<Stock30Dto> market30Kospi(String market){

        List<Stock30Dto> kospi30 = em.createQuery("select new comento.financial_it.repository.high30.CodesDto(A.code, B.code_name) " +
                        "from stock_finance A " +
                        "join fetch stock_kospi B on A.code=B.code " +
                        "where A.code in (select code from stock_info where stock_market= :market)", Stock30Dto.class)
                .setMaxResults(30)
                .setParameter("market", market)
                .getResultList();

        return kospi30;
    }
}
