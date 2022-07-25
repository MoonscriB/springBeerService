package microServicesPractice.sFGuru.springBeerService.repositories;

import microServicesPractice.sFGuru.springBeerService.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {


}
