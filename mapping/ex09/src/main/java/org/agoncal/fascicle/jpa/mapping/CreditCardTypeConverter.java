package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static org.agoncal.fascicle.jpa.mapping.CreditCardType.AMERICAN_EXPRESS;
import static org.agoncal.fascicle.jpa.mapping.CreditCardType.MASTER_CARD;
import static org.agoncal.fascicle.jpa.mapping.CreditCardType.VISA;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Converter
public class CreditCardTypeConverter implements AttributeConverter<CreditCardType, Character> {

  @Override
  public Character convertToDatabaseColumn(CreditCardType creditCardType) {
    switch (creditCardType) {
      case VISA:
        return 'V';
      case AMERICAN_EXPRESS:
        return 'A';
      case MASTER_CARD:
        return 'M';
      default:
        throw new IllegalArgumentException("Unknown" + creditCardType);
    }
  }

  @Override
  public CreditCardType convertToEntityAttribute(Character dbData) {
    switch (dbData) {
      case 'V':
        return VISA;
      case 'A':
        return AMERICAN_EXPRESS;
      case 'M':
        return MASTER_CARD;
      default:
        throw new IllegalArgumentException("Unknown" + dbData);
    }
  }
}
// end::adocSnippet[]
