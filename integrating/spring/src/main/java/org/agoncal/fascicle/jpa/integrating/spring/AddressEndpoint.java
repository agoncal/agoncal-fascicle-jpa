package org.agoncal.fascicle.jpa.integrating.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// tag::adocSnippet[]
@RestController
public class AddressEndpoint {

  private final AddressRepository addressRepository;

  // tag::adocSkip[]
  public AddressEndpoint(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  // end::adocSkip[]
  @PostMapping("/addresses")
  public Address createAddress(@RequestBody Address address) {
    return addressRepository.save(address);
  }

  @GetMapping(value = "/addresses/count")
  public Long countAll() {
    return addressRepository.count();
  }

  @GetMapping(value = "/addresses/country/{country}")
  public List<Address> getAddressesByCountry(@PathVariable String country) {
    return addressRepository.findAllByCountry(country);
  }

  @GetMapping(value = "/addresses/like/{zip}")
  public List<Address> getAddressesLikeZip(@PathVariable String zip) {
    return addressRepository.findAllLikeZip(zip);
  }
}
// end::adocSnippet[]
