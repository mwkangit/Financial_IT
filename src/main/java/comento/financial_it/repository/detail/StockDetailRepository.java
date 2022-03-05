package comento.financial_it.repository.detail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class StockDetailRepository {

    private final EntityManager em;

    public StockDetailDto codeDetail(String code){

        Optional<StockDetailDto> result = em.createQuery("select new comento.financial_it.repository.detail.StockDetailDto(A.code, (select code_name from stock_kosdaq C where C.code=A.code) as code_name, B.thema_name, A.sub_price, A.ROE, A.PER) " +
                        "from stock_finance A join fetch stock_info B on A.code=B.code " +
                        "where A.code= :code", StockDetailDto.class)
                .setMaxResults(1)
                .setParameter("code", code)
                .getResultList()
                .stream().findFirst();

        StockDetailDto stockDetailDto = result.orElse(null);

        return stockDetailDto;
    }

}
