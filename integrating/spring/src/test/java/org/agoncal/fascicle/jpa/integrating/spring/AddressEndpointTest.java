package org.agoncal.fascicle.jpa.integrating.spring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the AddressResource REST controller.
 *
 * @see AddressEndpoint
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JPASpringApplication.class)
public class AddressEndpointTest {

  @Autowired
  private AddressRepository addressRepository;

  private MockMvc mockAddressEndpoint;

  // ======================================
  // =              Constants             =
  // ======================================

  private static final String ALL_ADDRESSES = "7";
  private Address address01;
  private Address address02;
  private Address address03;
  private Address address04;
  private Address address05;
  private Address address06;
  private Address address07;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    final AddressEndpoint addressEndpoint = new AddressEndpoint(addressRepository);
    this.mockAddressEndpoint = MockMvcBuilders.standaloneSetup(addressEndpoint).build();

    address01 = new Address("Procession St", "Paris", "75015", "FR");
    address02 = new Address("Ritherdon Rd", "London", "8QE", "UK");
    address03 = new Address("Inacio Alfama", "Lisbon", "A54", "PT");
    address04 = new Address("Jardins", "Sao Paulo", "345678", "BR");
    address05 = new Address("Coffey", "Perth", "654F543", "AU");
    address06 = new Address("Harbour Bridge", "Sydney", "JHG3", "AU");
    address07 = new Address("Playa de la Concha", "San Sebastian", "45678", "ES");

    // Persist the object
    addressRepository.save(address01);
    addressRepository.save(address02);
    addressRepository.save(address03);
    addressRepository.save(address04);
    addressRepository.save(address05);
    addressRepository.save(address06);
    addressRepository.save(address07);
  }

  @After
  public void removeData() {
    // Remove objects
    addressRepository.delete(address01);
    addressRepository.delete(address02);
    addressRepository.delete(address03);
    addressRepository.delete(address04);
    addressRepository.delete(address05);
    addressRepository.delete(address06);
    addressRepository.delete(address07);
  }

  @Test
  @Transactional
  public void createAddress() throws Exception {

    mockAddressEndpoint.perform(get("/addresses/count"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(content().string(ALL_ADDRESSES));

    // tag::createValidAddress[]
    Address address = new Address().street1("233 Spring Street").city("New York").state("NY").zipcode("12345").country("USA");

    mockAddressEndpoint.perform(post("/addresses")
      .contentType("application/json")
      .content(convertObjectToJsonBytes(address)))
      .andExpect(status().isOk());
    // end::createValidAddress[]

    mockAddressEndpoint.perform(get("/addresses/count"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(content().string("8"));
  }

  @Test
  @Transactional
  public void getAddressesByCountry() throws Exception {

    mockAddressEndpoint.perform(get("/addresses/count"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(content().string(ALL_ADDRESSES));

    mockAddressEndpoint.perform(get("/addresses/country/AU"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].country").isArray());

    mockAddressEndpoint.perform(get("/addresses/country/dummy"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].country").isEmpty());
  }

  @Test
  @Transactional
  public void getAddressesLikeZip() throws Exception {

    mockAddressEndpoint.perform(get("/addresses/count"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(content().string(ALL_ADDRESSES));

    mockAddressEndpoint.perform(get("/addresses/like/8QE"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].zipcode").value("8QE"));

    mockAddressEndpoint.perform(get("/addresses/like/Q"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].zipcode").value("8QE"));

    mockAddressEndpoint.perform(get("/addresses/like/E"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].zipcode").isArray());

    mockAddressEndpoint.perform(get("/addresses/like/dummy"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
      .andExpect(jsonPath("$.[*].zipcode").isEmpty());
  }

  public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

    JavaTimeModule module = new JavaTimeModule();
    mapper.registerModule(module);

    return mapper.writeValueAsBytes(object);
  }
}
