package comento.financial_it.repository.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ThemeRepository {

    private final EntityManager em;

    public StockThemeDto themeName(String codeName){
        Optional<StockThemeDto> result = em.createQuery("select new comento.financial_it.repository.theme.StockThemeDto(A.code, A.thema_name) from stock_info A " +
                        "join fetch stock_price B on A.code=B.code " +
                        "where B.code_name = :name", StockThemeDto.class)
                .setParameter("name", codeName)
                .getResultList()
                .stream().findFirst();

        System.out.println("result = " + result);
        StockThemeDto stockThemeDto = result.orElse(null);
        if(stockThemeDto != null){
            System.out.println("stockSumDto = " + stockThemeDto);
        }else{
            System.out.println("stockSumDto null = " + stockThemeDto);
        }

        return stockThemeDto;

    }
}
