package microServicesPractice.sFGuru.springBeerService.web.mappers;

import microServicesPractice.sFGuru.springBeerService.domain.Beer;
import microServicesPractice.sFGuru.springBeerService.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}