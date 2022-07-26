package microServicesPractice.sFGuru.springBeerService.bootstrap;

import microServicesPractice.sFGuru.springBeerService.domain.Beer;
import microServicesPractice.sFGuru.springBeerService.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("L'Achouffe")
                    .beerStyle("Belge")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000001L)
                    .price(new BigDecimal("3.45"))
                    .build()
            );

            beerRepository.save(Beer.builder()
                    .beerName("Leffe")
                    .beerStyle("Belge")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000002L)
                    .price(new BigDecimal("2.45"))
                    .build()
            );
        }
    }
}
