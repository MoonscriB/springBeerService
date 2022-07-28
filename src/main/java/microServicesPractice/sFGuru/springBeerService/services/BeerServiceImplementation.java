package microServicesPractice.sFGuru.springBeerService.services;

import lombok.RequiredArgsConstructor;
import microServicesPractice.sFGuru.springBeerService.domain.Beer;
import microServicesPractice.sFGuru.springBeerService.repositories.BeerRepository;
import microServicesPractice.sFGuru.springBeerService.web.controller.BeerNotFoundException;
import microServicesPractice.sFGuru.springBeerService.web.mappers.BeerMapper;
import microServicesPractice.sFGuru.springBeerService.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImplementation implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {

        return beerMapper.beerToBeerDto(beerRepository.findById(beerId)
                .orElseThrow(BeerNotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto(beerRepository.save(
                beerMapper.beerDtoToBeer(beerDto)
        ));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId)
                .orElseThrow(BeerNotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beer.getBeerStyle());
        beer.setPrice(beer.getPrice());
        beer.setUpc(beer.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
