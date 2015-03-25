# Otwarta Platforma Wyborcza
Otwarta Platforma Wyborcza (OPW) to oprogramowanie klasy enterprise, którego podstawowym zadaniem jest niezależna i obiektywna weryfikacja wyników wyborów prezydenckich 2015. Celem projektu OPW **nie jest kompletna implementacja wymagań sprecyzowanych przez PKW** w ramach projektu PW2 (Platforma Wyborcza 2).   

Wersja daily OPW jest dostępna tutaj http://91.250.114.134:8080/opw/

# Quickstart
1. MySQL skonfiguruj serwer do pracy w trybie UTF-8, jako engine InnoDB    
  * ```default-storage-engine = InnoDB```  
  * ```collation-server = utf8_general_ci```  
  * ```character-set-server = utf8```  
2. MySQL dodaj użytkownika opw zgodnie z definicją w glassfish-resources.xml
3. MySQL Workbench wykonaj import bazy (opcja Forward Engineer)
4. GlassFish wykonaj import glassfish-resources.xml 
5. mvn clean install i deploy na serwer


##Wymagane oprogramowania
* JDK7 (migracja na JDK8 ASAP)
* IDE z obsługą Maven 3
* Kontener JEE (preferuje i polecam GlassFish 4, profil nie ma znaczenia, aplikacja działa w Web jak i Full)
  * aplikacja wymaga JNDI resource dla bazy danych, GlassFish pozwala na import definicji z pliku XML setup/glassfish-resources.xml 
* MySQL 5 na localhost (w pliku .mwb jest ustawiona min. kompatybilność na 5.1) 
  * url, port, login i hasło są w pliku persistance.xml
* MySQL Workbench
  * baza danych jest definiowana jako diagram ERM
  * synchronizacja z serwerem poprzez opcje Forward Engineer (CTRL+G)


# Proces

**Przygotowanie wyborów**

1. Administrator definiuje / importuje komisje obwodowe (nr komisji oraz adresy komisji)
2. Administrator zakłada konta użytkownikom (wolentariuszom bądz/i mężom zaufania)
3. Administrator rozsyła hasła użytkowikom 
4. Administrator zbiera dane  użytkownika bądź/i importuje je  z XLS  (Imie, nazwisko, mail , telefon, nr komisji) 
5. System automatycznie wysyła link do aktywacji konta, login i hasło użytkownikom na podany adres e-mail
6. Administrator systemu ma możliwość edycji i weryfikacji kont użytkownków wraz ich danymi (duża fluktuacja użytkownków przed wyborami)
7. Administrator ma możliwość weryfikacji i podglądu, który użytkownik odebrał hasła i poprawnie przeszedł procedurę testowego logowania do systemu

**Przygotowanie wyborów ( funkcjonalnoć docelowa )**

1. Administrator definiuje/ importuje koordynatorów wyborów (imie, nazwisko, telefon, mail, przypisane komisje obwodowe najczęsciej gminne bądź dzielnicowe)
2. Administrator zakłada konta koordynatorom i łączy je z odpowiednimi komisjami i obwodami
4. Kordynator wybórów zakłada konta operatorom i przewodniczącemu komisji - Import XLS
5. Administrator generuje i rozsyła certyfikaty SSL/TSL koordynatorom
6. Koordynator zbiera dane od członków komisji ( imie, nazwisko, telefon, mail,  z jakiej partii , data powołania, Pesel, Walidacja Czy nie kandydują, nr Komisji , Adres komisji)
7. Koordynator wyborów definiuje/importuje składy komisji lokalnych i przypisuje do nr komisji
8. System generuje hasła dostepu dla operatorow i przewodniczących komisji, którzy proszą po zalogowaniu się o wydanie certyfikatu 


**Dzień wyborczy**


1.  ***System po zatwierdzeniu zgłoszenia przez Administratora udostepnia certyfikat do pobrania operatorom i przewodniczacym -  funkcja docelowa w przyszłośći***
2.  Użytkownik loguje się na stronie OPW i automatycznie zostaje przypisany do prawidłowej komisji
3.  Użytkownik wpisuje dane do/z protokołu (maski w paper browser)
4.  Użytkownik ma możliwość wydrukowania protokołu (nie wypełnionego także)
5.  Użytkownik ma możliwość zapisania/wczytania protokołu na/z zewnetrznego nośnika (CD, USB)
6.  Walidacja protokołu po stronie klienta (JavaScript/HTML5) dla błędów twardych i miekkich.
7.  Użytkownik wysyła dane (protokół)
8.  Użytkownik otrzymuje powiadomienie o odebraniu protokołu przez serwer np po przez mail
9.  ***Raport błedów/ostrzeżeń dla przewodniczacych komisji - funkcja docelowa w przyszlości.***



PERSPEKTYWA SERWERA  


