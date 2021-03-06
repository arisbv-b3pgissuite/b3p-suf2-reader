package nl.b3p.suf2.records;

import java.io.IOException;
import java.io.LineNumberReader;
import nl.b3p.suf2.SUF2Map;
import nl.b3p.suf2.SUF2ParseException;

/**
 *
 * @author Gertjan Al, B3Partners
 */
public class SUF2Record07 extends SUF2Record {

    // Naam
    public static final String NAAM = "naam";
    public static final String OBJECT_ID = "aanduiding veld voor object-identificatie";
    public static final String BEHEERDER_ID = "identificatie beheerder";
    // Adres
    public static final String STRAATNAAM = "straatnaam";
    public static final String HUISNUMMER = "huisnummer";
    public static final String HUISNUMMER_TOEV = "huisnummer toevoeging";
    public static final String POSTCODE = "postcode";
    // Woonplaats
    public static final String WOONPLAATS = "woonplaats";

    public SUF2Record07(LineNumberReader lineNumberReader, String line) throws SUF2ParseException, IOException {
        super(lineNumberReader, line);
    }

    public SUF2Record07(LineNumberReader lineNumberReader, String line, SUF2Map properties) throws SUF2ParseException, IOException {
        super(lineNumberReader, line, properties);
    }

    public void parseProperties() throws SUF2ParseException {

        if (line.charAt(3) == 'N') {
            properties.put(NAAM, line.part(4, 38));
            properties.put(OBJECT_ID, line.part(53));
            properties.put(BEHEERDER_ID, line.part(54, 61));

        } else if (line.charAt(3) == 'A') {
            properties.put(STRAATNAAM, line.part(4, 27));
            properties.put(HUISNUMMER, line.part(28, 32));
            properties.put(HUISNUMMER_TOEV, line.part(33, 37));
            properties.put(POSTCODE, line.part(54, 59));

        } else if (line.charAt(3) == 'W') {
            properties.put(WOONPLAATS, line.part(4, 27));

            if (line.isMultiLine()) {
                throw new SUF2ParseException(lineNumberReader, "Record07 didn't close correct");
            }

        } else {
            throw new SUF2ParseException(lineNumberReader, "Unknown subrecord character in " + this.getClass().getSimpleName() + "; " + line.charAt(1) + " not supported");
        }
    }
}
