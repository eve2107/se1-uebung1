package se1.ws26.tests.uebung1;

import org.hbrs.se1.ws26.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws26.exercises.uebung1.control.Translator;
import org.hbrs.se1.ws26.exercises.uebung1.control.TranslatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class GermanTranslatorTest {

    @BeforeEach
    public void testSetup(){
        Translator translator = TranslatorFactory.createGermanTranslator();
    }
    @Test
    public void testTodayDate() {
        Translator translator = TranslatorFactory.createGermanTranslator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String expectedDate = LocalDate.now().format(formatter);
        assertEquals(expectedDate,((GermanTranslator)translator).getDate());
    }
    @Test
    public void validTestMidRange() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("fünf", translator.translateNumber(5));
    }

    @Test
    public void validTestLowestValue() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("eins", translator.translateNumber(1));
    }

    @Test
    public void validTestValueBetween11and19() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("dreizehn", translator.translateNumber(13));
    }

    @Test
    public void validTestValueOnesPlusTens() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("vierundzwanzig", translator.translateNumber(24));
    }

    @Test
    public void validTestHighestValue() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("einhundert", translator.translateNumber(100));
    }

    @Test
    public void validTestValueWholeTens() {
        GermanTranslator translator = new GermanTranslator();
        assertEquals("fünfzig", translator.translateNumber(50));
    }

    @Test
    public void invalidTestValueZero() {
        GermanTranslator translator = new GermanTranslator();
        String expected = "Übersetzung der Zahl 0 nicht möglich (" + Translator.version + ")";
        assertNotEquals(expected, translator.translateNumber(0));
    }

    @Test
    public void invalidTestLowestOutOfBound() {
        GermanTranslator translator = new GermanTranslator();
        String expected = "Übersetzung der Zahl 101 nicht möglich (" + Translator.version + ")";
        assertNotEquals(expected, translator.translateNumber(101));
    }

    @Test
    public void invalidTestMaxValue() {
        GermanTranslator translator = new GermanTranslator();
        String expected = "Übersetzung der Zahl 2147483647 nicht möglich (" + Translator.version + ")";
        assertNotEquals(expected, translator.translateNumber(Integer.MAX_VALUE));
    }
    @Test
    public void invalidTestNegativeValue() {
        GermanTranslator translator = new GermanTranslator();
        String expected = "Übersetzung der Zahl -50 nicht möglich (" + Translator.version + ")";
        assertNotEquals(expected, translator.translateNumber(-50));
    }
}