1. ***Sprawdzenie certyfikatów i uwierzytelnień operatorów i przewodniczących - funcja docelowa w przyszłości***
2. Import Danych do serwera (protokołów)
3. Potwierdzenie otrzymania danych dla użytkownika (np wysłanie maila)
4. Panel administracyjny dla Administratora jakie dane z których komisji spłyneły wraz z warningami (selecty SQL + maski w paper browser ) 

**Dzień wyborczy wyniki**  

1.  Gość wchodzi na stronę główną www, dostaje aktualne wyniki (agregowane np. co 5 min)
2.  Podział po kodzie Teryt, Wojewódzwo, Gmina, Komisja 
3.  Frekwencja - wysyłanie liczby osób uprawnionych do głosowania i wydanych kart. 


# Specyfikacja

## Grupy użytkowników 
1. Administrator (admin)
2. Użytkownik (user)
3. Gość (guest)


## Grupy użytkowników (docelowa architektura) 
1. Administrator (admin) 
2. Koordynator Gminy  (odpowiedzialny za operatorów)
3. Operator Informatyczny  (najczęściej informatyk, może być odpowiedzialny za kilka komisji)
4. Przewodniczący Komisji 
5. Gość (guest) - obywatel który odwiedza strone aby sprawdzić wynik wyborów

## Risk & Issue Logs
1. Wysyłanie protokołów i zakonczenie liczenia głosów w 25000 komisjach zazwyczaj konczy się o tej samej porze +/- 15 min w przypadku prostych wyborów jakimi są Wybory Prezydenckie Potrzebna Analiza wydajnosciowa serwerów  w tym (SQL, Moc Obliczeniowa maszyny oraz sama przepustowość łącza i-net). Zastanowić się nad modułem synchronizacji otrzymywania wyników.
2.
2. Goście (wyborcy), którzy będą chcieli sprawdzić niezależne wyniki na stronie www - mogą spowodować zawieszenie się wydajnościowe serwera, gdy usługa będzie cieszyć sie bardzo dużą popularnoscią. Do rozważenia wprowadzenie modułu logowania na gości i ograniczenie ilości połaczeń dla danego gościa.   

## Appendix Features
1. Moduł generowania umów zleceń z operatorami oraz wypaty diet dla członków komisji wraz z wstępnie wypełnionym PIT-R
2. Import / eksport danych operatorów i członków komisji z/do pliku XLS 
3. Moduł "Przypominajek" dla operatorów i członków komisji wyborczych mowiący o poprawnym przeprowadzeniu procedury wyborów np. Wywieszeniu Obwieszczeń, Wydrukowaniu w należytej ilosci kopii protokołów, Zabezpieczeniu Brudnopisów, Zgraniu na zewnętrzny nośnik elektronicznej wersji protokołu, Przekazanie protokołu fizcznie po wydrukowaniu do KBW itp itd etc.   


## Software stack
1. Java EE 7 (GlassFish 4, JPA2, CDI, EJB, JSF 2.2 (PrimeFaces 5.1), JAX-RS, JAAS, JavaMail)
2. MySQL 5.5 (UTF8, InnoDB, MySQL Workbench)
3. REST
4. HTML5 
5. CSS3
6. Maven 3

## Roadmap
Plan implementacji

### Wersja 0.1 [wydana 2015.03.24] 
* Definicja bazy danych
* Funkcjonalność CRUD(Create Remove Update Delete) w przeglądarce dla obiektów
  * user (+ generowanie hasła )
  * kandydat
  * komisja okręgowa
  * komisja obwodowa

### Wersja 0.2
* Wysyłanie E-Maili z loginem i hasłem
* Użytkownik może zarejestrować numer telefonu dla funkcji protokół SMS
* [DONE] Konfiguracja Jenkins i działający CI
* Definicja i implementacja interfejsu REST 
* Import CSV/KLK dla następujących encji: user, komisja obwodowa, komisja okręgowa 
* Kolejne funkcje dla administratora 
  * reset hasła użytkownika 
  * aktywowanie i deaktywowanie konta użytkownika
* Definicja szablonu SMS
* Definicja szablonu EMail
* Definicja masek UI dla klienta HTML5/CSS3 

### Wersja 0.3
* Możliwość zamknięcia listy kandydatów. 
* Autoryzacja i autentyfikacja na bazie JAAS
* Podbieranie protokołów przesłanych na skrzynke pocztową
* Automatyczne parsowanie protokołów ze skrzynki pocztowej
  * import poprawnych protokołów
  * tagowanie błędnych protokołów  
Definicja architektury na nadchodzące wybory


### Wersja 0.5
* Aktualne wyniki wyborów są dostępne na stronie.


### Wersja 0.6
* Frontend bezpośrednio w HTML / JavaScript / REST

### Wersja 0.8
* Aktualizacja Dashboard

### Wersja 1.0
* Backend w Java EE
* Maski administratora w JSF
* Maski użytkowników w HTML + REST 
