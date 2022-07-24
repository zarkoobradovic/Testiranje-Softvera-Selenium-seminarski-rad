package testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RunWith(JUnitPlatform.class)
@SelectClasses({ RegistracijaKorisnikaProveraPrijave.class, IdenticniPodaci.class, TriProizvodaUkorpi2.class,
		PerformanseOtvaranja.class, Okompaniji.class, TestZaSearch.class, ListaZelja.class,
		ProveraDrustvenihMreza.class })
class AllTests {

}